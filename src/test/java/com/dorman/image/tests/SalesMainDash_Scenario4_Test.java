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
import com.dorman.flash.pages.SalesMainDash_Scenario4;
import com.dorman.flash.pages.Screenshot;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.LogStatus;

public class SalesMainDash_Scenario4_Test {
	public BrowserInit binit = null;
	Boolean flag=false;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	
	@Test(priority=7)
	public void dormanproducts_salesmaindash_Scenario4_Qa() throws Exception {
		//WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");
		try {

	LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
	lgntst.login();
	DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
	dcmntst.document("qa");
SalesMainDash sm = PageFactory.initElements(driver, SalesMainDash.class);
	
	sm.open_salesmaindash("qa");
SalesMainDash_Scenario4 sm4 = PageFactory.initElements(driver, SalesMainDash_Scenario4.class);
	
	SalesMainDash_Scenario2 sm2 = PageFactory.initElements(driver, SalesMainDash_Scenario2.class);
	
	sm2.clcikon2018();
	sm4.clcikon_salesofficeall();
	Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
	String [] salesoffice= {"div-advance","div-autozone","div-canada","div-diesel","div-domestic","div-dorman-corporate","div-east","div-heavyduty","div-mch","div-mexico&latin_amrei","div-mpi",
			"div-napa","div-oe","div-o'reilly","div-west-us"};
	for(int i=0 ;i<salesoffice.length;i++)
	{	
		System.out.println("in for loop" +i);
		int j=i+1;
		String name=salesoffice[i];
		sm4.select_salesoffice(salesoffice[i]);
		
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario4_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
		
	if(i<salesoffice.length-1)
	{	
		sm4.clickagain_sc4(salesoffice[i]);
	
}	
	}	
	flag=true;
	
	
	}catch(Exception e)
		{
		Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 4");
		Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
		Extent.test_logger.log(LogStatus.INFO,e);
		 Extent.extent_report.endTest(Extent.test_logger);
		 flag=false;
		}
		finally {
			driver.close();
		}
	}	
	
	
	
	@Test(priority=8,dependsOnMethods= {"dormanproducts_salesmaindash_Scenario4_Qa"})
		public void dormanproducts_salesmaindash_Scenario4_Stage() throws Exception {
		
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
	SalesMainDash_Scenario4 sm41 = PageFactory.initElements(driver1, SalesMainDash_Scenario4.class);
	
	SalesMainDash_Scenario2 sm21 = PageFactory.initElements(driver1, SalesMainDash_Scenario2.class);
	
	sm21.clcikon2018();
	sm41.clcikon_salesofficeall();
	Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);
	String [] salesoffice= {"div-advance","div-autozone","div-canada","div-diesel","div-domestic","div-dorman-corporate","div-east","div-heavyduty","div-mch","div-mexico&latin_amrei","div-mpi",
			"div-napa","div-oe","div-o'reilly","div-west-us"};
	for(int i=0 ;i<salesoffice.length;i++)
	{	
		System.out.println("in for loop" +i);
		int j=i+1;
		String name=salesoffice[i];
		sm41.select_salesoffice(salesoffice[i]);
		
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario4_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
		
	if(i<salesoffice.length-1)
	{	
		sm41.clickagain_sc4(salesoffice[i]);
	
}	
	}	
	
	

	String scenario4_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario4_Screenshots";
	
	String scenario4_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario4_Screenshots";
	
	ExtentLog e=new ExtentLog();
	String dashoaradname ="Sales Main Dash _Scenario : 4";

	String log="Input Data used : Time Periods : 2018 , Distribution Channel : ALL , Contributor : ALL ,Material Group : ALL ,Price Group : ALL , salesoffice : ";
	e.log(scenario4_qapath, scenario4_stagepath, 15, salesoffice,log,dashoaradname,4,"SalesMainDash");
	
}
			catch(Exception e)
			{
				Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 4");
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