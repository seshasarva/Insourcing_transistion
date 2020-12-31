package com.insourcing.model;

public class AppIndiaExtraFieldsRequest {

	private String dealId;
	private boolean fatherName;
	private boolean dob;
//	Gender
	private boolean gender;
//	Nationality
	private boolean nationality;
//	Blood Group
	private boolean bloodGroup;
//	"Do You have a valid work permit?
	private boolean validWorkPermit;
//	LinkedIn profile URL
	private boolean linkedInUrl;
//	Twitter profile URL
	private boolean twitterUrl;
//	Facebook profile URL
	private boolean facebookUrl;
//	PAN Card No.
	private boolean panCard;
//	Aadhar Card
	private boolean aadharCard;
//	Skills
	private boolean skills;
//	Preferred Location
	private boolean preferredLocation;
//	Direct Source Detailing
	private boolean directSource;
//	Country of Residence
	private boolean residenceCountry;
//	LANGUAGES KNOWN
	private boolean languagesKnown;
//	Speak
	private boolean speak;
//	Read
	private boolean read;
//	Write
	private boolean write;
//	SELF DECLARATION
//	Are you involved in any pending and / or closed Civil / Criminal / case / proceedings / charges / enquiry prior to joining TCS ?
	private boolean civilCriminalCase;
//	Are you involved in any pending and / or closed Disciplinary / malpractices and / or any other charges / proceedings / enquiry/ case pending against me in any University or any other educational authority / institution prior to joining TCS ?
	private boolean disciplinaryMalPractices;
//	If the answer to any of the above mentioned question is YES give full particulars of the case / arrest /detention / fine /conviction / sentence / punishment etc. and / or the nature of the case pending in the Court / University / Educational authority etc. at the time of filling this form.

//	ADDRESS DETAILS
//	Present Address
	private boolean permanentAdress;
//	City:
	private boolean city;
//	State / Region /Province :
	private boolean state;
//	Country:
	private boolean country;
//	Pin Code:
	private boolean pinCode;
//	Alternate Contact:
	private boolean alternateContact;
//	Is the Present and Permanent Address same:
	private boolean samePresentAddress;
//	ACADEMIC DETAILS
//	Degree/Diploma
	private boolean degreeDiploma;
//	Specialization/Major Subject
	private boolean majorSubject;
//	University/Institute
	private boolean university;
//	College
	private boolean college;
//	Course Type
	private boolean courseType;
//	Duration From - To
	private boolean courseDuration;
//	% of Marks(Agg. of all semester/ grade obtained)
	private boolean marks;
//	EMPLOYMENT DETAILS
//	Are you currently employed?
	private boolean currentlyEmployed;
//	Tentative Notice Period of the current company:
	private boolean noticePeriod;
//	Company Name
	private boolean companyName;
//	Address of Company
	private boolean companyAddress;
//	Duration (From-To)
	private boolean compWorkDuration;
//	Post/Designation
	private boolean designation;
//	Gross Salary
	private boolean grossSalary;
//	Employee Id
	private boolean employeeId;
//	Total IT Experience
	private boolean itExperience;
//	Total Non IT Experience
	private boolean nonItExperience;
//	Recruiter Defined Experience
	private boolean definedExperience;
//	Are you currently under any Service Bond?
	private boolean currentServiceBond;
//	Service Bond Details
	private boolean serviceBondDetails;
//	RELATIVE DETAILS
//	Do you have relatives in TCS?
	private boolean tcsRelative;
//	JOINING DETAILS
//	Expected Salary
	private boolean expectedSalary;
	private boolean appflag;
	private boolean appCompletedDate;
	private boolean key;
	private boolean criminalCase1;
	private boolean malpractice1;
	private boolean permcity;
	private boolean permstate;
	private boolean permcountry;
	private boolean permpinCode;
	private boolean presentAddress;

	private AppExtraFieldName fieldOne;
	private AppExtraFieldName fieldTwo;
	private AppExtraFieldName fieldThree;
	private AppExtraFieldName fieldFour;
	private AppExtraFieldName fieldFive;
	private AppExtraFieldName fieldSix;
	private AppExtraFieldName fieldSeven;
	private AppExtraFieldName fieldEight;
	private AppExtraFieldName fieldNine;
	private AppExtraFieldName fieldTen;

	// @Column(name = "field1")
	private String extraFieldOne;
	// @Column(name = "field2")
	private String extraFieldTwo;
	// @Column(name = "field3")
	private String extraFieldThree;
	// @Column(name = "field4")
	private String extraFieldFour;
	// @Column(name = "field5")
	private String extraFieldFive;
	// @Column(name = "field6")
	private String extraFieldSix;
	// @Column(name = "field7")
	private String extraFieldSeven;
	// @Column(name = "field8")
	private String extraFieldEight;
	// @Column(name = "field9")
	private String extraFieldNine;
	// @Column(name = "field10")
	private String extraFieldTen;

	public AppIndiaExtraFieldsRequest() {
		super();
	}

	public boolean isFatherName() {
		return fatherName;
	}

	public void setFatherName(boolean fatherName) {
		this.fatherName = fatherName;
	}

	public boolean isDob() {
		return dob;
	}

	public void setDob(boolean dob) {
		this.dob = dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean isNationality() {
		return nationality;
	}

	public void setNationality(boolean nationality) {
		this.nationality = nationality;
	}

	public boolean isBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(boolean bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public boolean isValidWorkPermit() {
		return validWorkPermit;
	}

	public void setValidWorkPermit(boolean validWorkPermit) {
		this.validWorkPermit = validWorkPermit;
	}

	public boolean isLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(boolean linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public boolean isTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(boolean twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public boolean isFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(boolean facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public boolean isPanCard() {
		return panCard;
	}

	public void setPanCard(boolean panCard) {
		this.panCard = panCard;
	}

	public boolean isAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(boolean aadharCard) {
		this.aadharCard = aadharCard;
	}

	public boolean isSkills() {
		return skills;
	}

	public void setSkills(boolean skills) {
		this.skills = skills;
	}

	public boolean isPreferredLocation() {
		return preferredLocation;
	}

	public void setPreferredLocation(boolean preferredLocation) {
		this.preferredLocation = preferredLocation;
	}

	public boolean isDirectSource() {
		return directSource;
	}

	public void setDirectSource(boolean directSource) {
		this.directSource = directSource;
	}

	public boolean isResidenceCountry() {
		return residenceCountry;
	}

	public void setResidenceCountry(boolean residenceCountry) {
		this.residenceCountry = residenceCountry;
	}

	public boolean isLanguagesKnown() {
		return languagesKnown;
	}

	public void setLanguagesKnown(boolean languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

	public boolean isSpeak() {
		return speak;
	}

	public void setSpeak(boolean speak) {
		this.speak = speak;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isWrite() {
		return write;
	}

	public void setWrite(boolean write) {
		this.write = write;
	}

	public boolean isCivilCriminalCase() {
		return civilCriminalCase;
	}

	public void setCivilCriminalCase(boolean civilCriminalCase) {
		this.civilCriminalCase = civilCriminalCase;
	}

	public boolean isDisciplinaryMalPractices() {
		return disciplinaryMalPractices;
	}

	public void setDisciplinaryMalPractices(boolean disciplinaryMalPractices) {
		this.disciplinaryMalPractices = disciplinaryMalPractices;
	}

	public boolean isPermanentAdress() {
		return permanentAdress;
	}

	public void setPermanentAdress(boolean permanentAdress) {
		this.permanentAdress = permanentAdress;
	}

	public boolean isCity() {
		return city;
	}

	public void setCity(boolean city) {
		this.city = city;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isCountry() {
		return country;
	}

	public void setCountry(boolean country) {
		this.country = country;
	}

	public boolean isPinCode() {
		return pinCode;
	}

	public void setPinCode(boolean pinCode) {
		this.pinCode = pinCode;
	}

	public boolean isAlternateContact() {
		return alternateContact;
	}

	public void setAlternateContact(boolean alternateContact) {
		this.alternateContact = alternateContact;
	}

	public boolean isSamePresentAddress() {
		return samePresentAddress;
	}

	public void setSamePresentAddress(boolean samePresentAddress) {
		this.samePresentAddress = samePresentAddress;
	}

	public boolean isDegreeDiploma() {
		return degreeDiploma;
	}

	public void setDegreeDiploma(boolean degreeDiploma) {
		this.degreeDiploma = degreeDiploma;
	}

	public boolean isMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(boolean majorSubject) {
		this.majorSubject = majorSubject;
	}

	public boolean isUniversity() {
		return university;
	}

	public void setUniversity(boolean university) {
		this.university = university;
	}

	public boolean isCollege() {
		return college;
	}

	public void setCollege(boolean college) {
		this.college = college;
	}

	public boolean isCourseType() {
		return courseType;
	}

	public void setCourseType(boolean courseType) {
		this.courseType = courseType;
	}

	public boolean isCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(boolean courseDuration) {
		this.courseDuration = courseDuration;
	}

	public boolean isMarks() {
		return marks;
	}

	public void setMarks(boolean marks) {
		this.marks = marks;
	}

	public boolean isCurrentlyEmployed() {
		return currentlyEmployed;
	}

	public void setCurrentlyEmployed(boolean currentlyEmployed) {
		this.currentlyEmployed = currentlyEmployed;
	}

	public boolean isNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(boolean noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public boolean isCompanyName() {
		return companyName;
	}

	public void setCompanyName(boolean companyName) {
		this.companyName = companyName;
	}

	public boolean isCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(boolean companyAddress) {
		this.companyAddress = companyAddress;
	}

	public boolean isCompWorkDuration() {
		return compWorkDuration;
	}

	public void setCompWorkDuration(boolean compWorkDuration) {
		this.compWorkDuration = compWorkDuration;
	}

	public boolean isDesignation() {
		return designation;
	}

	public void setDesignation(boolean designation) {
		this.designation = designation;
	}

	public boolean isGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(boolean grossSalary) {
		this.grossSalary = grossSalary;
	}

	public boolean isEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(boolean employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isItExperience() {
		return itExperience;
	}

	public void setItExperience(boolean itExperience) {
		this.itExperience = itExperience;
	}

	public boolean isNonItExperience() {
		return nonItExperience;
	}

	public void setNonItExperience(boolean nonItExperience) {
		this.nonItExperience = nonItExperience;
	}

	public boolean isDefinedExperience() {
		return definedExperience;
	}

	public void setDefinedExperience(boolean definedExperience) {
		this.definedExperience = definedExperience;
	}

	public boolean isCurrentServiceBond() {
		return currentServiceBond;
	}

	public void setCurrentServiceBond(boolean currentServiceBond) {
		this.currentServiceBond = currentServiceBond;
	}

	public boolean isServiceBondDetails() {
		return serviceBondDetails;
	}

	public void setServiceBondDetails(boolean serviceBondDetails) {
		this.serviceBondDetails = serviceBondDetails;
	}

	public boolean isTcsRelative() {
		return tcsRelative;
	}

	public void setTcsRelative(boolean tcsRelative) {
		this.tcsRelative = tcsRelative;
	}

	public boolean isExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(boolean expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public boolean isAppflag() {
		return appflag;
	}

	public void setAppflag(boolean appflag) {
		this.appflag = appflag;
	}

	public boolean isAppCompletedDate() {
		return appCompletedDate;
	}

	public void setAppCompletedDate(boolean appCompletedDate) {
		this.appCompletedDate = appCompletedDate;
	}

	public boolean isKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}

	public boolean isCriminalCase1() {
		return criminalCase1;
	}

	public void setCriminalCase1(boolean criminalCase1) {
		this.criminalCase1 = criminalCase1;
	}

	public boolean isMalpractice1() {
		return malpractice1;
	}

	public void setMalpractice1(boolean malpractice1) {
		this.malpractice1 = malpractice1;
	}

	public boolean isPermcity() {
		return permcity;
	}

	public void setPermcity(boolean permcity) {
		this.permcity = permcity;
	}

	public boolean isPermstate() {
		return permstate;
	}

	public void setPermstate(boolean permstate) {
		this.permstate = permstate;
	}

	public boolean isPermcountry() {
		return permcountry;
	}

	public void setPermcountry(boolean permcountry) {
		this.permcountry = permcountry;
	}

	public boolean isPermpinCode() {
		return permpinCode;
	}

	public void setPermpinCode(boolean permpinCode) {
		this.permpinCode = permpinCode;
	}

	public boolean isPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(boolean presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public AppExtraFieldName getFieldOne() {
		return fieldOne;
	}

	public void setFieldOne(AppExtraFieldName fieldOne) {
		this.fieldOne = fieldOne;
	}

	public AppExtraFieldName getFieldTwo() {
		return fieldTwo;
	}

	public void setFieldTwo(AppExtraFieldName fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	public AppExtraFieldName getFieldThree() {
		return fieldThree;
	}

	public void setFieldThree(AppExtraFieldName fieldThree) {
		this.fieldThree = fieldThree;
	}

	public AppExtraFieldName getFieldFour() {
		return fieldFour;
	}

	public void setFieldFour(AppExtraFieldName fieldFour) {
		this.fieldFour = fieldFour;
	}

	public AppExtraFieldName getFieldFive() {
		return fieldFive;
	}

	public void setFieldFive(AppExtraFieldName fieldFive) {
		this.fieldFive = fieldFive;
	}

	public AppExtraFieldName getFieldSix() {
		return fieldSix;
	}

	public void setFieldSix(AppExtraFieldName fieldSix) {
		this.fieldSix = fieldSix;
	}

	public AppExtraFieldName getFieldSeven() {
		return fieldSeven;
	}

	public void setFieldSeven(AppExtraFieldName fieldSeven) {
		this.fieldSeven = fieldSeven;
	}

	public AppExtraFieldName getFieldEight() {
		return fieldEight;
	}

	public void setFieldEight(AppExtraFieldName fieldEight) {
		this.fieldEight = fieldEight;
	}

	public AppExtraFieldName getFieldNine() {
		return fieldNine;
	}

	public void setFieldNine(AppExtraFieldName fieldNine) {
		this.fieldNine = fieldNine;
	}

	public AppExtraFieldName getFieldTen() {
		return fieldTen;
	}

	public void setFieldTen(AppExtraFieldName fieldTen) {
		this.fieldTen = fieldTen;
	}

	public String getExtraFieldOne() {
		return extraFieldOne;
	}

	public void setExtraFieldOne(String extraFieldOne) {
		this.extraFieldOne = extraFieldOne;
	}

	public String getExtraFieldTwo() {
		return extraFieldTwo;
	}

	public void setExtraFieldTwo(String extraFieldTwo) {
		this.extraFieldTwo = extraFieldTwo;
	}

	public String getExtraFieldThree() {
		return extraFieldThree;
	}

	public void setExtraFieldThree(String extraFieldThree) {
		this.extraFieldThree = extraFieldThree;
	}

	public String getExtraFieldFour() {
		return extraFieldFour;
	}

	public void setExtraFieldFour(String extraFieldFour) {
		this.extraFieldFour = extraFieldFour;
	}

	public String getExtraFieldFive() {
		return extraFieldFive;
	}

	public void setExtraFieldFive(String extraFieldFive) {
		this.extraFieldFive = extraFieldFive;
	}

	public String getExtraFieldSix() {
		return extraFieldSix;
	}

	public void setExtraFieldSix(String extraFieldSix) {
		this.extraFieldSix = extraFieldSix;
	}

	public String getExtraFieldSeven() {
		return extraFieldSeven;
	}

	public void setExtraFieldSeven(String extraFieldSeven) {
		this.extraFieldSeven = extraFieldSeven;
	}

	public String getExtraFieldEight() {
		return extraFieldEight;
	}

	public void setExtraFieldEight(String extraFieldEight) {
		this.extraFieldEight = extraFieldEight;
	}

	public String getExtraFieldNine() {
		return extraFieldNine;
	}

	public void setExtraFieldNine(String extraFieldNine) {
		this.extraFieldNine = extraFieldNine;
	}

	public String getExtraFieldTen() {
		return extraFieldTen;
	}

	public void setExtraFieldTen(String extraFieldTen) {
		this.extraFieldTen = extraFieldTen;
	}

	@Override
	public String toString() {
		return "AppIndiaExtraFieldsRequest [dealId=" + dealId + ", fatherName=" + fatherName + ", dob=" + dob
				+ ", gender=" + gender + ", nationality=" + nationality + ", bloodGroup=" + bloodGroup
				+ ", validWorkPermit=" + validWorkPermit + ", linkedInUrl=" + linkedInUrl + ", twitterUrl=" + twitterUrl
				+ ", facebookUrl=" + facebookUrl + ", panCard=" + panCard + ", aadharCard=" + aadharCard + ", skills="
				+ skills + ", preferredLocation=" + preferredLocation + ", directSource=" + directSource
				+ ", residenceCountry=" + residenceCountry + ", languagesKnown=" + languagesKnown + ", speak=" + speak
				+ ", read=" + read + ", write=" + write + ", civilCriminalCase=" + civilCriminalCase
				+ ", disciplinaryMalPractices=" + disciplinaryMalPractices + ", permanentAdress=" + permanentAdress
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pinCode=" + pinCode
				+ ", alternateContact=" + alternateContact + ", samePresentAddress=" + samePresentAddress
				+ ", degreeDiploma=" + degreeDiploma + ", majorSubject=" + majorSubject + ", university=" + university
				+ ", college=" + college + ", courseType=" + courseType + ", courseDuration=" + courseDuration
				+ ", marks=" + marks + ", currentlyEmployed=" + currentlyEmployed + ", noticePeriod=" + noticePeriod
				+ ", companyName=" + companyName + ", companyAddress=" + companyAddress + ", compWorkDuration="
				+ compWorkDuration + ", designation=" + designation + ", grossSalary=" + grossSalary + ", employeeId="
				+ employeeId + ", itExperience=" + itExperience + ", nonItExperience=" + nonItExperience
				+ ", definedExperience=" + definedExperience + ", currentServiceBond=" + currentServiceBond
				+ ", serviceBondDetails=" + serviceBondDetails + ", tcsRelative=" + tcsRelative + ", expectedSalary="
				+ expectedSalary + ", appflag=" + appflag + ", appCompletedDate=" + appCompletedDate + ", key=" + key
				+ ", criminalCase1=" + criminalCase1 + ", malpractice1=" + malpractice1 + ", permcity=" + permcity
				+ ", permstate=" + permstate + ", permcountry=" + permcountry + ", permpinCode=" + permpinCode
				+ ", presentAddress=" + presentAddress + ", fieldOne=" + fieldOne + ", fieldTwo=" + fieldTwo
				+ ", fieldThree=" + fieldThree + ", fieldFour=" + fieldFour + ", fieldFive=" + fieldFive + ", fieldSix="
				+ fieldSix + ", fieldSeven=" + fieldSeven + ", fieldEight=" + fieldEight + ", fieldNine=" + fieldNine
				+ ", fieldTen=" + fieldTen + "]";
	}

}
