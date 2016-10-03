package com.test;

import javax.servlet.annotation.WebServlet;

import com.test.ui.CompanyUI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = CompanyUI.class)
public class MyServlet extends VaadinServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}