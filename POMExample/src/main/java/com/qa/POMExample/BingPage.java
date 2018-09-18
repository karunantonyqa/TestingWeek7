package com.qa.POMExample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingPage {
	
	String bingSearchID = "sb_form_q";
	String bingSearchSubmit = "sb_form_go";
	
	@FindBy(id = "sb_form_q")
	private WebElement searchBox;
	
	@FindBy(id = "sb_form_go")
	private WebElement searchBtn;
	
	
	public void searchFor(String text) {
		searchBox.sendKeys(text);
		searchBtn.click();
	}
	
	
	
	
	

}
