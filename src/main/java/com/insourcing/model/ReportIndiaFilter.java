package com.insourcing.model;

import java.util.Date;

public class ReportIndiaFilter {

	private Date startDate;
	private Date endDate;
	private String offerStatus;
	private String grade;

	public ReportIndiaFilter() {
		super();
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public ReportIndiaFilter(Date startDate, Date endDate, String offerStatus, String grade) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.offerStatus = offerStatus;
		this.grade = grade;
	}

}
