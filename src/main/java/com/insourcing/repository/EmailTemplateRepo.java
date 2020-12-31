package com.insourcing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.EmailTempEntity;

@Repository
public interface EmailTemplateRepo extends JpaRepository<EmailTempEntity, Object> {

	public EmailTempEntity findByTemplateName(String templateName);

    @Query("select a from EmailTempEntity a where a.emailId = ?1")
   //@Query("select a from EmailTempEntity a")
	public List<EmailTempEntity> findByEmaiId(String emailId);
}


