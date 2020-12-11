package com.insourcing.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class OfferModel {
	@SerializedName("Date")
	private Date date;
	@SerializedName("First Name")
	private String firstName;
	@SerializedName("Last Name")
	private String lastName;
	@SerializedName("Address")
	private String address;
	@SerializedName("Address2")
	private String address2;
	@SerializedName("City, State, Zip Code")
	private String city;
//	@SerializedName("State")
//	private String state;
//	@SerializedName("Zip-Code")
//	private String zipCode;
	@SerializedName("Role/Job Title")
	private String role;
	//@SerializedName("Job Title")
	//private String jobTitle;
	@SerializedName("Reporting To")
	private String reportingTo;
	@SerializedName("Reporting Address")
	private String reportingAddress;
	@SerializedName("Join Date")
	private Date joinDate;
	@SerializedName("Base $")
	private double base;
	@SerializedName("Exemption Status")
	private String exemptionStatus;
	@SerializedName("Bonus $")
	private double bonus;
	@SerializedName("Severance $")
	private double severance;
	@SerializedName("Offer Response Date")
	private Date offerResponseDate;
	@SerializedName("Email Id")
	private String emailId;

	public OfferModel(Date date, String firstName, String lastName, String address, String address2, String city,
			String state, String zipCode, String role, String jobTitle, String reportingTo, String reportingAddress,
			Date joinDate, double base, String exemptionStatus, double bonus, double severance, Date offerResponseDate,
			String emailId) {
		super();
		this.date = date;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.address2 = address2;
		this.city = city;
//		this.state = state;
//		this.zipCode = zipCode;
		this.role = role;
		//this.jobTitle = jobTitle;
		this.reportingTo = reportingTo;
		this.reportingAddress = reportingAddress;
		this.joinDate = joinDate;
		this.base = base;
		this.exemptionStatus = exemptionStatus;
		this.bonus = bonus;
		this.severance = severance;
		this.offerResponseDate = offerResponseDate;
		this.emailId = emailId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}
//	public String getZipCode() {
//		return zipCode;
//	}
//	public void setZipCode(String zipCode) {
//		this.zipCode = zipCode;
//	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	//public String getJobTitle() {
	//	return jobTitle;
	//}
	//public void setJobTitle(String jobTitle) {
		//this.jobTitle = jobTitle;
	//}
	public OfferModel() {
		super();
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReportingTo() {
		return reportingTo;
	}
	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}
	public String getReportingAddress() {
		return reportingAddress;
	}
	public void setReportingAddress(String reportingAddress) {
		this.reportingAddress = reportingAddress;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public String getExemptionStatus() {
		return exemptionStatus;
	}
	public void setExemptionStatus(String exemptionStatus) {
		this.exemptionStatus = exemptionStatus;
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
	public Date getOfferResponseDate() {
		return offerResponseDate;
	}
	public void setOfferResponseDate(Date offerResponseDate) {
		this.offerResponseDate = offerResponseDate;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "OfferModel [date=" + date + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", address2=" + address2 + ", city=" + city
				+ ", role=" + role + ", reportingTo=" + reportingTo + ", reportingAddress="
				+ reportingAddress + ", joinDate=" + joinDate + ", base=" + base + ", exemptionStatus="
				+ exemptionStatus + ", bonus=" + bonus + ", severance=" + severance + ", offerResponseDate="
				+ offerResponseDate + ", emailId=" + emailId + "]";
	}

}
