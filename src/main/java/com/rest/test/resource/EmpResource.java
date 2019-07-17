package com.rest.test.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.MediaType;

import com.rest.test.restprj.dao.model.EmpDb;
import com.rest.test.service.EmpService;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class EmpResource {
	private EmpService empService;

	public EmpResource() {
		empService = new EmpService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmpDb> getAllEmps(){
		return empService.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createEmployee(EmpDb emp) {
		if (emp.getLastname().isEmpty()) {
			throw new ServerErrorException(1);
		}
		empService.createEmp(emp);
	}
}
