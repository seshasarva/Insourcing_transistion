package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.CRFEntity;

@Repository
public interface CRFRepo extends JpaRepository<CRFEntity, Object>{

}
