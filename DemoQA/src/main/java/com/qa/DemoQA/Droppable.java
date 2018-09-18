package com.qa.DemoQA;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Droppable {
	
	@FindBy(id = "draggableview")
	WebElement draggableItem;
	
	@FindBy(id = "droppableview")
	WebElement droppableItem;
	
	@FindBy(xpath = "//*[@id=\"droppableview\"]/p")
	WebElement hasDropped;
	
	public void dropItem() {
	}
	

}
