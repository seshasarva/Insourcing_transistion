package com.insourcing.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insourcing.config.ChatbotServiceConstants;
import com.insourcing.exception.InvalidRequestException;
import com.insourcing.model.QueryInformation;
import com.insourcing.model.QueryInput;
import com.insourcing.model.ReplyInformation;
import com.insourcing.services.DialogFlowService;
import com.insourcing.validator.TokenValidator;

@CrossOrigin
@RestController
@Configuration
@RequestMapping("/chatbot")
@Scope("prototype")
@PropertySource("classpath:insourcingbot.properties")
public class ChatbotController {

	@Autowired
	DialogFlowService dialogflowutil;

	ReplyInformation replyInfo = new ReplyInformation();

	@Autowired
	TokenValidator tokenValidator;

	final String[] ALLOWED_FIELDS = new String[] { "query", "sessionID", "country" };
	private static final String HEADER = "Authorization";
	private static final String PREFIX = "Bearer ";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields(ALLOWED_FIELDS);
	}

	private final static Logger logger = Logger.getLogger(ChatbotController.class);

	@PostMapping(value = "/process/query")
	public ResponseEntity<ReplyInformation> ProcessIndiaQuery(@RequestBody QueryInformation queryinfo,
			HttpServletRequest httpRequest) throws FileNotFoundException, IOException {
		logger.debug("GetReplyForQuery : Entry");
		boolean tokenValidate;
		String jwtToken = httpRequest.getHeader(HEADER).replace(PREFIX, "");
		String emailId = tokenValidator.decodeEmailId(jwtToken);
		try {
			tokenValidate = tokenValidator.tokenValidator(emailId, jwtToken);
			if (tokenValidate) {
				String validationError = validateInputRequest(queryinfo);
				if (validationError != null) {
					throw new InvalidRequestException(validationError);
				}
				logger.debug("Query" + queryinfo.getQuery());
				String sessionID = queryinfo.getSessionID();
				logger.info("sessionID is" + sessionID);
				if (sessionID == null) {
					sessionID = UUID.randomUUID().toString();
					logger.info("sessionID is" + sessionID + "  " + sessionID.length());
				}
				String engagementBot = "";
				if (queryinfo.isPostOffer()) {
					engagementBot = ChatbotServiceConstants.POST_OFFER;
				} else {
					engagementBot = ChatbotServiceConstants.PRE_OFFER;
				}
				logger.info("Calling : " + engagementBot);
				QueryInput query = new QueryInput("en", queryinfo.getQuery());
				JSONObject jsonObj = new JSONObject(query.toString());
				String queryInputJSON = jsonObj.toString();
				// Date loggingDate = new Date(0);
				logger.info("try block is executing");
				replyInfo = dialogflowutil.getDialogFlowResponse(queryInputJSON, sessionID, queryinfo.getCountry(),
						engagementBot);
				// if(isRedFlagQuestion(replyInfo.getAnswer())) {
				// writeToExcel("User",queryinfo.getQuery(),replyInfo.getAnswer(),loggingDate);
				// }
			}
		} catch (Exception e) {
			logger.error("Error occurred : ", e);
		}
		logger.debug("GetReplyForQuery : Exit");
		return new ResponseEntity<>(replyInfo, HttpStatus.OK);
	}

	/*
	 * private boolean isRedFlagQuestion(String response) {
	 * System.out.println("Inside Redflag question methods"); boolean flag=false;
	 * ArrayList<String> redFlagResponse = new ArrayList<String>();
	 * redFlagResponse.add("what was that?".toLowerCase());
	 * redFlagResponse.add("One more time?".toLowerCase());
	 * redFlagResponse.add("I didn't get that. Can you say it again?".toLowerCase())
	 * ;
	 * redFlagResponse.add("I missed what you said. What was that?".toLowerCase());
	 * redFlagResponse.add("Sorry, could you say that again?".toLowerCase());
	 * redFlagResponse.add("Sorry, can you say that again?".toLowerCase());
	 * redFlagResponse.add("Can you say that again?".toLowerCase());
	 * redFlagResponse.add("Sorry, I didn't get that. Can you rephrase?".toLowerCase
	 * ()); redFlagResponse.add("Sorry, what was that?".toLowerCase());
	 * redFlagResponse.add("Say that one more time?".toLowerCase());
	 * redFlagResponse.add("I didn't get that. Can you repeat?".toLowerCase());
	 * redFlagResponse.add("I missed that, say that again?".toLowerCase());
	 * 
	 * if(redFlagResponse.contains(response.toLowerCase())) {
	 * System.out.println(response.toLowerCase()); flag=true; } return flag; }
	 * 
	 * private void writeToExcel(String uName, String question, String answer, Date
	 * loggingDate) { logExcel.writeToExcel(uName, question, answer, loggingDate); }
	 */

	/*
	 * @RequestMapping(value="/ProcessQueryMobileService", method =
	 * RequestMethod.POST)
	 * 
	 * @ResponseBody public ResponseEntity<ReplyInformationMobile>
	 * ProcessQueryMobileService(@RequestBody QueryInformationMobile queryinfo,
	 * HttpServletResponse response) throws FileNotFoundException, IOException {
	 * 
	 * logger.debug("ProcessQueryMobileService : Entry"); logger.debug("Query: " +
	 * queryinfo.getQuery()); ReplyInformationMobile replyInfoMobile = new
	 * ReplyInformationMobile(); logger.debug("replyInfoMobile: " +
	 * replyInfoMobile.toString());
	 * 
	 * if(!queryinfo.getCountry().isEmpty()) {
	 * if(queryinfo.getCountry().equalsIgnoreCase("Us")) {
	 * queryinfo.setCountry("US"); }else
	 * if(queryinfo.getCountry().equalsIgnoreCase("INDIA")) {
	 * queryinfo.setCountry("India"); } }
	 * 
	 * if(queryinfo.getQuery() == null || queryinfo.getQuery().isEmpty()) {
	 * logger.debug("Inside handleMobileStandardQuery"); replyInfoMobile =
	 * mobileServiceUtil.handleMobileStandardQuery(queryinfo); } else {
	 * logger.debug("Inside else handleMobileStandardQuery"); String sessionID =
	 * UUID.randomUUID().toString(); QueryInput query = new QueryInput("en",
	 * queryinfo.getQuery()); JSONObject jsonObj = new JSONObject(query.toString());
	 * String queryInputJSON = jsonObj.toString(); replyInfo =
	 * dialogflowutil.getDialogFlowResponse(queryInputJSON,
	 * sessionID,queryinfo.getCountry()); logger.debug("replyInfoMobile:" +
	 * replyInfoMobile.toString());
	 * replyInfoMobile.setAnswer(replyInfo.getAnswer());
	 * replyInfoMobile.setLeadingInformation(replyInfo.getLeadingInformation()); }
	 * 
	 * CacheControl.maxAge(100, TimeUnit.SECONDS); CacheControl.noCache(); String
	 * headerValue = CacheControl.noStore() .getHeaderValue();
	 * response.addHeader("Cache-Control", headerValue);
	 * response.addHeader("Connection", "Keep-Alive");
	 * 
	 * logger.debug("ProcessQueryMobileService : Exit"); return new
	 * ResponseEntity<>(replyInfoMobile , HttpStatus.OK); }
	 * 
	 * /** This method validates the input request
	 * 
	 * @param queryInfo
	 * 
	 * @return errorMessage
	 */
	private String validateInputRequest(QueryInformation queryInfo) {

		String errorMessage = " should not be null or empty";
		List<String> emptyFields = new ArrayList<String>();
		if (queryInfo.getQuery() == null || queryInfo.getQuery().isEmpty()) {
			emptyFields.add("query");
		} else if (queryInfo.getCountry() == null || queryInfo.getCountry().isEmpty()) {
			emptyFields.add("country");
		}
		if (!emptyFields.isEmpty()) {
			String fieldlist = String.join(",", emptyFields);
			errorMessage = fieldlist + ":" + errorMessage;
		} else {
			return null;
		}
		logger.debug("errormessage in validateInputRequest:" + errorMessage);
		return errorMessage;
	}

}
