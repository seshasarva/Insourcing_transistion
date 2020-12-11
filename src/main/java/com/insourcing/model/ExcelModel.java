package com.insourcing.model;

public class ExcelModel {
	
	private String firstname;
	private String middlename;
	private String lastname;
	private String emailid;
	private String createPassword;
	
	public ExcelModel() {
		super();
	}
	public ExcelModel(String firstname, String middlename, String lastname, String emailid,
			String createPassword) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.emailid = emailid;
		this.createPassword = createPassword;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getCreatePassword() {
		return createPassword;
	}
	public void setCreatePassword(String createPassword) {
		this.createPassword = createPassword;
	}
	

}
