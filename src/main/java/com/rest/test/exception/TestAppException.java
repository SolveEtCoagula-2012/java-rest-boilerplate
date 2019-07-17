package com.rest.test.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class TestAppException extends WebApplicationException{
	/** Serial version ID. */
	private static final long serialVersionUID = -797318333105119271L;

	public TestAppException(Status httpSstatus, String message, String internalError) {
		super(message, Response.status(httpSstatus).entity(new TestAppApiError(message, internalError)).build());
	}
}
