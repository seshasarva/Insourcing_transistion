package com.insourcing.helper;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.aspose.words.Document;
import com.aspose.words.FindReplaceDirection;
import com.aspose.words.FindReplaceOptions;
import com.aspose.words.SaveFormat;
import com.insourcing.entity.OfferIndiaEntity;
import com.insourcing.model.AppointmentModel;
import com.insourcing.model.OfferModel;
import com.insourcing.model.RetentionModel;

public class ReplaceDoc {

	private static Logger logger = LogManager.getLogger(ReplaceDoc.class);

	@Value("${insource.app.india.date.format}")
	private String indiaDateFormat;

	@Value("${insource.app.india.zone.id}")
	private String indiaZoneId;

	@Value("${insource.app.us.date.format}")
	private String usDateFormat;

	@Value("${insource.app.us.zone.id}")
	private String usZoneId;

	public static byte[] offerLetterIndia(OfferIndiaEntity offerModel, MultipartFile templateFile)
			throws IOException, IllegalAccessException {
		logger.info("offerLetterIndia : Entry");
		logger.info("offerModel : {}", offerModel.toString());
		Document doc = null;
		String strJoiningDate = new SimpleDateFormat("dd/MM/yyyy").format(offerModel.getJoiningDate());
		String middleName = null;
		byte[] offerIndiaBytes = null;
		if (offerModel.getMiddlename() != null) {
			middleName = offerModel.getMiddlename();
		} else {
			middleName = "";
		}
		try {
			OutputStream out = new FileOutputStream("out.docx");
			out.write(templateFile.getBytes());
			out.close();

			doc = new Document("out.docx");
			logger.info("Document read");

			doc.getRange().replace("#Title", offerModel.getTitle());
			doc.getRange().replace("#FirstName", offerModel.getFirstname());
			doc.getRange().replace("#MiddleName", middleName);
			doc.getRange().replace("#BASIC_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBasic()[0])));
			doc.getRange().replace("#MVA_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getMva()[0])));
			doc.getRange().replace("#QVA_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getQva()[0])));
			doc.getRange().replace("#CITY_ALLOWANCE_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCityAllowance()[0])));
			doc.getRange().replace("#BOB_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBob()[0])));
			doc.getRange().replace("#HRA_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHra()[0])));
			doc.getRange().replace("#LTA_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getLta()[0])));
			doc.getRange().replace("#FOODCOUPONS_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFoodCoupons()[0])));
			doc.getRange().replace("#CAR_ALLOWANCE_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCarAllo()[0])));
			doc.getRange().replace("#VEHICLE_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getVehicle()[0])));
			doc.getRange().replace("#FUEL_ALLOWANCE_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFuelAllo()[0])));
			doc.getRange().replace("#PERALLOWANCE_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPerAllo()[0])));
			doc.getRange().replace("#PF_M", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPf()[0])));
			doc.getRange().replace("#GRATUITY_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getGratuity()[0])));
			doc.getRange().replace("#ANNUAL_RETIRALS_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getAnnualRetirals()[0])));
			doc.getRange().replace("#CTC_M",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCtc()[0])));
			doc.getRange().replace("#BASIC_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBasic()[1])));
			doc.getRange().replace("#MVA_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getMva()[1])));
			doc.getRange().replace("#QVA_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getQva()[1])));
			doc.getRange().replace("#CITY_ALLOWANCE_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCityAllowance()[1])));
			doc.getRange().replace("#HRA_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHra()[1])));
			doc.getRange().replace("#LTA_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getLta()[1])));
			doc.getRange().replace("#FOODCOUPONS_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFoodCoupons()[1])));
			doc.getRange().replace("#CAR_ALLOWANCE_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCarAllo()[1])));
			doc.getRange().replace("#VEHICLE_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getVehicle()[1])));
			doc.getRange().replace("#FUEL_ALLOWANCE_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFuelAllo()[1])));
			doc.getRange().replace("#PERALLOWANCE_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPerAllo()[1])));
			doc.getRange().replace("#BOB_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBob()[1])));
			doc.getRange().replace("#HIS_III",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHis3())));
			doc.getRange().replace("#PF_A", DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPf()[1])));
			doc.getRange().replace("#GRATUITY_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getGratuity()[1])));
			doc.getRange().replace("#ANNUAL_RETIRALS_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getAnnualRetirals()[1])));
			doc.getRange().replace("#RET_INC_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getRetInc())));
			doc.getRange().replace("#CTC_A",
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCtc()[1])));
			doc.getRange().replace("#PROBATION_PERIOD", offerModel.getProbPeriod());
			doc.getRange().replace("#PROBATION_UNIT", offerModel.getProbUnit());
			doc.getRange().replace("#DATE_OF_JOINING", strJoiningDate);
			doc.getRange().replace("#JOINING_BRANCH", offerModel.getJoiningBranch());

			doc.getRange().replace("#EXGRATIA", offerModel.getExgratia(),
					new FindReplaceOptions(FindReplaceDirection.FORWARD));

			doc.save("India Offer.pdf");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			doc.save(byteArrayOutputStream, SaveFormat.PDF);
			offerIndiaBytes = byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return offerIndiaBytes;
	}

	public static byte[] offerLetterUs(OfferModel offerModel, MultipartFile templateFile)
			throws IOException, IllegalAccessException {
		logger.info("offerLetterUS : Entry");
		logger.info("offerModel : {}", offerModel.toString());
		Document doc = null;
		byte[] offerUsBytes = null;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
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
		try {
			OutputStream out = new FileOutputStream("out.docx");
			out.write(templateFile.getBytes());
			out.close();

			doc = new Document("out.docx");
			logger.info("Document read");

			doc.getRange().replace("#DATE", strDate);
			doc.getRange().replace("#Name", offerModel.getFirstName() + " " + offerModel.getLastName());
			doc.getRange().replace("#Address", offerModel.getAddress());
			doc.getRange().replace("#City_St_Zip", offerModel.getCity());
			doc.getRange().replace("#FirstName", offerModel.getFirstName());
			doc.getRange().replace("#Role", offerModel.getRole());
			doc.getRange().replace("#ReportingAddres", offerModel.getReportingAddress());
			doc.getRange().replace("#JoinDate", strJoiningDate);
			doc.getRange().replace("#Exemption", offerModel.getExemptionStatus());
			doc.getRange().replace("#BaseSal", "$" + format.format(Double.valueOf(offerModel.getBase())));
			doc.getRange().replace("#OfferResDate", strResponseDate);
			doc.getRange().replace("#RepTo", offerModel.getReportingTo());
			doc.getRange().replace("#Bon", "$" + format.format(Double.valueOf(offerModel.getBonus())));
			doc.getRange().replace("#SevDue", "$" + (format.format(Double.valueOf(offerModel.getSeverance()))),
					new FindReplaceOptions(FindReplaceDirection.FORWARD));

			doc.save("US Offer.pdf");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			doc.save(byteArrayOutputStream, SaveFormat.PDF);
			offerUsBytes = byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("offerLetterUS : Exit");
		return offerUsBytes;
	}

	public static byte[] retentionLetter(RetentionModel retentionModel, MultipartFile templateFile)
			throws IOException, IllegalAccessException {
		logger.info("Retention Letter : Entry");
		logger.info("retentionModel : {}", retentionModel.toString());
		Document doc = null;
		byte[] retentionBytes = null;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String address2 = null;
		String cityStateZip = null;
//		if (retentionModel.getAddress2().isEmpty())
			address2 = "\n" + retentionModel.getAddress2();
//		else
//			address2 = "";
//		if (retentionModel.getCityStateZip().isEmpty())
			cityStateZip = "\n" + retentionModel.getCityStateZip();
//		else
//			cityStateZip = "";

		DecimalFormat format = new DecimalFormat("$##,##,###");
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);
		try {
			OutputStream out = new FileOutputStream("out.docx");
			out.write(templateFile.getBytes());
			out.close();

			doc = new Document("out.docx");
			logger.info("Document read");

			doc.getRange().replace("#FirstName", retentionModel.getFirstName());
			doc.getRange().replace("#Name", retentionModel.getFirstName() + " " + retentionModel.getLastName());
			doc.getRange().replace("#LastName", retentionModel.getLastName());
			doc.getRange().replace("#Address", retentionModel.getAddress());
			doc.getRange().replace("#Addres2", address2);
			doc.getRange().replace("#CityStateZipCode", cityStateZip);
			doc.getRange().replace("#Bonus$", "$" + format.format(Double.valueOf(retentionModel.getBonus())));
			doc.getRange().replace("#WorkState", retentionModel.getWorkState());
			doc.getRange().replace("#Date", dateFormat.format(retentionModel.getDate()),
					new FindReplaceOptions(FindReplaceDirection.FORWARD));

			doc.save("Retention.pdf");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			doc.save(byteArrayOutputStream, SaveFormat.PDF);
			retentionBytes = byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Retention Letter : Exit");
		return retentionBytes;
	}

	public static byte[] appointmentLetter(AppointmentModel appointmentModel, MultipartFile templateFile)
			throws IOException, IllegalAccessException {
		logger.info("Appointment Letter : Entry");
		logger.info("appointmentModel : {}", appointmentModel.toString());
		Document doc = null;
		byte[] appointmentBytes = null;
		String currentDate = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
		String strEmpNo = String.valueOf((int) appointmentModel.getEmpNumber());
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strJoiningDate = dateFormat.format(appointmentModel.getJoiningDate());
		String middleName = null;
		if (appointmentModel.getMiddleName() != null) {
			middleName = appointmentModel.getMiddleName();
		} else {
			middleName = "";
		}
		try {
			OutputStream out = new FileOutputStream("out.docx");
			out.write(templateFile.getBytes());
			out.close();

			doc = new Document("out.docx");
			logger.info("Document read");

			doc.getRange().replace("#firstName", appointmentModel.getFirstName());
			doc.getRange().replace("#middleName", middleName);
			doc.getRange().replace("#lastName", appointmentModel.getLastName());
			doc.getRange().replace("#title", appointmentModel.getTitle());
			doc.getRange().replace("#joiningBranch", appointmentModel.getJoiningBranch());
			doc.getRange().replace("#joiningDate", strJoiningDate);
			doc.getRange().replace("#offerDate", currentDate);
			doc.getRange().replace("#grade", appointmentModel.getGrade());
			doc.getRange().replace("#empNo", strEmpNo);
			doc.getRange().replace("#designation", appointmentModel.getDesignation());
			doc.getRange().replace("#ApplicantId", appointmentModel.getRefId(),
					new FindReplaceOptions(FindReplaceDirection.FORWARD));

			doc.save("Appointment.pdf");
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			doc.save(byteArrayOutputStream, SaveFormat.PDF);
			appointmentBytes = byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Appointment Letter : Exit");
		return appointmentBytes;
	}

}
