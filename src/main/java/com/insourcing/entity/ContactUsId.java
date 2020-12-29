package com.insourcing.entity;

import java.io.Serializable;

public class ContactUsId implements Serializable{
	private String id;

    private String tileName;
    
    public ContactUsId() {
    	
    }

    public ContactUsId(String id, String tileName) {
        this.id = id;
        this.tileName = tileName;
    }

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
    
    
}
