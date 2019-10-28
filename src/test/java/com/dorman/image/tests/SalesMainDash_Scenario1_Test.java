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
import com.dorman.flash.pages.SalesMainDash;
import com.dorman.flash.pages.Screenshot;
import com.relevantcodes.extentreports.LogStatus;

public class SalesMainDash_Scenario1_Test {

	Boolean flag=false;
	public BrowserInit binit = null;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	

	@Test(enabled=true,priority=1)
	
	public void dormanproducts_salesmaindash_Scenario1_qa() throws Exception {
	//	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");

		try {
		

		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");
		
		SalesMainDash sm = PageFactory.initElements(driver, SalesMainDash.class);
		
		sm.open_salesmaindash("qa");
		sm.clcikinRolling12();
		sm.salesgroup();
		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
		String [] dstchannel= {"Distribution_all","Auto_aftermarket","Mch_mass"};
		for(int i=0 ;i<dstchannel.length;i++)
		{	
			System.out.println("in for loop" +i);
			int j=i+1;
			String name=dstchannel[i];
			sm.distribution_channel(dstchannel[i],i);
			
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario1_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
		if(i<dstchannel.length-1)
		{	
		sm.clickagain_sc1(dstchannel[i]);
		
	}	
		}		
		
		flag=true;
		
	}catch(Exception e)
		{
		Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 1");
		Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
		Extent.test_logger.log(LogStatus.INFO,e);
		 Extent.extent_report.endTest(Extent.test_logger);
		 flag=false;
		
		}
		
		finally{
			driver.close();	
		}
	}	
	
	//,dependsOnMethods= {"dormanproducts_salesmaindash_Scenario1_qa"}
	
	
		@Test(enabled=true,priority=2,dependsOnMethods= {"dormanproducts_salesmaindash_Scenario1_qa"})
		public void dormanproducts_salesmaindash_Scenario1_Stage() throws Exception {
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
		sm1.salesgroup();
		Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);
		String [] dstchannel= {"Distribution_all","Auto_aftermarket","Mch_mass"};
		for(int i=0 ;i<dstchannel.length;i++)
		{	
			System.out.println("in for loop" +i);
			int j=i+1;
			String name=dstchannel[i];
			sm1.distribution_channel(dstchannel[i],i);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario1_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
		if(i<dstchannel.length-1)
		{	
		sm1.clickagain_sc1(dstchannel[i]);
		
	}	
		}		
			
			
	
			
String scenario1_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario1_Screenshots";
	
	String scenario1_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario1_Screenshots";	
ExtentLog e=new ExtentLog();
String dashoaradname ="Sales Main Dash _Scenario : 1";

String log="Input Data used : Time Periods : Rolling 12 , Contributor : ALL ,  Sales Group : ALL , Material Group : ALL , Price Group : ALL, Distribution Channel :";
e.log(scenario1_qapath, scenario1_stagepath, 3, dstchannel,log,dashoaradname,1,"SalesMainDash");
}
				catch(Exception e)
				{
					Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 1");
					Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Stage Environment  ");
					Extent.test_logger.log(LogStatus.INFO ,e);
					 Extent.extent_report.endTest(Extent.test_logger);
					// flag=false;
					
				}
				
				finally
				{
					driver1.close();
				}
}
			
}
}