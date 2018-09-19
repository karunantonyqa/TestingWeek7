package com.qa.ReShop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingSearch {
	
	@FindBy(id = "search_query_top")
	private WebElement searchBox;
	
	@FindBy(xpath = "//*[@id=\"searchbox\"]/button")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[1]")
	public WebElement searchItemName;
	
	public void searchFor(String text) {
		searchBox.sendKeys(text);
		searchBtn.click();
	}

}
