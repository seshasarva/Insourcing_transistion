package com.insourcing.model;

import java.util.Date;

public class OfferRetentionReportModel {

	private String emailid;
	private String refid;
	private String firstname;
	private String middlename;
	private String lastname;
	private String exemptStatus;
	private Date offerCreatDate;
	private Date offerRelDate;
	private String offerAccept;
	private Date offerAcceptDate;
	private double base;
	private double bonus;
	private double severance;
	private String retentBonus;
	private double retentBonusQuant;

	public OfferRetentionReportModel() {
		super();
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

	public String getExemptStatus() {
		return exemptStatus;
	}

	public void setExemptStatus(String exemptStatus) {
		this.exemptStatus = exemptStatus;
	}

	public Date getOfferCreatDate() {
		return offerCreatDate;
	}

	public void setOfferCreatDate(Date offerCreatDate) {
		this.offerCreatDate = offerCreatDate;
	}

	public Date getOfferRelDate() {
		return offerRelDate;
	}

	public void setOfferRelDate(Date offerRelDate) {
		this.offerRelDate = offerRelDate;
	}

	public String getOfferAccept() {
		return offerAccept;
	}

	public void setOfferAccept(String offerAccept) {
		this.offerAccept = offerAccept;
	}

	public Date getOfferAcceptDate() {
		return offerAcceptDate;
	}

	public void setOfferAcceptDate(Date offerAcceptDate) {
		this.offerAcceptDate = offerAcceptDate;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getSeverance() {
		return severance;
	}

	public void setSeverance(double severance) {
		this.severance = severance;
	}

	public String getRetentBonus() {
		return retentBonus;
	}

	public void setRetentBonus(String retentBonus) {
		this.retentBonus = retentBonus;
	}

	public double getRetentBonusQuant() {
		return retentBonusQuant;
	}

	public void setRetentBonusQuant(double retentBonusQuant) {
		this.retentBonusQuant = retentBonusQuant;
	}

	public OfferRetentionReportModel(String emailid, String refid, String firstname, String middlename, String lastname,
			String exemptStatus, Date offerCreatDate, Date offerRelDate, String offerAccept, Date offerAcceptDate,
			double base, double bonus, double severance, String retentBonus, double retentBonusQuant) {
		super();
		this.emailid = emailid;
		this.refid = refid;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.exemptStatus = exemptStatus;
		this.offerCreatDate = offerCreatDate;
		this.offerRelDate = offerRelDate;
		this.offerAccept = offerAccept;
		this.offerAcceptDate = offerAcceptDate;
		this.base = base;
		this.bonus = bonus;
		this.severance = severance;
		this.retentBonus = retentBonus;
		this.retentBonusQuant = retentBonusQuant;
	}

	@Override
	public String toString() {
		return "OfferRetentionReportEntity [emailid=" + emailid + ", refid=" + refid + ", firstname=" + firstname
				+ ", middlename=" + middlename + ", lastname=" + lastname + ", exemptStatus=" + exemptStatus
				+ ", offerCreatDate=" + offerCreatDate + ", offerRelDate=" + offerRelDate + ", offerAccept="
				+ offerAccept + ", offerAcceptDate=" + offerAcceptDate + ", base=" + base + ", bonus=" + bonus
				+ ", severance=" + severance + ", retentBonus=" + retentBonus + ", retentBonusQuant=" + retentBonusQuant
				+ "]";
	}

}
