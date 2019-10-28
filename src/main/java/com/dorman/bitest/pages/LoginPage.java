package com.dorman.bitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage { 
	
	WebDriver driver;
	     public LoginPage(WebDriver driver)
	     
	     { 
	    	 this.driver=driver;
	       }
	   
	     
	     
	 @FindBy(xpath="//iframe[@name='servletBridgeIframe']")
	 WebElement loginframe;     
	     
	@FindBy(xpath="//input[@id='_id0:logon:USERNAME']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	public void Login(String uname , String pwd )
	{
		driver.switchTo().frame(loginframe);
		username.clear();
		username.sendKeys(uname);
		Password.sendKeys(pwd);
		loginbtn.click();
		
	}
}
