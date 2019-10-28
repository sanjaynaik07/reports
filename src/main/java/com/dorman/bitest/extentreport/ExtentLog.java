package com.dorman.bitest.extentreport;

import java.io.File;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dorman.flash.pages.LatestImage;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentLog {

	
	public void log(String qapath , String Stagepath ,int testcasecount,String array[],String log,String Scenario, int scenario,String Dashboard) throws Exception
	{
		Extent.test_logger = Extent.extent_report .startTest(Scenario);
		
		String qapath1=qapath;
		String []array1=array;
		String stagepath1=Stagepath;
		LatestImage	lm1 =new LatestImage();
		ImageCompare it=new ImageCompare();
		
		 for(int i=0;i<testcasecount;i++)
	       {
			 int j=i+1;
			 
			 Extent.test_logger1 = Extent.extent_report .startTest("Test case :"+ j);
			 Extent.test_logger1.log(LogStatus.INFO,log +""+array1[i]);
			 File latestscreenshot_testcase_qa=lm1.getTheNewestFile(qapath1+"\\TestCase_"+j, "jpg");
	    	  String latestimage_qa=latestscreenshot_testcase_qa.getAbsolutePath();
	    	   File latestscreenshot_testcase_stage=lm1.getTheNewestFile(stagepath1+"\\TestCase_"+j, "jpg");
	    	   
	    	   String latestimage_stage=latestscreenshot_testcase_stage.getAbsolutePath();
	    	   
	    	   Extent.test_logger1.log(LogStatus.INFO, "<a href=file:"+latestscreenshot_testcase_qa+">QA ScreenShot Link</a>");
	    	   
	      	 Extent.test_logger1.log(LogStatus.INFO, "<a href=file:"+latestscreenshot_testcase_stage+">Stage ScreenShot Link</a>");
	      	 
	      	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	    	   boolean result=it.ImgComp1(latestimage_qa ,
	    			   latestimage_stage,
	    			   System.getProperty("user.dir")+"\\ImageComparisonResults\\"+Dashboard+"\\Scenario"+scenario+"_Results\\TestCase_"+j+File.separator+"Result_screenshot_"+timestamp+".jpg");
	    	   
	    	   File latestfile_result=lm1.getTheNewestFile(System.getProperty("user.dir")+"\\ImageComparisonResults\\"+Dashboard+"\\Scenario"+scenario+"_Results\\TestCase_"+j,"jpg");
				
				
				String s3=latestfile_result.getAbsolutePath();
				
				System.out.println(s3);
				 Extent.test_logger1.log(LogStatus.INFO, "<a href=file:"+s3+">Result Image link</a>");
	    	   if(result)
				 {
					 Extent.test_logger1.log(LogStatus.PASS, "DashBoards  match");
				 }
				 else {
					 Extent.test_logger1.log(LogStatus.FAIL, "DashBoards doesnt match");
				 }
	    	   
	    	   
	    	   Extent.extent_report.endTest(Extent.test_logger1);
			
	    	   Extent.test_logger.appendChild(Extent.test_logger1);
	    	   
	    	 
	    	   
	    System.out.println("compared " +j);
	       }
		 Extent.extent_report.endTest(Extent.test_logger);
		// Extent.extent_report.endTest(Extent.test_logger1);
		}
	       
	}

