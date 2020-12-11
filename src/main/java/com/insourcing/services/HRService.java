package com.insourcing.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.insourcing.entity.*;
import com.insourcing.helper.TokenGenerator;
import com.insourcing.model.HRFormRequest;
import com.insourcing.model.HRFormResponse;
import com.insourcing.repository.*;

import org.modelmapper.ModelMapper;

@Service
public class HRService {

	@Autowired
	EncryptService encryptService;

	@Autowired
	HRLoginRepo hrRepository;

	ModelMapper modelMapper;

	private static Logger logger = LogManager.getLogger(HRService.class);
	@Value("${insource.app.india.date.format}")
	private String indiaDateFormat;

	@Value("${insource.app.india.zone.id}")
	private String indiaZoneId;

	@Value("${insource.app.us.date.format}")
	private String usDateFormat;

	@Value("${insource.app.us.zone.id}")
	private String usZoneId;

	@Value("${insource.app.hr.role}")
	private String hrRole;

	private final static int ZERO = 0;

	public String register(HRFormRequest request) {
		logger.info("updateHRDetails - Entry");
		String message = "";
		HRLoginEntity hrEntityMap = hrRepository.findByEmailId(request.getEmailId());
		if (null == hrEntityMap) {
			hrEntityMap = new ModelMapper().map(request, HRLoginEntity.class);
			hrEntityMap.setPassword(encryptService.encryptPassword(request.getPassword()));
			hrEntityMap.setRole(hrRole);
			hrEntityMap.setLastUpdatedDateTime(LocalDateTime.now());
			hrEntityMap.setLastLoginTime(LocalDateTime.now());
			hrRepository.save(hrEntityMap);
			message = HttpStatus.ACCEPTED.toString();
		} else {
			message = HttpStatus.NOT_ACCEPTABLE.toString();
			logger.info("HR User already exists");
		}
		logger.info("updateHRDetails - Exit");
		return message;
	}

	public HRFormResponse login(String emailId, String password) {
		logger.info("hrLogin - Entry");
		HRLoginEntity hrEntityMap;
		HRFormResponse hrFormResponse = new HRFormResponse();
		//hrEntityMap = hrRepository.findByEmailId(emailId);
		Optional<HRLoginEntity> row = hrRepository.findById(emailId);
		hrEntityMap=row.get();
		hrFormResponse = authenticateUser(emailId, password, hrEntityMap, hrFormResponse);
		logger.info("hrLogin - Exit");
		return hrFormResponse;
	}

	private HRFormResponse authenticateUser(String email, String password, HRLoginEntity hrLoginEntity,
			HRFormResponse hrFormResponse) {
		if (isHRAuthenticated(email, password)) {
		//	if (true) {
			logger.info("HRLogin - authentication sucessfull"+hrLoginEntity);
			if (null != hrLoginEntity) {
				hrFormResponse = new ModelMapper().map(hrLoginEntity, HRFormResponse.class);
				hrFormResponse.setJwtToken(TokenGenerator.getJWTToken(hrLoginEntity.getEmailId()));
				hrFormResponse.setAuthenticationCode(HttpStatus.OK);
				hrLoginEntity.setLastLoginTime(LocalDateTime.now());
				hrLoginEntity.setHRLoggedIn(true);
				hrLoginEntity.setIncorrectLoginAttempt(ZERO);
				hrRepository.save(hrLoginEntity);
			} else {
				hrFormResponse.setAuthenticationCode(HttpStatus.CONFLICT);
				return hrFormResponse;
			}
		} else {
			hrFormResponse.setAuthenticationCode(HttpStatus.UNAUTHORIZED);
			hrLoginEntity.setIncorrectLoginAttempt(hrLoginEntity.getIncorrectLoginAttempt() + 1);
			hrRepository.save(hrLoginEntity);
			hrFormResponse.setInCorrectLoginAttempt(hrLoginEntity.getIncorrectLoginAttempt());
			logger.info("HRLogin - authentication failed");
		}
		return hrFormResponse;
	}

	private boolean isHRAuthenticated(String emailId, String password) {
		logger.info("HRLogin - user authentication");
		boolean isAuthenticated = false;
		HRLoginEntity hrEntityMap = null;
		if (!emailId.isEmpty()) {
			hrEntityMap = hrRepository.findByEmailId(emailId);
			if (null != hrEntityMap) {
				isAuthenticated = encryptService.isPasswordMatching(password, hrEntityMap.getPassword());
			}
		}
		return isAuthenticated;
	}

	public HRFormResponse hrLogout(String email) {
		HRLoginEntity hrLoginEntity = null;
		HRFormResponse hrFormResponse = new HRFormResponse();
		modelMapper = new ModelMapper();
		if (!email.isEmpty()) {
			logger.info("HR - logout - entry");
			hrLoginEntity = hrRepository.findByEmailId(email);
			if (null != hrLoginEntity) {
				hrLoginEntity.setHRLoggedIn(false); // update logout flag
				hrRepository.save(hrLoginEntity);
				hrFormResponse.setAuthenticationCode(HttpStatus.ACCEPTED);
			}
		} else {
			hrFormResponse.setAuthenticationCode(HttpStatus.NOT_ACCEPTABLE);
			logger.info("HR - logout - exit");
		}
		return hrFormResponse;
	}

	public String updatePassword(String emailID, String newPassword) {
		String message = null;
		try {
			HRLoginEntity hrLoginEntity = hrRepository.findByEmailId(emailID);
			if (null != hrLoginEntity) {
				if (encryptService.isPasswordMatching(newPassword, hrLoginEntity.getPassword())) {
					message = "Old_and_New_Password_cannot_be_same";
				} else {
					hrLoginEntity.setPassword(encryptService.encryptPassword(newPassword));
					hrRepository.save(hrLoginEntity);
					message = "success";
				}
			} else {
				message = "Email_Id_does_not_exists";
			}
		} catch (Exception exce) {
			logger.error("exception occurred", exce);
		}
		return message;
	}
}