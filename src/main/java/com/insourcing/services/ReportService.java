package com.insourcing.services;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.entity.USAFReportEntity;
import com.insourcing.entity.USEduEmpReportEntity;
import com.insourcing.helper.ExcelHelper;
import com.insourcing.model.IndiaReportModel;
import com.insourcing.model.MySpaceModel;
import com.insourcing.model.OfferStatus;
import com.insourcing.model.SkillCount;
import com.insourcing.repository.ApplicationIndiaRepo;
import com.insourcing.repository.ApplicationUSRepo;
import com.insourcing.repository.CandidateRepo;
import com.insourcing.repository.OfferIndiaRepo;
import com.insourcing.repository.USAFReportRepo;
import com.insourcing.repository.USEduEmpReportRepo;

@SuppressWarnings({"unused" })
@Service
public class ReportService {
	
	@Autowired
	public CandidateRepo candRepo;

	@Autowired
	public ApplicationUSRepo appUSRepo;

	@Autowired
	public ApplicationIndiaRepo appIndRepo;

	@Autowired
	public USAFReportRepo usafRepo;

	@Autowired
	public USEduEmpReportRepo eduEmpUSReport;

	@Autowired
	public OfferIndiaRepo offerIndRepo;

	private static Logger logger = LogManager.getLogger(ReportService.class);
	
	public ByteArrayInputStream getAFReport() {
		logger.info("getAFReport - Entry");
		List<USAFReportEntity> afreportlist = usafRepo.findAll();
		ByteArrayInputStream in = ExcelHelper.toexcelAFReport(afreportlist);
		logger.info("getAFReport - Exit");
		return in;
	}

	public ByteArrayInputStream getEduEmpReport() {
		logger.info("getEduEmpReport - Entry");
		List<USEduEmpReportEntity> eduempreportlist = eduEmpUSReport.findAll();
		ByteArrayInputStream in = ExcelHelper.toexcelEduEmpReport(eduempreportlist);
		logger.info("getEduEmpReport - Exit");
		return in;
	}

	public ByteArrayInputStream getOfferRetReport() {
		logger.info("getOfferRetReport - Entry");
		List<CandidateEntityMap> offerRetreportlist = candRepo.findAll();
		ByteArrayInputStream in = ExcelHelper.toexcelOfferRetReport(offerRetreportlist);
		logger.info("getOfferRetReport - Exit");
		return in;
	}

	public ByteArrayInputStream getIndiaReport() {
		logger.info("getIndiaReport - Entry");
		List<IndiaReportModel> reportIndialist = offerIndRepo.offerIndiaReport();
		ByteArrayInputStream in = ExcelHelper.toexcelIndiaReport(reportIndialist);
		logger.info("getIndiaReport - Exit");
		return in;
	}

	public MySpaceModel mySpaceUS() {
		logger.info("mySpaceUS - Entry");
		long headCount = 0;
		long offerCount = 0;
		long joinerCount = 0;
		long offerAccept = 0;

		List<CandidateEntityMap> candEntity = candRepo.findAll();

		for(CandidateEntityMap c: candEntity) {
			headCount = headCount+1;
			if(c.getOfferFile() != null)
				offerCount = offerCount+1;
			if(c.isJoinerStatus())
				joinerCount = joinerCount+1;
			if(c.getOfferStatus() != null && c.getOfferStatus().equalsIgnoreCase(OfferStatus.ACCEPTED.toString()))
				offerAccept = offerAccept+1;
		}
		List<SkillCount> skillsCount = candRepo.countByUSSkills();
		long offerAcceptRatio = (offerAccept/offerCount)* 100;
		long skillCount = 0;
		for(SkillCount s : skillsCount) {
			skillCount = skillCount+1;
		}
		MySpaceModel mySpaceModel = new MySpaceModel();
		mySpaceModel.setHeadCount(headCount);
		mySpaceModel.setJoinerCount(joinerCount);
		mySpaceModel.setOfferCount(offerCount);
		mySpaceModel.setOfferAccept(String.valueOf(offerAcceptRatio+"%"));
		mySpaceModel.setSkillsCount(skillCount);
		logger.info("mySpaceUS - Exit");
		return mySpaceModel;
	}

	public MySpaceModel mySpaceIndia() {
		logger.info("mySpaceIndia - Entry");
		long headCount = 0;
		long offerCount = 0;
		long joinerCount = 0;
		long offerAccept = 0;
		long offerAcceptRatio = 0;
		long skillCount = 0;
		List<CandidateEntityMap> candEntity = candRepo.findByIndia();

		for (CandidateEntityMap c : candEntity) {
			headCount = headCount+1;
			if(c.getOfferFile() != null)
				offerCount = offerCount+1;
			if(c.isJoinerStatus())
				joinerCount = joinerCount+1;
			if(c.getOfferStatus() != null && c.getOfferStatus().equalsIgnoreCase(OfferStatus.ACCEPTED.toString()))
				offerAccept = offerAccept+1;
		}
		List<SkillCount> skillsCount = candRepo.countByIndiaSkills();
		if(offerCount != 0)
			offerAcceptRatio = (offerAccept/offerCount)* 100;

		for(SkillCount s : skillsCount) {
			skillCount = skillCount+1;
		}
		MySpaceModel mySpaceModel = new MySpaceModel();
		mySpaceModel.setHeadCount(headCount);
		mySpaceModel.setJoinerCount(joinerCount);
		mySpaceModel.setOfferCount(offerCount);
		mySpaceModel.setOfferAccept(String.valueOf(offerAcceptRatio+"%"));
		mySpaceModel.setSkillsCount(skillCount);
		logger.info("mySpaceIndia - Exit");
		return mySpaceModel;
	}


}
