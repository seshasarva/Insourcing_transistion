package com.insourcing.services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.entity.OfferIndiaEntity;
import com.insourcing.exception.PortalException;
import com.insourcing.helper.DateHelper;
import com.insourcing.helper.ExcelReader;
import com.insourcing.helper.PDFGenerator;
import com.insourcing.model.AppointmentModel;
import com.insourcing.model.OfferModel;
import com.insourcing.model.OfferStatus;
import com.insourcing.model.RetentionModel;
import com.insourcing.repository.CandidateRepo;
import com.insourcing.repository.OfferIndiaRepo;

@Service
public class FileService {

	@Autowired
	public CandidateRepo candRepo;

	@Autowired
	public OfferIndiaRepo offerIndRepo;

	private static Logger logger = LogManager.getLogger(FileService.class);
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
		try {
			List<OfferIndiaEntity> offerList = ExcelReader.offerIndiaExcel(excelFile.getInputStream());
			logger.info(offerList);
			if (offerList.isEmpty()) {
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
					if (candEntity.getOfferStatus() == null) {
						offerIndRepo.save(offerModel);
						logger.info("candidate details : {}", candEntity);
						logger.info("country : {}", candEntity.getCountry());
						if (candEntity.getCountry().equalsIgnoreCase(INDIA)) {
							logger.info("Calling offerLetterIndia");
							byte[] bytes = offerLetterIndia(offerModel, templateFile);
							if (null != bytes) {
								uploadFile(bytes, email);
								offerMessage = "Offer Generated successfully";
								logger.info("Offer generated sucessfully for {}", email);
							} else {
								throw new PortalException("Error in generating PDF");
							}
						}
					} else {
						logger.info("Offer already {}", candEntity.getOfferStatus());
						offerMessage = "Offer already - " + candEntity.getOfferStatus();
					}
				}

			}
		} catch (Exception ex) {
			offerMessage = "Please try again";
			logger.error(ex);
		}
		logger.info("generateIndiaOfferLetter : Exit");
		return offerMessage;
	}

	public byte[] previewIndiaOffer(OfferIndiaEntity list, MultipartFile templateFile) throws IOException {
		logger.info("previewIndiaOffer - Entry");
		logger.info("Offer India Entity List {}", list);
		logger.info(TEMPLATE_FILE, templateFile.getContentType());
		logger.info("previewIndiaOffer - Exit");
		return offerLetterIndia(list, templateFile);
	}

	public byte[] previewUSOffer(OfferModel list, MultipartFile templateFile) throws IOException {
		logger.info("previewUSOffer - Entry");
		logger.info("Offer India Entity List {}", list);
		logger.info(TEMPLATE_FILE, templateFile.getContentType());
		logger.info("previewUSOffer - Exit");
		return offerLetter(list, templateFile);
	}

	public String generateUSOfferLetter(MultipartFile excelFile, MultipartFile templateFile)
			throws IOException, ParseException {
		logger.info("generateUSOfferLetter - Entry");
		logger.info("excel file {}", excelFile.getContentType());
		logger.info(TEMPLATE_FILE, templateFile.getContentType());
		List<OfferModel> offerList = ExcelReader.offerUsExcel(excelFile.getInputStream());
		String offerStatus = null;
		if (offerList.isEmpty()) {
			offerStatus = EXCEED_CANDIDATES_COUNT;
		} else {
			for (OfferModel offerModel : offerList) {
				if (offerModel.getEmailId() == null) {
					throw new NullPointerException("email id is missing");
				}

				logger.info(offerModel.toString());
				byte[] bytes = offerLetter(offerModel, templateFile);
				uploadFile(bytes, offerModel.getEmailId());
				offerStatus = "Offer Letter Generated Successfully";
				CandidateEntityMap candEntity = candRepo.findByEmailid(offerModel.getEmailId());
				// candEntity = new ModelMapper().map(offerModel, CandidateEntityMap.class);
				candEntity.setOfferDate(offerModel.getDate());
				candEntity.setRole(offerModel.getRole());
				candEntity.setReportingTo(offerModel.getReportingTo());
				candEntity.setReportAddress(offerModel.getReportingAddress());
				candEntity.setJoinDate(offerModel.getJoinDate());
				candEntity.setBase(offerModel.getBase());
				candEntity.setExemptStatus(offerModel.getExemptionStatus());
				candEntity.setSeverance(offerModel.getSeverance());
				candEntity.setBonus(offerModel.getBonus());
				candRepo.save(candEntity);
			}

		}
		logger.info(offerStatus);
		logger.info("generateUSOfferLetter - Exit");
		return offerStatus;
	}

	public byte[] previewRetention(RetentionModel list, MultipartFile templateFile) throws IOException, ParseException {
		logger.info("previewRetention - Entry");
		logger.info("Offer India Entity List {}", list);
		logger.info(TEMPLATE_FILE, templateFile.getContentType());
		logger.info("previewRetention - Exit");
		return retentionLetter(list, templateFile);
	}

	public String generateRetentionLetters(MultipartFile excelFile, MultipartFile templateFile)
			throws IOException, ParseException {
		logger.info("generateUSOfferLetter - Entry");
		logger.info("excel file {}", excelFile.getContentType());
		logger.info(TEMPLATE_FILE, templateFile.getContentType());
		List<RetentionModel> offerList = ExcelReader.excelToRetentionModel(excelFile.getInputStream());
		String message = "";
		if (offerList.isEmpty()) {
			message = EXCEED_CANDIDATES_COUNT;
		} else {
			for (RetentionModel retentionModel : offerList) {
				logger.info("Retention Model {}", retentionModel);
				if (retentionModel.getEmailId() == null) {
					throw new NullPointerException(EMAIL_ID_MISSING);
				}
				byte[] bytes = retentionLetter(retentionModel, templateFile);
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
			}
		}
		return message;
	}

	public byte[] previewAppointment(AppointmentModel list, MultipartFile templateFile) throws IOException {
		return appointmentLetter(list, templateFile);
	}

	public String generateAppointmentLetter(MultipartFile excelFile, MultipartFile templateFile)
			throws IOException, ParseException {
		List<AppointmentModel> offerList = ExcelReader.excelToAppoinmentModel(excelFile.getInputStream());
		logger.info(offerList);
		String message = "";
		if (offerList.isEmpty()) {
			message = EXCEED_CANDIDATES_COUNT;
		} else {
			for (AppointmentModel appointmentModel : offerList) {
				if (appointmentModel.getEmailId() == null) {
					throw new NullPointerException(EMAIL_ID_MISSING);
				}
				byte[] bytes = appointmentLetter(appointmentModel, templateFile);
				uploadAppointmentFile(bytes, appointmentModel.getEmailId());
			}
			message = "Successfully Uploaded Appointment letter";
		}
		return message;
	}

	private byte[] offerLetterIndia(OfferIndiaEntity offerModel, MultipartFile templateFile) throws IOException {
		logger.info("offerLetterIndia : Entry");
		logger.info("offerModel : {}", offerModel.toString());
		PDFTextStripper pdfStripper = new PDFTextStripper();
		PDDocument document = PDDocument.load(templateFile.getBytes());
		String strJoiningDate = new SimpleDateFormat(indiaDateFormat).format(offerModel.getJoiningDate());
		String currentDate = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
		String middleName = null;
		if (offerModel.getMiddlename() != null) {
			middleName = offerModel.getMiddlename();
		} else {
			middleName = "";
		}
//		
		String boldText = pdfStripper.getText(document);

		String editedText = boldText.replace("#Title", offerModel.getTitle())
				.replace("#FirstName", offerModel.getFirstname()).replace("#MiddleName", middleName)
				.replace("#DateOfOffer", currentDate).replace("#LastName", offerModel.getLastname())
				.replace("#RefID", offerModel.getRefId()).replace("#Department", offerModel.getDepartment())
				.replace("#EmailID", offerModel.getEmailId()).replace("#Telephone", offerModel.getTelNo())
				.replace("#PresentAddress", offerModel.getAdd1()).replace("#City", offerModel.getAdd2())
				.replace("#StateRegionProvince", offerModel.getAdd3())
				.replace("#DESIGNATION", offerModel.getDesignation()).replace("#GRADE", offerModel.getGrade())
				.replace("#POSTINGBRANCH", offerModel.getPostingBranch())
				.replace("#CANDIDATEROLE", offerModel.getCandRole())
				.replace("#SUPERVISORROLE", offerModel.getSuperRole())
				.replace("#RelevantExperience", offerModel.getRelExp())
				.replace("#BASIC_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBasic()[0])))
				.replace("#MVA_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getMva()[0])))
				.replace("#QVA_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getQva()[0])))
				.replace("#CITY_ALLOWANCE_M",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCityAllowance()[0])))
				.replace("#BOB_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBob()[0])))
				.replace("#HRA_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHra()[0])))
				.replace("#LTA_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getLta()[0])))
				.replace("#FOODCOUPONS_M",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFoodCoupons()[0])))
				.replace("#CAR_ALLOWANCE_M",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCarAllo()[0])))
				.replace("#VEHICLE_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getVehicle()[0])))
				.replace("#FUEL_ALLOWANCE_M",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFuelAllo()[0])))
				.replace("#PERALLOWANCE_M",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPerAllo()[0])))
				.replace("#PF_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPf()[0])))
				.replace("#GRATUITY_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getGratuity()[0])))
				.replace("#ANNUAL_RETIRALS_M",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getAnnualRetirals()[0])))
				.replace("#CTC_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCtc()[0])))
				.replace("#BASIC_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBasic()[1])))
				.replace("#MVA_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getMva()[1])))
				.replace("#QVA_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getQva()[1])))
				.replace("#CITY_ALLOWANCE_A",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCityAllowance()[1])))
				.replace("#HRA_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHra()[1])))
				.replace("#LTA_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getLta()[1])))
				.replace("#FOODCOUPONS_A",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFoodCoupons()[1])))
				.replace("#CAR_ALLOWANCE_A",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCarAllo()[1])))
				.replace("#VEHICLE_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getVehicle()[1])))
				.replace("#FUEL_ALLOWANCE_A",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFuelAllo()[1])))
				.replace("#PERALLOWANCE_A",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPerAllo()[1])))
				.replace("#BOB_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBob()[1])))
				.replace("#HIS_III", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHis3())))
				.replace("#PF_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPf()[1])))
				.replace("#GRATUITY_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getGratuity()[1])))
				.replace("#ANNUAL_RETIRALS_A",
						DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getAnnualRetirals()[1])))
				.replace("#RET_INC_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getRetInc())))
				.replace("#CTC_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCtc()[1])))
				.replace("#PROBATION_PERIOD", offerModel.getProbPeriod())
				.replace("#PROBATION_UNIT", offerModel.getProbUnit()).replace("#DATE_OF_JOINING", strJoiningDate)
				.replace("#JOINING_BRANCH", offerModel.getJoiningBranch())
				.replace("#EXGRATIA", offerModel.getExgratia()).replace("\n", "<br>").replace("\r", "<br>");
		// .replace("\n", "<br>").replace("\r", "<br>");
		logger.info(editedText);
		document.close();
		byte[] offerIndiaBytes;
		offerIndiaBytes = PDFGenerator.offerIndiaPDFGen(offerModel, editedText);
		return offerIndiaBytes;
	}

	public byte[] offerLetter(OfferModel offerModel, MultipartFile templateFile) throws IOException {
		logger.info(templateFile.getOriginalFilename());
		PDDocument document = PDDocument.load(templateFile.getBytes());
		PDFTextStripper pdfStripper = new PDFTextStripper();
		DateFormat dateFormat = new SimpleDateFormat(usDateFormat);
		String strJoiningDate = dateFormat.format(offerModel.getJoinDate());
		String strResponseDate = dateFormat.format(offerModel.getOfferResponseDate());
		String strDate = dateFormat.format(offerModel.getDate());
		logger.info(strJoiningDate);
		// String strBase = String.valueOf((int) offerModel.getBase());
		// String strBonus = String.valueOf((int) offerModel.getBonus());
		// String strSeverance = String.valueOf((int) offerModel.getSeverance());

		DecimalFormat format = new DecimalFormat("$##,##,###");
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);

		String editedText = pdfStripper.getText(document).replace("#DATE", strDate)
				.replace("#Name", offerModel.getFirstName() + " " + offerModel.getLastName())
				.replace("#Address", offerModel.getAddress()).replace("#City_St_Zip", offerModel.getCity())
				.replace("#FirstName", offerModel.getFirstName()).replace("#Role", offerModel.getRole())
				.replace("#RepAdd", offerModel.getReportingAddress()).replace("#JoinDate", strJoiningDate)
				.replace("#Exempt", offerModel.getExemptionStatus())
				.replace("#BaseSal", format.format(Double.valueOf(offerModel.getBase())))
				.replace("#OfferResDate", strResponseDate).replace("#RepTo", offerModel.getReportingTo())
				.replace("#Bon", format.format(Double.valueOf(offerModel.getBonus())))
				.replace("#SevDue", format.format(Double.valueOf(offerModel.getSeverance()))).replace("#Signature", "")
				.replace("#PrintedName", "").replace("\n", "<br>").replace("\r", " ");

		logger.info(editedText);
		byte[] offerUSBytes = null;
		document.close();
		offerUSBytes = PDFGenerator.offerUSPDFGen(editedText);
		return offerUSBytes;
	}

	public byte[] retentionLetter(RetentionModel retentionModel, MultipartFile templateFile) throws IOException {
		PDDocument document = PDDocument.load(templateFile.getBytes());
		PDFTextStripper pdfStripper = new PDFTextStripper();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");

		DecimalFormat format = new DecimalFormat("$##,##,###");
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);
		String editedText = pdfStripper.getText(document).replace("#FirstName", retentionModel.getFirstName())
				.replace("#Name", retentionModel.getFirstName() + " " + retentionModel.getLastName())
				.replace("#LastName", retentionModel.getLastName()).replace("#Address", retentionModel.getAddress())
				// .replace("#Address2", retentionModel.getAddress2())
				.replace("#CityStateZipCode", retentionModel.getCityStateZip())
				.replace("#Bonus$", format.format(Double.valueOf(retentionModel.getBonus())))
				.replace("#WorkState", retentionModel.getWorkState()).replace("#TataConsultancyServicesLimited#", " ")
				.replace("379 Thornall St. Edison NJ 08837", " ").replace("Tel 732 590 2600", " ")
				.replace("Fax 732 603 2409", " ").replace("www.tcs.com", " ")
				.replace("#Date", dateFormat.format(retentionModel.getDate())).replace("\n", "<br>")
				.replace("\r", "<br>");
		document.close();
		byte[] retentionBytes;
		retentionBytes = PDFGenerator.retentionPDFGen(editedText);
		return retentionBytes;
	}

	public byte[] appointmentLetter(AppointmentModel appointmentModel, MultipartFile templateFile) throws IOException {
		PDDocument document = PDDocument.load(templateFile.getBytes());
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String currentDate = DateTimeFormatter.ofPattern(indiaDateFormat).format(LocalDateTime.now());
		String strEmpNo = String.valueOf((int) appointmentModel.getEmpNumber());
		DateFormat dateFormat = new SimpleDateFormat(indiaDateFormat);
		String strJoiningDate = dateFormat.format(appointmentModel.getJoiningDate());
		String middleName = null;
		if (appointmentModel.getMiddleName() != null) {
			middleName = appointmentModel.getMiddleName();
		} else {
			middleName = "";
		}
		String editedText = pdfStripper.getText(document).replace("#firstName", appointmentModel.getFirstName())
				.replace("#middleName", middleName).replace("#lastName", appointmentModel.getLastName())
				.replace("#title", appointmentModel.getTitle())
				.replace("#joiningBranch", appointmentModel.getJoiningBranch()).replace("#joiningDate", strJoiningDate)
				.replace("#offerDate", currentDate).replace("#grade", appointmentModel.getGrade())
				.replace("#empNo", strEmpNo).replace("#designation", appointmentModel.getDesignation())
				.replace("#ApplicantId", appointmentModel.getRefId()).replace("\n", "<br>").replace("\r", " ");
		document.close();
		byte[] appointmentBytes;
		appointmentBytes = PDFGenerator.appointmentPDFGen(editedText);
		return appointmentBytes;
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
		candEntity.setJoiningLetter(arrayData);
		if (candEntity.getCountry().equalsIgnoreCase(INDIA)) {
			OfferIndiaEntity offerIndiaEntity = offerIndRepo.findByEmailId(candEntity.getEmailid());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(indiaDateFormat);
			LocalDateTime now = LocalDateTime.now();
			String currentDate = dtf.format(now);
			Date cntDate = new SimpleDateFormat(indiaDateFormat).parse(currentDate);
			candEntity.setJoiningLetterDate(cntDate);
			candEntity.setJoinerStatus(true);
			offerIndiaEntity.setAppLetterStatus(OfferStatus.GENERATED.toString());
			offerIndRepo.save(offerIndiaEntity);
		} else {
			Date currentOfferDate = DateHelper.setCurrentDate(usDateFormat, usZoneId);
			candEntity.setJoiningLetterDate(currentOfferDate);
			candEntity.setJoinerStatus(true);
		}
		candRepo.save(candEntity);
	}

}