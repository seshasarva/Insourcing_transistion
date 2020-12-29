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
	@Column(columnDefinition="TEXT")
	private String euStatusManagement;
	@Column(columnDefinition="TEXT")
	private String euApplicationForm;
	@Column(columnDefinition="TEXT")
	private String noneuStatusManagement;
	@Column(columnDefinition="TEXT")
	private String noneuApplicationForm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEuStatusManagement() {
		return euStatusManagement;
	}
	public void setEuStatusManagement(String euStatusManagement) {
		this.euStatusManagement = euStatusManagement;
	}
	public String getEuApplicationForm() {
		return euApplicationForm;
	}
	public void setEuApplicationForm(String euApplicationForm) {
		this.euApplicationForm = euApplicationForm;
	}
	public String getNoneuStatusManagement() {
		return noneuStatusManagement;
	}
	public void setNoneuStatusManagement(String noneuStatusManagement) {
		this.noneuStatusManagement = noneuStatusManagement;
	}
	public String getNoneuApplicationForm() {
		return noneuApplicationForm;
	}
	public void setNoneuApplicationForm(String noneuApplicationForm) {
		this.noneuApplicationForm = noneuApplicationForm;
	}
	
}
