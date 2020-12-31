package com.insourcing.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "template_hrbc")
public class EmailTempEntity {
	
	@Column(name = "Email_Id", nullable = false)
	private String emailId;

	@Id
	@Column(name = "Template_Name", nullable = false)
	private String templateName;
	@Column(name = "Status")
	private String status;
	@Column(name = "Subject")
	private String subject;
	@Column(name = "Message")
	private String message;
	@Column(name = "Template_Creation_Date")
	private Date templateCreatedDate;
	
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
	public EmailTempEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailTempEntity(String emailId, int templateId, String templateName, String status, String subject,
			String message, Date templateCreatedDate) {
		super();
		this.emailId = emailId;
		this.templateName = templateName;
		this.status = status;
		this.subject = subject;
		this.message = message;
		this.templateCreatedDate = templateCreatedDate;
	}
	@Override
	public String toString() {
		return "EmailTempEntity [emailId=" + emailId + ", templateName=" + templateName
				+ ", status=" + status + ", subject=" + subject + ", message=" + message + ", templateCreatedDate="
				+ templateCreatedDate + "]";
	}
	
}
