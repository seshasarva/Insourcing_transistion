package com.insourcing.model;

import java.util.Arrays;

public class LoginFormResponse {

	private String firstname;
	private String middlename;
	private String lastname;
	private String emailid;
	private String country;
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

	private String dealId;
	private String flowSeqOne;
	private String flowSeqTwo;
	private String flowSeqThree;
	private String flowSeqFour;
	private String flowSeqFive;
	private String flowSeqSix;
	private String flowSeqSeven;
	private String flowSeqEight;
	private String flowSeqNine;
	private String flowSeqTen;

	public LoginFormResponse() {
		super();
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getFlowSeqOne() {
		return flowSeqOne;
	}

	public void setFlowSeqOne(String flowSeqOne) {
		this.flowSeqOne = flowSeqOne;
	}

	public String getFlowSeqTwo() {
		return flowSeqTwo;
	}

	public void setFlowSeqTwo(String flowSeqTwo) {
		this.flowSeqTwo = flowSeqTwo;
	}

	public String getFlowSeqThree() {
		return flowSeqThree;
	}

	public void setFlowSeqThree(String flowSeqThree) {
		this.flowSeqThree = flowSeqThree;
	}

	public String getFlowSeqFour() {
		return flowSeqFour;
	}

	public void setFlowSeqFour(String flowSeqFour) {
		this.flowSeqFour = flowSeqFour;
	}

	public String getFlowSeqFive() {
		return flowSeqFive;
	}

	public void setFlowSeqFive(String flowSeqFive) {
		this.flowSeqFive = flowSeqFive;
	}

	public String getFlowSeqSix() {
		return flowSeqSix;
	}

	public void setFlowSeqSix(String flowSeqSix) {
		this.flowSeqSix = flowSeqSix;
	}

	public String getFlowSeqSeven() {
		return flowSeqSeven;
	}

	public void setFlowSeqSeven(String flowSeqSeven) {
		this.flowSeqSeven = flowSeqSeven;
	}

	public String getFlowSeqEight() {
		return flowSeqEight;
	}

	public void setFlowSeqEight(String flowSeqEight) {
		this.flowSeqEight = flowSeqEight;
	}

	public String getFlowSeqNine() {
		return flowSeqNine;
	}

	public void setFlowSeqNine(String flowSeqNine) {
		this.flowSeqNine = flowSeqNine;
	}

	public String getFlowSeqTen() {
		return flowSeqTen;
	}

	public void setFlowSeqTen(String flowSeqTen) {
		this.flowSeqTen = flowSeqTen;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	@Override
	public String toString() {
		return "LoginFormResponse [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", emailid=" + emailid + ", country=" + country + ", currentTitle=" + currentTitle + ", regflag="
				+ regflag + ", refId=" + refId + ", appflag=" + appflag + ", offerStatus=" + offerStatus
				+ ", joiningLetter=" + Arrays.toString(joiningLetter) + ", jwtToken=" + jwtToken
				+ ", authenticationCode=" + authenticationCode + ", incorrectLoginAttempt=" + incorrectLoginAttempt
				+ ", isCandidateLoggedIn=" + isCandidateLoggedIn + ", dealId=" + dealId + ", flowSeqOne=" + flowSeqOne
				+ ", flowSeqTwo=" + flowSeqTwo + ", flowSeqThree=" + flowSeqThree + ", flowSeqFour=" + flowSeqFour
				+ ", flowSeqFive=" + flowSeqFive + ", flowSeqSix=" + flowSeqSix + ", flowSeqSeven=" + flowSeqSeven
				+ ", flowSeqEight=" + flowSeqEight + ", flowSeqNine=" + flowSeqNine + ", flowSeqTen=" + flowSeqTen
				+ "]";
	}

}