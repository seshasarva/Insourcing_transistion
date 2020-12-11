package com.insourcing.model;

public class EducationModel {
	
     private String instituteName;
     private String insAddress;
     private String graduate;
     private String degree;
     private String cos;
     private String GPA;
     private String educationalLevel;
     
	public String getEducationalLevel() {
		return educationalLevel;
	}
	public void setEducationalLevel(String educationalLevel) {
		this.educationalLevel = educationalLevel;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getInsAddress() {
		return insAddress;
	}
	public void setInsAddress(String insAddress) {
		this.insAddress = insAddress;
	}
	public String getGraduate() {
		return graduate;
	}
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getCos() {
		return cos;
	}
	public void setCos(String cos) {
		this.cos = cos;
	}
	public String getGPA() {
		return GPA;
	}
	public void setGPA(String gPA) {
		GPA = gPA;
	}
         
}
