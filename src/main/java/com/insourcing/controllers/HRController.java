package com.insourcing.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.insourcing.entity.OfferIndiaEntity;
import com.insourcing.exception.GenericException;
import com.insourcing.exception.PortalException;
import com.insourcing.model.AppointmentModel;
import com.insourcing.model.ForgotPasswordRequest;
import com.insourcing.model.HRFormRequest;
import com.insourcing.model.HRFormResponse;
import com.insourcing.model.LoginFormRequest;
import com.insourcing.model.OfferModel;
import com.insourcing.model.RetentionModel;
import com.insourcing.services.CandidateService;
import com.insourcing.services.EncryptService;
import com.insourcing.services.FileService;
import com.insourcing.services.HRService;
import com.insourcing.services.ReportService;
import com.insourcing.validator.EntityValidator;

@RestController
@RequestMapping("/hrbc")
public class HRController {

	@Autowired
	HRService hrService;

	@Autowired
	CandidateService candidateService;
	@Autowired
	FileService fileService;
	@Autowired
	EncryptService encryptService;
	@Autowired
	ReportService reportService;
	@Autowired
	EntityValidator validator;

	ModelMapper modelMapper;

	private static final String MS_EXCEL = "application/vnd.ms-excel";
	private static final String JSON_DATA = "jsonData(String) : {}";
	private static final String ATTACHMENT_FILE = "attachment; filename=";
	private static final String JSON_DATA_ENTITY = "jsonData(Entity) : {}";
	private static final String CONTENT = "Content-Disposition";
	private static final String ATTACHMENT_PDF_FILE = "attachment; filename=offer.pdf";
	private static final String FILE_TYPE_NOT_SUPPORTED = "File Type not supported";
	private static final String EXCEPTION_OCCURRED = "Exception occurred : ";
	private static final String EMAIL = "emailID";
	private static final String PASSWORD = "password";

	private static Logger logger = LogManager.getLogger(HRController.class);

	@PostMapping("/login")
	public HRFormResponse login(@RequestBody LoginFormRequest loginForm ,HttpServletRequest req) {
		System.out.println("login"+req.getSession().getId());
		logger.info("/HRBCLogin - HRBC Portal login");
		HRFormResponse hrFormResponse = null;
		String decryptedEmailId = "";
		String decryptedPassword = "";
		try {
			if (null == loginForm) {
				logger.error("EmailId/Password cannot be empty");
				throw new GenericException("EmailId/Password cannot be empty");
			} else {
				decryptedEmailId = encryptService.decrptPwd(loginForm.getEmailID(), EMAIL);
				decryptedPassword = encryptService.decrptPwd(loginForm.getPassword(), PASSWORD);
				hrFormResponse = hrService.login(decryptedEmailId, decryptedPassword);
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		return hrFormResponse;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody HRFormRequest request) {
		logger.info("/HRBC - HRBC Registration Form");
		String message = "";
		if (request.getEmailId().isEmpty() && request.getPassword().isEmpty()) {
			logger.error("HR Username/Password cannot be empty");
			throw new GenericException("HR Username/Password cannot be empty");
		}
		try {
			validator.validateHREntity(request);
			message = hrService.register(request);
		} catch (PortalException e) {
			logger.error(EXCEPTION_OCCURRED, e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	@PostMapping("/upload")
	public ResponseEntity<Map<String, String>> uploadCandiateFile(@RequestPart("file") MultipartFile file)
			throws NoSuchAlgorithmException, IOException {
		Map<String, String> map = null;
		try {
			if (!validator.isTemplateValid(file)) {
				throw new GenericException(FILE_TYPE_NOT_SUPPORTED);
			}
			logger.info("/upload - Excel upload to add candidates");
			map = candidateService.saveData(file);
			logger.info(map);
		} catch (Exception ex) {
			logger.error("upload file failed ", ex);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}

	@PostMapping("/download")
	public ResponseEntity<Resource> getFile(@RequestPart("country") String country) {
		logger.info("/download - Download Candidate List");
		if (country == null) {
			throw new GenericException("Please add country!");
		} else if (!country.equalsIgnoreCase("India") && !country.equalsIgnoreCase("US")) {
			throw new GenericException("Please add country as India or US");
		}
		String filename = "Candidate_Details.xlsx";
		InputStreamResource file = new InputStreamResource(candidateService.load(country));
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
	}

	@PostMapping(value = "/india/preview/offer")
	public ResponseEntity<InputStreamResource> generatePreviewIndiaOffer(@RequestPart("jsonData") String candidateList,
			@RequestPart("templateFile") MultipartFile templateFile) throws IOException {
		logger.info("/India/PreviewOffer - Preview India Offer File");
		logger.info(JSON_DATA, candidateList);
		if (candidateList == null) {
			throw new GenericException("Please add json data for offer letter");
		}
		Gson gson = new Gson();
		OfferIndiaEntity list = gson.fromJson(candidateList, OfferIndiaEntity.class);
		logger.info(JSON_DATA_ENTITY, list);
		ByteArrayInputStream bistream = new ByteArrayInputStream(fileService.previewIndiaOffer(list, templateFile));
		HttpHeaders headers = new HttpHeaders();
		headers.add(CONTENT, ATTACHMENT_PDF_FILE);
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bistream));
	}

	@PostMapping(value = "/india/generate/offer/letter")
	public ResponseEntity<String> generateIndiaOffer(@RequestPart("excelFile") MultipartFile excelFile,
			@RequestPart("templateFile") MultipartFile templateFile) throws IOException, ParseException {
		String offersCount = null;
		logger.info("/India/OfferLetter - Generate India Offer File");
		try {
			if (validator.isTemplateValid(excelFile) && validator.isTemplateValid(templateFile)) {
				offersCount = fileService.generateIndiaOfferLetter(excelFile, templateFile);
			} else {
				throw new GenericException(FILE_TYPE_NOT_SUPPORTED);
			}
		} catch (Exception exc) {
			logger.error("Exception occurred during India upload api : ", exc);
		}
		return ResponseEntity.status(HttpStatus.OK).body(offersCount);
	}

	@PostMapping(value = "/us/preview/offer")
	public ResponseEntity<InputStreamResource> generatePreviewUSOffer(@RequestPart("jsonData") String candidateList,
			@RequestPart("templateFile") MultipartFile templateFile) throws IOException {
		logger.info("/US/PreviewOffer - Preview US Offer File");
		logger.info(JSON_DATA, candidateList);
		if (candidateList == null) {
			throw new GenericException("Please add json data for offer letter");
		}
		Gson gson = new Gson();
		OfferModel list = gson.fromJson(candidateList, OfferModel.class);
		logger.info(JSON_DATA_ENTITY, list);
		ByteArrayInputStream bistream = new ByteArrayInputStream(fileService.previewUSOffer(list, templateFile));
		HttpHeaders headers = new HttpHeaders();
		headers.add(CONTENT, ATTACHMENT_PDF_FILE);
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bistream));
	}

	@PostMapping(value = "/us/offer/letter")
	public String generateUSOffer(@RequestPart("excelFile") MultipartFile excelFile,
			@RequestPart("templateFile") MultipartFile templateFile) throws IOException, ParseException {
		logger.info("/US/OfferLetter - Generate US Offer File");
		String message = null;
		try {
			if (!validator.isTemplateValid(excelFile) && !validator.isTemplateValid(templateFile)) {
				throw new GenericException(FILE_TYPE_NOT_SUPPORTED);
			}
			message = fileService.generateUSOfferLetter(excelFile, templateFile);
		} catch (Exception exc) {
			logger.error("Exception occurred during US upload api : ", exc);
		}
		return message;
	}

	@PostMapping(value = "/preview/retention")
	public ResponseEntity<InputStreamResource> generatePrevRetention(@RequestPart("jsonData") String candidateList,
			@RequestPart("templateFile") MultipartFile templateFile) throws IOException, ParseException {
		logger.info("/PreviewRetention - Preview Retention File");
		logger.info(JSON_DATA, candidateList);
		if (candidateList == null) {
			throw new GenericException("Please add json data for retention letter");
		}
		if (!validator.isTemplateValid(templateFile)) {
			throw new GenericException(FILE_TYPE_NOT_SUPPORTED);
		}
		Gson gson = new Gson();
		RetentionModel list = gson.fromJson(candidateList, RetentionModel.class);
		logger.info(JSON_DATA_ENTITY, list);
		ByteArrayInputStream bistream = new ByteArrayInputStream(fileService.previewRetention(list, templateFile));
		HttpHeaders headers = new HttpHeaders();
		headers.add(CONTENT, ATTACHMENT_PDF_FILE);
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bistream));
	}

	@PostMapping(value = "/retention/letter")
	public String generateRetention(@RequestPart("excelFile") MultipartFile excelFile,
			@RequestPart("templateFile") MultipartFile templateFile,
			HttpServletRequest req) throws IOException, ParseException {
		System.out.println("retention"+req.getSession().getId());

		logger.info("/RententionLetter - Generate Retention Letter");
		if (!validator.isTemplateValid(excelFile) && !validator.isTemplateValid(templateFile)) {
			throw new GenericException(FILE_TYPE_NOT_SUPPORTED);
		}
		return fileService.generateRetentionLetters(excelFile, templateFile);
	}

	@PostMapping(value = "/preview/appointment")
	public ResponseEntity<InputStreamResource> generatePreviewAppointment(@RequestPart("jsonData") String candidateList,
			@RequestPart("templateFile") MultipartFile templateFile) throws IOException {
		logger.info("/PreviewAppointment - Preview Appointment File");
		logger.info(JSON_DATA, candidateList);
		if (candidateList == null) {
			throw new GenericException("Please add json data for appointment letter");
		}
		if (!validator.isTemplateValid(templateFile)) {
			throw new GenericException(FILE_TYPE_NOT_SUPPORTED);
		}
		Gson gson = new Gson();
		AppointmentModel list = gson.fromJson(candidateList, AppointmentModel.class);
		logger.info(JSON_DATA_ENTITY, list);
		ByteArrayInputStream bistream = new ByteArrayInputStream(fileService.previewAppointment(list, templateFile));
		HttpHeaders headers = new HttpHeaders();
		headers.add(CONTENT, ATTACHMENT_PDF_FILE);
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bistream));
	}

	@PostMapping(value = "/appointment/letter")
	public String generateAppointment(@RequestPart("excelFile") MultipartFile excelFile,
			@RequestPart("templateFile") MultipartFile templateFile) throws IOException, ParseException {
		logger.info("/AppointmentLetter - Generate Appointment Letter");
		if (!validator.isTemplateValid(excelFile) && !validator.isTemplateValid(templateFile)) {
			throw new GenericException(FILE_TYPE_NOT_SUPPORTED);
		}
		return fileService.generateAppointmentLetter(excelFile, templateFile);
	}

	@GetMapping("/application/form/report")
	public ResponseEntity<Resource> getAFReport() {
		logger.info("/AppFormReport");
		String filename = "Application_Form_Report.xlsx";
		InputStreamResource file = new InputStreamResource(reportService.getAFReport());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
	}

	@GetMapping("/education/employement/report")
	public ResponseEntity<Resource> getEducationEmploymentReport() {
		logger.info("/EduEmpReport");
		String filename = "Education_Employment_Report.xlsx";
		InputStreamResource file = new InputStreamResource(reportService.getEduEmpReport());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
	}

	@GetMapping("/offer/retention/report")
	public ResponseEntity<Resource> getOfferRetentionReport() {
		logger.info("/OfferRetReport");
		String filename = "Offer_Retention_Report.xlsx";
		InputStreamResource file = new InputStreamResource(reportService.getOfferRetReport());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
	}

	@GetMapping("/india/report")
	public ResponseEntity<Resource> getIndiaReport() {
		logger.info("/IndiaReport");
		String filename = "India_Report.xlsx";
		InputStreamResource file = new InputStreamResource(reportService.getIndiaReport());
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
	}

	@PostMapping("/change/password")
	public String changePasswordCandidate(@RequestBody ForgotPasswordRequest request) {
		String message = candidateService.checkUserDetails(request.getEmailID(), request.getNewPassword());
		return message;
	}
	
	@PostMapping("/change/password/hr")
	public String changePasswordHR(@RequestBody ForgotPasswordRequest request) {
		String message = hrService.updatePassword(request.getEmailID(), request.getNewPassword());
		return message;
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logoutUser(@RequestBody String emailID)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		HRFormResponse hrFormResponse = null;
		ResponseEntity<String> entity = null;
		String decryptedEmailId = "";
		try {
			if (emailID.isEmpty()) {
				logger.error("Username cannot be empty");
				throw new GenericException("Username cannot be empty");
			} else {
				decryptedEmailId = encryptService.decrptPwd(emailID, EMAIL);
				hrFormResponse = hrService.hrLogout(decryptedEmailId);
				if (null != hrFormResponse && hrFormResponse.getAuthenticationCode().equals(HttpStatus.ACCEPTED)) {
					entity = ResponseEntity.status(HttpStatus.OK).body("success");
				} else {
					entity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("failure");
				}
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		return entity;
	}
}