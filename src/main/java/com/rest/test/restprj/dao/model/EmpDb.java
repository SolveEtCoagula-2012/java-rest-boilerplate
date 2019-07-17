package com.rest.test.restprj.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the emp_db database table.
 * 
 */
@Entity
@Table(name="emp_db")
@NamedQuery(name="EmpDb.findAll", query="SELECT e FROM EmpDb e")
public class EmpDb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String dept;

	private String fistname;

	private String lastname;

	public EmpDb() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getFistname() {
		return this.fistname;
	}

	public void setFistname(String fistname) {
		this.fistname = fistname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}