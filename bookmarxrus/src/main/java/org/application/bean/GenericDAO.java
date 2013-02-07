package org.application.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class GenericDAO {

	   private static EntityManagerFactory emf = Persistence
	            .createEntityManagerFactory("pu");
	 
	    public EntityManager createEntityManager() {
	        return emf.createEntityManager();
	    }
	 
	    public static void closeEntityManager() {
	        emf.close();
	    }
}
