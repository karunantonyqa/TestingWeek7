package com.qa.RestAssured;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SimpleTest {
	
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
	
	@Given("^a film exists with Title IT$")
	public void a_film_exists_with_title_IT() {
		request = RestAssured.given().contentType(ContentType.JSON);
	}
	
	@When("^a user retrieves the film by title$")
	public void a_user_retrieves_film_by_title() {
		response = request.when().get("http://www.omdbapi.com/?apikey=5364931e&t=\"it\"");
	}
	
	@Then("^the status code reads 200$")
	public void status_code_reads(int status) {
		json = response.then().statusCode(200);
	}
	
	 @Test
     public void makeSureThatGoogleIsUp() {
         RestAssured.given().when().get("http://www.google.com").then().statusCode(200);
     }
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
	}

}
