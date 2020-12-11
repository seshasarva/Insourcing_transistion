package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;

import com.insourcing.entity.DealAttachment;;

@Repository
public interface DealAttachmentRepo extends JpaRepository<DealAttachment, Object> {
	
	//@Query("select a.dealNoteFile from DealAttachment a where a.id = ?1")
	//byte[] downloadDealNoteFile(Long id);
	//@Query("update")
	@Modifying
	@Query("update DealAttachment c set c.dealId = ?2 where c.id = ?1")
	void update(Long id, Long dealId);
	
	@Query("select a from DealAttachment a where a.dealId = ?1")
	List<DealAttachment> fetchByDealid(long id);
	
}
