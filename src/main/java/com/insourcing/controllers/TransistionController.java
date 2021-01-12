package com.insourcing.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.insourcing.entity.CRFEntity;
import com.insourcing.entity.ContactUsEntity;
import com.insourcing.entity.ExploreTcsEntity;
import com.insourcing.entity.InterviewScheduleEntity;
import com.insourcing.entity.JourneyEntity;
import com.insourcing.entity.RecruiterProfileEntity;
import com.insourcing.services.TransistionService;
import com.insourcing.validator.TokenValidator;

@RestController
@RequestMapping("/hrbc/transistion")
public class TransistionController {
	private static final String HEADER = "Authorization";
	private static final String PREFIX = "Bearer ";
	@Autowired
	TransistionService service;
	@Autowired
	TokenValidator tokenValidator;
	@Autowired
	HttpServletRequest request;
	@GetMapping("/fetchExploreTcsDetails")
	public List<ExploreTcsEntity> fetchExploreTcsDetails(@RequestParam String id) {
		return service.fetchExploreTcsDetails(id);
	}
	
	@PostMapping("/saveExploreTcs")
	public boolean saveExploreTcs(@RequestBody List<ExploreTcsEntity> entity) {
		return service.saveExploreTcs(entity);
	}
	
	@PostMapping("/uploadExploreTcsAttachments")
	public boolean uploadExploreTcsAttachments(@RequestPart("file") MultipartFile file,
			@RequestParam String id, 
			@RequestParam int index,
			@RequestParam String field) {
		
		return service.uploadExploreTcsFile(file, id, index, field);
	}
	
	@GetMapping("/fetchContactUsDetails")
	public List<ContactUsEntity> fetchContactUsDetails(@RequestParam String id) {
		return service.fetchContactUsDetails(id);
	}
	
	@PostMapping("/saveContactUs")
	public boolean saveContactUs(@RequestBody List<ContactUsEntity> entities) {
		return service.saveContactUsEntity(entities);
	}
	
	@PostMapping("/saveContactUsImage")
	public ContactUsEntity saveContactUsImage(@RequestPart("file") MultipartFile file,
			@RequestParam String id, @RequestParam String tileName) {
		
		return service.saveContactUsImage(file, id, tileName);
	}
	
	@GetMapping("/fetchMyJourneyDetails")
	public JourneyEntity fetchMyJourneyDetails(@RequestParam String id) {
		return service.fetchMyJourneyDetails(id);
	}
	
	@PostMapping("/saveJourneyDetails")
	public boolean saveJourneyDetails(@RequestBody JourneyEntity entity) {
		return service.saveJourneyDetails(entity);
	}
	
	@PostMapping("/uploadJourneyAttachments")
	public boolean uploadJourneyAttachments(@RequestPart("file") MultipartFile file,
			@RequestParam String id, @RequestParam String fieldName) {
		return service.uploadJourneyAttachments(file, id, fieldName);
	}
	
	@GetMapping("/getDealGeography")
	public String fetchDealGeography(@RequestParam String id) {
		return service.fetchDealGeography(id);
	}
	
	@GetMapping("/fetchCrf")
	public CRFEntity fetchCrf(@RequestParam String id) throws JsonMappingException, JsonProcessingException {
		return service.fetchCrf(id);
	}
	
	@PostMapping("/saveCrf")
	public boolean saveCrf(@RequestBody String json, @RequestParam String id, @RequestParam  String field) throws JsonMappingException, JsonProcessingException {
		return service.saveCrf(id, json, field);
	}
	
	@GetMapping("/fetchInterviewSchedule")
	public InterviewScheduleEntity fetchInterviewSchedule(@RequestParam String id) {
		return service.fetchInterviewSchedule(id);
	}
	
	@PostMapping("/uploadInterviewSchedule")
	public boolean uploadInterviewSchedule(@RequestPart("file") MultipartFile file,
			@RequestParam String id) {
		return service.uploadInterviewSchedule(file, id);
	}
	
	@PostMapping("/saveInterviewDetails")
	public boolean saveInterviewDetails(@RequestBody InterviewScheduleEntity entity) {
		return service.saveInterviewSchedule(entity);
	}
	
	@GetMapping("/download")
	public ResponseEntity<InputStreamResource> download(@RequestParam String id,
			@RequestParam String fieldName) {
		return service.download(id, fieldName);
	}	
	
	@PostMapping("/fetchRecruiterProfile")
	public ObjectNode fetchRecruiterProfile(@RequestBody String filter,
			@RequestParam String username) throws JsonMappingException, JsonProcessingException {
		//String username = (String) request.getAttribute("username");

		return service.fetchRecruiterDetails(filter, username);
	}	
	
	@GetMapping("/fetchRecruiterProfile")
	public  List<RecruiterProfileEntity> fetchRecruiterProfile() {
		return service.fetchRecruiterProfile();
	}	
	
	@PostMapping("/saveRecruiterProfile")
	public boolean saveRecruiterProfile(@RequestBody List<RecruiterProfileEntity> entity) {
		return service.saveRecruiterProfile(entity);
	}
	
	@PostMapping("/uploadRecruiterProfileImg")
	public RecruiterProfileEntity uploadRecruiterProfileImg(@RequestPart("file") MultipartFile file,
			@RequestParam int id) {
		return service.uploadRecruiterProfileImage(id, file);
	}
	
	public String getMailId() {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		return emailId;
	}
}
