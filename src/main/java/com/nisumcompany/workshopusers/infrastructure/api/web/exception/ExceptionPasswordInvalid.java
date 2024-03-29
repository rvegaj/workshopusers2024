package com.nisumcompany.workshopusers.infrastructure.api.web.exception;

import lombok.Getter;

@Getter
public class ExceptionPasswordInvalid extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ExceptionPasswordInvalid(String message) {
		super(message);
		this.message = message;
	}

}
