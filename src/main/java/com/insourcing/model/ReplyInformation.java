package com.insourcing.model;

import java.util.List;

public class ReplyInformation {
	
	private String answer;
	
	private List<LeadingInformation> leadingInformation;
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}	
	
	public List<LeadingInformation> getLeadingInformation() {
		return leadingInformation;
	}

	public void setLeadingInformation(List<LeadingInformation> leadingInformation) {
		this.leadingInformation = leadingInformation;
	}

}
