package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "deal_attachments")
public class DealNotesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "deal_note_file_name")
	String dealNoteFileName;
	@Column(name = "deal_note_file")
	byte[] dealNoteFile;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private DealEntity deal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealNoteFileName() {
		return dealNoteFileName;
	}

	public void setDealNoteFileName(String dealNoteFileName) {
		this.dealNoteFileName = dealNoteFileName;
	}

	public byte[] getDealNoteFile() {
		return dealNoteFile;
	}

	public void setDealNoteFile(byte[] dealNoteFile) {
		this.dealNoteFile = dealNoteFile;
	}

	@JsonBackReference
	public DealEntity getDeal() {
		return deal;
	}

	public void setDeal(DealEntity deal) {
		this.deal = deal;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DealNotesEntity )) return false;
        return id != null && id.equals(((DealNotesEntity) o).getId());
    }
 
    @Override
    public int hashCode() {
        return 31;
    }

}
