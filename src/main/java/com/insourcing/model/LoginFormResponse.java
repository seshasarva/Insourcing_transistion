package com.insourcing.model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class LoginFormResponse {

	private String firstname;
	private String middlename;
	private String lastname;
	private String emailid;
	private String contactno;
	private String country;
	private String notice;
	private String currentTitle;
	private boolean regflag;
	private String refId;
	private boolean appflag;
	private String offerStatus;
	private byte[] joiningLetter;

	private String jwtToken;
	private Enum<?> authenticationCode;
	private int incorrectLoginAttempt;
	private boolean isCandidateLoggedIn;
	private LocalDateTime lastLoginDateTime;
	private Long loginTimeDifference;

	public LoginFormResponse() {
		super();
	}

	public LoginFormResponse(String firstname, String middlename, String lastname, String emailid, String contactno,
			String country, String notice, String currentTitle, boolean regflag, String refId, boolean appflag,
			String offerStatus, byte[] joiningLetter, String jwtToken, Enum<?> authenticationCode,
			int incorrectLoginAttempt, boolean isCandidateLoggedIn, LocalDateTime lastLoginDateTime,
			Long loginTimeDifference) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.emailid = emailid;
		this.contactno = contactno;
		this.country = country;
		this.notice = notice;
		this.currentTitle = currentTitle;
		this.regflag = regflag;
		this.refId = refId;
		this.appflag = appflag;
		this.offerStatus = offerStatus;
		this.joiningLetter = joiningLetter;
		this.jwtToken = jwtToken;
		this.authenticationCode = authenticationCode;
		this.incorrectLoginAttempt = incorrectLoginAttempt;
		this.isCandidateLoggedIn = isCandidateLoggedIn;
		this.lastLoginDateTime = lastLoginDateTime;
		this.loginTimeDifference = loginTimeDifference;
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

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getCurrentTitle() {
		return currentTitle;
	}

	public void setCurrentTitle(String currentTitle) {
		this.currentTitle = currentTitle;
	}

	public boolean isRegflag() {
		return regflag;
	}

	public void setRegflag(boolean regflag) {
		this.regflag = regflag;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public boolean isAppflag() {
		return appflag;
	}

	public void setAppflag(boolean appflag) {
		this.appflag = appflag;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public byte[] getJoiningLetter() {
		return joiningLetter;
	}

	public void setJoiningLetter(byte[] joiningLetter) {
		this.joiningLetter = joiningLetter;
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

	public int getIncorrectLoginAttempt() {
		return incorrectLoginAttempt;
	}

	public void setIncorrectLoginAttempt(int incorrectLoginAttempt) {
		this.incorrectLoginAttempt = incorrectLoginAttempt;
	}

	public boolean isCandidateLoggedIn() {
		return isCandidateLoggedIn;
	}

	public void setCandidateLoggedIn(boolean isCandidateLoggedIn) {
		this.isCandidateLoggedIn = isCandidateLoggedIn;
	}

	public LocalDateTime getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(LocalDateTime lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public Long getLoginTimeDifference() {
		return loginTimeDifference;
	}

	public void setLoginTimeDifference(Long loginTimeDifference) {
		this.loginTimeDifference = loginTimeDifference;
	}

	@Override
	public String toString() {
		return "LoginFormResponse [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", emailid=" + emailid + ", contactno=" + contactno + ", country=" + country + ", notice=" + notice
				+ ", currentTitle=" + currentTitle + ", regflag=" + regflag + ", refId=" + refId + ", appflag="
				+ appflag + ", offerStatus=" + offerStatus + ", joiningLetter=" + Arrays.toString(joiningLetter)
				+ ", jwtToken=" + jwtToken + ", authenticationCode=" + authenticationCode + ", incorrectLoginAttempt="
				+ incorrectLoginAttempt + ", isCandidateLoggedIn=" + isCandidateLoggedIn + ", lastLoginDateTime="
				+ lastLoginDateTime + ", loginTimeDifference=" + loginTimeDifference + "]";
	}
}