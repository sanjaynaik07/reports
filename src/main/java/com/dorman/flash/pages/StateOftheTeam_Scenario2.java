package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Button;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class StateOftheTeam_Scenario2 {
	WebDriver driver;
	Screen s1 =new Screen();
	Pattern loading3 =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\loading3.PNG");
	
	public StateOftheTeam_Scenario2(WebDriver driver)

	{
		this.driver = driver;
		
		
	}
	
	public void select_2018() throws Exception

	{	
		
		Pattern ytdp =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\YTD.PNG");
		Pattern scrollbar =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario2\\scrollbar2.PNG");

		Pattern y2018 =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario2\\20182.PNG");
		Pattern groupcodeall =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario2\\mrtlgrpcode.PNG");

	
		loading(s1, loading3);
		s1.click(ytdp);
		loading(s1, loading3);
		s1.click(scrollbar);
		loading(s1, loading3);
		s1.click(y2018);
		loading(s1, loading3);
		
		s1.click(groupcodeall);
	}
	
	

	public void materialgroupcode(String s) throws Exception
	{	
		
		String mtrcode=s;
		
		
		Pattern mtr_dropdown =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario2\\"+mtrcode+".PNG");

		Pattern grpcode_down_btn =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario2\\grpcode_down.PNG");
		
		s1.hover(grpcode_down_btn);
		if(mtrcode.equals("0180"))
		{
		s1.wheel(mtr_dropdown, Button.WHEEL_DOWN, 10);
		}
		if(mtrcode.equals("01K7"))
		{
		s1.wheel(mtr_dropdown, Button.WHEEL_DOWN, 36);
		}
		
		if(mtrcode.equals("01R3"))
		{
		s1.wheel(mtr_dropdown, Button.WHEEL_DOWN, 10);
		}
		
		if(mtrcode.equals("05972"))
		{
		s1.wheel(mtr_dropdown, Button.WHEEL_DOWN, 18);
		}
		if(mtrcode.equals("06162"))
		{
		s1.wheel(mtr_dropdown, Button.WHEEL_DOWN, 6);
		}
	
		if(mtrcode.equals("0804"))
		{
		s1.wheel(mtr_dropdown, Button.WHEEL_DOWN, 7);
		}
		
		if(mtrcode.equals("0317"))
		{
		s1.wheel(mtr_dropdown, Button.WHEEL_UP, 18);
		}
		s1.click(mtr_dropdown);
		loading(s1, loading3);
		

	}
	public void clickagain_sc2(String s) throws Exception

	{	
String mtrcode=s;			
		Pattern mtr_drpdown =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario2\\"+mtrcode+".PNG");
		
		s1.click(mtr_drpdown);
		
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
