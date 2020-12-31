package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.insourcing.entity.HRPwdHistoryEntityMap;

@Repository
public interface HRPwdHistoryRepo extends JpaRepository<HRPwdHistoryEntityMap, Object> {
	
	public HRPwdHistoryEntityMap findByEmailId(String email);
		
}

