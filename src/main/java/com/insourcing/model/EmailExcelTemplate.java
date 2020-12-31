package com.insourcing.model;

import java.util.Date;

public class EmailExcelTemplate {

	private String emailId;
	private String firstName;
	private String middleName;
	private String lastName;
	private double baseSalary;
	private String offerStatus;
	private Date joiningDate;

	public EmailExcelTemplate() {
		super();
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Emailemplate [emailId=" + emailId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", baseSalary=" + baseSalary + ", offerStatus=" + offerStatus
				+ ", joiningDate=" + joiningDate + "]";
	}

}
