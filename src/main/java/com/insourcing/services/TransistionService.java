package com.insourcing.services;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.insourcing.entity.CRFEntity;
import com.insourcing.entity.ContactUsEntity;
import com.insourcing.entity.DealAttachment;
import com.insourcing.entity.ExploreTcsEntity;
import com.insourcing.entity.InterviewScheduleEntity;
import com.insourcing.entity.JourneyEntity;
import com.insourcing.repository.CRFRepo;
import com.insourcing.repository.ContactUsRepo;
import com.insourcing.repository.ExploreTcsRepo;
import com.insourcing.repository.InterviewScheduleRepo;
import com.insourcing.repository.JourneyRepo;

@Service
public class TransistionService {
	
	public ExploreTcsEntity fetchExploreTcsDetails(long id) {
		Optional<ExploreTcsEntity> deal = exploreTcsRepo.findById(id);
		try {
			if(null != deal && deal.isPresent()) {
				return deal.get();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean saveExploreTcs(ExploreTcsEntity exploreTcsEntity) {
		try {
			exploreTcsRepo.save(exploreTcsEntity);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<ContactUsEntity> fetchContactUsDetails(long id) {
		List<ContactUsEntity> deals = contactUsRepo.findAll();
		List<ContactUsEntity> filtered = new ArrayList<ContactUsEntity>();
		for(ContactUsEntity deal : deals) {
			if(deal.getId()== id)
			filtered.add(deal);
		}
		return filtered;
	}
	
	public boolean saveContactUsEntity(List<ContactUsEntity> entities) {
		try {
			contactUsRepo.saveAll(entities);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Transactional
	public boolean saveContactUsImage(MultipartFile file, long id, String tileName) {
		try {	
			Optional<ContactUsEntity> deal = contactUsRepo.findById(id);
			if(null != deal && deal.isPresent()) {
				ContactUsEntity dealEntity = deal.get();
				dealEntity.setImg(file.getBytes());
				contactUsRepo.save(dealEntity);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public JourneyEntity fetchMyJourneyDetails(long id) {
		Optional<JourneyEntity> entity = journeyRepo.findById(id);
		if(null != entity && null != entity.get()) {
			JourneyEntity journeyEntity = entity.get();
			journeyEntity.setChecklist(null);
			journeyEntity.setInductionVideo(null);
			journeyEntity.setInstructionVideo(null);
			journeyEntity.setTestimonials(null);
			journeyEntity.setThirdPartUrls(null);
			journeyEntity.setUrl(null);
			return journeyEntity;
		}
		return null;
	}
	
	public boolean saveJourneyDetails(JourneyEntity entity) {
		journeyRepo.save(entity);
		return true;
	}
	@Transactional
	public boolean uploadJourneyAttachments(MultipartFile file, long id, String fieldName) {
		try {
			Optional<JourneyEntity> entity = journeyRepo.findById(id);
			if(null != entity && entity.isPresent()) {
				JourneyEntity journeyEntity = entity.get();
				switch(fieldName) {
				case "checklist":
					journeyEntity.setChecklist(file.getBytes());
					journeyEntity.setChecklistFile(file.getOriginalFilename());
					break;
				case "testimonials":
					journeyEntity.setTestimonials(file.getBytes());
					journeyEntity.setTestimonialsFile(file.getOriginalFilename());
					break;
				case "inductionVideo":
					journeyEntity.setInductionVideo(file.getBytes());
					journeyEntity.setInductionVideoFile(file.getOriginalFilename());
					break;
				case "instructionVideo":
					journeyEntity.setInstructionVideo(file.getBytes());
					journeyEntity.setInstructionVideoFile(file.getOriginalFilename());
					break;
				case "url":
					journeyEntity.setUrl(file.getBytes());
					journeyEntity.setUrlFile(file.getOriginalFilename());
					break;
				case "thirdPartUrls":
					journeyEntity.setThirdPartUrls(file.getBytes());
					journeyEntity.setThirdPartUrlsFile(file.getOriginalFilename());
					break;
	
				}
				journeyRepo.save(journeyEntity);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean saveCrf(long id, String json, String field) throws JsonMappingException, JsonProcessingException {
		Optional<CRFEntity> deal = crfRepo.findById(id);
		CRFEntity entity = null;
		if(null != deal && deal.isPresent()) {
			entity = deal.get();
		}else {
			entity = defaultCrfJson();
			entity.setId(id);
		}
		switch (field) {
		case "euStatusMangement": entity.setEuStatusManagement(json);break;
		case "noneuStatusMaangement":entity.setNoneuApplicationForm(json);break;
		case "euApplForm":entity.setEuApplicationForm(json);break;
		case "noneuApplForm":entity.setNoneuApplicationForm(json);break;
		}
		crfRepo.save(entity);
		return true;
	}
	
	public CRFEntity fetchCrf(long id) throws JsonMappingException, JsonProcessingException {
		Optional<CRFEntity> deal = crfRepo.findById(id);
		if(null != deal && deal.isPresent()) {
			CRFEntity crf = deal.get();
			return crf;
		}else {
			return defaultCrfJson();
		}
	}
	

	
	public InterviewScheduleEntity fetchInterviewSchedule(long id) {
		Optional<InterviewScheduleEntity> deal = interviewScheduleRepo.findById(id);
		if(null != deal && null != deal.get()) {
			return deal.get();
		}
		return null;
	}
	
	public boolean saveInterviewSchedule(InterviewScheduleEntity entity) {
		interviewScheduleRepo.save(entity);
		return true;
	}
	
	public boolean uploadInterviewSchedule(MultipartFile file, long id) {
		try {
			XSSFWorkbook wb  = new XSSFWorkbook(file.getInputStream());
			XSSFSheet sheet = wb.getSheetAt(0);
			ObjectMapper objectMapper = new ObjectMapper();
		    ArrayNode arrayNode = objectMapper.createArrayNode();
	
			for(Row row : sheet) {
				if(row.getRowNum()==0) continue;
				ObjectNode parentNode = objectMapper.createObjectNode();
				parentNode.put("Emp no", row.getCell(0).toString());
				parentNode.put("Start Date", row.getCell(1).toString());
				parentNode.put("Name", row.getCell(2).toString());
				parentNode.put("Grade", row.getCell(3).toString());
				parentNode.put("Access", row.getCell(4).toString());
				arrayNode.add(parentNode);
	
			}
			InterviewScheduleEntity entity = new InterviewScheduleEntity();
			entity.setId(id);
			entity.setData(arrayNode.toString());
			interviewScheduleRepo.save(entity);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public ResponseEntity<InputStreamResource> download(Long id, String fieldName) {
		System.out.println("came here---");
		byte[] bytes = null;
		InputStreamResource file = null;
		String filename=null;
		try {
			Optional<JourneyEntity> entity = journeyRepo.findById(id);
			if(null != entity && entity.isPresent()) {
				
			switch(fieldName) {
			case "checklist":
				bytes = entity.get().getChecklist();
				filename = entity.get().getChecklistFile();
				break;
			case "testimonials":
				bytes = entity.get().getTestimonials();
				filename = entity.get().getTestimonialsFile();
				break;
			case "inductionVideo":
				bytes = entity.get().getInductionVideo();
				filename = entity.get().getInductionVideoFile();
				break;
			case "instructionVideo":
				bytes = entity.get().getInstructionVideo();
				filename = entity.get().getInstructionVideoFile();
				break;
			case "url":
				bytes = entity.get().getUrl();
				filename = entity.get().getUrlFile();
				break;
			case "thirdPartUrls":
				bytes = entity.get().getThirdPartUrls();
				filename = entity.get().getThirdPartUrlsFile();
				break;

			}
			ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
			file = new InputStreamResource(inputStream);
			}
		} catch (Exception e) {
			System.out.println("Exception in download :" + e);
			e.printStackTrace();
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(file);

	}
	
	public CRFEntity defaultCrfJson() throws JsonMappingException, JsonProcessingException {
		CRFEntity crfEntity = new CRFEntity();
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode euStatusMangement = objectMapper.createObjectNode();
		ObjectNode euApplForm = objectMapper.createObjectNode();
		ObjectNode noneuStatusMaangement = objectMapper.createObjectNode();
		ObjectNode noneuApplForm = objectMapper.createObjectNode();
		crfEntity.setEuApplicationForm(updateApplForm());
		crfEntity.setEuStatusManagement(updatePref(euStatusMangement));
		crfEntity.setNoneuApplicationForm(updateApplForm());
		crfEntity.setNoneuStatusManagement(updatePref(noneuStatusMaangement));
		crfEntity.setId(1l);
		return crfEntity;

	}
	
	public String updatePref(ObjectNode json) {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode node = objectMapper.createObjectNode();
		node.put("display", false);
		node.put("type", "text");
		json.set("fn", node);
		json.set("mn", node);
		json.set("ln", node);
		json.set("cn", node);
		json.set("skills", node);
		json.set("ct", node);
		json.set("dob", node);
		json.set("loc", node);
		json.set("pwd", node);
		json.set("confpwd", node);
		return json.toString();
	}
	
	public String updateApplForm() {
		return "{\"title\":\"\",\"firstName\":\"yes\",\"middleName\":\"no\",\"lastName\":\"no\",\"contactNo\":\"yes\",\"emailid\":\"\",\"streetAddress\":\"yes\",\"apartmentUnit\":\"\",\"state\":\"\",\"zipCode\":\"\",\"city\":\"\",\"country\":\"Afganistan\",\"date\":\"\",\"dateAvailable\":\"\",\"currentWorkLocation\":\"\",\"totalExpYrs\":\"\",\"totalExpMts\":\"\",\"totalRelExpYrs\":\"\",\"totalRelExpMts\":\"\",\"exTCSEmployee\":\"\",\"under18ProvideWorkPermit\":\"\",\"offerEmpExtDemWorkUS\":\"\",\"reqSponsorship\":\"\",\"ifYesWhen\":\"\",\"exTCSStartDate\":\"\",\"exTCSEndDate\":\"\",\"companies\":[{\"companyName\":\"\",\"address\":\"\",\"supervisorName\":\"\",\"supervisorContact\":\"\",\"jobTitle\":\"\",\"responsibilities\":\"\",\"startDate\":\"\",\"endDate\":\"\",\"reasonForLeaving\":\"\",\"comMayContactSupervisorRef\":\"Yes\"}],\"courses\":[{\"educationalLevel\":\"\",\"instituteName\":\"\",\"insAddress\":\"\",\"graduate\":\"Yes\",\"degree\":\"\",\"cos\":\"\",\"GPA\":\"\"}],\"skills\":[{\"skillTech\":\"\",\"description\":\"\"}],\"references\":[{\"fullName\":\"\",\"relationship\":\"\",\"comName\":\"\",\"contactNo\":\"\",\"emailId\":\"\",\"address\":\"\"}],\"militaryExp\":\"\",\"signName\":\"\",\"signature\":\"\",\"signDate\":\"\",\"lawSignature\":\"\"}";
	}
	
	
	
	@Autowired
	ContactUsRepo contactUsRepo;
	@Autowired
	CRFRepo crfRepo;
	@Autowired
	ExploreTcsRepo exploreTcsRepo;
	@Autowired
	InterviewScheduleRepo interviewScheduleRepo;
	@Autowired
	JourneyRepo journeyRepo;
	private static final String MS_EXCEL = "application/vnd.ms-excel";
	private static final String ATTACHMENT_FILE = "attachment; filename=";
}
