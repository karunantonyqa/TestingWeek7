package com.qa.POMExample;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BingSearchPageTest {
	String selenium = "Selenium";

	WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void bingSearchBox() {
		driver.get("https://www.bing.com/");
		BingPage page = PageFactory.initElements(driver, BingPage.class);
		page.searchFor(selenium);
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		assertEquals("Selenium", checkElement.getText());
		System.out.println(checkElement.getText());
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	

}
