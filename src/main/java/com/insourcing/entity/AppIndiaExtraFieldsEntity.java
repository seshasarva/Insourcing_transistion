package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.insourcing.model.AppExtraFieldName;

@Entity
@Table(name = "app_india_extra_fields")
public class AppIndiaExtraFieldsEntity {

	@Id
	@Column(name = "deal_id", nullable = false)
	private String dealId;
	@Column(name = "emailid")
	private boolean emailId;
	@Column(name = "father_name")
	private boolean fatherName;
	@Column(name = "dob")
	private boolean dob;
	@Column(name = "gender")
	private boolean gender;
	@Column(name = "nationality")
	private boolean nationality;
	@Column(name = "blood_group")
	private boolean bloodGroup;
	@Column(name = "valid_workpermit")
	private boolean validWorkPermit;
	@Column(name = "linkedin")
	private boolean linkedInUrl;
	@Column(name = "twitter")
	private boolean twitterUrl;
	@Column(name = "facebook")
	private boolean facebookUrl;
	@Column(name = "pan_card")
	private boolean panCard;
	@Column(name = "aadhar_card")
	private boolean aadharCard;
	@Column(name = "skills")
	private boolean skills;
	@Column(name = "pref_location")
	private boolean preferredLocation;
	@Column(name = "direct_source")
	private boolean directSource;
	@Column(name = "residence_country")
	private boolean residenceCountry;
	@Column(name = "known_language")
	private boolean languagesKnown;
	@Column(name = "speak")
	private boolean speak;
	@Column(name = "read")
	private boolean read;
	@Column(name = "write")
	private boolean write;
	@Column(name = "civil_criminal_Case")
	private boolean civilCriminalCase;
	@Column(name = "disciplinary_malpractices")
	private boolean disciplinaryMalPractices;
	@Column(name = "permanent_address")
	private boolean permanentAdress;
	@Column(name = "city")
	private boolean city;
	@Column(name = "state")
	private boolean state;
	@Column(name = "country")
	private boolean country;
	@Column(name = "pinCode")
	private boolean pinCode;
	@Column(name = "alternate_contact")
	private boolean alternateContact;
	@Column(name = "same_present_address")
	private boolean samePresentAddress;
	@Column(name = "degree_diploma")
	private boolean degreeDiploma;
	@Column(name = "major_subject")
	private boolean majorSubject;
	@Column(name = "university")
	private boolean university;
	@Column(name = "college")
	private boolean college;
	@Column(name = "course_type")
	private boolean courseType;
	@Column(name = "course_duration")
	private boolean courseDuration;
	@Column(name = "marks")
	private boolean marks;
	@Column(name = "currently_employed")
	private boolean currentlyEmployed;
	@Column(name = "notice_period")
	private boolean noticePeriod;
	@Column(name = "company_name")
	private boolean companyName;
	@Column(name = "company_address")
	private boolean companyAddress;
	@Column(name = "comp_work_duration")
	private boolean compWorkDuration;
	@Column(name = "designation")
	private boolean designation;
	@Column(name = "gross_salary")
	private boolean grossSalary;
	@Column(name = "employee_id")
	private boolean employeeId;
	@Column(name = "it_experience")
	private boolean itExperience;
	@Column(name = "nonit_experience")
	private boolean nonItExperience;
	@Column(name = "defined_experience")
	private boolean definedExperience;
	@Column(name = "current_service_bond")
	private boolean currentServiceBond;
	@Column(name = "service_bond_details")
	private boolean serviceBondDetails;
	@Column(name = "relative_tcs")
	private boolean tcsRelative;
	@Column(name = "expectedSalary")
	private boolean expectedSalary;
	@Column(name = "criminalCase1")
	private boolean criminalCase1;
	@Column(name = "malpractice1")
	private boolean malpractice1;
	@Column(name = "permcity")
	private boolean permcity;
	@Column(name = "permstate")
	private boolean permstate;
	@Column(name = "permcountry")
	private boolean permcountry;
	@Column(name = "permpinCode")
	private boolean permpinCode;
	@Column(name = "presentAddress")
	private boolean presentAddress;

	@Transient
	private AppExtraFieldName fieldOne;
	@Transient
	private AppExtraFieldName fieldTwo;
	@Transient
	private AppExtraFieldName fieldThree;
	@Transient
	private AppExtraFieldName fieldFour;
	@Transient
	private AppExtraFieldName fieldFive;
	@Transient
	private AppExtraFieldName fieldSix;
	@Transient
	private AppExtraFieldName fieldSeven;
	@Transient
	private AppExtraFieldName fieldEight;
	@Transient
	private AppExtraFieldName fieldNine;
	@Transient
	private AppExtraFieldName fieldTen;
	@Column(name = "field1")
	private String extraFieldOne;
	@Column(name = "field2")
	private String extraFieldTwo;
	@Column(name = "field3")
	private String extraFieldThree;
	@Column(name = "field4")
	private String extraFieldFour;
	@Column(name = "field5")
	private String extraFieldFive;
	@Column(name = "field6")
	private String extraFieldSix;
	@Column(name = "field7")
	private String extraFieldSeven;
	@Column(name = "field8")
	private String extraFieldEight;
	@Column(name = "field9")
	private String extraFieldNine;
	@Column(name = "field10")
	private String extraFieldTen;

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

	public boolean isEmailId() {
		return emailId;
	}

	public void setEmailId(boolean emailId) {
		this.emailId = emailId;
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

	public AppIndiaExtraFieldsEntity() {
		super();
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

	@Override
	public String toString() {
		return "AppIndiaExtraFieldsEntity [dealId=" + dealId + ", emailId=" + emailId + ", fatherName=" + fatherName
				+ ", dob=" + dob + ", gender=" + gender + ", nationality=" + nationality + ", bloodGroup=" + bloodGroup
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
				+ expectedSalary + ", criminalCase1=" + criminalCase1 + ", malpractice1=" + malpractice1 + ", permcity="
				+ permcity + ", permstate=" + permstate + ", permcountry=" + permcountry + ", permpinCode="
				+ permpinCode + ", presentAddress=" + presentAddress + ", fieldOne=" + fieldOne + ", fieldTwo="
				+ fieldTwo + ", fieldThree=" + fieldThree + ", fieldFour=" + fieldFour + ", fieldFive=" + fieldFive
				+ ", fieldSix=" + fieldSix + ", fieldSeven=" + fieldSeven + ", fieldEight=" + fieldEight
				+ ", fieldNine=" + fieldNine + ", fieldTen=" + fieldTen + "]";
	}
}
