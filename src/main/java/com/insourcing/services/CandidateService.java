package com.insourcing.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.insourcing.config.CommonConstants;
import com.insourcing.entity.ApplicationIndiaEntity;
import com.insourcing.entity.ApplicationIndiaEntityMap;
import com.insourcing.entity.ApplicationUSEntity;
import com.insourcing.entity.ApplicationUSEntityMap;
import com.insourcing.entity.CandidateEntity;
import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.entity.OfferIndiaEntity;
import com.insourcing.entity.PasswordHistoryEntityMap;
import com.insourcing.entity.WorkflowSeqEntity;
import com.insourcing.helper.DateHelper;
import com.insourcing.helper.ExcelHelper;
import com.insourcing.helper.PDFGenerator;
import com.insourcing.helper.TokenGenerator;
import com.insourcing.model.EducationModel;
import com.insourcing.model.ExcelModel;
import com.insourcing.model.LoginFormRequest;
import com.insourcing.model.LoginFormResponse;
import com.insourcing.model.OfferStatus;
import com.insourcing.repository.ApplicationIndiaRepo;
import com.insourcing.repository.ApplicationUSRepo;
import com.insourcing.repository.CandidateRepo;
import com.insourcing.repository.HRLoginRepo;
import com.insourcing.repository.OfferIndiaRepo;
import com.insourcing.repository.PwdHistoryRepo;
import com.insourcing.repository.USAFReportRepo;
import com.insourcing.repository.USEduEmpReportRepo;
import com.insourcing.repository.WorkFlowSeqRepo;
import com.insourcing.validator.ApplicationUSValidator;

@Service
public class CandidateService {

	@Autowired
	public CandidateRepo candRepo;

	@Autowired
	public ApplicationUSRepo appUSRepo;

	@Autowired
	public ApplicationIndiaRepo appIndRepo;

	@Autowired
	public USAFReportRepo usafRepo;

	@Autowired
	public USEduEmpReportRepo eduEmpUSReport;

	@Autowired
	public OfferIndiaRepo offerIndRepo;

	@Autowired
	PwdHistoryRepo pwdHistoryRepo;

	@Autowired
	WorkFlowSeqRepo workFlowSeqRepo;

	@Autowired
	EncryptService encryptService;
	@Autowired
	HRLoginRepo hrRepository;
	@Autowired
	ApplicationUSValidator appUsValidator;

	ModelMapper modelMapper;

	private static Logger logger = LogManager.getLogger(CandidateService.class);
	private static final String INDIA = "India";
	private static final String US = "US";
	private static final String EXCEED_CANDIDATES_COUNT = "Please upload less than 2000 candidates";
	private static final String ERROR_MESSAGE_COUNTRY_EXCEL = "Please enter Country and upload excel for email ids : ";
	private static final String ERROR_MESSAGE_INDIA_OR_US = "Please enter country as India or US correctly and try again";
	private static final int ZERO = 0;

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

	/*
	 * Method to save the data from excel to DB
	 * 
	 * @Param input Excel file
	 * 
	 * @Param output Map
	 */
	public Map<String, String> saveData(MultipartFile file, String dealId)
			throws NoSuchAlgorithmException, IOException {
		logger.info("saveData - Entry");
		List<String> message = new ArrayList<>();
		List<CandidateEntity> excel = ExcelHelper.excelToEntity(file.getInputStream());
		String email = null;
		final String errorMessage = "errorMessage";
		Map<String, String> candidateUpdateMap = new HashMap<>();
		if (excel.isEmpty()) {
			candidateUpdateMap.put(errorMessage, EXCEED_CANDIDATES_COUNT + String.join(", ", message));
			return candidateUpdateMap;
		} else {
			for (CandidateEntity candEntity : excel) {
				email = null;
				if (!candEntity.getEmailid().trim().isEmpty()) {
					email = candEntity.getEmailid().trim();
				} else {
					logger.error("Please check, email id is empty in Excel");
					candidateUpdateMap.put("exception", "Please check, email id is empty");
				}
				if (candEntity.getCountry().isEmpty()) {
					logger.warn("Country missing for {}", email);
					message.add(email);
				} else {
					if (isCandidateFound(email)) {
						logger.info("User already exists - {}", email);
						candidateUpdateMap.put(email, HttpStatus.NOT_ACCEPTABLE.toString());
					} else {
						saveCandidateDetails(candEntity, dealId);
						candidateUpdateMap.put(email, HttpStatus.ACCEPTED.toString());
					}
				}
			}
		}
		logger.info("saveData - Exit");
		if (!message.isEmpty()) {
			logger.warn(ERROR_MESSAGE_COUNTRY_EXCEL, message);
			candidateUpdateMap.put(errorMessage, ERROR_MESSAGE_COUNTRY_EXCEL + String.join(", ", message));
			return candidateUpdateMap;
		} else {
			candidateUpdateMap.put("successMessage", "File_processed_successfully : " + file.getOriginalFilename());
			return candidateUpdateMap;
		}
	}

	private void saveCandidateDetails(CandidateEntity candidateEntity, String dealId) {
		if (!candidateEntity.getEmailid().trim().isEmpty()) {
			switch (candidateEntity.getCountry()) {
			case INDIA:
				saveIndiaCandidateDetails(candidateEntity);
				break;
			case US:
				saveUSDetails(candidateEntity);
				break;

			default:
				logger.error(ERROR_MESSAGE_INDIA_OR_US, candidateEntity.getEmailid());
				throw new NullPointerException(
						ERROR_MESSAGE_INDIA_OR_US + " for email " + candidateEntity.getEmailid());
			}
			CandidateEntityMap candEntityMap = mapCandidateDetails(candidateEntity);
			candEntityMap.setFirstTimeLogin(true);
			candEntityMap.setIncorrectLoginAttempt(0);
			candEntityMap.setDealId(dealId);
			candRepo.save(candEntityMap);
			logger.info("Succesfully updated the details in Database for the email id - {}",
					candidateEntity.getEmailid());
		}
	}

	private void saveIndiaCandidateDetails(CandidateEntity candEntity) {
		ApplicationIndiaEntityMap appEntity = new ApplicationIndiaEntityMap();
		OfferIndiaEntity offerEntity = new OfferIndiaEntity();
		appEntity.setEmailId(candEntity.getEmailid());
		appIndRepo.save(appEntity);
		offerEntity.setEmailId(candEntity.getEmailid());
		offerIndRepo.save(offerEntity);
	}

	private void saveUSDetails(CandidateEntity candEntity) {
		ApplicationUSEntityMap appEntity = new ApplicationUSEntityMap();
		appEntity.setEmailid(candEntity.getEmailid());
		appUSRepo.save(appEntity);
	}

	// Download the data from DB to excel
	public ByteArrayInputStream load(String country) {
		logger.info("load - Entry");
		List<ExcelModel> excelupload;
		if (country.equalsIgnoreCase(INDIA)) {
			excelupload = candRepo.findByListIndia();
		} else {
			excelupload = candRepo.findByListUS();
		}
		ByteArrayInputStream in = ExcelHelper.entityToExcel(excelupload);
		logger.info("load - Exit");
		return in;
	}

	public List<CandidateEntityMap> findAllList() {
		logger.info("findAll - Entry");
		List<CandidateEntityMap> list = candRepo.findAll();
		logger.info("findAll - Exit");
		return list;
	}

	public String updateRegister(CandidateEntity candEntity, String emailId) throws ParseException, IOException {
		logger.info("updateRegister - Entry");
		CandidateEntityMap candEntityMap = candRepo.findByEmailid(emailId);
		String countryCode = null;
		String refid = null;
		String digits = null;
		if (candEntityMap.isCandidateLoggedIn()) {
			if (candEntity.getPassword().equals(candEntityMap.getPassword()))
				return "Old_and_New_Password_cannot_be_same";
			if (!(candEntity.getFirstname().equalsIgnoreCase(candEntityMap.getFirstname())
					&& candEntity.getLastname().equalsIgnoreCase(candEntityMap.getLastname())
					&& candEntity.getCountry().equalsIgnoreCase(candEntityMap.getCountry()))) {
				refid = "Kindly contact HR to change the basic details";
			} else if (candEntityMap.getRefId() == null) {
				candEntityMap.setRegflag(true);
				candEntityMap.setPrivacyNotice("yes");
				int ref = candRepo.refid();
				int id = ref + 1;
				candEntityMap.setId(id);

				if (id <= 9)
					digits = "000";
				else if (id >= 10 && id <= 99)
					digits = "00";
				else if (id >= 100 && id <= 999)
					digits = "0";
				else if (id >= 1000 && id <= 9999)
					digits = "";

				if (candEntityMap.getCountry().equalsIgnoreCase(CommonConstants.COUNTRY_INDIA)) {
					countryCode = "IN" + digits;
					logger.info(candEntityMap.getRefId());
					candEntityMap.setRegCompletedDate(DateHelper.setCurrentDate(indiaDateFormat, indiaZoneId));
				} else {
					countryCode = "US" + digits;
					logger.info(candEntityMap.getRefId());
					candEntityMap.setRegCompletedDate(DateHelper.setCurrentDate(usDateFormat, usZoneId));
				}
				refid = "RTF" + countryCode + id;
				logger.info("service" + refid);
				candEntityMap.setRefId(refid);
				candEntityMap.setContactno(candEntity.getContactno());
				candEntityMap.setCurrentTitle(candEntity.getCurrentTitle());
				candEntityMap.setPassword(encryptService.encryptPassword(candEntity.getPassword()));
				candEntityMap.setFirstTimeLogin(false);
				candRepo.save(candEntityMap);

				if (candEntityMap.getCountry().equalsIgnoreCase(CommonConstants.COUNTRY_INDIA)) {
					OfferIndiaEntity offerIndEntity = offerIndRepo.findByEmailId(emailId);
					offerIndEntity.setRefId(refid);
					offerIndRepo.save(offerIndEntity);
				}
				logger.info("updateRegister - Exit");
			} else {
				refid = "Candidate already registered";
			}
		} else {
			refid = "Looks_like_knocking_back_window";
		}
		return refid;
	}

	public void saveDefaultPwd(LoginFormRequest request) throws IOException {
		logger.info("saveDefaultPwd - Entry");
		PasswordHistoryEntityMap pwdEntityMap;
		pwdEntityMap = new ModelMapper().map(request, PasswordHistoryEntityMap.class);
		logger.info("EmailTemplateDetails - Mapped");
		pwdEntityMap.setEmailId(request.getEmailID());
		pwdEntityMap.setPassword1(request.getPassword());
		pwdHistoryRepo.save(pwdEntityMap);
		logger.info("saveDefaultPwd - Saved");
	}

	public List<ApplicationIndiaEntityMap> findApplicationFormall() {
		logger.info("findApplicationFormall - Entry");
		return appIndRepo.findAll();
	}

	public String appUSUpdate(ApplicationUSEntity usappEntity, String emailId) throws ParseException {
		logger.info("appUSUpdate - Entry");
		logger.info("emailid {}", emailId);
		String message = null;
		ApplicationUSEntityMap usAppEntityMap;

		usappEntity = updateEducationDetails(usappEntity);
		boolean validate;
		try {
			validate = appUsValidator.validateUsApp(usappEntity);
			if (validate) {
				usAppEntityMap = new ModelMapper().map(usappEntity, ApplicationUSEntityMap.class);
				usAppEntityMap.setAppflag(true);
				usAppEntityMap.setEmailid(emailId);
				usAppEntityMap.setAppCompletedDate(DateHelper.setCurrentDate(usDateFormat, usZoneId));

				appUSRepo.save(usAppEntityMap);
				CandidateEntityMap candEntityMap = candRepo.findByEmailid(emailId);
				candEntityMap.setAppflag(true);
				candRepo.save(candEntityMap);
				message = "Application Form filled Successfully";
				logger.info("appUSUpdate - Exit");
			}
		} catch (Exception e) {
			message = e.getMessage();
			logger.info("Error occurred : ", e);
		}
		return message;
	}

	public ApplicationUSEntity updateEducationDetails(ApplicationUSEntity usappEntity) {
		logger.info("UpdateEducationDetails - Entry");
		String educationValue = usappEntity.getEducation();
		List<String> hsinstituteName = new ArrayList<>();
		List<String> hsinsAddress = new ArrayList<>();
		List<String> hsgraduate = new ArrayList<>();
		List<String> hsdegree = new ArrayList<>();
		List<String> hscos = new ArrayList<>();
		List<String> hsGPA = new ArrayList<>();

		List<String> msinstituteName = new ArrayList<>();
		List<String> msinsAddress = new ArrayList<>();
		List<String> msgraduate = new ArrayList<>();
		List<String> msdegree = new ArrayList<>();
		List<String> mscos = new ArrayList<>();
		List<String> msGPA = new ArrayList<>();

		List<String> asinstituteName = new ArrayList<>();
		List<String> asinsAddress = new ArrayList<>();
		List<String> asgraduate = new ArrayList<>();
		List<String> asdegree = new ArrayList<>();
		List<String> ascos = new ArrayList<>();
		List<String> asGPA = new ArrayList<>();

		List<String> bcinstituteName = new ArrayList<>();
		List<String> bcinsAddress = new ArrayList<>();
		List<String> bcgraduate = new ArrayList<>();
		List<String> bcdegree = new ArrayList<>();
		List<String> bccos = new ArrayList<>();
		List<String> bcGPA = new ArrayList<>();

		List<String> drinstituteName = new ArrayList<>();
		List<String> drinsAddress = new ArrayList<>();
		List<String> drgraduate = new ArrayList<>();
		List<String> drdegree = new ArrayList<>();
		List<String> drcos = new ArrayList<>();
		List<String> drGPA = new ArrayList<>();

		List<String> otherinstituteName = new ArrayList<>();
		List<String> otherinsAddress = new ArrayList<>();
		List<String> othergraduate = new ArrayList<>();
		List<String> otherdegree = new ArrayList<>();
		List<String> othercos = new ArrayList<>();
		List<String> otherGPA = new ArrayList<>();

		try {
			Gson gson = new Gson();
			EducationModel[] list = gson.fromJson(educationValue, EducationModel[].class);
			for (EducationModel educationModel : list) {
				if (educationModel.getEducationalLevel().equalsIgnoreCase("High School")) {
					hsinstituteName.add(educationModel.getInstituteName());
					hsinsAddress.add(educationModel.getInsAddress());
					hsgraduate.add(educationModel.getGraduate());
					hsdegree.add(educationModel.getDegree());
					hscos.add(educationModel.getCos());
					hsGPA.add(educationModel.getGPA());
				} else if (educationModel.getEducationalLevel().equalsIgnoreCase("Master")) {
					msinstituteName.add(educationModel.getInstituteName());
					msinsAddress.add(educationModel.getInsAddress());
					msgraduate.add(educationModel.getGraduate());
					msdegree.add(educationModel.getDegree());
					mscos.add(educationModel.getCos());
					msGPA.add(educationModel.getGPA());
				} else if (educationModel.getEducationalLevel().equalsIgnoreCase("Associate")) {
					asinstituteName.add(educationModel.getInstituteName());
					asinsAddress.add(educationModel.getInsAddress());
					asgraduate.add(educationModel.getGraduate());
					asdegree.add(educationModel.getDegree());
					ascos.add(educationModel.getCos());
					asGPA.add(educationModel.getGPA());
				} else if (educationModel.getEducationalLevel().equalsIgnoreCase("Bachelor")) {
					bcinstituteName.add(educationModel.getInstituteName());
					bcinsAddress.add(educationModel.getInsAddress());
					bcgraduate.add(educationModel.getGraduate());
					bcdegree.add(educationModel.getDegree());
					bccos.add(educationModel.getCos());
					bcGPA.add(educationModel.getGPA());
				} else if (educationModel.getEducationalLevel().equalsIgnoreCase("Doctoral")) {
					drinstituteName.add(educationModel.getInstituteName());
					drinsAddress.add(educationModel.getInsAddress());
					drgraduate.add(educationModel.getGraduate());
					drdegree.add(educationModel.getDegree());
					drcos.add(educationModel.getCos());
					drGPA.add(educationModel.getGPA());
				} else if (educationModel.getEducationalLevel().equalsIgnoreCase("Other/Certifications")) {
					otherinstituteName.add(educationModel.getInstituteName());
					otherinsAddress.add(educationModel.getInsAddress());
					othergraduate.add(educationModel.getGraduate());
					otherdegree.add(educationModel.getDegree());
					othercos.add(educationModel.getCos());
					otherGPA.add(educationModel.getGPA());
				}
			}
			usappEntity.setHsAddress(String.join(",", hsinsAddress));
			usappEntity.setHsGraduate(String.join(",", hsgraduate));
			usappEntity.setHsCos(String.join(",", hscos));
			usappEntity.setHsGPAScale(String.join(",", hsGPA));
			usappEntity.setHsDegree(String.join(",", hsdegree));
			usappEntity.setHsInsName(String.join(",", hsinstituteName));

			usappEntity.setMasterAddress(String.join(",", msinsAddress));
			usappEntity.setMasterGraduate(String.join(",", msgraduate));
			usappEntity.setMasterCos(String.join(",", mscos));
			usappEntity.setMasterGPAScale(String.join(",", msGPA));
			usappEntity.setMasterDegree(String.join(",", msdegree));
			usappEntity.setMasterInsName(String.join(",", msinstituteName));

			usappEntity.setAssosiateAddress(String.join(",", asinsAddress));
			usappEntity.setAssosiateGraduate(String.join(",", asgraduate));
			usappEntity.setAssosiateCos(String.join(",", ascos));
			usappEntity.setAssociateGPAScale(String.join(",", asGPA));
			usappEntity.setAssosiateDegree(String.join(",", asdegree));
			usappEntity.setAssociateInsName(String.join(",", asinstituteName));

			usappEntity.setBachelorAddress(String.join(",", bcinsAddress));
			usappEntity.setBachelorGraduate(String.join(",", bcgraduate));
			usappEntity.setBachelorCos(String.join(",", bccos));
			usappEntity.setBachelorGPAScale(String.join(",", bcGPA));
			usappEntity.setBachelorDegree(String.join(",", bcdegree));
			usappEntity.setBachelorInsName(String.join(",", bcinstituteName));

			usappEntity.setDoctoralAddress(String.join(",", drinsAddress));
			usappEntity.setDoctoralGraduate(String.join(",", drgraduate));
			usappEntity.setDoctoralCos(String.join(",", drcos));
			usappEntity.setDoctoralGPAScale(String.join(",", drGPA));
			usappEntity.setDoctoralDegree(String.join(",", drdegree));
			usappEntity.setDoctoralInsName(String.join(",", drinstituteName));

			usappEntity.setOthersAddress(String.join(",", drinsAddress));
			usappEntity.setOthersGraduate(String.join(",", drgraduate));
			usappEntity.setOthersCos(String.join(",", drcos));
			usappEntity.setOthersGPAScale(String.join(",", drGPA));
			usappEntity.setOthersDegree(String.join(",", drdegree));
			usappEntity.setOtherInsName(String.join(",", drinstituteName));
		} catch (Exception e) {
			logger.error("Error occurred : ", e);
		}
		return usappEntity;
	}

	public void appIndiaUpdate(ApplicationIndiaEntity appEntity, String emailId) {
		logger.info("appIndiaUpdate - Entry");
		ApplicationIndiaEntityMap appIndiaEntityMap;

		appIndiaEntityMap = new ModelMapper().map(appEntity, ApplicationIndiaEntityMap.class);
		appIndiaEntityMap.setAppCompletedDate(DateHelper.setCurrentDate(indiaDateFormat, indiaZoneId));
		appIndiaEntityMap.setEmailId(emailId);
		appIndiaEntityMap.setAppflag(true);

		appIndRepo.save(appIndiaEntityMap);
		OfferIndiaEntity offerIndiaEntity = offerIndRepo.findByEmailId(emailId);
		if (appEntity.getAppflag()) {
			offerIndiaEntity.setAppFormStatus("Completed");
		} else {
			offerIndiaEntity.setAppFormStatus("Not Completed");
		}
		offerIndiaEntity.setAppCreatedDate(DateHelper.setCurrentDate(indiaDateFormat, indiaZoneId));
		offerIndRepo.save(offerIndiaEntity);
		CandidateEntityMap candEntityMap = candRepo.findByEmailid(emailId);
		candEntityMap.setAppflag(true);
		candRepo.save(candEntityMap);
		logger.info("appIndiaUpdate - Exit");
	}

	public ApplicationUSEntityMap fetchUsApp(String emailId) {
		logger.info("fetchUsApp - Entry");
		if (!emailId.contains("@")) {
			return null;
		}
		logger.info("fetchUsApp - Entry");
		return appUSRepo.findByEmailid(emailId);
	}

	public ApplicationIndiaEntityMap fetchIndiaApp(String emailId) {
		logger.info("fetchIndiaApp - Entry");
		if (!emailId.contains("@")) {
			return null;
		}
		logger.info("fetchIndiaApp - Entry");
		return appIndRepo.findByEmailId(emailId);
	}

	public LoginFormResponse candidateLoginFailure() {
		LoginFormResponse loginFormResponse = new LoginFormResponse();
		loginFormResponse.setAuthenticationCode(HttpStatus.UNAUTHORIZED);
		return loginFormResponse;
	}

	public LoginFormResponse candidateLogin(String email, String password) throws IOException {
		LoginFormResponse loginFormResponse = new LoginFormResponse();
		CandidateEntityMap candidateEntityMap = candRepo.findByEmailid(email);
		logger.info(candidateEntityMap);
		if (null != candidateEntityMap && candidateEntityMap.getIncorrectLoginAttempt() > 4) {
			long timeDifference = Duration.between(candidateEntityMap.getAccountLockedTime(), LocalDateTime.now())
					.toMinutes();
			if (timeDifference > 60) {
				candidateEntityMap.setIncorrectLoginAttempt(ZERO);
				candRepo.save(candidateEntityMap);
				loginFormResponse = authenticateUser(candidateEntityMap, email, password, loginFormResponse);
			} else {
				loginFormResponse.setAuthenticationCode(HttpStatus.UNAUTHORIZED);
				loginFormResponse.setIncorrectLoginAttempt(candidateEntityMap.getIncorrectLoginAttempt());
				logger.info("Incorrect login attempt {}", candidateEntityMap.getIncorrectLoginAttempt());
				return loginFormResponse;
			}
		} else if (null != candidateEntityMap) {
			loginFormResponse = authenticateUser(candidateEntityMap, email, password, loginFormResponse);
			logger.info("In else part Incorrect login attempt {}", candidateEntityMap.getIncorrectLoginAttempt());
		} else {
			loginFormResponse.setAuthenticationCode(HttpStatus.UNAUTHORIZED);
		}
		return loginFormResponse;
	}

	private LoginFormResponse authenticateUser(CandidateEntityMap candidateEntityMap, String email, String password,
			LoginFormResponse loginFormResponse) throws IOException {
		if (!email.isEmpty() && isUserAuthenticated(candidateEntityMap, email, password)) {
			logger.info("candidateLogin - authentication sucessfull");
			candidateEntityMap = candRepo.findByEmailid(email);
			WorkflowSeqEntity workflowSeq = workFlowSeqRepo.findByDealId(candidateEntityMap.getDealId());

			if (candidateEntityMap.isFirstTimeLogin() == true) {
				LoginFormRequest request = new LoginFormRequest();
				request.setEmailID(candidateEntityMap.getEmailid());
				request.setPassword(candidateEntityMap.getPassword());
				saveDefaultPwd(request);
			}

			if (null != candidateEntityMap && !candidateEntityMap.isCandidateLoggedIn()) {
				String jwtToken = TokenGenerator.getJWTToken(email);
				loginFormResponse = new ModelMapper().map(candidateEntityMap, LoginFormResponse.class);
				loginFormResponse.setJwtToken(jwtToken);
				loginFormResponse.setAuthenticationCode(HttpStatus.OK);
				loginFormResponse.setFlowSeqOne(workflowSeq.getFlowSeqOne());
				loginFormResponse.setFlowSeqTwo(workflowSeq.getFlowSeqTwo());
				loginFormResponse.setFlowSeqThree(workflowSeq.getFlowSeqThree());
				loginFormResponse.setFlowSeqFour(workflowSeq.getFlowSeqFour());
				loginFormResponse.setFlowSeqFive(workflowSeq.getFlowSeqFive());
				loginFormResponse.setFlowSeqSix(workflowSeq.getFlowSeqSix());
				loginFormResponse.setFlowSeqSeven(workflowSeq.getFlowSeqSeven());
				loginFormResponse.setFlowSeqEight(workflowSeq.getFlowSeqEight());
				loginFormResponse.setFlowSeqNine(workflowSeq.getFlowSeqNine());
				loginFormResponse.setFlowSeqTen(workflowSeq.getFlowSeqTen());
				candidateEntityMap.setCandidateLoggedIn(true);
				candidateEntityMap.setLastLoginTime(LocalDateTime.now());
				candidateEntityMap.setGenToken(jwtToken.replace("Bearer ", ""));
				candRepo.save(candidateEntityMap);
			} else {
				loginFormResponse.setAuthenticationCode(HttpStatus.CONFLICT);
				loginFormResponse.setJwtToken(candidateEntityMap.getGenToken());
			}
		} else {
			loginFormResponse.setAuthenticationCode(HttpStatus.UNAUTHORIZED);
			candidateEntityMap = candRepo.findByEmailid(email);
			if (null != candidateEntityMap) {
				loginFormResponse.setIncorrectLoginAttempt(candidateEntityMap.getIncorrectLoginAttempt());
			}
			logger.info("candidateLogin - authentication failed");
		}

		return loginFormResponse;
	}

	public LoginFormResponse candidateLogout(String email, String expiredToken) {
		CandidateEntityMap candidateEntityMap = null;
		LoginFormResponse loginFormResponse = new LoginFormResponse();
		modelMapper = new ModelMapper();
		if (!email.isEmpty()) {
			logger.info("candidate - logout - entry");
			candidateEntityMap = candRepo.findByEmailid(email);
			if (null != candidateEntityMap) {
				candidateEntityMap.setCandidateLoggedIn(false); // update logout flag
				candidateEntityMap.setExpiredToken(expiredToken);
				candRepo.save(candidateEntityMap);
				loginFormResponse.setAuthenticationCode(HttpStatus.ACCEPTED);
			}
		} else {
			loginFormResponse.setAuthenticationCode(HttpStatus.NOT_ACCEPTABLE);
			logger.info("candidate - logout - exit");
		}
		return loginFormResponse;
	}

	private boolean isUserAuthenticated(CandidateEntityMap candidateEntityMap, String emailId, String password) {
		logger.info("candidateLogin - user authentication");
		boolean isAuthenticated = false;
		if (emailId != null) {
			if (password != null) {
				if (null != candidateEntityMap && candidateEntityMap.isFirstTimeLogin()) {
					isAuthenticated = password.equals(candidateEntityMap.getPassword());
				} else {
					isAuthenticated = encryptService.isPasswordMatching(password, candidateEntityMap.getPassword());
				}
				if (null != candidateEntityMap) {
					if (isAuthenticated) {
						candidateEntityMap.setIncorrectLoginAttempt(ZERO);
					} else {
						if (password.equals(candidateEntityMap.getPassword())) {
							candidateEntityMap.setPassword(encryptService.encryptPassword(password));
							candidateEntityMap.setFirstTimeLogin(false);
							candRepo.save(candidateEntityMap);
							return true;
						}
						candidateEntityMap.setIncorrectLoginAttempt(candidateEntityMap.getIncorrectLoginAttempt() + 1);
						if (candidateEntityMap.getIncorrectLoginAttempt() == 5) {
							candidateEntityMap.setAccountLockedTime(LocalDateTime.now());
						}
					}
					candRepo.save(candidateEntityMap);
				}
			} else {
				isAuthenticated = false;
			}
		} else {
			isAuthenticated = false;
		}
		return isAuthenticated;
	}

	public ByteArrayInputStream viewOfferFile(String emailId) {
		logger.info("viewOfferFile - Entry");
		CandidateEntityMap candEntityMap = candRepo.findByEmailid(emailId);
		ByteArrayInputStream bistream = null;
		if (candEntityMap != null)
			bistream = new ByteArrayInputStream(candEntityMap.getOfferFile());
		logger.info("viewOfferFile - Exit");
		return bistream;
	}

	public ByteArrayInputStream viewDocumentFile(String emailId) {
		logger.info("viewDocumentFile - Entry");
		CandidateEntityMap candEntityMap = candRepo.findByEmailid(emailId);
		ByteArrayInputStream bistream = null;
		if (candEntityMap != null)
			bistream = new ByteArrayInputStream(candEntityMap.getJoiningLetter());
		logger.info("viewDocumentFile - Exit");
		return bistream;
	}

	public String updateOfferStatus(String status, String email) {
		logger.info("updateOfferStatus - Entry");
		String message = null;
		CandidateEntityMap candEntityMap = candRepo.findByEmailid(email);
		if (null != candEntityMap && candEntityMap.getOfferStatus() != null) {
			switch (candEntityMap.getCountry()) {
			case INDIA:
				message = updateOfferIndia(email, status, candEntityMap);
				break;
			case US:
				message = updateOfferUS(candEntityMap, status);
				break;
			default:
				logger.info("Only India and US are supported");
			}
		} else {
			message = "Candidate not registered or offer doesn't exist";
		}
		logger.info("updateOfferStatus - Exit");
		return message;
	}

	private String updateOfferIndia(String email, String status, CandidateEntityMap candEntityMap) {
		String message = null;
		OfferIndiaEntity offerIndiaEntity = offerIndRepo.findByEmailId(email);
		if (candEntityMap.isCandidateLoggedIn()) {
			if (candEntityMap.getOfferStatus() != null) {
				if (null != offerIndiaEntity
						&& offerIndiaEntity.getOfferStatus().equalsIgnoreCase(OfferStatus.GENERATED.toString())) {
					message = updateOfferStatus(email, status, candEntityMap, offerIndiaEntity);
					logger.info("India offer status {}", status);
				} else {
					logger.info("India offer status already {}", offerIndiaEntity.getOfferStatus());
					message = "Offer_already_" + offerIndiaEntity.getOfferStatus();
				}
			} else {
				message = "offer doesn't exist";
			}
		} else {
			message = "Looks like knocking the back window";
		}
		return message;
	}

	private String updateOfferStatus(String email, String status, CandidateEntityMap candEntityMap,
			OfferIndiaEntity offerIndiaEntity) {
		String message = "";
		offerIndiaEntity.setOfferStatus(status);
		candEntityMap.setOfferStatus(status);
		candEntityMap.setOfferAcceptDate(DateHelper.setCurrentDate(indiaDateFormat, indiaZoneId));
		// offerIndiaEntity.setappLetterStatus(OfferStatus.NOT_GENERATED.toString());
		offerIndRepo.save(offerIndiaEntity);
		candRepo.save(candEntityMap);
		message = status;
		logger.info("India offer status {}", status);
		return message;
	}

	private String updateOfferUS(CandidateEntityMap candEntityMap, String status) {
		String message = null;
		try {
			if (candEntityMap.isCandidateLoggedIn()) {
				if (null != candEntityMap && candEntityMap.getOfferStatus().equals(OfferStatus.GENERATED.toString())) {
					if (status.equals(OfferStatus.ACCEPTED.toString())) {
						candEntityMap.setOfferFile(updateCandidateSignature(candEntityMap));
					}
					message = status;
					candEntityMap.setOfferStatus(status);
					candEntityMap.setOfferAcceptDate(DateHelper.setCurrentDate(usDateFormat, usZoneId));
				} else {
					logger.info("US offer status already {}", candEntityMap.getOfferStatus());
					message = "Offer_already_" + candEntityMap.getOfferStatus() + "_or__Candidate_not_logged_in";
				}
				candRepo.save(candEntityMap);
			} else {
				message = "Looks like knocking the back window";
			}
			logger.info("US offer status {}", status);
		} catch (IOException e) {
			logger.error(e);
		}
		return message;
	}

	public static byte[] updateCandidateSignature(CandidateEntityMap candEntity) throws IOException {
		logger.info("updateCandidateSignature - Entry");
		PDDocument document = PDDocument.load(candEntity.getOfferFile());
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String currentDate = DateTimeFormatter.ofPattern("MM-dd-yyyy").format(LocalDateTime.now());
		List<String> strList = new ArrayList<>();
		String strMiddleName;
		if (candEntity.getMiddlename() == null) {
			strMiddleName = " ";
		} else {
			strMiddleName = candEntity.getMiddlename();
		}
		logger.info("{} {}", candEntity.getFirstname(), candEntity.getLastname());
		logger.info(currentDate);
		strList.add(candEntity.getFirstname() + " " + strMiddleName + " " + candEntity.getLastname());
		strList.add(currentDate);
		logger.info("strList");
		String editedText = pdfStripper.getText(document)
				.replace("Signature:",
						"Signature: " + candEntity.getFirstname() + " " + strMiddleName + " "
								+ candEntity.getLastname())
				.replace("Printed Name:",
						"Printed Name: " + candEntity.getFirstname() + " " + strMiddleName + " "
								+ candEntity.getLastname())
				.replace("Date:", "Date: " + currentDate).replace("\n", "<br>").replace("\r", "<br>");
		byte[] offerUSBytes;
		String address2 = "";
		if (!candEntity.getOfferAddressTwo().isEmpty())
			address2 = candEntity.getOfferAddressTwo();
		else
			address2 = "";

		offerUSBytes = PDFGenerator.offerUSPDFGen(editedText, address2);
		document.close();
		return offerUSBytes;
	}

	public boolean isCandidateFound(String emailId) {
		boolean isEmailIdAlreadyExist = false;
		CandidateEntityMap candEntityMap = candRepo.findByEmailid(emailId);
		if (null != candEntityMap && null != candEntityMap.getEmailid()) {
			isEmailIdAlreadyExist = true;
		}
		return isEmailIdAlreadyExist;
	}

	public CandidateEntityMap mapCandidateDetails(CandidateEntity candidateEntity) {
		return new ModelMapper().map(candidateEntity, CandidateEntityMap.class);
	}

	public String checkUserDetails(String emailId, String curPassword, String newPassword) {
		logger.info("Change candidate password - Entry");
		logger.info(emailId);
		String message = null;
		try {
			CandidateEntityMap candidateEntityMap = candRepo.findByEmailid(emailId);
			PasswordHistoryEntityMap passwordHistoryEntityMap = pwdHistoryRepo.findByEmailId(emailId);
			logger.info(candidateEntityMap);
			logger.info(encryptService.isPasswordMatching(curPassword, candidateEntityMap.getPassword()));
			logger.info(curPassword);
			if (encryptService.isPasswordMatching(curPassword, candidateEntityMap.getPassword())) {
				if (null != candidateEntityMap) {

					if (candidateEntityMap.getPassword().length() == 8) {
						candidateEntityMap
								.setPassword(encryptService.encryptPassword(candidateEntityMap.getPassword()));
					}
					if (passwordHistoryEntityMap.getPassword1().length() == 8) {
						passwordHistoryEntityMap
								.setPassword1(encryptService.encryptPassword(passwordHistoryEntityMap.getPassword1()));
					}
					if (encryptService.isPasswordMatching(newPassword, candidateEntityMap.getPassword())
							|| encryptService.isPasswordMatching(newPassword, passwordHistoryEntityMap.getPassword1())
							|| encryptService.isPasswordMatching(newPassword, passwordHistoryEntityMap.getPassword2())
							|| encryptService.isPasswordMatching(newPassword,
									passwordHistoryEntityMap.getPassword3())) {
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
			} else {
				message = "Current Password is not matching!";
			}
		} catch (Exception exce) {
			message = "Candidate not registered";
			logger.error("exception occurred", exce);
		}
		logger.info("Change candidate password - Exit");
		return message;
	}
}