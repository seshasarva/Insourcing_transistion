package com.insourcing.config;

public class CommonConstants {
	
	public static final String SECRET_KEY = "password";
	
	public static final String PRIMARY_KEY = "emailId";
	
	public static final String COUNTRY_INDIA = "India";
	
	public static final String COUNTRY_US = "US";
	
	public static final String ENCRYPT_PWD = "U2FsdGVkX1+mmOxAgPzxybWNL0PccWdp4oN7OouMEek=";

	public static final String KEY = "dbpass";
	
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
	public static String[] HEADERs = { "First Name", "Middle Name", "Last Name", "Email ID", "Create Password" };
	
	public static String SHEET = "Sheet1";
	
	public static String[] AF_REPORT_HEADER = { "Candidate Unique Id", "Candidate Name", "Candidate E-mail",
			"Candidate Contact #", "Candidate Address", "Work Authorization (Y / N)", "Sponsorship  (Y / N)",
			"Application Status", "Resume Uploaded (Y / N)", "Technology Profeciency", "Registration Date",
			"Application Submitted Date", "Current Work Location" };

	public static String[] EDU_EMP_REPORT_HEADER = { "Candidate Unique Id", "Candidate Name", "Highest Education",
			"Total Years of Experience", "Total Years of Relevant Experience", "Past Employers",
			"Past Employer Start Date\r\n" + "MM-DD-YYYY", "Past Employer End Date\r\n" + "MM-DD-YYYY",
			"Prior Association with TCS (Y / N)" };

	public static String[] OFFER_RET_REPORT_HEADER = { "Candidate Unique Id", "Candidate Name", "Exemption Status",
			"Offer Creation Date", "Offer Release Date", "Offer Acceptance", "Offer Acceptance Date", "Base", "Bonus",
			"Severance", "Retention Bonus (Y / N)", "Retention Bonus Quantum (Bonus$)" };
	
	public static String[] INDIA_REPORT_HEADER = { "Applicant Id", "Title", "First Name", "Last Name", "User Mail", "Offer Letter Grade", "Offer Letter Status",
			"Application Form Completion Status", "Appointment Letter Status" };

}
