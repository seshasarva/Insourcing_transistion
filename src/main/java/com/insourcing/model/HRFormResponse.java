package com.insourcing.model;

public class HRFormResponse {

	// private String empNo;
	// private String empName;
	private String emailId;
	// private String password;
	private String country;

	private String role;
	// private LocalDateTime lastUpdatedDateTime;

	private String jwtToken;
	private Enum<?> authenticationCode;
	private int inCorrectLoginAttempt;
	private boolean isHRLoggedIn;
	// private long loginTimeDifference;

	public HRFormResponse() {
		super();
	}

	public boolean isHRLoggedIn() {
		return isHRLoggedIn;
	}

	public void setHRLoggedIn(boolean isHRLoggedIn) {
		this.isHRLoggedIn = isHRLoggedIn;
	}


	public String getEmailId() {
		return emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	@Override
	public String toString() {
		return "HRFormResponse [emailId=" + emailId + ", country=" + country + ", role=" + role + ", jwtToken="
				+ jwtToken + ", authenticationCode=" + authenticationCode + ", inCorrectLoginAttempt="
				+ inCorrectLoginAttempt + ", isHRLoggedIn=" + isHRLoggedIn + "]";
	}

}