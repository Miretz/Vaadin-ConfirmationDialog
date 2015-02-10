package com.example.confirmationdialog;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class ConfirmationDialog extends Window {
	
	private static final String ACCEPT = "Yes";
	private static final String DECLINE = "No";

	private boolean confirmed;
		
	public ConfirmationDialog(String title, String message){
		
		super(title);
		
		center();
		
		VerticalLayout content = new VerticalLayout();
		content.setMargin(true);
		setContent(content);

		Label messageLabel = new Label(message, ContentMode.PREFORMATTED);
		content.addComponent(messageLabel);
		content.setComponentAlignment(messageLabel, Alignment.MIDDLE_CENTER);
		
		HorizontalLayout buttons = new HorizontalLayout();
		
		Button btnYes = new Button(ACCEPT, new Button.ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				confirmed = true;
				close();
			}
			
		});

		Button btnNo = new Button(DECLINE, new Button.ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				confirmed = false;
				close();
			}
			
		});
		
		buttons.addComponent(btnYes);
		buttons.addComponent(btnNo);
		content.addComponent(buttons);
		content.setComponentAlignment(buttons, Alignment.MIDDLE_CENTER);
				
	}

	public boolean isConfirmed() {
		return confirmed;
	}
	
	
	
}
