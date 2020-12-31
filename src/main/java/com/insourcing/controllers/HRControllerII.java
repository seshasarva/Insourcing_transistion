package com.insourcing.controllers;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.insourcing.entity.EmailTempEntity;
import com.insourcing.exception.GenericException;
import com.insourcing.model.AppIndiaExtraFieldsRequest;
import com.insourcing.model.AppUsExtraFieldsRequest;
import com.insourcing.model.EmailNotificationRequest;
import com.insourcing.model.EmailTemplateRequest;
import com.insourcing.model.EmailTemplateResponse;
import com.insourcing.model.WorkflowSeqModel;
import com.insourcing.services.HRServiceII;
import com.insourcing.validator.EntityValidator;
import com.insourcing.validator.TokenValidator;

@CrossOrigin
@RestController
@RequestMapping("/hrbc")
public class HRControllerII {

	private static Logger logger = LogManager.getLogger(HRControllerII.class);

	private static final String EMPTY_LIST = "Empty list";
	private static final String EXCEPTION_OCCURRED = "Exception occurred : ";
	private static final String JSON_DATA = "jsonData(String) : {}";
	private static final String EXCEL_FILE_TYPE_NOT_SUPPORTED = "Excel File Type should be .xlsx";
	private static final String JSON_DATA_ENTITY = "jsonData(Entity) : {}";
	private static final String DEAL_ID_NOT_FOUND = "Deal Id not found";
	private static final String HEADER = "Authorization";
	private static final String PREFIX = "Bearer ";

	@Autowired
	EntityValidator validator;
	@Autowired
	HRServiceII hrService;
	@Autowired
	TokenValidator tokenValidator;

	@PostMapping("/saveTemplate")
	public String saveTemplate(@RequestBody EmailTemplateRequest request, HttpServletRequest httpRequest) {
		logger.info("/saveTemplate-Entry");
		boolean tokenValidate;
		String response = null;
		String jwtToken = httpRequest.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				logger.info("/HRBC - HRBC Template Save");
				if (request.getEmailId().isEmpty()) {
					logger.error("HR MailId cannot be empty");
					throw new GenericException("HR MailId cannot be empty");
				}
				hrService.saveTemplate(request);
			} else {
				response = "Authentication failed!";
			}
		} catch (Exception ex) {
			logger.info("/HRBC - HRBC Template Save Error");
		}
		logger.info("/saveTemplate-Exit");
		response = "Template Saved Successfully";
		return response;
	}

	@PostMapping("/chooseTemplate")
	public EmailTemplateResponse chooseTemplate(@RequestBody EmailTemplateRequest request,
			HttpServletRequest httpRequest) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		logger.info("/chooseTemplate-Entry");
		EmailTemplateResponse emailTemplateResponse = null;
		boolean tokenValidate;
		String jwtToken = httpRequest.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (request.getEmailId() != null && request.getTemplateName() != null) {

					emailTemplateResponse = hrService.chooseTemplate(request);

				} else {
					logger.error("Template Name cannot be empty");
					throw new GenericException("Template Name cannot be empty");
				}
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		logger.info("/chooseTemplate-Exit");
		return emailTemplateResponse;
	}

	@PostMapping("/getTemplate")
	public List<EmailTempEntity> getTemplate(@RequestBody EmailTemplateRequest request, HttpServletRequest httpRequest)
			throws InvalidKeyException {
		logger.info("/Template list - List of Templates");
		List<EmailTempEntity> list = hrService.getTemplate(request);
		boolean tokenValidate;
		String jwtToken = httpRequest.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (list.isEmpty()) {
					logger.error(EMPTY_LIST);
					throw new GenericException(EMPTY_LIST);
				}
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		logger.info("/getTemplate-Exit");
		return list;
	}

	@PostMapping(value = "/sendEmail")
	public String generatePreviewAppointment(@RequestPart("jsonData") String emailTemplateList,
			@RequestPart("excelFile") MultipartFile excelFile, HttpServletRequest httpRequest) throws IOException {
		logger.info("/sendEmail - Send Email - Entry");
		logger.info(JSON_DATA, emailTemplateList);
		String message = null;
		if (emailTemplateList == null) {
			throw new GenericException("Please add json data for appointment letter");
		}
		if (!validator.isExcelValid(excelFile)) {
			throw new GenericException(EXCEL_FILE_TYPE_NOT_SUPPORTED);
		}
		boolean tokenValidate;
		String jwtToken = httpRequest.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				Gson gson = new Gson();
				EmailNotificationRequest list = gson.fromJson(emailTemplateList, EmailNotificationRequest.class);
				logger.info(JSON_DATA_ENTITY, list);
				message = hrService.sendMultipleEmail(list, excelFile);
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
			message = ex.getMessage();
		}
		logger.info("/sendEmail");
		return message;
	}

	@PostMapping("/india/deals/fields")
	public String appIndiaExtraFields(@RequestBody AppIndiaExtraFieldsRequest request, HttpServletRequest httpRequest)
			throws InvalidKeyException {
		logger.info("/india/deals/extraFields - Application form extra fields:-Entry");
		String message = null;
		boolean tokenValidate;
		String jwtToken = httpRequest.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (request != null) {
					if (request.getDealId() == null) {
						logger.error(DEAL_ID_NOT_FOUND);
						message = DEAL_ID_NOT_FOUND;
						throw new GenericException(DEAL_ID_NOT_FOUND);
					}
					message = hrService.appIndiaExtraFieldsUpdate(request);
				}
			} else {
				message = "Authentication failed";
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
			message = ex.getMessage();
		}
		logger.info("/india/deals/extraFields - Application form extra fields:-Exit");
		return message;
	}

	@PostMapping("/us/deals/fields")
	public String appUsExtraFields(@RequestBody AppUsExtraFieldsRequest request, HttpServletRequest httpRequest)
			throws InvalidKeyException {
		logger.info("/us/deals/extraFields - Application form extra fields:-Entry");
		String message = null;
		boolean tokenValidate;
		String jwtToken = httpRequest.getHeader(HEADER).replace(PREFIX, "");
		logger.info(jwtToken);
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		logger.info(emailId);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (request != null) {
					if (request.getDealId() == null) {
						logger.error(DEAL_ID_NOT_FOUND);
						message = DEAL_ID_NOT_FOUND;
						throw new GenericException(DEAL_ID_NOT_FOUND);
					}
					message = hrService.appUsExtraFieldsUpdate(request);
				}
			} else {
				message = "Authentication failed";
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
			message = ex.getMessage();
		}
		logger.info("/us/deals/extraFields - Application form extra fields:-Exit");
		return message;
	}

	@PostMapping("/india/application/form/fields")
	public AppIndiaExtraFieldsRequest appIndiaFormFields(@RequestPart("dealId") String dealId,
			HttpServletRequest httpRequest) throws InvalidKeyException {
		logger.info("/india/application/form/fields-Entry");
		AppIndiaExtraFieldsRequest fields = new AppIndiaExtraFieldsRequest();
		boolean tokenValidate;
		String jwtToken = httpRequest.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (dealId == null) {
					logger.error(DEAL_ID_NOT_FOUND);
					throw new GenericException(DEAL_ID_NOT_FOUND);
				}
				fields = hrService.appIndiaFormFields(dealId);
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		logger.info("/india/application/form/fields-Exit");
		return fields;
	}

	@PostMapping("/us/application/form/fields")
	public AppUsExtraFieldsRequest appUsFormFields(@RequestPart("dealId") String dealId, HttpServletRequest httpRequest)
			throws InvalidKeyException {
		logger.info("/us/application/form/fields-Entry");
		AppUsExtraFieldsRequest fields = new AppUsExtraFieldsRequest();
		boolean tokenValidate;
		String jwtToken = httpRequest.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (dealId == null) {
					logger.error(DEAL_ID_NOT_FOUND);
					throw new GenericException(DEAL_ID_NOT_FOUND);
				}
				fields = hrService.appUsFormFields(dealId);
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		logger.info("/us/application/form/fields-Exit");
		return fields;
	}

	@PostMapping("/workflow/sequence")
	public String workflowSequence(@RequestBody WorkflowSeqModel workFlowSeq, HttpServletRequest httpRequest)
			throws InvalidKeyException {
		logger.info("/workflow/sequence-Entry");
		boolean tokenValidate = false;
		String message = null;
		String jwtToken = httpRequest.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (workFlowSeq.getDealId() == null) {
					logger.error(DEAL_ID_NOT_FOUND);
					throw new GenericException(DEAL_ID_NOT_FOUND);
				}
				message = hrService.workflowSequence(workFlowSeq);
			}
		} catch (Exception ex) {
			logger.error(EXCEPTION_OCCURRED, ex);
		}
		logger.info("/workflow/sequence-Exit");
		return message;
	}

}
