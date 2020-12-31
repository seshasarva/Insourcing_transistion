package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.insourcing.model.AppExtraFieldName;

@Entity
@Table(name = "app_us_extra_fields")
public class AppUsExtraFieldsEntity {

	@Id
	@Column(name = "deal_id", nullable = false)
	private String dealId;
	@Column(name = "emailid")
	private boolean emailid;
	@Column(name = "appflag")
	private boolean appflag;
	@Column(name = "resume_status")
	private boolean resumeStatus;
	@Column(name = "app_completed_date")
	private boolean appCompletedDate;;
	@Column(name = "street_address")
	private boolean streetAddress;
	@Column(name = "apartment_unit")
	private boolean apartmentUnit;
	@Column(name = "state")
	private boolean state;
	@Column(name = "zipCode")
	private boolean zipCode;
	@Column(name = "date")
	private boolean date;
	@Column(name = "date_available")
	private boolean dateAvailable;
	@Column(name = "current_work_location")
	private boolean currentWorkLocation;
	@Column(name = "total_exp")
	private boolean totalExp;
	@Column(name = "total_relevant_exp")
	private boolean totalRelExp;
	@Column(name = "under_18_provide_work_permit")
	private boolean under18ProvideWorkPermit;
	@Column(name = "offer_emp_extend_demonstrate_work_in_US")
	private boolean offerEmpExtDemWorkUS;
	@Column(name = "require_sponsorship")
	private boolean reqSponsorship;
	@Column(name = "ex_TCS_employee")
	private boolean exTCSEmployee;
	@Column(name = "if_yes_when")
	private boolean ifYesWhen;
	@Column(name = "com")
	private boolean com;
	@Column(name = "com_phone")
	private boolean comPhone;
	@Column(name = "com_address")
	private boolean comAddress;
	@Column(name = "com_supervisor")
	private boolean comSupervisor;
	@Column(name = "com_job_title")
	private boolean comJobTitle;
	@Column(name = "com_responsibilities")
	private boolean comResponsibilities;
	@Column(name = "com_from")
	private boolean comFrom;
	@Column(name = "com_to")
	private boolean comTo;
	@Column(name = "com_reason_for_leaving")
	private boolean comReasonForLeaving;
	@Column(name = "com_contact_supervisor_ref")
	private boolean comMayContactSupervisorRef;
	@Column(name = "hs_address")
	private boolean hsAddress;
	@Column(name = "hs_graduate")
	private boolean hsGraduate;
	@Column(name = "hs_degree")
	private boolean hsDegree;
	@Column(name = "hs_cos")
	private boolean hsCos;
	@Column(name = "hs_GPA_scale")
	private boolean hsGPAScale;
	@Column(name = "associate_address")
	private boolean assosiateAddress;
	@Column(name = "associate_graduate")
	private boolean assosiateGraduate;
	@Column(name = "associate_degree")
	private boolean assosiateDegree;
	@Column(name = "associate_cos")
	private boolean assosiateCos;
	@Column(name = "associate_GPA_scale")
	private boolean associateGPAScale;
	@Column(name = "bachelor_address")
	private boolean bachelorAddress;
	@Column(name = "bachelor_graduate")
	private boolean bachelorGraduate;
	@Column(name = "bachelor_degree")
	private boolean bachelorDegree;
	@Column(name = "bachelor_cos")
	private boolean bachelorCos;
	@Column(name = "bachelor_GPA_scale")
	private boolean bachelorGPAScale;
	@Column(name = "master_address")
	private boolean masterAddress;
	@Column(name = "master_graduate")
	private boolean masterGraduate;
	@Column(name = "master_degree")
	private boolean masterDegree;
	@Column(name = "master_cos")
	private boolean masterCos;
	@Column(name = "master_GPA_scale")
	private boolean masterGPAScale;
	@Column(name = "doctoral_address")
	private boolean doctoralAddress;
	@Column(name = "doctoral_graduate")
	private boolean doctoralGraduate;
	@Column(name = "doctoral_degree")
	private boolean doctoralDegree;
	@Column(name = "doctoral_cos")
	private boolean doctoralCos;
	@Column(name = "doctoral_GPA_scale")
	private boolean doctoralGPAScale;
	@Column(name = "others_address")
	private boolean othersAddress;
	@Column(name = "others_graduate")
	private boolean othersGraduate;
	@Column(name = "others_degree")
	private boolean othersDegree;
	@Column(name = "others_cos")
	private boolean othersCos;
	@Column(name = "others_GPA_scale")
	private boolean othersGPAScale;
	@Column(name = "tech_prof", length = 500)
	private boolean techProf;
	@Column(name = "ref_fullname")
	private boolean refFullName;
	@Column(name = "ref_relationship")
	private boolean refRelationship;
	@Column(name = "ref_company")
	private boolean refCompany;
	@Column(name = "ref_phone")
	private boolean ref_Phone;
	@Column(name = "ref_email")
	private boolean refEmail;
	@Column(name = "ref_address")
	private boolean refAddress;
	@Column(name = "rel_mili_training_exp")
	private boolean relMiliTrainingExp;
	@Column(name = "disclaimer_sign")
	private boolean disclaimerSign;
	@Column(name = "name")
	private boolean name;
	@Column(name = "signature")
	private boolean signature;
	@Column(name = "date1")
	private boolean date1;
	@Column(name = "education")
	private boolean education;
	@Column(name = "associateInsName")
	private boolean associateInsName;
	@Column(name = "bachelorInsName")
	private boolean bachelorInsName;
	@Column(name = "masterInsName")
	private boolean masterInsName;
	@Column(name = "doctoralInsName")
	private boolean doctoralInsName;
	@Column(name = "otherInsName")
	private boolean otherInsName;
	@Column(name = "hsInsName")
	private boolean hsInsName;

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

	public AppUsExtraFieldsEntity() {
		super();
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public boolean isEmailid() {
		return emailid;
	}

	public void setEmailid(boolean emailid) {
		this.emailid = emailid;
	}

	public boolean isAppflag() {
		return appflag;
	}

	public void setAppflag(boolean appflag) {
		this.appflag = appflag;
	}

	public boolean isResumeStatus() {
		return resumeStatus;
	}

	public void setResumeStatus(boolean resumeStatus) {
		this.resumeStatus = resumeStatus;
	}

	public boolean isAppCompletedDate() {
		return appCompletedDate;
	}

	public void setAppCompletedDate(boolean appCompletedDate) {
		this.appCompletedDate = appCompletedDate;
	}

	public boolean isStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(boolean streetAddress) {
		this.streetAddress = streetAddress;
	}

	public boolean isApartmentUnit() {
		return apartmentUnit;
	}

	public void setApartmentUnit(boolean apartmentUnit) {
		this.apartmentUnit = apartmentUnit;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isZipCode() {
		return zipCode;
	}

	public void setZipCode(boolean zipCode) {
		this.zipCode = zipCode;
	}

	public boolean isDate() {
		return date;
	}

	public void setDate(boolean date) {
		this.date = date;
	}

	public boolean isDateAvailable() {
		return dateAvailable;
	}

	public void setDateAvailable(boolean dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	public boolean isCurrentWorkLocation() {
		return currentWorkLocation;
	}

	public void setCurrentWorkLocation(boolean currentWorkLocation) {
		this.currentWorkLocation = currentWorkLocation;
	}

	public boolean isTotalExp() {
		return totalExp;
	}

	public void setTotalExp(boolean totalExp) {
		this.totalExp = totalExp;
	}

	public boolean isTotalRelExp() {
		return totalRelExp;
	}

	public void setTotalRelExp(boolean totalRelExp) {
		this.totalRelExp = totalRelExp;
	}

	public boolean isUnder18ProvideWorkPermit() {
		return under18ProvideWorkPermit;
	}

	public void setUnder18ProvideWorkPermit(boolean under18ProvideWorkPermit) {
		this.under18ProvideWorkPermit = under18ProvideWorkPermit;
	}

	public boolean isOfferEmpExtDemWorkUS() {
		return offerEmpExtDemWorkUS;
	}

	public void setOfferEmpExtDemWorkUS(boolean offerEmpExtDemWorkUS) {
		this.offerEmpExtDemWorkUS = offerEmpExtDemWorkUS;
	}

	public boolean isReqSponsorship() {
		return reqSponsorship;
	}

	public void setReqSponsorship(boolean reqSponsorship) {
		this.reqSponsorship = reqSponsorship;
	}

	public boolean isExTCSEmployee() {
		return exTCSEmployee;
	}

	public void setExTCSEmployee(boolean exTCSEmployee) {
		this.exTCSEmployee = exTCSEmployee;
	}

	public boolean isIfYesWhen() {
		return ifYesWhen;
	}

	public void setIfYesWhen(boolean ifYesWhen) {
		this.ifYesWhen = ifYesWhen;
	}

	public boolean isCom() {
		return com;
	}

	public void setCom(boolean com) {
		this.com = com;
	}

	public boolean isComPhone() {
		return comPhone;
	}

	public void setComPhone(boolean comPhone) {
		this.comPhone = comPhone;
	}

	public boolean isComAddress() {
		return comAddress;
	}

	public void setComAddress(boolean comAddress) {
		this.comAddress = comAddress;
	}

	public boolean isComSupervisor() {
		return comSupervisor;
	}

	public void setComSupervisor(boolean comSupervisor) {
		this.comSupervisor = comSupervisor;
	}

	public boolean isComJobTitle() {
		return comJobTitle;
	}

	public void setComJobTitle(boolean comJobTitle) {
		this.comJobTitle = comJobTitle;
	}

	public boolean isComResponsibilities() {
		return comResponsibilities;
	}

	public void setComResponsibilities(boolean comResponsibilities) {
		this.comResponsibilities = comResponsibilities;
	}

	public boolean getComFrom() {
		return comFrom;
	}

	public void setComFrom(boolean comFrom) {
		this.comFrom = comFrom;
	}

	public boolean getComTo() {
		return comTo;
	}

	public void setComTo(boolean comTo) {
		this.comTo = comTo;
	}

	public boolean isComReasonForLeaving() {
		return comReasonForLeaving;
	}

	public void setComReasonForLeaving(boolean comReasonForLeaving) {
		this.comReasonForLeaving = comReasonForLeaving;
	}

	public boolean isComMayContactSupervisorRef() {
		return comMayContactSupervisorRef;
	}

	public void setComMayContactSupervisorRef(boolean comMayContactSupervisorRef) {
		this.comMayContactSupervisorRef = comMayContactSupervisorRef;
	}

	public boolean isHsAddress() {
		return hsAddress;
	}

	public void setHsAddress(boolean hsAddress) {
		this.hsAddress = hsAddress;
	}

	public boolean isHsGraduate() {
		return hsGraduate;
	}

	public void setHsGraduate(boolean hsGraduate) {
		this.hsGraduate = hsGraduate;
	}

	public boolean isHsDegree() {
		return hsDegree;
	}

	public void setHsDegree(boolean hsDegree) {
		this.hsDegree = hsDegree;
	}

	public boolean isHsCos() {
		return hsCos;
	}

	public void setHsCos(boolean hsCos) {
		this.hsCos = hsCos;
	}

	public boolean isHsGPAScale() {
		return hsGPAScale;
	}

	public void setHsGPAScale(boolean hsGPAScale) {
		this.hsGPAScale = hsGPAScale;
	}

	public boolean isAssosiateAddress() {
		return assosiateAddress;
	}

	public void setAssosiateAddress(boolean assosiateAddress) {
		this.assosiateAddress = assosiateAddress;
	}

	public boolean isAssosiateGraduate() {
		return assosiateGraduate;
	}

	public void setAssosiateGraduate(boolean assosiateGraduate) {
		this.assosiateGraduate = assosiateGraduate;
	}

	public boolean isAssosiateDegree() {
		return assosiateDegree;
	}

	public void setAssosiateDegree(boolean assosiateDegree) {
		this.assosiateDegree = assosiateDegree;
	}

	public boolean isAssosiateCos() {
		return assosiateCos;
	}

	public void setAssosiateCos(boolean assosiateCos) {
		this.assosiateCos = assosiateCos;
	}

	public boolean isAssociateGPAScale() {
		return associateGPAScale;
	}

	public void setAssociateGPAScale(boolean associateGPAScale) {
		this.associateGPAScale = associateGPAScale;
	}

	public boolean isBachelorAddress() {
		return bachelorAddress;
	}

	public void setBachelorAddress(boolean bachelorAddress) {
		this.bachelorAddress = bachelorAddress;
	}

	public boolean isBachelorGraduate() {
		return bachelorGraduate;
	}

	public void setBachelorGraduate(boolean bachelorGraduate) {
		this.bachelorGraduate = bachelorGraduate;
	}

	public boolean isBachelorDegree() {
		return bachelorDegree;
	}

	public void setBachelorDegree(boolean bachelorDegree) {
		this.bachelorDegree = bachelorDegree;
	}

	public boolean isBachelorCos() {
		return bachelorCos;
	}

	public void setBachelorCos(boolean bachelorCos) {
		this.bachelorCos = bachelorCos;
	}

	public boolean isBachelorGPAScale() {
		return bachelorGPAScale;
	}

	public void setBachelorGPAScale(boolean bachelorGPAScale) {
		this.bachelorGPAScale = bachelorGPAScale;
	}

	public boolean isMasterAddress() {
		return masterAddress;
	}

	public void setMasterAddress(boolean masterAddress) {
		this.masterAddress = masterAddress;
	}

	public boolean isMasterGraduate() {
		return masterGraduate;
	}

	public void setMasterGraduate(boolean masterGraduate) {
		this.masterGraduate = masterGraduate;
	}

	public boolean isMasterDegree() {
		return masterDegree;
	}

	public void setMasterDegree(boolean masterDegree) {
		this.masterDegree = masterDegree;
	}

	public boolean isMasterCos() {
		return masterCos;
	}

	public void setMasterCos(boolean masterCos) {
		this.masterCos = masterCos;
	}

	public boolean isMasterGPAScale() {
		return masterGPAScale;
	}

	public void setMasterGPAScale(boolean masterGPAScale) {
		this.masterGPAScale = masterGPAScale;
	}

	public boolean isDoctoralAddress() {
		return doctoralAddress;
	}

	public void setDoctoralAddress(boolean doctoralAddress) {
		this.doctoralAddress = doctoralAddress;
	}

	public boolean isDoctoralGraduate() {
		return doctoralGraduate;
	}

	public void setDoctoralGraduate(boolean doctoralGraduate) {
		this.doctoralGraduate = doctoralGraduate;
	}

	public boolean isDoctoralDegree() {
		return doctoralDegree;
	}

	public void setDoctoralDegree(boolean doctoralDegree) {
		this.doctoralDegree = doctoralDegree;
	}

	public boolean isDoctoralCos() {
		return doctoralCos;
	}

	public void setDoctoralCos(boolean doctoralCos) {
		this.doctoralCos = doctoralCos;
	}

	public boolean isDoctoralGPAScale() {
		return doctoralGPAScale;
	}

	public void setDoctoralGPAScale(boolean doctoralGPAScale) {
		this.doctoralGPAScale = doctoralGPAScale;
	}

	public boolean isOthersAddress() {
		return othersAddress;
	}

	public void setOthersAddress(boolean othersAddress) {
		this.othersAddress = othersAddress;
	}

	public boolean isOthersGraduate() {
		return othersGraduate;
	}

	public void setOthersGraduate(boolean othersGraduate) {
		this.othersGraduate = othersGraduate;
	}

	public boolean isOthersDegree() {
		return othersDegree;
	}

	public void setOthersDegree(boolean othersDegree) {
		this.othersDegree = othersDegree;
	}

	public boolean isOthersCos() {
		return othersCos;
	}

	public void setOthersCos(boolean othersCos) {
		this.othersCos = othersCos;
	}

	public boolean isOthersGPAScale() {
		return othersGPAScale;
	}

	public void setOthersGPAScale(boolean othersGPAScale) {
		this.othersGPAScale = othersGPAScale;
	}

	public boolean isTechProf() {
		return techProf;
	}

	public void setTechProf(boolean techProf) {
		this.techProf = techProf;
	}

	public boolean isRefFullName() {
		return refFullName;
	}

	public void setRefFullName(boolean refFullName) {
		this.refFullName = refFullName;
	}

	public boolean isRefRelationship() {
		return refRelationship;
	}

	public void setRefRelationship(boolean refRelationship) {
		this.refRelationship = refRelationship;
	}

	public boolean isRefCompany() {
		return refCompany;
	}

	public void setRefCompany(boolean refCompany) {
		this.refCompany = refCompany;
	}

	public boolean isRef_Phone() {
		return ref_Phone;
	}

	public void setRef_Phone(boolean ref_Phone) {
		this.ref_Phone = ref_Phone;
	}

	public boolean isRefEmail() {
		return refEmail;
	}

	public void setRefEmail(boolean refEmail) {
		this.refEmail = refEmail;
	}

	public boolean isRefAddress() {
		return refAddress;
	}

	public void setRefAddress(boolean refAddress) {
		this.refAddress = refAddress;
	}

	public boolean isRelMiliTrainingExp() {
		return relMiliTrainingExp;
	}

	public void setRelMiliTrainingExp(boolean relMiliTrainingExp) {
		this.relMiliTrainingExp = relMiliTrainingExp;
	}

	public boolean isDisclaimerSign() {
		return disclaimerSign;
	}

	public void setDisclaimerSign(boolean disclaimerSign) {
		this.disclaimerSign = disclaimerSign;
	}

	public boolean isName() {
		return name;
	}

	public void setName(boolean name) {
		this.name = name;
	}

	public boolean isSignature() {
		return signature;
	}

	public void setSignature(boolean signature) {
		this.signature = signature;
	}

	public boolean isDate1() {
		return date1;
	}

	public void setDate1(boolean date1) {
		this.date1 = date1;
	}

	public boolean isEducation() {
		return education;
	}

	public void setEducation(boolean education) {
		this.education = education;
	}

	public boolean isAssociateInsName() {
		return associateInsName;
	}

	public void setAssociateInsName(boolean associateInsName) {
		this.associateInsName = associateInsName;
	}

	public boolean isBachelorInsName() {
		return bachelorInsName;
	}

	public void setBachelorInsName(boolean bachelorInsName) {
		this.bachelorInsName = bachelorInsName;
	}

	public boolean isMasterInsName() {
		return masterInsName;
	}

	public void setMasterInsName(boolean masterInsName) {
		this.masterInsName = masterInsName;
	}

	public boolean isDoctoralInsName() {
		return doctoralInsName;
	}

	public void setDoctoralInsName(boolean doctoralInsName) {
		this.doctoralInsName = doctoralInsName;
	}

	public boolean isOtherInsName() {
		return otherInsName;
	}

	public void setOtherInsName(boolean otherInsName) {
		this.otherInsName = otherInsName;
	}

	public boolean isHsInsName() {
		return hsInsName;
	}

	public void setHsInsName(boolean hsInsName) {
		this.hsInsName = hsInsName;
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
		return "AppUsExtraFieldsEntity [dealId=" + dealId + ", emailid=" + emailid + ", appflag=" + appflag
				+ ", resumeStatus=" + resumeStatus + ", appCompletedDate=" + appCompletedDate + ", streetAddress="
				+ streetAddress + ", apartmentUnit=" + apartmentUnit + ", state=" + state + ", zipCode=" + zipCode
				+ ", date=" + date + ", dateAvailable=" + dateAvailable + ", currentWorkLocation=" + currentWorkLocation
				+ ", totalExp=" + totalExp + ", totalRelExp=" + totalRelExp + ", under18ProvideWorkPermit="
				+ under18ProvideWorkPermit + ", offerEmpExtDemWorkUS=" + offerEmpExtDemWorkUS + ", reqSponsorship="
				+ reqSponsorship + ", exTCSEmployee=" + exTCSEmployee + ", ifYesWhen=" + ifYesWhen + ", com=" + com
				+ ", comPhone=" + comPhone + ", comAddress=" + comAddress + ", comSupervisor=" + comSupervisor
				+ ", comJobTitle=" + comJobTitle + ", comResponsibilities=" + comResponsibilities + ", comFrom="
				+ comFrom + ", comTo=" + comTo + ", comReasonForLeaving=" + comReasonForLeaving
				+ ", comMayContactSupervisorRef=" + comMayContactSupervisorRef + ", hsAddress=" + hsAddress
				+ ", hsGraduate=" + hsGraduate + ", hsDegree=" + hsDegree + ", hsCos=" + hsCos + ", hsGPAScale="
				+ hsGPAScale + ", assosiateAddress=" + assosiateAddress + ", assosiateGraduate=" + assosiateGraduate
				+ ", assosiateDegree=" + assosiateDegree + ", assosiateCos=" + assosiateCos + ", associateGPAScale="
				+ associateGPAScale + ", bachelorAddress=" + bachelorAddress + ", bachelorGraduate=" + bachelorGraduate
				+ ", bachelorDegree=" + bachelorDegree + ", bachelorCos=" + bachelorCos + ", bachelorGPAScale="
				+ bachelorGPAScale + ", masterAddress=" + masterAddress + ", masterGraduate=" + masterGraduate
				+ ", masterDegree=" + masterDegree + ", masterCos=" + masterCos + ", masterGPAScale=" + masterGPAScale
				+ ", doctoralAddress=" + doctoralAddress + ", doctoralGraduate=" + doctoralGraduate
				+ ", doctoralDegree=" + doctoralDegree + ", doctoralCos=" + doctoralCos + ", doctoralGPAScale="
				+ doctoralGPAScale + ", othersAddress=" + othersAddress + ", othersGraduate=" + othersGraduate
				+ ", othersDegree=" + othersDegree + ", othersCos=" + othersCos + ", othersGPAScale=" + othersGPAScale
				+ ", techProf=" + techProf + ", refFullName=" + refFullName + ", refRelationship=" + refRelationship
				+ ", refCompany=" + refCompany + ", ref_Phone=" + ref_Phone + ", refEmail=" + refEmail + ", refAddress="
				+ refAddress + ", relMiliTrainingExp=" + relMiliTrainingExp + ", disclaimerSign=" + disclaimerSign
				+ ", name=" + name + ", signature=" + signature + ", date1=" + date1 + ", education=" + education
				+ ", associateInsName=" + associateInsName + ", bachelorInsName=" + bachelorInsName + ", masterInsName="
				+ masterInsName + ", doctoralInsName=" + doctoralInsName + ", otherInsName=" + otherInsName
				+ ", hsInsName=" + hsInsName + ", fieldOne=" + fieldOne + ", fieldTwo=" + fieldTwo + ", fieldThree="
				+ fieldThree + ", fieldFour=" + fieldFour + ", fieldFive=" + fieldFive + ", fieldSix=" + fieldSix
				+ ", fieldSeven=" + fieldSeven + ", fieldEight=" + fieldEight + ", fieldNine=" + fieldNine
				+ ", fieldTen=" + fieldTen + ", extraFieldOne=" + extraFieldOne + ", extraFieldTwo=" + extraFieldTwo
				+ ", extraFieldThree=" + extraFieldThree + ", extraFieldFour=" + extraFieldFour + ", extraFieldFive="
				+ extraFieldFive + ", extraFieldSix=" + extraFieldSix + ", extraFieldSeven=" + extraFieldSeven
				+ ", extraFieldEight=" + extraFieldEight + ", extraFieldNine=" + extraFieldNine + ", extraFieldTen="
				+ extraFieldTen + "]";
	}

}
