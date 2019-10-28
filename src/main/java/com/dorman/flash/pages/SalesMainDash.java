package com.dorman.flash.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SalesMainDash {

	
	WebDriver driver;
	Screen s1 =new Screen();
	
	//System.getProperty("user.dir")+"\\SalesMainDash_images\\Loading.PNG
//	Pattern loading =new Pattern("D:\\Dorman_BI\\images\\salesmaindash\\Loading.PNG");
	
	Pattern loading =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Loading.PNG");
	public SalesMainDash(WebDriver driver)

	{
		this.driver = driver;
	}
	/*@FindBy(xpath = "//span[contains(text(),'DormanSales')]")
	WebElement Dormansales;*/
	
	@FindBy(xpath = "//div[text()='DormanSales']")
	WebElement Dormansales;
	//div[text()='DormanSales']
	@FindBy(xpath = "//div[text()='_Sales Main Dash']")
	WebElement salesmaindash;
	
	public void open_salesmaindash(String s) throws Exception
	{
		Actions a =new Actions(driver);
	//	Dormansales.click();
		
		
		a.moveToElement(Dormansales).doubleClick().build().perform();
		
		Thread.sleep(3000);
		a.moveToElement(salesmaindash).doubleClick().build().perform();

	
		Pattern stateoftheteam =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\salesmiandash.PNG");	
		
		Pattern ytd =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\ytd2.PNG");
		
		while(s1.exists(stateoftheteam) == null)
		{
			System.out.println("waiting for the sales main dash board");
				Thread.sleep(10000);
		}
		while(s1.exists(ytd) == null)
		{
			System.out.println("waiting for page to get displayed");
				Thread.sleep(15000);
		}
		
		loading(s1,loading);	
		
		
	}
	
	
	public void clcikinRolling12() throws Exception
	{
		Pattern ytd =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\ytd2.PNG");
	
		Pattern Rolling12 =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario1\\Rolling12.PNG");
		s1.click(ytd);	
		s1.click(Rolling12);
		loading(s1,loading);
	}
	
	public void salesgroup() throws Exception
	{
		
		Pattern salesgroup =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario1\\salesgroup.PNG");	
		s1.click(salesgroup);
		loading(s1,loading);
	}
	public void distribution_channel(String s,int i) throws Exception
	{
		String drpdwn=s;
		if(i!=0)
		{
			Pattern Distribution_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario1\\"+drpdwn+".PNG");
			
			s1.click(Distribution_drpdwn);
					
					loading(s1,loading);	
		}
		return;
	}
	
	
	public void clickagain_sc1(String s) throws Exception
	{
		String drpdwn=s;
Pattern Distribution_drpdwn =new Pattern(System.getProperty("user.dir")+"\\SalesMainDash_images\\Scenario1\\"+drpdwn+".PNG");
		
s1.click(Distribution_drpdwn);
		
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
