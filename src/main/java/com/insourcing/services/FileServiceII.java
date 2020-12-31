package com.insourcing.services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.insourcing.config.CommonConstants;
import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.entity.OfferIndiaEntity;
import com.insourcing.exception.PortalException;
import com.insourcing.helper.DateHelper;
import com.insourcing.helper.ExcelReader;
import com.insourcing.helper.ReplaceDoc;
import com.insourcing.model.AppointmentModel;
import com.insourcing.model.OfferModel;
import com.insourcing.model.OfferStatus;
import com.insourcing.model.RetentionModel;
import com.insourcing.repository.CandidateRepo;
import com.insourcing.repository.OfferIndiaRepo;
import com.insourcing.validator.EntityValidator;

@Service
public class FileServiceII {

	@Autowired
	public CandidateRepo candRepo;
	@Autowired
	public OfferIndiaRepo offerIndRepo;
	@Autowired
	public EntityValidator validator;

	private static Logger logger = LogManager.getLogger(FileServiceII.class);
	private static final String INDIA = "India";
	private static final String EXCEED_CANDIDATES_COUNT = "Please upload less than 2000 candidates";
	private static final String EMAIL_ID_MISSING = "Missing email id";
	private static final String TEMPLATE_FILE = "template file";

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

	public String generateIndiaOfferLetter(MultipartFile excelFile, MultipartFile templateFile)
			throws ParseException, IOException {
		logger.info("generateIndiaOfferLetter : Entry");
		String email = "";
		String offerMessage = null;
		byte[] bytes = null;
		try {
			List<OfferIndiaEntity> offerList = ExcelReader.offerIndiaExcel(excelFile.getInputStream());
			logger.info(offerList);
			if (offerList.isEmpty()) {
				offerMessage = EXCEED_CANDIDATES_COUNT;
				logger.info(EXCEED_CANDIDATES_COUNT);
				throw new PortalException(EXCEED_CANDIDATES_COUNT);
			} else {
				for (OfferIndiaEntity offerModel : offerList) {
					if (!offerModel.getEmailId().isEmpty()) {
						email = offerModel.getEmailId();
					} else {
						offerMessage = "Email Id not found";
						logger.error("Email doesn't exist ", email);
						continue;
					}
					CandidateEntityMap candEntity = candRepo.findByEmailid(email);
					logger.info(candEntity);
					// if (candEntity.getOfferStatus() == null) {
					offerIndRepo.save(offerModel);
					logger.info("candidate details : {}", candEntity);
					logger.info("country : {}", candEntity.getCountry());
					if (candEntity.getCountry().equalsIgnoreCase(INDIA)) {
						logger.info("Calling offerLetterIndia");
//						if (validator.isTemplateValid(templateFile))
//							bytes = ReplacePdf.offerLetterIndia(offerModel, templateFile);
//						else if (validator.isDocTemplateValid(templateFile))
						bytes = ReplaceDoc.offerLetterIndia(offerModel, templateFile);
						if (null != bytes) {
							uploadFile(bytes, email);
							offerMessage = "Offer Generated successfully";
							logger.info("Offer generated sucessfully for {}", email);
						} else {
							offerMessage = "Error in generating PDF";
							throw new PortalException("Error in generating PDF");
						}
					} else {
						offerMessage = "Please upload India candidate!";
					}
					// } else {
					// logger.info("Offer already {}", candEntity.getOfferStatus());
					// offerMessage = "Offer already - " + candEntity.getOfferStatus();
					// }
				}
			}
		} catch (Exception ex) {
			offerMessage = "Please try again";
			logger.error(ex);
		}
		logger.info("generateIndiaOfferLetter : Exit");
		return offerMessage;
	}

	public byte[] previewIndiaOffer(OfferIndiaEntity list, MultipartFile templateFile)
			throws IOException, IllegalAccessException {
		logger.info("previewIndiaOffer - Entry");
		logger.info("Offer India Entity List {}", list);
		logger.info(TEMPLATE_FILE, templateFile.getContentType());
		byte[] bytes = null;
//		if (validator.isTemplateValid(templateFile))
//			bytes = ReplacePdf.offerLetterIndia(list, templateFile);
//		else if (validator.isDocTemplateValid(templateFile))
		bytes = ReplaceDoc.offerLetterIndia(list, templateFile);
		logger.info("previewIndiaOffer - Exit");
		return bytes;
	}

	public byte[] previewUSOffer(OfferModel list, MultipartFile templateFile)
			throws IOException, IllegalAccessException {
		logger.info("previewUSOffer - Entry");
		logger.info("Offer India Entity List {}", list);
		logger.info(TEMPLATE_FILE, templateFile.getContentType());
		byte[] bytes = null;
		if (list.getAddress2() == null) {
			list.setAddress2("");
		}
//		if (validator.isTemplateValid(templateFile))
//			bytes = ReplacePdf.offerLetterUs(list, templateFile);
//		else 
//		if (validator.isDocTemplateValid(templateFile))
		bytes = ReplaceDoc.offerLetterUs(list, templateFile);
		logger.info("previewUsOffer - Exit");
		return bytes;
	}

	public String generateUSOfferLetter(MultipartFile excelFile, MultipartFile templateFile)
			throws IOException, ParseException, PortalException, IllegalAccessException {
		logger.info("generateUSOfferLetter - Entry");
		logger.info("excel file {}", excelFile.getContentType());
		logger.info(TEMPLATE_FILE, templateFile.getContentType());
		List<OfferModel> offerList = ExcelReader.offerUsExcel(excelFile.getInputStream());
		String offerMessage = null;
		byte[] bytes = null;
		if (offerList.isEmpty()) {
			offerMessage = EXCEED_CANDIDATES_COUNT;
		} else {
			for (OfferModel offerModel : offerList) {
				if (offerModel.getEmailId() == null) {
					throw new NullPointerException("email id is missing");
				}
				CandidateEntityMap candEntity = candRepo.findByEmailid(offerModel.getEmailId());
				// if (candEntity.getOfferStatus() == null) {
				logger.info("candidate details : {}", candEntity);
				logger.info("country : {}", candEntity.getCountry());
				if (candEntity.getCountry().equalsIgnoreCase(CommonConstants.COUNTRY_US)) {
					logger.info("Calling offerLetterUS");
					logger.info(offerModel.toString());
//						if (validator.isTemplateValid(templateFile))
//							bytes = ReplacePdf.offerLetterUs(offerModel, templateFile);
//						else 
//						if (validator.isDocTemplateValid(templateFile))
					bytes = ReplaceDoc.offerLetterUs(offerModel, templateFile);
					logger.info("previewIndiaOffer - Exit");
					if (null != bytes) {
						uploadFile(bytes, offerModel.getEmailId());
						offerMessage = "Offer Letter Generated Successfully";
					} else {
						offerMessage = "Error in generating PDF";
						throw new PortalException("Error in generating PDF");
					}
					CandidateEntityMap candEntityOne = candRepo.findByEmailid(offerModel.getEmailId());
					// candEntity = new ModelMapper().map(offerModel, CandidateEntityMap.class);
					candEntityOne.setOfferDate(offerModel.getDate());
					candEntityOne.setRole(offerModel.getRole());
					candEntityOne.setReportingTo(offerModel.getReportingTo());
					candEntityOne.setReportAddress(offerModel.getReportingAddress());
					candEntityOne.setJoinDate(offerModel.getJoinDate());
					candEntityOne.setBase(offerModel.getBase());
					candEntityOne.setExemptStatus(offerModel.getExemptionStatus());
					candEntityOne.setSeverance(offerModel.getSeverance());
					candEntityOne.setBonus(offerModel.getBonus());
					candRepo.save(candEntityOne);
				} else {
					offerMessage = "Please upload US candidate!";
				}
				// } else {
				// logger.info("Offer already {}", candEntity.getOfferStatus());
				// offerMessage = "Offer already - " + candEntity.getOfferStatus();
				// }
			}

		}
		logger.info(offerMessage);
		logger.info("generateUSOfferLetter - Exit");
		return offerMessage;
	}

	public byte[] previewRetention(RetentionModel list, MultipartFile templateFile)
			throws IOException, ParseException, IllegalAccessException {
		logger.info("previewRetention - Entry");
		logger.info("Offer India Entity List {}", list);
		logger.info(TEMPLATE_FILE, templateFile.getContentType());
		byte[] bytes = null;
//		if (validator.isDocTemplateValid(templateFile))
		bytes = ReplaceDoc.retentionLetter(list, templateFile);
		logger.info("previewRetention - Exit");
		return bytes;
	}

	public String generateRetentionLetters(MultipartFile excelFile, MultipartFile templateFile)
			throws IOException, ParseException, IllegalAccessException {
		logger.info("generateUSOfferLetter - Entry");
		logger.info("excel file {}", excelFile.getContentType());
		logger.info(TEMPLATE_FILE, templateFile.getContentType());
		List<RetentionModel> offerList = ExcelReader.excelToRetentionModel(excelFile.getInputStream());
		String message = "";
		if (offerList.isEmpty()) {
			message = EXCEED_CANDIDATES_COUNT;
		} else {
			for (RetentionModel retentionModel : offerList) {
				CandidateEntityMap candEntityOne = candRepo.findByEmailid(retentionModel.getEmailId());
				logger.info("Retention Model {}", retentionModel);
				if (retentionModel.getEmailId() == null) {
					throw new NullPointerException(EMAIL_ID_MISSING);
				}
				// if (!candEntityOne.isJoinerStatus()) {
					byte[] bytes = null;
//					if (validator.isDocTemplateValid(templateFile))
					bytes = ReplaceDoc.retentionLetter(retentionModel, templateFile);
					uploadAppointmentFile(bytes, retentionModel.getEmailId());
					message = "Successfully Uploaded Retention letter";
					String emailId = retentionModel.getEmailId();
					CandidateEntityMap candEntity = candRepo.findByEmailid(emailId);
					candEntity.setRetDate(retentionModel.getDate());
					candEntity.setRetBonusQuant(retentionModel.getBonus());
					if (retentionModel.getBonus() != 0)
						candEntity.setRetBonus("Yes");
					else
						candEntity.setRetBonus("No");
					candEntity.setWorkState(retentionModel.getWorkState());
					candRepo.save(candEntity);
				// } else {
				// message = "Retention Letter already Generated";
				// }
			}
		}
		return message;
	}

	public byte[] previewAppointment(AppointmentModel list, MultipartFile templateFile)
			throws IOException, IllegalAccessException {
		byte[] bytes = null;
		if (validator.isDocTemplateValid(templateFile))
			bytes = ReplaceDoc.appointmentLetter(list, templateFile);
		return bytes;
	}

	public String generateAppointmentLetter(MultipartFile excelFile, MultipartFile templateFile)
			throws IOException, ParseException, IllegalAccessException {
		List<AppointmentModel> offerList = ExcelReader.excelToAppoinmentModel(excelFile.getInputStream());
		logger.info(offerList);
		String message = "";
		if (offerList.isEmpty()) {
			message = EXCEED_CANDIDATES_COUNT;
		} else {
			for (AppointmentModel appointmentModel : offerList) {
				CandidateEntityMap candEntityOne = candRepo.findByEmailid(appointmentModel.getEmailId());
				if (appointmentModel.getEmailId() == null) {
					throw new NullPointerException(EMAIL_ID_MISSING);
				}
//				if (!candEntityOne.isJoinerStatus()) {
					byte[] bytes = null;
					if (validator.isDocTemplateValid(templateFile))
						bytes = ReplaceDoc.appointmentLetter(appointmentModel, templateFile);
					uploadAppointmentFile(bytes, appointmentModel.getEmailId());

					message = "Successfully Uploaded Appointment letter";
//				} else {
//					message = "Appointment Letter already Generated";
//				}
			}
		}
		return message;
	}

	public void uploadFile(byte[] arrayData, String emailId) throws ParseException {
		logger.info("uploadFile : Entry");
		logger.info(emailId);
		CandidateEntityMap candEntity = candRepo.findByEmailid(emailId);
		logger.info(candEntity);
		candEntity.setOfferStatus(OfferStatus.GENERATED.toString());
		candEntity.setOfferFile(arrayData);
		logger.info("file byte array ", arrayData);
		if (candEntity.getCountry().equalsIgnoreCase(INDIA)) {
			logger.info("inside country INDIA");
			OfferIndiaEntity offerIndiaEntity = offerIndRepo.findByEmailId(candEntity.getEmailid());
			offerIndiaEntity.setOfferStatus(OfferStatus.GENERATED.toString());
			Date cntDate = new SimpleDateFormat(indiaDateFormat)
					.parse(DateTimeFormatter.ofPattern(indiaDateFormat).format(LocalDateTime.now()));
			candEntity.setOfferGenDate(cntDate);
			candEntity.setOfferRelDate(cntDate);
			// candEntity.setOfferStatus(OfferStatus.GENERATED.toString());
			offerIndRepo.save(offerIndiaEntity);
		} else {
			logger.info("inside else part");
			Date currentOfferDate = DateHelper.setCurrentDate(usDateFormat, usZoneId);
			candEntity.setOfferGenDate(currentOfferDate);
			candEntity.setOfferRelDate(currentOfferDate);
			// candEntity.setOfferStatus(OfferStatus.GENERATED.toString());
			logger.info("exit else part");
		}
		candRepo.save(candEntity);
		logger.info("uploadFile : Exit");
	}

	public void uploadAppointmentFile(byte[] arrayData, String emailId) throws ParseException {
		CandidateEntityMap candEntity = candRepo.findByEmailid(emailId);
		logger.info(candEntity);
		candEntity.setJoiningLetter(arrayData);
		if (candEntity.getCountry().equalsIgnoreCase(INDIA)) {
			OfferIndiaEntity offerIndiaEntity = offerIndRepo.findByEmailId(candEntity.getEmailid());
			logger.info(offerIndiaEntity);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(indiaDateFormat);
			LocalDateTime now = LocalDateTime.now();
			String currentDate = dtf.format(now);
			Date cntDate = new SimpleDateFormat(indiaDateFormat).parse(currentDate);
			candEntity.setJoiningLetterDate(cntDate);
			candEntity.setJoinerStatus(true);
			offerIndiaEntity.setAppLetterStatus(OfferStatus.GENERATED.toString());
			offerIndRepo.save(offerIndiaEntity);
			logger.info("status saved in offer India");
		} else {
			Date currentOfferDate = DateHelper.setCurrentDate(usDateFormat, usZoneId);
			candEntity.setJoiningLetterDate(currentOfferDate);
			candEntity.setJoinerStatus(true);
		}
		candRepo.save(candEntity);
	}
}