package com.insourcing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.model.ExcelModel;
import com.insourcing.model.SkillCount;

@Repository
public interface CandidateRepo extends JpaRepository<CandidateEntityMap, Object> {

	@Query("select new com.insourcing.model.ExcelModel(a.firstname as Firstname, a.middlename as Middlename, a.lastname as Lastname, a.emailid as Emailid, a.password as CreatePassword) from CandidateEntityMap a where a.country = 'India' order by a.date asc")
	public List<ExcelModel> findByListIndia();
//order by a.date asc
	@Query("select new com.insourcing.model.ExcelModel(a.firstname as Firstname, a.middlename as Middlename, a.lastname as Lastname, a.emailid as Emailid, a.password as CreatePassword) from CandidateEntityMap a where a.country = 'US' order by a.date asc")
	public List<ExcelModel> findByListUS();
// order by a.date asc
	@Query("select max(a.id) from CandidateEntityMap a")
	public int refid();

	public CandidateEntityMap findByEmailidAndPassword(String email, String password);

	public CandidateEntityMap findByEmailid(String emailId);

	@Query("select a from CandidateEntityMap a where a.country = 'US'")
	public List<CandidateEntityMap> findAll();

	@Query("select a from CandidateEntityMap a where a.country = 'India'")
	public List<CandidateEntityMap> findByIndia();

	@Query("select new com.insourcing.model.SkillCount(a.skills as Skills, count(*) as Count) from CandidateEntityMap a where a.country = 'US' group by a.skills")
	public List<SkillCount> countByUSSkills();

	@Query("select new com.insourcing.model.SkillCount(a.skills as Skills, count(*) as Count) from CandidateEntityMap a where a.country = 'India' group by a.skills")
	public List<SkillCount> countByIndiaSkills();

	@Modifying
	@Query("update CandidateEntityMap c set c.password = ?2 where c.emailid = ?1")
	public void saveForgotPasswordById(String emailId, String newPassword);
	
	@Query("select a from CandidateEntityMap a where a.dealId = ?1")
	public List<CandidateEntityMap> findByDealId(String dealId);

}