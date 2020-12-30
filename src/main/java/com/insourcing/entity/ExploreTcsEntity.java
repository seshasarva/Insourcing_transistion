package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "explore_tcs_table")
@IdClass(ExploreTcsId.class)
public class ExploreTcsEntity {
	@Id
	private String id;
	@Id
	private int index;
	@Column(name = "cover_image")
	private byte[] coverImage;
	@Column(name = "cover_image_file")
	private String coverImageFile;
	@Column(name = "poster")
	private byte[] poster;
	@Column(name = "poster_file")
	private String posterFile;
	@Column(name = "video")
	private byte[] video;
	@Column(name = "video_file")
	private String videoFile;
	@Column(name = "content")
	private String content;
	@Column(name = "header")
	private String header;
	@Column(name = "benifits")
	private String benifits;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte[] getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(byte[] coverImage) {
		this.coverImage = coverImage;
	}
	public String getCoverImageFile() {
		return coverImageFile;
	}
	public void setCoverImageFile(String coverImageFile) {
		this.coverImageFile = coverImageFile;
	}
	public byte[] getPoster() {
		return poster;
	}
	public void setPoster(byte[] poster) {
		this.poster = poster;
	}
	public String getPosterFile() {
		return posterFile;
	}
	public void setPosterFile(String posterFile) {
		this.posterFile = posterFile;
	}
	public byte[] getVideo() {
		return video;
	}
	public void setVideo(byte[] video) {
		this.video = video;
	}
	public String getVideoFile() {
		return videoFile;
	}
	public void setVideoFile(String videoFile) {
		this.videoFile = videoFile;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBenifits() {
		return benifits;
	}
	public void setBenifits(String benifits) {
		this.benifits = benifits;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	
}
