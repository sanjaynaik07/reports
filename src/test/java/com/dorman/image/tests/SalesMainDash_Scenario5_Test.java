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
import com.dorman.flash.pages.SalesMainDash;

import com.dorman.flash.pages.SalesMainDash_Scenario5;
import com.dorman.flash.pages.Screenshot;
import com.relevantcodes.extentreports.LogStatus;

public class SalesMainDash_Scenario5_Test {
	
	Boolean flag=false;
	public BrowserInit binit = null;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	
	
	
	@Test(priority=9)
	public void dormanproducts_salesmaindash_Scenario5_Qa() throws Exception {
		
		//WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");
		try {
//WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");
SalesMainDash sm = PageFactory.initElements(driver, SalesMainDash.class);
		
		sm.open_salesmaindash("qa");
		
		sm.clcikinRolling12();
		//SalesMainDash_Scenario2
		
		SalesMainDash_Scenario5 sm5 = PageFactory.initElements(driver, SalesMainDash_Scenario5.class);
		
		sm5.clcikon_customergroup();
		sm5.clcikon_customergroupall();
		
		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
		String [] custmergrp= {"Automotive_retail","export_channel","heavy_duty","home_retail","oe","other","salvage","special_markets","traditional"};
		for(int i=0 ;i<custmergrp.length;i++)
		{	
			System.out.println("in for loop" +i);
			int j=i+1;
			String name=custmergrp[i];
			sm5.clcikon_customergroup((custmergrp[i]),"Qa");
			
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario5_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
		if(i<custmergrp.length-1)
		{	
			sm5.clickagain_sc5(custmergrp[i],"Qa");
		
	}	
		}	
		flag=true;
		
		} catch(Exception e)
	           {
	              Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 5");
	              Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
	              Extent.test_logger.log(LogStatus.INFO,e);
                	 Extent.extent_report.endTest(Extent.test_logger);
	              flag=false;
	}
		finally {
			driver.close();
		}
		
	}
	
	
	
		@Test(priority=10,dependsOnMethods= {"dormanproducts_salesmaindash_Scenario5_Qa"})
		public void dormanproducts_salesmaindash_Scenario5_Stage() throws Exception {	
			if(flag==true)
			{
				WebDriver driver1 = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");

				try {
		LoginTest lgntst1 = PageFactory.initElements(driver1, LoginTest.class);
		lgntst1.login();
		DocumentTest dcmntst1 = PageFactory.initElements(driver1, DocumentTest.class);
		dcmntst1.document("qa");
SalesMainDash sm1 = PageFactory.initElements(driver1, SalesMainDash.class);
		
		sm1.open_salesmaindash("qa");
		
		sm1.clcikinRolling12();	
		SalesMainDash_Scenario5 sm52 = PageFactory.initElements(driver1, SalesMainDash_Scenario5.class);
		
		sm52.clcikon_customergroup();
		sm52.clcikon_customergroupall();
		
		Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);
String [] custmergrp= {"Automotive_retail","export_channel","heavy_duty","home_retail","oe","other","salvage","special_markets","traditional"};
		for(int i=0 ;i<custmergrp.length;i++)
		{	
			System.out.println("in for loop" +i);
			int j=i+1;
			String name=custmergrp[i];
			sm52.clcikon_customergroup((custmergrp[i]),"Stage");
			
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario5_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
		if(i<custmergrp.length-1)
		{	
			sm52.clickagain_sc5(custmergrp[i],"Stage");
		
	}	
		}

		String scenario5_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario5_Screenshots";
		
		String scenario5_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario5_Screenshots";
		
		ExtentLog e=new ExtentLog();
		String dashoaradname ="Sales Main Dash _Scenario : 5";

		String log="Input Data used : Time Periods : Rolling 12 , Distribution Channel : ALL , Contributor : ALL ,Material Group : ALL ,Price Group : ALL ,Customer Group  : ";
		e.log(scenario5_qapath, scenario5_stagepath, 9, custmergrp,log,dashoaradname,5,"SalesMainDash");
		}
				
				catch(Exception e)
				{
					Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 5");
					Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Stage Environment  ");
					Extent.test_logger.log(LogStatus.INFO ,e);
					 Extent.extent_report.endTest(Extent.test_logger);
					// flag=false;
				}
				finally {
					driver1.close();
				}
}
}
		
}