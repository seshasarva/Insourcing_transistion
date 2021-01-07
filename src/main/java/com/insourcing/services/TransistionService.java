package com.insourcing.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.insourcing.entity.CRFEntity;
import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.entity.ContactUsEntity;
import com.insourcing.entity.ContactUsId;
import com.insourcing.entity.DealEntity;
import com.insourcing.entity.ExploreTcsEntity;
import com.insourcing.entity.ExploreTcsId;
import com.insourcing.entity.InterviewScheduleEntity;
import com.insourcing.entity.JourneyEntity;
import com.insourcing.entity.RecruiterProfileEntity;
import com.insourcing.repository.CRFRepo;
import com.insourcing.repository.CandidateRepo;
import com.insourcing.repository.ContactUsRepo;
import com.insourcing.repository.DealCounterRepo;
import com.insourcing.repository.DealsRepo;
import com.insourcing.repository.ExploreTcsRepo;
import com.insourcing.repository.InterviewScheduleRepo;
import com.insourcing.repository.JourneyRepo;
import com.insourcing.repository.RecruiterProfileRepo;

@Service
public class TransistionService {
	static Properties prop;
	@Autowired
	DealsRepo repo;
	@Autowired
	CandidateRepo candidateRepo;
	@Autowired
	RecruiterProfileRepo recruiterProfileRepo;
	
	public List<ExploreTcsEntity> fetchExploreTcsDetails(String id) {
		List<ExploreTcsId> ids = new ArrayList<ExploreTcsId>();
		List<ExploreTcsEntity> deals = new ArrayList<ExploreTcsEntity>();
		try {
			for(int i = 0; i<5;i++) {
				ExploreTcsId exploreTcsId = new ExploreTcsId(id, i);
				ids.add(exploreTcsId);
			}
			deals = exploreTcsRepo.findAllById(ids);			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return deals;
	}
	
	public boolean saveExploreTcs(List<ExploreTcsEntity> exploreTcsEntities) {
		try {
			for(ExploreTcsEntity exploreTcsEntity : exploreTcsEntities) {
				ExploreTcsId eachId = new ExploreTcsId(exploreTcsEntity.getId(), exploreTcsEntity.getIndex());
				Optional<ExploreTcsEntity> deal = exploreTcsRepo.findById(eachId);
				ExploreTcsEntity entity = null;
			if(null != deal && deal.isPresent()) {
				entity = deal.get();
			}else {
				entity = new ExploreTcsEntity();
				entity.setId(exploreTcsEntity.getId());
					entity.setIndex(exploreTcsEntity.getIndex());
			}
			entity.setBenifits(exploreTcsEntity.getBenifits());
			entity.setContent(exploreTcsEntity.getContent());
			exploreTcsRepo.save(exploreTcsEntity);
			}
			/*for(ExploreTcsEntity entity : allDeals) {
				
			}*/
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public boolean uploadExploreTcsFile(MultipartFile file, String id, int index,String field) {
		try {
		ExploreTcsEntity entity;
		ExploreTcsId exploreTcsId = new ExploreTcsId(id, index);
		Optional<ExploreTcsEntity> deal = exploreTcsRepo.findById(exploreTcsId);
		if(null != deal && deal.isPresent()) {
			entity = deal.get();
		}else {
			entity = new ExploreTcsEntity();
			entity.setId(id);
			entity.setIndex(index);
		}
			switch(field) {
				case "coverimage":
					entity.setCoverImage(file.getBytes());
					entity.setCoverImageFile(file.getOriginalFilename());
					break;
				case "poster":
					entity.setPoster(file.getBytes());
					entity.setPosterFile(file.getOriginalFilename());
					break;
				case "video":
					entity.setVideo(file.getBytes());
					entity.setVideoFile(file.getOriginalFilename());
					break;				
			}
		exploreTcsRepo.save(entity);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<ContactUsEntity> fetchContactUsDetails(String id) {
		List<ContactUsEntity> deals = contactUsRepo.findAll();
		List<ContactUsEntity> filtered = new ArrayList<ContactUsEntity>();
		for(ContactUsEntity deal : deals) {
			if(deal.getId().equalsIgnoreCase(id))
			filtered.add(deal);
		}
		return filtered;
	}
	
	public boolean saveContactUsEntity(List<ContactUsEntity> entities) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			for(ContactUsEntity contact : entities) {
				ContactUsEntity entity;
			ContactUsId contactUsId = new ContactUsId(contact.getId(), contact.getTileName());
			Optional<ContactUsEntity> contactUs = contactUsRepo.findById(contactUsId);
			if(null != contactUs && contactUs.isPresent()) {
				entity = contactUs.get();				
				
			}else {
				entity = new ContactUsEntity();
				entity.setId(contact.getId());
				entity.setTileName(contact.getTileName());
			}			
			entity.setHeader(contact.getHeader());
			entity.setName(contact.getName());
			entity.setPhone(contact.getPhone());
			entity.setEmailId(contact.getEmailId());
			entity.setDisplay(contact.getDisplay());
			System.out.println("saving contact us----"+objectMapper.writeValueAsString(entity));
			contactUsRepo.save(entity);	
				
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Transactional
	public ContactUsEntity saveContactUsImage(MultipartFile file, String id, String tileName) {
		
		ContactUsEntity contactUs=null;
		try {	
			boolean found = false;
			List<ContactUsEntity> alldeals = contactUsRepo.findAll();
			for(ContactUsEntity each : alldeals) {
					if(each.getId() == id 
							&& each.getTileName().equalsIgnoreCase(tileName) ) {
				ContactUsEntity dealEntity = each;
				dealEntity.setImg(file.getBytes());
				contactUsRepo.save(dealEntity);
				found  = true;
				}
			}
			if(!found){
				ContactUsEntity entity = new ContactUsEntity();
				entity.setId(id);
				entity.setTileName(tileName);
				entity.setImg(file.getBytes());
				contactUsRepo.save(entity);

			}
		}catch(Exception e) {
			e.printStackTrace();
			return contactUs;
		}
		
		ContactUsId contactUsId = new ContactUsId(id, tileName);
		Optional<ContactUsEntity> entity = contactUsRepo.findById(contactUsId);
		if(null != entity && null != entity.get()) {
			contactUs = entity.get();
		}
		return contactUs;		
		
	}
	
	public JourneyEntity fetchMyJourneyDetails(String id) {
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
		Optional<JourneyEntity> journeyEntityOpt = journeyRepo.findById(entity.getId());
		JourneyEntity journeyEntity;
		if(null != journeyEntityOpt && journeyEntityOpt.isPresent()) {
			journeyEntity = journeyEntityOpt.get();
		}else {
			journeyEntity = new JourneyEntity();
		}
		journeyEntity.setBlogEvaluation(entity.getBlogEvaluation());
		journeyEntity.setBlogInduction(entity.getBlogInduction());
		journeyEntity.setBlogOffer(entity.getBlogOffer());
		journeyEntity.setBlogRegistration(entity.getBlogRegistration());
		journeyEntity.setNewContent(entity.getNewContent());
		journeyRepo.save(journeyEntity);
		return true;
	}
		
	@Transactional
	public boolean uploadJourneyAttachments(MultipartFile file, String id, String fieldName) {
		try {
			Optional<JourneyEntity> entity = journeyRepo.findById(id);
			JourneyEntity journeyEntity;
			if(null != entity && entity.isPresent()) {
				journeyEntity = entity.get();
			}else {
				journeyEntity = new JourneyEntity();
				journeyEntity.setId(id);
			}
			switch(fieldName) {
				case "checklist":
				System.out.println("saving bytes");
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
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean saveCrf(String id, String json, String field) throws JsonMappingException, JsonProcessingException {
		Optional<CRFEntity> deal = crfRepo.findById(id);
		CRFEntity entity = null;
		if(null != deal && deal.isPresent()) {
			entity = deal.get();
		}else {
			entity = defaultCrfJson(id);
			entity.setId(id);
		}
		switch (field) {
		case "statusManagement": entity.setStatusManagement(json);;break;
		case "applicationForm":entity.setApplicationForm(json);break;
		}
		crfRepo.save(entity);
		return true;
	}
	
	public CRFEntity fetchCrf(String id) throws JsonMappingException, JsonProcessingException {
		Optional<CRFEntity> deal = crfRepo.findById(id);
		if(null != deal && deal.isPresent()) {
			CRFEntity crf = deal.get();
			return crf;
		}else {
			return defaultCrfJson(id);
		}
	}
	

	
	public InterviewScheduleEntity fetchInterviewSchedule(String id) {
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
	
	public boolean uploadInterviewSchedule(MultipartFile file, String id) {
		try {
			XSSFWorkbook wb  = new XSSFWorkbook(file.getInputStream());
			XSSFSheet sheet = wb.getSheetAt(0);
			ObjectMapper objectMapper = new ObjectMapper();
		    ArrayNode arrayNode = objectMapper.createArrayNode();
	
			for(Row row : sheet) {
				if(row.getRowNum()==0) continue;
				//start date,end date, empid, name, grade, tr/hr/mr
				ObjectNode parentNode = objectMapper.createObjectNode();
				parentNode.put("Employee_Id", row.getCell(0).toString());
				parentNode.put("Start_Date", row.getCell(1).toString());
				parentNode.put("End_Date", row.getCell(2).toString());
				parentNode.put("Name", row.getCell(3).toString());
				parentNode.put("Grade", row.getCell(4).toString());
				parentNode.put("TR_MR_HR", row.getCell(5).toString());
				arrayNode.add(parentNode);
	
			}
			InterviewScheduleEntity entity = new InterviewScheduleEntity();
			entity.setId(id);
			entity.setData(arrayNode.toString());
			System.out.println("the node is---"+arrayNode.toString());
			interviewScheduleRepo.save(entity);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public ResponseEntity<InputStreamResource> download(String id, String fieldName) {
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
			System.out.println("downloading file----"+filename);
			}
		} catch (Exception e) {
			System.out.println("Exception in download :" + e);
			e.printStackTrace();
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(file);

	}
	
	public CRFEntity defaultCrfJson(String id) throws JsonMappingException, JsonProcessingException {
		Optional<DealEntity> dealOpt = repo.findById(id);
		if(null == dealOpt || !dealOpt.isPresent()) return null;
		DealEntity deal = repo.findById(id).get();
		
		CRFEntity crfEntity = new CRFEntity();
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode euStatusMangement = objectMapper.createObjectNode();
		ObjectNode euApplForm = objectMapper.createObjectNode();
		ObjectNode noneuStatusMaangement = objectMapper.createObjectNode();
		ObjectNode noneuApplForm = objectMapper.createObjectNode();
		
		crfEntity.setApplicationForm(prop.getProperty(deal.getGeographyWithInScope()));
		crfEntity.setStatusManagement(DEFAULT_JSON);
		/*crfEntity.setEuApplicationForm(updateApplForm());
		crfEntity.setEuStatusManagement(updatePref(euStatusMangement));
		crfEntity.setNoneuApplicationForm(updateApplForm());
		crfEntity.setNoneuStatusManagement(updatePref(noneuStatusMaangement));*/
		crfEntity.setId(deal.getId());
		return crfEntity;

	}
	
	public String updatePref(ObjectNode json) {
		/*ObjectMapper objectMapper = new ObjectMapper();
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
		return "{\"emailid\":\"\",\"contactno\":\"\",\"title\":\"\",\"currentTitle\":\"\",\"firstname\":\"\",\"middlename\":\"\",\"lastname\":\"\",\"skills\":\"\",\"dateOfBirth\":\"\",\"currentLocation\":\"\",\"password\":\"\",\"confirmPassword\":\"\",\"newFields\":[{\"name\":\"Test\",\"type\":\"text\",\"display\":\"\"}]}";*/
		return "{\"emailid\":\"\",\"contactno\":\"\",\"title\":\"\",\"currentTitle\":\"\",\"firstname\":\"\",\"middlename\":\"\",\"lastname\":\"\",\"skills\":\"\",\"dateOfBirth\":\"\",\"currentLocation\":\"\",\"password\":\"\",\"confirmPassword\":\"\",\"newFields\":[]}";
	}
	
	public String updateApplForm() {
		return "{\"title\":\"\",\"firstName\":\"\",\"middleName\":\"\",\"lastName\":\"\",\"contactNo\":\"\",\"emailid\":\"\",\"streetAddress\":\"\",\"apartmentUnit\":\"\",\"state\":\"\",\"zipCode\":\"\",\"city\":\"\",\"country\":\"Afganistan\",\"date\":\"\",\"dateAvailable\":\"\",\"currentWorkLocation\":\"\",\"totalExpYrs\":\"\",\"totalExpMts\":\"\",\"totalRelExpYrs\":\"\",\"totalRelExpMts\":\"\",\"exTCSEmployee\":\"\",\"under18ProvideWorkPermit\":\"\",\"offerEmpExtDemWorkUS\":\"\",\"reqSponsorship\":\"\",\"ifYesWhen\":\"\",\"exTCSStartDate\":\"\",\"exTCSEndDate\":\"\",\"companies\":[{\"companyName\":\"\",\"address\":\"\",\"supervisorName\":\"\",\"supervisorContact\":\"\",\"jobTitle\":\"\",\"responsibilities\":\"\",\"startDate\":\"\",\"endDate\":\"\",\"reasonForLeaving\":\"\",\"comMayContactSupervisorRef\":\"\"}],\"courses\":[{\"educationalLevel\":\"\",\"instituteName\":\"\",\"insAddress\":\"\",\"graduate\":\"\",\"degree\":\"\",\"cos\":\"\",\"GPA\":\"\"}],\"skills\":[{\"skillTech\":\"\",\"description\":\"\"}],\"references\":[{\"fullName\":\"\",\"relationship\":\"\",\"comName\":\"\",\"contactNo\":\"\",\"emailId\":\"\",\"address\":\"\"}],\"militaryExp\":\"\",\"signName\":\"\",\"signature\":\"\",\"signDate\":\"\",\"lawSignature\":\"\"}";
	}
	
	public List<RecruiterProfileEntity> fetchRecruiterProfile() {
		return recruiterProfileRepo.findAll();
	}
	
	public boolean saveRecruiterProfile(List<RecruiterProfileEntity> requestEntities) {
		for(RecruiterProfileEntity requestEntity : requestEntities) {
			Optional<RecruiterProfileEntity> entity = recruiterProfileRepo.findById(requestEntity.getId());
			RecruiterProfileEntity recruiterProfileEntity;
			if(null !=entity && entity.isPresent()) {
				recruiterProfileEntity = entity.get();
			}else {
				recruiterProfileEntity = new RecruiterProfileEntity();
				recruiterProfileEntity.setId(requestEntity.getId());
			}
			requestEntity.setContactNo(requestEntity.getContactNo());
			requestEntity.setCountry(requestEntity.getCountry());
			requestEntity.setMail(requestEntity.getMail());
			requestEntity.setName(requestEntity.getName());
			recruiterProfileRepo.save(requestEntity);
		}
		return true;
	}
	
	public boolean uploadRecruiterProfileImage(int index, MultipartFile file) {
		Optional<RecruiterProfileEntity> entity = recruiterProfileRepo.findById(index);
		RecruiterProfileEntity recruiterProfileEntity;
		try {
			if(null !=entity && entity.isPresent()) {
				recruiterProfileEntity = entity.get();
			}else {
				recruiterProfileEntity = new RecruiterProfileEntity();
				recruiterProfileEntity.setId(index);
			}
			recruiterProfileEntity.setFileName(file.getOriginalFilename());
			recruiterProfileEntity.setImg(file.getBytes());
			recruiterProfileRepo.save(recruiterProfileEntity);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public ObjectNode fetchRecruiterDetails(String filter, String userName) throws JsonMappingException, JsonProcessingException {
		if(true)
			return populateRecruiterDetails(filter, userName);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode parent = mapper.createObjectNode();
		//List<String> list = new ArrayList<String>();
		ArrayNode array = mapper.createArrayNode();
		array.add("clent1");array.add("client2");array.add("All");
		ObjectNode chartNode = mapper.createObjectNode();
		chartNode.put("Joined", 50);
		chartNode.put("Offer_Progress", 15);
		chartNode.put("Offer_Acceptance_Pending", 30);
		chartNode.put("Offer_Declined", 5);
		parent.set("chart", chartNode);
		parent.put("total", 100);
		parent.put("actual", 50);
		parent.put("percent", "20%");
		parent.put("active", 2);
		parent.set("clients", array);
		return parent;

	}
	
	public ObjectNode populateRecruiterDetails(String filter, String userName) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonFilter = mapper.readTree(filter);
		ObjectNode parent = mapper.createObjectNode();
		JsonNode statusFilter = jsonFilter.get("status");
		JsonNode clientFilter = jsonFilter.get("client");

		String status = "all";
		String client = "all";

		if(null != statusFilter) {
			status = statusFilter.asText();
		}
		if(null != clientFilter) {
			client = clientFilter.asText();
		}
		List<DealEntity> allDeals = repo.findDealsByLead(userName);
		ObjectNode chartNode = mapper.createObjectNode();
		ArrayNode array = mapper.createArrayNode();
		parent.set("chart", chartNode);
		parent.set("clients", array);
		array.add("All");
		int allAdditions = 0;
		int joined = 0;
		int activeCount = 0;
		System.out.println("deal size"+allDeals.size());
		for(DealEntity deal : allDeals) {
			boolean isPresent = false;
			for(JsonNode each : array) {
				if(each.asText().equals(deal.getClientName())) {
					isPresent = true;
				}
			}
			if(!isPresent)
				array.add(deal.getClientName());
			if(!"all".equalsIgnoreCase(status) && !status.equalsIgnoreCase(deal.getDealStatus())) {
				continue;
			}
			if(!"all".equalsIgnoreCase(client) && !client.equalsIgnoreCase(deal.getClientName())) {
				continue;
			}
			
			if(deal.getDealStatus().equalsIgnoreCase("open")) activeCount++;
			List<CandidateEntityMap> allCandidates = candidateRepo.findByDealId(deal.getId());
			System.out.println("current deal"+allCandidates.size()+":"+deal.getId());
			allAdditions = allAdditions+allCandidates.size();
			for(CandidateEntityMap candidateEntity : allCandidates) {
				System.out.println("status deal"+candidateEntity.getDealId()+":"+candidateEntity.getOfferStatus());

				if(candidateEntity.getOfferStatus().equalsIgnoreCase("joined")) joined++;
				JsonNode offerStatus = chartNode.get(candidateEntity.getOfferStatus());
				if(null == offerStatus) {
					chartNode.put(candidateEntity.getOfferStatus(), 1);
				}else {
					long value = offerStatus.asLong();
					chartNode.put(candidateEntity.getOfferStatus(), ++value);
				}
			}
		}
		parent.put("active", activeCount);
		parent.put("total", allAdditions);
		parent.put("actual", joined);
		if(allAdditions != 0)
		parent.put("percent", (joined*100)/allAdditions);
		else
		parent.put("percent", 0);

		System.out.println(parent);
		return parent;
	}
	
	static {
		prop = new Properties();
		InputStream input = null;
		try {
		    input = ClassLoader.getSystemClassLoader().getResourceAsStream("crf.properties");
		    prop.load(input);
		    System.out.println("loaded properties");
		    Set<Entry<Object, Object>> entries = prop.entrySet();
		    for(Entry<Object, Object> each : entries) {
		    	System.out.println(each.getKey()+":"+each.getValue());
		    }
		} catch (IOException io) {
		    io.printStackTrace();
		}
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
	private static final String DEFAULT_JSON = "{\"test\":\"test\"}";
}
