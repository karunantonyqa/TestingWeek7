package com.qa.ReShop;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShoppingSearchResultsTest {
	
	WebDriver driver = null;
	static ExtentReports report;
	public ExtentTest test;
	
	String directory = "C:\\Users\\Admin\\eclipse-workspace\\ReShop\\src\\test\\java\\reports\\screenshot.png";
	
	
	public void takeShot() throws IOException {
		OutputStream output = null;
		File scrFile = new File(directory); 
		
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		output = new FileOutputStream(directory);
		Files.copy(scrFile, output);
	}
	
	
	@BeforeClass
	public static void intial() {
		report = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\ReShop\\src\\test\\java\\reports\\ShoppingResultTest.html", true);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void checkTestResult() {
		test = report.startTest("Check Search Results");
		driver.get("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		test.log(LogStatus.INFO, "Results run");
		ShoppingSearchResults page = PageFactory.initElements(driver, ShoppingSearchResults.class);
		
		int listSize = page.listElements.size();
		
		takeShot();
		
		//System.out.println(scrFile.getAbsolutePath());
		
		
		

		
		if(listSize > 0) {
			System.out.println("Test passed!");
			System.out.println("number of clothing items: " + listSize);
			test.log(LogStatus.PASS, "Test correct items results PASSED");
		} else {
			test.log(LogStatus.FAIL, "Test correct results items FAILED");
		}
		
		
		
		
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
