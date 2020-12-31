package com.insourcing.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.insourcing.model.EmailExcelTemplate;

public class ExcelReaderII {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	private static Logger logger = LogManager.getLogger(ExcelReaderII.class);

	// To check the uploaded excel format
	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<EmailExcelTemplate> excelToEmailExcelTemplateModel(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rows = sheet.iterator();

			List<EmailExcelTemplate> emailTemplateModel = new ArrayList<EmailExcelTemplate>();
			int totalRowCount = sheet.getLastRowNum();
			logger.info(totalRowCount);
			int rowNumber = 0;
			if (totalRowCount < 2000) {
				while (rows.hasNext()) {
					Row currentRow = rows.next();

					// skip header
					if (rowNumber == 0) {
						rowNumber++;
						continue;
					}

					// Iterator<Cell> cellsInRow = currentRow.iterator();

					EmailExcelTemplate emailTemplate = new EmailExcelTemplate();

					emailTemplate.setEmailId(
							currentRow.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					emailTemplate.setFirstName(
							currentRow.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					emailTemplate.setMiddleName(
							currentRow.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					emailTemplate.setLastName(
							currentRow.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					emailTemplate.setOfferStatus(
							currentRow.getCell(4, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					emailTemplate.setJoiningDate(
							currentRow.getCell(5, MissingCellPolicy.CREATE_NULL_AS_BLANK).getDateCellValue());
					emailTemplate.setBaseSalary(
							(int) currentRow.getCell(6, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());

					emailTemplateModel.add(emailTemplate);
				}

				workbook.close();
			} else {
				logger.info("More than 2000");
			}
			logger.info(emailTemplateModel);
			return emailTemplateModel;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

}
