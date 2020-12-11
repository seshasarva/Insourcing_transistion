package com.insourcing.entity;

import java.time.LocalDateTime;
import java.util.Arrays;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidate_details")
public class CandidateEntityMap {

	@Column(name = "firstname", nullable = false)
	private String firstname;
	@Column(name = "middlename")
	private String middlename;
	@Column(name = "lastname", nullable = false)
	private String lastname;
	@Id
	@Column(name = "emailid")
	private String emailid;
	@Column(name = "contact_no")
	private String contactno;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;
	@Column(name = "privacy_notice")
	private String privacyNotice;
	@Column(name = "password")
	private String password;
	@Column(name = "first_time_login")
	private boolean isFirstTimeLogin;
	@Column(name = "is_candidate_logged_in")
	private boolean isCandidateLoggedIn;
	@Column(name = "incorrect_login_attempt")
	private int incorrectLoginAttempt;
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "skills")
	private String skills;
	@Column(name = "current_title")
	private String currentTitle;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "current_location")
	private String currentLocation;
	@Column(name = "regflag")
	private boolean regflag;
	@Column(name = "ref_id")
	private String refId;
	@Column(name = "offer_file")
	private byte[] offerFile;
	@Column(name = "appflag")
	private boolean appflag;
	@Column(name = "offer_generated_date")
	private Date offerGenDate;
	@Column(name = "reg_completed_date")
	private Date regCompletedDate;
	@Column(name = "ret_date")
	private Date retDate;
	@Column(name = "ret_bonus")
	private String retBonus;
	@Column(name = "ret_bonus_quantum")
	private double retBonusQuant;
	@Column(name = "work_state")
	private String workState;
	@Column(name = "offer_date")
	private Date offerDate;
	@Column(name = "role")
	private String role;
	@Column(name = "reporting_to")
	private String reportingTo;
	@Column(name = "reporting_address")
	private String reportAddress;
	@Column(name = "joining_date")
	private Date joinDate;
	@Column(name = "exemption_status")
	private String exemptStatus;
	@Column(name = "offer_release_date")
	private Date offerRelDate;
	@Column(name = "offer_status")
	private String offerStatus;
	@Column(name = "offer_acceptance_date")
	private Date offerAcceptDate;
	@Column(name = "base")
	private double base;
	@Column(name = "bonus")
	private double bonus;
	@Column(name = "severance")
	private double severance;
	@Column(name = "joining_letter")
	private byte[] joiningLetter;
	@Column(name = "joining_letter_date")
	private Date joiningLetterDate;
	@Column(name = "joiner_status")
	private boolean joinerStatus;
	@Column(name = "key")
	private String key;
	@Column(name = "date")
	private Date date;
	@Column(name = "last_login_date_time")
	private LocalDateTime lastLoginTime;
	
	@Column(name = "account_locked_out_time")
	private LocalDateTime accountLockedTime;

	public CandidateEntityMap() {
		super();
	}

	public CandidateEntityMap(String firstname, String middlename, String lastname, String emailid, String contactno,
			String city, String country, String privacyNotice, String password, boolean isFirstTimeLogin,
			boolean isCandidateLoggedIn, int incorrectLoginAttempt, int id, String username, String skills,
			String currentTitle, Date dob, String currentLocation, boolean regflag, String refId, byte[] offerFile,
			boolean appflag, Date offerGenDate, Date regCompletedDate, Date retDate, String retBonus,
			double retBonusQuant, String workState, Date offerDate, String role, String reportingTo,
			String reportAddress, Date joinDate, String exemptStatus, Date offerRelDate, String offerStatus,
			Date offerAcceptDate, double base, double bonus, double severance, byte[] joiningLetter,
			Date joiningLetterDate, boolean joinerStatus, String key, Date date, LocalDateTime lastLoginTime,
			LocalDateTime accountLockedTime) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.emailid = emailid;
		this.contactno = contactno;
		this.city = city;
		this.country = country;
		this.privacyNotice = privacyNotice;
		this.password = password;
		this.isFirstTimeLogin = isFirstTimeLogin;
		this.isCandidateLoggedIn = isCandidateLoggedIn;
		this.incorrectLoginAttempt = incorrectLoginAttempt;
		this.id = id;
		this.username = username;
		this.skills = skills;
		this.currentTitle = currentTitle;
		this.dob = dob;
		this.currentLocation = currentLocation;
		this.regflag = regflag;
		this.refId = refId;
		this.offerFile = offerFile;
		this.appflag = appflag;
		this.offerGenDate = offerGenDate;
		this.regCompletedDate = regCompletedDate;
		this.retDate = retDate;
		this.retBonus = retBonus;
		this.retBonusQuant = retBonusQuant;
		this.workState = workState;
		this.offerDate = offerDate;
		this.role = role;
		this.reportingTo = reportingTo;
		this.reportAddress = reportAddress;
		this.joinDate = joinDate;
		this.exemptStatus = exemptStatus;
		this.offerRelDate = offerRelDate;
		this.offerStatus = offerStatus;
		this.offerAcceptDate = offerAcceptDate;
		this.base = base;
		this.bonus = bonus;
		this.severance = severance;
		this.joiningLetter = joiningLetter;
		this.joiningLetterDate = joiningLetterDate;
		this.joinerStatus = joinerStatus;
		this.key = key;
		this.date = date;
		this.lastLoginTime = lastLoginTime;
		this.accountLockedTime = accountLockedTime;
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
		return privacyNotice;
	}

	public void setPrivacyNotice(String privacyNotice) {
		this.privacyNotice = privacyNotice;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isFirstTimeLogin() {
		return isFirstTimeLogin;
	}

	public void setFirstTimeLogin(boolean isFirstTimeLogin) {
		this.isFirstTimeLogin = isFirstTimeLogin;
	}

	public boolean isCandidateLoggedIn() {
		return isCandidateLoggedIn;
	}

	public void setCandidateLoggedIn(boolean isCandidateLoggedIn) {
		this.isCandidateLoggedIn = isCandidateLoggedIn;
	}

	public int getIncorrectLoginAttempt() {
		return incorrectLoginAttempt;
	}

	public void setIncorrectLoginAttempt(int incorrectLoginAttempt) {
		this.incorrectLoginAttempt = incorrectLoginAttempt;
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

	public Date getRetDate() {
		return retDate;
	}

	public void setRetDate(Date retDate) {
		this.retDate = retDate;
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

	public boolean isJoinerStatus() {
		return joinerStatus;
	}

	public void setJoinerStatus(boolean joinerStatus) {
		this.joinerStatus = joinerStatus;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(LocalDateTime lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public LocalDateTime getAccountLockedTime() {
		return accountLockedTime;
	}

	public void setAccountLockedTime(LocalDateTime accountLockedTime) {
		this.accountLockedTime = accountLockedTime;
	}

	@Override
	public String toString() {
		return "CandidateEntityMap [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", emailid=" + emailid + ", contactno=" + contactno + ", city=" + city + ", country=" + country
				+ ", privacyNotice=" + privacyNotice + ", password=" + password + ", isFirstTimeLogin="
				+ isFirstTimeLogin + ", isCandidateLoggedIn=" + isCandidateLoggedIn + ", incorrectLoginAttempt="
				+ incorrectLoginAttempt + ", id=" + id + ", username=" + username + ", skills=" + skills
				+ ", currentTitle=" + currentTitle + ", dob=" + dob + ", currentLocation=" + currentLocation
				+ ", regflag=" + regflag + ", refId=" + refId + ", offerFile=" + Arrays.toString(offerFile)
				+ ", appflag=" + appflag + ", offerGenDate=" + offerGenDate + ", regCompletedDate=" + regCompletedDate
				+ ", retDate=" + retDate + ", retBonus=" + retBonus + ", retBonusQuant=" + retBonusQuant
				+ ", workState=" + workState + ", offerDate=" + offerDate + ", role=" + role + ", reportingTo="
				+ reportingTo + ", reportAddress=" + reportAddress + ", joinDate=" + joinDate + ", exemptStatus="
				+ exemptStatus + ", offerRelDate=" + offerRelDate + ", offerStatus=" + offerStatus
				+ ", offerAcceptDate=" + offerAcceptDate + ", base=" + base + ", bonus=" + bonus + ", severance="
				+ severance + ", joiningLetter=" + Arrays.toString(joiningLetter) + ", joiningLetterDate="
				+ joiningLetterDate + ", joinerStatus=" + joinerStatus + ", key=" + key + ", date=" + date
				+ ", lastLoginTime=" + lastLoginTime + ", accountLockedTime=" + accountLockedTime + "]";
	}
	
}