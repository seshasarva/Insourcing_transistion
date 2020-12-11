package com.insourcing.entity;

import java.util.Arrays;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "edu_emp_report")
public class USEduEmpReportEntity {

	@Id
	@Column(name = "emailid")
	//@JsonProperty("emailid")
	private String emailid;
	@Column(name = "ref_id")
	//@JsonProperty("refid")
	private String refid;
	@Column(name = "firstname")
	//@JsonProperty("firstname")
	private String firstname;
	@Column(name = "middlename")
	//@JsonProperty("middlename")
	private String middlename;
	@Column(name = "lastname")
	//@JsonProperty("lastname")
	private String lastname;
	@Column(name = "associate_degree")
	//@JsonProperty("assDegree")
	private String assDegree;
	@Column(name = "bachelor_degree")
	//@JsonProperty("bachDegree")
	private String bachDegree;
	@Column(name = "master_degree")
	//@JsonProperty("masterDegree")
	private String masterDegree;
	@Column(name = "doctoral_degree")
	//@JsonProperty("doctDegree")
	private String doctDegree;
	@Column(name = "total_exp")
	//@JsonProperty("totalExp")
	private String totalExp;
	@Column(name = "total_relevant_exp")
	//@JsonProperty("relExp")
	private String relExp;
	@Column(name = "com")
	//@JsonProperty("com")
	private String[] com;
	@Column(name = "com_from")
	//@JsonProperty("comFrom")
	private Date[] comFrom;
	@Column(name = "com_to")
	//@JsonProperty("comTo")
	private Date[] comTo;
	@Column(name = "ex_tcs_employee")
	//@JsonProperty("")
	private String exTCSEmp;

	public USEduEmpReportEntity() {
		super();
	}

	public USEduEmpReportEntity(String emailid, String refid, String firstname, String middlename, String lastname,
			String assDegree, String bachDegree, String masterDegree, String doctDegree, String totalExp, String relExp,
			String[] com, Date[] comFrom, Date[] comTo, String exTCSEmp) {
		super();
		this.emailid = emailid;
		this.refid = refid;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.assDegree = assDegree;
		this.bachDegree = bachDegree;
		this.masterDegree = masterDegree;
		this.doctDegree = doctDegree;
		this.totalExp = totalExp;
		this.relExp = relExp;
		this.com = com;
		this.comFrom = comFrom;
		this.comTo = comTo;
		this.exTCSEmp = exTCSEmp;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getRefid() {
		return refid;
	}

	public void setRefid(String refid) {
		this.refid = refid;
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

	public String getAssDegree() {
		return assDegree;
	}

	public void setAssDegree(String assDegree) {
		this.assDegree = assDegree;
	}

	public String getBachDegree() {
		return bachDegree;
	}

	public void setBachDegree(String bachDegree) {
		this.bachDegree = bachDegree;
	}

	public String getMasterDegree() {
		return masterDegree;
	}

	public void setMasterDegree(String masterDegree) {
		this.masterDegree = masterDegree;
	}

	public String getDoctDegree() {
		return doctDegree;
	}

	public void setDoctDegree(String doctDegree) {
		this.doctDegree = doctDegree;
	}

	public String getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(String totalExp) {
		this.totalExp = totalExp;
	}

	public String getRelExp() {
		return relExp;
	}

	public void setRelExp(String relExp) {
		this.relExp = relExp;
	}

	public String[] getCom() {
		return com;
	}

	public void setCom(String[] com) {
		this.com = com;
	}

	public Date[] getComFrom() {
		return comFrom;
	}

	public void setComFrom(Date[] comFrom) {
		this.comFrom = comFrom;
	}

	public Date[] getComTo() {
		return comTo;
	}

	public void setComTo(Date[] comTo) {
		this.comTo = comTo;
	}

	public String getExTCSEmp() {
		return exTCSEmp;
	}

	public void setExTCSEmp(String exTCSEmp) {
		this.exTCSEmp = exTCSEmp;
	}

	@Override
	public String toString() {
		return "USEduEmpReportEntity [emailid=" + emailid + ", refid=" + refid + ", firstname=" + firstname
				+ ", middlename=" + middlename + ", lastname=" + lastname + ", assDegree=" + assDegree + ", bachDegree="
				+ bachDegree + ", masterDegree=" + masterDegree + ", doctDegree=" + doctDegree + ", totalExp="
				+ totalExp + ", relExp=" + relExp + ", com=" + Arrays.toString(com) + ", comFrom="
				+ Arrays.toString(comFrom) + ", comTo=" + Arrays.toString(comTo) + ", exTCSEmp=" + exTCSEmp + "]";
	}

}
