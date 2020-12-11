package com.insourcing.model;

public class MySpaceModel {
	
	private long headCount;
	private long offerCount;
	private long joinerCount;
	private long skillsCount;
	private String offerAccept;
	public long getHeadCount() {
		return headCount;
	}
	public void setHeadCount(long headCount) {
		this.headCount = headCount;
	}
	public long getOfferCount() {
		return offerCount;
	}
	public void setOfferCount(long offerCount) {
		this.offerCount = offerCount;
	}
	public long getJoinerCount() {
		return joinerCount;
	}
	public void setJoinerCount(long joinerCount) {
		this.joinerCount = joinerCount;
	}
	public long getSkillsCount() {
		return skillsCount;
	}
	public void setSkillsCount(long skillsCount) {
		this.skillsCount = skillsCount;
	}
	public String getOfferAccept() {
		return offerAccept;
	}
	public void setOfferAccept(String offerAccept) {
		this.offerAccept = offerAccept;
	}
	public MySpaceModel(long headCount, long offerCount, long joinerCount, long skillsCount, String offerAccept) {
		super();
		this.headCount = headCount;
		this.offerCount = offerCount;
		this.joinerCount = joinerCount;
		this.skillsCount = skillsCount;
		this.offerAccept = offerAccept;
	}
	public MySpaceModel() {
		super();
	}
	
	
	

}
