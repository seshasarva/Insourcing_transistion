//package com.insourcing.helper;
//
//import java.io.ByteArrayOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.text.SimpleDateFormat;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.aspose.pdf.DocSaveOptions;
//import com.aspose.pdf.Document;
//import com.aspose.pdf.TextReplaceOptions;
//import com.aspose.pdf.facades.PdfContentEditor;
//import com.insourcing.entity.OfferIndiaEntity;
//
//public class ReplacePdf {
//
//	private static Logger logger = LogManager.getLogger(ReplacePdf.class);
//
//	@Value("${insource.app.india.date.format}")
//	private String indiaDateFormat;
//
//	@Value("${insource.app.india.zone.id}")
//	private String indiaZoneId;
//
//	@Value("${insource.app.us.date.format}")
//	private String usDateFormat;
//
//	@Value("${insource.app.us.zone.id}")
//	private String usZoneId;
//
//	public static byte[] offerLetterIndia(OfferIndiaEntity offerModel, MultipartFile templateFile)
//			throws IOException, IllegalAccessException {
//		logger.info("offerLetterIndia : Entry");
//		logger.info("offerModel : {}", offerModel.toString());
//		Document doc = null;
//		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//		byte[] offerIndiaBytes = null;
//		String strJoiningDate = new SimpleDateFormat("dd/MM/yyyy").format(offerModel.getJoiningDate());
//		String middleName = null;
//		if (offerModel.getMiddlename() != null) {
//			middleName = offerModel.getMiddlename();
//		} else {
//			middleName = "";
//		}
//		try {
//			OutputStream out = new FileOutputStream("out.pdf");
//			out.write(templateFile.getBytes());
//			out.close();
//
//			doc = new Document("out.pdf");
//			logger.info("Document read");
//			PdfContentEditor pdfContentEditor = new PdfContentEditor();
//			pdfContentEditor.bindPdf(doc);
//			TextReplaceOptions opt = new TextReplaceOptions(TextReplaceOptions.ReplaceAdjustment.AdjustSpaceWidth);
//			pdfContentEditor.setTextReplaceOptions(opt); // replace text on all pages
//			pdfContentEditor.replaceText("#Title", offerModel.getTitle());
//			pdfContentEditor.replaceText("#FirstName", offerModel.getFirstname());
//			pdfContentEditor.replaceText("#MiddleName", middleName);
//			pdfContentEditor.replaceText("#BASIC_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBasic()[0])));
//			pdfContentEditor.replaceText("#MVA_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getMva()[0])));
//			pdfContentEditor.replaceText("#QVA_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getQva()[0])));
//			pdfContentEditor.replaceText("#CITY_ALLOWANCE_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCityAllowance()[0])));
//			pdfContentEditor.replaceText("#BOB_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBob()[0])));
//			pdfContentEditor.replaceText("#HRA_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHra()[0])));
//			pdfContentEditor.replaceText("#LTA_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getLta()[0])));
//			pdfContentEditor.replaceText("#FOODCOUPONS_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFoodCoupons()[0])));
//			pdfContentEditor.replaceText("#CAR_ALLOWANCE_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCarAllo()[0])));
//			pdfContentEditor.replaceText("#VEHICLE_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getVehicle()[0])));
//			pdfContentEditor.replaceText("#FUEL_ALLOWANCE_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFuelAllo()[0])));
//			pdfContentEditor.replaceText("#PERALLOWANCE_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPerAllo()[0])));
//			pdfContentEditor.replaceText("#PF_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPf()[0])));
//			pdfContentEditor.replaceText("#GRATUITY_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getGratuity()[0])));
//			pdfContentEditor.replaceText("#ANNUAL_RETIRALS_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getAnnualRetirals()[0])));
//			pdfContentEditor.replaceText("#CTC_M",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCtc()[0])));
//			pdfContentEditor.replaceText("#BASIC_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBasic()[1])));
//			pdfContentEditor.replaceText("#MVA_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getMva()[1])));
//			pdfContentEditor.replaceText("#QVA_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getQva()[1])));
//			pdfContentEditor.replaceText("#CITY_ALLOWANCE_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCityAllowance()[1])));
//			pdfContentEditor.replaceText("#HRA_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHra()[1])));
//			pdfContentEditor.replaceText("#LTA_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getLta()[1])));
//			pdfContentEditor.replaceText("#FOODCOUPONS_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFoodCoupons()[1])));
//			pdfContentEditor.replaceText("#CAR_ALLOWANCE_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCarAllo()[1])));
//			pdfContentEditor.replaceText("#VEHICLE_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getVehicle()[1])));
//			pdfContentEditor.replaceText("#FUEL_ALLOWANCE_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFuelAllo()[1])));
//			pdfContentEditor.replaceText("#PERALLOWANCE_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPerAllo()[1])));
//			pdfContentEditor.replaceText("#BOB_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBob()[1])));
//			pdfContentEditor.replaceText("#HIS_III",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHis3())));
//			pdfContentEditor.replaceText("#PF_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPf()[1])));
//			pdfContentEditor.replaceText("#GRATUITY_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getGratuity()[1])));
//			pdfContentEditor.replaceText("#ANNUAL_RETIRALS_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getAnnualRetirals()[1])));
//			pdfContentEditor.replaceText("#RET_INC_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getRetInc())));
//			pdfContentEditor.replaceText("#CTC_A",
//					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCtc()[1])));
//			pdfContentEditor.replaceText("#PROBATION_PERIOD", offerModel.getProbPeriod());
//			pdfContentEditor.replaceText("#PROBATION_UNIT", offerModel.getProbUnit());
//			pdfContentEditor.replaceText("#DATE_OF_JOINING", strJoiningDate);
//			pdfContentEditor.replaceText("#JOINING_BRANCH", offerModel.getJoiningBranch());
//			pdfContentEditor.replaceText("#EXGRATIA", offerModel.getExgratia());
//
//			doc.save("India Offe output.pdf");
//			logger.info("Pdf replaced in local");
//			DocSaveOptions saveOptions = new DocSaveOptions();
//			saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
//			doc.save("India Offe output.docx", saveOptions);
//			// doc.save(byteArrayOutputStream, SaveFormat.PDF);
//			logger.info("After doc.save");
//			offerIndiaBytes = byteArrayOutputStream.toByteArray();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return offerIndiaBytes;
//	}
//
//}
