package com.insourcing.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.insourcing.model.EducationModel;

@Entity
@Table(name = "us_app_form")
public class ApplicationUSEntityMap {

	@Id
	@Column(name = "emailid", nullable = false)
	private String emailid;
	@Column(name = "appflag")
	private boolean appflag;
	@Column(name = "resume_status")
	private String resumeStatus;
	@Column(name = "app_completed_date")
	private Date appCompletedDate;
	@Column(name = "street_address")
	private String streetAddress;
	@Column(name = "apartment_unit")
	private String apartmentUnit;
	@Column(name = "state")
	private String state;
	@Column(name = "zipCode")
	private String zipCode;
	@Column(name = "date")
	private Date date;
	@Column(name = "date_available")
	private Date dateAvailable;
	@Column(name = "current_work_location")
	private String currentWorkLocation;
	@Column(name = "total_exp")
	private String totalExp;
	@Column(name = "total_relevant_exp")
	private String totalRelExp;
	@Column(name = "under_18_provide_work_permit")
	private String under18ProvideWorkPermit;
	@Column(name = "offer_emp_extend_demonstrate_work_in_US")
	private String offerEmpExtDemWorkUS;
	@Column(name = "require_sponsorship")
	private String reqSponsorship;
	@Column(name = "ex_TCS_employee")
	private String exTCSEmployee;
	@Column(name = "if_yes_when")
	private String ifYesWhen;
	@Column(name = "com")
	private String[] com;
	@Column(name = "com_phone")
	private String[] comPhone;
	@Column(name = "com_address")
	private String[] comAddress;
	@Column(name = "com_supervisor")
	private String[] comSupervisor;
	@Column(name = "com_job_title")
	private String[] comJobTitle;
	@Column(name = "com_responsibilities")
	private String[] comResponsibilities;
	@Column(name = "com_from")
	private Date[] comFrom;
	@Column(name = "com_to")
	private Date[] comTo;
	@Column(name = "com_reason_for_leaving")
	private String[] comReasonForLeaving;
	@Column(name = "com_contact_supervisor_ref")
	private String[] comMayContactSupervisorRef;
	@Column(name = "hs_address")
	private String hsAddress;
	@Column(name = "hs_graduate")
	private String hsGraduate;
	@Column(name = "hs_degree")
	private String hsDegree;
	@Column(name = "hs_cos")
	private String hsCos;
	@Column(name = "hs_GPA_scale")
	private String hsGPAScale;
	@Column(name = "associate_address")
	private String assosiateAddress;
	@Column(name = "associate_graduate")
	private String assosiateGraduate;
	@Column(name = "associate_degree")
	private String assosiateDegree;
	@Column(name = "associate_cos")
	private String assosiateCos;
	@Column(name = "associate_GPA_scale")
	private String associateGPAScale;
	@Column(name = "bachelor_address")
	private String bachelorAddress;
	@Column(name = "bachelor_graduate")
	private String bachelorGraduate;
	@Column(name = "bachelor_degree")
	private String bachelorDegree;
	@Column(name = "bachelor_cos")
	private String bachelorCos;
	@Column(name = "bachelor_GPA_scale")
	private String bachelorGPAScale;
	@Column(name = "master_address")
	private String masterAddress;
	@Column(name = "master_graduate")
	private String masterGraduate;
	@Column(name = "master_degree")
	private String masterDegree;
	@Column(name = "master_cos")
	private String masterCos;
	@Column(name = "master_GPA_scale")
	private String masterGPAScale;
	@Column(name = "doctoral_address")
	private String doctoralAddress;
	@Column(name = "doctoral_graduate")
	private String doctoralGraduate;
	@Column(name = "doctoral_degree")
	private String doctoralDegree;
	@Column(name = "doctoral_cos")
	private String doctoralCos;
	@Column(name = "doctoral_GPA_scale")
	private String doctoralGPAScale;
	@Column(name = "others_address")
	private String othersAddress;
	@Column(name = "others_graduate")
	private String othersGraduate;
	@Column(name = "others_degree")
	private String othersDegree;
	@Column(name = "others_cos")
	private String othersCos;
	@Column(name = "others_GPA_scale")
	private String othersGPAScale;
	@Column(name = "tech_prof", length = 500)
	private String techProf;
	@Column(name = "ref_fullname")
	private String[] refFullName;
	@Column(name = "ref_relationship")
	private String[] refRelationship;
	@Column(name = "ref_company")
	private String[] refCompany;
	@Column(name = "ref_phone")
	private String[] ref_Phone;
	@Column(name = "ref_email")
	private String[] refEmail;
	@Column(name = "ref_address")
	private String[] refAddress;
	@Column(name = "rel_mili_training_exp")
	private String relMiliTrainingExp;
	@Column(name = "disclaimer_sign")
	private String disclaimerSign;
	@Column(name = "name")
	private String name;
	@Column(name = "signature")
	private byte[] signature;
	@Column(name = "date1")
	private Date date1;
	private String key;
	@Column(name = "education")
	private String education;
	@Column(name = "associateInsName")
	private String associateInsName;
	@Column(name = "bachelorInsName")
	private String bachelorInsName;
	@Column(name = "masterInsName")
	private String masterInsName;
	@Column(name = "doctoralInsName")
	private String doctoralInsName;
	@Column(name = "otherInsName")
	private String otherInsName;
	@Column(name = "hsInsName")
	private String hsInsName;
	private EducationModel[] educationDetails;
	private String[] instituteName;
	private String[] insAddress;
	private String[] graduate;
	private String[] degree;
	private String[] cos;
	private String[] GPA;
	private String[] educationalLevel;
	// Extra fields
	@Column(name = "deal_id")
	private String dealId;
	@Column(name = "field1")
	private String fieldOne;
	@Column(name = "field2")
	private String fieldTwo;
	@Column(name = "field3")
	private String fieldThree;
	@Column(name = "field4")
	private String fieldFour;
	@Column(name = "field5")
	private String fieldFive;
	@Column(name = "field6")
	private String fieldSix;
	@Column(name = "field7")
	private String fieldSeven;
	@Column(name = "field8")
	private String fieldEight;
	@Column(name = "field9")
	private String fieldNine;
	@Column(name = "field10")
	private String fieldTen;

	public String getAssociateInsName() {
		return associateInsName;
	}

	public void setAssociateInsName(String associateInsName) {
		this.associateInsName = associateInsName;
	}

	public String getBachelorInsName() {
		return bachelorInsName;
	}

	public void setBachelorInsName(String bachelorInsName) {
		this.bachelorInsName = bachelorInsName;
	}

	public String getMasterInsName() {
		return masterInsName;
	}

	public void setMasterInsName(String masterInsName) {
		this.masterInsName = masterInsName;
	}

	public String getDoctoralInsName() {
		return doctoralInsName;
	}

	public void setDoctoralInsName(String doctoralInsName) {
		this.doctoralInsName = doctoralInsName;
	}

	public String getOtherInsName() {
		return otherInsName;
	}

	public void setOtherInsName(String otherInsName) {
		this.otherInsName = otherInsName;
	}

	public String getHsInsName() {
		return hsInsName;
	}

	public void setHsInsName(String hsInsName) {
		this.hsInsName = hsInsName;
	}

	public String[] getEducationalLevel() {
		return educationalLevel;
	}

	public void setEducationalLevel(String[] educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public EducationModel[] getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(EducationModel[] educationDetails) {
		this.educationDetails = educationDetails;
	}

	public String[] getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String[] instituteName) {
		this.instituteName = instituteName;
	}

	public String[] getInsAddress() {
		return insAddress;
	}

	public void setInsAddress(String[] insAddress) {
		this.insAddress = insAddress;
	}

	public String[] getGraduate() {
		return graduate;
	}

	public void setGraduate(String[] graduate) {
		this.graduate = graduate;
	}

	public String[] getDegree() {
		return degree;
	}

	public void setDegree(String[] degree) {
		this.degree = degree;
	}

	public String[] getCos() {
		return cos;
	}

	public void setCos(String[] cos) {
		this.cos = cos;
	}

	public String[] getGPA() {
		return GPA;
	}

	public void setGPA(String[] gPA) {
		GPA = gPA;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ApplicationUSEntityMap() {
		super();
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public boolean isAppflag() {
		return appflag;
	}

	public void setAppflag(boolean appflag) {
		this.appflag = appflag;
	}

	public String getResumeStatus() {
		return resumeStatus;
	}

	public void setResumeStatus(String resumeStatus) {
		this.resumeStatus = resumeStatus;
	}

	public Date getAppCompletedDate() {
		return appCompletedDate;
	}

	public void setAppCompletedDate(Date appCompletedDate) {
		this.appCompletedDate = appCompletedDate;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getApartmentUnit() {
		return apartmentUnit;
	}

	public void setApartmentUnit(String apartmentUnit) {
		this.apartmentUnit = apartmentUnit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateAvailable() {
		return dateAvailable;
	}

	public void setDateAvailable(Date dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	public String getCurrentWorkLocation() {
		return currentWorkLocation;
	}

	public void setCurrentWorkLocation(String currentWorkLocation) {
		this.currentWorkLocation = currentWorkLocation;
	}

	public String getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(String totalExp) {
		this.totalExp = totalExp;
	}

	public String getTotalRelExp() {
		return totalRelExp;
	}

	public void setTotalRelExp(String totalRelExp) {
		this.totalRelExp = totalRelExp;
	}

	public String getUnder18ProvideWorkPermit() {
		return under18ProvideWorkPermit;
	}

	public void setUnder18ProvideWorkPermit(String under18ProvideWorkPermit) {
		this.under18ProvideWorkPermit = under18ProvideWorkPermit;
	}

	public String getOfferEmpExtDemWorkUS() {
		return offerEmpExtDemWorkUS;
	}

	public void setOfferEmpExtDemWorkUS(String offerEmpExtDemWorkUS) {
		this.offerEmpExtDemWorkUS = offerEmpExtDemWorkUS;
	}

	public String getReqSponsorship() {
		return reqSponsorship;
	}

	public void setReqSponsorship(String reqSponsorship) {
		this.reqSponsorship = reqSponsorship;
	}

	public String getExTCSEmployee() {
		return exTCSEmployee;
	}

	public void setExTCSEmployee(String exTCSEmployee) {
		this.exTCSEmployee = exTCSEmployee;
	}

	public String getIfYesWhen() {
		return ifYesWhen;
	}

	public void setIfYesWhen(String ifYesWhen) {
		this.ifYesWhen = ifYesWhen;
	}

	public String[] getCom() {
		return com;
	}

	public void setCom(String[] com) {
		this.com = com;
	}

	public String[] getComPhone() {
		return comPhone;
	}

	public void setComPhone(String[] comPhone) {
		this.comPhone = comPhone;
	}

	public String[] getComAddress() {
		return comAddress;
	}

	public void setComAddress(String[] comAddress) {
		this.comAddress = comAddress;
	}

	public String[] getComSupervisor() {
		return comSupervisor;
	}

	public void setComSupervisor(String[] comSupervisor) {
		this.comSupervisor = comSupervisor;
	}

	public String[] getComJobTitle() {
		return comJobTitle;
	}

	public void setComJobTitle(String[] comJobTitle) {
		this.comJobTitle = comJobTitle;
	}

	public String[] getComResponsibilities() {
		return comResponsibilities;
	}

	public void setComResponsibilities(String[] comResponsibilities) {
		this.comResponsibilities = comResponsibilities;
	}

	public Date[] getComFrom() {
		return comFrom;
	}

	public void setComFrom(Date[] comFrom) {
		this.comFrom = comFrom;
	}

	public Date[] getComTo() {
		return comTo;
	}

	public void setComTo(Date[] comTo) {
		this.comTo = comTo;
	}

	public String[] getComReasonForLeaving() {
		return comReasonForLeaving;
	}

	public void setComReasonForLeaving(String[] comReasonForLeaving) {
		this.comReasonForLeaving = comReasonForLeaving;
	}

	public String[] getComMayContactSupervisorRef() {
		return comMayContactSupervisorRef;
	}

	public void setComMayContactSupervisorRef(String[] comMayContactSupervisorRef) {
		this.comMayContactSupervisorRef = comMayContactSupervisorRef;
	}

	public String getHsAddress() {
		return hsAddress;
	}

	public void setHsAddress(String hsAddress) {
		this.hsAddress = hsAddress;
	}

	public String getHsGraduate() {
		return hsGraduate;
	}

	public void setHsGraduate(String hsGraduate) {
		this.hsGraduate = hsGraduate;
	}

	public String getHsDegree() {
		return hsDegree;
	}

	public void setHsDegree(String hsDegree) {
		this.hsDegree = hsDegree;
	}

	public String getHsCos() {
		return hsCos;
	}

	public void setHsCos(String hsCos) {
		this.hsCos = hsCos;
	}

	public String getHsGPAScale() {
		return hsGPAScale;
	}

	public void setHsGPAScale(String hsGPAScale) {
		this.hsGPAScale = hsGPAScale;
	}

	public String getAssosiateAddress() {
		return assosiateAddress;
	}

	public void setAssosiateAddress(String assosiateAddress) {
		this.assosiateAddress = assosiateAddress;
	}

	public String getAssosiateGraduate() {
		return assosiateGraduate;
	}

	public void setAssosiateGraduate(String assosiateGraduate) {
		this.assosiateGraduate = assosiateGraduate;
	}

	public String getAssosiateDegree() {
		return assosiateDegree;
	}

	public void setAssosiateDegree(String assosiateDegree) {
		this.assosiateDegree = assosiateDegree;
	}

	public String getAssosiateCos() {
		return assosiateCos;
	}

	public void setAssosiateCos(String assosiateCos) {
		this.assosiateCos = assosiateCos;
	}

	public String getAssociateGPAScale() {
		return associateGPAScale;
	}

	public void setAssociateGPAScale(String associateGPAScale) {
		this.associateGPAScale = associateGPAScale;
	}

	public String getBachelorAddress() {
		return bachelorAddress;
	}

	public void setBachelorAddress(String bachelorAddress) {
		this.bachelorAddress = bachelorAddress;
	}

	public String getBachelorGraduate() {
		return bachelorGraduate;
	}

	public void setBachelorGraduate(String bachelorGraduate) {
		this.bachelorGraduate = bachelorGraduate;
	}

	public String getBachelorDegree() {
		return bachelorDegree;
	}

	public void setBachelorDegree(String bachelorDegree) {
		this.bachelorDegree = bachelorDegree;
	}

	public String getBachelorCos() {
		return bachelorCos;
	}

	public void setBachelorCos(String bachelorCos) {
		this.bachelorCos = bachelorCos;
	}

	public String getBachelorGPAScale() {
		return bachelorGPAScale;
	}

	public void setBachelorGPAScale(String bachelorGPAScale) {
		this.bachelorGPAScale = bachelorGPAScale;
	}

	public String getMasterAddress() {
		return masterAddress;
	}

	public void setMasterAddress(String masterAddress) {
		this.masterAddress = masterAddress;
	}

	public String getMasterGraduate() {
		return masterGraduate;
	}

	public void setMasterGraduate(String masterGraduate) {
		this.masterGraduate = masterGraduate;
	}

	public String getMasterDegree() {
		return masterDegree;
	}

	public void setMasterDegree(String masterDegree) {
		this.masterDegree = masterDegree;
	}

	public String getMasterCos() {
		return masterCos;
	}

	public void setMasterCos(String masterCos) {
		this.masterCos = masterCos;
	}

	public String getMasterGPAScale() {
		return masterGPAScale;
	}

	public void setMasterGPAScale(String masterGPAScale) {
		this.masterGPAScale = masterGPAScale;
	}

	public String getDoctoralAddress() {
		return doctoralAddress;
	}

	public void setDoctoralAddress(String doctoralAddress) {
		this.doctoralAddress = doctoralAddress;
	}

	public String getDoctoralGraduate() {
		return doctoralGraduate;
	}

	public void setDoctoralGraduate(String doctoralGraduate) {
		this.doctoralGraduate = doctoralGraduate;
	}

	public String getDoctoralDegree() {
		return doctoralDegree;
	}

	public void setDoctoralDegree(String doctoralDegree) {
		this.doctoralDegree = doctoralDegree;
	}

	public String getDoctoralCos() {
		return doctoralCos;
	}

	public void setDoctoralCos(String doctoralCos) {
		this.doctoralCos = doctoralCos;
	}

	public String getDoctoralGPAScale() {
		return doctoralGPAScale;
	}

	public void setDoctoralGPAScale(String doctoralGPAScale) {
		this.doctoralGPAScale = doctoralGPAScale;
	}

	public String getOthersAddress() {
		return othersAddress;
	}

	public void setOthersAddress(String othersAddress) {
		this.othersAddress = othersAddress;
	}

	public String getOthersGraduate() {
		return othersGraduate;
	}

	public void setOthersGraduate(String othersGraduate) {
		this.othersGraduate = othersGraduate;
	}

	public String getOthersDegree() {
		return othersDegree;
	}

	public void setOthersDegree(String othersDegree) {
		this.othersDegree = othersDegree;
	}

	public String getOthersCos() {
		return othersCos;
	}

	public void setOthersCos(String othersCos) {
		this.othersCos = othersCos;
	}

	public String getOthersGPAScale() {
		return othersGPAScale;
	}

	public void setOthersGPAScale(String othersGPAScale) {
		this.othersGPAScale = othersGPAScale;
	}

	public String getTechProf() {
		return techProf;
	}

	public void setTechProf(String techProf) {
		this.techProf = techProf;
	}

	public String[] getRefFullName() {
		return refFullName;
	}

	public void setRefFullName(String[] refFullName) {
		this.refFullName = refFullName;
	}

	public String[] getRefRelationship() {
		return refRelationship;
	}

	public void setRefRelationship(String[] refRelationship) {
		this.refRelationship = refRelationship;
	}

	public String[] getRefCompany() {
		return refCompany;
	}

	public void setRefCompany(String[] refCompany) {
		this.refCompany = refCompany;
	}

	public String[] getRef_Phone() {
		return ref_Phone;
	}

	public void setRef_Phone(String[] ref_Phone) {
		this.ref_Phone = ref_Phone;
	}

	public String[] getRefEmail() {
		return refEmail;
	}

	public void setRefEmail(String[] refEmail) {
		this.refEmail = refEmail;
	}

	public String[] getRefAddress() {
		return refAddress;
	}

	public void setRefAddress(String[] refAddress) {
		this.refAddress = refAddress;
	}

	public String getRelMiliTrainingExp() {
		return relMiliTrainingExp;
	}

	public void setRelMiliTrainingExp(String relMiliTrainingExp) {
		this.relMiliTrainingExp = relMiliTrainingExp;
	}

	public String getDisclaimerSign() {
		return disclaimerSign;
	}

	public void setDisclaimerSign(String disclaimerSign) {
		this.disclaimerSign = disclaimerSign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

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

	@Override
	public String toString() {
		return "ApplicationUSEntityMap [emailid=" + emailid + ", appflag=" + appflag + ", resumeStatus=" + resumeStatus
				+ ", appCompletedDate=" + appCompletedDate + ", streetAddress=" + streetAddress + ", apartmentUnit="
				+ apartmentUnit + ", state=" + state + ", zipCode=" + zipCode + ", date=" + date + ", dateAvailable="
				+ dateAvailable + ", currentWorkLocation=" + currentWorkLocation + ", totalExp=" + totalExp
				+ ", totalRelExp=" + totalRelExp + ", under18ProvideWorkPermit=" + under18ProvideWorkPermit
				+ ", offerEmpExtDemWorkUS=" + offerEmpExtDemWorkUS + ", reqSponsorship=" + reqSponsorship
				+ ", exTCSEmployee=" + exTCSEmployee + ", ifYesWhen=" + ifYesWhen + ", com=" + Arrays.toString(com)
				+ ", comPhone=" + Arrays.toString(comPhone) + ", comAddress=" + Arrays.toString(comAddress)
				+ ", comSupervisor=" + Arrays.toString(comSupervisor) + ", comJobTitle=" + Arrays.toString(comJobTitle)
				+ ", comResponsibilities=" + Arrays.toString(comResponsibilities) + ", comFrom="
				+ Arrays.toString(comFrom) + ", comTo=" + Arrays.toString(comTo) + ", comReasonForLeaving="
				+ Arrays.toString(comReasonForLeaving) + ", comMayContactSupervisorRef="
				+ Arrays.toString(comMayContactSupervisorRef) + ", hsAddress=" + hsAddress + ", hsGraduate="
				+ hsGraduate + ", hsDegree=" + hsDegree + ", hsCos=" + hsCos + ", hsGPAScale=" + hsGPAScale
				+ ", assosiateAddress=" + assosiateAddress + ", assosiateGraduate=" + assosiateGraduate
				+ ", assosiateDegree=" + assosiateDegree + ", assosiateCos=" + assosiateCos + ", associateGPAScale="
				+ associateGPAScale + ", bachelorAddress=" + bachelorAddress + ", bachelorGraduate=" + bachelorGraduate
				+ ", bachelorDegree=" + bachelorDegree + ", bachelorCos=" + bachelorCos + ", bachelorGPAScale="
				+ bachelorGPAScale + ", masterAddress=" + masterAddress + ", masterGraduate=" + masterGraduate
				+ ", masterDegree=" + masterDegree + ", masterCos=" + masterCos + ", masterGPAScale=" + masterGPAScale
				+ ", doctoralAddress=" + doctoralAddress + ", doctoralGraduate=" + doctoralGraduate
				+ ", doctoralDegree=" + doctoralDegree + ", doctoralCos=" + doctoralCos + ", doctoralGPAScale="
				+ doctoralGPAScale + ", othersAddress=" + othersAddress + ", othersGraduate=" + othersGraduate
				+ ", othersDegree=" + othersDegree + ", othersCos=" + othersCos + ", othersGPAScale=" + othersGPAScale
				+ ", techProf=" + techProf + ", refFullName=" + Arrays.toString(refFullName) + ", refRelationship="
				+ Arrays.toString(refRelationship) + ", refCompany=" + Arrays.toString(refCompany) + ", ref_Phone="
				+ Arrays.toString(ref_Phone) + ", refEmail=" + Arrays.toString(refEmail) + ", refAddress="
				+ Arrays.toString(refAddress) + ", relMiliTrainingExp=" + relMiliTrainingExp + ", disclaimerSign="
				+ disclaimerSign + ", name=" + name + ", signature=" + Arrays.toString(signature) + ", date1=" + date1
				+ ", key=" + key + ", education=" + education + ", associateInsName=" + associateInsName
				+ ", bachelorInsName=" + bachelorInsName + ", masterInsName=" + masterInsName + ", doctoralInsName="
				+ doctoralInsName + ", otherInsName=" + otherInsName + ", hsInsName=" + hsInsName
				+ ", educationDetails=" + Arrays.toString(educationDetails) + ", instituteName="
				+ Arrays.toString(instituteName) + ", insAddress=" + Arrays.toString(insAddress) + ", graduate="
				+ Arrays.toString(graduate) + ", degree=" + Arrays.toString(degree) + ", cos=" + Arrays.toString(cos)
				+ ", GPA=" + Arrays.toString(GPA) + ", educationalLevel=" + Arrays.toString(educationalLevel)
				+ ", dealId=" + dealId + ", fieldOne=" + fieldOne + ", fieldTwo=" + fieldTwo + ", fieldThree="
				+ fieldThree + ", fieldFour=" + fieldFour + ", fieldFive=" + fieldFive + ", fieldSix=" + fieldSix
				+ ", fieldSeven=" + fieldSeven + ", fieldEight=" + fieldEight + ", fieldNine=" + fieldNine
				+ ", fieldTen=" + fieldTen + "]";
	}

}
