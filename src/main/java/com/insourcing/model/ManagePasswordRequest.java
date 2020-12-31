package com.insourcing.model;

import java.io.Serializable;

public class ManagePasswordRequest implements Serializable {

private static final long serialVersionUID = 3042523838850251217L;
private String userName;
private String newPassword;
private String oldPassword;
private String confirmPassword;

/**
 * @return the userName
 */
public String getUserName() {
	return userName;
}
/**
 * @param userName the userName to set
 */
public void setUserName(String userName) {
	this.userName = userName;
}
/**
 * @return the newPassword
 */
public String getNewPassword() {
	return newPassword;
}
/**
 * @param newPassword the newPassword to set
 */
public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
}
/**
 * @return the oldPassword
 */
public String getOldPassword() {
	return oldPassword;
}
/**
 * @param oldPassword the oldPassword to set
 */
public void setOldPassword(String oldPassword) {
	this.oldPassword = oldPassword;
}
/**
 * @return the confirmPassword
 */
public String getConfirmPassword() {
	return confirmPassword;
}
/**
 * @param confirmPassword the confirmPassword to set
 */
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}


}
