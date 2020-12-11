package com.insourcing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.OfferIndiaEntity;
import com.insourcing.model.IndiaReportModel;

@Repository
public interface OfferIndiaRepo extends JpaRepository<OfferIndiaEntity, Object>{

	@Query("select new com.insourcing.model.IndiaReportModel(o.refId as AppId, o.title as Title, o.firstname as Firstname, o.middlename as Middlename,"
			+ "o.lastname as Lastname, o.emailId as EmailId, o.grade as Grade, o.offerStatus as OfferStatus, "
			+ "o.appFormStatus as AppFormStatus, o.appLetterStatus as AppointLetterStatus, o.offerReleaseDate as OfferReleaseDate) from OfferIndiaEntity o")
	public List<IndiaReportModel> offerIndiaReport();
	
	public OfferIndiaEntity findByEmailId(String emailid);
	
}
