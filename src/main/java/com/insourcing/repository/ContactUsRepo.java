package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.ContactUsEntity;

@Repository
public interface ContactUsRepo extends JpaRepository<ContactUsEntity, Object>{

}
