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
import com.dorman.flash.pages.SalesMainDash_Scenario6;
import com.dorman.flash.pages.Screenshot;
import com.relevantcodes.extentreports.LogStatus;

public class SalesMainDash_Scenario6_Test {
	
	Boolean flag=false;
	public BrowserInit binit = null;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 

	@Test(enabled=true,priority=11)
	
	public void dormanproducts_salesmaindash_Scenario6_qa() throws Exception {	
		//WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");
		try {		
	//	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");
		
		SalesMainDash sm = PageFactory.initElements(driver, SalesMainDash.class);
		SalesMainDash_Scenario6 sm6 = PageFactory.initElements(driver, SalesMainDash_Scenario6.class);
		sm.open_salesmaindash("qa");
		sm.clcikinRolling12();
		sm6.clickon_materialgroup_all();
		
		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
		String [] materialgroup= {"Brake_Cables","Control_Arms1","Convertible_Tops","Floor_Care","Hybrid_Components","Marketing","Transponder_Keys","Techm_Special_Order","Wheel_Order","Window_Regulators"};
		for(int i=0 ;i<materialgroup.length;i++)
		{	
			System.out.println("in for loop" +i);
			int j=i+1;
			String name=materialgroup[i];
			sm6.clcikon_materialgroup(materialgroup[i],i);
			
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario6_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
		if(i<materialgroup.length-1)
		{	
		sm6.clickagain_sc6(materialgroup[i]);
		
	}	
		}		
		flag=true;
	
}catch(Exception e)
	{
	Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 6");
	Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
	Extent.test_logger.log(LogStatus.INFO,e);
	 Extent.extent_report.endTest(Extent.test_logger);
	 flag=false;
	}
		
		finally {
			driver.close();
		}
}	
	
	
@Test(enabled=true,priority=12,dependsOnMethods= {"dormanproducts_salesmaindash_Scenario6_qa"})
	
	public void dormanproducts_salesmaindash_Scenario6_Stage() throws Exception {
	
	if(flag==true)
	{
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");

		try {
	//	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
	
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");
		
		SalesMainDash sm = PageFactory.initElements(driver, SalesMainDash.class);
		SalesMainDash_Scenario6 sm6 = PageFactory.initElements(driver, SalesMainDash_Scenario6.class);
		sm.open_salesmaindash("qa");
		sm.clcikinRolling12();
		sm6.clickon_materialgroup_all();
		
		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
		String [] materialgroup= {"Brake_Cables","Control_Arms1","Convertible_Tops","Floor_Care","Hybrid_Components","Marketing","Transponder_Keys","Techm_Special_Order","Wheel_Order","Window_Regulators"};
		for(int i=0 ;i<materialgroup.length;i++)
		{	
			System.out.println("in for loop" +i);
			int j=i+1;
			String name=materialgroup[i];
			sm6.clcikon_materialgroup(materialgroup[i],i);
			
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			sc.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario6_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
		if(i<materialgroup.length-1)
		{	
		sm6.clickagain_sc6(materialgroup[i]);
		
	}	
		}		
		
	
		
		String scenario6_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash\\Scenario6_Screenshots";
		
		String scenario6_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash\\Scenario6_Screenshots";	
	ExtentLog e=new ExtentLog();
	String dashoaradname ="Sales Main Dash _Scenario : 6";

	String log="Input Data used : Time Periods : Rolling 12 , Contributor : ALL ,  Sales Group : ALL, Price Group : ALL, Distribution Channel :ALL , Material Group :";
	e.log(scenario6_qapath, scenario6_stagepath, 10, materialgroup,log,dashoaradname,6,"SalesMainDash");
	}
		catch(Exception e)
		{
			Extent.test_logger = Extent.extent_report .startTest("Sales Main Dash _Scenario : 6");
			Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Stage Environment  ");
			Extent.test_logger.log(LogStatus.INFO ,e);
			 Extent.extent_report.endTest(Extent.test_logger);
			// flag=false;
		}
		finally {
			driver.close();
		}
}
}
}