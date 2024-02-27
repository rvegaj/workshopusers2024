package com.nisumcompany.workshopusers.infrastructure.web.exceptions;

import lombok.Getter;

@Getter
public class ExceptionRequestInvalid extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ExceptionRequestInvalid(String message) {
		super(message);
		this.message = message;
	}

}
