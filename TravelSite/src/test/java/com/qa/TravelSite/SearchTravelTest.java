package com.qa.TravelSite;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchTravelTest {
	
WebDriver driver = null;	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testSearch() {
		driver.get("https://www.phptravels.net/");
		SearchTravel page = PageFactory.initElements(driver, SearchTravel.class);
		
		Actions action = new Actions(driver);
		action.moveToElement(page.searchText).click().click().sendKeys("london").perform();
		
		
		WebElement searchSelectWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div/span")));
		
		
		Point londonPoint = page.londonOption.getLocation();
		
		action.moveToElement(page.londonOption).click(); 
//		action.moveToElement(page.londonOption).click().click();
		
		
		action.moveToElement(page.startDateChoice).click();
		System.out.println(page.startDate.getAttribute("value"));
		
		
		
		page.chooseDates();
//		page.addAdult();
//		page.search();
	}
	
	
	
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

}
