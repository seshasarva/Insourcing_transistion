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
	private boolean isTile1DisplayEligible;
	@Column(name = "tile2")
	private boolean isTile2DisplayEligible;
	@Column(name = "tile3")
	private boolean isTile3DisplayEligible;
	@Column(name = "tile4")
	private boolean isTile4DisplayEligible;
	@Column(name = "tile5")
	private boolean isTile5DisplayEligible;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isTile1DisplayEligible() {
		return isTile1DisplayEligible;
	}
	public void setTile1DisplayEligible(boolean isTile1DisplayEligible) {
		this.isTile1DisplayEligible = isTile1DisplayEligible;
	}
	public boolean isTile2DisplayEligible() {
		return isTile2DisplayEligible;
	}
	public void setTile2DisplayEligible(boolean isTile2DisplayEligible) {
		this.isTile2DisplayEligible = isTile2DisplayEligible;
	}
	public boolean isTile3DisplayEligible() {
		return isTile3DisplayEligible;
	}
	public void setTile3DisplayEligible(boolean isTile3DisplayEligible) {
		this.isTile3DisplayEligible = isTile3DisplayEligible;
	}
	public boolean isTile4DisplayEligible() {
		return isTile4DisplayEligible;
	}
	public void setTile4DisplayEligible(boolean isTile4DisplayEligible) {
		this.isTile4DisplayEligible = isTile4DisplayEligible;
	}
	public boolean isTile5DisplayEligible() {
		return isTile5DisplayEligible;
	}
	public void setTile5DisplayEligible(boolean isTile5DisplayEligible) {
		this.isTile5DisplayEligible = isTile5DisplayEligible;
	}
	
	
}
