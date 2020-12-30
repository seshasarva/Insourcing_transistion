package com.insourcing.entity;

import java.io.Serializable;

public class ExploreTcsId implements Serializable{
	private String id;

    private int index;
    
    public ExploreTcsId() {
    	
    }

    public ExploreTcsId(String id, int index) {
        this.id = id;
        this.index = index;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
}
