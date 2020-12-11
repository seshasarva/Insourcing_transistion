package com.insourcing.model;

public class HRFormRequest {

	private String empNo;
	private String empName;
	private String emailId;
	private String password;
	private String country;
	public HRFormRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HRFormRequest(String empNo, String empName, String emailId, String password, String country) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.emailId = emailId;
		this.password = password;
		this.country = country;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "HRFormRequest [empNo=" + empNo + ", empName=" + empName + ", emailId=" + emailId + ", password="
				+ password + ", country=" + country + "]";
	}
}