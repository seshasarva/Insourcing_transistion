package com.insourcing.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "hr_login_details")
public class HRLoginEntity {

	@Column(name = "Emp_No")
	@JsonProperty("empNo")
	private String empNo;
	@Column(name = "EmpName")
	@JsonProperty("empName")
	private String empName;
	@Id
	@Column(name = "Email_Id")
	@JsonProperty("emailId")
	private String emailId;
	@Column(name = "password")
	@JsonProperty("password")
	private String password;
	@Column(name = "country")
	@JsonProperty("country")
	private String country;

	@Column(name = "role")
	private String role;

	@Column(name = "last_updated_date_time")
	private LocalDateTime lastUpdatedDateTime;

	@Column(name = "is_user_logged_in")
	private boolean isHRLoggedIn;

	@Column(name = "last_login_time")
	private LocalDateTime lastLoginTime;

	@Column(name = "incorrect_login_attempt")
	private int incorrectLoginAttempt;

	@Column(name = "account_locked_out_time")
	private LocalDateTime accountLockedTime;

	public HRLoginEntity() {
		super();
	}

	public HRLoginEntity(String empNo, String empName, String emailId, String password, String country, String role,
			LocalDateTime lastUpdatedDateTime, boolean isHRLoggedIn, LocalDateTime lastLoginTime,
			int incorrectLoginAttempt, LocalDateTime accountLockedTime) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.emailId = emailId;
		this.password = password;
		this.country = country;
		this.role = role;
		this.lastUpdatedDateTime = lastUpdatedDateTime;
		this.isHRLoggedIn = isHRLoggedIn;
		this.lastLoginTime = lastLoginTime;
		this.incorrectLoginAttempt = incorrectLoginAttempt;
		this.accountLockedTime = accountLockedTime;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}

	public void setLastUpdatedDateTime(LocalDateTime lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	public boolean isHRLoggedIn() {
		return isHRLoggedIn;
	}

	public void setHRLoggedIn(boolean isHRLoggedIn) {
		this.isHRLoggedIn = isHRLoggedIn;
	}

	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(LocalDateTime lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getIncorrectLoginAttempt() {
		return incorrectLoginAttempt;
	}

	public void setIncorrectLoginAttempt(int incorrectLoginAttempt) {
		this.incorrectLoginAttempt = incorrectLoginAttempt;
	}

	public LocalDateTime getAccountLockedTime() {
		return accountLockedTime;
	}

	public void setAccountLockedTime(LocalDateTime accountLockedTime) {
		this.accountLockedTime = accountLockedTime;
	}

	@Override
	public String toString() {
		return "HRLoginEntity [empNo=" + empNo + ", empName=" + empName + ", emailId=" + emailId + ", password="
				+ password + ", country=" + country + ", role=" + role + ", lastUpdatedDateTime=" + lastUpdatedDateTime
				+ ", isHRLoggedIn=" + isHRLoggedIn + ", lastLoginTime=" + lastLoginTime + ", incorrectLoginAttempt="
				+ incorrectLoginAttempt + ", accountLockedTime=" + accountLockedTime + "]";
	}

}