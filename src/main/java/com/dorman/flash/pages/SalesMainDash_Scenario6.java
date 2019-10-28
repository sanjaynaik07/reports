package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Button;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SalesMainDash_Scenario6 {
	WebDriver driver;
	Screen s1 =new Screen();
	//Pattern loading =new Pattern("D:\\Dorman_BI\\images\\salesmaindash\\Loading.PNG");
	
	Pattern loading =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Loading.PNG");
	
	public SalesMainDash_Scenario6(WebDriver driver)

	{
		this.driver = driver;
	}
	
	
	public void clickon_materialgroup_all() throws Exception
	{
		Pattern salesgroup =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario6\\Material_Group_All.PNG");	
		s1.click(salesgroup);
		loading(s1,loading);
	}
	

	public void clcikon_materialgroup(String s,int i) throws Exception
	{
		String drpdwn=s;
		Pattern materialgroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario6\\"+drpdwn+".PNG");
		
		Pattern wd =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario6\\4wd.PNG");
		
		s1.hover(wd);
		
		if(i==0)
		{	
			 s1.wheel(Button.WHEEL_DOWN, 7);	  
		}
		
		if(i==1||i==2)
		{
			 s1.wheel(Button.WHEEL_DOWN, 14);
		}
		if(i==3)
		{
			s1.wheel(Button.WHEEL_DOWN, 22);
		}
		if(i==4)
		{
			s1.wheel(Button.WHEEL_DOWN, 35);
		}
		
		if(i==5)
		{
			s1.hover(wd);
			s1.wheel(Button.WHEEL_DOWN, 42);
		}
		
		if(i==6||i==7)
		{
			s1.wheel(Button.WHEEL_DOWN, 60);
		}
		if(i==8||i==9)
		{
			s1.wheel(Button.WHEEL_DOWN, 70);
		}

		s1.click(materialgroup_drpdwn);
		
		loading(s1,loading);
	}
	
	public void clickagain_sc6(String s)throws Exception
	{
		String drpdwn=s;
		
		Pattern materialgroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario6\\"+drpdwn+".PNG");
		s1.click(materialgroup_drpdwn);
		
		//loading(s1,loading);
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
