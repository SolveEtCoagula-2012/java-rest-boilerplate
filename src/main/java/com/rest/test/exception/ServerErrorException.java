package com.rest.test.exception;

import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerErrorException extends TestAppException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6616127921614312335L;
	private static final Logger LOG = LoggerFactory.getLogger(ServerErrorException.class);

	public ServerErrorException(String message, String internalError) {
		super(Status.INTERNAL_SERVER_ERROR, message + "\n " + internalError, internalError);
	}

	public ServerErrorException(String message, Exception exc) {
		super(Status.INTERNAL_SERVER_ERROR, message + "\n " + getExceptionMessage(exc), exc.getLocalizedMessage());
		LOG.error(message + " : " + getExceptionMessage(exc));
	}
	
	private static String getExceptionMessage(Exception exc) {
		return exc.getLocalizedMessage();
	}

}
