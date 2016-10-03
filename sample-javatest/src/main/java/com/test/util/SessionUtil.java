package com.test.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	private static SessionUtil util;
	SessionFactory sessionFactory;

	private SessionUtil() {
		// TODO Auto-generated constructor stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}

	public static SessionUtil getInstance() {
		if (util == null) {
			util = new SessionUtil();
		}
		return util;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		sessionFactory.close();
	}
}
