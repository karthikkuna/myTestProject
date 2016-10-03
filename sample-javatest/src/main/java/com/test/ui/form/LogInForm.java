package com.test.ui.form;

import com.test.logic.CompanyLogic;
import com.test.pojo.SessionDTO;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

public class LogInForm extends HorizontalLayout implements View {
	TextField username = new TextField();
	TextField password = new TextField();
	Label errorLabel = new Label();
	SessionDTO session;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String NAME = "LOGIN";

	public LogInForm(SessionDTO session) {
		this.session=session;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Panel signIn = new Panel("Sign In");
//		signIn.setStyleName(Reindeer.LAYOUT_BLUE);
		signIn.setWidth("500px");
		signIn.setHeight("200px");
		// signIn.setSizeFull();
		// signIn.setSpacing(true);
		// signIn.setMargin(true);
		VerticalLayout layout = new VerticalLayout();
		signIn.setContent(layout);
		layout.setImmediate(true);
		layout.setSizeFull();
		layout.setCaption("Log in");
		layout.setSpacing(true);
		layout.setMargin(true);
		Button signInButton = new Button("Sign In");
		signInButton.setImmediate(true);
		GridLayout box = new GridLayout(2, 2);
		box.setSpacing(true);
		box.setMargin(true);
		layout.addComponent(errorLabel);
		layout.addComponent(box);
		errorLabel.setImmediate(true);
		username.setImmediate(true);
		errorLabel.setStyleName(Reindeer.LABEL_H2);
		password.setImmediate(true);
		box.addComponent(new Label("User Name :"));
		box.addComponent(username);
		box.addComponent(new Label("Password :"));
		box.addComponent(password);
		addComponent(signIn);
		setComponentAlignment(signIn, Alignment.MIDDLE_CENTER);

		setSizeFull();
		setSpacing(true);
		setMargin(true);
		signInButton.setImmediate(true);
		layout.addComponent(new Label());
		layout.addComponent(signInButton);
		signInButton.addClickListener(new ClickListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Gonna Sign In");
				System.out.println("User name :" + username.getValue());
				System.out.println("password :" + password.getValue());
				CompanyLogic logic = new CompanyLogic();
				boolean validateVal = logic.validate(username.getValue(),
						password.getValue());
				if (!validateVal) {
					errorLabel
							.setCaption("Login Failed!!! User name and Password is not valid.");
				} else {
					errorLabel.setCaption("Login Successfull");
				}
				System.out.println("validateVal :" + validateVal);
			}
		});
	}

	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
