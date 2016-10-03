package com.test;

import java.util.Iterator;

import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.test.models.Product;
import com.test.models.Users;

public class HibernateMainClass {
	public static void main(String[] a) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Product p = new Product();

		p.setProName("Android");
		p.setPrice(250030);

		Transaction tx = session.beginTransaction();
		session.save(p);
		Users user=new Users();
		user.setUserName("test");
		user.setPassword("test");
		user.setRolename("admin");;
//		session.createSQLQuery("insert into Product (proName,price)  a,b from sess");
		Query crt=session.createSQLQuery("insert into PRODUCTS (pname, price) values ('df', 354)");
//		crt.setString(1, "Anr");
//		crt.setString(2, "675");
		crt.executeUpdate();
		System.out.println("Object saved successfully.....!!");
//		IdentifierLoadAccess<Product> loader = session.byId(Product.class);
//		System.out.println("Retrive - " + loader.getReference(3));
		tx.commit();
		session.close();
		factory.close();
	}
}
