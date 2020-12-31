package com.insourcing.model;

public class QueryInput {
	
	private String text;
	private String languageCode;
	public QueryInput(String languageCode, String text) {
		super();
		this.languageCode = languageCode;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	
	public String toString() {
		return "{"
				+ "queryInput:{"
				+ "text:{"
				+ "languageCode:" + languageCode + ","
				+ "text:" + text.replace(",", "") 
				+ "}}}";
	}

}
