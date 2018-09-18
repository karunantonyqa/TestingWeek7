package com.qa.ShoppingSite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingSearchResultsTest {
	
	WebDriver driver = null;	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void checkTestResult() {
		driver.get("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		ShoppingSearchResults page = PageFactory.initElements(driver, ShoppingSearchResults.class);
		
		int listSize = page.listElements.size();
		
		if(listSize > 0) {
			System.out.println("Test passed!");
			System.out.println("number of clothing items: " + listSize);
		}
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
