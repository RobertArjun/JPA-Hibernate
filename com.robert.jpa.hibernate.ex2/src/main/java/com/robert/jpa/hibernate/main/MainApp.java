package com.robert.jpa.hibernate.main;

import java.time.LocalDate;

import javax.persistence.Persistence;

import com.robert.jpa.hibernate.entities.Product;
/**
 * 
 * @author robert
 * This class is used for id generation and id values
 *
 */
public class MainApp {

	public static void main(String[] args) {
		// Create entity Manager factory
		var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
		
		// create entity manager from factory
		var em = emf.createEntityManager();
		
		Product p = new Product();
		p.setName("King Fisher");
		p.setPrice(99.50);
		p.setExpirationDate(LocalDate.now());
		
		em.getTransaction().begin();
		em.persist(p);// adding entity in the context
		em.getTransaction().commit();
		em.close();

	}

}
