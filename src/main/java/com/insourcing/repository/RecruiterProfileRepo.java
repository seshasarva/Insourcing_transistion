package com.insourcing.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.RecruiterProfileEntity;

@Repository
public interface RecruiterProfileRepo extends JpaRepository<RecruiterProfileEntity, Object>{
	@Transactional
	@Modifying
	@Query("delete from  RecruiterProfileEntity a where a.id = ?1")
	public void deleteEntry(int id);
}
