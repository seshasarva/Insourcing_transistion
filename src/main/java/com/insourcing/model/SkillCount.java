package com.insourcing.model;

public class SkillCount {
	
	private String skills;
	private long count;
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public SkillCount(String skills, long count) {
		super();
		this.skills = skills;
		this.count = count;
	}
	public SkillCount() {
		super();
	}
	
	

}
