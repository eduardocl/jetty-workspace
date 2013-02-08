package org.application.bean;

import java.io.Serializable;
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
public class ContactDAO extends GenericDAO implements Serializable{

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
	
	public Contact load(Long id) {
		System.out.println("------------------------>" + id);
	    
	    Query query = em.createQuery("select d from Contact d where d.id =:id");
	    query.setParameter("id", id);
	    query.setMaxResults(1);
	    Contact r = (Contact) query.getResultList().get(0);
	    System.out.println("------> " + r);
	    return r;
	}
	
	public void update(Contact contact) {
		em.merge(contact);
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

	public void delete(Long id) {
		EntityTransaction tx = em.getTransaction();
	    tx.begin();
		Query query = em.createQuery("delete Contact c where c.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		tx.commit();
	}
	
	
}
