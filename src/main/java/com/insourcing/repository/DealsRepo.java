package com.insourcing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.DealEntity;

@Repository
public interface DealsRepo extends JpaRepository<DealEntity, Object>{
	@Query("select a from DealEntity a where a.dealLead = ?1")
	public List<DealEntity> findDealsByLead(String dealLead);
}
