package com.ecl.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class ContactDAO extends GenericDAO {

	public void persist(Contact contact) {
	    EntityManager em = createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    tx.begin();
	
	    em.persist(contact);
	
	    tx.commit();
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> findAll() {
	    EntityManager em = createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    tx.begin();
	
	    Query allDogsQuery = em.createQuery("select d from Contact d");
	
	    List<Contact> allDogs = allDogsQuery.getResultList();
	
	    tx.commit();
	    em.close();
	
	    return allDogs;
	}
	
}
