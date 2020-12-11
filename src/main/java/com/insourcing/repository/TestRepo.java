package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.TestEntity;;

@Repository
public interface TestRepo extends JpaRepository<TestEntity, Object>{
	

}
