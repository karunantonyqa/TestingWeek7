package com.qa.RestAssured;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GuardiansSteps {
	
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
	
	
	@Given("^a film exists with the Title Guardians of the Galaxy Two$")
	public void a_film_exists_with_the_Title_Guardians_of_the_Galaxy_Two() throws Throwable {
		
		RequestSpecification httpReq = RestAssured.given();

		request = RestAssured.given().contentType(ContentType.JSON);
		response = httpReq.get("http://www.omdbapi.com/?apikey=5364931e&t=\"Guardians of the Galaxy Vol. 2\"");

		
		
	}

//	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
//	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy_Two() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Given("^a film exists with the Title IT$")
//	public void a_film_exists_with_the_Title_IT() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^a user retrieves the film by the title IT$")
//	public void a_user_retrieves_the_film_by_the_title_IT() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^the Rated Field is equal to R$")
//	public void the_Rated_Field_is_equal_to_R() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Given("^a film exists with the Title \"([^\"]*)\"$")
//	public void a_film_exists_with_the_Title(String arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
//	public void a_user_retrieves_the_film_by_the_title(String arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
//	public void the_Rated_Field_is_equal_to(String arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
	}

}
