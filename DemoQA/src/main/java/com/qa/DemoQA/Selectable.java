package com.qa.DemoQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Selectable {

	@FindBy(xpath = "//*[@id=\"selectable\"]/li[1]")
	WebElement selectableItem;
}
