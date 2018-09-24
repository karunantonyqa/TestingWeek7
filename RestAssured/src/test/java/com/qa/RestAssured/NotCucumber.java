package com.qa.RestAssured;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class NotCucumber {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	public static ExtentReports report;
	public ExtentTest test;
	
	
	@BeforeClass
	public static void intial() {
		report = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\RestAssured\\RestTest.html", false);
	}
	
	@Before
	public void setup() {
		test = report.startTest("Search Text");
	}
	
	@Test
	public void example200Test() {
		RestAssured.given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://www.omdbapi.com/?apikey=5364931e&t=it")
		.then().statusCode(200);
		
		test.log(LogStatus.INFO, "Test passed, code 200");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void expectedBodyValuesTest() {
		RequestSpecification httpReq = RestAssured.given();
		response = httpReq.get("http://www.omdbapi.com/?apikey=5364931e&t=it");
		
		ResponseBody body = response.getBody();
		
		String bodyAsString = body.asString();
		
		System.out.println(bodyAsString);
		Assert.assertEquals(bodyAsString.contains("Stephen"), true);
		
		test.log(LogStatus.INFO, "Stephen of stephen king found in the body");
	}
	
	@Test
	public void verifyCorrectRating() {
		RequestSpecification httpReq = RestAssured.given();
		response = httpReq.get("http://www.omdbapi.com/?apikey=5364931e&t=it");
		
		JsonPath path = response.jsonPath();
		
		String year = path.get("Year");
		
		System.out.println("Year received: " + year);
		
		Assert.assertEquals("2017", year);
		
		test.log(LogStatus.INFO, "Correct year received");
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
	}

}
