package com.test.persistance;

import javax.persistence.EntityManager;

import com.test.persistance.model.Address;

public class JPAMainClass {

	public JPAMainClass() {
		// TODO Auto-generated constructor stubJ
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setCity("Dhaka").setCountry("Bangladesh").setPostcode("1000")
				.setStreet("Poribagh");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();
		em.close();
		PersistenceManager.INSTANCE.close();
	}

}
