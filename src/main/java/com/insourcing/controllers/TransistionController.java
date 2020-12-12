package com.insourcing.controllers;

import java.util.List;

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
import com.insourcing.entity.CRFEntity;
import com.insourcing.entity.ContactUsEntity;
import com.insourcing.entity.ExploreTcsEntity;
import com.insourcing.entity.InterviewScheduleEntity;
import com.insourcing.entity.JourneyEntity;
import com.insourcing.services.TransistionService;

@RestController
@RequestMapping("/transistion")
public class TransistionController {
	@Autowired
	TransistionService service;
	
	@GetMapping("/fetchExploreTcsDetails")
	public ExploreTcsEntity fetchExploreTcsDetails(@RequestParam long id) {
		return service.fetchExploreTcsDetails(id);
	}
	
	@PostMapping("/saveExploreTcs")
	public boolean saveExploreTcs(@RequestBody ExploreTcsEntity entity) {
		return service.saveExploreTcs(entity);
	}
	
	@GetMapping("/fetchContactUsDetails")
	public List<ContactUsEntity> fetchContactUsDetails(@RequestParam long id) {
		return service.fetchContactUsDetails(id);
	}
	
	@PostMapping("/saveContactUs")
	public boolean saveContactUs(@RequestBody List<ContactUsEntity> entities) {
		return service.saveContactUsEntity(entities);
	}
	
	@PostMapping("/saveContactUsImage")
	public boolean saveContactUsImage(@RequestPart("file") MultipartFile file,
			@RequestParam long id, @RequestParam String tileName) {
		return service.saveContactUsImage(file, id, tileName);
	}
	
	@GetMapping("/fetchMyJourneyDetails")
	public JourneyEntity fetchMyJourneyDetails(@RequestParam long id) {
		return service.fetchMyJourneyDetails(id);
	}
	
	@PostMapping("/saveJourneyDetails")
	public boolean saveJourneyDetails(@RequestBody JourneyEntity entity) {
		return service.saveJourneyDetails(entity);
	}
	
	@PostMapping("/uploadJourneyAttachments")
	public boolean uploadJourneyAttachments(@RequestPart("file") MultipartFile file,
			@RequestParam long id, @RequestParam String fieldName) {
		return service.uploadJourneyAttachments(file, id, fieldName);
	}
	
	@GetMapping("/fetchCrf")
	public CRFEntity fetchCrf(@RequestParam long id) throws JsonMappingException, JsonProcessingException {
		return service.fetchCrf(id);
	}
	
	@PostMapping("/saveCrf")
	public boolean saveCrf(@RequestBody String json, @RequestParam long id, @RequestParam  String field) throws JsonMappingException, JsonProcessingException {
		return service.saveCrf(id, json, field);
	}
	
	@GetMapping("/fetchInterviewSchedule")
	public InterviewScheduleEntity fetchInterviewSchedule(@RequestParam long id) {
		return service.fetchInterviewSchedule(id);
	}
	
	@PostMapping("/uploadInterviewSchedule")
	public boolean uploadInterviewSchedule(@RequestPart("file") MultipartFile file,
			@RequestParam long id) {
		return service.uploadInterviewSchedule(file, id);
	}
	
	@GetMapping("/download")
	public ResponseEntity<InputStreamResource> download(@RequestParam Long id,
			@RequestParam String fieldName) {
		return service.download(id, fieldName);
	}	
}
