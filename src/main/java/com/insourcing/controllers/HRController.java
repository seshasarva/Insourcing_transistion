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
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.insourcing.services.FileServiceII;
import com.insourcing.services.HRService;
import com.insourcing.services.ReportService;
import com.insourcing.validator.EntityValidator;
import com.insourcing.validator.TokenValidator;

@CrossOrigin
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
	FileServiceII fileServiceII;
	@Autowired
	EncryptService encryptService;
	@Autowired
	ReportService reportService;
	@Autowired
	EntityValidator validator;
	@Autowired
	TokenValidator tokenValidator;

	ModelMapper modelMapper;

	private static final String MS_EXCEL = "application/vnd.ms-excel";
	private static final String JSON_DATA = "jsonData(String) : {}";
	private static final String ATTACHMENT_FILE = "attachment; filename=";
	private static final String JSON_DATA_ENTITY = "jsonData(Entity) : {}";
	private static final String CONTENT = "Content-Disposition";
	private static final String ATTACHMENT_PDF_FILE = "attachment; filename=offer.pdf";
	private static final String FILE_TYPE_NOT_SUPPORTED = "File Type not supported";
	private static final String EXCEL_FILE_TYPE_NOT_SUPPORTED = "Excel File Type should be .xlsx";
	private static final String TEMPLATE_FILE_TYPE_NOT_SUPPORTED = "Template File Type should be .pdf";
	private static final String EXCEPTION_OCCURRED = "Exception occurred : ";
	private static final String EMAIL = "emailID";
	private static final String PASSWORD = "password";
	private static final String HEADER = "Authorization";
	private static final String PREFIX = "Bearer ";

	private static Logger logger = LogManager.getLogger(HRController.class);

	@PostMapping("/login")
	public HRFormResponse login(@RequestBody LoginFormRequest loginForm, HttpServletRequest req) {
		logger.info("login" + req.getSession().getId());
		logger.info("/HRBCLogin - HRBC Portal login");
		HRFormResponse hrFormResponse = null;
		String decryptedEmailId = "";
		String decryptedPassword = "";
		boolean validate = false;
		try {
			validate = validator.validateLogin(loginForm);
			if (validate) {
				if (loginForm.getEmailID() != null && loginForm.getPassword() != null) {
					decryptedEmailId = encryptService.decrptPwd(loginForm.getEmailID(), EMAIL);
					decryptedPassword = encryptService.decrptPwd(loginForm.getPassword(), PASSWORD);
					hrFormResponse = hrService.login(decryptedEmailId, decryptedPassword);
				} else {
					logger.error("Username/Password cannot be empty");
					hrFormResponse = hrService.candidateLoginFailure();
					throw new GenericException("Username/Password cannot be empty");
				}
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		return hrFormResponse;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody HRFormRequest request) throws Exception {
		logger.info("/HRBC - HRBC Registration Form");
		String message = "";
		if (request.getEmailId().isEmpty() && request.getPassword().isEmpty()) {
			logger.error("HR Username/Password cannot be empty");
			throw new GenericException("HR Username/Password cannot be empty");
		}
		try {
			validator.validateHREntity(request);
			message = hrService.register(request);
		} catch (Exception e) {
			message = e.getMessage();
			logger.error(EXCEPTION_OCCURRED, e);
		}
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	@SuppressWarnings("null")
	@PostMapping("/upload")
	public ResponseEntity<Map<String, String>> uploadCandiateFile(@RequestPart("file") MultipartFile file,
			@RequestPart("dealId") String dealId, HttpServletRequest request)
			throws NoSuchAlgorithmException, IOException {
		Map<String, String> map = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (!validator.isExcelValid(file)) {
					throw new GenericException(FILE_TYPE_NOT_SUPPORTED);
				}
				logger.info("/upload - Excel upload to add candidates");
				if(dealId != null)
					if(!dealId.isEmpty())
						map = candidateService.saveData(file, dealId);
					else
						map.put("Failure message", "Deal Id should not be Empty");
				else
					map.put("Failure message", "Deal Id should not be Empty");
				logger.info(map);
			}
		} catch (Exception ex) {
			logger.error("upload file failed ", ex);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}

	@PostMapping("/download")
	public ResponseEntity<Resource> getFile(@RequestPart("country") String country, HttpServletRequest request) {
		logger.info("/download - Download Candidate List");
		boolean tokenValidate;
		InputStreamResource file = null;
		String filename = null;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (country == null) {
					throw new GenericException("Please add country!");
				} else if (!country.equalsIgnoreCase("India") && !country.equalsIgnoreCase("US")) {
					throw new GenericException("Please add country as India or US");
				}
				filename = "Candidate_Details.xlsx";
				file = new InputStreamResource(candidateService.load(country));
			}
		} catch (Exception ex) {
			logger.error("download file failed ", ex);
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
	}

	@PostMapping(value = "/india/preview/offer")
	public ResponseEntity<InputStreamResource> generatePreviewIndiaOffer(@RequestPart("jsonData") String candidateList,
			@RequestPart("templateFile") MultipartFile templateFile, HttpServletRequest request)
			throws IOException, IllegalAccessException {
		logger.info("/India/PreviewOffer - Preview India Offer File");
		logger.info(JSON_DATA, candidateList);
		HttpHeaders headers = null;
		ByteArrayInputStream bistream = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (candidateList == null) {
					throw new GenericException("Please add json data for offer letter");
				} else if (templateFile == null) {
					throw new GenericException("Please add template file for offer letter");
				}

				if (!validator.isDocTemplateValid(templateFile)) {
					throw new GenericException(TEMPLATE_FILE_TYPE_NOT_SUPPORTED);
				}

				Gson gson = new Gson();
				OfferIndiaEntity list = gson.fromJson(candidateList, OfferIndiaEntity.class);
				logger.info(JSON_DATA_ENTITY, list);
				bistream = new ByteArrayInputStream(fileServiceII.previewIndiaOffer(list, templateFile));
				headers = new HttpHeaders();
				headers.add(CONTENT, ATTACHMENT_PDF_FILE);
			}
		} catch (Exception ex) {
			logger.error("india preview offer failed ", ex);
		}
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bistream));
	}

	@PostMapping(value = "/india/generate/offer/letter")
	public ResponseEntity<String> generateIndiaOffer(@RequestPart("excelFile") MultipartFile excelFile,
			@RequestPart("templateFile") MultipartFile templateFile, HttpServletRequest request)
			throws IOException, ParseException {
		String message = null;
		logger.info("/India/OfferLetter - Generate India Offer File");
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (!validator.isExcelValid(excelFile)) {
					message = EXCEL_FILE_TYPE_NOT_SUPPORTED;
					throw new GenericException(EXCEL_FILE_TYPE_NOT_SUPPORTED);
				} else if (!(validator.isDocTemplateValid(templateFile))) {// validator.isTemplateValid(templateFile) ||
					message = TEMPLATE_FILE_TYPE_NOT_SUPPORTED;
					throw new GenericException(TEMPLATE_FILE_TYPE_NOT_SUPPORTED);
				}
				message = fileServiceII.generateIndiaOfferLetter(excelFile, templateFile);
			} else {
				message = "Failed to authenticate";
			}
		} catch (Exception exc) {
			message = exc.getMessage();
			logger.error("Exception occurred during India upload api : ", exc);
		}
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	@PostMapping(value = "/us/preview/offer")
	public ResponseEntity<InputStreamResource> generatePreviewUSOffer(@RequestPart("jsonData") String candidateList,
			@RequestPart("templateFile") MultipartFile templateFile, HttpServletRequest request) throws IOException {
		logger.info("/US/PreviewOffer - Preview US Offer File");
		logger.info(JSON_DATA, candidateList);
		ByteArrayInputStream bistream = null;
		HttpHeaders headers = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (candidateList == null) {
					throw new GenericException("Please add json data for offer letter");
				} else if (templateFile == null) {
					throw new GenericException("Please add template file for offer letter");
				}

				if (!validator.isDocTemplateValid(templateFile)) {
					throw new GenericException(TEMPLATE_FILE_TYPE_NOT_SUPPORTED);
				}

				Gson gson = new Gson();
				OfferModel list = gson.fromJson(candidateList, OfferModel.class);
				logger.info(JSON_DATA_ENTITY, list);
				bistream = new ByteArrayInputStream(fileServiceII.previewUSOffer(list, templateFile));
				headers = new HttpHeaders();
				headers.add(CONTENT, ATTACHMENT_PDF_FILE);
			}
		} catch (Exception exc) {
			logger.error("Exception occurred during India preview api : ", exc);
		}
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bistream));
	}

	@PostMapping(value = "/us/offer/letter")
	public String generateUSOffer(@RequestPart("excelFile") MultipartFile excelFile,
			@RequestPart("templateFile") MultipartFile templateFile, HttpServletRequest request)
			throws IOException, ParseException {
		logger.info("/US/OfferLetter - Generate US Offer File");
		String message = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (!validator.isExcelValid(excelFile)) {
					message = EXCEL_FILE_TYPE_NOT_SUPPORTED;
					throw new GenericException(EXCEL_FILE_TYPE_NOT_SUPPORTED);
				} else if (!validator.isDocTemplateValid(templateFile)) {
					message = TEMPLATE_FILE_TYPE_NOT_SUPPORTED;
					throw new GenericException(TEMPLATE_FILE_TYPE_NOT_SUPPORTED);
				}
				message = fileServiceII.generateUSOfferLetter(excelFile, templateFile);
			} else {
				message = "Failed to authenticate";
			}
		} catch (Exception exc) {
			message = exc.getMessage();
			logger.error("Exception occurred during US upload api : ", exc);
		}
		return message;
	}

	@PostMapping(value = "/preview/retention")
	public ResponseEntity<InputStreamResource> generatePrevRetention(@RequestPart("jsonData") String candidateList,
			@RequestPart("templateFile") MultipartFile templateFile, HttpServletRequest request)
			throws IOException, ParseException {
		logger.info("/PreviewRetention - Preview Retention File");
		logger.info(JSON_DATA, candidateList);
		ByteArrayInputStream bistream = null;
		HttpHeaders headers = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (candidateList == null) {
					throw new GenericException("Please add json data for retention letter");
				}
				if (!validator.isDocTemplateValid(templateFile)) {
					throw new GenericException(TEMPLATE_FILE_TYPE_NOT_SUPPORTED);
				}

				Gson gson = new Gson();
				RetentionModel list = gson.fromJson(candidateList, RetentionModel.class);
				logger.info(JSON_DATA_ENTITY, list);
				bistream = new ByteArrayInputStream(fileServiceII.previewRetention(list, templateFile));
				headers = new HttpHeaders();
				headers.add(CONTENT, ATTACHMENT_PDF_FILE);
			}
		} catch (Exception exc) {
			logger.error("Exception occurred during US retention preview api : ", exc);
		}
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bistream));
	}

	@PostMapping(value = "/retention/letter")
	public String generateRetention(@RequestPart("excelFile") MultipartFile excelFile,
			@RequestPart("templateFile") MultipartFile templateFile, HttpServletRequest request)
			throws IOException, ParseException {
		logger.info("/RententionLetter - Generate Retention Letter");
		String message = "";
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (!validator.isExcelValid(excelFile)) {
					message = EXCEL_FILE_TYPE_NOT_SUPPORTED;
					throw new GenericException(EXCEL_FILE_TYPE_NOT_SUPPORTED);
				} else if (!validator.isDocTemplateValid(templateFile)) {
					message = TEMPLATE_FILE_TYPE_NOT_SUPPORTED;
					throw new GenericException(TEMPLATE_FILE_TYPE_NOT_SUPPORTED);
				}
				message = fileServiceII.generateRetentionLetters(excelFile, templateFile);
			} else {
				message = "Failed to authenticate";
			}
		} catch (Exception exc) {
			message = exc.getMessage();
			logger.error("Exception occurred during US retention preview api : ", exc);
		}
		return message;
	}

	@PostMapping(value = "/preview/appointment")
	public ResponseEntity<InputStreamResource> generatePreviewAppointment(@RequestPart("jsonData") String candidateList,
			@RequestPart("templateFile") MultipartFile templateFile, HttpServletRequest request) throws IOException {
		logger.info("/PreviewAppointment - Preview Appointment File");
		logger.info(JSON_DATA, candidateList);
		ByteArrayInputStream bistream = null;
		HttpHeaders headers = new HttpHeaders();
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (candidateList == null) {
					throw new GenericException("Please add json data for appointment letter");
				}
				if (!validator.isDocTemplateValid(templateFile)) {
					throw new GenericException(TEMPLATE_FILE_TYPE_NOT_SUPPORTED);
				}

				Gson gson = new Gson();
				AppointmentModel list = gson.fromJson(candidateList, AppointmentModel.class);
				logger.info(JSON_DATA_ENTITY, list);
				bistream = new ByteArrayInputStream(fileServiceII.previewAppointment(list, templateFile));
				headers.add(CONTENT, ATTACHMENT_PDF_FILE);
			}
		} catch (Exception exc) {
			logger.error("Exception occurred during India Appointment preview api : ", exc);
		}
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bistream));
	}

	@PostMapping(value = "/appointment/letter")
	public String generateAppointment(@RequestPart("excelFile") MultipartFile excelFile,
			@RequestPart("templateFile") MultipartFile templateFile, HttpServletRequest request)
			throws IOException, ParseException {
		logger.info("/AppointmentLetter - Generate Appointment Letter");
		String message = "";
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (!validator.isExcelValid(excelFile)) {
					message = EXCEL_FILE_TYPE_NOT_SUPPORTED;
					throw new GenericException(EXCEL_FILE_TYPE_NOT_SUPPORTED);
				} else if (!validator.isDocTemplateValid(templateFile)) {
					message = TEMPLATE_FILE_TYPE_NOT_SUPPORTED;
					throw new GenericException(TEMPLATE_FILE_TYPE_NOT_SUPPORTED);
				}
				message = fileServiceII.generateAppointmentLetter(excelFile, templateFile);
			} else {
				message = "Failed to authenticate";
			}
		} catch (Exception exc) {
			message = exc.getMessage();
			logger.error("Exception occurred during India appointment letter api : ", exc);
		}
		return message;
	}

	@GetMapping("/application/form/report")
	public ResponseEntity<Resource> getAFReport(HttpServletRequest request) {
		logger.info("/AppFormReport");
		String filename = "Application_Form_Report.xlsx";
		InputStreamResource file = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				file = new InputStreamResource(reportService.getAFReport());
			}
		} catch (Exception exc) {
			logger.error("Exception occurred during /application/form/report api : ", exc);
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
	}

	@GetMapping("/education/employement/report")
	public ResponseEntity<Resource> getEducationEmploymentReport(HttpServletRequest request) {
		logger.info("/EduEmpReport");
		String filename = "Education_Employment_Report.xlsx";
		InputStreamResource file = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				file = new InputStreamResource(reportService.getEduEmpReport());
			}
		} catch (Exception exc) {
			logger.error("Exception occurred during /education/employement/report api : ", exc);
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
	}

	@GetMapping("/offer/retention/report")
	public ResponseEntity<Resource> getOfferRetentionReport(HttpServletRequest request) {
		logger.info("/OfferRetReport");
		String filename = "Offer_Retention_Report.xlsx";
		InputStreamResource file = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				file = new InputStreamResource(reportService.getOfferRetReport());
			}
		} catch (Exception exc) {
			logger.error("Exception occurred during /education/employement/report api : ", exc);
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
	}

	@GetMapping("/india/report")
	public ResponseEntity<Resource> getIndiaReport(HttpServletRequest request) {
		logger.info("/IndiaReport");
		String filename = "India_Report.xlsx";
		InputStreamResource file = null;
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				file = new InputStreamResource(reportService.getIndiaReport());
			}
		} catch (Exception exc) {
			logger.error("Exception occurred during /education/employement/report api : ", exc);
		}
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, ATTACHMENT_FILE + filename)
				.contentType(MediaType.parseMediaType(MS_EXCEL)).body(file);
	}

	/*
	 * @PostMapping("/change/password") public String
	 * changePasswordCandidate(@RequestBody ForgotPasswordRequest request,
	 * HttpServletRequest headerRequest) {
	 * logger.info("/change/password - Change Password"); String message = "";
	 * String decryptedPassword = null; boolean validate; logger.info(request);
	 * boolean tokenValidate; String jwtToken =
	 * headerRequest.getHeader("Authorization").replace("Bearer ", ""); String
	 * emailID = tokenValidator.decodeEmailId(jwtToken); try { tokenValidate =
	 * tokenValidator.validateHrToken(emailID, jwtToken); if (tokenValidate) {
	 * validate = validator.validateRequest(emailID, request.getNewPassword()); if
	 * (validate) { decryptedPassword =
	 * encryptService.decrptPwd(request.getNewPassword(), PASSWORD); message =
	 * candidateService.checkUserDetails(emailID, decryptedPassword); } else {
	 * message = "Validation failed"; } } else { message = "Failed to Authenticate";
	 * } } catch (Exception e) { message = e.getMessage();
	 * logger.error("Error occurred : ", e); } return message; }
	 */

	@PostMapping("/change/password/hr")
	public String changePasswordHR(@RequestBody ForgotPasswordRequest request, HttpServletRequest headerRequest) {
		logger.info("/change/password - Change Password");
		String message = "";
		String decryptEmailId = null;
		String decryptedPassword = null;
		boolean validate;
		if (request == null) {
			logger.error("candidate details not found");
			throw new GenericException("candidate details not found");
		}
		boolean validateToken;
		String jwtToken = headerRequest.getHeader("Authorization").replace("Bearer ", "");
		String emailID = tokenValidator.decodeEmailId(jwtToken);
		try {
			validateToken = tokenValidator.validateHrToken(emailID, jwtToken);
			if (validateToken) {
				validate = validator.validateRequest(request.getEmailID(), request.getNewPassword());
				if (validate) {
					decryptEmailId = encryptService.decrptPwd(request.getEmailID(), EMAIL);
					decryptedPassword = encryptService.decrptPwd(request.getNewPassword(), PASSWORD);
					message = hrService.changeCandPwdByHR(decryptEmailId, decryptedPassword);
				} else {
					message = "Validation failed";
				}
			} else {
				message = "Failed to authenticate";
			}
		} catch (Exception e) {
			message = e.getMessage();
			logger.error("Error occurred : ", e);
		}
		return message;
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logoutUser(HttpServletRequest request)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		HRFormResponse hrFormResponse = null;
		ResponseEntity<String> entity = null;
		String jwtToken = request.getHeader("Authorization").replace("Bearer ", "");
		String emailID = tokenValidator.decodeEmailId(jwtToken);
		try {
			if (emailID.isEmpty()) {
				logger.error("Username cannot be empty");
				entity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("failure");
				throw new GenericException("Username cannot be empty");
			} else {
				hrFormResponse = hrService.hrLogout(emailID, jwtToken);
				if (null != hrFormResponse && hrFormResponse.getAuthenticationCode().equals(HttpStatus.ACCEPTED)) {
					entity = ResponseEntity.status(HttpStatus.OK).body("success");
				} else {
					entity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("failure");
				}
			}
		} catch (Exception ex) {
			entity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		return entity;
	}

	@PostMapping("/reset/password/hr")
	public String resetPasswordHR(@RequestBody ForgotPasswordRequest request, HttpServletRequest headerRequest) {
		logger.info("/Reset/password - Reset Password by Super User");
		String message = "";
		String decryptedEmailId = null;
		String decryptedPassword = null;
		boolean validate;
		if (request == null) {
			logger.error("HR details not found");
			throw new GenericException("HR details not found");
		}
		boolean validateToken;
		String jwtToken = headerRequest.getHeader("Authorization").replace("Bearer ", "");
		String emailID = tokenValidator.decodeEmailId(jwtToken);
		try {
			validateToken = tokenValidator.validateHrToken(emailID, jwtToken);
			if (validateToken) {
				validate = validator.validateRequest(request.getEmailID(), request.getNewPassword());
				if (validate) {
					decryptedEmailId = encryptService.decrptPwd(request.getEmailID(), EMAIL);
					decryptedPassword = encryptService.decrptPwd(request.getNewPassword(), PASSWORD);
					message = hrService.checkHRDetails(decryptedEmailId, decryptedPassword);
				} else {
					message = "Validation failed";
				}
			} else {
				message = "Failed to authenticate";
			}
		} catch (Exception e) {
			message = e.getMessage();
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
			validateToken = tokenValidator.validateHrToken(emailID, jwtToken);
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