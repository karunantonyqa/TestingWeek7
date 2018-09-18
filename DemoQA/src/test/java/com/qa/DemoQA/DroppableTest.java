package com.qa.DemoQA;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class DroppableTest {
	
	WebDriver driver = null;	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void dragOpTest() {
		driver.get("https://web.archive.org/web/20170712113643/http://demoqa.com:80/droppable/");
		Droppable page = PageFactory.initElements(driver, Droppable.class);
		
		Actions action = new Actions(driver);
		Action mouseDragItem = (Action) action.moveToElement(page.draggableItem).dragAndDrop(page.draggableItem, page.droppableItem).build();

		mouseDragItem.perform();
		
		String text = "Dropped!";
		assertEquals(text, page.hasDropped.getText());
	}
	
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

}
