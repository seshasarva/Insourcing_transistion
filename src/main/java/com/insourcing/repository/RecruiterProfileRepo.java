package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.CRFEntity;
import com.insourcing.entity.RecruiterProfileEntity;

@Repository
public interface RecruiterProfileRepo extends JpaRepository<RecruiterProfileEntity, Object>{

}
