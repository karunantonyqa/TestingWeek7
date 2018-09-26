package com.qa.PersonSwagger;

//import java.util.HashMap;
//import java.util.Map;

import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class JUnitTester {

	private static final String API_URI = "http://localhost:8080/v1/person";

	JSONObject people = new JSONObject();

	JSONObject address = new JSONObject();

	JSONArray addresses = new JSONArray();

	public static ExtentReports report;
	public ExtentTest test;

	@BeforeClass
	public static void intial() {
		report = new ExtentReports(
				"C:\\Users\\Admin\\Documents\\Hotel Springboot\\spring-boot-rest-example\\HotelTest.html", false);
	}

	@Before
	public void setup() {
		test = report.startTest("Create person test ");

	}

	@Test
	public void putPersonTest() throws JSONException {
		RestAssured.baseURI = API_URI;
		RequestSpecification request1 = RestAssured.given();

		request1.header("content-Type", "application/json");
		request1.header("userId", "11111111");

		// Person {
		// addresses (Array[Address], optional),
		// dateOfBirth (string, optional),
		// firstName (string, optional),
		// gender (string, optional) = ['M', 'F']
		// string
		// Enum: "M", "F"
		// ,
		// id (integer, optional),
		// lastName (string, optional),
		// middleName (string, optional)
		// }
		// Address {
		// city (string, optional),
		// id (integer, optional),
		// line1 (string, optional),
		// line2 (string, optional),
		// state (string, optional),
		// zip (string, optional)
		// }

		addresses.put(address);
		
		people.put("dateOfBirth", "2018-09-26T08:18:03.250Z");
		people.put("firstName", "Karun");
		people.put("gender", "M");
		people.put("id", 5);
		people.put("lastName", "Antony");
		people.put("middleName", "Chris");
		
		address.put("id", 5);
		address.put("city", "Birmingham");
		address.put("line1", "53 Funny Lane");
		address.put("line2", "Funnyland");
		address.put("state", "Funlands");
		address.put("zip", "FU9 7ND");

		people.put("addresses", addresses);
		
		System.out.println(people);
		

		// System.out.println("people: " + people);

		// Response response = request1.put("/");

		request1.body(people.toString()).when().put("/").then().statusCode(200);
		
	}
	
	@Test
	public void getPersonById() {
		RestAssured.given().contentType(ContentType.JSON).when().get(API_URI + "/1").then().statusCode(200);

	}
	
	@Test
	public void getPersonTest() {
		
		RequestSpecification request2 = RestAssured.given();

		
		request2.when().get(API_URI).then().statusCode(200);
		
	}
	
	

	@After
	public void teardown() throws InterruptedException {
		// Thread.sleep(3000);
		report.endTest(test);
		report.flush();
	}

}
