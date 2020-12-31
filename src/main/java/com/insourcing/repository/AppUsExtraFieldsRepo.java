package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.AppUsExtraFieldsEntity;

@Repository
public interface AppUsExtraFieldsRepo extends JpaRepository<AppUsExtraFieldsEntity, Object> {

	public AppUsExtraFieldsEntity findByDealId(String dealId);

}