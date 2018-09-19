package com.qa.TravelSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;

public class SearchTravel {
	
	@FindBy(xpath = "//*[@id=\"s2id_autogen8\"]/a")
	WebElement searchText;
	
	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div/span")
	WebElement londonOption;
	
	
	@FindBy(id = "dpd1")
	WebElement startDate;
	
	@FindBy(xpath = "/html/body/div[8]/div[1]/table/tbody/tr[4]/td[3]")
	WebElement startDateChoice;
	
	@FindBy(xpath = "dpd2")
	WebElement endDate;
	
	@FindBy(id = "adultPlusBtn")
	WebElement addAdult;
	
	@FindBy(xpath = "//*[@id=\"HOTELS\"]/form/div[5]/button")
	WebElement search;
	
	@FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[2]/a")
	WebElement hotelNav;
	
	public void addAdult() {
		addAdult.click();
	}
	
	public void chooseDates() {
		startDate.click();
		endDate.click();
	}
	
	public void searchCity(String city) {
		searchText.sendKeys(city);
		londonOption.click();
		
		
	}
	
	public void search() {
		search.click();
	}
	
	public void fullSearch(String city, WebDriver driver) {
		
	}

}
