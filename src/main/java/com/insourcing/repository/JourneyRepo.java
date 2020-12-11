package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.JourneyEntity;

@Repository
public interface JourneyRepo extends JpaRepository<JourneyEntity, Object>{
	
}
