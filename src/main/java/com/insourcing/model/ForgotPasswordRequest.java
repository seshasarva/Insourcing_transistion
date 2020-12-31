package com.insourcing.model;

public class ForgotPasswordRequest {

	String emailId;
	String newPassword;
	String currentPassword;

	public ForgotPasswordRequest() {
		super();
	}

	public ForgotPasswordRequest(String emailId, String newPassword) {
		super();
		this.emailId = emailId;
		this.newPassword = newPassword;
	}

	public String getEmailID() {
		return emailId;
	}

	public void setEmailID(String emailId) {
		this.emailId = emailId;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	@Override
	public String toString() {
		return "ForgotPasswordRequest [emailId=" + emailId + ", newPassword=" + newPassword + ", currentPassword="
				+ currentPassword + "]";
	}

}
