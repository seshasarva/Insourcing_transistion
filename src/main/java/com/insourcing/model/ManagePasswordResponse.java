package com.insourcing.model;

import java.io.Serializable;

public class ManagePasswordResponse implements Serializable {

private static final long serialVersionUID = 3042523838850251217L;
private String status;
private ErrorInfo errorInfo;

/**
 * @return the status
 */
public String getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}
/**
 * @return the errorInfo
 */
public ErrorInfo getErrorInfo() {
	return errorInfo;
}
/**
 * @param errorInfo the errorInfo to set
 */
public void setErrorInfo(ErrorInfo errorInfo) {
	this.errorInfo = errorInfo;
}

}
