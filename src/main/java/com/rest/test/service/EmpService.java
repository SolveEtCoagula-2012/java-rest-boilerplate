package com.rest.test.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rest.test.restprj.dao.model.EmpDb;

public class EmpService extends AbstractService {
	private static final Logger LOG = LoggerFactory.getLogger(EmpService.class);
	
	public List<EmpDb> findAll() {
		TypedQuery<EmpDb> query = entityManager.createNamedQuery("EmpDb.findAll", EmpDb.class);
		return query.getResultList();
	}
	
	public void createEmp(EmpDb emp) {
		begin();
		entityManager.persist(emp);
		entityManager.getTransaction().commit();
		LOG.info("employee created successfully - last name: " + emp.getLastname() + " first name: " + emp.getFistname());
	}

}
