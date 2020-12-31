//package com.insourcing;
//
//import java.io.ByteArrayOutputStream;
//
//import com.aspose.pdf.Document;
//import com.aspose.pdf.TextReplaceOptions;
//import com.aspose.pdf.facades.PdfContentEditor;
//import com.aspose.words.SaveFormat;
//
////import com.aspose.words.Document;
////import com.aspose.words.FindReplaceDirection;
////import com.aspose.words.FindReplaceOptions;
//
//public class WordToPdf {
//
//	public static void main(String[] args) {
//		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//		Document doc = null;
//		try {
//			doc = new Document("India Offer.pdf");
//			System.out.println("Document read");
//
//			PdfContentEditor pdfContentEditor = new PdfContentEditor();
//			pdfContentEditor.bindPdf(doc);
//			TextReplaceOptions opt = new TextReplaceOptions(TextReplaceOptions.ReplaceAdjustment.AdjustSpaceWidth);
//			pdfContentEditor.setTextReplaceOptions(opt); // replace text on all pages
//			pdfContentEditor.replaceText("#POSTINGBRANCH", 1, "Chennai");
//			pdfContentEditor.replaceText("#FIRSTNAME", 1, "Sobiga");
//			pdfContentEditor.replaceText("#ApplicantID", 1, "RTFIN001");
//			pdfContentEditor.replaceText("#Title", 1, "Ms.");
//			pdfContentEditor.replaceText("#MIDDLENAME", 1, "");
//			pdfContentEditor.replaceText("#LASTNAME", 1, "R");
//			pdfContentEditor.replaceText("#DESIGNATION", 1, "System Engineer");
//			pdfContentEditor.replaceText("#GRADE", 1, "C1Y");
//			pdfContentEditor.replaceText("#CTC_A", 1, "1,00,000");
//			pdfContentEditor.replaceText("#BASIC_M", 1, "1,00,000");
//			pdfContentEditor.replaceText("#HRA_M", 1, "1,00,000");
//			pdfContentEditor.replaceText("#PERALLOWANCE_M", 1, "2,000");
//			pdfContentEditor.replaceText("#TITLE", 1, "Ms");
//			pdfContentEditor.replaceText("#MVA_M", 1, "2,000");
//			pdfContentEditor.replaceText("#QVA_M", 1, "2,000");
//			pdfContentEditor.replaceText("#CITY_ALLOWANCE_M", 1, "2,000");
//			pdfContentEditor.replaceText("#BOB_M", 1, "2000");
//			pdfContentEditor.replaceText("#BOB_A", 1, "2000000");
//			pdfContentEditor.replaceText("#ANNUAL_RETIRALS_M", 1, "20000");
//			pdfContentEditor.replaceText("#ANNUAL_RETIRALS_A", 1, "2000000");
//			pdfContentEditor.replaceText("#BOB_M", 1, "2500");
//			pdfContentEditor.replaceText("Responsibilities", 1, "25000000");
//
////			doc.getRange().replace("#FirstName", "Sobiga");
////			doc.getRange().replace("#POSTINGBRANCH", "Chennai");
////			doc.getRange().replace("#ApplicantID", "RTFIN001");
////			doc.getRange().replace("#Title", "Ms.");
////			doc.getRange().replace("#MiddleName", "");
////			doc.getRange().replace("#LastName", "R");
////			doc.getRange().replace("#DESIGNATION", "System Engineer");
////			doc.getRange().replace("#GRADE", "C1Y");
////			doc.getRange().replace("#CTC_A", "1,00,000");
////			doc.getRange().replace("#BASIC_M", "1,00,000");
////			doc.getRange().replace("#HRA_M", "1,00,000");
////			doc.getRange().replace("#PERALLOWANCE_M", "2,000");
////			doc.getRange().replace("#VEHICLE_M", "2,000");
////			doc.getRange().replace("#MVA_M", "2,000");
////			doc.getRange().replace("#QVA_M", "2,000");
////			doc.getRange().replace("#CITY_ALLOWANCE_M", "2,000");
////			doc.getRange().replace("#BOB_M", "2000");
////			doc.getRange().replace("#BOB_A", "2000000");
////			doc.getRange().replace("#ANNUAL_RETIRALS_M", "20000");
////			doc.getRange().replace("#ANNUAL_RETIRALS_A", "2000000");
////			doc.getRange().replace("#BOB_M", "2500");
////			doc.getRange().replace("Responsibilities", "25000000");
////			doc.getRange().replace("#Department", "Information Technology",
////					new FindReplaceOptions(FindReplaceDirection.FORWARD));
//
//			doc.save("India Offer.pdf");
//			System.out.print("Pdf replaced in local");
//			// doc.save("India Offer output.docx", SaveFormat.DOCX);
//			doc.save(byteArrayOutputStream, SaveFormat.PDF);
//			System.out.print("After doc.save");
//			System.out.println("success");
//		} catch (Exception e) {
//			System.out.println("Exception occurred : " + e);
//		}
//
//	}
//
//}
