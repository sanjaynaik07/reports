package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SalesMainDash_Scenario2 {
	WebDriver driver;
	Screen s1 =new Screen();
	
	//Pattern loading =new Pattern("D:\\Dorman_BI\\images\\salesmaindash\\Loading.PNG");
	
	Pattern loading =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Loading.PNG");
	public SalesMainDash_Scenario2(WebDriver driver)

	{
		this.driver = driver;
	}
	
	
	public void clcikon2018() throws Exception
	{
		
		Pattern ytd =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\ytd2.PNG");
		
		Pattern scrolldown =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario2\\scrolldown.PNG");
	
		Pattern y2018 =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario2\\2018.PNG");
		s1.click(ytd);
		s1.click(scrolldown);
		loading(s1,loading);
		
		s1.click(y2018);
		loading(s1,loading);
		
		
		//loading(s1,loading);
	}
	public void clcikon_contributorall() throws Exception
	{
		Pattern contributor_all =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario2\\contributor_all.PNG");
		s1.click(contributor_all);
	}
	
	public void contributor(String s) throws Exception
	{
		
		String drpdwn=s;
	
		
		Pattern contributor_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario2\\"+drpdwn+".PNG");
		
s1.click(contributor_drpdwn);
		
		loading(s1,loading);
		
		
	
	}
	
	public void clickagain_sc2(String s) throws Exception
	{
		
		String drpdwn=s;	
		Pattern contributor_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario2\\"+drpdwn+".PNG");
		
s1.click(contributor_drpdwn);
		
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
