package com.insourcing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.insourcing.entity.CRFEntity;
import com.insourcing.entity.ContactUsEntity;
import com.insourcing.entity.ExploreTcsEntity;
import com.insourcing.entity.JourneyEntity;

public class Main {

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ExploreTcsEntity xplore = new ExploreTcsEntity();
		xplore.setId(1l);
		System.out.println(mapper.writeValueAsString(xplore));
		ContactUsEntity obj = new ContactUsEntity();
		obj.setId(1l);
		System.out.println(mapper.writeValueAsString(obj));
		CRFEntity entity = new CRFEntity();
		System.out.println(mapper.writeValueAsString(entity));
		ObjectNode noneuApplForm = mapper.createObjectNode();
		noneuApplForm.put("sdf", false);
		System.out.println(noneuApplForm.toString());
		System.out.println(mapper.writeValueAsString(noneuApplForm));
		JourneyEntity je = new JourneyEntity();
		System.out.println(mapper.writeValueAsString(je));

	}

}
