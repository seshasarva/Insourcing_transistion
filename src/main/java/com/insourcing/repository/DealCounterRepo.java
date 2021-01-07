package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.DealCounter;

@Repository
public interface DealCounterRepo extends JpaRepository<DealCounter, Object>{

}
