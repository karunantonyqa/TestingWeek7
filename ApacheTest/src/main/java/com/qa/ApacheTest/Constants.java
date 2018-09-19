package com.qa.ApacheTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Constants {
	
	public static final String websiteURL = "http://thedemosite.co.uk";
	
	public static final String registerURL = "http://thedemosite.co.uk/addauser.php";

	public static final String loginURL = "http://thedemosite.co.uk/login.php";

	public static final String pathTestData = "C:\\Users\\Admin\\eclipse-workspace\\ApacheTest\\src\\";
	
	public static final String screenshotLoc = "C:\\Users\\Admin\\eclipse-workspace\\ApacheTest\\src\\screenshot.png";


	public static final String fileTestDataName = "testdata.xlsx";
	
	public final String fileTestDataLoc = "C:\\Users\\Admin\\eclipse-workspace\\ApacheTest\\src\\testdata.xlsx";

	
	public void takeShot(WebDriver driver) throws IOException {
		OutputStream output = null;
		File scrFile = new File(screenshotLoc); 
		
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		output = new FileOutputStream(screenshotLoc);
		Files.copy(scrFile, output);
	}
	
}
