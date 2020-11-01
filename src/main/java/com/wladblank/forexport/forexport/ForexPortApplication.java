package com.wladblank.forexport.forexport;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.wladblank.forexport.forexport.dto.TechnicalDivResponse;
import com.wladblank.forexport.forexport.dto.TechnicalResponse;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpEntity;
import org.json.JSONObject;
import org.json.XML;


import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONArray;

@SpringBootApplication
public class ForexPortApplication {

	public static void main(String[] args) throws IOException {
		
		String url = "https://www.investing.com/instruments/Service/GetTechincalData";
		//gives 1 minute, 5 minutes, 15 minutes, 30 minutes, 1 hour, 5 hours and 1 day array.
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		headers.set("User-Agent","PostmanRuntime/7.26.5");
		headers.set("X-Requested-With", "XMLHttpRequest");
		MultiValueMap<String, String> formDataMap= new LinkedMultiValueMap<>();

		formDataMap.add("pairID", "1036977");
		formDataMap.add("period", "1800");
		formDataMap.add("viewType", "normal");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formDataMap, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(url, request , String.class);
		
		JacksonXmlModule xmlModule = new JacksonXmlModule();
		xmlModule.setDefaultUseWrapper(false);
		XmlMapper xmlMapper = new XmlMapper(xmlModule);
		xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		JSONObject soapDatainJsonObject = XML.toJSONObject(response.getBody());

		org.json.JSONArray nodeArray = soapDatainJsonObject.getJSONArray("div");

		ObjectMapper objectMapper = new ObjectMapper();

		//System.out.println(nodeArray.getJSONObject(0).getJSONArray("div").get(0));
		
		JsonNode jsonNode = objectMapper.readTree(nodeArray.getJSONObject(0).toString());
		
		System.out.println(jsonNode.toPrettyString());
		System.out.println(objectMapper.readValue(jsonNode.toPrettyString(), TechnicalDivResponse.class));

		//ObjectMapper objectMapper = new ObjectMapper();
//

//String body = "<wrap>" + response.getBody() + "</wrap>";

//	TechnicalResponse tResponse = xmlMapper.readValue(body, TechnicalResponse.class);

	//System.out.println(tResponse);

	//System.out.println(response.getBody());

		//objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		//String json = objectMapper.writeValueAsString(jsonNode);
	//
		//// TODO: findout how to use propper mapping here
//
		//System.out.println("from Body:");
		//System.out.println(json);

		//System.out.println("original Body:");
		//System.out.println(response.getBody());



		//SpringApplication.run(ForexPortApplication.class, args);



	}

}
