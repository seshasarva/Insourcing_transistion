package com.insourcing.entity;

import java.util.Arrays;

import java.util.Date;

import com.insourcing.model.EducationModel;

//@Entity
//@Table(name = "us_app_form")
public class ApplicationUSEntity {

	// @Id
	// @Column(name = "emailid", nullable = false)
	// @JsonProperty("emailid")
	private String emailid;
	// @Column(name = "appflag")
	// @JsonProperty("appflag")
	private boolean appflag;
	// @Column(name = "resume_status")
	// @JsonProperty("resumeStatus")
	private String resumeStatus;
	// @Column(name = "app_completed_date")
	// @JsonProperty("appCompletedDate")
	private Date appCompletedDate;
	// @Column(name = "street_address")
	// @JsonProperty("streetAddress")
	private String streetAddress;
	// @Column(name = "apartment_unit")
	// @JsonProperty("apartmentUnit")
	private String apartmentUnit;
	// @Column(name = "state")
	// @JsonProperty("state")
	private String state;
	// @Column(name = "zipCode")
	// @JsonProperty("zipCode")
	private String zipCode;
	// @Column(name = "date")
	// @JsonProperty("date")
	private Date date;
	// @Column(name = "date_available")
	// @JsonProperty("dateAvailable")
	private Date dateAvailable;
	// @Column(name = "current_work_location")
	// @JsonProperty("currentWorkLocation")
	private String currentWorkLocation;
	// @Column(name = "total_exp")
	// @JsonProperty("totalExp")
	private String totalExp;
	// @Column(name = "total_relevant_exp")
	// @JsonProperty("totalRelExp")
	private String totalRelExp;
	// @Column(name = "under_18_provide_work_permit")
	// @JsonProperty("under18ProvideWorkPermit")
	private String under18ProvideWorkPermit;
	// @Column(name = "offer_emp_extend_demonstrate_work_in_US")
	// @JsonProperty("offerEmpExtDemWorkUS")
	private String offerEmpExtDemWorkUS;
	// @Column(name = "require_sponsorship")
	// @JsonProperty("reqSponsorship")
	private String reqSponsorship;
	// @Column(name = "ex_TCS_employee")
	// @JsonProperty("exTCSEmployee")
	private String exTCSEmployee;
	// @Column(name = "if_yes_when")
	// @JsonProperty("ifYesWhen")
	private String ifYesWhen;
	// @Column(name = "com")
	// @JsonProperty("com")
	private String[] com;
	// @Column(name = "com_phone")
	// @JsonProperty("comPhone")
	private String[] comPhone;
	// @Column(name = "com_address")
	// @JsonProperty("comAddress")
	private String[] comAddress;
	// @Column(name = "com_supervisor")
	// @JsonProperty("comSupervisor")
	private String[] comSupervisor;
	// @Column(name = "com_job_title")
	// @JsonProperty("comJobTitle")
	private String[] comJobTitle;
	// @Column(name = "com_responsibilities")
	// @JsonProperty("comResponsibilities")
	private String[] comResponsibilities;
	// @Column(name = "com_from")
	// @JsonProperty("comFrom")
	private Date[] comFrom;
	// @Column(name = "com_to")
	// @JsonProperty("comTo")
	private Date[] comTo;
	// @Column(name = "com_reason_for_leaving")
	// @JsonProperty("comReasonForLeaving")
	private String[] comReasonForLeaving;
	// @Column(name = "com_contact_supervisor_ref")
	// @JsonProperty("comMayContactSupervisorRef")
	private String[] comMayContactSupervisorRef;
	// @Column(name = "hs_address")
	// @JsonProperty("hsAddress")
	private String hsInsName;
	private String hsAddress;
	// @Column(name = "hs_graduate")
	// @JsonProperty("hsGraduate")
	private String hsGraduate;
	// @Column(name = "hs_degree")
	// @JsonProperty("hsDegree")
	private String hsDegree;
	// @Column(name = "hs_cos")
	// @JsonProperty("hsCos")
	private String hsCos;
	// @Column(name = "hs_GPA_scale")
	// @JsonProperty("hsGPAScale")
	private String hsGPAScale;
	// @Column(name = "associate_address")
	// @JsonProperty("assosiateAddress")
	
	private String assosiateAddress;
	private String associateInsName;
	// @Column(name = "associate_graduate")
	// @JsonProperty("assosiateGraduate")
	private String assosiateGraduate;
	// @Column(name = "associate_degree")
	// @JsonProperty("assosiateDegree")
	private String assosiateDegree;
	// @Column(name = "associate_cos")
	// @JsonProperty("assosiateCos")
	private String assosiateCos;
	// @Column(name = "associate_GPA_scale")
	// @JsonProperty("associateGPAScale")
	private String associateGPAScale;
	// @Column(name = "bachelor_address")
	// @JsonProperty("bachelorAddress")
	private String bachelorAddress;
	private String bachelorInsName;
	// @Column(name = "bachelor_graduate")
	// @JsonProperty("bachelorGraduate")
	private String bachelorGraduate;
	// @Column(name = "bachelor_degree")
	// @JsonProperty("bachelorDegree")
	private String bachelorDegree;
	// @Column(name = "bachelor_cos")
	// @JsonProperty("bachelorCos")
	private String bachelorCos;
	// @Column(name = "bachelor_GPA_scale")
	// @JsonProperty("bachelorGPAScale")
	private String bachelorGPAScale;
	// @Column(name = "master_address")
	// @JsonProperty("masterAddress")
	private String masterAddress;
	private String masterInsName;
	// @Column(name = "master_graduate")
	// @JsonProperty("masterGraduate")
	private String masterGraduate;
	// @Column(name = "master_degree")
	// @JsonProperty("masterDegree")
	private String masterDegree;
	// @Column(name = "master_cos")
	// @JsonProperty("masterCos")
	private String masterCos;
	// @Column(name = "master_GPA_scale")
	// @JsonProperty("masterGPAScale")
	private String masterGPAScale;
	// @Column(name = "doctoral_address")
	// @JsonProperty("doctoralAddress")
	private String doctoralAddress;
	private String doctoralInsName;
	// @Column(name = "doctoral_graduate")
	// @JsonProperty("doctoralGraduate")
	private String doctoralGraduate;
	// @Column(name = "doctoral_degree")
	// @JsonProperty("doctoralDegree")
	private String doctoralDegree;
	// @Column(name = "doctoral_cos")
	// @JsonProperty("doctoralCos")
	private String doctoralCos;
	// @Column(name = "doctoral_GPA_scale")
	// @JsonProperty("doctoralGPAScale")
	private String doctoralGPAScale;
	// @Column(name = "others_address")
	// @JsonProperty("othersAddress")
	private String othersAddress;
	private String otherInsName;
	// @Column(name = "others_graduate")
	// @JsonProperty("othersGraduate")
	private String othersGraduate;
	// @Column(name = "others_degree")
	// @JsonProperty("othersDegree")
	private String othersDegree;
	// @Column(name = "others_cos")
	// @JsonProperty("othersCos")
	private String othersCos;
	// @Column(name = "others_GPA_scale")
	// @JsonProperty("othersGPAScale")
	private String othersGPAScale;
	// @Column(name = "tech_prof")
	// @JsonProperty("techProf")
	private String techProf;
	// @Column(name = "ref_fullname")
	// @JsonProperty("refFullName")
	private String[] refFullName;
	// @Column(name = "ref_relationship")
	// @JsonProperty("refRelationship")
	private String[] refRelationship;
	// @Column(name = "ref_company")
	// @JsonProperty("refCompany")
	private String[] refCompany;
	// @Column(name = "ref_phone")
	// @JsonProperty("ref_Phone")
	private String[] ref_Phone;
	// @Column(name = "ref_email")
	// @JsonProperty("refEmail")
	private String[] refEmail;
	// @Column(name = "ref_address")
	// @JsonProperty("refAddress")
	private String[] refAddress;
	// @Column(name = "rel_mili_training_exp")
	// @JsonProperty("relMiliTrainingExp")
	private String relMiliTrainingExp;
	// @Column(name = "disclaimer_sign")
	// @JsonProperty("disclaimerSign")
	private String disclaimerSign;
	// @Column(name = "name")
	// @JsonProperty("name")
	private String name;
	// @Column(name = "signature")
	// @JsonProperty("signature")
	private byte[] signature;
	// @Column(name = "date1")
	// @JsonProperty("date1")
	private Date date1;
	private String key;
	
	private String education;
	private EducationModel[] educationDetails;
	private String[] instituteName;
    private String[] insAddress;
    private String[] graduate;
    private String[] degree;
    private String[] cos;
    private String[] GPA;
    private String[] educationalLevel;
    
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

	public ApplicationUSEntity() {
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

	@Override
	public String toString() {
		return "USApplicationEntity [emailid=" + emailid + ", appflag=" + appflag + ", resumeStatus=" + resumeStatus
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
				+ disclaimerSign + ", name=" + name + ", signature=" + signature + ", date1=" + date1 + "]";
	}

}
