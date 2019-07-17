package com.rest.test.restprj.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
@Table(schema = "\"public\"", name = "test")
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer pk1;

	private String col1;

	private String col2;

	public Test() {
	}

	public Integer getPk1() {
		return this.pk1;
	}

	public void setPk1(Integer pk1) {
		this.pk1 = pk1;
	}

	public String getCol1() {
		return this.col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return this.col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

}