package com.qa.DemoQA;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class SelectableTest {
	
	WebDriver driver = null;	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void singleSelectTest() {
		driver.get("https://web.archive.org/web/20170630171225/http://demoqa.com:80/selectable/");
		Selectable page = PageFactory.initElements(driver, Selectable.class);
		
		Actions action = new Actions(driver);
		Action singleSel = (Action) action.moveToElement(page.selectableItem).click();
		singleSel.perform();
	}
	
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

}
