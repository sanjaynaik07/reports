package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class StateoftheTeam_Scenario4 {
	WebDriver driver;
	Screen s1 =new Screen();
	Pattern loading3 =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\loading3.PNG");
	public StateoftheTeam_Scenario4(WebDriver driver)

	{
		this.driver = driver;
		
		
	}
	public void selectrolling2() throws Exception

	{	
			
	
		Pattern ytdp =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\YTD.PNG");
		
		Pattern Rolling2 =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Rolling2.PNG");
	
		Pattern contributorall =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario4\\contributor.PNG");
	loading(s1, loading3);
		
		
		s1.wait(ytdp, 100);
		s1.click(ytdp);
		
		
		s1.click(Rolling2);	
		
		loading(s1, loading3);
		s1.click(contributorall);	
		
	}
	
	public void contributor(String s) throws Exception
	{	
		
		String contributor =s;
	
		Pattern contributor_drpdown =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario4\\"+contributor+".PNG");
		
		s1.click(contributor_drpdown);
		loading(s1, loading3);
		
		Thread.sleep(2000);
		
	}
	
	
	

	public void clickagain_sc4(String s) throws Exception

	{	
String contributor=s;			
		Pattern contributor_drpdown =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario4\\"+contributor+".PNG");
		
		s1.click(contributor_drpdown);
		
		loading(s1, loading3);
	
	  return;
	}
	
	public void loading(Screen s1, Pattern loading2) throws InterruptedException
	{
		while(s1.exists(loading2)!=null)
		{
			System.out.println("loading....");
			
			Thread.sleep(5000);
		}
		
		return;
	}
}
