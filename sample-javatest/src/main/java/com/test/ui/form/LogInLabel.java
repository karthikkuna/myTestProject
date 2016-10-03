package com.test.ui.form;

import com.test.pojo.SessionDTO;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LogInLabel extends HorizontalLayout implements View {
	TextField username = new TextField();
	TextField password = new TextField();
	Label errorLabel = new Label();
	SessionDTO session;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogInLabel(SessionDTO session) {
		this.session = session;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Panel signIn = new Panel("Sign In");
		// signIn.setStyleName(Reindeer.LAYOUT_BLUE);
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
		Button adminLogin = new Button("Admin LogIn");
		adminLogin.setImmediate(true);
		Button userLogin = new Button("User LogIn");
		userLogin.setImmediate(true);
		addComponent(signIn);
		setComponentAlignment(signIn, Alignment.MIDDLE_CENTER);

		setSizeFull();
		setSpacing(true);
		setMargin(true);
		layout.addComponent(adminLogin);
		layout.addComponent(new Label());
		layout.addComponent(userLogin);
		userLogin.addClickListener(lsitener);
		adminLogin.addClickListener(lsitener);
	}

	ClickListener lsitener = new ClickListener() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			System.out.println("Gonna Sign In Page");
			String buttonName = event.getButton().getCaption();
			session.setLoginId(buttonName);
			getUI().getNavigator().navigateTo(LogInForm.NAME);
		}
	};

	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}

}
