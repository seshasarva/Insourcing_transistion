//package com.insourcing.validator;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import com.insourcing.entity.*;
//import com.insourcing.exception.PortalException;
//import com.insourcing.model.HRFormRequest;
//import com.insourcing.services.EncryptService;
//
//import java.security.InvalidAlgorithmParameterException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EntityValidator2_BackUp {
//
//	private static Logger logger = LogManager.getLogger(EntityValidator2_BackUp.class);
//
//	@Autowired
//	EncryptService encryptService;
//
//	@Value("${insource.app.india.date.format}")
//	private String indiaDateFormat;
//
//	@Value("${insource.app.us.date.format}")
//	private String usDateFormat;
//
//	@Value("${insource.app.supported_file_type}")
//	private String[] fileTypes;
//
//	private static final String INDIA = "India";
//	private static final String US = "US";
//	private static final String INVALID_CONTACT_NUMBER = "Contact number is invalid";
//	private static final String INVALID_COUNTRY = "Country is invalid";
//	private static final String INVALID_DATE = "Date is invalid";
//
//	private static final String EMAIL_ID = "emailID";
//	private static final String PASSWORD = "password";
//
//	public void validateCandidateEntity(CandidateEntity candEntity)
//			throws PortalException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
//			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
//		if (null != candEntity) {
//			String email = encryptService.decrptPwd(candEntity.getEmailid(), EMAIL_ID);
//			String password = encryptService.decrptPwd(candEntity.getPassword(), PASSWORD);
//			String contactNo = candEntity.getContactno();
//			String country = candEntity.getCountry();
////			String dateAsString = candEntity.getDob().toString();
//			if (!isValidEmail(email)) {
//				throw new PortalException("EmailID is not invalid");
//			}
//			if (!isValidPassword(password)) {
//				throw new PortalException("Password is not invalid");
//			}
//			if (!isStringOnlyAlphabet(candEntity.getFirstname())) {
//				throw new PortalException("FirstName is not invalid");
//			}
//			if (!isStringOnlyAlphabet(candEntity.getLastname())) {
//				throw new PortalException("Lastname is not invalid");
//			}
////			if (!isStringOnlyAlphabet(candEntity.getCity())) {
////				throw new PortalException("City is not invalid");
////			}
////			validateCountryWithPhoneNumber(country, contactNo, dateAsString);
//			if (!(country.equals(INDIA) || country.equals(US))) {
//				throw new PortalException(INVALID_COUNTRY);
//			}
//		}
//	}
//
//	private void validateCountryWithPhoneNumber(String country, String contactNo, String dateAsString)
//			throws PortalException {
//		if (isStringOnlyAlphabet(country)) {
//			if (isNumeric(contactNo)) {
//				switch (country) {
//				case INDIA:
//					validateIndiaContact(contactNo, dateAsString);
//					break;
//				case US:
//					validateUSContact(contactNo, dateAsString);
//					break;
//				default:
//					throw new PortalException(INVALID_COUNTRY);
//				}
//			} else {
//				throw new PortalException(INVALID_COUNTRY);
//			}
//		}
//	}
//
//	private void validateIndiaContact(String contactNo, String dateAsString) throws PortalException {
//		if (!isValidIndianPhoneNumber(contactNo)) {
//			throw new PortalException(INVALID_CONTACT_NUMBER);
//		}
//		if (!isValidDate(dateAsString, indiaDateFormat)) {
//			throw new PortalException(INVALID_DATE);
//		}
//	}
//
//	private void validateUSContact(String contactNo, String dateAsString) throws PortalException {
//		if (!isValidUSPhoneNumber(contactNo)) {
//			logger.error("US Phone Number must be in the form XXX-XXXXXXX");
//			throw new PortalException(INVALID_CONTACT_NUMBER);
//		}
//		if (!isValidDate(dateAsString, usDateFormat)) {
//			throw new PortalException(INVALID_DATE);
//		}
//	}
//
//	public boolean isTemplateValid(MultipartFile file) {
//		boolean isFileTypeValid = false;
//		String fileOriginalName = file.getOriginalFilename();
//		int dotIndex = file.getOriginalFilename().lastIndexOf(".");
//		String extension = fileOriginalName.substring(dotIndex);
//		if (Arrays.stream(fileTypes).anyMatch(extension::equals)) {
//			logger.info("Uploaded file type is : {}", extension);
//			isFileTypeValid = true;
//		}
//		return isFileTypeValid;
//	}
//
//	public static boolean isValidEmail(String email) {
//		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
//				+ "A-Z]{2,7}$";
//
//		Pattern pat = Pattern.compile(emailRegex);
//		if (email == null)
//			return false;
//		return pat.matcher(email).matches();
//	}
//
//	public static boolean isValidPassword(String password) {
//		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
//		Pattern p = Pattern.compile(regex);
//		if (password == null) {
//			return false;
//		}
//		Matcher m = p.matcher(password);
//		return m.matches();
//	}
//
//	public static boolean isStringOnlyAlphabet(String str) {
//		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
//	}
//
//	public static boolean isNumeric(String str) {
//		try {
//			Double.parseDouble(str);
//			return true;
//		} catch (NumberFormatException e) {
//			return false;
//		}
//	}
//
//	public static boolean isValidDate(final String dateAsString, final String dateFormat) {
//		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
//		try {
//			final Date date = simpleDateFormat.parse(dateAsString);
//			logger.info("Date: {}", date);
//			return true;
//		} catch (ParseException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	public static boolean isValidIndianPhoneNumber(String phoneNumber) {
//		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
//		Matcher m = p.matcher(phoneNumber);
//		return (m.find() && m.group().equals(phoneNumber));
//	}
//
//	public static boolean isValidUSPhoneNumber(String phoneNumber) {
//		Pattern p = Pattern.compile("\\([4-6]{1}[0-9]{2}\\) [0-9]{3}\\-[0-9]{4}$"); // Pattern p =
//																					// Pattern.compile("[0-9]?[0-9]{10}");
//		Matcher m = p.matcher(phoneNumber);
//		return (m.find() && m.group().equals(phoneNumber));
//	}
//
//	public void validateHREntity(HRFormRequest request) throws PortalException {
//		if (null != request) {
//			if (!isValidEmail(request.getEmailId())) {
//				throw new PortalException("EmailID is not invalid");
//			}
//			if (!isValidPassword(request.getPassword())) {
//				throw new PortalException("Password is not invalid");
//			}
//			if (!isStringOnlyAlphabet(request.getEmpName())) {
//				throw new PortalException("FirstName is not invalid");
//			}
//			if (!isNumeric(request.getEmpNo())) {
//				throw new PortalException("Employee ID is not invalid");
//			}
//		}
//	}
//}