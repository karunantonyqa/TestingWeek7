package com.qa.quickstart.chromeDriver;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverTest {
	private WebDriver driver;
	String url = "https://www.google.co.uk/"; 
	String siteURL ="http://thedemosite.co.uk/";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();	
	}
	
	@After
	public void teardown() {
		driver.quit();	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
//	@Test
//	public void methodTest() {
//		driver.manage().window().maximize();
//		driver.get(url);
//		
//			
//		WebElement wb2 = driver.findElement(By.name("q"));
//		wb2.sendKeys("Elephant");
//		wb2.submit();
//		
//		WebElement wb = driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a"));
//		wb.click();
//		wb = driver.findElement(By.xpath("//*[@id=\"isr_chc\"]/div/div/a[1]/div/span"));
//		wb.click();
//		wb = driver.findElement(By.xpath("//*[@id=\"CHQjtylg3AffpM:\"]"));
//		wb.click();
//		wb = driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[3]/a"));
//		
//		assertEquals("Shopping", wb.getText());
//		System.out.println(wb.getText());
//		
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	@Test
	public void siteTest() {
		driver.manage().window().maximize();
		driver.get(siteURL);
		
		WebElement user = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		user.click();
		WebElement username = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		username.sendKeys("Karun");
		WebElement password = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		password.sendKeys("karun");
		WebElement save = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		save.click();
		
		WebElement login = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		login.click();
		username = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		username.sendKeys("Karun");
		password = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		password.sendKeys("karun");
		save = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		save.click();
		
		
		WebElement loginSuccess = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("**Successful Login**", loginSuccess.getText());
		System.out.println(loginSuccess.getText());
	}
	


}
