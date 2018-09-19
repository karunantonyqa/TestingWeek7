package com.qa.POMExample;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BingSearchPageTest {
	String selenium = "Selenium";
	
	//Report initialisation
	public static ExtentReports report;
	public ExtentTest test;

	WebDriver driver = null;
	
	//Report
	@BeforeClass
	public static void initial() {
		report = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\POMExample\\src\\main\\reports\\BingPageTest.html", true);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void bingSearchBox() {
		test = report.startTest("Search Text");
		driver.get("https://www.bing.com/");
		test.log(LogStatus.INFO, "Search Run");
		
		BingPage page = PageFactory.initElements(driver, BingPage.class);
		Actions action = new Actions(driver);
		
		action.moveToElement(page.searchBox).click().sendKeys(selenium).sendKeys(Keys.ENTER);
		
//		page.searchFor(selenium);
		
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));

		
		if(page.getText().equals("Selenium")) {
			test.log(LogStatus.PASS, "Search text found");
		}else {
			test.log(LogStatus.FAIL, "Search text not found");
		}
		
		System.out.println(checkElement.getText());
		
		
		assertEquals("Selenium", checkElement.getText());

		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();

		driver.close();
	}
	

}
