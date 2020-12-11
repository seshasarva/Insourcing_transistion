package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.insourcing.entity.ApplicationUSEntityMap;

@Repository
public interface ApplicationUSRepo extends JpaRepository<ApplicationUSEntityMap, Object> {

	public ApplicationUSEntityMap findByEmailid(String emailId);

}
