package com.qa.HotelSwagger;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.junit.Ignore;
import org.junit.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.minidev.json.JSONObject;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class HotelTester {
	
	private Response response;
	private RequestSpecification request;
	
	private static final String API_URI = "http://localhost:8090/example/v1/hotels/";
	private static final String Post_URI = "1/";
	private static final String paginatedList_URI = "http://localhost:8090/example/v1/hotels?page=0&size=10/";
	
	Map<String, Object> json = new HashMap<String, Object>();

	public static ExtentReports report;
	public ExtentTest test;
	
	@BeforeClass
	public static void intial() {
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\Hotel Springboot\\spring-boot-rest-example\\HotelTest.html", false);
	}
	
	@Before
	public void setup() {
		test = report.startTest("Create hotel test ");
		json.clear();
	}
	
	@Test
	public void getPaginatedList() {
		
		RestAssured.given().contentType(ContentType.JSON).when().get(API_URI).then().statusCode(200);
		
	}
	
	@Test
	public void postHotelTest() {
		
//		{
//			  "city": "string",
//			  "description": "string",
//			  "id": 0,
//			  "name": "string",
//			  "rating": 0
//			}
		

		RestAssured.baseURI = API_URI;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject requestParams = new JSONObject();

		
		json.put("city","Birmingham");
		json.put("description","Greatest hotel in the greatest city");
		json.put("name","Beds R Us");
		json.put("rating",10);
	
//		json.put("City","Manchester");
//		json.put("Desc.","Good hotel in a good city");
//		json.put("ID", roomsRUsID);
//		json.put("Name","Rooms R Us");
//		json.put("Rating",8);
//		
//		json.put("City","London");
//		json.put("Desc.","Nice hotel in a nice city");
//		json.put("ID", flatsRUsID);
//		json.put("Name","Flats R Us");
//		json.put("Rating",8.5);
		
		RestAssured.given().contentType(ContentType.JSON).body(json).when().post("/").then().statusCode(201);
		
	}

	@Test
	public void getHotelByID() {

		RestAssured.given().contentType(ContentType.JSON).when().get(API_URI + 1).then().statusCode(200);
	}
	
	@Test
	public void deleteHotelTest() {
		
//		for(int i=4;i<=33;i++) {
//			RestAssured.given().contentType(ContentType.JSON).when().delete(API_URI + i);
//
//		}
		RestAssured.given().contentType(ContentType.JSON).when().delete(API_URI + 1).then().statusCode(204);
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
	}

}
