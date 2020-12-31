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

import com.insourcing.entity.ApplicationIndiaEntity;

@Component
public class ApplicationIndiaValidator {

	private static Logger logger = LogManager.getLogger(ApplicationIndiaValidator.class);
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-dd-MM");
	DecimalFormat numberFormat = new DecimalFormat("#.00");

	public boolean validateIndiaApp(ApplicationIndiaEntity applicationIndiaEntity)
			throws ParseException, Exception {
		logger.info("validateUsApp - Entry");
		boolean validate = false;
		if (null != applicationIndiaEntity) {
			if (!isStringOnlyAlphabet(applicationIndiaEntity.getFatherName())) {
				throw new Exception("Father Name is not valid");
			}
			if (!isDateValid(format1.parse(applicationIndiaEntity.getDob()))) {
				throw new Exception("DOB is not valid");
			}
			if (!isStringOnlyAlphabet(applicationIndiaEntity.getGender())) {
				throw new Exception("Gender is not valid");
			}
			if (!isStringOnlyAlphabet(applicationIndiaEntity.getNationality())) {
				throw new Exception("Nationality is not valid");
			}
//			if (!isStringOnlyAlphabet(applicationIndiaEntity.getValidWorkPermit())) {
//				throw new Exception("ValidWorkPermit is not valid");
//			}
//			if (applicationIndiaEntity.getLinkedInUrl() != null) {
//				if (!isAlphaNumericSkills(applicationIndiaEntity.getLinkedInUrl())) {
//					throw new Exception("LinkedInUrl is not valid");
//				}
//			}
//			if (applicationIndiaEntity.getTwitterUrl() != null) {
//				if (!isAlphaNumericSkills(applicationIndiaEntity.getTwitterUrl())) {
//					throw new Exception("TwitterUrl is not valid");
//				}
//			}
//			if (applicationIndiaEntity.getFacebookUrl() != null) {
//				if (!isAlphaNumericSkills(applicationIndiaEntity.getFacebookUrl())) {
//					throw new Exception("FacebookUrl is not valid");
//				}
//			}
			if (!isStringOnlyAlphabetAdd(applicationIndiaEntity.getResidenceCountry())) {
				throw new Exception("ResidenceCountry is not valid");
			}
			if (!isAlphaNumeric(applicationIndiaEntity.getPanCard())) {
				throw new Exception("PanCard is not valid");
			}
			if (!isAlphaNumericAadhar(applicationIndiaEntity.getAadharCard())) {
				throw new Exception("AadharCard is not valid");
			}
//			if (!isAlphaNumericSkills(applicationIndiaEntity.getSkills())) {
//				throw new Exception("Skills is not valid");
//			}
//			if (!isStringOnlyAlphabet(applicationIndiaEntity.getPreferredLocation())) {
//				throw new Exception("PreferredLocation is not valid");
//			}
//			if (!isStringOnlyAlphabet(applicationIndiaEntity.getDirectSource())) {
//				throw new Exception("DirectSource is not valid");
//			}
//			if (!isStringOnlyAlphabet(applicationIndiaEntity.getDirectSource())) {
//				throw new Exception("DirectSource is not valid");
//			}
//			if (!isAlphaNumericSkills(applicationIndiaEntity.getPermanentAdress())) {
//				throw new Exception("PermanentAdress is not valid");
//			}
			if (!isStringOnlyAlphabetcos(applicationIndiaEntity.getCity())) {
				throw new Exception("City is not valid");
			}
			if (!isStringOnlyAlphabetcos(applicationIndiaEntity.getState())) {
				throw new Exception("State is not valid");
			}
			/*
			 * if (!isStringOnlyAlphabet(applicationIndiaEntity.getCountry())) { throw new
			 * Exception("Country is not valid"); }
			 */
			if (!isNumeric(applicationIndiaEntity.getPinCode())) {
				throw new Exception("PinCode is not valid");
			}
			if (applicationIndiaEntity.getAlternateContact() != null) {
				if (!isValidIndianPhoneNumber(applicationIndiaEntity.getAlternateContact())) {
					throw new Exception("AlternateContact is not valid");
				}
			}
			if (!isAlphaNumericFiftyArray(applicationIndiaEntity.getDegreeDiploma())) {
				throw new Exception("DegreeDiploma is not valid");
			}
			if (!isStringArrayRel(applicationIndiaEntity.getMajorSubject())) {
				throw new Exception("MajorSubject is not valid");
			}
			if (!isStringArray(applicationIndiaEntity.getUniversity())) {
				throw new Exception("University is not valid");
			}
			if (!isStringArray(applicationIndiaEntity.getCollege())) {
				throw new Exception("College is not valid");
			}
			if (!isStringArrayTwenty(applicationIndiaEntity.getCourseType())) {
				throw new Exception("CourseType is not valid");
			}
			if (!isCourseDuration(applicationIndiaEntity.getCourseDuration())) {
				throw new Exception("CourseDuration is not valid");
			}
			if (!isGpaNumeric(applicationIndiaEntity.getMarks())) {
				throw new Exception("Marks is not valid");
			}
			if (!isStringArray(applicationIndiaEntity.getCompanyName())) {
				throw new Exception("CompanyName is not valid");
			}
			if (!isAlphaNumericAdd(applicationIndiaEntity.getCompanyAddress())) {
				throw new Exception("CompanyAddress is not valid");
			}
			if (!isCourseDuration(applicationIndiaEntity.getCompWorkDuration())) {
				throw new Exception("CompWorkDuration is not valid");
			}
			if (!isStringArrayRel(applicationIndiaEntity.getDesignation())) {
				throw new Exception("Designation is not valid");
			}
			if (!isNumericEightArray(applicationIndiaEntity.getGrossSalary())) {
				throw new Exception("GrossSalary is not valid");
			}
			if (!isAlphaNumericTwenty(applicationIndiaEntity.getEmployeeId())) {
				throw new Exception("EmployeeId is not valid");
			}
			if (applicationIndiaEntity.getItExperience() != null) {
				if (!isExpNumeric(applicationIndiaEntity.getItExperience())) {
					throw new Exception("ItExperience is not valid");
				}
			}
			if (applicationIndiaEntity.getNonItExperience() != null) {
				if (!isExpNumeric(applicationIndiaEntity.getNonItExperience())) {
					throw new Exception("NonItExperience is not valid");
				}
			}
//			if (applicationIndiaEntity.getDefinedExperience() != null) {
//				if (!isExpNumeric(applicationIndiaEntity.getDefinedExperience())) {
//					throw new Exception("DefinedExperience is not valid");
//				}
//			}
//			if (applicationIndiaEntity.getCurrentServiceBond() != null) {
//				if (!isAlphaNumericHund(applicationIndiaEntity.getCurrentServiceBond())) {
//					throw new Exception("CurrentServiceBond is not valid");
//				}
//			}
//			if (applicationIndiaEntity.getCurrentServiceBond() != null) {
//				if (!isAlphaNumericHund(applicationIndiaEntity.getServiceBondDetails())) {
//					throw new Exception("ServiceBondDetails is not valid");
//				}
//			}
//			if (applicationIndiaEntity.getExpectedSalary() != null) {
//				if (!isNumericEight(applicationIndiaEntity.getExpectedSalary())) {
//					throw new Exception("ExpectedSalary is not valid");
//				}
//			}
		if (applicationIndiaEntity.getPermcity() != null) {
				if (!isStringOnlyAlphabetcos(applicationIndiaEntity.getPermcity())) {
					throw new Exception("Permcity is not valid");
				}
			}
			if (applicationIndiaEntity.getPermstate() != null) {
				if (!isStringOnlyAlphabetcos(applicationIndiaEntity.getPermstate())) {
					throw new Exception("Permstate is not valid");
				}
			}
			/*
			 * if (applicationIndiaEntity.getPermcountry() != null) { if
			 * (!isStringOnlyAlphabet(applicationIndiaEntity.getPermcountry())) { throw new
			 * Exception("Permcountry is not valid"); } }
			 */
			if (applicationIndiaEntity.getPermpinCode() != null) {
				if (!isNumeric(applicationIndiaEntity.getPermpinCode())) {
					throw new Exception("PermpinCode is not valid");
				}
			}
			if (!applicationIndiaEntity.getPermanentAdress().isEmpty()) {
				if (!isAlphaNumericSkills(applicationIndiaEntity.getPermanentAdress())) {
					throw new Exception("PermanentAdress is not valid");
				}
			}
			if (applicationIndiaEntity.getCriminalCase1() != null) {
				if (!isAlphaNumericSkills(applicationIndiaEntity.getCriminalCase1())) {
					throw new Exception("CriminalCase1 is not valid");
				}
			}
			if (applicationIndiaEntity.getMalpractice1() != null) {
				if (!isAlphaNumericSkills(applicationIndiaEntity.getMalpractice1())) {
					throw new Exception("Malpractice1 is not valid");
				}
			}
			if (applicationIndiaEntity.getCivilCriminalCase() != null) {
				if (!isAlphaNumericSkills(applicationIndiaEntity.getCivilCriminalCase())) {
					throw new Exception("CivilCriminalCase is not valid");
				}
			}
			if (applicationIndiaEntity.getDisciplinaryMalPractices() != null) {
				if (!isAlphaNumericSkills(applicationIndiaEntity.getDisciplinaryMalPractices())) {
					throw new Exception("DisciplinaryMalPractices is not valid");
				}
			}
//			if (applicationIndiaEntity.getLanguagesKnown() != null) {
//				if (!isStringArray(applicationIndiaEntity.getLanguagesKnown())) {
//					throw new Exception("LanguagesKnown is not valid");
//				}
//			}
			if (!(applicationIndiaEntity.getSpeak() != null)) {
				if (!isStringArray(applicationIndiaEntity.getSpeak())) {
					throw new Exception("Speak is not valid");
				}
			}
			if (!(applicationIndiaEntity.getRead() != null)) {
				if (!isStringArray(applicationIndiaEntity.getRead())) {
					throw new Exception("Read is not valid");
				}
			}
			if (!(applicationIndiaEntity.getWrite() != null)) {
				if (!isStringArray(applicationIndiaEntity.getWrite())) {
					throw new Exception("Write is not valid");
				}
			}
			validate = true;
		}
		return validate;
	}

	private boolean isCourseDuration(String[] courseDuration) throws ParseException {
		for (String i : courseDuration) {
			double j = Double.parseDouble(i);
			if (j <= 9999) 
				return true;
//			return isDateValid(format1.parse(i));
		}
		return false;
	}

	private boolean isGpaNumeric(String[] GPAScale) {
		for (String i : GPAScale) {
			double j = Double.parseDouble(i);
			// int decimalLength = (numberFormat.format(j).length() - 1);
			if (j <= 100) // && decimalLength <= 2
				return true;
		}
		return false;
	}

	public static boolean isValidEmail(String[] email) {
		for (String i : email) {
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
					+ "A-Z]{2,7}$";

			Pattern pat = Pattern.compile(emailRegex);
			if (i == null)
				return false;
			return pat.matcher(i).matches();
		}
		return false;
	}

	public static boolean isAlphaNumericAdd(String[] str) {// && i.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")
		for (String i : str) {
			if (!i.startsWith(" ") && i.length() <= 200
					&& (!i.equals("")))
				return true;
		}
		return false;
	}

	public static boolean isValidIndianPhoneNumber(String str) {
		if (str.length() == 10) {
			double j = (Double.parseDouble(str));
			return true;
		} else {
			return false;
		}
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
		if (!str.startsWith(" ") && str.length() <= 10
				&& (!str.equals("") && str.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")))
			return true;
		return false;
	}

	public static boolean isAlphaNumericAadhar(String str) {
		if (!str.startsWith(" ") && str.length() <= 12
				&& (!str.equals("") && str.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")))
			return true;
		return false;
	}

	public static boolean isAlphaNumericTwenty(String[] str) {
		for (String i : str) {
			if (!i.startsWith(" ") && i.length() <= 20
					&& (!i.equals("") && i.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")))
				return true;
		}
		return false;
	}

	public static boolean isAlphaNumericFiftyArray(String[] str) {
		for (String i : str) {
			if (!i.startsWith(" ") && i.length() <= 50
					&& (!i.equals("") && i.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")))
				return true;
		}
		return false;
	}

	public static boolean isAlphaNumericSkills(String str) {// && str.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")
		if (!str.startsWith(" ") && str.length() <= 200
				&& (!str.equals("")))
			return true;
		return false;
	}

	public static boolean isAlphaNumericHund(String str) {// && str.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")
		if (!str.startsWith(" ") && str.length() <= 100
				&& (!str.equals("")))
			return true;
		return false;
	}

	public static boolean isStringOnlyAlphabetTech(String str) {
		if ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z\\s]*$")) && !str.startsWith(" ")
				&& str.length() <= 500)
			return true;
		return false;
	}

	public static boolean isStringOnlyAlphabetAdd(String str) {
		if ((str != null) && (!str.equals("")) && !str.startsWith(" ")
				&& str.length() <= 200)
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

	public static boolean isStringOnlyAlphabetTwenty(String str) {
		if ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z\\s]*$"))
				&& (!str.startsWith(" ") && str.length() <= 20))
			return true;
		return false;
	}

	private boolean isStringArrayRel(String[] str) {
		for (String i : str) {
			if ((i != null) && (!i.equals("")) && (i.matches("^[a-zA-Z\\s]*$")) && !i.startsWith(" ")
					&& i.length() <= 50)
				return true;
		}
		return false;
	}

	public static boolean isNumeric(String str) {
		double i = (Double.parseDouble(str));
		if (i <= 999999 && i >= 100000)
			return true;
		return false;
	}

	public static boolean isNumericEightArray(String[] str) {
		for (String i : str) {
			if ((Double.parseDouble(i)) <= 99999999)
				return true;
		}
		return false;
	}

	public static boolean isNumericEight(String str) {
		if ((Double.parseDouble(str)) <= 99999999)
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

	private boolean isStringArrayTwenty(String[] str) {
		for (String i : str) {
			if (isStringOnlyAlphabetTwenty(i))
				return true;
		}
		return false;
	}

}