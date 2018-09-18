package com.qa.ShoppingSite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingSearchResults {
	
	@FindBy(className = "ajax_block_product")
	List<WebElement> listElements;
	


}
