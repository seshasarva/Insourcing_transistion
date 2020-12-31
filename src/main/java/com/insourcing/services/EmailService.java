package com.insourcing.services;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.PreencodedMimeBodyPart;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.insourcing.entity.CandidateEntity;
import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.entity.LoginUserDetails;
import com.insourcing.entity.OfferIndiaEntity;
import com.insourcing.model.EmailNotificationRequest;
import com.insourcing.model.ManagePasswordRequest;
import com.insourcing.model.OfferModel;

@Service
public class EmailService {
	private static final Logger logger = LogManager.getLogger(EmailService.class);

	// CommonHelper commonHelper = new CommonHelper();

	@Autowired
	private JavaMailSender javaMailSender;

	// @Autowired
	// private EmailTemplateRepo emailTemplateRepo;

	@Value("${email.feature.switch}")
	private boolean emailSwitch;

	public void sendEmail(EmailNotificationRequest emailNotificationRequest) throws MessagingException, IOException {
		logger.info("EmailService :: sendEmail() :: emailSwitch :: " + emailSwitch);
		String message = emailNotificationRequest.getMessage();
		String subject = emailNotificationRequest.getSubject();
		for (String toEmail : emailNotificationRequest.getToEmail()) {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(toEmail);
			msg.setSubject(subject);
			msg.setText(message);
			if (emailNotificationRequest.isHasAttachment()) {
				sendEmailWithAttachment(emailNotificationRequest, toEmail);
			} else {
				if (emailSwitch)
					javaMailSender.send(msg);
			}
		}
	}

	public void sendEmailWithAttachment(EmailNotificationRequest emailNotificationRequest, String toEmail)
			throws MessagingException, IOException {
		logger.info("EmailService :: sendEmailWithAttachment() :: emailSwitch :: " + emailSwitch);
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setSubject(emailNotificationRequest.getSubject());
		helper.setTo(toEmail);
		helper.setText(emailNotificationRequest.getMessage());
		Multipart multipart = new MimeMultipart();
		MimeBodyPart filePart = new PreencodedMimeBodyPart("base64");
		filePart.setFileName(emailNotificationRequest.getFileName());
		filePart.setText(emailNotificationRequest.getAttachment().split(",")[1].trim());
		multipart.addBodyPart(filePart);
		msg.setContent(multipart);
		if (emailSwitch)
			javaMailSender.send(msg);
	}

	// Account creation mail to candidates
	public void sendAccountCreationEmail(List<CandidateEntity> candidates) throws MessagingException, IOException {
		logger.info("EmailService :: sendAccountCreationEmail() :: emailSwitch :: " + emailSwitch);
		SimpleMailMessage msg = new SimpleMailMessage();
		for (CandidateEntity can : candidates) {
			msg.setTo(can.getEmailid());
			msg.setSubject("REXA - Insourcing portal - Account created");
			msg.setText("Dear Associate," + "\r\n"
					+ " Your account has been successfully created in REXA - Insourcing portal." + "\r\n"
					+ " Tata Consultancy Services (TCS) is pleased to start you on your journey to new opportunities.\r\n"
					+ " Please click the button below to sign into the secure TCS Transition Portal where you will receive all the information and steps required for a position with TCS.\r\n"
					+ " You will need the information below to sign in for the first time: \r\n" + "•"
					+ can.getEmailid() + "\r\n" + "•" + can.getPassword() + "\r\n"
					+ "Upon initial login, you will be prompted to change your password and complete your profile information.\r\n"
					+ "Once logged in you will be able to view your <offer letter>, <process of applying>;  benefit offerings, review Frequently Asked Questions, and learn about TCS. \r\n"
					+ "If you require technical support, please submit XXXXX");
			if (emailSwitch)
				javaMailSender.send(msg);
		}
	}

	// Intimation mail for Changed password to candidates
	public void sendChangePwdEmail(String emailId, String newPassword) throws MessagingException, IOException {

		logger.info("EmailService :: sendChangePwdEmail() :: emailSwitch :: " + emailSwitch);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(emailId);
		msg.setSubject("REXA - Insourcing portal - New password generated");
		msg.setText(
				"Dear Associate, As per TCS Registration policy, You have successfully changed your password,Here is your new password for your reference "
						+ newPassword);
		if (emailSwitch)
			javaMailSender.send(msg);

	}

	// Intimation mail for Filled Application Form to candidates
	public void sendFilledAppFormEmail(String emailId) throws MessagingException, IOException {

		logger.info("EmailService :: sendFilledAppFormEmail() :: emailSwitch :: " + emailSwitch);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(emailId);
		msg.setSubject("REXA - Insourcing portal - New password generated");
		msg.setText(
				"Dear Associate, Thank you for completing the TCS Application Form.  A representative from the TCS Talent Acquisition team will contact you shortly.");
		if (emailSwitch)
			javaMailSender.send(msg);

	}

	// India Offer Generated Mail to candidates
	public void sendIndiaOfferGenEmail(OfferIndiaEntity offerModel) throws MessagingException, IOException {
		logger.info("EmailService :: sendIndiaOfferGenEmail() :: emailSwitch :: " + emailSwitch);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(offerModel.getEmailId());
		msg.setSubject("Offer/Retention Letter Generated");
		msg.setText("Dear Associate,\r\n" + "Congratulations!\r\n"
				+ "Tata Consultancy Services (TCS) is pleased to present to you an offer of employment. Please view your offer by logging into the secure TCS Transition Portal. Once in the portal please insert the X-digit code below to view and respond to your offer. You will be asked to change your password upon initial log in.  All information is confidential. Once logged in you will be able to view benefit offerings, Frequently Asked Questions, and other information about TCS to assist with your decision. There is also an opportunity to send a query online if you seek additional information.\r\n"
				+ "Best Regards,\r\n" + "TCS Transition Team");
		if (emailSwitch)
			javaMailSender.send(msg);
	}

	// US Offer or Retention Generated Mail to candidates
	public void sendUSOfferGenEmail(OfferModel offerModel) throws MessagingException, IOException {
		logger.info("EmailService :: sendUSOfferGenEmail() :: emailSwitch :: " + emailSwitch);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(offerModel.getEmailId());
		msg.setSubject("Offer/Retention Letter Generated");
		msg.setText("Dear Associate,\r\n" + "Congratulations!\r\n"
				+ "Tata Consultancy Services (TCS) is pleased to present to you an offer of employment. Please view your offer by logging into the secure TCS Transition Portal. Once in the portal please insert the X-digit code below to view and respond to your offer. You will be asked to change your password upon initial log in.  All information is confidential. Once logged in you will be able to view benefit offerings, Frequently Asked Questions, and other information about TCS to assist with your decision. There is also an opportunity to send a query online if you seek additional information.\r\n"
				+ "Best Regards,\r\n" + "TCS Transition Team");
		if (emailSwitch)
			javaMailSender.send(msg);
	}

	// Accept Offer or Retention Generated Mail to candidates
	public void offerAcceptEmail(String email, String status, CandidateEntityMap candEntityMap)
			throws MessagingException, IOException {
		logger.info("EmailService :: offerAcceptEmail() :: emailSwitch :: " + emailSwitch);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Offer/Retention Letter Accepted");
		msg.setText("Dear Associate,\r\n" + "Congratulations!\r\n"
				+ "TCS is very excited that you have accepted our offer.  Please watch for directions by the Onboarding Team for instructions on all Pre-Joining actions which are to be completed no later than 10 days prior to your join date with TCS."
				+ "\r\nBest Regards,\r\n" + "TCS Transition Team");
		if (emailSwitch)
			javaMailSender.send(msg);
	}

	// Reject Offer or Retention Generated Mail to candidates
	public void offerRejectEmail(String email, String status, CandidateEntityMap candEntityMap)
			throws MessagingException, IOException {
		logger.info("EmailService :: offerRejectEmail() :: emailSwitch :: " + emailSwitch);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Offer/Retention Letter Rejected");
		msg.setText("Dear Associate,\r\n" + "Sorry!\r\n"
				+ "We are disappointed to hear of your decision to decline TCS’ offer of employment. We hope to have addressed your concerns and that you will reconsider the offer. If you wish to change your decision, you have X days to do so.  Please return to <directions> to do so.\r\n"
				+ "Best Regards,\r\n" + "TCS Transition Team");
		if (emailSwitch)
			javaMailSender.send(msg);
	}

	public void sendForgotPwdEmail(ManagePasswordRequest request) throws MessagingException, IOException {
		logger.info("EmailService :: sendForgotPwdEmail() :: emailSwitch :: " + emailSwitch);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(request.getUserName());
		msg.setSubject("REXA - Insourcing portal - New password generated");
		msg.setText("Dear Associate, As per your forgot password request, please find below your new password is "
				+ request.getNewPassword());
		if (emailSwitch)
			javaMailSender.send(msg);

	}

	public void sendAccountCreationEmailHRBC(List<LoginUserDetails> userDetails, HttpServletRequest request)
			throws MessagingException, IOException {
		logger.info("EmailService :: sendAccountCreationEmail() :: emailSwitch :: " + emailSwitch);
		SimpleMailMessage msg = new SimpleMailMessage();
		for (LoginUserDetails user : userDetails) {
			msg.setTo(user.getUsername());
			msg.setSubject("REXA - Insourcing portal - Account created");
			msg.setText("Dear Associate, Your HRBC account has been successfully created in REXA - HRBC portal by "
					+ request.getSession().getAttribute("LOGGED_USER_NAME").toString()
					+ ". Please login with your email address as User Name and default password as password");
			if (emailSwitch)
				javaMailSender.send(msg);
		}
	}

}
