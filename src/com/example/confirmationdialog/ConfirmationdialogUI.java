package com.example.confirmationdialog;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseEvent;

@SuppressWarnings("serial")
@Theme("confirmationdialog")
public class ConfirmationdialogUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = ConfirmationdialogUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Click Me");
		
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				ConfirmationDialog confirmation = new ConfirmationDialog("Please confirm", "Are you sure you want to continue?");
				
				UI.getCurrent().addWindow(confirmation);
				
				confirmation.addCloseListener(new Window.CloseListener() {
					
					@Override
					public void windowClose(CloseEvent e) {
						
						ConfirmationDialog dialog = (ConfirmationDialog)e.getComponent();

						if(dialog.isConfirmed()){
							layout.addComponent(new Label("The user clicked Yes"));
						} else {
							layout.addComponent(new Label("The user clicked No"));
						}
						
					}
				});
				
			}
		});
		
		layout.addComponent(button);
	}

}