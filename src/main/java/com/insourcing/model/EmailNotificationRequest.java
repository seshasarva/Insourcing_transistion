/**
 * 
 */
package com.insourcing.model;

import java.io.Serializable;
import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

public class EmailNotificationRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 346528510469591138L;
	@SerializedName("emailId")
	private String emailId;
	@SerializedName("toEmail")
	private String[] toEmail;
	@SerializedName("subject")
	private String subject;
	@SerializedName("message")
	private String message;
	@SerializedName("hasAttachment")
	private boolean hasAttachment;
	@SerializedName("attachment")
	private String attachment;
	@SerializedName("fileName")
	private String fileName;
	

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}
	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the toEmail
	 */
	public String[] getToEmail() {
		return toEmail;
	}
	/**
	 * @param toEmail the toEmail to set
	 */
	public void setToEmail(String[] toEmail) {
		this.toEmail = toEmail;
	}
	/**
	 * @return the hasAttachment
	 */
	public boolean isHasAttachment() {
		return hasAttachment;
	}
	/**
	 * @param hasAttachment the hasAttachment to set
	 */
	public void setHasAttachment(boolean hasAttachment) {
		this.hasAttachment = hasAttachment;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "EmailNotificationRequest [emailId=" + emailId + ", toEmail=" + Arrays.toString(toEmail) + ", subject="
				+ subject + ", message=" + message + ", hasAttachment=" + hasAttachment + ", attachment=" + attachment
				+ ", fileName=" + fileName + "]";
	}

}
