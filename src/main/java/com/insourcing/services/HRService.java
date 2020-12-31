package com.insourcing.services;

import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.entity.HRLoginEntity;
import com.insourcing.entity.HRPwdHistoryEntityMap;
import com.insourcing.entity.PasswordHistoryEntityMap;
import com.insourcing.helper.TokenGenerator;
import com.insourcing.model.HRFormRequest;
import com.insourcing.model.HRFormResponse;
import com.insourcing.repository.CandidateRepo;
import com.insourcing.repository.HRLoginRepo;
import com.insourcing.repository.HRPwdHistoryRepo;
import com.insourcing.repository.PwdHistoryRepo;

@Service
public class HRService {

	@Autowired
	EncryptService encryptService;

	@Autowired
	HRLoginRepo hrRepository;

	@Autowired
	public CandidateRepo candRepo;

	@Autowired
	HRPwdHistoryRepo hrPwdHistoryRepo;

	@Autowired
	PwdHistoryRepo pwdHistoryRepo;

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

	public HRFormResponse candidateLoginFailure() {
		HRFormResponse hrFormResponse = new HRFormResponse();
		hrFormResponse.setAuthenticationCode(HttpStatus.UNAUTHORIZED);
		return hrFormResponse;
	}

	public HRFormResponse login(String emailId, String password) {
		logger.info("hrLogin - Entry");

		HRFormResponse hrFormResponse = new HRFormResponse();
		HRLoginEntity hrEntityMap = hrRepository.findByEmailId(emailId);

		if (null != hrEntityMap && hrEntityMap.getIncorrectLoginAttempt() > 4) {
			long timeDifference = Duration.between(hrEntityMap.getAccountLockedTime(), LocalDateTime.now()).toMinutes();
			// hrFormResponse.setLoginTimeDifference(timeDifference);
			if (timeDifference > 60) {
				hrFormResponse = authenticateUser(emailId, password, hrEntityMap, hrFormResponse);
			} else {
				hrFormResponse.setAuthenticationCode(HttpStatus.UNAUTHORIZED);
				hrFormResponse.setInCorrectLoginAttempt(hrEntityMap.getIncorrectLoginAttempt());
				logger.info("Incorrect login attempt {}", hrEntityMap.getIncorrectLoginAttempt());
				return hrFormResponse;
			}
		} else if (null != hrEntityMap) {
			hrFormResponse = authenticateUser(emailId, password, hrEntityMap, hrFormResponse);
			logger.info("In else part Incorrect login attempt {}", hrEntityMap.getIncorrectLoginAttempt());
		} else {
			hrFormResponse.setAuthenticationCode(HttpStatus.UNAUTHORIZED);
		}

		logger.info("hrLogin - Exit");
		return hrFormResponse;
	}

	private HRFormResponse authenticateUser(String email, String password, HRLoginEntity hrLoginEntity,
			HRFormResponse hrFormResponse) {

		if (!email.isEmpty() && isHRAuthenticated(hrLoginEntity, email, password)) {
			hrLoginEntity = hrRepository.findByEmailId(email);
			logger.info("HRLogin - authentication sucessfull");
			if (null != hrLoginEntity && !hrLoginEntity.isHRLoggedIn()) {
				String jwtToken = TokenGenerator.getJWTToken(hrLoginEntity.getEmailId());
				hrFormResponse = new ModelMapper().map(hrLoginEntity, HRFormResponse.class);
				hrFormResponse.setJwtToken(jwtToken);
				hrFormResponse.setAuthenticationCode(HttpStatus.OK);
				hrLoginEntity.setLastLoginTime(LocalDateTime.now());
				hrLoginEntity.setHRLoggedIn(true);
				hrLoginEntity.setIncorrectLoginAttempt(ZERO);
				hrLoginEntity.setLastLoginTime(LocalDateTime.now());
				hrLoginEntity.setGenToken(jwtToken.replace("Bearer ", ""));
				hrRepository.save(hrLoginEntity);
			} else {
				hrFormResponse.setAuthenticationCode(HttpStatus.CONFLICT);
				hrFormResponse.setJwtToken(hrLoginEntity.getGenToken());
			}
		} else {
			hrFormResponse.setAuthenticationCode(HttpStatus.UNAUTHORIZED);
			hrFormResponse.setInCorrectLoginAttempt(hrLoginEntity.getIncorrectLoginAttempt());
			logger.info("HRLogin - authentication failed");
		}
		return hrFormResponse;
	}

	private boolean isHRAuthenticated(HRLoginEntity hrEntityMap, String emailId, String password) {
		logger.info("HRLogin - user authentication");
		boolean isAuthenticated = false;
		if (emailId != null) {
			if (password != null) {
				isAuthenticated = encryptService.isPasswordMatching(password, hrEntityMap.getPassword());
				if (null != hrEntityMap) {
					if (isAuthenticated) {
						hrEntityMap.setIncorrectLoginAttempt(ZERO);
					} else {
						if (password.equals(hrEntityMap.getPassword())) {
							hrEntityMap.setPassword(encryptService.encryptPassword(password));
							hrRepository.save(hrEntityMap);
							return true;
						}
						hrEntityMap.setIncorrectLoginAttempt(hrEntityMap.getIncorrectLoginAttempt() + 1);
						if (hrEntityMap.getIncorrectLoginAttempt() == 5) {
							hrEntityMap.setAccountLockedTime(LocalDateTime.now());

						}
					}
					hrRepository.save(hrEntityMap);
				}
			} else {
				isAuthenticated = false;
			}
		} else {
			isAuthenticated = false;
		}

		return isAuthenticated;
	}

	public HRFormResponse hrLogout(String email, String expiredToken) {
		HRLoginEntity hrLoginEntity = null;
		HRFormResponse hrFormResponse = new HRFormResponse();
		modelMapper = new ModelMapper();
		if (!email.isEmpty()) {
			logger.info("HR - logout - entry");
			hrLoginEntity = hrRepository.findByEmailId(email);
			if (null != hrLoginEntity) {
				hrLoginEntity.setHRLoggedIn(false); // update logout flag
				hrLoginEntity.setExpiredToken(expiredToken);
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
	public String changeCandPwdByHR(String emailId, String newPassword) {
		logger.info("Change candidate password - Entry");
		logger.info(emailId);
		String message = null;
		try {
			CandidateEntityMap candidateEntityMap = candRepo.findByEmailid(emailId);
			PasswordHistoryEntityMap passwordHistoryEntityMap = pwdHistoryRepo.findByEmailId(emailId);
			logger.info(candidateEntityMap);
			if (null != candidateEntityMap) {

				if (candidateEntityMap.getPassword().length() == 8) {
					candidateEntityMap.setPassword(encryptService.encryptPassword(candidateEntityMap.getPassword()));
				}
				if (passwordHistoryEntityMap.getPassword1().length() == 8) {
					passwordHistoryEntityMap
							.setPassword1(encryptService.encryptPassword(passwordHistoryEntityMap.getPassword1()));
				}
				if (encryptService.isPasswordMatching(newPassword, candidateEntityMap.getPassword())
						|| encryptService.isPasswordMatching(newPassword, passwordHistoryEntityMap.getPassword1())
						|| encryptService.isPasswordMatching(newPassword, passwordHistoryEntityMap.getPassword2())
						|| encryptService.isPasswordMatching(newPassword, passwordHistoryEntityMap.getPassword3())) {
					message = "Old_and_New_Password_cannot_be_same";
				} else {

					if (passwordHistoryEntityMap.getPassword2() == null
							&& passwordHistoryEntityMap.getPassword3() == null) {
						passwordHistoryEntityMap.setPassword2(encryptService.encryptPassword(newPassword));
						candidateEntityMap.setPassword(passwordHistoryEntityMap.getPassword2());
					} else if (passwordHistoryEntityMap.getPassword2() != null
							&& passwordHistoryEntityMap.getPassword3() == null) {
						passwordHistoryEntityMap.setPassword3(encryptService.encryptPassword(newPassword));
						candidateEntityMap.setPassword(passwordHistoryEntityMap.getPassword3());
					} else {
						passwordHistoryEntityMap.setPassword1(passwordHistoryEntityMap.getPassword2());
						passwordHistoryEntityMap.setPassword2(passwordHistoryEntityMap.getPassword3());
						passwordHistoryEntityMap.setPassword3(encryptService.encryptPassword(newPassword));
						candidateEntityMap.setPassword(passwordHistoryEntityMap.getPassword3());
					}
					pwdHistoryRepo.save(passwordHistoryEntityMap);
					candRepo.save(candidateEntityMap);

					message = "success";
					}
				}
		} catch (Exception exce) {
			message = "Candidate not registered";
			logger.error("exception occurred", exce);
		}
		logger.info("Change candidate password - Exit");
		return message;
	}

	public String checkHRDetails(String emailId, String newPassword) {
		logger.info("Change HR password - Entry");
		logger.info(emailId);
		String message = null;
		try {
			HRLoginEntity hrLoginEntity = hrRepository.findByEmailId(emailId);
			HRPwdHistoryEntityMap passwordHistoryEntityMap = hrPwdHistoryRepo.findByEmailId(emailId);
			logger.info(hrLoginEntity);

			if (null != hrLoginEntity) {
				if (hrLoginEntity.getPassword().length() == 8) {
					hrLoginEntity.setPassword(encryptService.encryptPassword(hrLoginEntity.getPassword()));

				}
				if (passwordHistoryEntityMap.getPassword1().length() == 8) {

					passwordHistoryEntityMap
							.setPassword1(encryptService.encryptPassword(passwordHistoryEntityMap.getPassword1()));
				}

				if (encryptService.isPasswordMatching(newPassword, hrLoginEntity.getPassword())
						|| encryptService.isPasswordMatching(newPassword, passwordHistoryEntityMap.getPassword1())
						|| encryptService.isPasswordMatching(newPassword, passwordHistoryEntityMap.getPassword2())
						|| encryptService.isPasswordMatching(newPassword, passwordHistoryEntityMap.getPassword3())) {
					message = "Old_and_New_Password_cannot_be_same";
				} else {

					if (passwordHistoryEntityMap.getPassword2() == null
							&& passwordHistoryEntityMap.getPassword3() == null) {
						passwordHistoryEntityMap.setPassword2(encryptService.encryptPassword(newPassword));
						hrLoginEntity.setPassword(passwordHistoryEntityMap.getPassword2());
					} else if (passwordHistoryEntityMap.getPassword2() != null
							&& passwordHistoryEntityMap.getPassword3() == null) {
						passwordHistoryEntityMap.setPassword3(encryptService.encryptPassword(newPassword));
						hrLoginEntity.setPassword(passwordHistoryEntityMap.getPassword3());
					} else {
						passwordHistoryEntityMap.setPassword1(passwordHistoryEntityMap.getPassword2());
						passwordHistoryEntityMap.setPassword2(passwordHistoryEntityMap.getPassword3());
						passwordHistoryEntityMap.setPassword3(encryptService.encryptPassword(newPassword));
						hrLoginEntity.setPassword(passwordHistoryEntityMap.getPassword3());
					}
					hrPwdHistoryRepo.save(passwordHistoryEntityMap);
					hrRepository.save(hrLoginEntity);

					message = "success";
				}
					}

		} catch (Exception exce) {
			message = "HR not registered";
			logger.error("exception occurred", exce);
		}
		logger.info("Changed HR password - Exit");
		return message;
	}

}