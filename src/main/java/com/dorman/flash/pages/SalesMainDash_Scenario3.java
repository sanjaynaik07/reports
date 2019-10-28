package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Button;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SalesMainDash_Scenario3 {

	
	WebDriver driver;
	Screen s1 =new Screen();
	
	Pattern loading =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Loading.PNG");
	//Pattern loading =new Pattern("D:\\Dorman_BI\\images\\salesmaindash\\Loading.PNG");
	public SalesMainDash_Scenario3(WebDriver driver)

	{
		this.driver = driver;
	}
	public void clcikon_salesgroup() throws Exception
	{

		Pattern salesgroup =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario3\\salesgroup.PNG");
		s1.click(salesgroup);
		
	}
	public void clcikon_salesgroupall() throws Exception
	{
		Pattern salesgroup_all =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario3\\salesgroup_all.PNG");
		s1.click(salesgroup_all);
	}
	public void select_salesgroup(String s, int i,String env) throws Exception
	{
		Pattern salesgroup_drpdwn;
		if(env.equals("Qa"))
		{
		String drpdwn=s;	
		 salesgroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario3\\Stage\\"+drpdwn+".PNG");
		}
		else {
			String drpdwn=s;
			salesgroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario3\\Stage\\"+drpdwn+".PNG");
		}
   if(i>5&i<=8)
    {
	   Pattern scroll_down =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario3\\Qa\\scrolldown.PNG");
	   loading(s1,loading);
	   s1.click(scroll_down);
	   System.out.println("in scroll down");
	   
	}
   
   if(i>8&i<=10)
   {
	   System.out.println(i);
	   Pattern first =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario3\\Stage\\Aut-Advance.PNG");
	   Pattern scroll_down2 =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Qa\\scrolldown2.PNG");
	 /*  loading(s1,loading);
	   s1.click(scroll_down2);
	   System.out.println("in scroll down");*/
	   s1.hover(first);
	   s1.wheel(Button.WHEEL_DOWN, 12);
	   s1.click(salesgroup_drpdwn);
	 
   }
   
   if(i>10)
   {
	   
	   Pattern first =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario3\\Stage\\Aut-Advance.PNG");
	//   Pattern scroll_down2 =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario3\\Qa\\scrolldown2.PNG");
	   s1.hover(first);
	   s1.wheel (Button.WHEEL_DOWN, 40);
	   s1.click(salesgroup_drpdwn);
	   
   }
 
 
s1.click(salesgroup_drpdwn);
loading(s1,loading);
	}
	
	
	public void clickagain_sc3(String s,String env ) throws Exception
	{
		Pattern salesgroup_drpdwn;
		if(env.equals("Qa"))
		{
		String drpdwn=s;

		
		 salesgroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario3\\Stage\\"+drpdwn+".PNG");
		
s1.click(salesgroup_drpdwn);
		}
		else
		{
			String drpdwn=s;

			
			 salesgroup_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario3\\Stage\\"+drpdwn+".PNG");
			
	s1.click(salesgroup_drpdwn);
		}

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
