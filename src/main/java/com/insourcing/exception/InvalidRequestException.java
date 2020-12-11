package com.insourcing.exception;

public class InvalidRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
    
	public InvalidRequestException() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public InvalidRequestException(String validationError) {
		// TODO Auto-generated constructor stub
		super(validationError);
        this.errorMessage = validationError;
	}
    
	public String getErrorMessage() {
        return errorMessage;
    }
	
}
