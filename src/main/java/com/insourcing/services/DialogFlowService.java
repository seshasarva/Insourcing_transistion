package com.insourcing.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ArrayMap;
import com.google.api.client.util.GenericData;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.insourcing.config.ChatbotServiceConstants;
import com.insourcing.exception.GenericException;
import com.insourcing.exception.InvalidRequestException;
import com.insourcing.model.LeadingInformation;
import com.insourcing.model.ReplyInformation;

@Service
public class DialogFlowService {

	Logger logger = Logger.getLogger(DialogFlowService.class);

	@Autowired
	private Environment env;

	/**
	 * 	This methods built url and calls the dialogflow API to get reply for the query
	 * @param queryInput
	 * @param sessionID
	 * @param env
	 * @return ReplyInformation
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public ReplyInformation getDialogFlowResponse(String queryInput, String sessionID, String country, String engagementBot) throws FileNotFoundException, IOException {

		logger.info("getDialogFlowReply : Entry");
		ReplyInformation replyInformation = null;
		String projectId = null;
		if(engagementBot.equalsIgnoreCase(ChatbotServiceConstants.POST_OFFER)) {
			projectId = ChatbotServiceConstants.POST_PROJECT_ID;
		}else {
			projectId = ChatbotServiceConstants.PRE_PROJECT_ID;
		}
		String url = env.getProperty(ChatbotServiceConstants.DIALOGFLOW_ENDPOINT) + env.getProperty(projectId+country+ChatbotServiceConstants.EN) + env.getProperty(ChatbotServiceConstants.URI) + sessionID + ":" + env.getProperty(ChatbotServiceConstants.DETECT_INTENT_API);
		//String url = DialogFlowConstants.DIALOGFLOW_ENDPOINT + env.getProperty("dialogflow.projectID.India.en") + DialogFlowConstants.URI + sessionID + ":" + DialogFlowConstants.DETECT_INTENT_API;
		logger.info("Url : "+url);
		replyInformation = getHttpResponse(url, queryInput, country, engagementBot);

		if(replyInformation == null) {
			logger.error("Failed to process HTTP request");
			throw new GenericException("Failed to process HTTP request");
		}
		return replyInformation;
	}

	/**
	 * 	This methods reads reply message from dialog flow API
	 * @param queryInput
	 * @param url
	 * @return ReplyInformation
	 * @throws InvalidRequestException 
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	private ReplyInformation getHttpResponse(String url, String queryInput, String country, String engagementBot) throws InvalidRequestException, IOException {

		ReplyInformation replyInfo = new ReplyInformation();
		List<LeadingInformation> leadInfoList = new ArrayList<>();
		ArrayMap<String, Object> resultMap = new ArrayMap<>();
		ArrayMap<String, Object> resultMessages = new ArrayMap<>();
		ArrayMap<String, Object> payloadMap = new ArrayMap<>();
		List<Object> promptsList = new ArrayList<>();
		ArrayMap<String, Object> promptsMap = new ArrayMap<>();
		String reply = "";

		HttpRequest request = null;
		HttpResponse response = null;
		GenericData responseData;
		try {
			request = buildRequest(url, queryInput, country, engagementBot);
			request.setParser(new JacksonFactory().createJsonObjectParser());
			response = request.execute();
			if(response !=null && response.isSuccessStatusCode()) {
				logger.info("Response Status Code : " + response.getStatusCode());
				logger.info("Status Message : "+response.getStatusMessage());
				responseData = response.parseAs(GenericData.class);
			}else if(response !=null){
				logger.error("Getting "+response.getStatusCode());
				throw new GenericException("Getting "+response.getStatusCode());
			}else {
				logger.error("Error in processing request. Getting empty response");
				throw new GenericException("Error in processing request. Getting empty response");
			}
		} finally {
			response.disconnect();
		}

		if(responseData!= null && responseData.get("queryResult")!=null){
			logger.info("responseData.get(\"queryResult\") : "+responseData.get("queryResult"));
			resultMap = (ArrayMap<String, Object>) responseData.get("queryResult");
		}else if(responseData == null){ 
			logger.error("responseData is empty");
			throw new GenericException("responseData is empty");
		}else {
			logger.error("queryResult is empty");
			throw new GenericException("queryResult is empty");
		}
		if(resultMap.get("fulfillmentText")!=null ){
			reply= (String) resultMap.get("fulfillmentText");
		}else { 
			logger.error("fulfillmentText is empty");
			throw new GenericException("fulfillmentText is empty");
		}

		// Checking # inside reply messages and to verify any hashtag messages appears in it
		if (reply.contains("#")) {
			reply = addFileLocation(reply);
		}else { 
			logger.info("addFileLocation not called. No hashtags found");
		}

		replyInfo.setAnswer(reply);
		List<Object> replyMessages = new ArrayList<Object>();
		if(resultMap.get("fulfillmentMessages")!=null) {
			logger.info("resultMap.get(\"fulfillmentMessages\") : "+resultMap.get("fulfillmentMessages"));
			replyMessages = (List<Object>) resultMap.get("fulfillmentMessages");
			if(replyMessages.size()!=0) {
				for(int i=0; i<replyMessages.size();i++){
					resultMessages = (ArrayMap<String, Object>) replyMessages.get(i);
					if(resultMessages != null && resultMessages.containsKey("payload")){
						payloadMap = (ArrayMap<String, Object>) resultMessages.get("payload");
						if(payloadMap.containsKey("prompts")){
							promptsList = (List<Object>) payloadMap.get("prompts");
							if(promptsList.size()!=0) {
								for(int j=0; j<promptsList.size();j++){
									LeadingInformation leadInfo = new LeadingInformation();
									promptsMap = (ArrayMap<String, Object>) promptsList.get(j);
									if(promptsMap!=null && promptsMap.containsKey("displayText")) {
										String buttonHTML = (String) promptsMap.get("displayText");
										leadInfo.setButtonText(buttonHTML);
										if(promptsMap.containsKey("extraInfo") && !promptsMap.get("extraInfo").toString().isEmpty()) {
											String extraInfo = (String) promptsMap.get("extraInfo");
											leadInfo.setButtonValue(extraInfo);
										}
										leadInfoList.add(leadInfo);
									}else if(promptsMap == null){
										logger.warn("promptsMap is empty");
									}else {
										logger.warn("displayText not found");
									}
								}
							}else {
								logger.warn("prompt list is empty");
							}
						}else {
							logger.warn("prompts not found");
						}
					}else if(resultMessages == null){
						logger.warn("resultMessages is empty");
					}else {
						logger.warn("payload in fulfillmentMessages not found");
					}
					replyInfo.setLeadingInformation(leadInfoList);
				}
			}else {
				logger.error("replyMessage is empty");
				throw new GenericException("replyMessage is empty");
			}
		}else {
			logger.error("fulfillmentMessages not present in JSON response");
			throw new GenericException("fulfillmentMessages not present in JSON response");
		}
		return replyInfo;
	}

	/**
	 * This method execute dialog flow http request
	 * @param url
	 * @param message
	 * @return HttpRequest
	 * @throws IOException 
	 */
	private HttpRequest buildRequest(String url, String message, String country, String engagementBot) throws IOException {

		logger.info("buildRequest : Entry");
		ServiceAccountCredentials credentials = fetchCredentials(country, engagementBot);
		String jwt = createJwt(credentials);
		String token = fetchToken(jwt);
		// int port = Integer.parseInt(env.getProperty("http.proxy.port"));
		// Proxy proxy = new Proxy(Proxy.Type.HTTP, new
		// InetSocketAddress(env.getProperty("http.proxy"), port));
		//HttpTransport httpTransport = new  NetHttpTransport.Builder().setProxy(proxy).build();
		HttpTransport httpTransport = new NetHttpTransport.Builder().build();
		ByteArrayContent.fromString(ChatbotServiceConstants.CONTENT_TYPE, message);
		HttpRequest request = httpTransport.createRequestFactory()
				.buildPostRequest(new GenericUrl(url),ByteArrayContent.fromString(ChatbotServiceConstants.CONTENT_TYPE, message))                    
				.setHeaders(new HttpHeaders()
						.setAuthorization("Bearer " + token)
						.set("Host", env.getProperty(ChatbotServiceConstants.DIALOGFLOW_HOST)));
		logger.info("buildRequest : Exit");
		return request;
	}

	/**
	 * This method read JSON file and fetch credential details to access dialog flow API
	 * @return ServiceAccountCredentials
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private ServiceAccountCredentials fetchCredentials(String country, String engagementBot) throws FileNotFoundException, IOException {
		logger.info("fetchCredentials : Entry");
		String credentialFilePath = null;
		if(engagementBot.equalsIgnoreCase(ChatbotServiceConstants.POST_OFFER)) {
			credentialFilePath = ChatbotServiceConstants.POST_CREDENTIAL_FILE_PATH;
		}else {
			credentialFilePath = ChatbotServiceConstants.PRE_CREDENTIAL_FILE_PATH;
		}
		ServiceAccountCredentials credentials = ServiceAccountCredentials
				.fromStream(new FileInputStream(env.getProperty(credentialFilePath+country+ChatbotServiceConstants.EN)));
		//if(credentials == null) {"+country+"
			//logger.error("ServiceAccountCredentials is empty");
			//throw new GenericException("ServiceAccountCredentials is empty");
		//}
		logger.info("Check credentials::::::::::::::::::"+credentials);
		logger.info("fetchCredentials : Exit");
		
		return credentials;
	}

	/**
	 * This method create jwt token
	 * @param credentials
	 * @return
	 * @throws Exception
	 */
	private String createJwt(ServiceAccountCredentials credentials) {
		logger.info("createJwt : Entry");
		String jwt = "";
		long now = System.currentTimeMillis();
		if(credentials.getClientEmail()!=null && credentials.getPrivateKey()!=null) {
			String serviceAccount = credentials.getClientEmail();
			RSAPrivateKey privateKey = (RSAPrivateKey) credentials.getPrivateKey();
			Algorithm algorithm = Algorithm.RSA256(null,privateKey);
			String tokenUri = env.getProperty("oauth.token.uri");
			int timeout = Integer.parseInt(env.getProperty("session.timeout"));
			if(!tokenUri.isEmpty()) {
				jwt = JWT.create()            
						.withIssuer(serviceAccount)
						.withClaim("scope",env.getProperty("dialogflow.scope"))
						.withIssuedAt(new Date(now))
						.withAudience(tokenUri)
						.withExpiresAt(new Date(now + timeout * 1000L))
						.sign(algorithm);
				//jwt = TokenGenerator.getJWTToken(serviceAccount);
			}else {
				logger.warn("Oauth token property not found");
			}
		}else if(credentials.getPrivateKey() == null){
			logger.error("ServiceAccountCredentials primary key not found");
			throw new GenericException("ServiceAccountCredentials primary key not found");
		}else {
			logger.error("ServiceAccountCredentials client mail not found");
			throw new GenericException("ServiceAccountCredentials client mail not found");
		}
		if(jwt.isEmpty()) {
			logger.error("jwt not created");
			throw new GenericException("jwt not created");
		}
		logger.info("createJwt : Exit");
		return jwt;
	}

	/**
	 * This method generate access tokens
	 * @param jwt
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	private String fetchToken(String jwt) throws IOException {

		logger.info("fetchToken : Entry");
		final GenericData tokenRequest = new GenericData().set("grant_type", env.getProperty("jwt.bearer.token.grant.type")).set("assertion", jwt);
		logger.info("Token Request "+tokenRequest);
		final UrlEncodedContent content = new UrlEncodedContent(tokenRequest);
		// int port = Integer.parseInt(env.getProperty("http.proxy.port"));
		// Proxy proxy = new Proxy(Proxy.Type.HTTP, new
		// InetSocketAddress(env.getProperty("http.proxy"), port));
		//HttpTransport httpTransport = new  NetHttpTransport.Builder().setProxy(proxy).build();
		HttpTransport httpTransport = new NetHttpTransport.Builder().build();
		final HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
		String accessToken = null ;
		HttpRequest request;
		HttpResponse response = null;
		GenericData responseData;
		try {
			request = requestFactory
					.buildPostRequest(new GenericUrl(env.getProperty("oauth.token.uri")), content)
					.setParser(new JsonObjectParser(JacksonFactory.getDefaultInstance()));
			if(request != null) {
				logger.info("request.getHeaders() :" + request.getHeaders());
				logger.info(request);
				response = request.execute();
				logger.info("request executed");
				if(response !=null && response.isSuccessStatusCode()) {
					responseData = response.parseAs(GenericData.class);
					logger.info("Http response status code : "+response.getStatusCode());
					logger.info("response :" + response.getContent());
				}else if(response != null) {
					logger.error("Getting "+response.getStatusCode());
					throw new GenericException("Getting "+response.getStatusCode());
				}else {
					logger.error("Request not successfull. Getting empty response");
					throw new GenericException("Request not successfull. Getting empty response");
				}
			}else {
				logger.error("Empty request");
				throw new GenericException("Empty request");
			}
		} finally {
			response.disconnect();
		}
		if(responseData!=null && responseData.get("access_token")!=null) {
			accessToken = (String) responseData.get("access_token");
		}else if(responseData == null){
			logger.error("responseData not found");
			throw new GenericException();
		}else {
			logger.error("Access Token not found");
			throw new GenericException("Access token not found");
		}
		logger.info("fetchToken : Exit");
		return accessToken;
	}


	/**
	 * This method finds name of the file present in reply message and replace with file location
	 * This has been implemented and later iBegin agreed to handle this.
	 * @param reply
	 * @return
	 */
	private String addFileLocation(String reply) {
		String fileLoc = null;
		String docName = null;
		String modifiedAnswer = reply;
		Pattern pattern = Pattern.compile("#(.*?)#", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(reply);
		while (matcher.find()) {
			docName= matcher.group(1);
			fileLoc = env.getProperty("dialogflow.fileloc." + docName);
			if(fileLoc !=null && !fileLoc.isEmpty()) {
				modifiedAnswer = reply.replaceAll(docName, fileLoc);
			}
//			else {
//				logger.error("fileLoc is empty");
//				throw new GenericException("fileLoc is empty");
//			}
		}
		logger.info("replyMessage in addFileLocation: " + modifiedAnswer);
		return modifiedAnswer;
	}

}

