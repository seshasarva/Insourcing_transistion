package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.WorkflowSeqEntity;

@Repository
public interface WorkFlowSeqRepo extends JpaRepository<WorkflowSeqEntity, Object> {

	public WorkflowSeqEntity findByDealId(String dealId);

}
