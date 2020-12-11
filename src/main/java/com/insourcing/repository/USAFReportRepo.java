package com.insourcing.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.USAFReportEntity;

@Repository
public interface USAFReportRepo extends JpaRepository<USAFReportEntity, Object>{
	
	public List<USAFReportEntity> findAll();

}
