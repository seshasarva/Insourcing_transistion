package com.insourcing.entity;

import java.io.Serializable;

public class ContactUsId implements Serializable{
	private long id;

    private String tileName;
    
    public ContactUsId() {
    	
    }

    public ContactUsId(long id, String tileName) {
        this.id = id;
        this.tileName = tileName;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTileName() {
		return tileName;
	}

	public void setTileName(String tileName) {
		this.tileName = tileName;
	}
    
    
}
