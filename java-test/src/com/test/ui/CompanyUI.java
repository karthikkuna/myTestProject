/**
 * 
 */
package com.test.ui;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.test.pojo.SessionDTO;
import com.test.ui.form.LogInForm;
import com.test.ui.form.LogInLabel;
import com.test.util.SessionUtil;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * @author Karthikeyan.Subraman
 *
 */

public class CompanyUI extends UI {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	Navigator navigator;

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		navigator = new Navigator(this, this);
		SessionDTO session=new SessionDTO();
		navigator.addView("", new LogInLabel(session));
		navigator.addView(LogInForm.NAME, new LogInForm(session));
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Creating Session Factory");
				SessionUtil.getInstance();
				System.out.println("Session Factory Created");
			}
		});
		// setContent(new Label("Adding label"));
	}
}
