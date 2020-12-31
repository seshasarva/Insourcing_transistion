package com.insourcing.validator;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.insourcing.entity.CandidateEntity;
import com.insourcing.model.HRFormRequest;
import com.insourcing.model.LoginFormRequest;
import com.insourcing.services.EncryptService;

@Component
public class EntityValidator {

	private static Logger logger = LogManager.getLogger(EntityValidator.class);

	@Autowired
	EncryptService encryptService;

	@Value("${insource.app.india.date.format}")
	private String indiaDateFormat;

	@Value("${insource.app.us.date.format}")
	private String usDateFormat;

	@Value("${insource.app.supported_excel_file_type}")
	private String[] excelFileTypes;

	@Value("${insource.app.supported_pdf_file_type}")
	private String[] templateFileTypes;

	@Value("${insource.app.supported_doc_file_type}")
	private String[] templateDocFileTypes;

	private static final String INDIA = "India";
	private static final String US = "US";
	private static final String INVALID_COUNTRY = "Country is invalid";
	private static final String PASSWORD = "password";
	private static final String EMAIL = "emailID";

	public boolean validateCandidateEntity(CandidateEntity candEntity) throws Exception {
		boolean validate = false;
		String password = null;
		String confirmPassword = null;
		String country = null;
		if (null != candEntity) {

			if (candEntity.getPassword() != null)
				if (!candEntity.getPassword().isEmpty())
					if (isValidEncryption(candEntity.getPassword()))
						password = encryptService.decrptPwd(candEntity.getPassword(), PASSWORD);
					else
						throw new Exception("Password is not encrypted");
				else
					throw new Exception("Password is not valid");
			else
				throw new Exception("Password is not valid");
			if (candEntity.getConfirmPassword() != null)
				if (!candEntity.getConfirmPassword().isEmpty())
					if (isValidEncryption(candEntity.getConfirmPassword()))
						confirmPassword = encryptService.decrptPwd(candEntity.getConfirmPassword(), PASSWORD);
					else
						throw new Exception("Confirm Password is not encrypted");
				else
					throw new Exception("Confirm Password is not valid");
			else
				throw new Exception("Confirm Password is not valid");
			if (!password.equals(confirmPassword))
				throw new Exception("Password and Confirm password must match");
			if (candEntity.getCountry() != null)
				country = candEntity.getCountry();
			else
				throw new Exception(INVALID_COUNTRY);
			if (!candEntity.getCountry().isEmpty())
				country = candEntity.getCountry();
			else
				throw new Exception(INVALID_COUNTRY);
			if (!isValidPassword(password)) {
				throw new Exception("Password is not valid");
			}
			if (!isValidPassword(confirmPassword)) {
				throw new Exception("Confirm Password is not valid");
			}
			if (!isStringOnlyAlphabet(candEntity.getFirstname())) {
				throw new Exception("FirstName is not valid");
			}
			if (!isStringOnlyAlphabet(candEntity.getLastname())) {
				throw new Exception("Lastname is not valid");
			}
			if (!isStringCurrentTitle(candEntity.getCurrentTitle())) {
				throw new Exception("Current title is not valid");
			}
			if (!(country.equals(INDIA) || country.equals(US))) {
				throw new Exception(INVALID_COUNTRY);
			}
			if (!isRefPhone(candEntity.getContactno())) {
				throw new Exception("Contact No is not valid");
			}
			validate = true;
		}
		return validate;
	}

	public boolean validateLogin(LoginFormRequest loginForm) throws Exception {
		boolean validate = false;
		String password = null;
		String emailID = null;
		if (null != loginForm) {

			if (loginForm.getPassword() != null)
				if (!loginForm.getPassword().isEmpty())
					if (isValidEncryption(loginForm.getPassword()))
						password = encryptService.decrptPwd(loginForm.getPassword(), PASSWORD);
					else
						throw new Exception("Password is not encrypted");
				else
					throw new Exception("Password is not valid");
			else
				throw new Exception("Password is not valid");

			if (loginForm.getEmailID() != null)
				if (!loginForm.getEmailID().isEmpty())
					if (isValidEncryption(loginForm.getEmailID()))
						emailID = encryptService.decrptPwd(loginForm.getEmailID(), EMAIL);
					else
						throw new Exception("emailID is not encrypted");
				else
					throw new Exception("emailID is not valid");
			else
				throw new Exception("emailID is not valid");

			if (!isValidPassword(password)) {
				throw new Exception("Password is not valid");
			}
			if (!isValidEmail(emailID)) {
				throw new Exception("emailID is not valid");
			}
			validate = true;
		}
		return validate;
	}

	private boolean isRefPhone(String str) {
		if (str != null) {
			if (str.length() == 10) {
				double j = (Double.parseDouble(str));
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	public boolean validateUploadCandidateEntity(CandidateEntity candEntity) throws Exception {
		boolean validate = false;
		if (null != candEntity) {
			String country = candEntity.getCountry();
			if (!isValidEmail(candEntity.getEmailid())) {
				throw new Exception("emailID is not valid");
			}
			if (!isStringOnlyAlphabet(candEntity.getFirstname())) {
				throw new Exception("FirstName is not valid");
			}
			if (candEntity.getMiddlename() != null || !candEntity.getMiddlename().isEmpty()) {
				if (!isStringOnlyAlphabet(candEntity.getMiddlename())) {
					throw new Exception("MiddleName is not valid");
				}
			}
			if (candEntity.getLastname() != null || !candEntity.getLastname().isEmpty()) {
				if (!isStringOnlyAlphabet(candEntity.getLastname())) {
					throw new Exception("LastName is not valid");
				}
			}
			if (candEntity.getCurrentTitle() != null || !candEntity.getCurrentTitle().isEmpty()) {
				if (!isStringOnlyAlphabet(candEntity.getCurrentTitle())) {
					throw new Exception("Current title is not valid");
				}
			}
			if (candEntity.getContactno() != null || !candEntity.getContactno().isEmpty()) {
				if (!isValidIndianPhoneNumber(candEntity.getContactno())) {
					throw new Exception("Contact No is not valid");
				}
			}
			if (candEntity.getCity() != null || !candEntity.getCity().isEmpty()) {
				if (!isStringOnlyAlphabet(candEntity.getCity())) {
					throw new Exception("City is not valid");
				}
			}
			if (candEntity.getNotice() != null || !candEntity.getNotice().isEmpty()) {
				if (!isStringOnlyAlphabet(candEntity.getNotice())) {
					throw new Exception("Notice is not valid");
				}
			}
			if (candEntity.getPassword() != null || !candEntity.getPassword().isEmpty()) {
				if (!isValidPassword(candEntity.getPassword())) {
					throw new Exception("Password is not valid");
				}
			}
			if (!(country.equals(INDIA) || country.equals(US))) {
				throw new Exception(INVALID_COUNTRY);
			}
			validate = true;
		}
		return validate;
	}

	public boolean validateRequest(String emailId, String newPassword)
			throws Exception, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		boolean validate = false;
		if (null != emailId && null != newPassword) {
			String emailID = encryptService.decrptPwd(emailId, EMAIL);
			String password = encryptService.decrptPwd(newPassword, PASSWORD);
			if (!isValidEmail(emailID)) {
				throw new Exception("emailID is not valid");
			}
			if (!isValidPassword(password)) {
				throw new Exception("Password is not valid");
			}
			validate = true;
		}
		return validate;
	}

	public boolean validateCandidateRequest(String emailId, String curPassword, String newPassword)
			throws Exception, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		boolean validate = false;
		if (null != emailId && null != curPassword && null != newPassword) {
			String currentPassword = encryptService.decrptPwd(curPassword, PASSWORD);
			String password = encryptService.decrptPwd(newPassword, PASSWORD);
			if (!isValidEmail(emailId)) {
				throw new Exception("emailID is not valid");
			}
			if (!isValidPassword(currentPassword)) {
				throw new Exception("currentPassword is not valid");
			}
			if (!isValidPassword(password)) {
				throw new Exception("Password is not valid");
			}
			validate = true;
		}
		return validate;
	}

	public boolean isExcelValid(MultipartFile file) {
		boolean isFileTypeValid = false;
		String fileOriginalName = file.getOriginalFilename();
		int dotIndex = file.getOriginalFilename().lastIndexOf(".");
		String extension = fileOriginalName.substring(dotIndex);
		if (Arrays.stream(excelFileTypes).anyMatch(extension::equals)) {
			logger.info("Uploaded file type is : {}", extension);
			isFileTypeValid = true;
		}
		return isFileTypeValid;
	}

	public boolean isTemplateValid(MultipartFile file) {
		boolean isFileTypeValid = false;
		String fileOriginalName = file.getOriginalFilename();
		int dotIndex = file.getOriginalFilename().lastIndexOf(".");
		String extension = fileOriginalName.substring(dotIndex);
		if (Arrays.stream(templateFileTypes).anyMatch(extension::equals)) {
			logger.info("Uploaded file type is : {}", extension);
			isFileTypeValid = true;
		}
		return isFileTypeValid;
	}

	public boolean isDocTemplateValid(MultipartFile file) {
		boolean isFileTypeValid = false;
		String fileOriginalName = file.getOriginalFilename();
		int dotIndex = file.getOriginalFilename().lastIndexOf(".");
		String extension = fileOriginalName.substring(dotIndex);
		if (Arrays.stream(templateDocFileTypes).anyMatch(extension::equals)) {
			logger.info("Uploaded file type is : {}", extension);
			isFileTypeValid = true;
		}
		return isFileTypeValid;
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isValidPassword(String password) {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(regex);
		if (password == null) {
			return false;
		} else if (password.isEmpty()) {
			return false;
		}
		Matcher m = p.matcher(password);
		return m.matches();
	}

	public static boolean isValidEncryption(String str) {
		return ((str != null) && (!str.equals(""))
				&& (str.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$")));
	}

	public static boolean isStringOnlyAlphabet(String str) {
		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
	}

	public static boolean isStringCurrentTitle(String str) {
		return ((str != null) && (!str.equals("")));
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isValidDate(final String dateAsString, final String dateFormat) {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		try {
			final Date date = simpleDateFormat.parse(dateAsString);
			logger.info("Date: {}", date);
			return true;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean isValidIndianPhoneNumber(String phoneNumber) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(phoneNumber);
		return (m.find() && m.group().equals(phoneNumber));
	}

	public static boolean isValidUSPhoneNumber(String phoneNumber) {
		Pattern p = Pattern.compile("\\([4-6]{1}[0-9]{2}\\) [0-9]{3}\\-[0-9]{4}$");
		Matcher m = p.matcher(phoneNumber);
		return (m.find() && m.group().equals(phoneNumber));
	}

	public void validateHREntity(HRFormRequest request) throws Exception {
		if (null != request) {
			if (!isValidEmail(request.getEmailId())) {
				throw new Exception("EmailID is not valid");
			}
			if (!isValidPassword(request.getPassword())) {
				throw new Exception("Password is not valid");
			}
			if (!isStringOnlyAlphabet(request.getEmpName())) {
				throw new Exception("FirstName is not valid");
			}
			if (!isNumeric(request.getEmpNo())) {
				throw new Exception("Employee ID is not valid");
			}
		}
	}
}