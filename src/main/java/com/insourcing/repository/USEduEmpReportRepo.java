package com.insourcing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.*;

@Repository
public interface USEduEmpReportRepo extends JpaRepository<USEduEmpReportEntity, String>{
	
	public List<USEduEmpReportEntity> findAll();

}
