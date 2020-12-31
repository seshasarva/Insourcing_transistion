package com.insourcing.entity;

import java.util.Arrays;
import java.util.Date;

public class ApplicationIndiaEntity {

	private String fatherName;
	private String dob;
//	Gender
	private String gender;
//	Nationality
	private String nationality;
//	Blood Group
	private String bloodGroup;
//	"Do You have a valid work permit?
	private String validWorkPermit;
//	LinkedIn profile URL
	private String linkedInUrl;
//	Twitter profile URL
	private String twitterUrl;
//	Facebook profile URL
	private String facebookUrl;
//	PAN Card No.
	private String panCard;
//	Aadhar Card
	private String aadharCard;
//	Skills
	private String skills;
//	Preferred Location
	private String preferredLocation;
//	Direct Source Detailing
	private String directSource;
//	Country of Residence
	private String residenceCountry;
//	LANGUAGES KNOWN
	private String[] languagesKnown;
//	Speak
	private String[] speak;
//	Read
	private String[] read;
//	Write
	private String[] write;
//	SELF DECLARATION
//	Are you involved in any pending and / or closed Civil / Criminal / case / proceedings / charges / enquiry prior to joining TCS ?
	private String civilCriminalCase;
//	Are you involved in any pending and / or closed Disciplinary / malpractices and / or any other charges / proceedings / enquiry/ case pending against me in any University or any other educational authority / institution prior to joining TCS ?
	private String disciplinaryMalPractices;
//	If the answer to any of the above mentioned question is YES give full particulars of the case / arrest /detention / fine /conviction / sentence / punishment etc. and / or the nature of the case pending in the Court / University / Educational authority etc. at the time of filling this form.

//	ADDRESS DETAILS
//	Present Address
	private String permanentAdress;
//	City:
	private String city;
//	State / Region /Province :
	private String state;
//	Country:
	private String country;
//	Pin Code:
	private String pinCode;
//	Alternate Contact:
	private String alternateContact;
//	Is the Present and Permanent Address same:
	private boolean samePresentAddress;
//	ACADEMIC DETAILS
//	Degree/Diploma
	private String[] degreeDiploma;
//	Specialization/Major Subject
	private String[] majorSubject;
//	University/Institute
	private String[] university;
//	College
	private String[] college;
//	Course Type
	private String[] courseType;
//	Duration From - To
	private String[] courseDuration;
//	% of Marks(Agg. of all semester/ grade obtained)
	private String[] marks;
//	EMPLOYMENT DETAILS
//	Are you currently employed?
	private String currentlyEmployed;
//	Tentative Notice Period of the current company:
	private String noticePeriod;
//	Company Name
	private String[] companyName;
//	Address of Company
	private String[] companyAddress;
//	Duration (From-To)
	private String[] compWorkDuration;
//	Post/Designation
	private String[] designation;
//	Gross Salary
	private String[] grossSalary;
//	Employee Id
	private String[] employeeId;
//	Total IT Experience
	private String itExperience;
//	Total Non IT Experience
	private String nonItExperience;
//	Recruiter Defined Experience
	private String definedExperience;
//	Are you currently under any Service Bond?
	private String currentServiceBond;
//	Service Bond Details
	private String serviceBondDetails;
//	RELATIVE DETAILS
//	Do you have relatives in TCS?
	private String tcsRelative;
//	JOINING DETAILS
//	Expected Salary
	private String expectedSalary;
	private boolean appflag;
	private Date appCompletedDate;
	private String key;
	private String criminalCase1;
	private String malpractice1;
	private String permcity;
	private String permstate;
	private String permcountry;
	private String permpinCode;
	private String presentAddress;
	// Extra fields
	private String dealId;
	private String fieldOne;
	private String fieldTwo;
	private String fieldThree;
	private String fieldFour;
	private String fieldFive;
	private String fieldSix;
	private String fieldSeven;
	private String fieldEight;
	private String fieldNine;
	private String fieldTen;

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getFieldOne() {
		return fieldOne;
	}

	public void setFieldOne(String fieldOne) {
		this.fieldOne = fieldOne;
	}

	public String getFieldTwo() {
		return fieldTwo;
	}

	public void setFieldTwo(String fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	public String getFieldThree() {
		return fieldThree;
	}

	public void setFieldThree(String fieldThree) {
		this.fieldThree = fieldThree;
	}

	public String getFieldFour() {
		return fieldFour;
	}

	public void setFieldFour(String fieldFour) {
		this.fieldFour = fieldFour;
	}

	public String getFieldFive() {
		return fieldFive;
	}

	public void setFieldFive(String fieldFive) {
		this.fieldFive = fieldFive;
	}

	public String getFieldSix() {
		return fieldSix;
	}

	public void setFieldSix(String fieldSix) {
		this.fieldSix = fieldSix;
	}

	public String getFieldSeven() {
		return fieldSeven;
	}

	public void setFieldSeven(String fieldSeven) {
		this.fieldSeven = fieldSeven;
	}

	public String getFieldEight() {
		return fieldEight;
	}

	public void setFieldEight(String fieldEight) {
		this.fieldEight = fieldEight;
	}

	public String getFieldNine() {
		return fieldNine;
	}

	public void setFieldNine(String fieldNine) {
		this.fieldNine = fieldNine;
	}

	public String getFieldTen() {
		return fieldTen;
	}

	public void setFieldTen(String fieldTen) {
		this.fieldTen = fieldTen;
	}

	public String getCriminalCase1() {
		return criminalCase1;
	}

	public void setCriminalCase1(String criminalCase1) {
		this.criminalCase1 = criminalCase1;
	}

	public String getMalpractice1() {
		return malpractice1;
	}

	public void setMalpractice1(String malpractice1) {
		this.malpractice1 = malpractice1;
	}

	public String getPermcity() {
		return permcity;
	}

	public void setPermcity(String permcity) {
		this.permcity = permcity;
	}

	public String getPermstate() {
		return permstate;
	}

	public void setPermstate(String permstate) {
		this.permstate = permstate;
	}

	public String getPermcountry() {
		return permcountry;
	}

	public void setPermcountry(String permcountry) {
		this.permcountry = permcountry;
	}

	public String getPermpinCode() {
		return permpinCode;
	}

	public void setPermpinCode(String permpinCode) {
		this.permpinCode = permpinCode;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean getAppflag() {
		return appflag;
	}

	public void setAppflag(boolean appflag) {
		this.appflag = appflag;
	}

	public Date getAppCompletedDate() {
		return appCompletedDate;
	}

	public void setAppCompletedDate(Date appCompletedDate) {
		this.appCompletedDate = appCompletedDate;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getValidWorkPermit() {
		return validWorkPermit;
	}

	public void setValidWorkPermit(String validWorkPermit) {
		this.validWorkPermit = validWorkPermit;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getPreferredLocation() {
		return preferredLocation;
	}

	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}

	public String getDirectSource() {
		return directSource;
	}

	public void setDirectSource(String directSource) {
		this.directSource = directSource;
	}

	public String getResidenceCountry() {
		return residenceCountry;
	}

	public void setResidenceCountry(String residenceCountry) {
		this.residenceCountry = residenceCountry;
	}

	public String[] getLanguagesKnown() {
		return languagesKnown;
	}

	public void setLanguagesKnown(String[] languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

	public String[] getSpeak() {
		return speak;
	}

	public void setSpeak(String[] speak) {
		this.speak = speak;
	}

	public String[] getRead() {
		return read;
	}

	public void setRead(String[] read) {
		this.read = read;
	}

	public String[] getWrite() {
		return write;
	}

	public void setWrite(String[] write) {
		this.write = write;
	}

	public String getCivilCriminalCase() {
		return civilCriminalCase;
	}

	public void setCivilCriminalCase(String civilCriminalCase) {
		this.civilCriminalCase = civilCriminalCase;
	}

	public String getDisciplinaryMalPractices() {
		return disciplinaryMalPractices;
	}

	public void setDisciplinaryMalPractices(String disciplinaryMalPractices) {
		this.disciplinaryMalPractices = disciplinaryMalPractices;
	}

	public String getPermanentAdress() {
		return permanentAdress;
	}

	public void setPermanentAdress(String permanentAdress) {
		this.permanentAdress = permanentAdress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAlternateContact() {
		return alternateContact;
	}

	public void setAlternateContact(String alternateContact) {
		this.alternateContact = alternateContact;
	}

	public boolean isSamePresentAddress() {
		return samePresentAddress;
	}

	public void setSamePresentAddress(boolean samePresentAddress) {
		this.samePresentAddress = samePresentAddress;
	}

	public String[] getDegreeDiploma() {
		return degreeDiploma;
	}

	public void setDegreeDiploma(String[] degreeDiploma) {
		this.degreeDiploma = degreeDiploma;
	}

	public String[] getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(String[] majorSubject) {
		this.majorSubject = majorSubject;
	}

	public String[] getUniversity() {
		return university;
	}

	public void setUniversity(String[] university) {
		this.university = university;
	}

	public String[] getCollege() {
		return college;
	}

	public void setCollege(String[] college) {
		this.college = college;
	}

	public String[] getCourseType() {
		return courseType;
	}

	public void setCourseType(String[] courseType) {
		this.courseType = courseType;
	}

	public String[] getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String[] courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String[] getMarks() {
		return marks;
	}

	public void setMarks(String[] marks) {
		this.marks = marks;
	}

	public String getCurrentlyEmployed() {
		return currentlyEmployed;
	}

	public void setCurrentlyEmployed(String currentlyEmployed) {
		this.currentlyEmployed = currentlyEmployed;
	}

	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public String[] getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String[] companyName) {
		this.companyName = companyName;
	}

	public String[] getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String[] companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String[] getCompWorkDuration() {
		return compWorkDuration;
	}

	public void setCompWorkDuration(String[] compWorkDuration) {
		this.compWorkDuration = compWorkDuration;
	}

	public String[] getDesignation() {
		return designation;
	}

	public void setDesignation(String[] designation) {
		this.designation = designation;
	}

	public String[] getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(String[] grossSalary) {
		this.grossSalary = grossSalary;
	}

	public String[] getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String[] employeeId) {
		this.employeeId = employeeId;
	}

	public String getItExperience() {
		return itExperience;
	}

	public void setItExperience(String itExperience) {
		this.itExperience = itExperience;
	}

	public String getNonItExperience() {
		return nonItExperience;
	}

	public void setNonItExperience(String nonItExperience) {
		this.nonItExperience = nonItExperience;
	}

	public String getDefinedExperience() {
		return definedExperience;
	}

	public void setDefinedExperience(String definedExperience) {
		this.definedExperience = definedExperience;
	}

	public String getCurrentServiceBond() {
		return currentServiceBond;
	}

	public void setCurrentServiceBond(String currentServiceBond) {
		this.currentServiceBond = currentServiceBond;
	}

	public String getServiceBondDetails() {
		return serviceBondDetails;
	}

	public void setServiceBondDetails(String serviceBondDetails) {
		this.serviceBondDetails = serviceBondDetails;
	}

	public String getTcsRelative() {
		return tcsRelative;
	}

	public void setTcsRelative(String tcsRelative) {
		this.tcsRelative = tcsRelative;
	}

	public String getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(String expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	@Override
	public String toString() {
		return "ApplicationIndiaEntity [fatherName=" + fatherName + ", dob=" + dob + ", gender=" + gender
				+ ", nationality=" + nationality + ", bloodGroup=" + bloodGroup + ", validWorkPermit=" + validWorkPermit
				+ ", linkedInUrl=" + linkedInUrl + ", twitterUrl=" + twitterUrl + ", facebookUrl=" + facebookUrl
				+ ", panCard=" + panCard + ", aadharCard=" + aadharCard + ", skills=" + skills + ", preferredLocation="
				+ preferredLocation + ", directSource=" + directSource + ", residenceCountry=" + residenceCountry
				+ ", languagesKnown=" + Arrays.toString(languagesKnown) + ", speak=" + Arrays.toString(speak)
				+ ", read=" + Arrays.toString(read) + ", write=" + Arrays.toString(write) + ", civilCriminalCase="
				+ civilCriminalCase + ", disciplinaryMalPractices=" + disciplinaryMalPractices + ", permanentAdress="
				+ permanentAdress + ", city=" + city + ", state=" + state + ", country=" + country + ", pinCode="
				+ pinCode + ", alternateContact=" + alternateContact + ", samePresentAddress=" + samePresentAddress
				+ ", degreeDiploma=" + Arrays.toString(degreeDiploma) + ", majorSubject="
				+ Arrays.toString(majorSubject) + ", university=" + Arrays.toString(university) + ", college="
				+ Arrays.toString(college) + ", courseType=" + Arrays.toString(courseType) + ", courseDuration="
				+ Arrays.toString(courseDuration) + ", marks=" + Arrays.toString(marks) + ", currentlyEmployed="
				+ currentlyEmployed + ", noticePeriod=" + noticePeriod + ", companyName=" + Arrays.toString(companyName)
				+ ", companyAddress=" + Arrays.toString(companyAddress) + ", compWorkDuration="
				+ Arrays.toString(compWorkDuration) + ", designation=" + Arrays.toString(designation) + ", grossSalary="
				+ Arrays.toString(grossSalary) + ", employeeId=" + Arrays.toString(employeeId) + ", itExperience="
				+ itExperience + ", nonItExperience=" + nonItExperience + ", definedExperience=" + definedExperience
				+ ", currentServiceBond=" + currentServiceBond + ", serviceBondDetails=" + serviceBondDetails
				+ ", tcsRelative=" + tcsRelative + ", expectedSalary=" + expectedSalary + ", appflag=" + appflag
				+ ", appCompletedDate=" + appCompletedDate + ", key=" + key + ", criminalCase1=" + criminalCase1
				+ ", malpractice1=" + malpractice1 + ", permcity=" + permcity + ", permstate=" + permstate
				+ ", permcountry=" + permcountry + ", permpinCode=" + permpinCode + ", presentAddress=" + presentAddress
				+ ", dealId=" + dealId + ", fieldOne=" + fieldOne + ", fieldTwo=" + fieldTwo + ", fieldThree="
				+ fieldThree + ", fieldFour=" + fieldFour + ", fieldFive=" + fieldFive + ", fieldSix=" + fieldSix
				+ ", fieldSeven=" + fieldSeven + ", fieldEight=" + fieldEight + ", fieldNine=" + fieldNine
				+ ", fieldTen=" + fieldTen + "]";
	}

}
