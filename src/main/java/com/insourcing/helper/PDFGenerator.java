package com.insourcing.helper;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import com.insourcing.entity.OfferIndiaEntity;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;

@SuppressWarnings({ "deprecation", "unused" })
public class PDFGenerator {
	private static Logger logger = LogManager.getLogger(PDFGenerator.class);

	public static byte[] offerIndiaPDFGen(OfferIndiaEntity offerModel, String editedText) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			PDDocument doc = new PDDocument();
			PDPage pageOne = new PDPage(PDRectangle.A4);
			doc.addPage(pageOne);
			PDPageContentStream cos = null;
			String[] value = null;
			value = editedText.split("<br>");
			PDFont pdfFont = PDType1Font.HELVETICA;
			PDFont pdfFontBold = PDType1Font.HELVETICA_BOLD;
			float fontSize = 11;
			float leading = 1.5f * fontSize;
			float margin = 50;
			PDRectangle mediabox = pageOne.getMediaBox();
			float width = mediabox.getWidth() - 2 * margin;
			float startX = mediabox.getLowerLeftX() + margin;
			float startY = mediabox.getUpperRightY() - margin;
			PDPage pageTwo = new PDPage(PDRectangle.A4);
			doc.addPage(pageTwo);
			PDPage pageThree = new PDPage(PDRectangle.A4);
			doc.addPage(pageThree);
			PDPage pageFour = new PDPage(PDRectangle.A4);
			doc.addPage(pageFour);
			PDPage pageFive = new PDPage(PDRectangle.A4);
			doc.addPage(pageFive);
			PDPage pageSix = new PDPage(PDRectangle.A4);
			doc.addPage(pageSix);
			PDPage pageSeven = new PDPage(PDRectangle.A4);
			doc.addPage(pageSeven);
			PDPage pageEight = new PDPage(PDRectangle.A4);
			doc.addPage(pageEight);
			PDPage pageNine = new PDPage(PDRectangle.A4);
			doc.addPage(pageNine);
			// PDPage pageTen = new PDPage(PDRectangle.A4);
			// doc.addPage(pageTen);
			// PDPage pageEleven = new PDPage(PDRectangle.A4);
			// doc.addPage(pageEleven);
			PDPage pageTwelve = new PDPage(PDRectangle.A4);
			doc.addPage(pageTwelve);
			PDPage pageThirteen = new PDPage(PDRectangle.A4);
			doc.addPage(pageThirteen);
			PDPage pageFourteen = new PDPage(PDRectangle.A4);
			doc.addPage(pageFourteen);
			PDPage pageFifteen = new PDPage(PDRectangle.A4);
			doc.addPage(pageFifteen);
			PDPage pageSixteen = new PDPage(PDRectangle.A4);
			doc.addPage(pageSixteen);
			PDPage pageSeventeen = new PDPage(PDRectangle.A4);
			doc.addPage(pageSeventeen);
			PDPage pageEighteen = new PDPage(PDRectangle.A4);
			doc.addPage(pageEighteen);
			PDPage pageNineteen = new PDPage(PDRectangle.A4);
			doc.addPage(pageNineteen);
			PDPage pageTwenty = new PDPage(PDRectangle.A4);
			doc.addPage(pageTwenty);
			PDPage pageTwentyOne = new PDPage(PDRectangle.A4);
			doc.addPage(pageTwentyOne);
			PDPageContentStream cosOne = new PDPageContentStream(doc, pageTwo);
			PDPageContentStream cosTwo = new PDPageContentStream(doc, pageThree);
			PDPageContentStream cosThree = new PDPageContentStream(doc, pageFour);
			PDPageContentStream cosFour = new PDPageContentStream(doc, pageFive);
			PDPageContentStream cosFive = new PDPageContentStream(doc, pageSix);
			PDPageContentStream cosSix = new PDPageContentStream(doc, pageSeven);
			PDPageContentStream cosSeven = new PDPageContentStream(doc, pageEight);
			PDPageContentStream cosEight = new PDPageContentStream(doc, pageNine);
			// PDPageContentStream cosNine = new PDPageContentStream(doc, pageTen);
			// PDPageContentStream cosOne0 = new PDPageContentStream(doc, pageEleven);
			PDPageContentStream cosEleven = new PDPageContentStream(doc, pageTwelve);
			PDPageContentStream cosTwelve = new PDPageContentStream(doc, pageThirteen);
			PDPageContentStream cosThirteen = new PDPageContentStream(doc, pageFourteen);
			PDPageContentStream cosFourteen = new PDPageContentStream(doc, pageFifteen);
			PDPageContentStream cosFifteen = new PDPageContentStream(doc, pageSixteen);
			PDPageContentStream cosSixteen = new PDPageContentStream(doc, pageSeventeen);
			PDPageContentStream cosSeventeen = new PDPageContentStream(doc, pageEighteen);
			PDPageContentStream cosEighteen = new PDPageContentStream(doc, pageNineteen);
			PDPageContentStream cosNineteen = new PDPageContentStream(doc, pageTwenty);
			PDPageContentStream cosTwenty = new PDPageContentStream(doc, pageTwentyOne);
			cos = new PDPageContentStream(doc, pageOne);

			// ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			// logger.info("Class Loader path::::" +
			// classLoader.getResource("images/image.jpg").getPath());
			/// String pathImage = classLoader.getResource("images/image.jpg").getPath();
			// String pathFooter =
			// classLoader.getResource("images/footer_india.png").getPath();
			// String path =
			// classLoader.getResource("images/signature-india.jpg").getPath();

			// PDImageXObject pdImage =
			// PDImageXObject.createFromFile(pathImage.replaceAll("%20", " "), doc);
			// PDImageXObject pdFooterImage =
			// PDImageXObject.createFromFile(pathFooter.replaceAll("%20", " "), doc);
			PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/images/image.jpg", doc);
			PDImageXObject pdFooterImage = PDImageXObject.createFromFile("src/main/resources/images/footer_india.PNG",
					doc);
			cos.drawXObject(pdImage, 260, 750, 70, 70);
			cos.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosOne.drawXObject(pdImage, 255, 750, 70, 70);
			cosOne.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosTwo.drawXObject(pdImage, 255, 750, 70, 70);
			cosTwo.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosThree.drawXObject(pdImage, 255, 750, 70, 70);
			cosThree.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosFour.drawXObject(pdImage, 255, 750, 70, 70);
			cosFour.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosFive.drawXObject(pdImage, 255, 750, 70, 70);
			cosFive.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosSix.drawXObject(pdImage, 255, 750, 70, 70);
			cosSix.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosSeven.drawXObject(pdImage, 255, 750, 70, 70);
			cosSeven.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosEight.drawXObject(pdImage, 255, 750, 70, 70);
			cosEight.drawXObject(pdFooterImage, 150, 0, 300, 75);
			// cosNine.drawXObject(pdImage, 250, 750, 70, 70);
			// cosNine.drawXObject(pdFooterImage, 150, 0, 300, 75);
			// cosOne0.drawXObject(pdImage, 245, 750, 75, 75);
			// cosOne0.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosEleven.drawXObject(pdImage, 255, 750, 70, 70);
			cosEleven.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosTwelve.drawXObject(pdImage, 255, 750, 70, 70);
			cosTwelve.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosThirteen.drawXObject(pdImage, 255, 750, 70, 70);
			cosThirteen.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosFourteen.drawXObject(pdImage, 255, 750, 70, 70);
			cosFourteen.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosFifteen.drawXObject(pdImage, 255, 750, 70, 70);
			cosFifteen.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosSixteen.drawXObject(pdImage, 255, 750, 70, 70);
			cosSixteen.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosSeventeen.drawXObject(pdImage, 255, 750, 70, 70);
			cosSeventeen.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosEighteen.drawXObject(pdImage, 255, 750, 70, 70);
			cosEighteen.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosNineteen.drawXObject(pdImage, 255, 750, 70, 70);
			cosNineteen.drawXObject(pdFooterImage, 150, 0, 300, 75);
			cosTwenty.drawXObject(pdImage, 255, 750, 70, 70);
			cosTwenty.drawXObject(pdFooterImage, 150, 0, 300, 75);

			// PDImageXObject signatureIndia =
			// PDImageXObject.createFromFile(path.replaceAll("%20", " "),
			// doc);
			PDImageXObject signatureIndia = PDImageXObject.createFromFile(
					"src/main/resources/images/signature-india.JPG",
					doc);
			cosEight.drawXObject(signatureIndia, 70, 455, 65, 65);
			cos.beginText();
			cos.setFont(PDType1Font.HELVETICA, 10);
			cos.setStrokingColor(Color.GRAY);
			cos.newLineAtOffset(15, 65);
			cos.showText("Private and Confidential");
			cos.endText();
			cos.beginText();
			cos.setFont(PDType1Font.HELVETICA, 10);
			cos.setStrokingColor(Color.GRAY);
			cos.newLineAtOffset(15, 55);
			cos.showText("TCSL/" + offerModel.getRefId());
			cos.endText();
			cosOne.drawXObject(pdImage, 250, 750, 70, 70);
			cosOne.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosOne.beginText();
			cosOne.setFont(PDType1Font.HELVETICA, 10);
			cosOne.setStrokingColor(Color.GRAY);
			cosOne.newLineAtOffset(15, 65);
			cosOne.showText("Private and Confidential");
			cosOne.endText();
			cosOne.beginText();
			cosOne.setFont(PDType1Font.HELVETICA, 10);
			cosOne.setStrokingColor(Color.GRAY);
			cosOne.newLineAtOffset(15, 55);
			cosOne.showText("TCSL/" + offerModel.getRefId());
			cosOne.endText();
			cosTwo.drawXObject(pdImage, 250, 750, 70, 70);
			cosTwo.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosTwo.beginText();
			cosTwo.setFont(PDType1Font.HELVETICA, 10);
			cosTwo.setStrokingColor(Color.GRAY);
			cosTwo.newLineAtOffset(15, 65);
			cosTwo.showText("Private and Confidential");
			cosTwo.endText();
			cosTwo.beginText();
			cosTwo.setFont(PDType1Font.HELVETICA, 10);
			cosTwo.setStrokingColor(Color.GRAY);
			cosTwo.newLineAtOffset(15, 55);
			cosTwo.showText("TCSL/" + offerModel.getRefId());
			cosTwo.endText();
			cosThree.drawXObject(pdImage, 250, 750, 70, 70);
			cosThree.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosThree.beginText();
			cosThree.setFont(PDType1Font.HELVETICA, 10);
			cosThree.setStrokingColor(Color.GRAY);
			cosThree.newLineAtOffset(15, 65);
			cosThree.showText("Private and Confidential");
			cosThree.endText();
			cosThree.beginText();
			cosThree.setFont(PDType1Font.HELVETICA, 10);
			cosThree.setStrokingColor(Color.GRAY);
			cosThree.newLineAtOffset(15, 55);
			cosThree.showText("TCSL/" + offerModel.getRefId());
			cosThree.endText();
			cosFour.drawXObject(pdImage, 250, 750, 70, 70);
			cosFour.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosFour.beginText();
			cosFour.setFont(PDType1Font.HELVETICA, 10);
			cosFour.setStrokingColor(Color.GRAY);
			cosFour.newLineAtOffset(15, 65);
			cosFour.showText("Private and Confidential");
			cosFour.endText();
			cosFour.beginText();
			cosFour.setFont(PDType1Font.HELVETICA, 10);
			cosFour.setStrokingColor(Color.GRAY);
			cosFour.newLineAtOffset(15, 55);
			cosFour.showText("TCSL/" + offerModel.getRefId());
			cosFour.endText();
			cosFive.drawXObject(pdImage, 250, 750, 70, 70);
			cosFive.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosFive.beginText();
			cosFive.setFont(PDType1Font.HELVETICA, 10);
			cosFive.setStrokingColor(Color.GRAY);
			cosFive.newLineAtOffset(15, 65);
			cosFive.showText("Private and Confidential");
			cosFive.endText();
			cosFive.beginText();
			cosFive.setFont(PDType1Font.HELVETICA, 10);
			cosFive.setStrokingColor(Color.GRAY);
			cosFive.newLineAtOffset(15, 55);
			cosFive.showText("TCSL/" + offerModel.getRefId());
			cosFive.endText();
			cosSix.drawXObject(pdImage, 250, 750, 70, 70);
			cosSix.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosSix.beginText();
			cosSix.setFont(PDType1Font.HELVETICA, 10);
			cosSix.setStrokingColor(Color.GRAY);
			cosSix.newLineAtOffset(15, 65);
			cosSix.showText("Private and Confidential");
			cosSix.endText();
			cosSix.beginText();
			cosSix.setFont(PDType1Font.HELVETICA, 10);
			cosSix.setStrokingColor(Color.GRAY);
			cosSix.newLineAtOffset(15, 55);
			cosSix.showText("TCSL/" + offerModel.getRefId());
			cosSix.endText();
			cosSeven.drawXObject(pdImage, 250, 750, 70, 70);
			cosSeven.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosSeven.beginText();
			cosSeven.setFont(PDType1Font.HELVETICA, 10);
			cosSeven.setStrokingColor(Color.GRAY);
			cosSeven.newLineAtOffset(15, 65);
			cosSeven.showText("Private and Confidential");
			cosSeven.endText();
			cosSeven.beginText();
			cosSeven.setFont(PDType1Font.HELVETICA, 10);
			cosSeven.setStrokingColor(Color.GRAY);
			cosSeven.newLineAtOffset(15, 55);
			cosSeven.showText("TCSL/" + offerModel.getRefId());
			cosSeven.endText();
			cosEight.drawXObject(pdImage, 250, 750, 70, 70);
			cosEight.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosEight.beginText();
			cosEight.setFont(PDType1Font.HELVETICA, 10);
			cosEight.setStrokingColor(Color.GRAY);
			cosEight.newLineAtOffset(15, 65);
			cosEight.showText("Private and Confidential");
			cosEight.endText();
			cosEight.beginText();
			cosEight.setFont(PDType1Font.HELVETICA, 10);
			cosEight.setStrokingColor(Color.GRAY);
			cosEight.newLineAtOffset(15, 55);
			cosEight.showText("TCSL/" + offerModel.getRefId());
			cosEight.endText();
			cosEleven.drawXObject(pdImage, 250, 750, 70, 70);
			cosEleven.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosEleven.beginText();
			cosEleven.setFont(PDType1Font.HELVETICA, 10);
			cosEleven.setStrokingColor(Color.GRAY);
			cosEleven.newLineAtOffset(15, 65);
			cosEleven.showText("Private and Confidential");
			cosEleven.endText();
			cosEleven.beginText();
			cosEleven.setFont(PDType1Font.HELVETICA, 10);
			cosEleven.setStrokingColor(Color.GRAY);
			cosEleven.newLineAtOffset(15, 55);
			cosEleven.showText("TCSL/" + offerModel.getRefId());
			cosEleven.endText();
			cosTwelve.drawXObject(pdImage, 250, 750, 70, 70);
			cosTwelve.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosTwelve.beginText();
			cosTwelve.setFont(PDType1Font.HELVETICA, 10);
			cosTwelve.setStrokingColor(Color.GRAY);
			cosTwelve.newLineAtOffset(15, 65);
			cosTwelve.showText("Private and Confidential");
			cosTwelve.endText();
			cosTwelve.beginText();
			cosTwelve.setFont(PDType1Font.HELVETICA, 10);
			cosTwelve.setStrokingColor(Color.GRAY);
			cosTwelve.newLineAtOffset(15, 75);
			cosTwelve.showText("TCSL/" + offerModel.getRefId());
			cosTwelve.endText();
			cosThirteen.drawXObject(pdImage, 250, 750, 70, 70);
			cosThirteen.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosThirteen.beginText();
			cosThirteen.setFont(PDType1Font.HELVETICA, 10);
			cosThirteen.setStrokingColor(Color.GRAY);
			cosThirteen.newLineAtOffset(15, 65);
			cosThirteen.showText("Private and Confidential");
			cosThirteen.endText();
			cosThirteen.beginText();
			cosThirteen.setFont(PDType1Font.HELVETICA, 10);
			cosThirteen.setStrokingColor(Color.GRAY);
			cosThirteen.newLineAtOffset(15, 55);
			cosThirteen.showText("TCSL/" + offerModel.getRefId());
			cosThirteen.endText();
			cosFourteen.drawXObject(pdImage, 250, 750, 70, 70);
			cosFourteen.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosFourteen.beginText();
			cosFourteen.setFont(PDType1Font.HELVETICA, 10);
			cosFourteen.setStrokingColor(Color.GRAY);
			cosFourteen.newLineAtOffset(15, 65);
			cosFourteen.showText("Private and Confidential");
			cosFourteen.endText();
			cosFourteen.beginText();
			cosFourteen.setFont(PDType1Font.HELVETICA, 10);
			cosFourteen.setStrokingColor(Color.GRAY);
			cosFourteen.newLineAtOffset(15, 55);
			cosFourteen.showText("TCSL/" + offerModel.getRefId());
			cosFourteen.endText();
			cosFifteen.drawXObject(pdImage, 250, 750, 70, 70);
			cosFifteen.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosFifteen.beginText();
			cosFifteen.setFont(PDType1Font.HELVETICA, 10);
			cosFifteen.setStrokingColor(Color.GRAY);
			cosFifteen.newLineAtOffset(15, 65);
			cosFifteen.showText("Private and Confidential");
			cosFifteen.endText();
			cosFifteen.beginText();
			cosFifteen.setFont(PDType1Font.HELVETICA, 10);
			cosFifteen.setStrokingColor(Color.GRAY);
			cosFifteen.newLineAtOffset(15, 55);
			cosFifteen.showText("TCSL/" + offerModel.getRefId());
			cosFifteen.endText();
			cosSixteen.drawXObject(pdImage, 250, 750, 70, 70);
			cosSixteen.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosSixteen.beginText();
			cosSixteen.setFont(PDType1Font.HELVETICA, 10);
			cosSixteen.setStrokingColor(Color.GRAY);
			cosSixteen.newLineAtOffset(15, 65);
			cosSixteen.showText("Private and Confidential");
			cosSixteen.endText();
			cosSixteen.beginText();
			cosSixteen.setFont(PDType1Font.HELVETICA, 10);
			cosSixteen.setStrokingColor(Color.GRAY);
			cosSixteen.newLineAtOffset(15, 55);
			cosSixteen.showText("TCSL/" + offerModel.getRefId());
			cosSixteen.endText();
			cosSeventeen.drawXObject(pdImage, 250, 750, 70, 70);
			cosSeventeen.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosSeventeen.beginText();
			cosSeventeen.setFont(PDType1Font.HELVETICA, 10);
			cosSeventeen.setStrokingColor(Color.GRAY);
			cosSeventeen.newLineAtOffset(15, 65);
			cosSeventeen.showText("Private and Confidential");
			cosSeventeen.endText();
			cosSeventeen.beginText();
			cosSeventeen.setFont(PDType1Font.HELVETICA, 10);
			cosSeventeen.setStrokingColor(Color.GRAY);
			cosSeventeen.newLineAtOffset(15, 55);
			cosSeventeen.showText("TCSL/" + offerModel.getRefId());
			cosSeventeen.endText();
			cosEighteen.drawXObject(pdImage, 250, 750, 70, 70);
			cosEighteen.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosEighteen.beginText();
			cosEighteen.setFont(PDType1Font.HELVETICA, 10);
			cosEighteen.setStrokingColor(Color.GRAY);
			cosEighteen.newLineAtOffset(15, 65);
			cosEighteen.showText("Private and Confidential");
			cosEighteen.endText();
			cosEighteen.beginText();
			cosEighteen.setFont(PDType1Font.HELVETICA, 10);
			cosEighteen.setStrokingColor(Color.GRAY);
			cosEighteen.newLineAtOffset(15, 55);
			cosEighteen.showText("TCSL/" + offerModel.getRefId());
			cosEighteen.endText();
			cosNineteen.drawXObject(pdImage, 250, 750, 70, 70);
			cosNineteen.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosNineteen.beginText();
			cosNineteen.setFont(PDType1Font.HELVETICA, 10);
			cosNineteen.setStrokingColor(Color.GRAY);
			cosNineteen.newLineAtOffset(15, 65);
			cosNineteen.showText("Private and Confidential");
			cosNineteen.endText();
			cosNineteen.beginText();
			cosNineteen.setFont(PDType1Font.HELVETICA, 10);
			cosNineteen.setStrokingColor(Color.GRAY);
			cosNineteen.newLineAtOffset(15, 55);
			cosNineteen.showText("TCSL/" + offerModel.getRefId());
			cosNineteen.endText();
			cosTwenty.drawXObject(pdImage, 250, 750, 70, 70);
			cosTwenty.drawXObject(pdFooterImage, 180, 0, 240, 75);
			cosTwenty.beginText();
			cosTwenty.setFont(PDType1Font.HELVETICA, 10);
			cosTwenty.setStrokingColor(Color.GRAY);
			cosTwenty.newLineAtOffset(15, 65);
			cosTwenty.showText("Private and Confidential");
			cosTwenty.endText();
			cosTwenty.beginText();
			cosTwenty.setFont(PDType1Font.HELVETICA, 10);
			cosTwenty.setStrokingColor(Color.GRAY);
			cosTwenty.newLineAtOffset(15, 55);
			cosTwenty.showText("TCSL/" + offerModel.getRefId());
			cosTwenty.endText();
			cos.beginText();
			cos.newLineAtOffset(startX, startY);
			cos.moveTextPositionByAmount(10, -40);
			cosOne.beginText();
			cosOne.newLineAtOffset(startX, startY);
			cosOne.moveTextPositionByAmount(10, -55);
			cosTwo.beginText();
			// cosTwo.setFont(pdfFont, fontSize);
			cosTwo.newLineAtOffset(startX, startY);
			cosTwo.moveTextPositionByAmount(10, -65);
			cosThree.beginText();
			// cosThree.setFont(pdfFont, fontSize);
			cosThree.newLineAtOffset(startX, startY);
			cosThree.moveTextPositionByAmount(10, -65);
			cosFour.beginText();
			// cosFour.setFont(pdfFont, fontSize);
			cosFour.newLineAtOffset(startX, startY);
			cosFour.moveTextPositionByAmount(10, -65);
			cosFive.beginText();
			// cosFive.setFont(pdfFont, fontSize);
			cosFive.newLineAtOffset(startX, startY);
			cosFive.moveTextPositionByAmount(10, -65);
			cosSix.beginText();
			// cosSix.setFont(pdfFont, fontSize);
			cosSix.newLineAtOffset(startX, startY);
			cosSix.moveTextPositionByAmount(10, -65);
			cosSeven.beginText();
			// cosSeven.setFont(pdfFont, fontSize);
			cosSeven.newLineAtOffset(startX, startY);
			cosSeven.moveTextPositionByAmount(10, -65);
			cosEight.beginText();
			// cosEight.setFont(pdfFont, fontSize);
			cosEight.newLineAtOffset(startX, startY);
			cosEight.moveTextPositionByAmount(10, -65);
			cosEleven.beginText();
			cosEleven.newLineAtOffset(startX, startY);
			cosEleven.moveTextPositionByAmount(10, -70);
			cosFifteen.beginText();
			// cosFifteen.setFont(pdfFont, fontSize);
			cosFifteen.newLineAtOffset(startX, startY);
			cosFifteen.moveTextPositionByAmount(10, -65);
			cosSixteen.beginText();
			// cosSixteen.setFont(pdfFont, fontSize);
			cosSixteen.newLineAtOffset(startX, startY);
			cosSixteen.moveTextPositionByAmount(10, -65);
			cosSeventeen.beginText();
			// cosSeventeen.setFont(pdfFont, fontSize);
			cosSeventeen.newLineAtOffset(startX, startY);
			cosSeventeen.moveTextPositionByAmount(10, -65);
			cosEighteen.beginText();
			// cosEighteen.setFont(pdfFont, fontSize);
			cosEighteen.newLineAtOffset(startX, startY);
			cosEighteen.moveTextPositionByAmount(10, -65);
			cosNineteen.beginText();
			// cosNineteen.setFont(pdfFont, fontSize);
			cosNineteen.newLineAtOffset(startX, startY);
			cosNineteen.moveTextPositionByAmount(10, -65);
			cosTwenty.beginText();
			// cosTwenty.setFont(pdfFont, fontSize);
			cosTwenty.newLineAtOffset(startX, startY);
			cosTwenty.moveTextPositionByAmount(10, -65);
			long lineCount = 0;
			for (String strings : value) {

				List<String> lines = new ArrayList<String>();

				int lastSpace = -1;
				while (strings.length() > 0) {
					int spaceIndex = strings.indexOf(' ', lastSpace + 1);
					if (spaceIndex < 0)
						spaceIndex = strings.length();
					String subString = strings.substring(0, spaceIndex);
					float size = fontSize * pdfFont.getStringWidth(subString) / 1000;
					// logger.info("'%s' - %f of %f\n", subString, size, width);
					if (size > width) {
						if (lastSpace < 0)
							lastSpace = spaceIndex;
						subString = strings.substring(0, lastSpace);
						lines.add(subString);
						strings = strings.substring(lastSpace).trim();
						// logger.info("'%s' is line\n", subString);
						lastSpace = -1;
					} else if (spaceIndex == strings.length()) {
						lines.add(strings);
						// logger.info("'%s' is line\n", strings);
						strings = "";
					} else {
						lastSpace = spaceIndex;
					}
				}

				for (String line : lines) {
					lineCount = lineCount + 1;
					// logger.info("lineCount: " + lineCount);
					float charSpacing = 0;
					if (line.length() > 84) {
						float size = fontSize * pdfFont.getStringWidth(line) / 1000;
						float free = width - size;
						if (free > 0) {
							charSpacing = free / (line.length() - 1);
						}
					}
					if (lineCount >= 35 && lineCount <= 74) {
						if (line.startsWith("<b>")) {
							cosOne.setFont(pdfFontBold, fontSize);
							cosOne.setCharacterSpacing(charSpacing);
							cosOne.showText(line.replace("<b>", ""));
							cosOne.newLineAtOffset(0, -leading);
						} else {
							cosOne.setFont(pdfFont, fontSize);
							cosOne.setCharacterSpacing(charSpacing);
							cosOne.showText(line);
							cosOne.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 74 && lineCount <= 114) {
						if (line.startsWith("<b>")) {
							cosTwo.setFont(pdfFontBold, fontSize);
							cosTwo.setCharacterSpacing(charSpacing);
							cosTwo.showText(line.replace("<b>", ""));
							cosTwo.newLineAtOffset(0, -leading);
						} else {
							cosTwo.setFont(pdfFont, fontSize);
							cosTwo.setCharacterSpacing(charSpacing);
							cosTwo.showText(line);
							cosTwo.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 114 && lineCount <= 153) {
						if (line.startsWith("<b>")) {
							cosThree.setFont(pdfFontBold, fontSize);
							cosThree.setCharacterSpacing(charSpacing);
							cosThree.showText(line.replace("<b>", ""));
							cosThree.newLineAtOffset(0, -leading);
						} else {
							cosThree.setFont(pdfFont, fontSize);
							cosThree.setCharacterSpacing(charSpacing);
							cosThree.showText(line);
							cosThree.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 153 && lineCount <= 192) {
						if (line.startsWith("<b>")) {
							cosFour.setFont(pdfFontBold, fontSize);
							cosFour.setCharacterSpacing(charSpacing);
							cosFour.showText(line.replace("<b>", ""));
							cosFour.newLineAtOffset(0, -leading);
						} else {
							cosFour.setFont(pdfFont, fontSize);
							cosFour.setCharacterSpacing(charSpacing);
							cosFour.showText(line);
							cosFour.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 192 && lineCount <= 231) {
						if (line.startsWith("<b>")) {
							cosFive.setFont(pdfFontBold, fontSize);
							cosFive.setCharacterSpacing(charSpacing);
							cosFive.showText(line.replace("<b>", ""));
							cosFive.newLineAtOffset(0, -leading);
						} else {
							cosFive.setFont(pdfFont, fontSize);
							cosFive.setCharacterSpacing(charSpacing);
							cosFive.showText(line);
							cosFive.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 231 && lineCount <= 270) {
						if (line.startsWith("<b>")) {
							cosSix.setFont(pdfFontBold, fontSize);
							cosSix.setCharacterSpacing(charSpacing);
							cosSix.showText(line.replace("<b>", ""));
							cosSix.newLineAtOffset(0, -leading);
						} else {
							cosSix.setFont(pdfFont, fontSize);
							cosSix.setCharacterSpacing(charSpacing);
							cosSix.showText(line);
							cosSix.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 270 && lineCount <= 310) {
						if (line.startsWith("<b>")) {
							cosSeven.setFont(pdfFontBold, fontSize);
							cosSeven.setCharacterSpacing(charSpacing);
							cosSeven.showText(line.replace("<b>", ""));
							cosSeven.newLineAtOffset(0, -leading);
						} else {
							cosSeven.setFont(pdfFont, fontSize);
							cosSeven.setCharacterSpacing(charSpacing);
							cosSeven.showText(line);
							cosSeven.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 310 && lineCount <= 335) {
						if (line.startsWith("<b>")) {
							cosEight.setFont(pdfFontBold, fontSize);
							cosEight.setCharacterSpacing(charSpacing);
							cosEight.showText(line.replace("<b>", ""));
							cosEight.newLineAtOffset(0, -leading);
						} else {
							cosEight.setFont(pdfFont, fontSize);
							cosEight.setCharacterSpacing(charSpacing);
							cosEight.showText(line);
							cosEight.newLineAtOffset(0, -leading);
						}
					} // else if (lineCount >= 345 && lineCount <= 370) {
						// if(line.startsWith("<b>")) {
						// cosNine.setFont(pdfFontBold, fontSize);
						// cosNine.setCharacterSpacing(charSpacing);
						// cosNine.showText(line.replace("<b>", ""));
						// .newLineAtOffset(0, -leading);
						// }else {
						// cosNine.setFont(pdfFont, fontSize);
						// cosNine.setCharacterSpacing(charSpacing);
						// cosNine.showText(line);
						// cosNine.newLineAtOffset(0, -leading);
						// }
						// } else if (lineCount >= 380 && lineCount <= 430) {
						// cosOne0.showText(line);
						// cosOne0.newLineAtOffset(0, -leading);
						// }
					else if (lineCount >= 618 && lineCount <= 656) {
						if (line.startsWith("<b>")) {
							cosFifteen.setFont(pdfFontBold, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText(line.replace("<b>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<bCenter>")) {
							cosFifteen.setFont(pdfFontBold, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("                  " + line.replace("<bCenter>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("          " + line.replace("<op>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op1>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("                    " + line.replace("<op1>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText(line);
							cosFifteen.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 656 && lineCount <= 696) {
						if (line.startsWith("<b>")) {
							cosSixteen.setFont(pdfFontBold, fontSize);
							cosSixteen.setCharacterSpacing(charSpacing);
							cosSixteen.showText(line.replace("<b>", ""));
							cosSixteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("          " + line.replace("<op>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op1>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("                    " + line.replace("<op1>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else {
							cosSixteen.setFont(pdfFont, fontSize);
							cosSixteen.setCharacterSpacing(charSpacing);
							cosSixteen.showText(line);
							cosSixteen.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 696 && lineCount <= 736) {
						if (line.startsWith("<b>")) {
							cosSeventeen.setFont(pdfFontBold, fontSize);
							cosSeventeen.setCharacterSpacing(charSpacing);
							cosSeventeen.showText(line.replace("<b>", ""));
							cosSeventeen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("          " + line.replace("<op>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op1>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("                    " + line.replace("<op1>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else {
							cosSeventeen.setFont(pdfFont, fontSize);
							cosSeventeen.setCharacterSpacing(charSpacing);
							cosSeventeen.showText(line);
							cosSeventeen.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 736 && lineCount <= 776) {
						if (line.startsWith("<b>")) {
							cosEighteen.setFont(pdfFontBold, fontSize);
							cosEighteen.setCharacterSpacing(charSpacing);
							cosEighteen.showText(line.replace("<b>", ""));
							cosEighteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("          " + line.replace("<op>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op1>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("                    " + line.replace("<op1>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else {
							cosEighteen.setFont(pdfFont, fontSize);
							cosEighteen.setCharacterSpacing(charSpacing);
							cosEighteen.showText(line);
							cosEighteen.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 776 && lineCount <= 816) {
						if (line.startsWith("<b>")) {
							cosNineteen.setFont(pdfFontBold, fontSize);
							cosNineteen.setCharacterSpacing(charSpacing);
							cosNineteen.showText(line.replace("<b>", ""));
							cosNineteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("          " + line.replace("<op>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op1>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("                    " + line.replace("<op1>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else {
							cosNineteen.setFont(pdfFont, fontSize);
							cosNineteen.setCharacterSpacing(charSpacing);
							cosNineteen.showText(line);
							cosNineteen.newLineAtOffset(0, -leading);
						}
					} else if (lineCount >= 816 && lineCount <= 856) {
						if (line.startsWith("<b>")) {
							cosTwenty.setFont(pdfFontBold, fontSize);
							cosTwenty.setCharacterSpacing(charSpacing);
							cosTwenty.showText(line.replace("<b>", ""));
							cosTwenty.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("          " + line.replace("<op>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<op1>")) {
							cosFifteen.setFont(pdfFont, fontSize);
							cosFifteen.setCharacterSpacing(charSpacing);
							cosFifteen.showText("                    " + line.replace("<op1>", ""));
							cosFifteen.newLineAtOffset(0, -leading);
						} else {
							cosTwenty.setFont(pdfFont, fontSize);
							cosTwenty.setCharacterSpacing(charSpacing);
							cosTwenty.showText(line);
							cosTwenty.newLineAtOffset(0, -leading);
						}
					} else if (lineCount <= 35) {
						logger.info(lineCount);
						if (line.startsWith("<b>")) {
							cos.setFont(pdfFontBold, fontSize);
							cos.setCharacterSpacing(charSpacing);
							String boldLine = line.replace("<b>", "");
							cos.showText(boldLine);
							cos.newLineAtOffset(0, -leading);
						} else if (line.startsWith("<bCenter>")) {
							cos.setFont(pdfFontBold, fontSize);
							cos.setCharacterSpacing(charSpacing);
							cos.showText("                                        " + line.replace("<bCenter>", ""));
							cos.newLineAtOffset(0, -leading);
						} else {
							cos.setFont(pdfFont, fontSize);
							cos.setCharacterSpacing(charSpacing);
							cos.showText(line);
							cos.newLineAtOffset(0, -leading);
						}
					}
				}

				// logger.info("splited string" + strings);
			} // 12 to 15 cosEleven to cosFourteen

			// Gross Salary Table
			PDFont fontBold = PDType1Font.HELVETICA_BOLD;
			boolean drawContent = true;
			cosEleven.setFont(fontBold, fontSize);
			cosEleven.showText("GROSS SALARY SHEET");
			cosEleven.newLineAtOffset(250, 0);
			cosEleven.showText("Annexure 1");

			BaseTable table = new BaseTable(700, 752, 5, 500, 50, doc, pageTwelve, true, drawContent);

			// row height
			Row<PDPage> headerRow = table.createRow(20);
			// cell width
			Cell<PDPage> cell = headerRow.createCell(20, "Name");
			cell.setFont(fontBold);
			cell.setFontSize(12);
			cell = headerRow.createCell(80, offerModel.getFirstname() + " " + offerModel.getLastname());
			cell.setFontSize(12);
			table.addHeaderRow(headerRow);

			Row<PDPage> row = table.createRow(20);
			cell = row.createCell(20, "Designation");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(80, offerModel.getDesignation());
			cell.setFontSize(12);

			row = table.createRow(20);
			cell = row.createCell(20, "Grade");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20, offerModel.getGrade());
			cell.setFontSize(12);
			cell = row.createCell(40, "Relevant Experience");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20, offerModel.getRelExp());
			cell.setFontSize(12);

			table.draw();
			cosEleven.setFont(fontBold, fontSize);
			cosEleven.newLineAtOffset(50.0f, 680.0f);
			cosEleven.showText("Table 1: Compensation Details: (All Components are in Rs.)");
			BaseTable compensationTable = new BaseTable(570, 500, 5, 500, 50, doc, pageTwelve, true, drawContent);
			headerRow = compensationTable.createRow(20);

			NumberFormat myFormat = NumberFormat.getInstance();
			myFormat.setGroupingUsed(true);

			cell = headerRow.createCell(60, "Component Category");
			cell.setFont(fontBold);
			cell.setFillColor(Color.LIGHT_GRAY);
			cell.setFontSize(12);
			cell = headerRow.createCell(20, "Monthly");
			cell.setFont(fontBold);
			cell.setFillColor(Color.LIGHT_GRAY);
			cell.setFontSize(12);
			cell = headerRow.createCell(20, "Annual");
			cell.setFont(fontBold);
			cell.setFontSize(12);
			cell.setFillColor(Color.LIGHT_GRAY);
			compensationTable.addHeaderRow(headerRow);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "1) Fixed Compensation");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell.setFillColor(Color.LIGHT_GRAY);
			cell = row.createCell(20, "");
			cell.setFontSize(12);
			cell = row.createCell(20, "");

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "Basic Monthly");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBasic()[0])));
			cell.setFontSize(12);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBasic()[1])));
			cell.setFontSize(12);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "Bouquet Of Benefits #");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBob()[0])));
			cell.setFontSize(12);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBob()[1])));
			cell.setFontSize(12);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "2) Performance Pay");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell.setFillColor(Color.LIGHT_GRAY);
			cell = row.createCell(20, "");
			cell.setFontSize(12);
			cell = row.createCell(20, "");

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "Monthly Performance Pay");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getMva()[0])));
			cell.setFontSize(12);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getMva()[1])));
			cell.setFontSize(12);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "Performance Bonus *");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getQva()[0])));
			cell.setFontSize(12);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getQva()[1])));
			cell.setFontSize(12);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "3) City Allowance");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell.setFillColor(Color.LIGHT_GRAY);
			cell = row.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCityAllowance()[0])));
			cell.setFontSize(12);
			cell = row.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCityAllowance()[1])));
			cell.setFontSize(12);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "4) Annual Components/Retirals");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell.setFillColor(Color.LIGHT_GRAY);
			cell = row.createCell(20, "");
			cell.setFontSize(12);
			cell = row.createCell(20, "");

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "Health Insurance");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20, "NA");
			cell.setFontSize(12);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHis3())));
			cell.setFontSize(12);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "Provident fund");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPf()[0])));
			cell.setFontSize(12);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPf()[1])));
			cell.setFontSize(12);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "Gratuity");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getGratuity()[0])));
			cell.setFontSize(12);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getGratuity()[1])));
			cell.setFontSize(12);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "Total of Annual Components & Retirals");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getAnnualRetirals()[0])));
			cell.setFontSize(12);
			cell = row.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getAnnualRetirals()[1])));
			cell.setFontSize(12);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "Retention Incentive");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell = row.createCell(20, "NA");
			cell.setFontSize(12);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getRetInc())));
			cell.setFontSize(12);

			row = compensationTable.createRow(15);
			cell = row.createCell(60, "TOTAL GROSS");
			cell.setFontSize(12);
			cell.setFont(fontBold);
			cell.setFillColor(Color.LIGHT_GRAY);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCtc()[0])));
			cell.setFontSize(12);
			cell = row.createCell(20, DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getCtc()[1])));
			cell.setFontSize(12);
			String bobContent = "# Refer to Table 2 for TCSL defined Structure" + "<br>" + "<br>"
					+ "In case, you wish not to opt for the BoB, Defined Structure as given in Table 2 will be applicable."
					+ "<br>" + "<br>" + "* Amount depicted will be paid-out on a quarterly basis" + "<br>" + "<br>"
					+ "";
			TableHelper.drawInnerTable(680, 10, 100, 600, 50, doc, pageThirteen, false, true, 5, 80, bobContent,
					pdfFont, 10, Color.BLACK);
			cosTwelve.beginText();
			cosTwelve.setFont(fontBold, fontSize);
			cosTwelve.newLineAtOffset(50.0f, 550.0f); // change 2nd value(680) to move up and down
			cosTwelve.showText("Table 2: TCSL defined structure for BoB (All Components in Rs.)");
			cosTwelve.endText();

			BaseTable bobTable = new BaseTable(520, 742, 5, 500, 50, doc, pageThirteen, true, drawContent);// change
																											// this
																											// pageSixteen
																											// if
																											// tables is
																											// not
																											// in
																											// expected
																											// page
			Row<PDPage> headerRowThree;
			Cell<PDPage> cellThree;

			headerRowThree = bobTable.createRow(20);
			headerRowThree = bobTable.createRow(20);
			cellThree = headerRowThree.createCell(60, "Component Category");
			cellThree.setFont(fontBold);
			cellThree.setFillColor(Color.LIGHT_GRAY);
			cellThree.setFontSize(12);
			cellThree = headerRowThree.createCell(20, "Monthly");
			cellThree.setFont(fontBold);
			cellThree.setFillColor(Color.LIGHT_GRAY);
			cellThree.setFontSize(12);
			cellThree = headerRowThree.createCell(20, "Annual");
			cellThree.setFont(fontBold);
			cellThree.setFontSize(12);
			cellThree.setFillColor(Color.LIGHT_GRAY);
			bobTable.addHeaderRow(headerRowThree);

			Row<PDPage> rowFour = bobTable.createRow(15);
			cellThree = rowFour.createCell(60, "House Rent Allowance");
			cellThree.setFontSize(12);
			cellThree.setFont(fontBold);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHra()[0])));// review
			cellThree.setFontSize(12);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getHra()[1])));
			cellThree.setFontSize(12);

			rowFour = bobTable.createRow(15);
			cellThree = rowFour.createCell(60, "Leave Travel Assistance");
			cellThree.setFontSize(12);
			cellThree.setFont(fontBold);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getLta()[0])));
			cellThree.setFontSize(12);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getLta()[1])));
			cellThree.setFontSize(12);

			rowFour = bobTable.createRow(15);
			cellThree = rowFour.createCell(60, "Food Card");
			cellThree.setFontSize(12);
			cellThree.setFont(fontBold);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFoodCoupons()[0])));
			cellThree.setFontSize(12);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getFoodCoupons()[1])));
			cellThree.setFontSize(12);

			rowFour = bobTable.createRow(15);
			cellThree = rowFour.createCell(60, "Vehicle Maintenance Allowance");
			cellThree.setFontSize(12);
			cellThree.setFont(fontBold);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getVehicle()[0])));
			cellThree.setFontSize(12);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getVehicle()[1])));
			cellThree.setFontSize(12);

			rowFour = bobTable.createRow(15);
			cellThree = rowFour.createCell(60, "Personal Allowance");
			cellThree.setFontSize(12);
			cellThree.setFont(fontBold);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPerAllo()[0])));
			cellThree.setFontSize(12);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getPerAllo()[1])));
			cellThree.setFontSize(12);

			rowFour = bobTable.createRow(15);
			cellThree = rowFour.createCell(60, "GROSS BOUQUET OF BENEFITS");
			cellThree.setFontSize(12);
			cellThree.setFont(fontBold);
			cellThree.setFillColor(Color.LIGHT_GRAY);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBob()[0])));
			cellThree.setFontSize(12);
			cellThree = rowFour.createCell(20,
					DateHelper.getIndianCurrencyFormat(String.valueOf(offerModel.getBob()[1])));
			cellThree.setFontSize(12);

			bobTable.draw();

			compensationTable.draw();
			PDFont fontNormal = PDType1Font.HELVETICA;
			// logger.info("Class Loader path::::" +
			// classLoader.getResource("font/Verdana.ttf").getPath());
			// String font = classLoader.getResource("font/Verdana.ttf").getPath();
			PDFont fontVerdana = PDTrueTypeFont.loadTTF(doc, new File("src/main/resources/font/Verdana.ttf"));
			Color greyColor = TableHelper.getColorForValue(500, 1000, false, 100, 1000, Color.lightGray, Color.white);
			String titleName = "Document Submission - Annexure 2";
			int headingFontSize = 14;
			cosThirteen.beginText();
			cosThirteen.setFont(fontBold, headingFontSize);
			cosThirteen.newLineAtOffset(160, 1010); // change 2nd value to move up and down
			cosThirteen.setLeading(300.0f);
			cosThirteen.newLine();
			cosThirteen.showText(titleName);

			cosThirteen.setLeading(20.0f);
			cosThirteen.newLine();
			cosThirteen.setFont(fontNormal, 12);
			cosThirteen.moveTextPositionByAmount(50, 0);
			cosThirteen.showText("List of Joining Documents");
			cosThirteen.endText();

			// float margin = 50;
			float yStartNewPage = pageFourteen.getMediaBox().getHeight() - (2 * margin);
			float tableWidth = pageFourteen.getMediaBox().getWidth() - (2 * margin);
			// boolean drawContent = true;
			float bottomMargin = 5;
			float yPosition = 680;

			BaseTable outerTable = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, doc,
					pageFourteen, true, drawContent);

			Row<PDPage> headerrowOne = outerTable.createRow(270);
			Cell<PDPage> cellOne = headerrowOne.createCell(100, "");
			cell.setFontSize(10);
			cell.setFillColor(greyColor);

			outerTable.addHeaderRow(headerRow);
			outerTable.draw();

			TableHelper.drawInnerTable(680, 10, 100, 80, 50, doc, pageFourteen, false, true, 5, 80, "Joining:",
					fontBold, 10, Color.RED);
			TableHelper.drawInnerTable(665, 10, 100, 600, 50, doc, pageFourteen, false, true, 5, 80,
					"1. Birth Certificate", fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(650, 10, 100, 800, 50, doc, pageFourteen, false, true, 5, 80,
					"2. Standard Xth and XII the mark sheets / equivalents", fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(635, 10, 100, 800, 50, doc, pageFourteen, false, true, 5, 80,
					"3. Degree certificate and mark sheets for all semesters", fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(620, 10, 100, 800, 50, doc, pageFourteen, false, true, 5, 80,
					"4. Postgraduate Degree certificate and mark sheets for all semesters", fontNormal, 10,
					Color.BLACK);
			TableHelper.drawInnerTable(605, 10, 100, 800, 50, doc, pageFourteen, false, true, 5, 80,
					"5. Passport / Driving License / Ration Card", fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(590, 10, 100, 800, 50, doc, pageFourteen, false, true, 5, 80,
					"6. Experience certificate from previous employers indicating the following: ", fontNormal, 10,
					Color.BLACK);
			TableHelper.drawInnerTable(575, 10, 100, 800, 60, doc, pageFourteen, false, true, 5, 80,
					"(i). Period of employment", fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(560, 10, 100, 800, 60, doc, pageFourteen, false, true, 5, 80,
					"(ii). Certificates for any training provided by your previous employers in various technologies",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(545, 10, 100, 800, 60, doc, pageFourteen, false, true, 5, 80,
					"(iii). Release letter and experience letter from current and all previous employers indicating date of release",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(530, 10, 100, 800, 50, doc, pageFourteen, false, true, 5, 80, "7. PAN card",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(515, 10, 100, 800, 50, doc, pageFourteen, false, true, 5, 80,
					"8. Work permit or any other documentation required to take up permanent employment with TCSL",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(500, 10, 100, 800, 50, doc, pageFourteen, false, true, 5, 80,
					"9. Two passport size photographs", fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(485, 10, 100, 800, 50, doc, pageFourteen, false, true, 5, 80,
					"10. An affidavit/notarized undertaking that there is no criminal offence registered/pending against you",
					fontNormal, 10, Color.RED);
			TableHelper.drawInnerTable(470, 10, 100, 800, 50, doc, pageFourteen, false, true, 5, 80, "11. Aadhar Card",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(455, 10, 100, 600, 50, doc, pageFourteen, false, true, 5, 80,
					"12. Self-attested copy of offer letter along with Confidentiality, Data and Intellectual Property Protection (Annexure 4) to be shared with the HR team on the date of joining, which shall be considered as a proof of acceptance of the offer",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(390, 10, 100, 600, 50, doc, pageFourteen, false, true, 5, 80,
					"Please mention your EP Reference number on all the documents and also carry originals of the joining documents for verification on your date of joining.",
					fontNormal, 10, Color.BLACK);
			PDFont fontItalic = PDType1Font.HELVETICA_OBLIQUE;
			PDFont fontMono = PDType1Font.COURIER;

			Color tableBlueColor = TableHelper.getColorForValue(100, 1000, false, 2000, 1600, Color.RED, Color.GREEN);
			String titleName1 = "Regional Offices - Annexure 3";
			PDFont customFont = PDTrueTypeFont.loadTTF(doc, new File("src/main/resources/font/Verdana.ttf")); // to load
																												// custom
																												// font
			cosThirteen.beginText();
			cosThirteen.setFont(fontBold, fontSize);
			cosThirteen.newLineAtOffset(160, 610); // change 2nd value to move up and down
			cosThirteen.setLeading(300.0f);
			cosThirteen.newLine();
			cosThirteen.showText(titleName1);
			cosThirteen.endText();
			float yPosition1 = 300;
			BaseTable table1 = new BaseTable(yPosition1, yStartNewPage, bottomMargin, tableWidth, margin, doc,
					pageFourteen, true, drawContent);
			// Chennai
			Row<PDPage> rowOne;
			Cell<PDPage> cellTwo;

			rowOne = table1.createRow(100);
			rowOne.createCell(33, "");
			rowOne.createCell(33, "");
			rowOne.createCell(34, "");

			// spoc
			rowOne = table1.createRow(20);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(34, "");
			cellTwo.setFillColor(Color.lightGray);
			// joining
			rowOne = table1.createRow(27);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(34, "");
			cellTwo.setFillColor(Color.lightGray);
			// BGC
			rowOne = table1.createRow(27);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(34, "");
			cellTwo.setFillColor(Color.lightGray);
			table1.draw();

			TableHelper.drawInnerTable(300, 10, 100, 600, 49, doc, pageFourteen, false, true, 5, 80, "Chennai",
					fontBold, 10, Color.BLUE);
			String chennai = "TATA Consultancy Services Ltd," + "<br>" + "A1 Module, 415/21-24, Kumaran " + "<br>"
					+ "Nagar, Sholinganallur, Old" + "<br>" + "Mahabalipuram," + "<br>" + "Chennai 600 119" + "<br>"
					+ "Tel: 044-66162209";

			String delhi = "Tata Consultancy Services Ltd," + "<br>" + "5th Floor, PTI Building," + "<br>"
					+ "4, Parliament Street," + "<br>" + "New Delhi 110 001" + "<br>" + "Tel: 011-66506283";
			String hyderabad = "Tata Consultancy Services Ltd," + "<br>" + "Deccan Park No.1," + "<br>"
					+ "Software Units Layout," + "<br>" + "Madhapur, Hyderabad 500 081" + "<br>" + "Tel: 040-66673510";
			TableHelper.drawInnerTable(300, 10, 100, 600, 210, doc, pageFourteen, false, true, 5, 80, "Delhi", fontBold,
					10, Color.BLUE);

			TableHelper.drawInnerTable(300, 10, 100, 600, 375, doc, pageFourteen, false, true, 5, 80, "Hyderabad",
					fontBold, 10, Color.BLUE);
			TableHelper.drawInnerTable(290, 10, 100, 600, 49, doc, pageFourteen, false, true, 5, 80, chennai,
					customFont, 9, Color.BLACK);

			TableHelper.drawInnerTable(290, 10, 100, 600, 210, doc, pageFourteen, false, true, 5, 80, delhi, customFont,
					10, Color.BLACK);
			TableHelper.drawInnerTable(290, 10, 100, 600, 375, doc, pageFourteen, false, true, 5, 80, hyderabad,
					customFont, 10, Color.BLACK);

			// SPOC
			TableHelper.drawInnerTable(200, 10, 100, 600, 50, doc, pageFourteen, false, true, 5, 80, "SPOC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(200, 10, 100, 600, 85, doc, pageFourteen, false, true, 5, 80,
					"Vaishnavi Mahadevan", fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(200, 10, 100, 600, 210, doc, pageFourteen, false, true, 5, 80, "SPOC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(200, 10, 100, 600, 245, doc, pageFourteen, false, true, 5, 80, "Vinaya Sandhu",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(200, 10, 100, 600, 375, doc, pageFourteen, false, true, 5, 80, "SPOC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(200, 10, 100, 600, 415, doc, pageFourteen, false, true, 5, 80, "Priyanka Kumar",
					fontNormal, 10, Color.BLACK);

			TableHelper.drawInnerTable(180, 10, 100, 600, 50, doc, pageFourteen, false, true, 5, 80, "Joining:",
					fontBold, 10, Color.BLACK);
			TableHelper.drawInnerTable(180, 10, 100, 600, 210, doc, pageFourteen, false, true, 5, 80, "Joining:",
					fontBold, 10, Color.BLACK);
			TableHelper.drawInnerTable(180, 10, 100, 600, 375, doc, pageFourteen, false, true, 5, 80, "Joining:",
					fontBold, 10, Color.BLACK);
			TableHelper.drawInnerTable(180, 10, 100, 600, 50, doc, pageFourteen, false, true, 5, 80,
					"<br>" + "vaishnavi.mahadevan@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(180, 10, 100, 600, 210, doc, pageFourteen, false, true, 5, 80,
					"<br>" + "vinaya.sandhu@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(180, 10, 100, 600, 375, doc, pageFourteen, false, true, 5, 80,
					"<br>" + "kumar.priyanka@tcs.com", fontNormal, 10, Color.BLUE);

			TableHelper.drawInnerTable(155, 10, 100, 600, 50, doc, pageFourteen, false, true, 5, 80, "BGC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(155, 10, 100, 600, 210, doc, pageFourteen, false, true, 5, 80, "BGC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(155, 10, 100, 600, 375, doc, pageFourteen, false, true, 5, 80, "BGC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(155, 10, 100, 600, 50, doc, pageFourteen, false, true, 5, 80,
					"<br>" + "chennai.hrtabgc@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(155, 10, 100, 600, 210, doc, pageFourteen, false, true, 5, 80,
					"<br>" + "delhi.bgc@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(155, 10, 100, 600, 375, doc, pageFourteen, false, true, 5, 80,
					"<br>" + "hyderabad.hrtabgc@tcs.com", fontNormal, 10, Color.BLUE);

			// kochi
			String kochi = "TATA Consultancy Services Ltd," + "<br>" + "Infopark PO," + "<br>" + "Kochi - 682042,Kerala"
					+ "<br>" + "Tel: 0484-6187117";
			String kolkata = "Tata Consultancy Services Ltd," + "<br>" + "ODC 1-K-1, Gitanjali Park," + "<br>"
					+ "IT/ITES SEZ, Plot- IIF / 3," + "<br>" + "Action Area - II, New Town" + "<br>"
					+ "Calcutta - 700156,West Bengal" + "<br>" + "Tel: 033-66537137";
			String lucknow = "Tata Consultancy Services Ltd," + "<br>" + "TCS Awadh Park, Vibhuti Khand," + "<br>"
					+ "Gomti Nagar" + "<br>" + "Lucknow 226 010" + "<br>" + "Tel: 0522-6661135";
			float yPosition11 = 680;
			// new page
			BaseTable secondTable = new BaseTable(yPosition11, yStartNewPage, bottomMargin, tableWidth, margin, doc,
					pageFifteen, true, drawContent);
			// Kochi
			rowOne = secondTable.createRow(100);
			cellTwo = rowOne.createCell(33, "");
			cellTwo = rowOne.createCell(33, "");
			cellTwo = rowOne.createCell(34, "");

			rowOne = secondTable.createRow(25);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(34, "");
			cellTwo.setFillColor(Color.lightGray);

			rowOne = secondTable.createRow(25);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(34, "");
			cellTwo.setFillColor(Color.lightGray);

			rowOne = secondTable.createRow(25);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(34, "");
			cellTwo.setFillColor(Color.lightGray);

			// Ahemadabad
			rowOne = secondTable.createRow(100);
			rowOne.createCell(33, "");
			rowOne.createCell(33, "");
			rowOne.createCell(34, "");
			// spoc
			rowOne = secondTable.createRow(20);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(greyColor);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(greyColor);
			cellTwo = rowOne.createCell(34, "");
			cellTwo.setFillColor(greyColor);
			// Joining
			rowOne = secondTable.createRow(25);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);

			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);

			cellTwo = rowOne.createCell(34, "");
			cellTwo.setFillColor(Color.lightGray);
			// BGC
			rowOne = secondTable.createRow(25);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(33, "");
			cellTwo.setFillColor(Color.lightGray);
			cellTwo = rowOne.createCell(34, "");
			cellTwo.setFillColor(Color.lightGray);

			secondTable.draw();

			// second page cells
			TableHelper.drawInnerTable(500, 10, 100, 600, 49, doc, pageFifteen, false, true, 5, 80, "Kochi", fontBold,
					10, Color.BLUE);
			TableHelper.drawInnerTable(500, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80, "Kolkata",
					fontBold, 10, Color.BLUE);
			TableHelper.drawInnerTable(500, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80, "Lucknow",
					fontBold, 10, Color.BLUE);
			TableHelper.drawInnerTable(490, 10, 100, 600, 49, doc, pageFifteen, false, true, 5, 80, kochi, customFont,
					9, Color.BLACK);
			TableHelper.drawInnerTable(490, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80, kolkata,
					customFont, 10, Color.BLACK);
			TableHelper.drawInnerTable(490, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80, lucknow,
					customFont, 10, Color.BLACK);

			// spoc
			TableHelper.drawInnerTable(410, 10, 100, 600, 50, doc, pageFifteen, false, true, 5, 80, "SPOC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(410, 10, 100, 600, 85, doc, pageFifteen, false, true, 5, 80, "Anju Dinesh",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(410, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80, "SPOC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(410, 10, 100, 600, 245, doc, pageFifteen, false, true, 5, 80, "Swathi Yadav",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(410, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80, "SPOC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(410, 10, 100, 600, 415, doc, pageFifteen, false, true, 5, 80, "Vinaya Sandhu",
					fontNormal, 10, Color.BLACK);

			TableHelper.drawInnerTable(385, 10, 100, 600, 50, doc, pageFifteen, false, true, 5, 80, "Joining:",
					fontBold, 10, Color.BLACK);
			TableHelper.drawInnerTable(385, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80, "Joining:",
					fontBold, 10, Color.BLACK);
			TableHelper.drawInnerTable(385, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80, "Joining:",
					fontBold, 10, Color.BLACK);
			TableHelper.drawInnerTable(385, 10, 100, 600, 50, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "anju.dinesh@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(385, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "yadav.swathi@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(385, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "vinaya.sandhu@tcs.com", fontNormal, 10, Color.BLUE);

			TableHelper.drawInnerTable(360, 10, 100, 600, 50, doc, pageFifteen, false, true, 5, 80, "BGC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(360, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80, "BGC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(360, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80, "BGC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(360, 10, 100, 600, 50, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "nandini.shreeg@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(360, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "kolkata.hrtabgc@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(360, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "lucknow.hrtabgc@tcs.com", fontNormal, 10, Color.BLUE);

			String mumbai = "<br>" + "TATA Consultancy Services Ltd," + "<br>" + "Atithi Building, Yantra Park,"
					+ "<br>" + "Pokhran Road No. 2," + "<br>" + "Subhash Nagar," + "<br>" + "Thane West 400601" + "<br>"
					+ "Tel: 022-67782616";

			String pune = "<br>" + "TATA Consultancy Services Ltd," + "<br>" + "Plot No. 2 & 3, MIDC-SEZ," + "<br>"
					+ "Rajiv Gandhi Infotech Park," + "<br>" + "Hinjewadi Phase III," + "<br>" + "Pune 411 057" + "<br>"
					+ "Tel:  020-67943058";
			String thiruvananthapuram = "<br>" + "Tata Consultancy Services Ltd," + "<br>" + "Peepul Park, Technopark"
					+ "<br>" + "Campus," + "<br>" + "Kariyavattom P.O." + "<br>" + "Thiruvananthapuram 695 581" + "<br>"
					+ "Tel: 0471-6624569";
			TableHelper.drawInnerTable(680, 10, 100, 600, 49, doc, pageFifteen, false, true, 5, 80, "Mumbai", fontBold,
					10, Color.BLUE);
			TableHelper.drawInnerTable(680, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80, "Pune", fontBold,
					10, Color.BLUE);
			TableHelper.drawInnerTable(680, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80,
					"Thiruvananthapuram", fontBold, 10, Color.BLUE);
			TableHelper.drawInnerTable(680, 10, 100, 600, 49, doc, pageFifteen, false, true, 5, 80, mumbai, customFont,
					9, Color.BLACK);
			TableHelper.drawInnerTable(680, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80, pune, customFont,
					10, Color.BLACK);
			TableHelper.drawInnerTable(680, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80, thiruvananthapuram,
					customFont, 10, Color.BLACK);

			TableHelper.drawInnerTable(582, 10, 100, 600, 50, doc, pageFifteen, false, true, 5, 80, "SPOC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(582, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80, "SPOC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(582, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80, "SPOC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(582, 10, 100, 600, 85, doc, pageFifteen, false, true, 5, 80, "Abhishek Shukla",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(582, 10, 100, 600, 245, doc, pageFifteen, false, true, 5, 80, "Venkatprasat Rb",
					fontNormal, 10, Color.BLACK);
			TableHelper.drawInnerTable(582, 10, 100, 600, 415, doc, pageFifteen, false, true, 5, 80, "Anju Dinesh",
					fontNormal, 10, Color.BLACK);

			TableHelper.drawInnerTable(557, 10, 100, 600, 50, doc, pageFifteen, false, true, 5, 80, "Joining:",
					fontBold, 10, Color.BLACK);
			TableHelper.drawInnerTable(557, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80, "Joining:",
					fontBold, 10, Color.BLACK);
			TableHelper.drawInnerTable(557, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80, "Joining:",
					fontBold, 10, Color.BLACK);
			TableHelper.drawInnerTable(557, 10, 100, 600, 50, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "abhishek1.shukla@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(557, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "venkatprasat.rb@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(557, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "anju.dinesh@tcs.com", fontNormal, 10, Color.BLUE);

			TableHelper.drawInnerTable(530, 10, 100, 600, 50, doc, pageFifteen, false, true, 5, 80, "BGC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(530, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80, "BGC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(530, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80, "BGC:", fontBold,
					10, Color.BLACK);
			TableHelper.drawInnerTable(530, 10, 100, 600, 50, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "mumbai.bgc@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(532, 10, 100, 600, 210, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "pune.hrtabgc@tcs.com", fontNormal, 10, Color.BLUE);
			TableHelper.drawInnerTable(530, 10, 100, 600, 375, doc, pageFifteen, false, true, 5, 80,
					"<br>" + "nandini.shreeg@tcs.com", fontNormal, 10, Color.BLUE);

			cos.endText();
			cosOne.endText();
			cosTwo.endText();
			cosThree.endText();
			cosFour.endText();
			cosFive.endText();
			cosSix.endText();
			cosSeven.endText();
			cosEight.endText();
			// cosNine.endText();
			// cosOne0.endText();
			cosEleven.endText();
			// cosTwelve.endText();
			// cosThirteen.endText();
			// cosFourteen.endText();
			cosFifteen.endText();
			cosSixteen.endText();
			cosSeventeen.endText();
			cosEighteen.endText();
			cosNineteen.endText();
			cosTwenty.endText();
			cos.close();
			cosOne.close();
			cosTwo.close();
			cosThree.close();
			cosFour.close();
			cosFive.close();
			cosSix.close();
			cosSeven.close();
			cosEight.close();
			// cosNine.close();
			cosEleven.close();
			cosTwelve.close();
			cosThirteen.close();
			cosFourteen.close();
			cosFifteen.close();
			cosSixteen.close();
			cosSeventeen.close();
			cosEighteen.close();
			cosNineteen.close();
			cosTwenty.close();
			doc.save("India Offer.pdf");

			doc.save(byteArrayOutputStream);
			doc.close();
			// document.close();

		} catch (IOException e) {
			logger.info("We had an error creating pdf document");
			// e.printStackTrace();
		}
		return byteArrayOutputStream.toByteArray();
	}

	public static byte[] offerUSPDFGen(String editedText, String address2) throws IOException {
		PDDocument doc = new PDDocument();
		PDPage pageOne = new PDPage(PDRectangle.A4);
		doc.addPage(pageOne);
		PDPageContentStream cos = null;
		String[] value = editedText.split("<br>");
		PDFont pdfFont = PDType1Font.HELVETICA;
		PDFont pdfFontBold = PDType1Font.HELVETICA_BOLD;
		float fontSize = 11;
		float leading = 1.5f * fontSize;
		float margin = 50;
		PDRectangle mediabox = pageOne.getMediaBox();
		float width = mediabox.getWidth() - 2 * margin;
		float startX = mediabox.getLowerLeftX() + margin;
		float startY = mediabox.getUpperRightY() - margin;
		PDPage pageTwo = new PDPage(PDRectangle.A4);
		// PDRectangle mediaBox = pageTwo.getMediaBox();
		doc.addPage(pageTwo);
		PDPageContentStream cosOne = new PDPageContentStream(doc, pageTwo);
		PDPage pageThree = new PDPage(PDRectangle.A4);
		// PDRectangle mediaBox = pageTwo.getMediaBox();
		doc.addPage(pageThree);
		PDPage pageFour = new PDPage(PDRectangle.A4);
		// PDRectangle mediaBox = pageTwo.getMediaBox();
		doc.addPage(pageFour);
		PDPageContentStream cosTwo = new PDPageContentStream(doc, pageThree);
		PDPageContentStream cosThree = new PDPageContentStream(doc, pageFour);
		// PDPageContentStream cosFour = new PDPageContentStream(doc, pageFour);
		cos = new PDPageContentStream(doc, pageOne);

		// ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		// logger.info("Class Loader path::::" +
		// classLoader.getResource("images/image.jpg").getPath());
		// String pathImage = classLoader.getResource("images/image.jpg").getPath();
		// String pathFooter =
		// classLoader.getResource("images/footer_us.PNG").getPath();
		// String pathSignature =
		// classLoader.getResource("images/signature-us.png").getPath();

		// PDImageXObject pdImage =
		// PDImageXObject.createFromFile(pathImage.replaceAll("%20", " "), doc);

		// PDImageXObject pdFooterImage =
		// PDImageXObject.createFromFile(pathFooter.replaceAll("%20", " "), doc);
		PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/images/image.jpg", doc);
		PDImageXObject pdFooterImage = PDImageXObject.createFromFile("src/main/resources/images/footer_us.PNG", doc);
		cos.drawXObject(pdImage, 245, 750, 70, 70);
		cos.drawXObject(pdFooterImage, 220, 5, 120, 75);
		cosOne.drawXObject(pdImage, 245, 750, 70, 70);
		cosOne.drawXObject(pdFooterImage, 220, 5, 120, 75);
		cosTwo.drawXObject(pdImage, 245, 750, 70, 70);
		cosTwo.drawXObject(pdFooterImage, 220, 5, 120, 75);
		cosThree.drawXObject(pdImage, 245, 750, 70, 70);
		cosThree.drawXObject(pdFooterImage, 220, 5, 120, 75);
		PDImageXObject signatureUS = PDImageXObject.createFromFile("src/main/resources/images/signature-us.png", doc);
		// PDImageXObject signatureUS =
		// PDImageXObject.createFromFile(pathSignature.replaceAll("%20", " "), doc);
		logger.info("Us Signature");
		if (!address2.trim().isEmpty())
			cosThree.drawXObject(signatureUS, 50, 310, 85, 85);
		else
			cosThree.drawXObject(signatureUS, 50, 325, 85, 85);
		logger.info("Us Signature1");
		cos.beginText();
		// cos.setFont(pdfFont, fontSize);
		cos.newLineAtOffset(startX, startY);
		cos.moveTextPositionByAmount(10, -40);
		cosOne.beginText();
		// cosOne.setFont(pdfFont, fontSize);
		cosOne.newLineAtOffset(startX, startY);
		cosOne.moveTextPositionByAmount(10, -60);
		cosTwo.beginText();
		// cosTwo.setFont(pdfFont, fontSize);
		cosTwo.newLineAtOffset(startX, startY);
		cosTwo.moveTextPositionByAmount(10, -60);
		cosThree.beginText();
		// cosThree.setFont(pdfFont, fontSize);
		cosThree.newLineAtOffset(startX, startY);
		cosThree.moveTextPositionByAmount(10, -60);
		// cosFour.beginText();
		// cosFour.setFont(pdfFont, fontSize);

		long lineCount = 0;
		for (String strings : value) {
			List<String> lines = new ArrayList<String>();

			int lastSpace = -1;
			while (strings.length() > 0) {
				int spaceIndex = strings.indexOf(' ', lastSpace + 1);
				if (spaceIndex < 0)
					spaceIndex = strings.length();
				String subString = strings.substring(0, spaceIndex);
				float size = fontSize * pdfFont.getStringWidth(subString) / 1000;
				// System.out.printf("'%s' - %f of %f\n", subString, size, width);
				if (size > width) {
					if (lastSpace < 0)
						lastSpace = spaceIndex;
					subString = strings.substring(0, lastSpace);
					lines.add(subString);
					strings = strings.substring(lastSpace).trim();
					// System.out.printf("'%s' is line\n", subString);
					lastSpace = -1;
				} else if (spaceIndex == strings.length()) {
					lines.add(strings);
					System.out.printf("'%s' is line\n", strings);
					strings = "";
				} else {
					lastSpace = spaceIndex;
				}
			}

			for (String line : lines) {
				lineCount = lineCount + 1;
				logger.info("lineCount: " + lineCount);
				float charSpacing = 0;
				if (line.length() > 78) {
					float size = fontSize * pdfFont.getStringWidth(line) / 1000;
					float free = width - size;
					if (free > 0) {
						charSpacing = free / (line.length() - 1);
					}
				}

				if (lineCount >= 42 && lineCount <= 81) {
					logger.info("Line 43");
					// if(lineCount == 50 )
					if (line.startsWith("<b>")) {
						cosOne.setFont(pdfFontBold, fontSize);
						cosOne.setCharacterSpacing(charSpacing);
						cosOne.showText(line.replace("<b>", ""));
						cosOne.newLineAtOffset(0, -leading);
					} else {
						cosOne.setFont(pdfFont, fontSize);
						cosOne.setCharacterSpacing(charSpacing);
						cosOne.showText(line);
						cosOne.newLineAtOffset(0, -leading);
					}
				} else if (lineCount >= 81 && lineCount <= 121) {
					logger.info("Line 86");
					if (line.startsWith("<b>")) {
						cosTwo.setFont(pdfFontBold, fontSize);
						cosTwo.setCharacterSpacing(charSpacing);
						cosTwo.showText(line.replace("<b>", ""));
						cosTwo.newLineAtOffset(0, -leading);
					} else {
						cosTwo.setFont(pdfFont, fontSize);
						cosTwo.setCharacterSpacing(charSpacing);
						cosTwo.showText(line);
						cosTwo.newLineAtOffset(0, -leading);
					}
				} else if (lineCount >= 121) {
					logger.info("Line 125");
					if (line.startsWith("<b>")) {
						cosThree.setFont(pdfFontBold, fontSize);
						cosThree.setCharacterSpacing(charSpacing);
						cosThree.showText(line.replace("<b>", ""));
						cosThree.newLineAtOffset(0, -leading);
					} else {
						cosThree.setFont(pdfFont, fontSize);
						cosThree.setCharacterSpacing(charSpacing);
						cosThree.showText(line);
						cosThree.newLineAtOffset(0, -leading);
					}
				} else {
					if (line.startsWith("<b>")) {
						cos.setFont(pdfFontBold, fontSize);
						cos.setCharacterSpacing(charSpacing);
						cos.showText(line.replace("<b>", ""));
						cos.newLineAtOffset(0, -leading);
					} else {
						cos.setFont(pdfFont, fontSize);
						cos.setCharacterSpacing(charSpacing);
						cos.showText(line);
						cos.newLineAtOffset(0, -leading);
					}
				}
			}

			logger.info("splited string" + strings);
		}

		cos.endText();
		cosOne.endText();
		cosTwo.endText();
		cosThree.endText();
		// cosFour.endText();
		cos.close();
		cosOne.close();
		cosTwo.close();
		cosThree.close();
		// cosFour.close();
		doc.save("US Offer.pdf");

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		doc.save(byteArrayOutputStream);
		doc.close();

		return byteArrayOutputStream.toByteArray();

	}

	public static byte[] retentionPDFGen(String editedText) throws IOException {
		PDDocument doc = new PDDocument();
		PDPage pageOne = new PDPage(PDRectangle.A4);
		doc.addPage(pageOne);
		PDPageContentStream cos = null;
		String[] value = editedText.split("<br>");
		PDFont pdfFont = PDType1Font.HELVETICA;
		PDFont pdfFontBold = PDType1Font.HELVETICA_BOLD;
		float fontSize = 11;
		float leading = 1.5f * fontSize;
		float margin = 50;
		PDRectangle mediabox = pageOne.getMediaBox();
		float width = mediabox.getWidth() - 2 * margin;
		float startX = mediabox.getLowerLeftX() + margin;
		float startY = mediabox.getUpperRightY() - margin;
		PDPage pageTwo = new PDPage(PDRectangle.A4);
		// PDRectangle mediaBox = pageTwo.getMediaBox();
		doc.addPage(pageTwo);
		PDPageContentStream cosOne = new PDPageContentStream(doc, pageTwo);
		PDPage pageThree = new PDPage(PDRectangle.A4);
		// PDRectangle mediaBox = pageTwo.getMediaBox();
		doc.addPage(pageThree);
		PDPageContentStream cosTwo = new PDPageContentStream(doc, pageThree);
		cos = new PDPageContentStream(doc, pageOne);

		// ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		// logger.info("Class Loader path::::" +
		// classLoader.getResource("images/image.jpg").getPath());
		// String pathImage = classLoader.getResource("images/image.jpg").getPath();
		// String pathFooter =
		// classLoader.getResource("images/footer_us.PNG").getPath();

		// PDImageXObject pdImage =
		// PDImageXObject.createFromFile(pathImage.replaceAll("%20", " "), doc);

		// PDImageXObject pdFooterImage =
		// PDImageXObject.createFromFile(pathFooter.replaceAll("%20", " "), doc);
		PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/images/image.jpg", doc);
		PDImageXObject pdFooterImage = PDImageXObject.createFromFile("src/main/resources/images/footer_us.PNG", doc);
		cos.drawXObject(pdImage, 250, 750, 75, 75);
		cos.drawXObject(pdFooterImage, 210, 10, 160, 65);
		cosOne.drawXObject(pdImage, 250, 750, 75, 75);
		cosOne.drawXObject(pdFooterImage, 210, 10, 160, 65);
		cosTwo.drawXObject(pdImage, 250, 750, 75, 75);
		cosTwo.drawXObject(pdFooterImage, 210, 10, 160, 65);
		cos.beginText();
		// cos.setFont(pdfFont, fontSize);
		cos.newLineAtOffset(startX, startY);
		cos.moveTextPositionByAmount(10, -40);
		cosOne.beginText();
		// cosOne.setFont(pdfFont, fontSize);
		cosOne.newLineAtOffset(startX, startY);
		cosOne.moveTextPositionByAmount(10, -55);
		cosTwo.beginText();
		// cosTwo.setFont(pdfFont, fontSize);
		cosTwo.newLineAtOffset(startX, startY);
		cosTwo.moveTextPositionByAmount(10, -55);
		long lineCount = 0;
		for (String strings : value) {

			// cos.beginText();
			// cos.newLineAtOffset(200, 405);
			// cos.setFont(fontPlain, 11);
			// cos.showText(strings);
			List<String> lines = new ArrayList<String>();

			int lastSpace = -1;
			while (strings.length() > 0) {
				int spaceIndex = strings.indexOf(' ', lastSpace + 1);
				if (spaceIndex < 0)
					spaceIndex = strings.length();
				String subString = strings.substring(0, spaceIndex);
				float size = fontSize * pdfFont.getStringWidth(subString) / 1000;
				System.out.printf("'%s' - %f of %f\n", subString, size, width);
				if (size > width) {
					if (lastSpace < 0)
						lastSpace = spaceIndex;
					subString = strings.substring(0, lastSpace);
					lines.add(subString);
					strings = strings.substring(lastSpace).trim();
					System.out.printf("'%s' is line\n", subString);
					lastSpace = -1;
				} else if (spaceIndex == strings.length()) {
					lines.add(strings);
					System.out.printf("'%s' is line\n", strings);
					strings = "";
				} else {
					lastSpace = spaceIndex;
				}
			}

			for (String line : lines) {
				lineCount = lineCount + 1;
				logger.info("lineCount: " + lineCount);
				float charSpacing = 0;
				if (line.length() > 80) {
					float size = fontSize * pdfFont.getStringWidth(line) / 1000;
					float free = width - size;
					if (free > 0) {
						charSpacing = free / (line.length() - 1);
					}
				}
				if (lineCount >= 39 && lineCount <= 77) {
					logger.info("Line 43");
					// page = new PDPage();
					// doc.addPage(page);
					if (line.startsWith("<b>")) {
						cosOne.setFont(pdfFontBold, fontSize);
						cosOne.setCharacterSpacing(charSpacing);
						cosOne.showText(line.replace("<b>", ""));
						cosOne.newLineAtOffset(0, -leading);
					} else {
						cosOne.setFont(pdfFont, fontSize);
						cosOne.setCharacterSpacing(charSpacing);
						cosOne.showText(line);
						cosOne.newLineAtOffset(0, -leading);
					}
				} else if (lineCount >= 77) {
					logger.info("Line 86");
					// page = new PDPage();
					// doc.addPage(page);
					if (line.startsWith("<b>")) {
						cosTwo.setFont(pdfFontBold, fontSize);
						cosTwo.setCharacterSpacing(charSpacing);
						cosTwo.showText(line.replace("<b>", ""));
						cosTwo.newLineAtOffset(0, -leading);
					} else {
						cosTwo.setFont(pdfFont, fontSize);
						cosTwo.setCharacterSpacing(charSpacing);
						cosTwo.showText(line);
						cosTwo.newLineAtOffset(0, -leading);
					}
				} else {
					if (line.startsWith("<b>")) {
						cos.setFont(pdfFontBold, fontSize);
						cos.setCharacterSpacing(charSpacing);
						cos.showText(line.replace("<b>", ""));
						cos.newLineAtOffset(0, -leading);
					} else {
						cos.setFont(pdfFont, fontSize);
						cos.setCharacterSpacing(charSpacing);
						cos.showText(line);
						cos.newLineAtOffset(0, -leading);
					}
				}
			}

			logger.info("splited string" + strings);
		}
		cos.endText();
		cosOne.endText();
		cosTwo.endText();
		cos.close();
		cosOne.close();
		cosTwo.close();
		doc.save("Retention.pdf");

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		doc.save(byteArrayOutputStream);
		doc.close();

		return byteArrayOutputStream.toByteArray();
	}

	public static byte[] appointmentPDFGen(String editedText) throws IOException {
		PDDocument doc = new PDDocument();
		PDPage pageOne = new PDPage(PDRectangle.A4);
		doc.addPage(pageOne);
		PDPageContentStream cos = null;
		String[] value = editedText.split("<br>");
		PDFont pdfFont = PDType1Font.HELVETICA;
		PDFont pdfFontBold = PDType1Font.HELVETICA_BOLD;
		float fontSize = 11;
		float leading = 1.5f * fontSize;
		float margin = 50;
		PDRectangle mediabox = pageOne.getMediaBox();
		float width = mediabox.getWidth() - 2 * margin;
		float startX = mediabox.getLowerLeftX() + margin;
		float startY = mediabox.getUpperRightY() - margin;
		cos = new PDPageContentStream(doc, pageOne);

		// ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		// logger.info("Class Loader path::::" +
		// classLoader.getResource("images/image.jpg").getPath());
		// String pathImage = classLoader.getResource("images/image.jpg").getPath();
		// String pathFooter =
		// classLoader.getResource("images/footer_india.png").getPath();
		// String pathSignature =
		// classLoader.getResource("images/signature-india.jpg").getPath();

		// PDImageXObject pdImage =
		// PDImageXObject.createFromFile(pathImage.replaceAll("%20", " "), doc);
		// PDImageXObject pdFooterImage =
		// PDImageXObject.createFromFile(pathFooter.replaceAll("%20", " "), doc);
		PDImageXObject pdImage = PDImageXObject.createFromFile("src/main/resources/images/image.jpg", doc);
		PDImageXObject pdFooterImage = PDImageXObject.createFromFile("src/main/resources/images/footer_india.PNG", doc);
		cos.drawXObject(pdImage, 245, 750, 75, 75);
		cos.drawXObject(pdFooterImage, 200, 0, 240, 75);
		// PDImageXObject signatureIndia =
		// PDImageXObject.createFromFile(pathSignature.replaceAll("%20", " "), doc);
		PDImageXObject signatureIndia = PDImageXObject.createFromFile("src/main/resources/images/signature-india.JPG",
				doc);
		cos.drawXObject(signatureIndia, 70, 280, 65, 65);
		cos.beginText();
		// cos.setFont(pdfFont, fontSize);
		cos.newLineAtOffset(startX, startY);
		cos.moveTextPositionByAmount(10, 0);

		long lineCount = 0;
		for (String strings : value) {

			List<String> lines = new ArrayList<String>();

			int lastSpace = -1;
			while (strings.length() > 0) {
				int spaceIndex = strings.indexOf(' ', lastSpace + 1);
				if (spaceIndex < 0)
					spaceIndex = strings.length();
				String subString = strings.substring(0, spaceIndex);
				float size = fontSize * pdfFont.getStringWidth(subString) / 1000;
				System.out.printf("'%s' - %f of %f\n", subString, size, width);
				if (size > width) {
					if (lastSpace < 0)
						lastSpace = spaceIndex;
					subString = strings.substring(0, lastSpace);
					lines.add(subString);
					strings = strings.substring(lastSpace).trim();
					System.out.printf("'%s' is line\n", subString);
					lastSpace = -1;
				} else if (spaceIndex == strings.length()) {
					lines.add(strings);
					System.out.printf("'%s' is line\n", strings);
					strings = "";
				} else {
					lastSpace = spaceIndex;
				}
			}

			for (String line : lines) {
				lineCount = lineCount + 1;
				logger.info("lineCount: " + lineCount);
				float charSpacing = 0;
				if (line.length() > 78) {
					float size = fontSize * pdfFont.getStringWidth(line) / 1000;
					float free = width - size;
					if (free > 0) {
						charSpacing = free / (line.length() - 1);
					}
				}
				if (line.startsWith("<b>")) {
					cos.setFont(pdfFontBold, fontSize);
					cos.setCharacterSpacing(charSpacing);
					cos.showText(line.replace("<b>", ""));
					cos.newLineAtOffset(0, -leading);
				} else if (line.startsWith("<bCenter>")) {
					cos.setFont(pdfFontBold, fontSize);
					cos.setCharacterSpacing(charSpacing);
					cos.showText(
							"                                                    " + line.replace("<bCenter>", ""));
					cos.newLineAtOffset(0, -leading);
				} else {
					cos.setFont(pdfFont, fontSize);
					cos.setCharacterSpacing(charSpacing);
					cos.showText(line);
					cos.newLineAtOffset(0, -leading);
				}
			}

			logger.info("splited string" + strings);
		}
		cos.endText();
		cos.close();
		doc.save("Appointment.pdf");

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		doc.save(byteArrayOutputStream);
		doc.close();
		return byteArrayOutputStream.toByteArray();
	}

}