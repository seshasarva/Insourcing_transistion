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

import com.insourcing.entity.OfferIndiaEntity;
import com.insourcing.model.AppointmentModel;
import com.insourcing.model.OfferModel;
import com.insourcing.model.RetentionModel;

public class ExcelReader {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	private static Logger logger = LogManager.getLogger(ExcelReader.class);

	// To check the uploaded excel format
	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<RetentionModel> excelToRetentionModel(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rows = sheet.iterator();

			List<RetentionModel> retentionModel = new ArrayList<RetentionModel>();
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

					RetentionModel rmodel = new RetentionModel();
					// int cellIdx = 0;

					// Cell currentCell = cellsInRow.next();

					rmodel.setDate(currentRow.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getDateCellValue());
					rmodel.setEmailId(
							currentRow.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					rmodel.setFirstName(
							currentRow.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					rmodel.setLastName(
							currentRow.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					rmodel.setAddress(
							currentRow.getCell(4, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					// rmodel.setAddress2(currentRow.getCell(5,
					// MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					rmodel.setCityStateZip(
							currentRow.getCell(5, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					rmodel.setBonus(
							(int) currentRow.getCell(6, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
					rmodel.setWorkState(
							currentRow.getCell(7, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());

					retentionModel.add(rmodel);

				}

				workbook.close();
			} else {
				logger.info("More than 2000");
			}
			logger.info(retentionModel);
			return retentionModel;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	public static List<OfferModel> offerUsExcel(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rows = sheet.iterator();

			List<OfferModel> offerModel = new ArrayList<OfferModel>();
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

					OfferModel fmodel = new OfferModel();

					fmodel.setDate(currentRow.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getDateCellValue());
					fmodel.setFirstName(
							currentRow.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					fmodel.setLastName(
							currentRow.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					fmodel.setAddress(
							currentRow.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					fmodel.setAddress2(
							currentRow.getCell(4, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					fmodel.setCity(currentRow.getCell(5, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					fmodel.setRole(currentRow.getCell(6, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					fmodel.setReportingTo(
							currentRow.getCell(7, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					fmodel.setReportingAddress(
							currentRow.getCell(8, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					fmodel.setJoinDate(
							currentRow.getCell(9, MissingCellPolicy.CREATE_NULL_AS_BLANK).getDateCellValue());
					fmodel.setBase(
							(int) currentRow.getCell(10, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
					fmodel.setExemptionStatus(
							currentRow.getCell(11, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					fmodel.setBonus(
							(int) currentRow.getCell(12, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
					fmodel.setSeverance(
							(int) currentRow.getCell(13, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
					fmodel.setOfferResponseDate(
							currentRow.getCell(14, MissingCellPolicy.CREATE_NULL_AS_BLANK).getDateCellValue());
					fmodel.setEmailId(
							currentRow.getCell(15, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());

					offerModel.add(fmodel);
				}

				workbook.close();
			} else {
				logger.info("More than 2000");
			}
			logger.info(offerModel);
			return offerModel;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	// Save the India Offer excel to DB
	public static List<OfferIndiaEntity> offerIndiaExcel(InputStream is) {

		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();

			List<OfferIndiaEntity> excelOfferIndEntity = new ArrayList<OfferIndiaEntity>();
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

					OfferIndiaEntity offerIndEntity = new OfferIndiaEntity();

					offerIndEntity.setRefId(
							currentRow.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setDepartment(
							currentRow.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setDateOfOffer(
							currentRow.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getDateCellValue());
					offerIndEntity.setTitle(
							currentRow.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setFirstname(
							currentRow.getCell(4, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setMiddlename(
							currentRow.getCell(5, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setLastname(
							currentRow.getCell(6, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setAdd1(
							currentRow.getCell(7, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setAdd2(
							currentRow.getCell(8, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setAdd3(
							currentRow.getCell(9, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setTelNo(
							currentRow.getCell(10, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setDesignation(
							currentRow.getCell(11, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setGrade(
							currentRow.getCell(12, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setPostingBranch(
							currentRow.getCell(13, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setCandRole(
							currentRow.getCell(14, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setSuperRole(
							currentRow.getCell(15, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setRelExp(String.valueOf((int) currentRow
							.getCell(16, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue()));
					String basic = String.valueOf(
							(int) currentRow.getCell(17, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(33, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String mva = String.valueOf(
							(int) currentRow.getCell(18, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(34, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String qva = String.valueOf(
							(int) currentRow.getCell(19, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(35, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String cityAllo = String.valueOf(
							(int) currentRow.getCell(20, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(36, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String bob = String.valueOf(
							(int) currentRow.getCell(21, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(44, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String hra = String.valueOf(
							(int) currentRow.getCell(22, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(37, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String lta = String.valueOf(
							(int) currentRow.getCell(23, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(38, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String foodcoupons = String.valueOf(
							(int) currentRow.getCell(24, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(39, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String carAllo = String.valueOf(
							(int) currentRow.getCell(25, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(40, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String vehicle = String.valueOf(
							(int) currentRow.getCell(26, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(41, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String fuelAllo = String.valueOf(
							(int) currentRow.getCell(27, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(42, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String perAllo = String.valueOf(
							(int) currentRow.getCell(28, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(43, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String pf = String.valueOf(
							(int) currentRow.getCell(29, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(46, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String gratuity = String.valueOf(
							(int) currentRow.getCell(30, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(47, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String annualReti = String.valueOf(
							(int) currentRow.getCell(31, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(48, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String ctc = String.valueOf(
							(int) currentRow.getCell(32, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
							+ "," + String.valueOf((int) currentRow.getCell(50, MissingCellPolicy.CREATE_NULL_AS_BLANK)
									.getNumericCellValue());
					String retiIncA = String.valueOf(
							(int) currentRow.getCell(49, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
					String his3 = String.valueOf(
							(int) currentRow.getCell(45, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
					offerIndEntity.setBasic(basic.split(","));
					offerIndEntity.setMva(mva.split(","));
					offerIndEntity.setQva(qva.split(","));
					offerIndEntity.setCityAllowance(cityAllo.split(","));
					offerIndEntity.setBob(bob.split(","));
					offerIndEntity.setHra(hra.split(","));
					offerIndEntity.setLta(lta.split(","));
					offerIndEntity.setFoodCoupons(foodcoupons.split(","));
					offerIndEntity.setCarAllo(carAllo.split(","));
					offerIndEntity.setVehicle(vehicle.split(","));
					offerIndEntity.setFuelAllo(fuelAllo.split(","));
					offerIndEntity.setPerAllo(perAllo.split(","));
					offerIndEntity.setPf(pf.split(","));
					offerIndEntity.setGratuity(gratuity.split(","));
					offerIndEntity.setAnnualRetirals(annualReti.split(","));
					offerIndEntity.setCtc(ctc.split(","));
					offerIndEntity.setRetInc(retiIncA);
					offerIndEntity.setHis3(his3);
					offerIndEntity.setProbPeriod(String.valueOf((int) currentRow
							.getCell(51, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue()));
					offerIndEntity.setProbUnit(
							currentRow.getCell(52, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setEmailId(
							currentRow.getCell(53, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setJoiningDate(
							currentRow.getCell(54, MissingCellPolicy.CREATE_NULL_AS_BLANK).getDateCellValue());
					offerIndEntity.setJoiningBranch(
							currentRow.getCell(55, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					offerIndEntity.setExgratia(
							currentRow.getCell(56, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					excelOfferIndEntity.add(offerIndEntity);
				}

				workbook.close();
			} else {
				logger.info("More than 2000");
			}
			logger.info(excelOfferIndEntity);
			return excelOfferIndEntity;
		} catch (IOException e) {
			logger.info("Excel parsing error: " + e);
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	public static List<AppointmentModel> excelToAppoinmentModel(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();

			List<AppointmentModel> excelToAppoinmentModel = new ArrayList<AppointmentModel>();
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
					AppointmentModel appointModel = new AppointmentModel();
					appointModel.setRefId(
							currentRow.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					appointModel.setTitle(
							currentRow.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					appointModel.setFirstName(
							currentRow.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					appointModel.setMiddleName(
							currentRow.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					appointModel.setLastName(
							currentRow.getCell(4, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					appointModel.setDesignation(
							currentRow.getCell(5, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					appointModel.setGrade(
							currentRow.getCell(6, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					appointModel.setJoiningDate(
							currentRow.getCell(7, MissingCellPolicy.CREATE_NULL_AS_BLANK).getDateCellValue());
					appointModel.setEmpNumber(
							(int) currentRow.getCell(8, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue());
					appointModel.setEmailId(
							currentRow.getCell(9, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					appointModel.setJoiningBranch(
							currentRow.getCell(10, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
					excelToAppoinmentModel.add(appointModel);
				}

				workbook.close();
			} else {
				logger.info("More than 2000");
			}
			logger.info(excelToAppoinmentModel);
			return excelToAppoinmentModel;
		} catch (IOException e) {
			logger.info("Excel parsing error: " + e);
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

}