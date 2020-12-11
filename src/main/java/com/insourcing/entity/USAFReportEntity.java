package com.insourcing.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "afreport")
public class USAFReportEntity {
	
	@Column(name = "refid")
	//@JsonProperty("refId")
	private String refId;
	@Column(name = "firstname")
	//@JsonProperty("firstname")
	private String firstname;
	@Column(name = "middlename")
	//@JsonProperty("middlename")
	private String middlename;
	@Column(name = "lastname")
	//@JsonProperty("lastname")
	private String lastname;
	@Id
	@Column(name = "emailid")
	//@JsonProperty("emailid")
	private String emailid;
	@Column(name = "contactno")
	//@JsonProperty("contactno")
	private String contactno;
	@Column(name = "apartmentunit")
	//@JsonProperty("apartmentUnit")
	private String apartmentUnit;
	@Column(name = "streetaddress")
	//@JsonProperty("streetAddress")
	private String streetAddress;
	@Column(name = "city")
	//@JsonProperty("city")
	private String city;
	@Column(name = "state")
	//@JsonProperty("state")
	private String state;
	@Column(name = "zipcode")
	//@JsonProperty("zipCode")
	private String zipCode;
	@Column(name = "offerempextdemworkus")
	//@JsonProperty("offerEmpExtDemWorkUS")
	private String offerEmpExtDemWorkUS;
	@Column(name = "reqsponsorship")
	//@JsonProperty("reqSponsorship")
	private String reqSponsorship;
	@Column(name = "appflagreg")
	//@JsonProperty("appflagreg")
	private boolean appflagreg;
	@Column(name = "appflagapp")
	//@JsonProperty("appflagapp")
	private boolean appflagapp;
	@Column(name = "resumestatus")
	//@JsonProperty("resumeStatus")
	private String resumeStatus;
	@Column(name = "techprof")
	//@JsonProperty("techProf")
	private String techProf;
	@Column(name = "regcompleteddate")
	//@JsonProperty("regCompletedDate")
	private Date regCompletedDate;
	@Column(name = "appcompleteddate")
	//@JsonProperty("appCompletedDate")
	private Date appCompletedDate;
	@Column(name = "currentworklocation")
	//@JsonProperty("currentWorkLocation")
	private String currentWorkLocation;

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
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

	public String getApartmentUnit() {
		return apartmentUnit;
	}

	public void setApartmentUnit(String apartmentUnit) {
		this.apartmentUnit = apartmentUnit;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getOfferEmpExtDemWorkUS() {
		return offerEmpExtDemWorkUS;
	}

	public void setOfferEmpExtDemWorkUS(String offerEmpExtDemWorkUS) {
		this.offerEmpExtDemWorkUS = offerEmpExtDemWorkUS;
	}

	public String getReqSponsorship() {
		return reqSponsorship;
	}

	public void setReqSponsorship(String reqSponsorship) {
		this.reqSponsorship = reqSponsorship;
	}

	public boolean getAppflagapp() {
		return appflagapp;
	}

	public void setAppflagapp(boolean appflagapp) {
		this.appflagapp = appflagapp;
	}

	public String getResumeStatus() {
		return resumeStatus;
	}

	public void setResumeStatus(String resumeStatus) {
		this.resumeStatus = resumeStatus;
	}

	public String getTechProf() {
		return techProf;
	}

	public void setTechProf(String techProf) {
		this.techProf = techProf;
	}

	public Date getRegCompletedDate() {
		return regCompletedDate;
	}

	public void setRegCompletedDate(Date regCompletedDate) {
		this.regCompletedDate = regCompletedDate;
	}

	public Date getAppCompletedDate() {
		return appCompletedDate;
	}

	public void setAppCompletedDate(Date appCompletedDate) {
		this.appCompletedDate = appCompletedDate;
	}

	public String getCurrentWorkLocation() {
		return currentWorkLocation;
	}

	public void setCurrentWorkLocation(String currentWorkLocation) {
		this.currentWorkLocation = currentWorkLocation;
	}

	public USAFReportEntity(String refId, String firstname, String middlename, String lastname, String emailid,
			String contactno, String apartmentUnit, String streetAddress, String city, String state, String zipCode,
			String offerEmpExtDemWorkUS, String reqSponsorship, boolean appflagapp, String resumeStatus, String techProf,
			Date regCompletedDate, Date appCompletedDate, String currentWorkLocation) {
		super();
		this.refId = refId;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.emailid = emailid;
		this.contactno = contactno;
		this.apartmentUnit = apartmentUnit;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.offerEmpExtDemWorkUS = offerEmpExtDemWorkUS;
		this.reqSponsorship = reqSponsorship;
		this.appflagapp = appflagapp;
		this.resumeStatus = resumeStatus;
		this.techProf = techProf;
		this.regCompletedDate = regCompletedDate;
		this.appCompletedDate = appCompletedDate;
		this.currentWorkLocation = currentWorkLocation;
	}

	public USAFReportEntity() {
		super();
	}

	@Override
	public String toString() {
		return "USAFReport [refId=" + refId + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname="
				+ lastname + ", emailid=" + emailid + ", contactno=" + contactno + ", apartmentUnit=" + apartmentUnit
				+ ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", offerEmpExtDemWorkUS=" + offerEmpExtDemWorkUS + ", reqSponsorship=" + reqSponsorship + ", appflag="
				+ appflagapp + ", resumeStatus=" + resumeStatus + ", techProf=" + techProf + ", regCompletedDate="
				+ regCompletedDate + ", appCompletedDate=" + appCompletedDate + ", currentWorkLocation="
				+ currentWorkLocation + "]";
	}

}
