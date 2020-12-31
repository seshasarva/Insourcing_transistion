package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.AppIndiaExtraFieldsEntity;

@Repository
public interface AppIndiaExtraFieldsRepo extends JpaRepository<AppIndiaExtraFieldsEntity, Object> {

	public AppIndiaExtraFieldsEntity findByDealId(String dealId);
}
