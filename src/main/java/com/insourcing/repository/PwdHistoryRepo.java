package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.insourcing.entity.PasswordHistoryEntityMap;

@Repository
public interface PwdHistoryRepo extends JpaRepository<PasswordHistoryEntityMap, Object> {
	
	public PasswordHistoryEntityMap findByEmailId(String email);
		
	}

  