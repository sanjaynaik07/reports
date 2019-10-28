package com.dorman.image.tests;

import java.io.File;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Date;
import com.dorman.bitest.extentreport.Extent;
import com.dorman.bitest.extentreport.ExtentLog;
import com.dorman.bitest.startbrowser.BrowserInit;
import com.dorman.bitest.tests.DocumentTest;
import com.dorman.bitest.tests.LoginTest;
import com.dorman.flash.pages.GetFileNames;
import com.dorman.flash.pages.LatestImage;
import com.dorman.flash.pages.Screenshot;
import com.dorman.flash.pages.StateoftheTeam;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.LogStatus;

public class StateoftheTeam_Scenaro1_Test {
	
	Boolean flag=false;
	public BrowserInit binit = null;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	

	@Test(enabled=true,priority=15)
	public void dormanproducts_stateoftheteam_Scenario1_Qa() throws Exception {
		try {
	
//	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();	
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
	dcmntst.document("qa");	
	Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class); 
	
		StateoftheTeam st = PageFactory.initElements(driver, StateoftheTeam.class);
		
		st.open_stateoftheteam("qa");
		
		st.selectrolling2();

		String [] extmtrgrp1= {"BDY","CHS","ENG","INN","PKG","RMN","RTL","UND","VOID"};

		for(int i=0 ;i<extmtrgrp1.length;i++)
		{
			
			int j=i+1;
			String name=extmtrgrp1[i];
			st.externalmaterialgroup(extmtrgrp1[i]);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario1_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+timestamp+".jpg");
			
			if(i<extmtrgrp1.length-1)
			{
				
			
			st.clickagain(extmtrgrp1[i]);
			
		}
		}         
		flag=true;	 
		 driver.close();
	}catch(Exception e)
	{
	Extent.test_logger = Extent.extent_report .startTest("State of the Team _Scenario : 1");
	Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
	Extent.test_logger.log(LogStatus.INFO,e);
	 Extent.extent_report.endTest(Extent.test_logger);
	 flag=false;
	}
}
	
	
	@Test(enabled=true,priority=16,dependsOnMethods= {"dormanproducts_stateoftheteam_Scenario1_Qa"})
    public void dormanproducts_stateoftheteam_Scenario1_Stage() throws Exception {
		if(flag==true)
		{
			try {
		
		WebDriver driver1 = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");

		LoginTest lgntst1 = PageFactory.initElements(driver1, LoginTest.class);
		lgntst1.login();
//		Extent.test_logger.log(LogStatus.INFO, "Logged in to BOTEST");
		DocumentTest dcmntst1 = PageFactory.initElements(driver1, DocumentTest.class);
		dcmntst1.document("stage");
//		Extent.test_logger.log(LogStatus.INFO, "clicked on documents, expanded public folders");
		StateoftheTeam st1 = PageFactory.initElements(driver1, StateoftheTeam.class);
		
		Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);

		
			st1.open_stateoftheteam("stage");
			
			
			st1.selectrolling2();
			
		String [] extmtrgrp1= {"BDY","CHS","ENG","INN","PKG","RMN","RTL","UND","VOID"};
			
			for(int i=0 ;i<extmtrgrp1.length;i++)
			{
				int j=i+1;
				String name=extmtrgrp1[i];
				st1.externalmaterialgroup(extmtrgrp1[i]);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario1_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+timestamp+".jpg");
				
				if(i<extmtrgrp1.length-1)
				{
					
				
				st1.clickagain(extmtrgrp1[i]);
				
			}
			}
			
			 driver1.close();
	
			String scenario1_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario1_Screenshots";
			
			String scenario1_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario1_Screenshots";
			ExtentLog e=new ExtentLog();
			String dashboaradname ="State of the Team _Scenario : 1";

			String log= "Input Data used  : Time Periods : Rolling 12 , Contributor : ALL , Material Group Code : ALL , External Material Group :";
			e.log(scenario1_qapath, scenario1_stagepath, 9, extmtrgrp1,log,dashboaradname,1,"StateoftheTeam");	
}
			catch(Exception e)
			{
				Extent.test_logger = Extent.extent_report .startTest("State of the Team _Scenario : 1");
				Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Stage Environment  ");
				Extent.test_logger.log(LogStatus.INFO ,e);
				 Extent.extent_report.endTest(Extent.test_logger);
				// flag=false;
			}
}
	}
}