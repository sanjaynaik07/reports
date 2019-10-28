package com.dorman.image.tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Pattern;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.dorman.bitest.extentreport.Extent;
import com.dorman.bitest.startbrowser.BrowserInit;
import com.dorman.bitest.tests.DocumentTest;
import com.dorman.bitest.tests.LoginTest;
import com.dorman.flash.pages.GetFileNames;
import com.dorman.flash.pages.LatestImage;
import com.dorman.flash.pages.SalesMainDash;
import com.dorman.flash.pages.Screenshot;
import com.dorman.flash.pages.StateOftheTeam_Scenario2;
import com.dorman.flash.pages.StateoftheTeam;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.LogStatus;

import junit.extensions.TestSetup;

public class ImageTest extends Extent{
public BrowserInit binit = null;


String latestimage_Qa;

String latestimage_Stage;

	@BeforeClass
	public void InitilizeWDClassObject() {
		 
		
		binit = new BrowserInit();
	} 
	
	
	
	@Test(enabled=false,priority=1)
	
	public void dormanproducts_stateoftheteam_Scenario1() throws Exception {
		
	//	Extent.test_logger = Extent.extent_report
       //         .startTest("DashBoard - State Of the Team");
	
	try {	
	/*	
	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");

		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		
	//	Extent.test_logger.log(LogStatus.INFO, "Logged in to BOQA");
		
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
	dcmntst.document("qa");
	
	//Extent.test_logger.log(LogStatus.INFO, "clicked on documents, expanded public folders");
	
	Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class); 
	
		StateoftheTeam st = PageFactory.initElements(driver, StateoftheTeam.class);
		
		st.open_stateoftheteam("qa");
		
		st.selectrolling2();
	
		String [] extmtrgrp1= {"BDY1","CHS","ENG","INN","PKG","RMN","RTL","UND","VOID"};
//		String [] extmtrgrp1= {"BDY1"};
//		 System.out.println(scenario1_qapath+"\\"+qa_filename);
		for(int i=0 ;i<extmtrgrp1.length;i++)
		{
			
			int j=i+1;
			String name=extmtrgrp1[i];
			st.externalmaterialgroup(extmtrgrp1[i]);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario1_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+timestamp+".jpg");
			
			if(i<extmtrgrp1.length-1)
			{
				
			
			st.clickagain(extmtrgrp1[i]);
			
		}
		}*/
		
		
	
	//	Extent.test_logger.log(LogStatus.INFO, "opened state of the team dashboard,Selected the YTD as Rolling12 , "
	//			+ "External Material Group as BDY , Material Group code as ALL , Contributor as ALL  "); 
	
		  
	
			
		/*
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam"+File.separator+"screenshot_"+timestamp+".jpg");
		
		Extent.test_logger.log(LogStatus.INFO, "Took the screenshot  ");
		
		LatestImage	lm =new LatestImage();
		
		File latestfile_qa=lm.getTheNewestFile(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam", "jpg");
		
				System.out.println(latestfile_qa.getName());
				
				String s=latestfile_qa.getName();
				 latestimage_Qa=latestfile_qa.getAbsolutePath();
				 
				 Extent.test_logger.log(LogStatus.INFO, "<a href=file:./QA_Screenshots/StateoftheTeam/"+s+">QA Image link</a>");
				 */
	         
				 
		//		 driver.close();
	
	
	
		
		
		
		/*WebDriver driver1 = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");

		LoginTest lgntst1 = PageFactory.initElements(driver1, LoginTest.class);
		lgntst1.login();
//		Extent.test_logger.log(LogStatus.INFO, "Logged in to BOTEST");
		DocumentTest dcmntst1 = PageFactory.initElements(driver1, DocumentTest.class);
		dcmntst1.document("stage");
//		Extent.test_logger.log(LogStatus.INFO, "clicked on documents, expanded public folders");
		StateoftheTeam st1 = PageFactory.initElements(driver1, StateoftheTeam.class);
		
		Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);

		
			st1.open_stateoftheteam("stage");
			
			
			st1.selectrolling2();
			
	//		String [] extmtrgrp1= {"BDY1","CHS","ENG","INN","PKG","RMN","RTL","UND","VOID"};
			
			for(int i=0 ;i<extmtrgrp1.length;i++)
			{
				int j=i+1;
				String name=extmtrgrp1[i];
				st1.externalmaterialgroup(extmtrgrp1[i]);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario1_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+timestamp+".jpg");
				
				if(i<extmtrgrp1.length-1)
				{
					
				
				st1.clickagain(extmtrgrp1[i]);
				
			}
			}
			*/
			
			String scenario1_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario1_Screenshots";
			
			String scenario1_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario1_Screenshots";
			GetFileNames g=new GetFileNames();
			
			LatestImage	lm1 =new LatestImage();
			File[] qa=g.getnames(scenario1_qapath);
			ImageCompare it=new ImageCompare();
			 for(int i=0;i<qa.length;i++)
	           {
				 int j=i+1;
	        	   String qa_filename=qa[i].getName();
	        	   System.out.println(qa_filename);
	        	   File latestscreenshot_testcase_qa=lm1.getTheNewestFile(scenario1_qapath+"\\TestCase_"+j, "jpg");
	        	  String latestimage_qa=latestscreenshot_testcase_qa.getAbsolutePath();
	        	   File latestscreenshot_testcase_stage=lm1.getTheNewestFile(scenario1_stagepath+"\\TestCase_"+j, "jpg");
	        	   String latestimage_stage=latestscreenshot_testcase_stage.getAbsolutePath();
	        	   
	        	System.out.println(latestimage_qa);
	        	
	        	System.out.println(latestimage_stage);
	        	
	        	System.out.println("-------------------------------------");
	        	
	        	
	        
	        	   boolean result=it.ImgComp1(latestimage_qa ,
	        			   latestimage_stage,
							"C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\ImageComparisonResults\\StateoftheTeam\\Scenario1_Results\\TestCase_"+j+File.separator+"Result_screenshot_.jpg");
	        	   
	        	   System.out.println("compared " +j);
	           }
		/*	String scenario1_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario1_Screenshots";
			
			LatestImage	lm1 =new LatestImage();
			File latestfile_stage=lm1.getTheNewestFile(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam", "jpg");
		
			
              	File[] qa=g.getnames(scenario1_qapath);
	System.out.println(qa.length);
	           File[] stage=g.getnames(scenario1_stagepath);
	       	System.out.println(stage.length);           
	           ImageCompare it=new ImageCompare();
	           
	           
	           for(int i=0;i<=0;i++)
	           {
	        	   String qa_filename=qa[i].getName();
	        	   
	        	   String stage_filename=stage[i].getName();
	        	   
	        	   System.out.println(qa[i].getName());
	        	   
	        	   System.out.println(stage[i].getName());
	        	   
	        	   System.out.println(scenario1_qapath+"\\"+qa_filename);
	        	   
	        	   boolean result=it.ImgComp1(scenario1_qapath+"\\"+qa_filename ,
	        			   scenario1_stagepath+"\\"+stage_filename,
							"C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\ImageComparisonResults\\StateoftheTeam"+File.separator+"Result_screenshot_.jpg");
	           
	           }   
	          */
	
			
		/*	Extent.test_logger.log(LogStatus.INFO, "opened state of the team dashboard,Selected the YTD as Rolling12 , External Material Group as BDY , Material Group code as ALL , Contributor as ALL "); 
		
		
          String timestamp1 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam"+File.separator+"screenshot_"+timestamp1+".jpg");
		
		Extent.test_logger.log(LogStatus.INFO, "Took the screenshot  ");
		
		LatestImage	lm1 =new LatestImage();
		
		File latestfile_stage=lm1.getTheNewestFile(System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam", "jpg");
				System.out.println(latestfile_stage.getName());
				
				
				String s1=latestfile_stage.getName();
				 latestimage_Stage=latestfile_stage.getAbsolutePath();	
	
				 Extent.test_logger.log(LogStatus.INFO, "<a href=file:./Stage_Screenshots/StateoftheTeam/"+s1+">Stage Image link</a>");
				 
				 
				 
					ImageCompare it=new ImageCompare();
					String timestamp3 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			boolean result=		it.ImgComp1(latestimage_Qa ,
							latestimage_Stage,
							"C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\ImageComparisonResults\\StateoftheTeam"+File.separator+"Result_screenshot_"+timestamp3+".jpg");
					
					
					File latestfile_result=lm1.getTheNewestFile(System.getProperty("user.dir")+"\\ImageComparisonResults\\StateoftheTeam", "jpg");
					
					
					String s3=latestfile_result.getName();
					
					System.out.println(s3);
					 Extent.test_logger.log(LogStatus.INFO, "<a href=file:./ImageComparisonResults/StateoftheTeam/"+s3+">Result Image link</a>");
					 
					 if(result)
					 {
						 Extent.test_logger.log(LogStatus.PASS, "DashBoards  match");
					 }
					 else {
						 Extent.test_logger.log(LogStatus.FAIL, "DashBoards doesnt match");
					 }*/
					 
		//		 Extent.extent_report.endTest(Extent.test_logger);
				 
			 
				 
	}catch(Exception e) {
        e.printStackTrace();
        Extent.test_logger.log(LogStatus.FAIL, e.fillInStackTrace());
	}

	
	}
	

	@Test(enabled=true,priority=1)
	public void dormanproducts_stateoftheteam_Scenario2() throws Exception {
	
		
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
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
		driver.close();
		
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
//		String [] grpcode= {"0180","0186","01K7","01L5","01R3","01T1","0597","06162","0804","0317"};

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
		
		
		String scenario2_qapath=System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario2_Screenshots";
		
		String scenario2_stagepath=System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam\\Scenario2_Screenshots";
		GetFileNames g=new GetFileNames();
		
		LatestImage	lm1 =new LatestImage();
		File[] qa=g.getnames(scenario2_qapath);
		ImageCompare it=new ImageCompare();
		 for(int i=0;i<qa.length;i++)
           {
			 int j=i+1;
        	   String qa_filename=qa[i].getName();
        	   System.out.println(qa_filename);
        	   File latestscreenshot_testcase_qa=lm1.getTheNewestFile(scenario2_qapath+"\\TestCase_"+j, "jpg");
        	  String latestimage_qa=latestscreenshot_testcase_qa.getAbsolutePath();
        	   File latestscreenshot_testcase_stage=lm1.getTheNewestFile(scenario2_stagepath+"\\TestCase_"+j, "jpg");
        	   String latestimage_stage=latestscreenshot_testcase_stage.getAbsolutePath();
        	   
        	System.out.println(latestimage_qa);
        	
        	System.out.println(latestimage_stage);
        	
        	System.out.println("-------------------------------------");
        	
        	
        
        	   boolean result=it.ImgComp1(latestimage_qa ,
        			   latestimage_stage,
						"C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\ImageComparisonResults\\StateoftheTeam\\Scenario2_Results\\TestCase_"+j+File.separator+"Result_screenshot_.jpg");
        	   
        System.out.println("compared " +j);
           }
		
	}
	
	
	
	@Test(enabled=false,priority=1)
	public void dormanproducts_stateoftheteam_Scenario4() throws Exception {
	
		
		WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");

		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		
		
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");
		
		
StateoftheTeam st = PageFactory.initElements(driver, StateoftheTeam.class);
		
		st.open_stateoftheteam("qa");
		
	//	st.select_2018();
		//st.materialgroupcode();
/*		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
	st.selectrolling2();
	String [] contributor= {"BRIAN_MURFY_X5547","CHRIS_VAN_OSTEN_X5571","HARRY_MOBLEY_X5393","JEFF_TRIPP_X5399","JEN_SCHROEDER_X5119"};
//	String [] extmtrgrp1= {"BDY1"};
//	 System.out.println(scenario1_qapath+"\\"+qa_filename);
	for(int i=0 ;i<contributor.length;i++)
	{
		
		int j=i+1;
		String name=contributor[i];
		st.contributor(contributor[i]);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam\\Scenario4_Screenshots\\TestCase_"+j+File.separator+"screenshot_"+name+timestamp+".jpg");
		
		if(i<contributor.length-1)
		{
			
		
		st.clickagain_sc4(contributor[i]);
		
	}
	}
	*/
	}
	
@Test(enabled=false,priority=1)
	
	public void dormanproducts_stateoftheteam() throws Exception {
		
		Extent.test_logger = Extent.extent_report
                .startTest("DashBoard - State Of the Team");
	
	try {	
	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");

		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		
		Extent.test_logger.log(LogStatus.INFO, "Logged in to BOQA");
		
		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
	dcmntst.document("qa");
	
	Extent.test_logger.log(LogStatus.INFO, "clicked on documents, expanded public folders");
	
		StateoftheTeam st = PageFactory.initElements(driver, StateoftheTeam.class);
		
		st.open_stateoftheteam("qa");
		
		Extent.test_logger.log(LogStatus.INFO, "opened state of the team dashboard,Selected the YTD as Q4 , "
				+ "External Material Group as BDY , Material Group code as 0171  "); 
	
		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);   
	
			
		
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam"+File.separator+"screenshot_"+timestamp+".jpg");
		
		Extent.test_logger.log(LogStatus.INFO, "Took the screenshot  ");
		
		LatestImage	lm =new LatestImage();
		
		File latestfile_qa=lm.getTheNewestFile(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam", "jpg");
		
				System.out.println(latestfile_qa.getName());
				
				String s=latestfile_qa.getName();
				 latestimage_Qa=latestfile_qa.getAbsolutePath();
				 
				 Extent.test_logger.log(LogStatus.INFO, "<a href=file:./QA_Screenshots/StateoftheTeam/"+s+">QA Image link</a>");
				 
	         
				 
				 driver.close();
	
	
	
		
		
		
		WebDriver driver1 = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");

		LoginTest lgntst1 = PageFactory.initElements(driver1, LoginTest.class);
		lgntst1.login();
		Extent.test_logger.log(LogStatus.INFO, "Logged in to BOTEST");
		DocumentTest dcmntst1 = PageFactory.initElements(driver1, DocumentTest.class);
		dcmntst1.document("stage");
		Extent.test_logger.log(LogStatus.INFO, "clicked on documents, expanded public folders");
		StateoftheTeam st1 = PageFactory.initElements(driver1, StateoftheTeam.class);
		
		Screenshot	 sc1 = PageFactory.initElements(driver1, Screenshot.class);

		
			st1.open_stateoftheteam("stage");
			
			Extent.test_logger.log(LogStatus.INFO, "opened state of the team dashboard,Selected the YTD as Q4 , External Material Group as BDY , Material Group code as 0171  "); 
		
		
          String timestamp1 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		sc1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam"+File.separator+"screenshot_"+timestamp1+".jpg");
		
		Extent.test_logger.log(LogStatus.INFO, "Took the screenshot  ");
		
		LatestImage	lm1 =new LatestImage();
		
		File latestfile_stage=lm1.getTheNewestFile(System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam", "jpg");
				System.out.println(latestfile_stage.getName());
				
				
				String s1=latestfile_stage.getName();
				 latestimage_Stage=latestfile_stage.getAbsolutePath();	
	
				 Extent.test_logger.log(LogStatus.INFO, "<a href=file:./Stage_Screenshots/StateoftheTeam/"+s1+">Stage Image link</a>");
				 
				 
				 
					ImageCompare it=new ImageCompare();
					String timestamp3 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			boolean result=		it.ImgComp1(latestimage_Qa ,
							latestimage_Stage,
							"C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\ImageComparisonResults\\StateoftheTeam"+File.separator+"Result_screenshot_"+timestamp3+".jpg");
					
					
					File latestfile_result=lm1.getTheNewestFile(System.getProperty("user.dir")+"\\ImageComparisonResults\\StateoftheTeam", "jpg");
					
					
					String s3=latestfile_result.getName();
					
					System.out.println(s3);
					 Extent.test_logger.log(LogStatus.INFO, "<a href=file:./ImageComparisonResults/StateoftheTeam/"+s3+">Result Image link</a>");
					 
					 if(result)
					 {
						 Extent.test_logger.log(LogStatus.PASS, "DashBoards  match");
					 }
					 else {
						 Extent.test_logger.log(LogStatus.FAIL, "DashBoards doesnt match");
					 }
					 
				 Extent.extent_report.endTest(Extent.test_logger);
				 
				 
				 
	}catch(Exception e) {
        e.printStackTrace();
        Extent.test_logger.log(LogStatus.FAIL, e.fillInStackTrace());
	}
}
	
	

	
	@Test(enabled=false,priority=2)
	
	public void dormansales_salesmiandash() throws Exception {
		
		

		Extent.test_logger = Extent.extent_report
                .startTest("DashBoard - Sales Main Dash ");
	try {	
		
	WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");

		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();
		
		Extent.test_logger.log(LogStatus.INFO, "Logged in to BOQA");

		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");
		
		Extent.test_logger.log(LogStatus.INFO, "clicked on documents, expanded public folders");

	SalesMainDash sm = PageFactory.initElements(driver, SalesMainDash.class);
		
		
			sm.open_salesmaindash("qa");
			
			Extent.test_logger.log(LogStatus.INFO, "opened sales main dashboard,Selected the YTD as Q2 , Sales office as DIV Advance ,Distribution channel as ALL ,Contributor as ALL, Material Group as ALL,Price Group as ALL "); 
			
		Screenshot	 sc = PageFactory.initElements(driver, Screenshot.class);
		
		Extent.test_logger.log(LogStatus.INFO, "Took the screenshot  ");
		
          String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
	sc.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash"+File.separator+"screenshot_"+timestamp+".jpg");
       
	LatestImage	lm =new LatestImage();
File latestfile_qa=lm.getTheNewestFile(System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash", "jpg");
		System.out.println(latestfile_qa.getName());
		
		 latestimage_Qa=latestfile_qa.getAbsolutePath();
		 
		 String s=latestfile_qa.getName();
		 
		 Extent.test_logger.log(LogStatus.INFO, "<a href=file:./QA_Screenshots/SalesMainDash/"+s+">QA Image link</a>");
		 
		 driver.close();
		 
	
		WebDriver	 driver1 = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");	
		
		Extent.test_logger.log(LogStatus.INFO, "Logged in to BOTEST");
		
		LoginTest lgntst1 = PageFactory.initElements(driver1, LoginTest.class);
				lgntst1.login();
				Extent.test_logger.log(LogStatus.INFO, "Logged in to BOTEST");
				
				DocumentTest dcmntst1 = PageFactory.initElements(driver1, DocumentTest.class);
				dcmntst1.document("stage");
				
				Extent.test_logger.log(LogStatus.INFO, "clicked on documents, expanded public folders");
				SalesMainDash sm1 = PageFactory.initElements(driver1, SalesMainDash.class);	
				
				sm1.open_salesmaindash("stage");
				Extent.test_logger.log(LogStatus.INFO, "opened sales main dashboard,Selected the YTD as Q2 , Sales office as DIV Advance ,Distribution channel as ALL ,Contributor as ALL, Material Group as ALL,Price Group as ALL "); 
				Screenshot sc1 = PageFactory.initElements(driver1, Screenshot.class);
		          String timestamp1 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				
				sc1.takescreenshot(System.getProperty("user.dir")+"\\c\\SalesMainDash"+File.separator+"screenshot_"+timestamp1+".jpg");
				
				Extent.test_logger.log(LogStatus.INFO, "Took the screenshot  ");
				LatestImage	lm1 =new LatestImage();
				File latestfile_stage=lm1.getTheNewestFile(System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash", "jpg");
						System.out.println(latestfile_stage.getName());
						
						 latestimage_Stage=latestfile_stage.getAbsolutePath();		
						 String s1=latestfile_stage.getName();
						 
						 Extent.test_logger.log(LogStatus.INFO, "<a href=file:./Stage_Screenshots/SalesMainDash/"+s1+">Stage Image link</a>");
						 
							String timestamp3 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
							ImageCompare it=new ImageCompare();
							boolean result=		it.ImgComp1(latestimage_Qa ,
											latestimage_Stage,
											"C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\ImageComparisonResults\\SalesMainDash"+File.separator+"Result_screenshot_"+timestamp3+".jpg");
									
									
									File latestfile_result=lm1.getTheNewestFile(System.getProperty("user.dir")+"\\ImageComparisonResults\\SalesMainDash", "jpg");
									
									
									String s3=latestfile_result.getName();
									
									System.out.println(s3);
									 Extent.test_logger.log(LogStatus.INFO, "<a href=file:./ImageComparisonResults/SalesMainDash/"+s3+">Result Image link</a>");
									 
									 if(result)
									 {
										 Extent.test_logger.log(LogStatus.PASS, "DashBoards  match");
									 }
									 else {
										 Extent.test_logger.log(LogStatus.FAIL, "DashBoards doesnt match");
									 }
									 
								 Extent.extent_report.endTest(Extent.test_logger);
								 
						 
						 
						 
	}catch(Exception e) {
        e.printStackTrace();
        Extent.test_logger.log(LogStatus.FAIL, e.fillInStackTrace());
	}					 
}
	
	
	@AfterMethod(enabled=false)
		public void image_compare() throws Exception {
			 
			ImageCompare it=new ImageCompare();
			System.out.println(latestimage_Qa);
			  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
			  
		//	  C:\Users\sdhanavath\eclipse-workspace\Practic2\reports\QA_Screenshots\StateoftheTeam\screenshot_2019_02_22__03_54_06.jpg
			String dash[]=latestimage_Qa.replace("\\", "#").split("#");
			System.out.println(dash[dash.length-2]);
			
			  
			it.ImgComp1(latestimage_Qa ,
					latestimage_Stage,
					"C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\ImageComparisonResults\\"+dash[dash.length-2]+File.separator+"Result_screenshot_"+timestamp+".jpg");
			
}
		
}

