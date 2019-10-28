package com.dorman.image.tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dorman.bitest.extentreport.Extent;
import com.dorman.bitest.extentreport.ExtentLog;
import com.dorman.bitest.startbrowser.BrowserInit;
import com.dorman.bitest.tests.DocumentTest;
import com.dorman.bitest.tests.LoginTest;
import com.dorman.flash.pages.GetFileNames;
import com.dorman.flash.pages.LatestImage;
import com.dorman.flash.pages.Screenshot;
import com.dorman.flash.pages.StateOftheTeam_Scenario2;
import com.dorman.flash.pages.StateoftheTeam;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.LogStatus;

public class StateoftheTeam_Scenaro2_Test {
	
	Boolean flag=false;
	public BrowserInit binit = null;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	
	@Test(enabled=true,priority=17)
	
	public void dormanproducts_stateoftheteam_Scenario2_Qa() throws Exception {
		
		try {
	//	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");
	//	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		
		
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");
		
		//Extent.test_logger.log(LogStatus.INFO, "clicked on documents, expanded public folders");
		StateoftheTeam st1 = PageFactory.initElements(driver, StateoftheTeam.class);
		StateOftheTeam_Scenario2 st = PageFactory.initElements(driver, StateOftheTeam_Scenario2.class);
		
		st1.open_stateoftheteam("qa");
		
		st.select_2018();
		
		
		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
		String [] grpcode= {"0180","0186","01K7","01L5","01R3","01T1","05972","06162","0804","0317"};
//		String [] extmtrgrp1= {"BDY1"};
//		 System.out.println(scenario1_qapath+"\\"+qa_filename);
		for(int i=0 ;i<grpcode.length;i++)
		{
			
			int j=i+1;
		
			String name=grpcode[i];
			st.materialgroupcode(grpcode[i]);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario2_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
			if(i<grpcode.length-1)
			{
				
			
			st.clickagain_sc2(grpcode[i]);
			
		}
			
		}
		flag=true;
		driver.close();
	}		catch(Exception e)
		{
		Extent.test_logger = Extent.extent_report .startTest("State of the Team _Scenario : 2");
		Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
		Extent.test_logger.log(LogStatus.INFO,e);
		 Extent.extent_report.endTest(Extent.test_logger);
		 flag=false;
		}
	}	
		
//	,dependsOnMethods= {"dormanproducts_stateoftheteam_Scenario2_Qa"}
	@Test(enabled=true,priority=18,dependsOnMethods= {"dormanproducts_stateoftheteam_Scenario2_Qa"})
	public void dormanproducts_stateoftheteam_Scenario2_Stage() throws Exception {
		if(flag==true)
		{
			try {
	WebDriver driver1 = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");
		LoginTest lgntst1 = PageFactory.initElements(driver1, LoginTest.class);
		lgntst1.login();
		
		
		DocumentTest dcmntst1 = PageFactory.initElements(driver1, DocumentTest.class);
		dcmntst1.document("stage");
		
		//Extent.test_logger.log(LogStatus.INFO, "clicked on documents, expanded public folders");
		StateoftheTeam st2 = PageFactory.initElements(driver1, StateoftheTeam.class);
		StateOftheTeam_Scenario2 st3 = PageFactory.initElements(driver1, StateOftheTeam_Scenario2.class);
		
		st2.open_stateoftheteam("qa");
		
		st3.select_2018();
		
		
		Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);
		
	//	String [] grpcode= {"0180","0186","01K7","01L5","01R3","01T1","05972","06162","0804","0317"};
	String [] grpcode= {"0180","0186","01K7","01L5","01R3","01T1","05972","06162","0804","0317"};

		for(int i=0 ;i<grpcode.length;i++)
		{
			
			int j=i+1;
			String name=grpcode[i];
			st3.materialgroupcode(grpcode[i]);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario2_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
			if(i<grpcode.length-1)
			{
				
			
			st3.clickagain_sc2(grpcode[i]);
			
		}
			
		}
		
		driver1.close();
		String scenario2_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario2_Screenshots";
		String scenario2_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario2_Screenshots";
		
		
		ExtentLog e=new ExtentLog();
		String dashboaradname ="State Of the Team _Scenario : 2";

		String log="Input Data used :Time Periods : 2018 , External Material Group : ALL  , Contributor : ALL , Material Group Code  :";
		e.log(scenario2_qapath, scenario2_stagepath, 10, grpcode,log,dashboaradname,2,"StateoftheTeam");

	}
	
			catch(Exception e)
			{
				Extent.test_logger = Extent.extent_report .startTest("State of the Team _Scenario : 2");
				Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Stage Environment  ");
				Extent.test_logger.log(LogStatus.INFO ,e);
				 Extent.extent_report.endTest(Extent.test_logger);
				// flag=false;
			}
}
	}
	
}
