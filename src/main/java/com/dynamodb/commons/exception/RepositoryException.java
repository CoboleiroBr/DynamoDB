package com.dynamodb.commons.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import org.springframework.web.bind.annotation.ControllerAdvice;

public class RepositoryException extends RuntimeException{
	
	private static final long serialVersionUID = -770751536548302516L;
	
	private HttpStatus httpStatus;

	/*
	 * public RepositoryException(final HttpStatus httpStatus, final Throwable e) {
	 * 
	 * super(e); this.httpStatus = httpStatus; }
	 * 
	 * public RepositoryException(final String message) {
	 * 
	 * super(message); this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; }
	 */
	
	public RepositoryException(final HttpStatus httpStatus, final String message) {

		super(message);
		this.httpStatus = httpStatus;
	}
}