package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class TestEntity {
	@Id
	@Column(name = "emailid", nullable = false)
	private String emailid;
	@Column(name = "appflag")
	private String appflag;
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAppflag() {
		return appflag;
	}
	public void setAppflag(String appflag) {
		this.appflag = appflag;
	}
	
}
