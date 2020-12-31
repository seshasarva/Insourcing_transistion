package com.insourcing.model;

public class AppExtraFieldName {

	private String titleName;
	private boolean display;

	public AppExtraFieldName() {
		super();
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	@Override
	public String toString() {
		return "AppExtraFieldName [titleName=" + titleName + ", display=" + display + "]";
	}

}
