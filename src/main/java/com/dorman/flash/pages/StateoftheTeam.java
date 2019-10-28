package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Button;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliAction;
import org.sikuli.script.SikuliEvent;


public class StateoftheTeam {
	
	WebDriver driver;
	Screen s1 =new Screen();
	
	Pattern loading3 =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\loading3.PNG");
	
	//System.getProperty("user.dir")+"\\StateOfTheTeam_images
	public StateoftheTeam(WebDriver driver)

	{
		this.driver = driver;
		
		
	}
	
	
	//span[contains(text(),'DormanSales')]
	/*@FindBy(xpath = "//span[contains(text(),'DormanProduct')]")
	WebElement DormanProduct;*/
	
	
	@FindBy(xpath = "//div[text()='DormanProduct']")
	WebElement DormanProduct;
	
	//div[text()='DormanSales']
	
	@FindBy(xpath = "//div[text()='State of the Team']")
	WebElement stateoftheteam;
	
	
	public void open_stateoftheteam(String s) throws Exception
	{
		
		Actions a =new Actions(driver);
		
		System.out.println("in state of the team");
	//	DormanProduct.click();
		a.moveToElement(DormanProduct).doubleClick().build().perform();
		
		Thread.sleep(5000);
		
		a.moveToElement(stateoftheteam).doubleClick().build().perform();
		
		Pattern stateoftheteam =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\stateoftheteam.PNG");
		while(s1.exists(stateoftheteam) == null)
		{
			System.out.println("waiting for the state of the team");
				Thread.sleep(5000);
		}
		
		
		Pattern ytdp =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\YTD.PNG");
		
		while(s1.exists(ytdp) == null)
		{
			System.out.println("waiting for page to get displayed");
				Thread.sleep(8000);
		}
	
	}	
	
	public void selectrolling2() throws Exception

	{	
			
	
		Pattern ytdp =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\YTD.PNG");
		
		Pattern Rolling2 =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Rolling2.PNG");	
		
		Pattern extrmatrialgroup =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\extmtgrp.PNG");
	//	Pattern contributorall =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario4\\contributor.PNG");
	loading(s1, loading3);
		
		
		s1.wait(ytdp, 100);
		s1.click(ytdp);
		
		
		s1.click(Rolling2);	
		
		loading(s1, loading3);
		
s1.click(extrmatrialgroup);


	}
	
	
	public void externalmaterialgroup(String s) throws Exception

	{	
			String extmtrgrp=s;			
		Pattern extmtgrp_drpdown =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario1\\"+extmtrgrp+".PNG");
		
		s1.click(extmtgrp_drpdown);
		
	
		loading(s1, loading3);
	
		Thread.sleep(3000);
	  
	}
	
	public void clickagain(String s) throws Exception

	{	
String extmtrgrp=s;			
		Pattern extmtgrp_drpdown =new Pattern(System.getProperty("user.dir")+"\\StateOfTheTeam_images\\Scenario1\\"+extmtrgrp+".PNG");
		
		s1.click(extmtgrp_drpdown);
		
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
