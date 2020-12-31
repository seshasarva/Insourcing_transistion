package com.insourcing.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.PreencodedMimeBodyPart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.insourcing.entity.AppIndiaExtraFieldsEntity;
import com.insourcing.entity.AppUsExtraFieldsEntity;
import com.insourcing.entity.EmailTempEntity;
import com.insourcing.entity.WorkflowSeqEntity;
import com.insourcing.exception.PortalException;
import com.insourcing.helper.ExcelReaderII;
import com.insourcing.model.AppIndiaExtraFieldsRequest;
import com.insourcing.model.AppUsExtraFieldsRequest;
import com.insourcing.model.EmailExcelTemplate;
import com.insourcing.model.EmailNotificationRequest;
import com.insourcing.model.EmailTemplateRequest;
import com.insourcing.model.EmailTemplateResponse;
import com.insourcing.model.WorkflowSeqModel;
import com.insourcing.repository.AppIndiaExtraFieldsRepo;
import com.insourcing.repository.AppUsExtraFieldsRepo;
import com.insourcing.repository.EmailTemplateRepo;
import com.insourcing.repository.WorkFlowSeqRepo;

@Service
public class HRServiceII {

	private static Logger logger = LogManager.getLogger(HRServiceII.class);

	@Value("${insource.app.india.date.format}")
	private String indiaDateFormat;

	@Value("${insource.app.india.zone.id}")
	private String indiaZoneId;

	@Value("${email.feature.switch}")
	private boolean emailSwitch;

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private EmailTemplateRepo emailTemplateRepo;
	@Autowired
	private AppIndiaExtraFieldsRepo appExtraFieldsRepo;
	@Autowired
	private AppUsExtraFieldsRepo appUsExtraFieldsRepo;
	@Autowired
	private WorkFlowSeqRepo workFlowSeqRepo;

	private static final String EXCEED_CANDIDATES_COUNT = "Please upload less than 2000 candidates";

	public void saveTemplate(EmailTemplateRequest request) {
		logger.info("EmailTemplateDetails - Entry");
		// String message = "";
		// int templateId = 0;
		// templateId = templateId + 1;
		EmailTempEntity emailTempEntity;
		emailTempEntity = new ModelMapper().map(request, EmailTempEntity.class);
		logger.info("EmailTemplateDetails - Mapped");
		// emailTempEntity.setTemplateId(templateId);
		/*
		 * emailTempEntity.setTemplateName(request.getTemplateName());
		 * //emailTempEntity.setTemplateCreatedDate(LocalDateTime.now());
		 * emailTempEntity.setStatus(request.getStatus());
		 * emailTempEntity.setSubject(request.getSubject());
		 * emailTempEntity.setMessage(request.getMessage());
		 */
		emailTemplateRepo.save(emailTempEntity);
		// message = HttpStatus.OK.toString();

		logger.info("EmailTemplateDetails - Saved");
		// return message;
	}

	public EmailTemplateResponse chooseTemplate(EmailTemplateRequest request) {
		EmailTemplateResponse emailTemplateResponse = new EmailTemplateResponse();
		EmailTempEntity emailTempEntity = emailTemplateRepo.findByTemplateName(request.getTemplateName());
		logger.info(emailTempEntity);
		emailTemplateResponse.setMessage(emailTempEntity.getMessage());
		emailTemplateResponse.setStatus(emailTempEntity.getStatus());
		emailTemplateResponse.setSubject(emailTempEntity.getSubject());
		return emailTemplateResponse;
	}

	public List<EmailTempEntity> getTemplate(EmailTemplateRequest request) {
		logger.info("Get Template - Entry");
		return emailTemplateRepo.findByEmaiId(request.getEmailId());
	}

	public String sendMultipleEmail(EmailNotificationRequest list, MultipartFile excelFile) {
		logger.info("Send Email - Entry");
		String message = null;
		try {
			List<EmailExcelTemplate> excelList = ExcelReaderII
					.excelToEmailExcelTemplateModel(excelFile.getInputStream());
			logger.info(excelList);
			if (excelList.isEmpty()) {
				message = EXCEED_CANDIDATES_COUNT;
				logger.info(EXCEED_CANDIDATES_COUNT);
				throw new PortalException(EXCEED_CANDIDATES_COUNT);
			} else {
				for (EmailExcelTemplate emailExcelList : excelList) {
					message = replaceEmailTemplate(emailExcelList, list);
				}
			}
		} catch (Exception ex) {
			message = "Please try again";
			logger.error(ex);
		}
		logger.info("Send Email - Exit");
		return message;
	}

	public String replaceEmailTemplate(EmailExcelTemplate emailExcelList, EmailNotificationRequest emailTemplate)
			throws MessagingException, IOException {
		logger.info("replaceEmailTemplate - Entry");
		String message = null;
		String middleName = null;
		String strJoiningDate = new SimpleDateFormat(indiaDateFormat).format(emailExcelList.getJoiningDate());
		String baseSalary = String.valueOf((int) emailExcelList.getBaseSalary());

		EmailNotificationRequest replacedTemplate = new EmailNotificationRequest();

		if (emailExcelList.getMiddleName() != null)
			middleName = emailExcelList.getMiddleName();
		else
			middleName = "";

		replacedTemplate.setSubject(emailTemplate.getSubject().replace("#OfferStatus", emailExcelList.getOfferStatus())
				.replace("#JoiningDate", strJoiningDate));
		replacedTemplate.setMessage(emailTemplate.getMessage().replace("#FirstName", emailExcelList.getFirstName())
				.replace("#MiddleName", middleName).replace("#LastName", emailExcelList.getLastName())
				.replace("#BaseSalary", baseSalary).replace("#OfferStatus", emailExcelList.getOfferStatus())
				.replace("#JoniningDate", strJoiningDate));

		logger.info(replacedTemplate);
		if (replacedTemplate != null)
			message = sendEmail(replacedTemplate);
		logger.info("replaceEmailTemplate - Exit");
		return message;
	}

	public String sendEmail(EmailNotificationRequest emailNotificationRequest) throws MessagingException, IOException {
		logger.info("EmailService :: sendEmail() :: emailSwitch :: " + emailSwitch);
		String returnMessage = null;
		String message = emailNotificationRequest.getMessage();
		String subject = emailNotificationRequest.getSubject();
		String emailId = emailNotificationRequest.getEmailId();

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(emailId);
		msg.setSubject(subject);
		msg.setText(message);
		if (emailNotificationRequest.isHasAttachment()) {
			returnMessage = sendEmailWithAttachment(emailNotificationRequest, emailId);
		} else {
			if (emailSwitch)
				javaMailSender.send(msg);
		}
		returnMessage = "Email sent successfully";

		return returnMessage;
	}

	public String sendEmailWithAttachment(EmailNotificationRequest emailNotificationRequest, String emailId)
			throws MessagingException, IOException {
		logger.info("EmailService :: sendEmailWithAttachment() :: emailSwitch :: " + emailSwitch);
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setSubject(emailNotificationRequest.getSubject());
		helper.setTo(emailId);
		helper.setText(emailNotificationRequest.getMessage());
		Multipart multipart = new MimeMultipart();
		MimeBodyPart filePart = new PreencodedMimeBodyPart("base64");
		filePart.setFileName(emailNotificationRequest.getFileName());
		filePart.setText(emailNotificationRequest.getAttachment().split(",")[1].trim());
		multipart.addBodyPart(filePart);
		msg.setContent(multipart);
		if (emailSwitch)
			javaMailSender.send(msg);

		return "Email sent successfully";
	}

	public String appIndiaExtraFieldsUpdate(AppIndiaExtraFieldsRequest request) {
		String message = null;
		logger.info("appIndiaExtraFieldsUpdate - Entry");
		request = updateIndiaExtraFields(request);
		AppIndiaExtraFieldsEntity appExtraFieldsEntity;
		appExtraFieldsEntity = new ModelMapper().map(request, AppIndiaExtraFieldsEntity.class);
		appExtraFieldsRepo.save(appExtraFieldsEntity);
		message = "success";
		logger.info("appIndiaExtraFieldsUpdate - Exit");
		return message;
	}

	private AppIndiaExtraFieldsRequest updateIndiaExtraFields(AppIndiaExtraFieldsRequest request) {
		logger.info("updateExtraFields - Entry");
		if (request.getFieldOne() != null)
			if (request.getFieldOne().isDisplay())
				request.setExtraFieldOne(request.getFieldOne().getTitleName());
			else
				request.setExtraFieldOne(
						request.getFieldOne().getTitleName() + ", " + request.getFieldOne().isDisplay());
		if (request.getFieldTwo() != null)
			if (request.getFieldTwo().isDisplay())
				request.setExtraFieldTwo(request.getFieldTwo().getTitleName());
			else
				request.setExtraFieldTwo(
						request.getFieldTwo().getTitleName() + ", " + request.getFieldTwo().isDisplay());
		if (request.getFieldThree() != null)
			if (request.getFieldThree().isDisplay())
				request.setExtraFieldThree(request.getFieldThree().getTitleName());
			else
				request.setExtraFieldThree(
						request.getFieldThree().getTitleName() + ", " + request.getFieldThree().isDisplay());
		if (request.getFieldFour() != null)
			if (request.getFieldFour().isDisplay())
				request.setExtraFieldFour(request.getFieldFour().getTitleName());
			else
				request.setExtraFieldFour(
						request.getFieldFour().getTitleName() + ", " + request.getFieldFour().isDisplay());
		if (request.getFieldFive() != null)
			if (request.getFieldFive().isDisplay())
				request.setExtraFieldFive(request.getFieldFive().getTitleName());
			else
				request.setExtraFieldFive(
						request.getFieldFive().getTitleName() + ", " + request.getFieldFive().isDisplay());
		if (request.getFieldSix() != null)
			if (request.getFieldSix().isDisplay())
				request.setExtraFieldSix(request.getFieldSix().getTitleName());
			else
				request.setExtraFieldSix(
						request.getFieldSix().getTitleName() + ", " + request.getFieldSix().isDisplay());
		if (request.getFieldSeven() != null)
			if (request.getFieldSeven().isDisplay())
				request.setExtraFieldSeven(request.getFieldSeven().getTitleName());
			else
				request.setExtraFieldSeven(
						request.getFieldSeven().getTitleName() + ", " + request.getFieldSeven().isDisplay());
		if (request.getFieldEight() != null)
			if (request.getFieldEight().isDisplay())
				request.setExtraFieldEight(request.getFieldEight().getTitleName());
			else
				request.setExtraFieldEight(
						request.getFieldEight().getTitleName() + ", " + request.getFieldEight().isDisplay());
		if (request.getFieldNine() != null)
			if (request.getFieldNine().isDisplay())
				request.setExtraFieldNine(request.getFieldNine().getTitleName());
			else
				request.setExtraFieldNine(
						request.getFieldNine().getTitleName() + ", " + request.getFieldNine().isDisplay());
		if (request.getFieldTen() != null)
			if (request.getFieldTen().isDisplay())
				request.setExtraFieldTen(request.getFieldTen().getTitleName());
			else
				request.setExtraFieldTen(
						request.getFieldTen().getTitleName() + ", " + request.getFieldTen().isDisplay());
		logger.info("updateExtraFields - Exit");
		return request;
	}

	public String appUsExtraFieldsUpdate(AppUsExtraFieldsRequest request) {
		String message = null;
		logger.info("appUsExtraFieldsUpdate - Entry");
		request = updateUssExtraFields(request);
		AppUsExtraFieldsEntity appExtraFieldsEntity;
		appExtraFieldsEntity = new ModelMapper().map(request, AppUsExtraFieldsEntity.class);
		logger.info(appExtraFieldsEntity);
		appUsExtraFieldsRepo.save(appExtraFieldsEntity);
		message = "success";
		logger.info("appUsExtraFieldsUpdate - Exit");
		return message;
	}

	private AppUsExtraFieldsRequest updateUssExtraFields(AppUsExtraFieldsRequest request) {
		logger.info("updateUssExtraFields - Entry");
		if (request.getFieldOne() != null)
			if (request.getFieldOne().isDisplay())
				request.setExtraFieldOne(request.getFieldOne().getTitleName());
			else
				request.setExtraFieldOne(
						request.getFieldOne().getTitleName() + ", " + request.getFieldOne().isDisplay());
		if (request.getFieldTwo() != null)
			if (request.getFieldTwo().isDisplay())
				request.setExtraFieldTwo(request.getFieldTwo().getTitleName());
			else
				request.setExtraFieldTwo(
						request.getFieldTwo().getTitleName() + ", " + request.getFieldTwo().isDisplay());
		if (request.getFieldThree() != null)
			if (request.getFieldThree().isDisplay())
				request.setExtraFieldThree(request.getFieldThree().getTitleName());
			else
				request.setExtraFieldThree(
						request.getFieldThree().getTitleName() + ", " + request.getFieldThree().isDisplay());
		if (request.getFieldFour() != null)
			if (request.getFieldFour().isDisplay())
				request.setExtraFieldFour(request.getFieldFour().getTitleName());
			else
				request.setExtraFieldFour(
						request.getFieldFour().getTitleName() + ", " + request.getFieldFour().isDisplay());
		if (request.getFieldFive() != null)
			if (request.getFieldFive().isDisplay())
				request.setExtraFieldFive(request.getFieldFive().getTitleName());
			else
				request.setExtraFieldFive(
						request.getFieldFive().getTitleName() + ", " + request.getFieldFive().isDisplay());
		if (request.getFieldSix() != null)
			if (request.getFieldSix().isDisplay())
				request.setExtraFieldSix(request.getFieldSix().getTitleName());
			else
				request.setExtraFieldSix(
						request.getFieldSix().getTitleName() + ", " + request.getFieldSix().isDisplay());
		if (request.getFieldSeven() != null)
			if (request.getFieldSeven().isDisplay())
				request.setExtraFieldSeven(request.getFieldSeven().getTitleName());
			else
				request.setExtraFieldSeven(
						request.getFieldSeven().getTitleName() + ", " + request.getFieldSeven().isDisplay());
		if (request.getFieldEight() != null)
			if (request.getFieldEight().isDisplay())
				request.setExtraFieldEight(request.getFieldEight().getTitleName());
			else
				request.setExtraFieldEight(
						request.getFieldEight().getTitleName() + ", " + request.getFieldEight().isDisplay());
		if (request.getFieldNine() != null)
			if (request.getFieldNine().isDisplay())
				request.setExtraFieldNine(request.getFieldNine().getTitleName());
			else
				request.setExtraFieldNine(
						request.getFieldNine().getTitleName() + ", " + request.getFieldNine().isDisplay());
		if (request.getFieldTen() != null)
			if (request.getFieldTen().isDisplay())
				request.setExtraFieldTen(request.getFieldTen().getTitleName());
			else
				request.setExtraFieldTen(
						request.getFieldTen().getTitleName() + ", " + request.getFieldTen().isDisplay());
		logger.info("updateUssExtraFields - Exit");
		return request;
	}

	public AppIndiaExtraFieldsRequest appIndiaFormFields(String dealId) {
		logger.info("appIndiaFormFields - Entry");
		AppIndiaExtraFieldsRequest fields = new AppIndiaExtraFieldsRequest();
		AppIndiaExtraFieldsEntity fieldsEntity = new AppIndiaExtraFieldsEntity();
		fieldsEntity = appExtraFieldsRepo.findByDealId(dealId);
		logger.info(fieldsEntity);
		fields = new ModelMapper().map(fieldsEntity, AppIndiaExtraFieldsRequest.class);
		logger.info("appIndiaFormFields - Exit");
		return fields;
	}

	public AppUsExtraFieldsRequest appUsFormFields(String dealId) {
		logger.info("appUsFormFields - Entry");
		AppUsExtraFieldsRequest fields = new AppUsExtraFieldsRequest();
		AppUsExtraFieldsEntity fieldsEntity = new AppUsExtraFieldsEntity();
		fieldsEntity = appUsExtraFieldsRepo.findByDealId(dealId);
		fields = new ModelMapper().map(fieldsEntity, AppUsExtraFieldsRequest.class);
		logger.info("appUsFormFields - Exit");
		return fields;
	}

	public String workflowSequence(WorkflowSeqModel workFlowSeq) {
		logger.info("workflowSequence - Entry");
		WorkflowSeqEntity flowEntity = new WorkflowSeqEntity();
		flowEntity = new ModelMapper().map(workFlowSeq, WorkflowSeqEntity.class);
		workFlowSeqRepo.save(flowEntity);
		logger.info("workflowSequence - Exit");
		return "success";
	}

}
