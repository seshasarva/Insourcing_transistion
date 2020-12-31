package com.insourcing.model;

import java.util.Date;

public class EmailTemplateRequest {
	

	private String emailId;
	private String templateName;
	//private int templateId;
	private String status;
	private String subject;
	private String message;
	private Date templateCreatedDate;
	
	public EmailTemplateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmailTemplateRequest(String emailId, String templateName, int templateId, String status, String subject,
			String message, Date templateCreatedDate) {
		super();
		this.emailId = emailId;
		this.templateName = templateName;
		//this.templateId = templateId;
		this.status = status;
		this.subject = subject;
		this.message = message;
		this.templateCreatedDate = templateCreatedDate;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTemplateCreatedDate() {
		return templateCreatedDate;
	}
	public void setTemplateCreatedDate(Date templateCreatedDate) {
		this.templateCreatedDate = templateCreatedDate;
	}

	@Override
	public String toString() {
		return "EmailTemplateRequest [emailId=" + emailId + ", templateName=" + templateName + ", status=" + status + ", subject=" + subject + ", message=" + message
				+ ", templateCreatedDate=" + templateCreatedDate + "]";
	}
	
}
