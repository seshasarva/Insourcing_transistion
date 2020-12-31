package com.insourcing.entity;

import java.util.Date;

public class CandidateEntity {

	private String firstname;
	private String middlename;
	private String lastname;
	private String emailid;
	private String currentTitle;
	private String contactno;
	private String city;
	private String country;
	private String notice;
	private String password;
	private String confirmPassword;
	private boolean consent;
	private Date date;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isConsent() {
		return consent;
	}

	public void setConsent(boolean consent) {
		this.consent = consent;
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

	public String getCurrentTitle() {
		return currentTitle;
	}

	public void setCurrentTitle(String currentTitle) {
		this.currentTitle = currentTitle;
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

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CandidateEntity [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", emailid=" + emailid + ", currentTitle=" + currentTitle + ", contactno=" + contactno + ", city="
				+ city + ", country=" + country + ", notice=" + notice + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", consent=" + consent + ", date=" + date + "]";
	}

}