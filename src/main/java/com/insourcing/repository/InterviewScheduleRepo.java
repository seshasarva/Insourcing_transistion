package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.InterviewScheduleEntity;

@Repository
public interface InterviewScheduleRepo extends JpaRepository<InterviewScheduleEntity, Object>{

}
