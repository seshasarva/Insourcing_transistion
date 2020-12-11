package com.insourcing.controllers;

import java.io.ByteArrayInputStream;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import com.insourcing.config.CommonConstants;
import com.insourcing.entity.*;
import com.insourcing.exception.GenericException;
import com.insourcing.model.*;
import com.insourcing.services.*;
import com.insourcing.services.CandidateService;
import com.insourcing.validator.EntityValidator;

@RestController
@RequestMapping("/api")
public class CandidateController {

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

	private static Logger logger = LogManager.getLogger(CandidateController.class);
	private static final String EMAIL_ID_NOT_FOUND = "email id not found";
	private static final String EMAIL_ID = "emailID : {}";
	private static final String EMPTY_LIST = "Empty list";
	private static final String CONTENT = "Content-Disposition";
	private static final String ATTACHMENT_PDF_FILE = "attachment; filename=offer.pdf";
	private static final String EMAIL = "emailID";
	private static final String PASSWORD = "password";
	private static final String EXCEPTION_OCCURRED = "Exception occurred : ";

	@GetMapping("/list")
	public List<CandidateEntityMap> findall() {
		logger.info("/list - List of candidate in database");
		List<CandidateEntityMap> list = candidateService.findAllList();
		if (list.isEmpty()) {
			throw new GenericException(EMPTY_LIST);
		}
		return list;
	}

	@GetMapping("/application/list")
	public List<ApplicationIndiaEntityMap> findApplicationFormAll() {
		logger.info("/applist - List of Indian Application form details");
		List<ApplicationIndiaEntityMap> list = candidateService.findApplicationFormall();
		if (list.isEmpty()) {
			logger.error(EMPTY_LIST);
			throw new GenericException(EMPTY_LIST);
		}
		return list;
	}

	@InitBinder("candEntity")
	public void initCandEntityBinder(WebDataBinder binder, WebRequest request) {
		binder.setDisallowedFields("refId", "offerFile");
	}

	@PutMapping("/candidate/registration/form")
	public String register(@RequestBody CandidateEntity candEntity) throws ParseException {
		logger.info("/CandRegistrationForm - Candidate Registration Form");
		String referenceId = "";
		String decryptedEmailId = null;
		String decryptedPassword = null;
		if (candEntity == null) {
			logger.error("candidate details not found");
			throw new GenericException("candidate details not found");
		}
		try {
			validator.validateCandidateEntity(candEntity);
			decryptedEmailId = encryptService.decrptPwd(candEntity.getEmailid(), EMAIL);
			decryptedPassword = encryptService.decrptPwd(candEntity.getPassword(), PASSWORD);
			candEntity.setEmailid(decryptedEmailId);
			candEntity.setPassword(decryptedPassword);
			referenceId = candidateService.updateRegister(candEntity);
		} catch (Exception e) {
			logger.error("Error occurred : ", e);
		}
		return referenceId;
	}

	@InitBinder("applicationUSEntity")
	public void initAppUSEntityBinder(WebDataBinder binder, WebRequest request) {
		binder.setDisallowedFields("appCompletedDate");
	}

	@PostMapping("/us/application/form")
	public String appForm(@RequestBody ApplicationUSEntity applicationUSEntity)
			throws ParseException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		logger.info("/USApplicationForm - Register US Application Form");
		if (applicationUSEntity.getEmailid() == null) {
			logger.error(EMAIL_ID_NOT_FOUND);
			throw new GenericException(EMAIL_ID_NOT_FOUND);
		}
		String key = null;
		if (applicationUSEntity.getKey() != null)
			key = applicationUSEntity.getKey();
		else
			key = CommonConstants.PRIMARY_KEY;
		String emailDecrypt = encryptService.decrptPwd(applicationUSEntity.getEmailid(), key);
		logger.info(EMAIL_ID, applicationUSEntity.getEmailid());
		logger.info(EMAIL_ID, emailDecrypt);
		candidateService.appUSUpdate(applicationUSEntity, emailDecrypt);
		return "Application Form filled Successfully";
	}

	@InitBinder("applicationIndiaEntity")
	public void initAppInEntityBinder(WebDataBinder binder, WebRequest request) {
		binder.setDisallowedFields("appCompletedDate");
	}

	@PostMapping("/india/application/form")
	public String appIndiaForm(@RequestBody ApplicationIndiaEntity applicationIndiaEntity)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		logger.info("/IndiaApplicationForm - Register India Application Form");
		if (applicationIndiaEntity.getEmailId() == null) {
			logger.error(EMAIL_ID_NOT_FOUND);
			throw new GenericException(EMAIL_ID_NOT_FOUND);
		}
		String key = null;
		if (applicationIndiaEntity.getKey() != null)
			key = applicationIndiaEntity.getKey();
		else
			key = CommonConstants.PRIMARY_KEY;
		String emailDecrypt = encryptService.decrptPwd(applicationIndiaEntity.getEmailId(), key);
		logger.info(EMAIL_ID, emailDecrypt);
		candidateService.appIndiaUpdate(applicationIndiaEntity, emailDecrypt);
		return "Application Form filled Successfully";
	}

	@PostMapping("/us/application/data")
	public ApplicationUSEntityMap fetchUsData(@RequestBody String emailId)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		logger.info("/US/ApplicationData - Fetch US Application Form Data");
		ApplicationUSEntity applicationUSEntity = new ApplicationUSEntity();
		if (emailId == null) {
			logger.error(EMAIL_ID_NOT_FOUND);
			throw new GenericException(EMAIL_ID_NOT_FOUND);
		}
		String key = null;
		if (applicationUSEntity.getKey() != null)
			key = applicationUSEntity.getKey();
		else
			key = CommonConstants.PRIMARY_KEY;
		String emailDecrypt = encryptService.decrptPwd(emailId, key);
		return candidateService.fetchUsApp(emailDecrypt);
	}

	@PostMapping("/india/application/data")
	public ApplicationIndiaEntityMap fetchIndiaData(@RequestBody String emailId)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		logger.info("/India/ApplicationData - Fetch India Application Form Data");
		ApplicationIndiaEntity applicationIndiaEntity = new ApplicationIndiaEntity();
		if (emailId == null) {
			logger.error(EMAIL_ID_NOT_FOUND);
			throw new GenericException(EMAIL_ID_NOT_FOUND);
		}
		String key = null;
		if (applicationIndiaEntity.getKey() != null)
			key = applicationIndiaEntity.getKey();
		else
			key = CommonConstants.PRIMARY_KEY;
		String emailDecrypt = encryptService.decrptPwd(emailId, key);
		return candidateService.fetchIndiaApp(emailDecrypt);
	}

	@InitBinder("loginForm")
	public void initLoginBinder(WebDataBinder binder, WebRequest request) {
		binder.setAllowedFields(EMAIL, PASSWORD);
	}

	@PostMapping(value = "/view/offer", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> viewOffer(@RequestParam(value = "emailid") String emailId) {
		logger.info("/ViewOffer - View Offer File for email id : {}", emailId);
		ByteArrayInputStream bis = candidateService.viewOfferFile(emailId);
		HttpHeaders headers = new HttpHeaders();
		headers.add(CONTENT, ATTACHMENT_PDF_FILE);
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));

	}

	@PostMapping(value = "/view/document", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> viewJoiningLetter(@RequestParam(value = "emailid") String emailId) {
		logger.info("/ViewDocument - View Retention or Appointment Letter for email id : {}", emailId);
		ByteArrayInputStream bis = candidateService.viewDocumentFile(emailId);
		HttpHeaders headers = new HttpHeaders();
		headers.add(CONTENT, ATTACHMENT_PDF_FILE);
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));

	}

	@PostMapping(value = "/update/offer/status")
	public String updateOfferStatus(@RequestPart("status") String status, @RequestPart("email") String email) {
		logger.info("/OfferStatus - Update Offer status for email id : {}", email);
		if (email == null) {
			logger.error(EMAIL_ID_NOT_FOUND);
			throw new GenericException(EMAIL_ID_NOT_FOUND);
		} else if (status == null) {
			logger.error("status not found");
			throw new GenericException("status not found");
		}
		return candidateService.updateOfferStatus(status, email);
	}

	@GetMapping("/us/myspace")
	public MySpaceModel getUSMySpace() {
		logger.info("/US/MySpace");
		return reportService.mySpaceUS();
	}

	@GetMapping("/india/myspace")
	public MySpaceModel getIndiaMySpace() {
		logger.info("/India/MySpace");
		return reportService.mySpaceIndia();
	}

	@PostMapping("/authenticate")
	public LoginFormResponse loginUser(@RequestBody LoginFormRequest loginForm)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		LoginFormResponse loginFormResponse = null;
		String decryptedEmailId = "";
		String decryptedPassword = "";
		try {
			if (loginForm.getEmailID().isEmpty() || loginForm.getPassword().isEmpty()) {
				logger.error("Username/Password cannot be empty");
				throw new GenericException("Username/Password cannot be empty");
			} else {
				decryptedEmailId = encryptService.decrptPwd(loginForm.getEmailID(), EMAIL);
				decryptedPassword = encryptService.decrptPwd(loginForm.getPassword(), PASSWORD);
				loginFormResponse = candidateService.candidateLogin(decryptedEmailId, decryptedPassword);
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		return loginFormResponse;
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logoutUser(@RequestBody String emailID)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		LoginFormResponse loginFormResponse = null;
		ResponseEntity<String> entity = null;
		String decryptedEmailId = "";
		try {
			if (emailID.isEmpty()) {
				logger.error("Username cannot be empty");
				throw new GenericException("Username cannot be empty");
			} else {
				decryptedEmailId = encryptService.decrptPwd(emailID, EMAIL);
				loginFormResponse = candidateService.candidateLogout(decryptedEmailId);
				if (null != loginFormResponse
						&& loginFormResponse.getAuthenticationCode().equals(HttpStatus.ACCEPTED)) {
					entity = ResponseEntity.status(HttpStatus.OK).body("success");
				} else {
					entity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("success");
				}
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		return entity;
	}

	@PostMapping("/check/username")
	public boolean checkUsername(@RequestBody String emailId) {
		return candidateService.isCandidateFound(emailId);
	}

	@PostMapping("/change/password")
	public String changePassword(@RequestBody ForgotPasswordRequest request) {
		return candidateService.checkUserDetails(request.getEmailID(), request.getNewPassword());
//		return false;
	}
}