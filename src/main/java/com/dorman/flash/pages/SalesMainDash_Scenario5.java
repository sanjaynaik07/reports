package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SalesMainDash_Scenario5 {
	WebDriver driver;
	Screen s1 =new Screen();
	//Pattern loading =new Pattern("D:\\Dorman_BI\\images\\salesmaindash\\Loading.PNG");
	
	Pattern loading =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Loading.PNG");
	
	public SalesMainDash_Scenario5(WebDriver driver)

	{
		this.driver = driver;
	}
	public void clcikon_customergroup() throws Exception
	{
		
		Pattern customergroup =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario5\\stage\\customergrp.PNG");
		s1.click(customergroup);
	}
	
	public void clcikon_customergroupall() throws Exception
	{
		Pattern customergroupall =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario5\\stage\\customergrp_all.PNG");
		s1.click(customergroupall);
	}
	
	public void clcikon_customergroup(String s,String env) throws Exception
	{
		String drpdwn=s;
		if(env.equals("Qa"))
		{
			Pattern customergroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario5\\Stage\\"+drpdwn+".PNG");
			s1.click(customergroup_drpdwn);
			
			loading(s1,loading);
		}
	
	
		else {
			Pattern customergroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario5\\stage\\"+drpdwn+".PNG");
			
			s1.click(customergroup_drpdwn);
				
				loading(s1,loading);
		}
	
	}
	
	public void clickagain_sc5(String s,String env) throws Exception
	{
		String drpdwn=s;
		if(env.equals("Qa"))
		{
			Pattern customergroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario5\\Stage\\"+drpdwn+".PNG");
			s1.click(customergroup_drpdwn);
			
			loading(s1,loading);
		}
	
	
		else {
			Pattern customergroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario5\\stage\\"+drpdwn+".PNG");
			
			s1.click(customergroup_drpdwn);
				
				loading(s1,loading);
		}
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
