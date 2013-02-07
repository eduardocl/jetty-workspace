package org.application.bean;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Named
@Singleton
public class ContactDAO extends GenericDAO {

	@Inject
	@DataRepository
	private EntityManager em; // = createEntityManager();
	
	public void persist(Contact contact) {
		EntityTransaction tx = em.getTransaction();
	    tx.begin();
	
	    em.persist(contact);
	
	    tx.commit();
	    //em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> findAll() {
	    EntityTransaction tx = em.getTransaction();
	    tx.begin();
	    Query allDogsQuery = em.createQuery("select d from Contact d");
	    List<Contact> allDogs = allDogsQuery.getResultList();
	    tx.commit();
	    //em.close();
	    return allDogs;
//		return new ArrayList<Contact>();
	}
	
	
}
