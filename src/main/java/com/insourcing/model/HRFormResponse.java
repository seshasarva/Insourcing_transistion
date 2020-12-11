package com.insourcing.model;

import java.time.LocalDateTime;

public class HRFormResponse {

	private String empNo;
	private String empName;
	private String emailId;
	private String password;
	private String country;

	private String role;
	private LocalDateTime lastUpdatedDateTime;
	
	private String jwtToken;
	private Enum<?> authenticationCode;
	private int inCorrectLoginAttempt;
	private long loginTimeDifference;
	
	public HRFormResponse() {
		super();
	}

	public HRFormResponse(String empNo, String empName, String emailId, String password, String country, String role,
			LocalDateTime lastUpdatedDateTime, String jwtToken, Enum<?> authenticationCode, int inCorrectLoginAttempt,
			long loginTimeDifference) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.emailId = emailId;
		this.password = password;
		this.country = country;
		this.role = role;
		this.lastUpdatedDateTime = lastUpdatedDateTime;
		this.jwtToken = jwtToken;
		this.authenticationCode = authenticationCode;
		this.inCorrectLoginAttempt = inCorrectLoginAttempt;
		this.loginTimeDifference = loginTimeDifference;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}

	public void setLastUpdatedDateTime(LocalDateTime lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public Enum<?> getAuthenticationCode() {
		return authenticationCode;
	}

	public void setAuthenticationCode(Enum<?> authenticationCode) {
		this.authenticationCode = authenticationCode;
	}

	public int getInCorrectLoginAttempt() {
		return inCorrectLoginAttempt;
	}

	public void setInCorrectLoginAttempt(int inCorrectLoginAttempt) {
		this.inCorrectLoginAttempt = inCorrectLoginAttempt;
	}

	public long getLoginTimeDifference() {
		return loginTimeDifference;
	}

	public void setLoginTimeDifference(long loginTimeDifference) {
		this.loginTimeDifference = loginTimeDifference;
	}

	@Override
	public String toString() {
		return "HRFormResponse [empNo=" + empNo + ", empName=" + empName + ", emailId=" + emailId + ", password="
				+ password + ", country=" + country + ", role=" + role + ", lastUpdatedDateTime=" + lastUpdatedDateTime
				+ ", jwtToken=" + jwtToken + ", authenticationCode=" + authenticationCode + ", inCorrectLoginAttempt="
				+ inCorrectLoginAttempt + ", loginTimeDifference=" + loginTimeDifference + "]";
	}

}