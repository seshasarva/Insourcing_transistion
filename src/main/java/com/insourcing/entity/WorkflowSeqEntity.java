package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workflow_sequence")
public class WorkflowSeqEntity {

	@Id
	@Column(name = "dealId")
	private String dealId;
	@Column(name = "flowSeqOne")
	private String flowSeqOne;
	@Column(name = "flowSeqTwo")
	private String flowSeqTwo;
	@Column(name = "flowSeqThree")
	private String flowSeqThree;
	@Column(name = "flowSeqFour")
	private String flowSeqFour;
	@Column(name = "flowSeqFive")
	private String flowSeqFive;
	@Column(name = "flowSeqSix")
	private String flowSeqSix;
	@Column(name = "flowSeqSeven")
	private String flowSeqSeven;
	@Column(name = "flowSeqEight")
	private String flowSeqEight;
	@Column(name = "flowSeqNine")
	private String flowSeqNine;
	@Column(name = "flowSeqTen")
	private String flowSeqTen;

	public WorkflowSeqEntity() {
		super();
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getFlowSeqOne() {
		return flowSeqOne;
	}

	public void setFlowSeqOne(String flowSeqOne) {
		this.flowSeqOne = flowSeqOne;
	}

	public String getFlowSeqTwo() {
		return flowSeqTwo;
	}

	public void setFlowSeqTwo(String flowSeqTwo) {
		this.flowSeqTwo = flowSeqTwo;
	}

	public String getFlowSeqThree() {
		return flowSeqThree;
	}

	public void setFlowSeqThree(String flowSeqThree) {
		this.flowSeqThree = flowSeqThree;
	}

	public String getFlowSeqFour() {
		return flowSeqFour;
	}

	public void setFlowSeqFour(String flowSeqFour) {
		this.flowSeqFour = flowSeqFour;
	}

	public String getFlowSeqFive() {
		return flowSeqFive;
	}

	public void setFlowSeqFive(String flowSeqFive) {
		this.flowSeqFive = flowSeqFive;
	}

	public String getFlowSeqSix() {
		return flowSeqSix;
	}

	public void setFlowSeqSix(String flowSeqSix) {
		this.flowSeqSix = flowSeqSix;
	}

	public String getFlowSeqSeven() {
		return flowSeqSeven;
	}

	public void setFlowSeqSeven(String flowSeqSeven) {
		this.flowSeqSeven = flowSeqSeven;
	}

	public String getFlowSeqEight() {
		return flowSeqEight;
	}

	public void setFlowSeqEight(String flowSeqEight) {
		this.flowSeqEight = flowSeqEight;
	}

	public String getFlowSeqNine() {
		return flowSeqNine;
	}

	public void setFlowSeqNine(String flowSeqNine) {
		this.flowSeqNine = flowSeqNine;
	}

	public String getFlowSeqTen() {
		return flowSeqTen;
	}

	public void setFlowSeqTen(String flowSeqTen) {
		this.flowSeqTen = flowSeqTen;
	}

	@Override
	public String toString() {
		return "WorkflowSeqEntity [dealId=" + dealId + ", flowSeqOne=" + flowSeqOne + ", flowSeqTwo=" + flowSeqTwo
				+ ", flowSeqThree=" + flowSeqThree + ", flowSeqFour=" + flowSeqFour + ", flowSeqFive=" + flowSeqFive
				+ ", flowSeqSix=" + flowSeqSix + ", flowSeqSeven=" + flowSeqSeven + ", flowSeqEight=" + flowSeqEight
				+ ", flowSeqNine=" + flowSeqNine + ", flowSeqTen=" + flowSeqTen + "]";
	}

}
