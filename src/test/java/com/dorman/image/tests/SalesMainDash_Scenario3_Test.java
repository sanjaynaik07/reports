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
import com.dorman.flash.pages.SalesMainDash;
import com.dorman.flash.pages.SalesMainDash_Scenario2;
import com.dorman.flash.pages.SalesMainDash_Scenario3;
import com.dorman.flash.pages.Screenshot;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.LogStatus;

public class SalesMainDash_Scenario3_Test {
	
	Boolean flag=false;
	public BrowserInit binit = null;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	
	
	
	@Test(enabled=true,priority=5)
	public void dormanproducts_salesmaindash_Scenario3_qa() throws Exception {
	//	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");
		try {
      
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");
SalesMainDash sm = PageFactory.initElements(driver, SalesMainDash.class);
		
		sm.open_salesmaindash("qa");
		SalesMainDash_Scenario3 sm3 = PageFactory.initElements(driver, SalesMainDash_Scenario3.class);
		

		
		SalesMainDash_Scenario2 sm2 = PageFactory.initElements(driver, SalesMainDash_Scenario2.class);
		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class); 
		sm2.clcikon2018();
		sm3.clcikon_salesgroup();
		sm3.clcikon_salesgroupall();
		String[] salesgroup= {"Aut-Advance","Aut-Autozone","Aut-Autozone-Mexico","Aut-Canadian_Tire","Aut-Oreilly","Aut-Pep_Boys","Heavy-Duty-HD_Canada",
				"Heavy-Duty-HD_NorthEast","Oe-Oe","Traditional_CarRequest","Traditional_Domestic_International","Traditional_NorthEast(k)","Traditional_Napa","Traditional_Upper_MidWest(Q)","Traditional_WesternCanada(Y)"};

		for(int i=0 ;i<salesgroup.length;i++)
		{	
		System.out.println("in for loop" +i);
			int j=i+1;
			String name=salesgroup[i];
			sm3.select_salesgroup(salesgroup[i], i,"Qa");
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario3_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
		if(i<salesgroup.length-1)
		{
			System.out.println("in for loop" +i);
		
			System.out.println(salesgroup[i]);
			sm3.clickagain_sc3(salesgroup[i],"Qa");
		}	
		}	
		flag=true;
	
		}
		catch(Exception e)
		{
		Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 3");
		Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
		Extent.test_logger.log(LogStatus.INFO,e);
		 Extent.extent_report.endTest(Extent.test_logger);
		 flag=false;
		}
		finally {
			driver.close();
		}
	}		
	
	//,dependsOnMethods= {"dormanproducts_salesmaindash_Scenario3_qa"}
	
	@Test(priority=6,dependsOnMethods= {"dormanproducts_salesmaindash_Scenario3_qa"})
	public void dormanproducts_salesmaindash_Scenario3_Stage() throws Exception {
		
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
	SalesMainDash_Scenario3 sm31 = PageFactory.initElements(driver1, SalesMainDash_Scenario3.class);
	
	//SalesMainDash_Scenario2
	
	SalesMainDash_Scenario2 sm21 = PageFactory.initElements(driver1, SalesMainDash_Scenario2.class);
	Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class); 
	sm21.clcikon2018();
	sm31.clcikon_salesgroup();
	sm31.clcikon_salesgroupall();
	
	String[] salesgroup= {"Aut-Advance","Aut-Autozone","Aut-Autozone-Mexico","Aut-Canadian_Tire","Aut-Oreilly","Aut-Pep_Boys","Heavy-Duty-HD_Canada",
			"Heavy-Duty-HD_NorthEast","Oe-Oe","Traditional_CarRequest","Traditional_Domestic_International","Traditional_NorthEast(k)","Traditional_Napa","Traditional_Upper_MidWest(Q)","Traditional_WesternCanada(Y)"};
	
	
	for(int i=0 ;i<salesgroup.length;i++)
	{	
	System.out.println("in for loop" +i);
		int j=i+1;
		String name=salesgroup[i];
		sm31.select_salesgroup(salesgroup[i], i,"Stage");
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
	sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario3_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
		
	if(i<salesgroup.length-1)
	{
		System.out.println("in for loop" +i);
	
		System.out.println(salesgroup[i]);
		sm31.clickagain_sc3(salesgroup[i],"Stage");
	}	

	}
		
		
		
	ExtentLog e=new ExtentLog();
	
String scenario3_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario3_Screenshots";
String dashoaradname ="Sales Main Dash _Scenario : 3";
	String scenario3_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario3_Screenshots";
	String log="Input Data used : Time Periods : 2018 , Contributor : ALL , Distribution Channel : ALL , Material Group : ALL , Price Group : ALL,  Sales Group :";
	e.log(scenario3_qapath, scenario3_stagepath, 15, salesgroup,log,dashoaradname,3,"SalesMainDash");
	
	
	
	}
			catch(Exception e)
			{
				Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 3");
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