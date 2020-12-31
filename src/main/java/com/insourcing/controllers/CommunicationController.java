
package com.insourcing.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insourcing.model.EmailNotificationRequest;
import com.insourcing.model.EmailNotificationResponse;
import com.insourcing.model.ErrorInfo;
import com.insourcing.services.EmailService;
import com.insourcing.validator.TokenValidator;

@CrossOrigin
@RestController
public class CommunicationController {
	private static final Logger logger = LogManager.getLogger(CommunicationController.class);
	// private static final String EXCEPTION_OCCURRED = "Exception occurred : ";

	@Autowired
	private EmailService emailService;

	private ErrorInfo errorInfo;

	@Autowired
	TokenValidator tokenValidator;

	private static final String HEADER = "Authorization";
	private static final String PREFIX = "Bearer ";

	// This service is for only recruiters to send email notification for candidates
	// from Send Notification page.

	@PostMapping("mail/sendNotification")
	public ResponseEntity<EmailNotificationResponse> sendEmailNotification(
			@RequestBody EmailNotificationRequest emailNotificationRequest, HttpServletRequest request)
			throws Exception {
		logger.info("Entering CommunicationController :: sendEmailNotification() method");
		String userRole = request.getSession().getAttribute("LOGGED_USER_ROLE").toString();
		boolean tokenValidate;
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.validateHrToken(emailId, jwtToken);
			if (tokenValidate) {
				if (isRecruiterRole(userRole)) {
					try {
						emailService.sendEmail(emailNotificationRequest);
					} catch (Exception e) {
						logger.error("CommunicationController :: Exception occured " + e.getMessage());
						errorInfo = new ErrorInfo("ERR_CD_0008", e.getMessage(),
								"CommunicationController :: sendEmailNotification()",
								"Unable to send Email. Please try again.", e.getClass().toString());
						throw e;
					}
				}
			}
		} catch (Exception ex) {
			logger.info("/HRBC - mail/sendNotification");
		}
		EmailNotificationResponse response = new EmailNotificationResponse();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ErrorInfo> handleException(Exception exception, HttpServletRequest request) {
		return new ResponseEntity<>(errorInfo, HttpStatus.OK);
	}

	private boolean isRecruiterRole(String userRole) { // get the user role from request session
		logger.info("Entering isRecruiterRole :: USER_ROLE from Session :: " + userRole);
		if ("RECRUITER".equalsIgnoreCase(userRole)) {
			return true;
		}
		return false;
	}

}
