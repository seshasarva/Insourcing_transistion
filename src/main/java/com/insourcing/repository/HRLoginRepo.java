package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.insourcing.entity.HRLoginEntity;

@Repository
public interface HRLoginRepo extends JpaRepository<HRLoginEntity, Object>{
	
	public HRLoginEntity findByEmailIdAndPassword(String email, String password);
	
	public HRLoginEntity findByEmailId(String email);

}
