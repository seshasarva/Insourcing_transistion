package com.insourcing.model;

public class LoginFormRequest {
	
	String emailID;
	String password;
	
	public LoginFormRequest() {
		super();
	}
	public LoginFormRequest(String emailID, String password) {
		super();
		this.emailID = emailID;
		this.password = password;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}