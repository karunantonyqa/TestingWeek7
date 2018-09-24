package com.qa.Cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {
	
	@FindBy(id = "wsb-button-00000000-0000-0000-0000-000450914890")
	WebElement herbalCollectionLink;
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[2]/a")
	WebElement ourPassionLink;
	

}
