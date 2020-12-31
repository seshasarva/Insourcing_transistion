package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "password_history")
public class PasswordHistoryEntityMap {
	@Id
	@Column(name = "emailid", nullable = false)
	private String emailId;
	@Column(name = "password1")
	private String password1;
	@Column(name = "password2")
	private String password2;
	@Column(name = "password3")
	private String password3;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getPassword3() {
		return password3;
	}
	public void setPassword3(String password3) {
		this.password3 = password3;
	}
	public PasswordHistoryEntityMap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PasswordHistoryEntityMap(String emailId, String password1, String password2, String password3) {
		super();
		this.emailId = emailId;
		this.password1 = password1;
		this.password2 = password2;
		this.password3 = password3;
	}
	@Override
	public String toString() {
		return "PasswordHistoryEntityMap [emailId=" + emailId + ", password1=" + password1 + ", password2=" + password2
				+ ", password3=" + password3 + "]";
	}
	
	
}