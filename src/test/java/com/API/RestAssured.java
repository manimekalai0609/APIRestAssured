package com.API;

import org.junit.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured {
	
	@Test
	
	public void createPet() {
		
		//initializing
		
		RequestSpecification given =io.restassured.RestAssured.given();
		
		//Header initializing
		
		RequestSpecification header = given.header("Content-Type", "application/json");
	
		
		//Body
		
		RequestSpecification body = given.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}");
		
		//Method Initializing
		
		Response post = given.log().all().post("https://petstore.swagger.io/v2/pet");
		
		//to get status code
		
		int statusCode = post.getStatusCode();
		
		System.out.println(statusCode);
		
		System.out.println(post.asPrettyString());
		
		
	}

}
