package com.insourcing.exception;

public class PortalException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message;

	public PortalException(String message) {
		this.message = message;
	}

	public String getException() {
		return message;
	}

}
