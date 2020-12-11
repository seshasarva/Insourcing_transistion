package com.insourcing.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "offer_india")
public class OfferIndiaEntity {

	@Id
	@SerializedName("CANDIDATE EMAIL")
	@Column(name = "emailid")
	private String emailId;
	@Column(name = "refid")
	@SerializedName("APPLICANT ID")
	private String refId;
	@Column(name = "department")
	@SerializedName("DEPARTMENT")
	private String department;
	@Column(name = "date_of_offer")
	@SerializedName("DATE OF OFFER")
	private Date dateOfOffer;
	@Column(name = "title")
	@SerializedName("TITLE")
	private String title;
	@Column(name = "firstname")
	@SerializedName("FIRST NAME")
	private String firstname;
	@Column(name = "middlename")
	@SerializedName("MIDDLE NAME")
	private String middlename;
	@Column(name = "lastname")
	@SerializedName("LAST NAME")
	private String lastname;
	@Column(name = "address1")
	@SerializedName("ADDRESS LINE 1")
	private String add1;
	@Column(name = "address2")
	@SerializedName("ADDRESS LINE 2")
	private String add2;
	@Column(name = "address3")
	@SerializedName("ADDRESS LINE 3")
	private String add3;
	@Column(name = "telNo")
	@SerializedName("TELEPHONE NUMBER")
	private String telNo;
	@Column(name = "designation")
	@SerializedName("DESIGNATION")
	private String designation;
	@Column(name = "grade")
	@SerializedName("GRADE")
	private String grade;
	@Column(name = "posting_branch")
	@SerializedName("POSTING BRANCH")
	private String postingBranch;
	@Column(name = "cand_role")
	@SerializedName("CANDIDATE ROLE")
	private String candRole;
	@Column(name = "supervisor_role")
	@SerializedName("SUPERVISOR ROLE")
	private String superRole;
	@Column(name = "rel_exp")
	@SerializedName("Relevant Experience")
	private String relExp;
	@Column(name = "basic")
	@SerializedName("BASIC")
	private String[] basic;
	@Column(name = "mva")
	@SerializedName("MVA")
	private String[] mva;
	@Column(name = "qva")
	@SerializedName("QVA")
	private String[] qva;
	@Column(name = "city_allowance")
	@SerializedName("CITY_ALLOWANCE")
	private String[] cityAllowance;
	@Column(name = "bob")
	@SerializedName("BOB")
	private String[] bob;
	@Column(name = "hra")
	@SerializedName("HRA")
	private String[] hra;
	@Column(name = "lta")
	@SerializedName("LTA")
	private String[] lta;
	@Column(name = "foodcoupons")
	@SerializedName("FOODCOUPONS")
	private String[] foodCoupons;
	@Column(name = "car_allowance")
	@SerializedName("CAR_ALLOWANCE")
	private String[] carAllo;
	@Column(name = "vehicle")
	@SerializedName("VEHICLE")
	private String[] vehicle;
	@Column(name = "fuel_allowance")
	@SerializedName("FUEL_ALLOWANCE")
	private String[] fuelAllo;
	@Column(name = "perallowance")
	@SerializedName("PERALLOWANCE")
	private String[] perAllo;
	@Column(name = "pf")
	@SerializedName("PF")
	private String[] pf;
	@Column(name = "gratuity")
	@SerializedName("GRATUITY")
	private String[] gratuity;
	@Column(name = "annual_retirals")
	@SerializedName("ANNUAL_RETIRALS")
	private String[] annualRetirals;
	@Column(name = "ctc")
	@SerializedName("CTC")
	private String[] ctc;
	@Column(name = "his_3")
	@SerializedName("HIS_III")
	private String his3;
	@Column(name = "ret_inc")
	@SerializedName("RET_INC_A")
	private String retInc;
	@Column(name = "prob_period")
	@SerializedName("PROBATION_PERIOD")
	private String probPeriod;
	@Column(name = "prob_unit")
	@SerializedName("PROBATION_UNIT")
	private String probUnit;
	@Column(name = "joining_date")
	@SerializedName("DATE_OF_JOINING")
	private Date joiningDate;
	@Column(name = "joining_branch")
	@SerializedName("JOINING_BRANCH")
	private String joiningBranch;
	@Column(name = "exgratia")
	@SerializedName("EXGRATIA")
	private String exgratia;
	@Column(name = "offer_status")
	private String offerStatus;
	@Column(name = "appointment_status")
	private String appLetterStatus;
	@Column(name = "app_created_date")
	private Date appCreatedDate;
	@Column(name = "app_form_status")
	private String appFormStatus;
	@Column(name = "offer_release_date")
	private Date offerReleaseDate;

	public OfferIndiaEntity(String emailId, String refId, String department, Date dateOfOffer, String title,
			String firstname, String middlename, String lastname, String add1, String add2, String add3, String telNo,
			String designation, String grade, String postingBranch, String candRole, String superRole, String relExp,
			String[] basic, String[] mva, String[] qva, String[] cityAllowance, String[] bob, String[] hra,
			String[] lta, String[] foodCoupons, String[] carAllo, String[] vehicle, String[] fuelAllo, String[] perAllo,
			String[] pf, String[] gratuity, String[] annualRetirals, String[] ctc, String retInc, String probPeriod,
			String probUnit, Date joiningDate, String joiningBranch, String exgratia, String offerStatus,
			String appLetterStatus, Date appCreatedDate) {
		super();
		this.emailId = emailId;
		this.refId = refId;
		this.department = department;
		this.dateOfOffer = dateOfOffer;
		this.title = title;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.add1 = add1;
		this.add2 = add2;
		this.add3 = add3;
		this.telNo = telNo;
		this.designation = designation;
		this.grade = grade;
		this.postingBranch = postingBranch;
		this.candRole = candRole;
		this.superRole = superRole;
		this.relExp = relExp;
		this.basic = basic;
		this.mva = mva;
		this.qva = qva;
		this.cityAllowance = cityAllowance;
		this.bob = bob;
		this.hra = hra;
		this.lta = lta;
		this.foodCoupons = foodCoupons;
		this.carAllo = carAllo;
		this.vehicle = vehicle;
		this.fuelAllo = fuelAllo;
		this.perAllo = perAllo;
		this.pf = pf;
		this.gratuity = gratuity;
		this.annualRetirals = annualRetirals;
		this.ctc = ctc;
		this.retInc = retInc;
		this.probPeriod = probPeriod;
		this.probUnit = probUnit;
		this.joiningDate = joiningDate;
		this.joiningBranch = joiningBranch;
		this.exgratia = exgratia;
		this.offerStatus = offerStatus;
		this.appLetterStatus = appLetterStatus;
		this.appCreatedDate = appCreatedDate;
	}

	public Date getOfferReleaseDate() {
		return offerReleaseDate;
	}

	public void setOfferReleaseDate(Date offerReleaseDate) {
		this.offerReleaseDate = offerReleaseDate;
	}

	public OfferIndiaEntity() {
		super();
	}

	public String getAppLetterStatus() {
		return appLetterStatus;
	}

	public void setAppLetterStatus(String appLetterStatus) {
		this.appLetterStatus = appLetterStatus;
	}

	public String getHis3() {
		return his3;
	}

	public void setHis3(String his3) {
		this.his3 = his3;
	}

	public String getAppFormStatus() {
		return appFormStatus;
	}

	public void setAppFormStatus(String appFormStatus) {
		this.appFormStatus = appFormStatus;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDateOfOffer() {
		return dateOfOffer;
	}

	public void setDateOfOffer(Date dateOfOffer) {
		this.dateOfOffer = dateOfOffer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getAdd3() {
		return add3;
	}

	public void setAdd3(String add3) {
		this.add3 = add3;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPostingBranch() {
		return postingBranch;
	}

	public void setPostingBranch(String postingBranch) {
		this.postingBranch = postingBranch;
	}

	public String getCandRole() {
		return candRole;
	}

	public void setCandRole(String candRole) {
		this.candRole = candRole;
	}

	public String getSuperRole() {
		return superRole;
	}

	public void setSuperRole(String superRole) {
		this.superRole = superRole;
	}

	public String getRelExp() {
		return relExp;
	}

	public void setRelExp(String relExp) {
		this.relExp = relExp;
	}

	public String[] getBasic() {
		return basic;
	}

	public void setBasic(String[] basic) {
		this.basic = basic;
	}

	public String[] getMva() {
		return mva;
	}

	public void setMva(String[] mva) {
		this.mva = mva;
	}

	public String[] getQva() {
		return qva;
	}

	public void setQva(String[] qva) {
		this.qva = qva;
	}

	public String[] getCityAllowance() {
		return cityAllowance;
	}

	public void setCityAllowance(String[] cityAllowance) {
		this.cityAllowance = cityAllowance;
	}

	public String[] getBob() {
		return bob;
	}

	public void setBob(String[] bob) {
		this.bob = bob;
	}

	public String[] getHra() {
		return hra;
	}

	public void setHra(String[] hra) {
		this.hra = hra;
	}

	public String[] getLta() {
		return lta;
	}

	public void setLta(String[] lta) {
		this.lta = lta;
	}

	public String[] getFoodCoupons() {
		return foodCoupons;
	}

	public void setFoodCoupons(String[] foodCoupons) {
		this.foodCoupons = foodCoupons;
	}

	public String[] getCarAllo() {
		return carAllo;
	}

	public void setCarAllo(String[] carAllo) {
		this.carAllo = carAllo;
	}

	public String[] getVehicle() {
		return vehicle;
	}

	public void setVehicle(String[] vehicle) {
		this.vehicle = vehicle;
	}

	public String[] getFuelAllo() {
		return fuelAllo;
	}

	public void setFuelAllo(String[] fuelAllo) {
		this.fuelAllo = fuelAllo;
	}

	public String[] getPerAllo() {
		return perAllo;
	}

	public void setPerAllo(String[] perAllo) {
		this.perAllo = perAllo;
	}

	public String[] getPf() {
		return pf;
	}

	public void setPf(String[] pf) {
		this.pf = pf;
	}

	public String[] getGratuity() {
		return gratuity;
	}

	public void setGratuity(String[] gratuity) {
		this.gratuity = gratuity;
	}

	public String[] getAnnualRetirals() {
		return annualRetirals;
	}

	public void setAnnualRetirals(String[] annualRetirals) {
		this.annualRetirals = annualRetirals;
	}

	public String[] getCtc() {
		return ctc;
	}

	public void setCtc(String[] ctc) {
		this.ctc = ctc;
	}

	public String getRetInc() {
		return retInc;
	}

	public void setRetInc(String retInc) {
		this.retInc = retInc;
	}

	public String getProbPeriod() {
		return probPeriod;
	}

	public void setProbPeriod(String probPeriod) {
		this.probPeriod = probPeriod;
	}

	public String getProbUnit() {
		return probUnit;
	}

	public void setProbUnit(String probUnit) {
		this.probUnit = probUnit;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getJoiningBranch() {
		return joiningBranch;
	}

	public void setJoiningBranch(String joiningBranch) {
		this.joiningBranch = joiningBranch;
	}

	public String getExgratia() {
		return exgratia;
	}

	public void setExgratia(String exgratia) {
		this.exgratia = exgratia;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public String getappLetterStatus() {
		return appLetterStatus;
	}

	public void setappLetterStatus(String appLetterStatus) {
		this.appLetterStatus = appLetterStatus;
	}

	public Date getAppCreatedDate() {
		return appCreatedDate;
	}

	public void setAppCreatedDate(Date appCreatedDate) {
		this.appCreatedDate = appCreatedDate;
	}

	@Override
	public String toString() {
		return "OfferIndiaEntity [emailId=" + emailId + ", refId=" + refId + ", department=" + department
				+ ", dateOfOffer=" + dateOfOffer + ", title=" + title + ", firstname=" + firstname + ", middlename="
				+ middlename + ", lastname=" + lastname + ", add1=" + add1 + ", add2=" + add2 + ", add3=" + add3
				+ ", telNo=" + telNo + ", designation=" + designation + ", grade=" + grade + ", postingBranch="
				+ postingBranch + ", candRole=" + candRole + ", superRole=" + superRole + ", relExp=" + relExp
				+ ", basic=" + Arrays.toString(basic) + ", mva=" + Arrays.toString(mva) + ", qva="
				+ Arrays.toString(qva) + ", cityAllowance=" + Arrays.toString(cityAllowance) + ", bob="
				+ Arrays.toString(bob) + ", hra=" + Arrays.toString(hra) + ", lta=" + Arrays.toString(lta)
				+ ", foodCoupons=" + Arrays.toString(foodCoupons) + ", carAllo=" + Arrays.toString(carAllo)
				+ ", vehicle=" + Arrays.toString(vehicle) + ", fuelAllo=" + Arrays.toString(fuelAllo) + ", perAllo="
				+ Arrays.toString(perAllo) + ", pf=" + Arrays.toString(pf) + ", gratuity=" + Arrays.toString(gratuity)
				+ ", annualRetirals=" + Arrays.toString(annualRetirals) + ", ctc=" + Arrays.toString(ctc) + ", his3="
				+ his3 + ", retInc=" + retInc + ", probPeriod=" + probPeriod + ", probUnit=" + probUnit
				+ ", joiningDate=" + joiningDate + ", joiningBranch=" + joiningBranch + ", exgratia=" + exgratia
				+ ", offerStatus=" + offerStatus + ", appLetterStatus=" + appLetterStatus + ", appCreatedDate="
				+ appCreatedDate + ", appFormStatus=" + appFormStatus + ", offerReleaseDate=" + offerReleaseDate + "]";
	}
	
	

}
