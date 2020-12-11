package com.insourcing.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class AppointmentModel {
	
	@SerializedName("title")
	private String title;
	@SerializedName("First Name")
	private String firstName;
	
	@SerializedName("Middle Name") 
	private String middleName;
	 
	@SerializedName("Last Name")
	private String lastName;
	@SerializedName("Designation")
	private String designation;
	@SerializedName("Grade")
	private String grade;
	@SerializedName("Joining Date")
	private Date joiningDate;
	@SerializedName("Emp No")
	private double empNumber;
	@SerializedName("Email Id")
	private String emailId;
	@SerializedName("Joining Branch")
	private String joiningBranch;
	@SerializedName("Applicant Id")
	private String refId;

	public AppointmentModel(String title, String firstName, String middleName, String lastName, String designation,
			String grade, Date joiningDate, double empNumber, String emailId, String joiningBranch) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.designation = designation;
		this.grade = grade;
		this.joiningDate = joiningDate;
		this.empNumber = empNumber;
		this.emailId = emailId;
		this.joiningBranch = joiningBranch;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	  public String getMiddleName() { return middleName; } public void
	  setMiddleName(String middleName) { this.middleName = middleName; }
	 
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public double getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(double empNumber) {
		this.empNumber = empNumber;
	}
	public String getJoiningBranch() {
		return joiningBranch;
	}
	public void setJoiningBranch(String joiningBranch) {
		this.joiningBranch = joiningBranch;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public AppointmentModel() {
		super();
	}
	@Override
	public String toString() {
		return "AppointmentModel [title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", designation=" + designation + ", grade=" + grade + ", joiningDate="
				+ joiningDate + ", empNumber=" + empNumber + ", emailId=" + emailId + ", joiningBranch=" + joiningBranch
				+ "]";
	}
}
