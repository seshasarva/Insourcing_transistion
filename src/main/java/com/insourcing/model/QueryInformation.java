package com.insourcing.model;

public class QueryInformation {
	
	private String query ;
	private String sessionID;
	private String country;
	private boolean postOffer;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public boolean isPostOffer() {
		return postOffer;
	}
	public void setPostOffer(boolean postOffer) {
		this.postOffer = postOffer;
	}
	
}
