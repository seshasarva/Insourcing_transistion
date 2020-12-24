package com.insourcing.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

import com.fasterxml.jackson.databind.JsonNode;
import com.insourcing.entity.DealEntity;
import com.insourcing.services.DealsService;

@RestController
@RequestMapping("/deals")
public class DealsController {

	@Autowired
	DealsService service;

	@PostMapping("/save")
	public boolean create(HttpServletRequest request, @RequestBody DealEntity deal) {
		boolean result = false;
		try {
			System.out.println("welcome---" + deal.getMonthOfCreation());
			String username = (String) request.getAttribute("username");
			result = service.create(deal, username);
		} catch (Exception e) {
			System.out.println("Excepttion in create/save :" + e);
			e.printStackTrace();
			return false;
		}
		return result;
	}

	@GetMapping("/onLoadFields")
	public DealEntity onLoadFields(HttpServletRequest request) {
		String username = (String) request.getAttribute("username");
		return service.onLoadFields(username);
	}

	@GetMapping("/fetchAll")
	public List<DealEntity> fetchAllDeals() {
		return service.fetchAll();
	}

	@GetMapping("/fetchDeal")
	public DealEntity fetchDeal(@RequestParam String id) {
		return service.fetch(id);
	}

	@PostMapping("/upload")
	public long uploadCandiateFile(@RequestPart("file") MultipartFile file, @RequestParam String fieldName) {
		try {
			System.out.println("file name is----" + file.getName() + "---" + file.getContentType() + "---"
					+ file.getOriginalFilename());
			return service.upload(file, fieldName);
		} catch (Exception e) {
			System.out.println("Excepttion in uploadCandiateFile :" + e);
			return -1;
		}
	}

	@GetMapping("/deleteFile")
	public long deleteFile(@RequestParam Long id) {
		try {
			System.out.println("deleteFile----" + id);
			return service.deleteFile(id);
		} catch (Exception e) {
			System.out.println("Excepttion in deleteFile :" + e);
			return -1;
		}
	}

	@GetMapping("/download")
	public ResponseEntity<InputStreamResource> download(@RequestParam Long id) {
		return service.download(id);
	}

}
