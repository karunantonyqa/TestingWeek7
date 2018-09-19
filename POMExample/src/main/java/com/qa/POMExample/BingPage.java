package com.qa.POMExample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingPage {
	
	String bingSearchID = "sb_form_q";
	String bingSearchSubmit = "sb_form_go";
	
	@FindBy(id = "sb_form_q") 
	WebElement searchBox;
	
	@FindBy(id = "sb_form_go")
	WebElement searchBtn;
	
	@FindBy(xpath = "//*[@id=\"b_context\"]/li[1]/div/div[1]/h2")
	WebElement searchedText;
	
	
	public void searchFor(String text) {
		searchBox.sendKeys(text);
		searchBtn.click();
	}
	
	public String getText() {
		String text = searchedText.getText();
		return text;
	}
	
	
	
	
	

}
