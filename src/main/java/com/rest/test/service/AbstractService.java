package com.rest.test.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.rest.test.dao.PersistenceUtil;
import com.rest.test.exception.ServerErrorException;

/***
 * Abstract Service.
 *
 */
public abstract class AbstractService {
	/** Entity manager instance. */
	@PersistenceContext(unitName = "RestTest")
	protected EntityManager entityManager;

	/**
	 * Constructor.
	 */
	public AbstractService() {
		entityManager = PersistenceUtil.getEntityManager();
	}

	protected void begin() {
		EntityTransaction tx = entityManager.getTransaction();
		if (!tx.isActive()) {
			tx.begin();
		}
	}
	
	/**
	 * Perform rollback if transaction is active.
	 */
	protected void rollback() {
		if (entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().rollback();
		}
	}
	
	protected void throwNotFound(String entity) {
		throw new ServerErrorException(entity + " not found !", "Entity does not exist in the database.");
	}
	
}
