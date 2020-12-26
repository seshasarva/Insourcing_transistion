package com.insourcing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.insourcing.entity.CRFEntity;
import com.insourcing.entity.ContactUsEntity;
import com.insourcing.entity.ExploreTcsEntity;
import com.insourcing.entity.JourneyEntity;

public class Main {

	public static void main(String[] args) throws JsonProcessingException {
		json();
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode parent = mapper.createObjectNode();
		
		ObjectNode chartNode = mapper.createObjectNode();
		chartNode.put("Joined", 50);
		chartNode.put("Offer_Progress", 15);
		chartNode.put("Offer_Acceptance_Pending", 30);
		chartNode.put("Offer_Declined", 5);
		parent.set("chart", chartNode);
		parent.put("total", 100);
		parent.put("actual", 50);
		parent.put("percent", "20%");
		parent.put("active", 2);
		System.out.println(parent);
		double d= (10*100)/50;
		System.out.println(d);
		ExploreTcsEntity xplore = new ExploreTcsEntity();
		xplore.setId("dealid");
		System.out.println(mapper.writeValueAsString(xplore));
		ContactUsEntity obj = new ContactUsEntity();
		obj.setId("dealid");
		System.out.println(mapper.writeValueAsString(obj));
		System.exit(0);
		CRFEntity entity = new CRFEntity();
		System.out.println(mapper.writeValueAsString(entity));
		ObjectNode noneuApplForm = mapper.createObjectNode();
		noneuApplForm.put("sdf", false);
		System.out.println(noneuApplForm.toString());
		System.out.println(mapper.writeValueAsString(noneuApplForm));
		JourneyEntity je = new JourneyEntity();

	}
	
	static void json() {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode parent = mapper.createObjectNode();
		//List<String> list = new ArrayList<String>();
		ArrayNode array = mapper.createArrayNode();
		array.add("clent1");array.add("client2");array.add("All");
		ObjectNode chartNode = mapper.createObjectNode();
		chartNode.put("Joined", 50);
		chartNode.put("Offer_Progress", 15);
		chartNode.put("Offer_Acceptance_Pending", 30);
		chartNode.put("Offer_Declined", 5);
		parent.set("chart", chartNode);
		parent.put("total", 100);
		parent.put("actual", 50);
		parent.put("percent", "20%");
		parent.put("active", 2);
		parent.set("clients", array);
		System.out.println(parent.toString());
		System.exit(0);
	}
}
	