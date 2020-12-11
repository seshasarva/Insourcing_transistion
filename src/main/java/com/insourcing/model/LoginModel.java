package com.insourcing.model;

public class LoginModel {
	
	private String empNo;
	private String empName;
	private String emailId;
	public LoginModel(String empNo, String empName, String emailId) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.emailId = emailId;
	}
	public LoginModel() {
		super();
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "LoginModel [empNo=" + empNo + ", empName=" + empName + ", emailId=" + emailId + "]";
	}
	

}
