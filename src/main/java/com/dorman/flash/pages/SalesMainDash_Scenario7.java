package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Button;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SalesMainDash_Scenario7 {
	WebDriver driver;
	Screen s1 =new Screen();
	//Pattern loading =new Pattern("D:\\Dorman_BI\\images\\salesmaindash\\Loading.PNG");
	
	Pattern loading =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Loading.PNG");
	public SalesMainDash_Scenario7(WebDriver driver)

	{
		this.driver = driver;
	}
	public void clcikon_pricegroup_all() throws Exception
	{
		Pattern customergroup =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario7\\Pricegrp_all.PNG");
		s1.click(customergroup);
	}
	
	public void clcikon_pricegroup(String s , int i) throws Exception
	{
		String drpdwn=s;
		
		System.out.println(drpdwn);
	
	
	Pattern pricegroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario7\\"+drpdwn+".PNG");
	
	Pattern internal =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario7\\Internal.PNG");
	if(i>7)
	{
		
		Pattern pricegroup_drpdwn1 =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario7\\scrolldown.PNG");
		
		s1.click(pricegroup_drpdwn1);
	}
	
s1.click(pricegroup_drpdwn);
	s1.hover(internal);
	loading(s1,loading);
	}
	
	public void clickagain_sc7(String s) throws Exception
	{
		String drpdwn=s;
		System.out.println(drpdwn);
	
	
	Pattern pricegroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario7\\"+drpdwn+".PNG");
	
s1.click(pricegroup_drpdwn);
	
	loading(s1,loading);
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
