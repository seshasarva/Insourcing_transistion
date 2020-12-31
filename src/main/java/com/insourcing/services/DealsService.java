package com.insourcing.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insourcing.entity.DealEntity;
import com.insourcing.entity.HRLoginEntity;
import com.insourcing.model.DealFileAttachment;
import com.insourcing.entity.DealAttachment;
import com.insourcing.repository.DealAttachmentRepo;
import com.insourcing.repository.DealsRepo;
import com.insourcing.repository.HRLoginRepo;

@Service
public class DealsService {

	@Autowired
	DealsRepo repo;

	@Autowired
	DealAttachmentRepo dealAttachmentRepo;

	@Autowired
	HRLoginRepo hrRepository;

	@Value("${insource.app.deals.countries}")
	private String countries;

	ObjectMapper mapper = new ObjectMapper();
	private List<String> fileFieldsList = new ArrayList<>(Arrays.asList("exceptionApprovedFile", "hrCostingTenetsFile",
			"hrSolutionTenetsFile", "dealSolutionSummaryFile", "peopleTransitionJoinersDataFile", "dealAttachments"));
	
	public long upload(MultipartFile file, String fieldName) {
		long id = 0;
		try {
			byte[] bytes = file.getBytes();
			DealAttachment dne = new DealAttachment();
			dne.setFieldName(fieldName);
			dne.setFileData(bytes);
			dne.setFileName(file.getOriginalFilename());
			DealAttachment attachmentRow = dealAttachmentRepo.save(dne);
			id = attachmentRow.getId();
			System.out.println("uploaded the excel successfully in dne----");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	// @PostConstruct
//	public void upload() {
//		try {
//		//byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\PC\\Downloads\\India_Report.xlsx"));
//		byte[] bytes = Files.readAllBytes(Paths.get("E:\\Masrath\\TCS\\TCS Insourcing VDI\\Source Files\\DealEntity.xlsx"));
//		long id = 1;
//		Optional<DealEntity> dealOpt = repo.findById(id);
//		DealEntity deal = dealOpt.get();
//		deal.setExceptionApprovedBy("DealEntity.xlsx");
//		deal.setExceptionApprovedFile(bytes);
//		repo.save(deal);
//		System.out.println("uploaded the excel successfully----");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

	@Transactional
	public boolean create(DealEntity deal, String emailId) {
		String username = getUserName(emailId);
		System.out.println("username is: " + username);
		Random random =  new Random();
		int randomId = random.nextInt(10000); 
		if(null == deal.getId())
		deal.setId("DL"+randomId);
		//deal.setDealLead(username);
		//deal.setHrTransitionManager(username);
		Calendar canlendar = Calendar.getInstance();
		if (null == deal.getId()) {
			deal.setCreatedTime(canlendar.getTime());
		} else {
			deal.setUpdatedTime(canlendar.getTime());
		}

		DealEntity createdDeal = repo.save(deal);
		String dealId = createdDeal.getId();
		for (long attachmentId : deal.getAttachmentIds()) {
			Optional<DealAttachment> dealAttachment = dealAttachmentRepo.findById(attachmentId);
			if (null != dealAttachment && null != dealAttachment.get()) {
				dealAttachmentRepo.update(attachmentId, dealId);
			}
		}
		System.out.println("Deal created");
		return true;
	}

	public List<DealEntity> fetchAll() {
		return repo.findAll();
	}	
	
	public List<DealEntity> fetchDealLead(String dealLead) {
		return repo.findDealsByLead(dealLead);
	}	
	
	public DealEntity loadDetails(String emailId) {
		DealEntity deal = new DealEntity();
		String username = getUserName(emailId);
		if(null!=username){
			deal.setDealLead(username);
			deal.setDealLeadEmail(emailId);
		}else{
			deal.setAllUsers(getAllUsers());
		}
		List<String> geographies = Arrays.asList(countries.split(","));
		deal.setAllGeographies(geographies);		
		return deal;
	}
	
	private Map<String, String> getAllUsers() {
		Map<String, String> allUsers=new HashMap<>();
		List<HRLoginEntity> all = hrRepository.findAll();
		all.forEach(user->{allUsers.put(user.getEmailId(), user.getEmpName());});
		System.out.println("allUsers-----"+allUsers.size());
		return allUsers;
	}

//	public ResponseEntity<InputStreamResource> download() {
//		long id = 3;
//		byte[] bytes = repo.downloadExceptionApproval(id);
//		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
//		InputStreamResource file = new InputStreamResource(inputStream);
//		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + "test.xlsx")
//				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
//
//	}

	public ResponseEntity<InputStreamResource> download(Long id) {
		// long id = 2;
		System.out.println("came here---");
		byte[] bytes = null;
		InputStreamResource file = null;
		String filename=null;
		try {
			Optional<DealAttachment> dealAttachment = dealAttachmentRepo.findById(id);
			if (null != dealAttachment && null != dealAttachment.get()) {
				bytes = dealAttachment.get().getFileData();
				ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
				file = new InputStreamResource(inputStream);
				filename=dealAttachment.get().getFileName();
				System.out.println("downloading file----"+filename);
			}
		} catch (Exception e) {
			System.out.println("Exception in download :" + e);
			e.printStackTrace();
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(file);

	}

	public DealEntity fetch(String id) {
		DealEntity deal = null;
		try {
			Optional<DealEntity> dealEntity = repo.findById(id);
			deal = dealEntity.get();
			Field[] fields = DealEntity.class.getDeclaredFields();
			List<DealAttachment> list = dealAttachmentRepo.fetchByDealid(id);

			for (DealAttachment each : list) {
				System.out.println("Deal id is ----------"+each.getDealId()+"----"+each.getId()+"-----"+each.getFieldName()+"----"+each.getFileName());
				for (Field f : fields) {
					if (fileFieldsList.contains(f.getName())) {
						setDealAttachmentData(f, each, deal);
					}
				}
			}
			// deal.getDealAttachments().addAll(list);
			System.out.println("fianl deal object is---" + mapper.writeValueAsString(deal));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deal;
	}

	private void setDealAttachmentData(Field f, DealAttachment each, DealEntity deal)
			throws IllegalArgumentException, IllegalAccessException {
		String fieldName = f.getName();
		String eachFieldName = each.getFieldName();
		String eachfileName = each.getFileName();
		f.setAccessible(true);
		DealFileAttachment attachment = new DealFileAttachment();
		//attachment.setId(each.getId());
		attachment.setName(eachfileName);
		System.out.println("f.getType().getName()---" + fieldName);
		if (fieldName.equals("dealAttachments") && "dealNoteFile".equals(eachFieldName)) {
			deal.getDealAttachments().add(attachment);
		} else if (fieldName.equals(eachFieldName)) {
			f.set(deal, attachment);
		}

	}

	public DealEntity onLoadFields(String emailId) {
		DealEntity deal = new DealEntity();
		String username = getUserName(emailId);
		deal.setDealLead(username);
		deal.setHrTransitionManager(username);
		deal.setGeographyWithInScope(countries);
		return deal;
	}

	private String getUserName(String emailId) {
		String username = null;
		Optional<HRLoginEntity> row = hrRepository.findById(emailId);
		if (row.isPresent()) {
			username = row.get().getEmpName();
		}
		return username;
	}

	public Long deleteFile(Long id) {
		dealAttachmentRepo.deleteById(id);
		System.out.println("deleted the id successfully------" + id);
		return id;
	}

	private static final String MS_EXCEL = "application/vnd.ms-excel";
	private static final String ATTACHMENT_FILE = "attachment; filename=";

}
