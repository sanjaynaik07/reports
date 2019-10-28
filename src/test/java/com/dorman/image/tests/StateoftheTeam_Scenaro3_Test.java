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
import com.dorman.flash.pages.StateOftheTeam_Scenario3;
import com.dorman.flash.pages.StateoftheTeam;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.LogStatus;

public class StateoftheTeam_Scenaro3_Test {
	
	Boolean flag=false;
	public BrowserInit binit = null;
	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	

	@Test(enabled=true,priority=19)

	public void dormanproducts_stateoftheteam_Scenario3() throws Exception {
		try {
	//	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboprod","http://boprod/BOE/BI");
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		
		
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");
		
		
		StateoftheTeam st1 = PageFactory.initElements(driver, StateoftheTeam.class);
		StateOftheTeam_Scenario3 st = PageFactory.initElements(driver, StateOftheTeam_Scenario3.class);
		
		st1.open_stateoftheteam("qa");
	
		st.clcikytd();
		
		
		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
	//	String [] month= {"M01","M02","M03","M04","M05","M06","M07","M08","M09","M10","M11","M12"};
		String [] month= {"M01","M02"};
		for(int i=0 ;i<month.length;i++)
		{
			
			int j=i+1;
			String name=month[i];
			st.selectmonth(month[i]);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario3_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
	
		LatestImage	lm =new LatestImage();
		
		File latestfile_qa=lm.getTheNewestFile(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario3_Screenshots\\TestCase_"+j, "jpg");
		

		System.out.println(latestfile_qa.getName());
		
		String s=latestfile_qa.getName();
	
		
			if(i<month.length-1)
			{
				
			
			st.clickagain_sc3(month[i]);
			
		}
		}
		flag=true;
		driver.close();	
		}catch(Exception e)
		{
		Extent.test_logger = Extent.extent_report .startTest("State of the Team _Scenario : 3");
		Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Qa Environment");
		Extent.test_logger.log(LogStatus.INFO,e);
		 Extent.extent_report.endTest(Extent.test_logger);
		 flag=false;
		}	 
	}
	
			
	
	@Test(enabled=true,priority=20,dependsOnMethods= {"dormanproducts_stateoftheteam_Scenario3"})
	public void dormanproducts_stateoftheteam_Scenario3_Stage() throws Exception {
		if(flag==true)
		{
			try {
	WebDriver driver1 = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");
		LoginTest lgntst1 = PageFactory.initElements(driver1, LoginTest.class);
		lgntst1.login();
		
		
		DocumentTest dcmntst1 = PageFactory.initElements(driver1, DocumentTest.class);
		dcmntst1.document("stage");
		
		
		StateoftheTeam st2 = PageFactory.initElements(driver1, StateoftheTeam.class);
		StateOftheTeam_Scenario3 st3 = PageFactory.initElements(driver1, StateOftheTeam_Scenario3.class);
		
		st2.open_stateoftheteam("qa");
		
		st3.clcikytd();
		
		
		Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);
		String [] month= {"M01","M02","M03","M04","M05","M06","M07","M08","M09","M10","M11","M12"};

		for(int i=0 ;i<month.length;i++)
		{
			
			int j=i+1;
			String name=month[i];
			st3.selectmonth(month[i]);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario3_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+"_"+timestamp+".jpg");
			
			if(i<month.length-1)
			{
				
			
			st3.clickagain_sc3(month[i]);
			
		}
			
		}
		
		driver1.close();

		String scenario3_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario3_Screenshots";
		
		String scenario3_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario3_Screenshots";
	
		ExtentLog e=new ExtentLog();
		String dashboaradname ="State Of the Team _Scenario : 3";

		String log= "Input Data used : External Material Group : ALL ,Material Group Code : ALL , Contributor : ALL , Time Periods :";
		e.log(scenario3_qapath, scenario3_stagepath, 12, month,log,dashboaradname,3,"StateoftheTeam");
		
	}
			catch(Exception e)
			{
				Extent.test_logger = Extent.extent_report .startTest("State of the Team _Scenario : 3");
				Extent.test_logger.log(LogStatus.FAIL, "Could not execute this scenario due to the exception in Stage Environment  ");
				Extent.test_logger.log(LogStatus.INFO ,e);
				 Extent.extent_report.endTest(Extent.test_logger);
				// flag=false;
			}

	
		}
}
}
