package com.insourcing.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.insourcing.config.CommonConstants;
import com.insourcing.entity.CandidateEntity;
import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.entity.USAFReportEntity;
import com.insourcing.entity.USEduEmpReportEntity;
import com.insourcing.model.ExcelModel;
import com.insourcing.model.IndiaReportModel;

public class ExcelHelper {

	private static Logger logger = LogManager.getLogger(ExcelHelper.class);
	
	@Value("${insource.app.india.date.format}")
	private static String indiaDateFormat;

	@Value("${insource.app.india.zone.id}")
	private static String indiaZoneId;
	
	// To check the uploaded excel format
	public static boolean hasExcelFormat(MultipartFile file) {

		if (!CommonConstants.TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	/* Download the data as Excel */
	public static ByteArrayInputStream entityToExcel(List<ExcelModel> exceldownload) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(CommonConstants.SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < CommonConstants.HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(CommonConstants.HEADERs[col]);
			}

			int rowIdx = 1;

			for (ExcelModel excel : exceldownload) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(excel.getFirstname());
				row.createCell(1).setCellValue(excel.getMiddlename());
				row.createCell(2).setCellValue(excel.getLastname());
				row.createCell(3).setCellValue(excel.getEmailid());
				row.createCell(4).setCellValue(excel.getCreatePassword());

			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	/*
	 * Method to extract the data from Spreadsheet and create random initial
	 * password
	 * 
	 * @Param input Excel file as InputStream
	 * 
	 * @Param output List of CandidateEntity object
	 */
	public static List<CandidateEntity> excelToEntity(InputStream is) throws NoSuchAlgorithmException {
		try {
			Workbook workbook = new XSSFWorkbook(is);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<CandidateEntity> excelUploadsEntity = new ArrayList<>();
			int totalRowCount = sheet.getLastRowNum();
			logger.info(totalRowCount);
			int rowNumber = 0;
			if (totalRowCount < 2000) {
				while (rows.hasNext()) {
					Row currentRow = rows.next();
					if (rowNumber == 0 || rowNumber == 1) { // skip header
						rowNumber++;
						continue;
					}
					CandidateEntity candidateEntity = new CandidateEntity();
					candidateEntity.setFirstname(
							currentRow.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					candidateEntity.setMiddlename(
							currentRow.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					candidateEntity.setLastname(
							currentRow.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					candidateEntity.setEmailid(
							currentRow.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					candidateEntity.setContactno(
							currentRow.getCell(4, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					candidateEntity.setCity(
							currentRow.getCell(5, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					candidateEntity.setCountry(
							currentRow.getCell(6, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					if (!candidateEntity.getCountry().isEmpty()) {
						candidateEntity.setPassword(genDefaultPwd());
					}
					candidateEntity.setDate(DateHelper.setCurrentDate("dd/MM/yyyy HH:mm:ss", "Asia/Kolkata"));
					excelUploadsEntity.add(candidateEntity);
				}
				workbook.close();
			} else {
				logger.info("More than 2000");
			}
			logger.info(excelUploadsEntity);
			return excelUploadsEntity;
		} catch (IOException e) {
			logger.error(String.format("Excel parsing error: %s", e));
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	public static String genDefaultPwd() {
		  int length=8;
	      String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$?";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[length];
	      String pwd;

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< length ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      pwd=toString(password); 
	     return pwd;
	   }
	
	public static String toString(char[] a) 
    { 
        String string = new String(a); 
        return string; 
    } 
	
	
	// Application Form Report from db to excel
	public static ByteArrayInputStream toexcelAFReport(List<USAFReportEntity> afreportlist) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(CommonConstants.SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < CommonConstants.AF_REPORT_HEADER.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(CommonConstants.AF_REPORT_HEADER[col]);
			}

			int rowIdx = 1;
			logger.info(afreportlist);
			for (USAFReportEntity excel : afreportlist) {
				Row row = sheet.createRow(rowIdx++);
				logger.info(excel.getAppCompletedDate());

				if (excel.getRefId() != null)
					row.createCell(0).setCellValue(excel.getRefId());
				else
					row.createCell(0).setCellValue(" ");
				if (excel.getMiddlename() != null)
					row.createCell(1).setCellValue(
							excel.getFirstname() + " " + excel.getMiddlename() + " " + excel.getLastname());
				else
					row.createCell(1).setCellValue(excel.getFirstname() + " " + excel.getLastname());
				if (excel.getEmailid() != null)
					row.createCell(2).setCellValue(excel.getEmailid());
				else
					row.createCell(2).setCellValue(" ");
				if (excel.getContactno() != null)
					row.createCell(3).setCellValue(excel.getContactno());
				else
					row.createCell(3).setCellValue(" ");
				if (excel.getApartmentUnit() != null && excel.getStreetAddress() != null && excel.getState() != null
						&& excel.getZipCode() != null)
					row.createCell(4).setCellValue(excel.getApartmentUnit() + ", " + excel.getStreetAddress() + ", "
							+ excel.getState() + " - " + excel.getZipCode());
				else if (excel.getApartmentUnit() != null && excel.getStreetAddress() != null
						&& excel.getState() != null)
					row.createCell(4).setCellValue(
							excel.getApartmentUnit() + ", " + excel.getStreetAddress() + ", " + excel.getState());
				else if (excel.getApartmentUnit() != null && excel.getStreetAddress() != null)
					row.createCell(4).setCellValue(excel.getApartmentUnit() + ", " + excel.getStreetAddress());
				else if (excel.getApartmentUnit() != null)
					row.createCell(4).setCellValue(excel.getApartmentUnit());
				else
					row.createCell(4).setCellValue(" ");
				if (excel.getOfferEmpExtDemWorkUS() != null)
					row.createCell(5).setCellValue(excel.getOfferEmpExtDemWorkUS());
				else
					row.createCell(5).setCellValue(" ");
				if (excel.getReqSponsorship() != null)
					row.createCell(6).setCellValue(excel.getReqSponsorship());
				else
					row.createCell(6).setCellValue(" ");
				if (excel.getAppflagapp() == true)
					row.createCell(7).setCellValue("Completed");
				else
					row.createCell(7).setCellValue("Not Completed");
				if (excel.getResumeStatus() != null)
					row.createCell(8).setCellValue(excel.getResumeStatus());
				else
					row.createCell(8).setCellValue(" ");
				if (excel.getTechProf() != null)
					row.createCell(9).setCellValue(excel.getTechProf());
				else
					row.createCell(9).setCellValue(" ");
				DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
				String strRegDate = dateFormat.format(excel.getRegCompletedDate());
				if (strRegDate != null)
					row.createCell(10).setCellValue(strRegDate);
				else
					row.createCell(10).setCellValue(" ");
				if (excel.getAppCompletedDate() != null) {
					String strAppDate = dateFormat.format(excel.getAppCompletedDate());
					row.createCell(11).setCellValue(strAppDate);
				} else
					row.createCell(11).setCellValue(" ");
				if (excel.getCurrentWorkLocation() != null)
					row.createCell(12).setCellValue(excel.getCurrentWorkLocation());
				else
					row.createCell(12).setCellValue(" ");

			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	// Education Employment Report from db to excel
	public static ByteArrayInputStream toexcelEduEmpReport(List<USEduEmpReportEntity> eduempreportlist) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(CommonConstants.SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < CommonConstants.EDU_EMP_REPORT_HEADER.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(CommonConstants.EDU_EMP_REPORT_HEADER[col]);
			}

			int rowIdx = 1;
			logger.info(eduempreportlist);
			for (USEduEmpReportEntity excel : eduempreportlist) {
				for (int i = 0; i < excel.getCom().length; i++) {
					Row row = sheet.createRow(rowIdx++);
					if (excel.getRefid() != null)
						row.createCell(0).setCellValue(excel.getRefid());
					else
						row.createCell(0).setCellValue(" ");
					if (excel.getMiddlename() != null)
						row.createCell(1).setCellValue(
								excel.getFirstname() + " " + excel.getMiddlename() + " " + excel.getLastname());
					else
						row.createCell(1).setCellValue(excel.getFirstname() + " " + excel.getLastname());
					if (excel.getDoctDegree() != null)
						row.createCell(2).setCellValue(excel.getDoctDegree());
					else if (excel.getMasterDegree() != null)
						row.createCell(2).setCellValue(excel.getMasterDegree());
					else if (excel.getBachDegree() != null)
						row.createCell(2).setCellValue(excel.getBachDegree());
					else if (excel.getAssDegree() != null)
						row.createCell(2).setCellValue(excel.getAssDegree());
					else
						row.createCell(2).setCellValue(" ");
					if (excel.getTotalExp() != null)
						row.createCell(3).setCellValue(excel.getTotalExp());
					else
						row.createCell(3).setCellValue(" ");
					if (excel.getRelExp() != null)
						row.createCell(4).setCellValue(excel.getRelExp());
					else
						row.createCell(4).setCellValue(" ");
					String[] strCom = excel.getCom();
					if (strCom[i] != null)
						row.createCell(5).setCellValue(strCom[i]);
					else
						row.createCell(5).setCellValue(" ");
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
					Date[] dateFrom = excel.getComFrom();
					String dateFrom1 = simpleDateFormat.format(dateFrom[i]);
					if (dateFrom1 != null)
						row.createCell(6).setCellValue(dateFrom1);
					else
						row.createCell(6).setCellValue(" ");
					Date[] dateTo = excel.getComTo();
					String dateTo1 = simpleDateFormat.format(dateTo[i]);
					if (dateTo1 != null)
						row.createCell(7).setCellValue(dateTo1);
					else
						row.createCell(7).setCellValue(" ");
					if (excel.getExTCSEmp() != null)
						row.createCell(8).setCellValue(excel.getExTCSEmp());
					else
						row.createCell(8).setCellValue(" ");
				}

			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	// Offer Retention Report DB to excel
	public static ByteArrayInputStream toexcelOfferRetReport(List<CandidateEntityMap> offerRetreportlist) {
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(CommonConstants.SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < CommonConstants.OFFER_RET_REPORT_HEADER.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(CommonConstants.OFFER_RET_REPORT_HEADER[col]);
			}

			int rowIdx = 1;
			logger.info(offerRetreportlist);
			for (CandidateEntityMap excel : offerRetreportlist) {
				Row row = sheet.createRow(rowIdx++);
				if (excel.getRefId() != null)
					row.createCell(0).setCellValue(excel.getRefId());
				else
					row.createCell(0).setCellValue("");
				if (excel.getMiddlename() != null)
					row.createCell(1).setCellValue(
							excel.getFirstname() + " " + excel.getMiddlename() + " " + excel.getLastname());
				else
					row.createCell(1).setCellValue(excel.getFirstname() + " " + excel.getLastname());
				if (excel.getExemptStatus() != null)
					row.createCell(2).setCellValue(excel.getExemptStatus());
				else
					row.createCell(2).setCellValue("");
				DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
				if (excel.getOfferGenDate() != null) {
					String strOfferCreateDate = dateFormat.format(excel.getOfferGenDate());
					row.createCell(3).setCellValue(strOfferCreateDate);
				} else
					row.createCell(3).setCellValue("");
				if (excel.getOfferGenDate() != null) {
					String strOfferRelDate = dateFormat.format(excel.getOfferGenDate());
					row.createCell(4).setCellValue(strOfferRelDate);
				} else {
					row.createCell(4).setCellValue("");
				}
				if (excel.getOfferStatus() != null)
					row.createCell(5).setCellValue(excel.getOfferStatus());
				else
					row.createCell(5).setCellValue("");
				if (excel.getOfferAcceptDate() != null) {
					String strOfferAcceptDate = dateFormat.format(excel.getOfferAcceptDate());
					row.createCell(6).setCellValue(strOfferAcceptDate);
				} else
					row.createCell(6).setCellValue(" ");
				if (excel.getBase() != 0)
					row.createCell(7).setCellValue((int) excel.getBase());
				else
					row.createCell(7).setCellValue("");
				if (excel.getBonus() != 0)
					row.createCell(8).setCellValue((int) excel.getBonus());
				else
					row.createCell(8).setCellValue("");
				if (excel.getSeverance() != 0)
					row.createCell(9).setCellValue((int) excel.getSeverance());
				else
					row.createCell(9).setCellValue(" ");
				if (excel.getRetBonusQuant() == 0)
					row.createCell(10).setCellValue("No");
				else
					row.createCell(10).setCellValue("Yes");
				if (excel.getRetBonusQuant() != 0)
					row.createCell(11).setCellValue((int) excel.getRetBonusQuant());
				else
					row.createCell(11).setCellValue("");
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

	// India Report DB to excel
	public static ByteArrayInputStream toexcelIndiaReport(List<IndiaReportModel> reportIndialist) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(CommonConstants.SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < CommonConstants.INDIA_REPORT_HEADER.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(CommonConstants.INDIA_REPORT_HEADER[col]);
			}

			int rowIdx = 1;
			logger.info(reportIndialist);
			for (IndiaReportModel excel : reportIndialist) {

				Row row = sheet.createRow(rowIdx++);
				row.createCell(0).setCellValue(excel.getAppId());
				row.createCell(1).setCellValue(excel.getTitle());
				row.createCell(2).setCellValue(excel.getFirstname());
				row.createCell(3).setCellValue(excel.getLastname());
				row.createCell(4).setCellValue(excel.getEmailId());
				row.createCell(5).setCellValue(excel.getGrade());
				row.createCell(6).setCellValue(excel.getOfferStatus());
				row.createCell(7).setCellValue(excel.getAppFormStatus());
				row.createCell(8).setCellValue(excel.getAppointLetterStatus());

			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}

}
