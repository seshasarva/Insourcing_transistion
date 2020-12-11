package com.insourcing.model;

import java.util.Date;

public class IndiaReportModel {

	private String appId;
	private String title;
	private String firstname;
	private String middlename;
	private String lastname;
	private String emailId;
	private String grade;
	private String offerStatus;
	private String appFormStatus;
	private String appointLetterStatus;
	private Date offerReleaseDate;

	public IndiaReportModel() {
		super();
	}

	public IndiaReportModel(String appId, String title, String firstname, String middlename, String lastname,
			String emailId, String grade, String offerStatus, String appFormStatus, String appointLetterStatus,
			Date offerReleaseDate) {
		super();
		this.appId = appId;
		this.title = title;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.emailId = emailId;
		this.grade = grade;
		this.offerStatus = offerStatus;
		this.appFormStatus = appFormStatus;
		this.appointLetterStatus = appointLetterStatus;
		this.offerReleaseDate = offerReleaseDate;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public String getAppFormStatus() {
		return appFormStatus;
	}

	public void setAppFormStatus(String appFormStatus) {
		this.appFormStatus = appFormStatus;
	}

	public String getAppointLetterStatus() {
		return appointLetterStatus;
	}

	public void setAppointLetterStatus(String appointLetterStatus) {
		this.appointLetterStatus = appointLetterStatus;
	}

	public Date getOfferReleaseDate() {
		return offerReleaseDate;
	}

	public void setOfferReleaseDate(Date offerReleaseDate) {
		this.offerReleaseDate = offerReleaseDate;
	}

	@Override
	public String toString() {
		return "IndiaReportModel [appId=" + appId + ", title=" + title + ", firstname=" + firstname + ", middlename="
				+ middlename + ", lastname=" + lastname + ", emailId=" + emailId + ", grade=" + grade + ", offerStatus="
				+ offerStatus + ", appFormStatus=" + appFormStatus + ", appointLetterStatus=" + appointLetterStatus
				+ ", offerReleaseDate=" + offerReleaseDate + "]";
	}

	
}
