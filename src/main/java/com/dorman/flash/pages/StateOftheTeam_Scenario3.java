package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class StateOftheTeam_Scenario3 {
	WebDriver driver;
	Screen s1 =new Screen();
	Pattern loading3 =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\loading3.PNG");
	public StateOftheTeam_Scenario3(WebDriver driver)

	{
		this.driver = driver;
		
		
	}
	
	public void clcikytd() throws Exception
	{
		Pattern ytdp =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\YTD.PNG");
		
		s1.click(ytdp);
	}
	
	public void selectmonth(String s) throws Exception
	{
		
		String month=s;
		
		Pattern month_drpdwn =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario3\\"+month+".PNG");
		
		s1.click(month_drpdwn);
		loading(s1, loading3);
	}
	
	
	public void clickagain_sc3(String s) throws Exception

	{
       String month=s;			
		Pattern month_drpdown =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario3\\"+month+".PNG");
		
		s1.click(month_drpdown);
		
		loading(s1, loading3);
	
	  return;
	
	}
	public void loading(Screen s1, Pattern loading2) throws InterruptedException
	{
		while(s1.exists(loading2)!=null)
		{
			System.out.println("loading....");
			
			Thread.sleep(3000);
		}
		
		return;
	}
}
