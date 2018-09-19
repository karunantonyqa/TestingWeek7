package com.qa.ReShop;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShoppingSearchTest {
	
	WebDriver driver = null;
	String expectedSearch = "\"DRESS\"";
	public static ExtentReports report;
	public ExtentTest test;

	
	@BeforeClass
	public static void initial() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\eclipse\\BingPageTest.html", true);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void searchTest() {
		test = report.startTest("Search Text");
		driver.get("http://automationpractice.com/index.php");
		test.log(LogStatus.INFO, "Search Run");

		
		ShoppingSearch page = PageFactory.initElements(driver, ShoppingSearch.class);
		page.searchFor("dress");
		if(page.searchItemName.getText().equals(expectedSearch)) {
			test.log(LogStatus.PASS, "Test correct search item PASSED");
		} else{
			test.log(LogStatus.FAIL, "Test correct search item FAILED");

		}
		
		assertEquals(expectedSearch , page.searchItemName.getText());
		
		System.out.println(page.searchItemName.getText());
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
