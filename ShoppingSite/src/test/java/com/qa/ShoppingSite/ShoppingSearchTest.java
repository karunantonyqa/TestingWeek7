package com.qa.ShoppingSite;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingSearchTest {
	
	WebDriver driver = null;
	String expectedSearch = "\"DRESS\"";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void searchTest() {
		driver.get("http://automationpractice.com/index.php");
		ShoppingSearch page = PageFactory.initElements(driver, ShoppingSearch.class);
		page.searchFor("dress");
		
		assertEquals(expectedSearch , page.searchItemName.getText());
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
