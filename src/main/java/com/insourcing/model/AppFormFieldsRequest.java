package com.insourcing.model;

public class AppFormFieldsRequest {

	private String dealId;
	private String country;

	public AppFormFieldsRequest() {
		super();
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "AppFormFieldsRequest [dealId=" + dealId + ", country=" + country + "]";
	}

}
