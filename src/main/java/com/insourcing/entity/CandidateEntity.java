package com.insourcing.entity;

import java.time.LocalDateTime;
import java.util.Arrays;

import java.util.Date;

import javax.persistence.Entity;

//@Entity
public class CandidateEntity {

	private String firstname;
	private String middlename;
	private String lastname;
	private String emailid;
	private String contactno;
	private String city;
	private String country;
	private String notice;
	private String password;
	private int id;
	private String username;
	private String skills;
	private String currentTitle;
	private Date dob;
	private String currentLocation;
	private boolean regflag;
	private String refId;
	private byte[] offerFile;
	private boolean appflag;
	private Date offerGenDate;
	private Date regCompletedDate;
	private Date retDate;
	private String retBonus;
	private double retBonusQuant;
	private String workState;
	private Date offerDate;
	private String role;
	private String reportingTo;
	private String reportAddress;
	private Date joinDate;
	private String exemptStatus;
	private Date offerRelDate;
	private String offerStatus;
	private Date offerAcceptDate;
	private double base;
	private double bonus;
	private double severance;
	private byte[] joiningLetter;
	private Date joiningLetterDate;
	private boolean joinerStatus;
	private String key;
	private Date date;
	private boolean isCandidateLoggedIn;
	private LocalDateTime lastLoginDateTime;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isJoinerStatus() {
		return joinerStatus;
	}

	public void setJoinerStatus(boolean joinerStatus) {
		this.joinerStatus = joinerStatus;
	}

	public byte[] getJoiningLetter() {
		return joiningLetter;
	}

	public void setJoiningLetter(byte[] joiningLetter) {
		this.joiningLetter = joiningLetter;
	}

	public Date getJoiningLetterDate() {
		return joiningLetterDate;
	}

	public void setJoiningLetterDate(Date joiningLetterDate) {
		this.joiningLetterDate = joiningLetterDate;
	}

	public CandidateEntity() {
		super();
	}

	public Date getRetDate() {
		return retDate;
	}

	public void setRetDate(Date retDate) {
		this.retDate = retDate;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public Date getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	public String getReportAddress() {
		return reportAddress;
	}

	public void setReportAddress(String reportAddress) {
		this.reportAddress = reportAddress;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getExemptStatus() {
		return exemptStatus;
	}

	public void setExemptStatus(String exemptStatus) {
		this.exemptStatus = exemptStatus;
	}

	public Date getOfferRelDate() {
		return offerRelDate;
	}

	public void setOfferRelDate(Date offerRelDate) {
		this.offerRelDate = offerRelDate;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public Date getOfferAcceptDate() {
		return offerAcceptDate;
	}

	public void setOfferAcceptDate(Date offerAcceptDate) {
		this.offerAcceptDate = offerAcceptDate;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getSeverance() {
		return severance;
	}

	public void setSeverance(double severance) {
		this.severance = severance;
	}

	public String getRetBonus() {
		return retBonus;
	}

	public void setRetBonus(String retBonus) {
		this.retBonus = retBonus;
	}

	public double getRetBonusQuant() {
		return retBonusQuant;
	}

	public void setRetBonusQuant(double retBonusQuant) {
		this.retBonusQuant = retBonusQuant;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPrivacyNotice() {
		return notice;
	}

	public void setPrivacyNotice(String privacyNotice) {
		this.notice = privacyNotice;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getCurrentTitle() {
		return currentTitle;
	}

	public void setCurrentTitle(String currentTitle) {
		this.currentTitle = currentTitle;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
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

	public byte[] getOfferFile() {
		return offerFile;
	}

	public void setOfferFile(byte[] offerFile) {
		this.offerFile = offerFile;
	}

	public boolean isAppflag() {
		return appflag;
	}

	public void setAppflag(boolean appflag) {
		this.appflag = appflag;
	}

	public Date getOfferGenDate() {
		return offerGenDate;
	}

	public void setOfferGenDate(Date offerGenDate) {
		this.offerGenDate = offerGenDate;
	}

	public Date getRegCompletedDate() {
		return regCompletedDate;
	}

	public void setRegCompletedDate(Date regCompletedDate) {
		this.regCompletedDate = regCompletedDate;
	}

	@Override
	public String toString() {
		return "CandidateEntity [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", emailid=" + emailid + ", contactno=" + contactno + ", city=" + city + ", country=" + country
				+ ", notice=" + notice + ", password=" + password + ", id=" + id + ", username=" + username
				+ ", skills=" + skills + ", currentTitle=" + currentTitle + ", dob=" + dob + ", currentLocation="
				+ currentLocation + ", regflag=" + regflag + ", refId=" + refId + ", offerFile="
				+ Arrays.toString(offerFile) + ", appflag=" + appflag + ", offerGenDate=" + offerGenDate
				+ ", regCompletedDate=" + regCompletedDate + ", retDate=" + retDate + ", retBonus=" + retBonus
				+ ", retBonusQuant=" + retBonusQuant + ", workState=" + workState + ", offerDate=" + offerDate
				+ ", role=" + role + ", reportingTo=" + reportingTo + ", reportAddress=" + reportAddress + ", joinDate="
				+ joinDate + ", exemptStatus=" + exemptStatus + ", offerRelDate=" + offerRelDate + ", offerStatus="
				+ offerStatus + ", offerAcceptDate=" + offerAcceptDate + ", base=" + base + ", bonus=" + bonus
				+ ", severance=" + severance + ", joiningLetter=" + Arrays.toString(joiningLetter)
				+ ", joiningLetterDate=" + joiningLetterDate + ", joinerStatus=" + joinerStatus + ", key=" + key
				+ ", date=" + date + ", isCandidateLoggedIn=" + isCandidateLoggedIn + ", lastLoginDateTime="
				+ lastLoginDateTime + "]";
	}
}