package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.insourcing.entity.ApplicationIndiaEntityMap;

@Repository
public interface ApplicationIndiaRepo extends JpaRepository<ApplicationIndiaEntityMap, Object> {
	
	public ApplicationIndiaEntityMap findByEmailId(String emailId);

}
