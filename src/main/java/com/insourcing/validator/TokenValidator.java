package com.insourcing.validator;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.insourcing.entity.CandidateEntityMap;
import com.insourcing.entity.HRLoginEntity;
import com.insourcing.model.TokenClassifier;
import com.insourcing.repository.CandidateRepo;
import com.insourcing.repository.HRLoginRepo;

@Component
public class TokenValidator {

	private static Logger logger = LogManager.getLogger(TokenValidator.class);

	@Autowired
	public CandidateRepo candRepo;
	@Autowired
	HRLoginRepo hrRepository;

	public boolean tokenValidator(String emailId, String jwtToken) {
		boolean validate = false;
		CandidateEntityMap candEntityMap = candRepo.findByEmailid(emailId);
		logger.info(jwtToken);
		if (candEntityMap.getExpiredToken() != null && candEntityMap.getExpiredToken().equals(jwtToken))
			validate = false;
		else
			validate = true;
		logger.info("tokenValidator - Exit");
		return validate;
	}

	public boolean validateHrToken(String emailId, String jwtToken) {
		boolean validate = false;
		HRLoginEntity hrLoginEntity = hrRepository.findByEmailId(emailId);
		logger.info(jwtToken);
		if (hrLoginEntity.getExpiredToken() != null && hrLoginEntity.getExpiredToken().equals(jwtToken))
			validate = false;
		else
			validate = true;
		return validate;
	}

	public String decodeEmailId(String jwtToken) {
		logger.info("decodeEmailId - Entry");
		String emailId = null;
		logger.info(jwtToken);
		String[] split_string = jwtToken.split("\\.");
		String base64EncodedBody = split_string[1];
		Base64 base64Url = new Base64(true);
		String body = new String(base64Url.decode(base64EncodedBody));
		logger.info(body);
		Gson gson = new Gson();
		TokenClassifier list = gson.fromJson(body, TokenClassifier.class);
		emailId = list.getSub();
		logger.info("decodeEmailId - Exit");
		return emailId;
	}

}
