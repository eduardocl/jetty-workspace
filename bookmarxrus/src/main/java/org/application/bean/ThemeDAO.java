package org.application.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Named
@Singleton
public class ThemeDAO implements Serializable {

	@Inject
	@DataRepository
	private EntityManager em;
	
	public void persist(Theme theme) {
		EntityTransaction tx = em.getTransaction();
	    tx.begin();
	    
	    em.persist(theme);
	    tx.commit();
	    //em.close();
	}
	
	public Theme getTheme() {
		EntityTransaction tx = em.getTransaction();
	    tx.begin();
	    Query query = em.createQuery("select d from Theme d");
	    Theme theme = null;
	    try {
	    	theme = (Theme) query.getSingleResult();
	    }catch(Throwable e) {
	    	
	    }
	    tx.commit();
	    return theme;
	}

	public void update(Theme theme) {
		EntityTransaction tx = em.getTransaction();
	    tx.begin();
	    em.merge(theme);
	    tx.commit();
	}
	

	
}
