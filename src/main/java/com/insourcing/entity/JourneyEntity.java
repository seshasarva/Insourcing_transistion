package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_journey_table")
public class JourneyEntity {
	@Id
	private String id;
	@Column
	private String blogRegistration;
	@Column
	private String blogInduction;
	@Column
	private String blogEvaluation;
	@Column
	private String blogOffer;
	@Column
	private String newContent;
	@Column
	private String checklistFile;
	@Column
	private byte[] checklist;
	@Column
	private String testimonialsFile;
	@Column
	private byte[] testimonials;
	@Column
	private String inductionVideoFile;
	@Column
	private byte[] inductionVideo;
	@Column
	private String instructionVideoFile;
	@Column
	private byte[] instructionVideo;
	@Column
	private String urlFile;
	@Column
	private byte[] url;
	@Column
	private String thirdPartUrlsFile;
	@Column
	private byte[] thirdPartUrls;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBlogRegistration() {
		return blogRegistration;
	}
	public void setBlogRegistration(String blogRegistration) {
		this.blogRegistration = blogRegistration;
	}
	public String getBlogInduction() {
		return blogInduction;
	}
	public void setBlogInduction(String blogInduction) {
		this.blogInduction = blogInduction;
	}
	public String getBlogEvaluation() {
		return blogEvaluation;
	}
	public void setBlogEvaluation(String blogEvaluation) {
		this.blogEvaluation = blogEvaluation;
	}
	public String getBlogOffer() {
		return blogOffer;
	}
	public void setBlogOffer(String blogOffer) {
		this.blogOffer = blogOffer;
	}
	public String getNewContent() {
		return newContent;
	}
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	public byte[] getChecklist() {
		return checklist;
	}
	public void setChecklist(byte[] checklist) {
		this.checklist = checklist;
	}
	public byte[] getTestimonials() {
		return testimonials;
	}
	public void setTestimonials(byte[] testimonials) {
		this.testimonials = testimonials;
	}
	public byte[] getInductionVideo() {
		return inductionVideo;
	}
	public void setInductionVideo(byte[] inductionVideo) {
		this.inductionVideo = inductionVideo;
	}
	public byte[] getInstructionVideo() {
		return instructionVideo;
	}
	public void setInstructionVideo(byte[] instructionVideo) {
		this.instructionVideo = instructionVideo;
	}
	public byte[] getUrl() {
		return url;
	}
	public void setUrl(byte[] url) {
		this.url = url;
	}
	public byte[] getThirdPartUrls() {
		return thirdPartUrls;
	}
	public void setThirdPartUrls(byte[] thirdPartUrls) {
		this.thirdPartUrls = thirdPartUrls;
	}
	public String getChecklistFile() {
		return checklistFile;
	}
	public void setChecklistFile(String checklistFile) {
		this.checklistFile = checklistFile;
	}
	public String getTestimonialsFile() {
		return testimonialsFile;
	}
	public void setTestimonialsFile(String testimonialsFile) {
		this.testimonialsFile = testimonialsFile;
	}
	public String getInductionVideoFile() {
		return inductionVideoFile;
	}
	public void setInductionVideoFile(String inductionVideoFile) {
		this.inductionVideoFile = inductionVideoFile;
	}
	public String getInstructionVideoFile() {
		return instructionVideoFile;
	}
	public void setInstructionVideoFile(String instructionVideoFile) {
		this.instructionVideoFile = instructionVideoFile;
	}
	public String getUrlFile() {
		return urlFile;
	}
	public void setUrlFile(String urlFile) {
		this.urlFile = urlFile;
	}
	public String getThirdPartUrlsFile() {
		return thirdPartUrlsFile;
	}
	public void setThirdPartUrlsFile(String thirdPartUrlsFile) {
		this.thirdPartUrlsFile = thirdPartUrlsFile;
	}
	
	
}
