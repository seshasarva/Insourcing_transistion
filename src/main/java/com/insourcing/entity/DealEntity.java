package com.insourcing.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.insourcing.model.DealFileAttachment;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL) 
@JsonIgnoreProperties({ "createdBy", "createdTime", "updatedTime", "updatedBy" })
@Table(name = "deals")
public class DealEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "month_of_creation")
	String monthOfCreation;
	@Column(name = "oppurtunity_id")
	String oppurtunityId;
	@Column(name = "client_name")
	String clientName;
	@Column(name = "deal_status")
	String dealStatus;
	@Column(name = "business_spoc_name")
	String businessSpocName;
	@Column(name = "client_interaction")
	String clientInteraction;
	@Column(name = "iou_isu")
	String iouOrIsu;
	@Column(name = "deal_value")
	String dealValue;
	@Column(name = "work_area")
	String workArea;
	@Column(name = "people_transition")
	String peopleTransistion;
	@Column(name = "kick_off_people_transition")
	String kickOffPeopleTransistion;
	@Column(name = "global_deal")
	String globalDeal;
	@Column(name = "deal_location")
	String dealLocation;
	@Column(name = "geography_scope")
	String geographyWithInScope;
	@Column(name = "deal_lead")
	String dealLead;
	@Column(name = "service_commencement_date")
	String serviceCommencementDate;
	@Column(name = "offer_release_month")
	String offerReleaseMonth;
	@Column(name = "proposed_joining_date")
	String proposedJoiningDate;
	@Column(name = "number_of_offers_to_be_released")
	String numberOfOffersToBeReleased;
	@Column(name = "offer_released_through")
	String offerReleasedThrough;
	@Column(name = "hr_transistion_manager")
	String hrTransitionManager;
	@Column(name = "exception_category")
	String exceptionCategory;
	@Column(name = "dealException")
	String dealException;
	@Column(name = "exception_summary")
	String exceptionSummary;
	@Column(name = "exception_approved_by")
	String exceptionApprovedBy;
	/*
	 * @Column(name = "exception_approved_file_name") String
	 * exceptionApprovedFileName;
	 * 
	 * @Column(name = "exception_approved_file") byte[] exceptionApprovedFile;
	 * 
	 * @Column(name = "hr_costing_tenets") String hrCostingTenets;
	 * 
	 * @Column(name = "hr_costing_tenets_file") byte[] hrCostingTenetsFile;
	 * 
	 * @Column(name = "hr_solution_tenets") String hrSolutionTenets;
	 * 
	 * @Column(name = "hr_solution_tenets_file") byte[] hrSolutionTenetsFile;
	 * 
	 * @Column(name = "deal_solution_summary") String dealSolutionSummary;
	 * 
	 * @Column(name = "deal_solution_summary_file") byte[] dealSolutionSummaryFile;
	 * 
	 * @Column(name = "people_transistion_joiners_data") String
	 * peopleTransitionJoinersData;
	 * 
	 * @Column(name = "people_transistion_joiners_data_file") byte[]
	 * peopleTransitionJoinersDataFile;
	 */
	@Column(name = "hr_costing_tenets")
	String hrCostingTenets;
	@Column(name = "hr_solution_tenets")
	String hrSolutionTenets;
	@Column(name = "deal_solution_summary")
	String dealSolutionSummary;
	@Column(name = "people_transistion_joiners_data")
	String peopleTransitionJoinersData;

	@Column(name = "deal_note")
	String dealNote;
	@Column(name = "created_by")
	String createdBy;
	@Column(name = "created_time")
	Date createdTime;
	@Column(name = "updated_by")
	String updatedBy;
	@Column(name = "updated_time")
	Date updatedTime;

	@Transient
	DealFileAttachment exceptionApprovedFile;
	@Transient
	DealFileAttachment hrCostingTenetsFile;
	@Transient
	DealFileAttachment hrSolutionTenetsFile;
	@Transient
	DealFileAttachment dealSolutionSummaryFile;
	@Transient
	DealFileAttachment peopleTransitionJoinersDataFile;
	@Transient
	List<DealFileAttachment> dealAttachments = new ArrayList<>();

	@Transient
	List<Integer> attachmentIds = new ArrayList<Integer>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonthOfCreation() {
		return monthOfCreation;
	}

	public void setMonthOfCreation(String monthOfCreation) {
		this.monthOfCreation = monthOfCreation;
	}

	public String getOppurtunityId() {
		return oppurtunityId;
	}

	public void setOppurtunityId(String oppurtunityId) {
		this.oppurtunityId = oppurtunityId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDealStatus() {
		return dealStatus;
	}

	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}

	public String getBusinessSpocName() {
		return businessSpocName;
	}

	public void setBusinessSpocName(String businessSpocName) {
		this.businessSpocName = businessSpocName;
	}

	public String getClientInteraction() {
		return clientInteraction;
	}

	public void setClientInteraction(String clientInteraction) {
		this.clientInteraction = clientInteraction;
	}

	public String getIouOrIsu() {
		return iouOrIsu;
	}

	public void setIouOrIsu(String iouOrIsu) {
		this.iouOrIsu = iouOrIsu;
	}

	public String getDealValue() {
		return dealValue;
	}

	public void setDealValue(String dealValue) {
		this.dealValue = dealValue;
	}

	public String getWorkArea() {
		return workArea;
	}

	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}

	public String getPeopleTransistion() {
		return peopleTransistion;
	}

	public void setPeopleTransistion(String peopleTransistion) {
		this.peopleTransistion = peopleTransistion;
	}

	public String getKickOffPeopleTransistion() {
		return kickOffPeopleTransistion;
	}

	public void setKickOffPeopleTransistion(String kickOffPeopleTransistion) {
		this.kickOffPeopleTransistion = kickOffPeopleTransistion;
	}

	public String getGlobalDeal() {
		return globalDeal;
	}

	public void setGlobalDeal(String globalDeal) {
		this.globalDeal = globalDeal;
	}

	public String getDealLocation() {
		return dealLocation;
	}

	public void setDealLocation(String dealLocation) {
		this.dealLocation = dealLocation;
	}

	public String getGeographyWithInScope() {
		return geographyWithInScope;
	}

	public void setGeographyWithInScope(String geographyWithInScope) {
		this.geographyWithInScope = geographyWithInScope;
	}

	public String getDealLead() {
		return dealLead;
	}

	public void setDealLead(String dealLead) {
		this.dealLead = dealLead;
	}

	public String getServiceCommencementDate() {
		return serviceCommencementDate;
	}

	public void setServiceCommencementDate(String serviceCommencementDate) {
		this.serviceCommencementDate = serviceCommencementDate;
	}

	public String getOfferReleaseMonth() {
		return offerReleaseMonth;
	}

	public void setOfferReleaseMonth(String offerReleaseMonth) {
		this.offerReleaseMonth = offerReleaseMonth;
	}

	public String getProposedJoiningDate() {
		return proposedJoiningDate;
	}

	public void setProposedJoiningDate(String proposedJoiningDate) {
		this.proposedJoiningDate = proposedJoiningDate;
	}

	public String getNumberOfOffersToBeReleased() {
		return numberOfOffersToBeReleased;
	}

	public void setNumberOfOffersToBeReleased(String numberOfOffersToBeReleased) {
		this.numberOfOffersToBeReleased = numberOfOffersToBeReleased;
	}

	public String getOfferReleasedThrough() {
		return offerReleasedThrough;
	}

	public void setOfferReleasedThrough(String offerReleasedThrough) {
		this.offerReleasedThrough = offerReleasedThrough;
	}

	public String getHrTransitionManager() {
		return hrTransitionManager;
	}

	public void setHrTransitionManager(String hrTransitionManager) {
		this.hrTransitionManager = hrTransitionManager;
	}

	public String getExceptionCategory() {
		return exceptionCategory;
	}

	public void setExceptionCategory(String exceptionCategory) {
		this.exceptionCategory = exceptionCategory;
	}

	public String getDealException() {
		return dealException;
	}

	public void setDealException(String dealException) {
		this.dealException = dealException;
	}

	public String getExceptionSummary() {
		return exceptionSummary;
	}

	public void setExceptionSummary(String exceptionSummary) {
		this.exceptionSummary = exceptionSummary;
	}

	public String getExceptionApprovedBy() {
		return exceptionApprovedBy;
	}

	public void setExceptionApprovedBy(String exceptionApprovedBy) {
		this.exceptionApprovedBy = exceptionApprovedBy;
	}

	public String getHrCostingTenets() {
		return hrCostingTenets;
	}

	public void setHrCostingTenets(String hrCostingTenets) {
		this.hrCostingTenets = hrCostingTenets;
	}

	public String getHrSolutionTenets() {
		return hrSolutionTenets;
	}

	public void setHrSolutionTenets(String hrSolutionTenets) {
		this.hrSolutionTenets = hrSolutionTenets;
	}

	public String getDealSolutionSummary() {
		return dealSolutionSummary;
	}

	public void setDealSolutionSummary(String dealSolutionSummary) {
		this.dealSolutionSummary = dealSolutionSummary;
	}

	public String getPeopleTransitionJoinersData() {
		return peopleTransitionJoinersData;
	}

	public void setPeopleTransitionJoinersData(String peopleTransitionJoinersData) {
		this.peopleTransitionJoinersData = peopleTransitionJoinersData;
	}

	public String getDealNote() {
		return dealNote;
	}

	public void setDealNote(String dealNote) {
		this.dealNote = dealNote;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public DealFileAttachment getExceptionApprovedFile() {
		return exceptionApprovedFile;
	}

	public void setExceptionApprovedFile(DealFileAttachment exceptionApprovedFile) {
		this.exceptionApprovedFile = exceptionApprovedFile;
	}

	public DealFileAttachment getHrCostingTenetsFile() {
		return hrCostingTenetsFile;
	}

	public void setHrCostingTenetsFile(DealFileAttachment hrCostingTenetsFile) {
		this.hrCostingTenetsFile = hrCostingTenetsFile;
	}

	public DealFileAttachment getHrSolutionTenetsFile() {
		return hrSolutionTenetsFile;
	}

	public void setHrSolutionTenetsFile(DealFileAttachment hrSolutionTenetsFile) {
		this.hrSolutionTenetsFile = hrSolutionTenetsFile;
	}

	public DealFileAttachment getDealSolutionSummaryFile() {
		return dealSolutionSummaryFile;
	}

	public void setDealSolutionSummaryFile(DealFileAttachment dealSolutionSummaryFile) {
		this.dealSolutionSummaryFile = dealSolutionSummaryFile;
	}

	public DealFileAttachment getPeopleTransitionJoinersDataFile() {
		return peopleTransitionJoinersDataFile;
	}

	public void setPeopleTransitionJoinersDataFile(DealFileAttachment peopleTransitionJoinersDataFile) {
		this.peopleTransitionJoinersDataFile = peopleTransitionJoinersDataFile;
	}

	public List<DealFileAttachment> getDealAttachments() {
		return dealAttachments;
	}

	public void setDealAttachments(List<DealFileAttachment> dealAttachments) {
		this.dealAttachments = dealAttachments;
	}

	public List<Integer> getAttachmentIds() {
		return attachmentIds;
	}

	public void setAttachmentIds(List<Integer> attachmentIds) {
		this.attachmentIds = attachmentIds;
	}

}
