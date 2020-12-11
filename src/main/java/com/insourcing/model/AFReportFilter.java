package com.insourcing.model;

import java.util.Date;

public class AFReportFilter {

	private Date startDate;
	private Date endDate;
	private boolean appStatus;

	public AFReportFilter() {
		super();
	}

	public AFReportFilter(Date startDate, Date endDate, boolean appStatus) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.appStatus = appStatus;
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

	public boolean getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(boolean appStatus) {
		this.appStatus = appStatus;
	}

	@Override
	public String toString() {
		return "AFReportFilter [startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
