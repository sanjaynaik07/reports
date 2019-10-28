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
import com.dorman.flash.pages.StateoftheTeam;
import com.dorman.flash.pages.StateoftheTeam_Scenario4;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.LogStatus;

public class StateoftheTeam_Scenaro4_Test {
	
	Boolean flag=false;
	public BrowserInit binit = null;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	
	
@Test(enabled=true,priority=21)
	
	public void dormanproducts_stateoftheteam_Scenario4_Qa() throws Exception {
	try {
	//WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");
//	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");
	LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
	lgntst.login();

	
	DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
	dcmntst.document("qa");

	StateoftheTeam st1 = PageFactory.initElements(driver, StateoftheTeam.class);
	StateoftheTeam_Scenario4 st = PageFactory.initElements(driver, StateoftheTeam_Scenario4.class);
	
	st1.open_stateoftheteam("qa");

	st.selectrolling2();
	Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
	String [] contributor= {"BRIAN_MURFY_X5547","chrisvan","HARRY_MOBLEY_X5393","JEFF_TRIPP_X5399","JEN_SCHROEDER_X5119"};
	
	for(int i=0 ;i<contributor.length;i++)
	{	
		int j=i+1;
		String name=contributor[i];
		st.contributor(contributor[i]);
		
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario4_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
		
	if(i<contributor.length-1)
	{	
	st.clickagain_sc4(contributor[i]);
	
}	
	}		 
	flag=true;
	driver.close();
	}catch(Exception e)
	{
	Extent.test_logger = Extent.extent_report .startTest("State of the Team _Scenario : 4");
	Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
	Extent.test_logger.log(LogStatus.INFO,e);
	 Extent.extent_report.endTest(Extent.test_logger);
	 flag=false;
	}
}
		

@Test(enabled=true,priority=22,dependsOnMethods= {"dormanproducts_stateoftheteam_Scenario4_Qa"})
public void dormanproducts_stateoftheteam_Scenario4_Stage() throws Exception {
	if(flag==true)
	{
		try {
	
WebDriver driver1 = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");
	LoginTest lgntst1 = PageFactory.initElements(driver1, LoginTest.class);
	lgntst1.login();
	
	
	DocumentTest dcmntst1 = PageFactory.initElements(driver1, DocumentTest.class);
	dcmntst1.document("stage");
	
	
	StateoftheTeam st2 = PageFactory.initElements(driver1, StateoftheTeam.class);
	StateoftheTeam_Scenario4 st3 = PageFactory.initElements(driver1, StateoftheTeam_Scenario4.class);
	
	st2.open_stateoftheteam("qa");
	
	st3.selectrolling2();
	String [] contributor= {"BRIAN_MURFY_X5547","chrisvan","HARRY_MOBLEY_X5393","JEFF_TRIPP_X5399","JEN_SCHROEDER_X5119"};
	
	Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);

	for(int i=0 ;i<contributor.length;i++)
	{
		
		int j=i+1;
		String name=contributor[i];
		st3.contributor(contributor[i]);

		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario4_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
	if(i<contributor.length-1)
	{
		
	
	st3.clickagain_sc4(contributor[i]);
	
}
	}
	
	driver1.close();
	
	String scenario4_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario4_Screenshots";
	
	String scenario4_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario4_Screenshots";
	
	ExtentLog e=new ExtentLog();
	String dashboaradname ="State Of the Team _Scenario : 4";
	
	String log="Input Data used : External Material Group : ALL ,Material Group Code : ALL , Contributor : ALL , Time Periods :";
	e.log(scenario4_qapath, scenario4_stagepath, 5, contributor,log,dashboaradname,4,"StateoftheTeam");
	
}
		
		catch(Exception e)
		{
			Extent.test_logger = Extent.extent_report .startTest("State of the Team _Scenario : 4");
			Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Stage Environment  ");
			Extent.test_logger.log(LogStatus.INFO ,e);
			 Extent.extent_report.endTest(Extent.test_logger);
			// flag=false;
		}
}
	
}
}
