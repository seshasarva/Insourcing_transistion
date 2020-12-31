package com.insourcing.validator;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.insourcing.entity.ApplicationUSEntity;

@Component
public class ApplicationUSValidator {

	private static Logger logger = LogManager.getLogger(ApplicationUSValidator.class);
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-dd-MM");
	DecimalFormat numberFormat = new DecimalFormat("#.00");

	public boolean validateUsApp(ApplicationUSEntity applicationUSEntity) throws ParseException, Exception {
		logger.info("validateUsApp - Entry");
		boolean validate = false;
		if (null != applicationUSEntity) {
			if (!isApartmentUnit(applicationUSEntity.getApartmentUnit())) {
				throw new Exception("Appartment Unit is not valid");
			}
			if (!isAlphaNumeric(applicationUSEntity.getStreetAddress())) {
				throw new Exception("Street Address is not valid");
			}
			if (!isNumeric(applicationUSEntity.getZipCode())) {
				throw new Exception("Zipcode is not valid");
			}
			if (!isDateValid(applicationUSEntity.getDate())) {
				throw new Exception("Date is not valid");
			}
			if (!isDateValid(applicationUSEntity.getDateAvailable())) {
				throw new Exception("Date Available is not valid");
			}
			if (!isStringOnlyAlphabet(applicationUSEntity.getCurrentWorkLocation())) {
				throw new Exception("Current Work Location is not valid");
			}
			if (!isExpNumeric(applicationUSEntity.getTotalExp())) {
				throw new Exception("Total Experience is not valid");
			}
			if (!isExpNumeric(applicationUSEntity.getTotalRelExp())) {
				throw new Exception("Total Relevant Experience is not valid");
			}
			if (!applicationUSEntity.getIfYesWhen().trim().isEmpty()) {
				if (!isDateValid(format1.parse(applicationUSEntity.getIfYesWhen()))) {
					throw new Exception("If Yes when is not valid");
				}
			}
			if (!isAlphaNumericArray(applicationUSEntity.getCom())) {
				throw new Exception("Company Name is not valid");
			}
			if (!isNumericArray(applicationUSEntity.getComPhone())) {
				throw new Exception("Company Phone number is not valid");
			}

			if (!isAlphaArray(applicationUSEntity.getComAddress())) {
				throw new Exception("Company Address is not valid");
			}
			if (!isStringArray(applicationUSEntity.getComSupervisor())) {
				throw new Exception("Company Supervisor is not valid");
			}
			if (!isStringRespArray(applicationUSEntity.getComResponsibilities())) {
				throw new Exception("Company Responsibilities is not valid");
			}
			if (!isDateValidArray(applicationUSEntity.getComFrom())) {
				throw new Exception("Company From date is not valid");
			}
			if (!isDateValidArray(applicationUSEntity.getComTo())) {
				throw new Exception("Company To date is not valid");
			}
			if (!isStringArray(applicationUSEntity.getComReasonForLeaving())) {
				throw new Exception("Company Reason for leaving is not valid");
			}
			if (!isStringOnlyAlphabetTech(applicationUSEntity.getTechProf())) {
				throw new Exception("Technical Proficiency is not valid");
			}
			for (String i : applicationUSEntity.getRefFullName()) {
				if (i.trim().isEmpty()) {
					if (!isString(i)) {
						throw new Exception("Reference FullName is not valid");
					}
				}
			}
			for (String i : applicationUSEntity.getRefRelationship()) {
				if (i.trim().isEmpty()) {
					if (!isStringArrayRel(i)) {
						throw new Exception("Reference Relationship is not valid");
					}
				}
			}
			for (String i : applicationUSEntity.getRefCompany()) {
				if (i.trim().isEmpty()) {
					if (!isStringArrayRel(i)) {
						throw new Exception("Reference Company is not valid");
					}
				}
			}
			for (String i : applicationUSEntity.getRef_Phone()) {
				if (i.trim().isEmpty()) {
					if (!isRefPhone(i)) {
						throw new Exception("Reference Phone is not valid");
					}
				}
			}
			for (String i : applicationUSEntity.getRefEmail()) {
				if (i.trim().isEmpty()) {
					if (!isValidRefEmail(i)) {
						throw new Exception("Reference Email is not valid");
					}
				}
			}
			for (String i : applicationUSEntity.getRefAddress()) {
				if (i.trim().isEmpty()) {
					if (!isAlphaNumericRefAdd(i)) {
						throw new Exception("Reference Address is not valid");
					}
				}
			}
			if (applicationUSEntity.getRelMiliTrainingExp() != null) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getRelMiliTrainingExp())) {
					throw new Exception("Relevant Military Training Experience is not valid");
				}
			}
			if (applicationUSEntity.getSignature() != null) {
				if (!isStringOnlyAlphabetcos(applicationUSEntity.getSignature())) {
					throw new Exception("Signature is not valid");
				}
			}
			if (applicationUSEntity.getDisclaimerSign() != null) {
				if (!isStringOnlyAlphabetcos(applicationUSEntity.getDisclaimerSign())) {
					throw new Exception("Sign is not valid");
				}
			}
			if (!applicationUSEntity.getHsInsName().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getHsInsName())) {
					throw new Exception("Higher sec Inst name is not valid");
				}
			}
			if (!applicationUSEntity.getHsAddress().isEmpty()) {
				if (!isStringOnlyAlphabetAdd(applicationUSEntity.getHsAddress())) {
					throw new Exception("Higher sec Address is not valid");
				}
			}
			if (!applicationUSEntity.getHsGraduate().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getHsGraduate())) {
					throw new Exception("Higher sec graduate is not valid");
				}
			}
			if (!applicationUSEntity.getHsDegree().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getHsDegree())) {
					throw new Exception("Higher sec degree is not valid");
				}
			}
			if (!applicationUSEntity.getHsCos().isEmpty()) {
				if (!isStringOnlyAlphabetcos(applicationUSEntity.getHsCos())) {
					throw new Exception("Higher sec course of study is not valid");
				}
			}
			if (!applicationUSEntity.getHsGPAScale().isEmpty()) {
				if (!isGpaNumeric(applicationUSEntity.getHsGPAScale())) {
					throw new Exception("Higher sec GPA/Scale is not valid");
				}
			}
			if (!applicationUSEntity.getAssociateInsName().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getAssociateInsName())) {
					throw new Exception("Assosiate Inst name is not valid");
				}
			}
			if (!applicationUSEntity.getAssosiateAddress().isEmpty()) {
				if (!isStringOnlyAlphabetAdd(applicationUSEntity.getAssosiateAddress())) {
					throw new Exception("Assosiate Address is not valid");
				}
			}
			if (!applicationUSEntity.getAssosiateGraduate().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getAssosiateGraduate())) {
					throw new Exception("Assosiate graduate is not valid");
				}
			}
			if (!applicationUSEntity.getAssosiateDegree().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getAssosiateDegree())) {
					throw new Exception("Assosiate degree is not valid");
				}
			}
			if (!applicationUSEntity.getAssosiateCos().isEmpty()) {
				if (!isStringOnlyAlphabetcos(applicationUSEntity.getAssosiateCos())) {
					throw new Exception("Assosiate course of study is not valid");
				}
			}
			if (!applicationUSEntity.getAssociateGPAScale().isEmpty()) {
				if (!isGpaNumeric(applicationUSEntity.getAssociateGPAScale())) {
					throw new Exception("Assosiate GPA/Scale is not valid");
				}
			}
			if (!applicationUSEntity.getBachelorInsName().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getBachelorInsName())) {
					throw new Exception("Bachelor Inst name is not valid");
				}
			}
			if (!applicationUSEntity.getBachelorAddress().isEmpty()) {
				if (!isStringOnlyAlphabetAdd(applicationUSEntity.getBachelorAddress())) {
					throw new Exception("Bachelor Address is not valid");
				}
			}
			if (!applicationUSEntity.getBachelorGraduate().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getBachelorGraduate())) {
					throw new Exception("Bachelor graduate is not valid");
				}
			}
			if (!applicationUSEntity.getBachelorDegree().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getBachelorDegree())) {
					throw new Exception("Bachelor degree is not valid");
				}
			}
			if (!applicationUSEntity.getBachelorCos().isEmpty()) {
				if (!isStringOnlyAlphabetcos(applicationUSEntity.getBachelorCos())) {
					throw new Exception("Bachelor degree is not valid");
				}
			}
			if (!applicationUSEntity.getBachelorGPAScale().isEmpty()) {
				if (!isGpaNumeric(applicationUSEntity.getBachelorGPAScale())) {
					throw new Exception("Bachelor GPA/Scale is not valid");
				}
			}
			if (!applicationUSEntity.getMasterInsName().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getMasterInsName())) {
					throw new Exception("Master Inst name is not valid");
				}
			}
			if (!applicationUSEntity.getMasterAddress().isEmpty()) {
				if (!isStringOnlyAlphabetAdd(applicationUSEntity.getMasterAddress())) {
					throw new Exception("Master Address is not valid");
				}
			}
			if (!applicationUSEntity.getMasterGraduate().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getMasterGraduate())) {
					throw new Exception("Master graduate is not valid");
				}
			}
			if (!applicationUSEntity.getMasterDegree().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getMasterDegree())) {
					throw new Exception("Master degree is not valid");
				}
			}
			if (!applicationUSEntity.getMasterCos().isEmpty()) {
				if (!isStringOnlyAlphabetcos(applicationUSEntity.getMasterCos())) {
					throw new Exception("Master course of study is not valid");
				}
			}
			if (!applicationUSEntity.getMasterGPAScale().isEmpty()) {
				if (!isGpaNumeric(applicationUSEntity.getMasterGPAScale())) {
					throw new Exception("Master GPA/Scale is not valid");
				}
			}
			if (!applicationUSEntity.getDoctoralInsName().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getDoctoralInsName())) {
					throw new Exception("Doctoral Inst name is not valid");
				}
			}
			if (!applicationUSEntity.getDoctoralAddress().isEmpty()) {
				if (!isStringOnlyAlphabetAdd(applicationUSEntity.getDoctoralAddress())) {
					throw new Exception("Doctoral Address is not valid");
				}
			}
			if (!applicationUSEntity.getDoctoralGraduate().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getDoctoralGraduate())) {
					throw new Exception("Doctoral graduate is not valid");
				}
			}
			if (!applicationUSEntity.getDoctoralDegree().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getDoctoralDegree())) {
					throw new Exception("Doctoral degree is not valid");
				}
			}
			if (!applicationUSEntity.getDoctoralCos().isEmpty()) {
				if (!isStringOnlyAlphabetcos(applicationUSEntity.getDoctoralCos())) {
					throw new Exception("Doctoral course of study is not valid");
				}
			}
			if (!applicationUSEntity.getDoctoralGPAScale().isEmpty()) {
				if (!isGpaNumeric(applicationUSEntity.getDoctoralGPAScale())) {
					throw new Exception("Doctoral GPA/Scale is not valid");
				}
			}
			if (!applicationUSEntity.getOtherInsName().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getOtherInsName())) {
					throw new Exception("Other Inst name is not valid");
				}
			}
			if (!applicationUSEntity.getOthersAddress().isEmpty()) {
				if (!isStringOnlyAlphabetAdd(applicationUSEntity.getOthersAddress())) {
					throw new Exception("Other Address is not valid");
				}
			}
			if (!applicationUSEntity.getOthersGraduate().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getOthersGraduate())) {
					throw new Exception("Other graduate is not valid");
				}
			}
			if (!applicationUSEntity.getOthersDegree().isEmpty()) {
				if (!isStringOnlyAlphabet(applicationUSEntity.getOthersDegree())) {
					throw new Exception("Other degree is not valid");
				}
			}
			if (!applicationUSEntity.getOthersCos().isEmpty()) {
				if (!isStringOnlyAlphabetcos(applicationUSEntity.getOthersCos())) {
					throw new Exception("Other course of study is not valid");
				}
			}
			if (!applicationUSEntity.getOthersGPAScale().isEmpty()) {
				if (!isGpaNumeric(applicationUSEntity.getOthersGPAScale())) {
					throw new Exception("Other GPA/Scale is not valid");
				}
			}
			validate = true;
		}
		logger.info("validateUsApp - Exit");
		return validate;
	}

	private boolean isGpaNumeric(String GPAScale) {
		double j = Double.parseDouble(GPAScale);
		// int decimalLength = (numberFormat.format(j).length() - 1);
		if (j <= 100) // && decimalLength <= 2
			return true;
		return false;
	}
	/*
	 * public static boolean isValidEmail(String[] email) { for (String i : email) {
	 * String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" +
	 * "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
	 * 
	 * Pattern pat = Pattern.compile(emailRegex); if (i == null) return false;
	 * return pat.matcher(i).matches(); } return false; }
	 */

	public static boolean isValidRefEmail(String i) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (i == null)
			return false;
		return pat.matcher(i).matches();
	}

	@SuppressWarnings("unlikely-arg-type")
	public static boolean isAlphaNumericAdd(String[] str) {
		for (String i : str) {
			if (!i.startsWith(" ") && i.length() <= 200 && (!str.equals("")))
				return true;
		}
		return false;
	}

	public static boolean isAlphaNumericRefAdd(String str) {

		if (!str.startsWith(" ") && str.length() <= 200 && (!str.equals("")))
			return true;

		return false;
	}

	private boolean isDateValid(Date date) throws ParseException {
		Date dateAfter = format.parse("01/01/1960");
		String currentDate = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
		Date cntDate = format.parse(currentDate);
		if (date.after(dateAfter) && date.before(cntDate))
			return true;
		return false;
	}

	public static boolean isAlphaNumeric(String str) {
		if (!str.startsWith(" ") && str.length() <= 100 && (!str.equals("")))
			return true;
		return false;
	}

	public static boolean isApartmentUnit(String str) {
		if (!str.startsWith(" ") && str.length() <= 100 && (!str.equals("")))
			return true;
		return false;
	}

	public static boolean isStringOnlyAlphabetTech(String str) { // str.matches("^[a-zA-Z\\\\s]*$")) &&
		if ((str != null) && (!str.equals("")) && !str.startsWith(" ") && str.length() <= 500)
			return true;
		return false;
	}

	public static boolean isStringOnlyAlphabetAdd(String str) {
		if ((str != null) && (!str.equals("")) && !str.startsWith(" ") && str.length() <= 200)
			return true;
		return false;
	}

	public static boolean isStringOnlyAlphabet(String str) {
		if ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z\\s]*$"))
				&& (!str.startsWith(" ") && str.length() <= 100))
			return true;
		return false;
	}

	public static boolean isStringOnlyAlphabetcos(String str) {
		if ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z\\s]*$")) && !str.startsWith(" ")
				&& str.length() <= 50)
			return true;
		return false;
	}

	private boolean isStringArrayRel(String str) {
		if ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z\\s]*$")) && !str.startsWith(" ")
				&& str.length() <= 50)
			return true;
		return false;
	}

	private boolean isStringRespArray(String[] str) {
		for (String i : str) {
			if ((i != null) && (!i.equals("")) && (i.matches("^[a-zA-Z\\s]*$")) && !i.startsWith(" ")
					&& i.length() <= 500)
				return true;
		}
		return false;
	}

	public static boolean isNumeric(String str) {
		if ((Double.parseDouble(str)) <= 9999999)
			return true;
		return false;
	}

	private boolean isExpNumeric(String totalExp) {
		if (Double.parseDouble(totalExp) <= 30)
			return true;
		return false;
	}

	private boolean isStringArray(String[] str) {
		for (String i : str) {
			if (isStringOnlyAlphabet(i))
				return true;
		}
		return false;
	}

	private boolean isString(String str) {
		if (isStringOnlyAlphabet(str))
			return true;
		return false;
	}

	private boolean isAlphaArray(String[] str) {
		for (String i : str) {
			if (isAlphaNumeric(i))
				return true;
		}
		return false;
	}

	private boolean isAlphaNumericArray(String[] str) {
		for (String i : str) {
			if (isApartmentUnit(i))
				return true;
		}
		return false;
	}

	private boolean isNumericArray(String[] str) {
		for (String i : str) {
			if (i.length() == 10) {
				double j = (Double.parseDouble(i));
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	private boolean isRefPhone(String str) {
		if (str.length() == 10) {
			double j = (Double.parseDouble(str));
			return true;
		} else {
			return false;
		}
	}

	private boolean isDateValidArray(Date[] date) throws ParseException {
		for (Date i : date) {
			if (isDateValid(i))
				return true;
		}
		return false;
	}

}