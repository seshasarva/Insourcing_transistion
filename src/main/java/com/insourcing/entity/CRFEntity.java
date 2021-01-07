package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidate_reg_form")
public class CRFEntity {
	@Id
	private String id;
	public String getStatusManagement() {
		return statusManagement;
	}
	public void setStatusManagement(String statusManagement) {
		this.statusManagement = statusManagement;
	}
	public String getApplicationForm() {
		return applicationForm;
	}
	public void setApplicationForm(String applicationForm) {
		this.applicationForm = applicationForm;
	}
	@Column(columnDefinition="TEXT")
	private String statusManagement;
	@Column(columnDefinition="TEXT")
	private String applicationForm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
