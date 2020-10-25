package com.wladblank.forexport.forexport;

import java.net.http.HttpResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpEntity;

import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ForexPortApplication {

	public static void main(String[] args) {
		
		String url = "https://www.investing.com/instruments/Service/GetTechincalData";
		//gives 1 minute, 5 minutes, 15 minutes, 30 minutes, 1 hour, 5 hours and 1 day array.
		String xrequest= "X-Requested-With:XMLHttpRequest";
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
		   
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		  
		//SpringApplication.run(ForexPortApplication.class, args);



	}

}
