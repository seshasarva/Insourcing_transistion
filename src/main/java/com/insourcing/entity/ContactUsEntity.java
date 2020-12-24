package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "contact_us_table")
@IdClass(ContactUsId.class)
public class ContactUsEntity {
	@Id
	private String id;
	@Id
	private String tileName;
	@Column
	private String header;
	@Column
	private String name;
	@Column
	private String phone;	
	@Column
	private String emailId;
	@Column
	private byte[] img;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTileName() {
		return tileName;
	}
	public void setTileName(String tileName) {
		this.tileName = tileName;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
