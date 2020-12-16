package com.insourcing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "explore_tcs_table")
public class ExploreTcsEntity {
	@Id
	private Long id;

	@Column(name = "tile1")
	private String tile1;
	@Column(name = "tile2")
	private String tile2;
	@Column(name = "tile3")
	private String tile3;
	@Column(name = "tile4")
	private String tile4;
	@Column(name = "tile5")
	private String tile5;
	public String getTile2() {
		return tile2;
	}
	public void setTile2(String tile2) {
		this.tile2 = tile2;
	}
	public String getTile3() {
		return tile3;
	}
	public void setTile3(String tile3) {
		this.tile3 = tile3;
	}
	public String getTile4() {
		return tile4;
	}
	public void setTile4(String tile4) {
		this.tile4 = tile4;
	}
	public String getTile5() {
		return tile5;
	}
	public void setTile5(String tile5) {
		this.tile5 = tile5;
	}
	public String getTile1() {
		return tile1;
	}
	public void setTile1(String tile1) {
		this.tile1 = tile1;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	
	
	
}
