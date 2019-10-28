package com.dorman.image.tests;

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
import com.dorman.flash.pages.SalesMainDash_Scenario7;
import com.dorman.flash.pages.Screenshot;
import com.dorman.flash.pages.StateoftheTeam;
import com.dorman.flash.pages.StateoftheTeam_Scenario4;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SalesMainDash_Scenario7_Test {

	Boolean flag=false;
	public BrowserInit binit = null;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	
	
@Test(enabled=true,priority=13)
	
	public void dormanproducts_stateoftheteam_Scenario7_Qa() throws Exception {
	
	//WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");
	try {
	

	LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
	lgntst.login();

	
	DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
	dcmntst.document("qa");

	SalesMainDash sm = PageFactory.initElements(driver, SalesMainDash.class);
	SalesMainDash_Scenario7 sm7 = PageFactory.initElements(driver, SalesMainDash_Scenario7.class);
	
	SalesMainDash_Scenario2 sm2 = PageFactory.initElements(driver, SalesMainDash_Scenario2.class);

	sm.open_salesmaindash("qa");
	sm2.clcikon2018();
	sm7.clcikon_pricegroup_all();
	String[] pricegroup= {"Alliance","Apsg_The_Group","Auto_Plus","Canadian_Tire","Carrequest","CMB_Marketting","Heavy_Duty_Power","Heavy_Duty_Traction","Keystone","Street_Price_level1","MPI_AfterMarket","Napa","Napa_uap","Non_Affilliated"};
	Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
	//String[] pricegroup= {"Heavy_Duty_Traction","Street_Price_level1","MPI_AfterMarket","Napa","Napa_uap","Non_Affilliated"};
	for(int i=0 ;i<pricegroup.length;i++)
	{	
		System.out.println("in for loop" +i);
		int j=i+1;
		String name=pricegroup[i];
		sm7.clcikon_pricegroup(pricegroup[i],i);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario7_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
		
	if(i<pricegroup.length-1)
	{	
		sm7.clickagain_sc7(pricegroup[i]);
	
}	
	}	
	
	flag=true;
	
	}catch(Exception e)
	{
	Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 7");
	Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
	Extent.test_logger.log(LogStatus.INFO,e);
	 Extent.extent_report.endTest(Extent.test_logger);
	 flag=false;
	}
	finally {
		driver.close();
	}
}


	@Test(enabled=true,priority=14,dependsOnMethods= {"dormanproducts_stateoftheteam_Scenario7_Qa"})
	
	public void dormanproducts_stateoftheteam_Scenario7_Stage() throws Exception {
		
		if(flag==true)
		{
			WebDriver driver1 = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");

			try {
	LoginTest lgntst1 = PageFactory.initElements(driver1, LoginTest.class);
	lgntst1.login();

	
	DocumentTest dcmntst1 = PageFactory.initElements(driver1, DocumentTest.class);
	dcmntst1.document("qa");

	SalesMainDash sm1 = PageFactory.initElements(driver1, SalesMainDash.class);
	SalesMainDash_Scenario7 sm71 = PageFactory.initElements(driver1, SalesMainDash_Scenario7.class);
	
	SalesMainDash_Scenario2 sm21 = PageFactory.initElements(driver1, SalesMainDash_Scenario2.class);

	sm1.open_salesmaindash("qa");
	sm21.clcikon2018();
	sm71.clcikon_pricegroup_all();
String[] pricegroup= {"Alliance","Apsg_The_Group","Auto_Plus","Canadian_Tire","Carrequest","CMB_Marketting","Heavy_Duty_Power","Heavy_Duty_Traction","Keystone","Street_Price_level1","MPI_AfterMarket","Napa","Napa_uap","Non_Affilliated"};
	Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);
	for(int i=0 ;i<pricegroup.length;i++)
	{	
		System.out.println("in for loop" +i);
		int j=i+1;
		String name=pricegroup[i];
		sm71.clcikon_pricegroup(pricegroup[i],i);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	
		sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario7_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
		
	if(i<pricegroup.length-1)
	{	
		sm71.clickagain_sc7(pricegroup[i]);
	
}	
	}




	String scenario7_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario7_Screenshots";
	
	String scenario7_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario7_Screenshots";
	ExtentLog e=new ExtentLog();
	String dashoaradname =" Sales Main Dash _Scenario : 7";

	String log="Input Data used : Time Periods : 2018 , Distribution Channel : ALL , Sales Office : ALL , Material Group : ALL , Contributor : ALL ,price group :";
	e.log(scenario7_qapath, scenario7_stagepath, 14, pricegroup,log,dashoaradname,7,"SalesMainDash");
}
			
			catch(Exception e)
			{
				Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 7");
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