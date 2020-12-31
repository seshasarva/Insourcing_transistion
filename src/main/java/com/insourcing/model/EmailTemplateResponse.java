package com.insourcing.model;

public class EmailTemplateResponse {

	private String status;
	private String subject;
	private String message;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public EmailTemplateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public EmailTemplateResponse(String status, String subject, String message) {
		super();
		this.status = status;
		this.subject = subject;
		this.message = message;
	}
	@Override
	public String toString() {
		return "EmailTemplateResponse [status=" + status + ", subject=" + subject + ", message=" + message + "]";
	}

	
}
