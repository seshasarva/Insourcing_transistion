package com.insourcing.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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

	@Column(name = "expired_token", length = 500)
	private String expiredToken;

	@Size(max = 500)
	@Column(name = "generated_token", length = 500)
	private String genToken;

	public HRLoginEntity() {
		super();
	}

	public String getGenToken() {
		return genToken;
	}

	public void setGenToken(String genToken) {
		this.genToken = genToken;
	}


	public String getExpiredToken() {
		return expiredToken;
	}

	public void setExpiredToken(String expiredToken) {
		this.expiredToken = expiredToken;
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
				+ incorrectLoginAttempt + ", accountLockedTime=" + accountLockedTime + ", expiredToken=" + expiredToken
				+ ", genToken=" + genToken + "]";
	}

}