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
import com.dorman.flash.pages.SalesMainDash;
import com.dorman.flash.pages.SalesMainDash_Scenario2;
import com.dorman.flash.pages.Screenshot;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.LogStatus;

public class SalesMainDash_Scenario2_Test {
	Boolean flag=false;
	public BrowserInit binit = null;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	

	@Test(enabled=true,priority=3)
	public void dormanproducts_salesmaindash_Scenario2_Qa() throws Exception {
	//	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");
		try {
	

		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");
SalesMainDash sm = PageFactory.initElements(driver, SalesMainDash.class);
		
		sm.open_salesmaindash("qa");
		SalesMainDash_Scenario2 sm2 = PageFactory.initElements(driver, SalesMainDash_Scenario2.class);
		sm.salesgroup();
		sm2.clcikon2018();
		sm2.clcikon_contributorall();
		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
		String [] contributor= {"dir_aj_alvarez","dir_corporate","dir_tony_ruiz","sp_cliff_green","sp_corporate"};
		for(int i=0 ;i<contributor.length;i++)
		{	
			System.out.println("in for loop" +i);
			int j=i+1;
			String name=contributor[i];
			sm2.contributor(contributor[i]);
			
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario2_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
		if(i<contributor.length-1)
		{	
		sm2.clickagain_sc2(contributor[i]);
		
	}	
		}	
		flag=true;
	
		}catch(Exception e)
		{
		Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 2");
		Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
		Extent.test_logger.log(LogStatus.INFO,e);
		 Extent.extent_report.endTest(Extent.test_logger);
		 flag=false;
		}
		
		finally
		{
			driver.close();
		}
	}
	
	
	@Test(enabled=true,priority=4,dependsOnMethods= {"dormanproducts_salesmaindash_Scenario2_Qa"})
	public void dormanproducts_salesmaindash_Scenario2_Stage() throws Exception {
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
		SalesMainDash_Scenario2 sm3 = PageFactory.initElements(driver1, SalesMainDash_Scenario2.class);
		sm1.salesgroup();
		sm3.clcikon2018();
		sm3.clcikon_contributorall();
		Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);
		String [] contributor= {"dir_aj_alvarez","dir_corporate","dir_tony_ruiz","sp_cliff_green","sp_corporate"};
		for(int i=0 ;i<contributor.length;i++)
		{	
			System.out.println("in for loop" +i);
			int j=i+1;
			String name=contributor[i];
			sm3.contributor(contributor[i]);
			
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario2_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
		if(i<contributor.length-1)
		{	
			sm3.clickagain_sc2(contributor[i]);
		
	}	
		}
		
		
		
		String scenario2_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario2_Screenshots";
		
		String scenario2_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario2_Screenshots";
		String dashoaradname ="Sales Main Dash _Scenario : 2";
		ExtentLog e=new ExtentLog();
			String log="Input Data used : Time Periods : 2018 , Distribution Channel : ALL , Sales Group : ALL , Material Group : ALL , Price Group : ALL , Contributor :";
			e.log(scenario2_qapath, scenario2_stagepath, 5, contributor,log,dashoaradname,2,"SalesMainDash");
			}
			catch(Exception e)
			{
				Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 2");
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