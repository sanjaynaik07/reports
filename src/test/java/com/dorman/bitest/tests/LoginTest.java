package com.dorman.bitest.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dorman.bitest.pages.LoginPage;
import com.dorman.bitest.startbrowser.BrowserInit;
import com.dorman.bitest.startbrowser.BrowserInit2;

public class LoginTest extends BrowserInit {
	
	@Test
	public void login()
	{
		
		
	  LoginPage lp =PageFactory.initElements(driver, LoginPage.class);
      lp.Login("sdhanavath","Augu$t19!");
	}
	
	
	
}
