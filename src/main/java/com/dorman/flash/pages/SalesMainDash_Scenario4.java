package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SalesMainDash_Scenario4 {
	WebDriver driver;
	Screen s1 =new Screen();
	//Pattern loading =new Pattern("D:\\Dorman_BI\\images\\salesmaindash\\Loading.PNG");
	
		Pattern loading =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Loading.PNG");
	public SalesMainDash_Scenario4(WebDriver driver)

	{
		this.driver = driver;
	}
	
	
	public void clcikon_salesofficeall() throws Exception
	{
		
		//D:\Dorman_BI\images\salesmaindash\Scenario4
		Pattern salesoffice_all =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario4\\salesoffice_all.PNG");
		s1.click(salesoffice_all);
	}
	
	public void select_salesoffice(String s) throws Exception
	{
		String drpdwn=s;
		
		Pattern salesoffice_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario4\\"+drpdwn+".PNG");
		
s1.click(salesoffice_drpdwn);
		
		loading(s1,loading);
	}
	
	
	public void clickagain_sc4(String s) throws Exception
	{
		
		String drpdwn=s;
		
		
		Pattern salesoffice_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario4\\"+drpdwn+".PNG");
		
s1.click(salesoffice_drpdwn);
		
		loading(s1,loading);
		
		return;
	
	}
	
	public void loading(Screen s1, Pattern loading) throws InterruptedException
	{
		while(s1.exists(loading)!=null)
		{
			System.out.println("loading....");
			
			Thread.sleep(5000);
		}
		
		return;
	}
}

