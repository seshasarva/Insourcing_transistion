package com.insourcing.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.google.gson.annotations.SerializedName;

public class RetentionModel {
	@SerializedName("Date")
	private Date date;
	@SerializedName("First Name")
	private String firstName;
	@SerializedName("Last Name")
	private String lastName;
	@SerializedName("Address")
	@JsonAlias("Address")
	private String address;
	/*
	 * @SerializedName("Apartment/Unit#") private String apartment;
	 * 
	 * @SerializedName("City") private String city;
	 * 
	 * @SerializedName("State") private String state;
	 * 
	 * @SerializedName("Zip-Code") private String zipCode;
	 */
	@SerializedName("Address 2")
	private String address2;
	@SerializedName("City,State,Zip Code")
	private String cityStateZip;
	@SerializedName("Bonus $")
	private double bonus;
	@SerializedName("Work State")
	private String workState;
	@SerializedName("Email ID")
	private String emailId;
	
	public RetentionModel() {
		super();
	}

	public RetentionModel(Date date, String firstName, String lastName, String address, String address2,
			String cityStateZip, double bonus, String workState, String emailId) {
		super();
		this.date = date;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.address2 = address2;
		this.cityStateZip = cityStateZip;
		this.bonus = bonus;
		this.workState = workState;
		this.emailId = emailId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCityStateZip() {
		return cityStateZip;
	}

	public void setCityStateZip(String cityStateZip) {
		this.cityStateZip = cityStateZip;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "RetentionModel [date=" + date + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", address2=" + address2 + ", cityStateZip=" + cityStateZip + ", bonus=" + bonus
				+ ", workState=" + workState + ", emailId=" + emailId + "]";
	}
	
}
