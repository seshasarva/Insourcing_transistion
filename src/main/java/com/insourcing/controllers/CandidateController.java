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
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.insourcing.config.CommonConstants;
import com.insourcing.entity.ApplicationIndiaEntity;
import com.insourcing.entity.ApplicationIndiaEntityMap;
import com.insourcing.entity.ApplicationUSEntity;
import com.insourcing.entity.ApplicationUSEntityMap;
import com.insourcing.entity.CandidateEntity;
import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.exception.GenericException;
import com.insourcing.exception.PortalException;
import com.insourcing.model.ForgotPasswordRequest;
import com.insourcing.model.LoginFormRequest;
import com.insourcing.model.LoginFormResponse;
import com.insourcing.model.MySpaceModel;
import com.insourcing.services.CandidateService;
import com.insourcing.services.EncryptService;
import com.insourcing.services.FileService;
import com.insourcing.services.ReportService;
import com.insourcing.validator.ApplicationIndiaValidator;
import com.insourcing.validator.ApplicationUSValidator;
import com.insourcing.validator.EntityValidator;
import com.insourcing.validator.TokenValidator;

@RestController
@CrossOrigin
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
	@Autowired
	TokenValidator tokenValidator;
	@Autowired
	ApplicationUSValidator appUsValidator;
	@Autowired
	ApplicationIndiaValidator appIndiaValidator;

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
	private static final String HEADER = "Authorization";
	private static final String PREFIX = "Bearer ";

	@PostMapping("/list")
	public List<CandidateEntityMap> findall() {
		logger.info("/list - List of candidate in database");
		List<CandidateEntityMap> list = candidateService.findAllList();
		if (list.isEmpty()) {
			throw new GenericException(EMPTY_LIST);
		}
		return list;
	}

	@PostMapping("/application/list")
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
	public String register(@RequestBody CandidateEntity candEntity, HttpServletRequest request) throws ParseException {
		logger.info("/CandRegistrationForm - Candidate Registration Form");
		String referenceId = "";
		String decryptedPassword = null;
		boolean validate;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.tokenValidator(emailId, jwtToken);
			if (tokenValidate) {
				validate = validator.validateCandidateEntity(candEntity);
				if (validate && candEntity.isConsent()) {
					decryptedPassword = encryptService.decrptPwd(candEntity.getPassword(), PASSWORD);
					candEntity.setPassword(decryptedPassword);
					referenceId = candidateService.updateRegister(candEntity, emailId);
				} else {
					referenceId = "Validation failed";
				}
			} else {
				referenceId = "Failed to Authenticate";
			}
		} catch (Exception e) {
			referenceId = e.getMessage();
			logger.error("Error occurred : ", e);
		}
		return referenceId;
	}

	@InitBinder("applicationUSEntity")
	public void initAppUSEntityBinder(WebDataBinder binder, WebRequest request) {
		binder.setDisallowedFields("appCompletedDate");
	}

	@PostMapping("/us/application/form")
	public String appForm(@RequestBody ApplicationUSEntity applicationUSEntity, HttpServletRequest request)
			throws ParseException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, PortalException {
		logger.info("/USApplicationForm - Register US Application Form");
		String message = "";
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		tokenValidate = tokenValidator.tokenValidator(emailId, jwtToken);
		try {
			if (tokenValidate) {
				if (applicationUSEntity != null && applicationUSEntity.getEducation() != null) {
					if (emailId == null) {
						logger.error(EMAIL_ID_NOT_FOUND);
						throw new GenericException(EMAIL_ID_NOT_FOUND);
					}
					logger.info(EMAIL_ID, emailId);
					message = candidateService.appUSUpdate(applicationUSEntity, emailId);
				} else {
					message = "Kindly fill all the Mandatory fields";
				}
			} else {
				message = "Failed to Authenticate";
			}
		} catch (Exception e) {
			message = e.getMessage();
			logger.error("Error occurred : ", e);
		}
		return message;
	}

	@InitBinder("applicationIndiaEntity")
	public void initAppInEntityBinder(WebDataBinder binder, WebRequest request) {
		binder.setDisallowedFields("appCompletedDate");
	}

	@PostMapping("/india/application/form")
	public String appIndiaForm(@RequestBody ApplicationIndiaEntity applicationIndiaEntity, HttpServletRequest request)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		logger.info("/IndiaApplicationForm - Register India Application Form");
		String message = "";
		boolean tokenValidate;
		boolean validate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		tokenValidate = tokenValidator.tokenValidator(emailId, jwtToken);
		logger.info(tokenValidate);
		try {
			if (tokenValidate) {
				if (applicationIndiaEntity != null) {
					validate = appIndiaValidator.validateIndiaApp(applicationIndiaEntity);
					if (validate) {
						if (emailId == null) {
							logger.error(EMAIL_ID_NOT_FOUND);
							message = EMAIL_ID_NOT_FOUND;
							throw new GenericException(EMAIL_ID_NOT_FOUND);
						}
						logger.info(EMAIL_ID, emailId);
						candidateService.appIndiaUpdate(applicationIndiaEntity, emailId);
						message = "Application Form filled Successfully";
					} else {
						message = "Validation failed";
					}
				}
			} else {
				message = "Failed to Authenticate";
			}
		} catch (Exception e) {
			message = e.getMessage();
			logger.error("Error occurred : ", e);
		}
		return message;
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
	public ResponseEntity<InputStreamResource> viewOffer(HttpServletRequest request) {
		logger.info("/ViewOffer - View Offer File");
		HttpHeaders headers = new HttpHeaders();
		ByteArrayInputStream bis = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		logger.info("/ViewOffer - View Offer File for : {}", emailId);
		tokenValidate = tokenValidator.tokenValidator(emailId, jwtToken);
		logger.info(tokenValidate);
		if (tokenValidate) {
			if (emailId != null) {
				bis = candidateService.viewOfferFile(emailId);
				headers.add(CONTENT, ATTACHMENT_PDF_FILE);
			}
		}
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));

	}

	@PostMapping(value = "/view/document", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> viewJoiningLetter(HttpServletRequest request) {
		logger.info("/ViewDocument - View Retention or Appointment Letter");
		HttpHeaders headers = new HttpHeaders();
		ByteArrayInputStream bis = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		tokenValidate = tokenValidator.tokenValidator(emailId, jwtToken);
		logger.info(tokenValidate);
		if (tokenValidate) {
			if (emailId != null) {
				bis = candidateService.viewDocumentFile(emailId);
				headers.add(CONTENT, ATTACHMENT_PDF_FILE);
			}
		}
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));

	}

	@PostMapping(value = "/update/offer/status")
	public String updateOfferStatus(@RequestPart("status") String status, HttpServletRequest request) {
		logger.info("/OfferStatus - Update Offer status");
		String message = "";
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String email = tokenValidator.decodeEmailId(jwtToken);
		logger.info("Email Id : {}", email);
		tokenValidate = tokenValidator.tokenValidator(email, jwtToken);
		if (tokenValidate) {
			if (email == null) {
				logger.error(EMAIL_ID_NOT_FOUND);
				message = EMAIL_ID_NOT_FOUND;
				throw new GenericException(EMAIL_ID_NOT_FOUND);
			} else if (status == null) {
				logger.error("status not found");
				message = "status not found";
				throw new GenericException("status not found");
			} else if (email != null && status != null) {
				message = candidateService.updateOfferStatus(status, email);
			}
		} else {
			message = "Failed to Authenticate";
		}
		return message;
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
		boolean validate = false;
		try {
			validate = validator.validateLogin(loginForm);
			if (validate) {
				if (loginForm.getEmailID() != null && loginForm.getPassword() != null) {
					decryptedEmailId = encryptService.decrptPwd(loginForm.getEmailID(), EMAIL);
					decryptedPassword = encryptService.decrptPwd(loginForm.getPassword(), PASSWORD);
					loginFormResponse = candidateService.candidateLogin(decryptedEmailId, decryptedPassword);
					// loginFormResponse = candidateService.candidateLogin(loginForm.getEmailID(),
					// loginForm.getPassword());
				} else {
					logger.error("Username/Password cannot be empty");
					loginFormResponse = candidateService.candidateLoginFailure();
					throw new GenericException("Username/Password cannot be empty");
				}
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		return loginFormResponse;
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logoutUser(HttpServletRequest request)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		LoginFormResponse loginFormResponse = null;
		ResponseEntity<String> entity = null;
		logger.info("Logout - Entry");
		String jwtToken = request.getHeader("Authorization").replace("Bearer ", "");
		String emailID = tokenValidator.decodeEmailId(jwtToken);
		try {
			if (emailID.isEmpty()) {
				logger.error("Username cannot be empty");
				throw new GenericException("Username cannot be empty");
			} else {
				loginFormResponse = candidateService.candidateLogout(emailID, jwtToken);
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
	public String changePassword(@RequestBody ForgotPasswordRequest request, HttpServletRequest headerRequest) {
		logger.info("/change/password - Change Password");
		String message = "";
		String decryptedPassword = null;
		String decryptedCurPassword = null;
		boolean validate;
		logger.info(request);
		boolean tokenValidate;
		String jwtToken = headerRequest.getHeader(HEADER).replace(PREFIX, "");
		String emailID = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.tokenValidator(emailID, jwtToken);
			if (tokenValidate) {
				validate = validator.validateCandidateRequest(emailID, request.getNewPassword(),
						request.getCurrentPassword());
				if (validate) {
					decryptedCurPassword = encryptService.decrptPwd(request.getCurrentPassword(), PASSWORD);
					decryptedPassword = encryptService.decrptPwd(request.getNewPassword(), PASSWORD);
					message = candidateService.checkUserDetails(emailID, decryptedCurPassword, decryptedPassword);
				} else {
					message = "Validation failed";
				}
			} else {
				message = "Failed to Authenticate";
			}
		} catch (Exception e) {
			message = "Validation failed";
			logger.error("Error occurred : ", e);
		}
		return message;
	}

	@PostMapping("/expire/session")
	public String expireSession(HttpServletRequest headerRequest) {
		logger.info("/expire/session - Controller Entry");
		String message = "";
		boolean validateToken;
		String jwtToken = headerRequest.getHeader("Authorization").replace("Bearer ", "");
		String emailID = tokenValidator.decodeEmailId(jwtToken);
		try {
			validateToken = tokenValidator.tokenValidator(emailID, jwtToken);
			if (validateToken) {
				message = "User Authentication success";
			} else {
				message = "Failed to authenticate";
			}
		} catch (Exception e) {
			message = e.getMessage();
			logger.error("Error occurred : ", e);
		}
		return message;
	}
}