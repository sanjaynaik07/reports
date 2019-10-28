package com.dorman.bitest.extentreport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Extent {
	
	public static ExtentReports extent_report = null;
	
	public static ExtentReports extent_report1 = null;
    public static ExtentTest test_logger = null;
    public static ExtentTest test_logger1 = null;
	
   @Parameters({ "suiteName" })
    @BeforeSuite
    public void extentSetup(String suiteName) {
                    ExtentReportsSetup(suiteName);
    }

    public void ExtentReportsSetup(String suiteName) {
                    System.out.println("In Extent Report Setup");
                    if(extent_report==null) {
                    	
                    	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
                    extent_report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport\\"+timestamp+".html");
                    
                    extent_report.loadConfig(new File(System.getProperty("user.dir")+"\\config\\extent-config.xml"));
                    }
    }

   @AfterSuite
    public void ExtentReportsClosure() {
    	
                    extent_report.flush();
                 //   extent_report.close();
                    
                    
    }
	
	
	
	
	
	/*public static ExtentReports report;	
	public static ExtentTest etest;	

@Test	
public static void setup()
{
	report=new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport.html");
	
	 report.loadConfig(new File(System.getProperty("user.dir")+"\\config\\extent-config.xml"));	
	
}
*/


}

