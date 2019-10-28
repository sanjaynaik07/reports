package com.dorman.flash.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {


	WebDriver driver;

	public Screenshot(WebDriver driver)

	{
		this.driver = driver;
	}

	public void takescreenshot(String path)
	{		
		
		System.out.println(path);
		
		   File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   System.out.println("took screenshot");
		   try {

		   FileUtils.copyFile(src, new File(path));
		  
		   }
		    
		   catch (IOException e)
		   {
		    System.out.println(e.getMessage());
		   
		   }
		   	
			}
}
