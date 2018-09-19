package com.qa.ApacheTest;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReadFromDataTest {
	
	WebDriver driver = null;
	public static ExtentReports report;
	public ExtentTest test;
	String successString = "**Successful Login**";
	
	@BeforeClass
	public static void intial() {
		report = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\ApacheTest\\ShoppingResultTest.html", false);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
		test = report.startTest("Search Text");
	}
	
	@Test
	public void searchTest() throws IOException {
		Constants constants = PageFactory.initElements(driver, Constants.class);
		Elements elements = PageFactory.initElements(driver, Elements.class);
		
		driver.get(Constants.websiteURL);
		test.log(LogStatus.INFO, "Register run");
		
		FileInputStream file = new FileInputStream(constants.fileTestDataLoc);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		for(int i = 1; i<sheet.getPhysicalNumberOfRows();i++) {
			elements.adduser.click();

			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);
						
			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();
			
			System.out.println(user);
			System.out.println(pass);
			
			elements.username.sendKeys(user);
			elements.password.sendKeys(pass);
			elements.registerBtn.click();			
			elements.loginPageBtn.click();
			elements.loginUsername.sendKeys(user);
			elements.loginPassword.sendKeys(pass);
			elements.loginBtn.click();
			
			String kSuccess = elements.success.getText();
			
			
			if(elements.success.getText().equals(successString)) {
				test.log(LogStatus.PASS, "Login for " + user + " SUCCESSFUL");
			} else{
				test.log(LogStatus.FAIL, "Login for " + user + " FAILED");

			}
			
			assertEquals("**Successful Login**", elements.success.getText());
			
			
		}
		workbook.close();


		
	}
	
	
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}