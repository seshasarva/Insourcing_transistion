package com.insourcing.exception;

public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
    
	public GenericException() {
		super();
	}
	
	public GenericException(String errorMessage) {
		super(errorMessage);
        this.errorMessage = errorMessage;
	}
    
	public String getErrorMessage() {
        return errorMessage;
    }
}
