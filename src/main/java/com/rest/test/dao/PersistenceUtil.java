package com.rest.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utility class for db management.
 * 
 *
 */
public class PersistenceUtil {

	/** The entity manager instance. */
	private static EntityManagerFactory emf;

	/**
	 * Getter for the entity manager.
	 * 
	 * @return the entity manager
	 */
	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("PersistenceRest");
		}
		return emf.createEntityManager();
	}
}
