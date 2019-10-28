package com.dorman.bitest.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dorman.bitest.comparator.ExcelComparator;

import com.dorman.bitest.pages.DSC_MDM_Page;
import com.dorman.bitest.pages.DormanSharedCorporatePage;
import com.dorman.bitest.pages.SavedReports;
import com.dorman.bitest.startbrowser.BrowserInit;
import com.dorman.bitest.startbrowser.BrowserInit2;
import com.dorman.flash.pages.SalesMainDash;
import com.dorman.flash.pages.Screenshot;
import com.dorman.flash.pages.StateoftheTeam;
import com.dorman.image.comparison.ImageCompare;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DormanSharedCorporateTest {

	public BrowserInit binit = null;
	public BrowserInit2 binit2 = null;
//	public BrowserInit2 binit2 = null;
	/*
	public static ExtentReports report;	
	public static ExtentTest etest;*/	
	
	@BeforeSuite
	public void InitilizeWDClassObject() {
		binit = new BrowserInit();
		binit2 = new BrowserInit2();
	} 
	
	/*@BeforeSuite
	public void InitilizeWDClassObjec2t() {
		System.out.println("browser2 init");
		binit2 = new BrowserInit2();*/
	

	@Test(enabled=false,priority=1)
	public void excelinit() throws EncryptedDocumentException, IOException {
		
		
		String datapath ="C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\src\\main\\java\\TestData\\Testdata.xlsx";
           
           FileInputStream f1= new FileInputStream(datapath);
           
           XSSFWorkbook wb1=new XSSFWorkbook(f1);
           XSSFSheet sh1=wb1.getSheetAt(0);
           XSSFRow row=sh1.getRow(0);
        		   
           int columncount =row.getLastCellNum();
           
           int rowcount =sh1.getLastRowNum();
           System.out.println("columncount" +columncount );
           
           System.out.println("rowcount" +rowcount);
           
           for(int i=0 ;i<rowcount;i++)
           {
        	   for(int j=i;j<columncount;j++)
        	   {
        		   String data=sh1.getRow(i).getCell(2).getStringCellValue();
        		   //getStringCellValue()
        		   System.out.println(data);
        	   }
        	   
        	   
           }
           
           
	}
    
	
	@Test(enabled=true)
	public void dormansharedcorporate_POS_Basic_Key_Account_QA() throws Exception {
		/*WebDriver driver = binit.initialize("http://boqa/BOE/BI",System.getProperty("user.dir")+"\\QA_Reports");
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();

		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");

		DormanSharedCorporatePage dscp = PageFactory.initElements(driver, DormanSharedCorporatePage.class);
		try {
			//DormanProduct  |RID_011_Core_Bank
			//dscp.openpos("DormanSharedCorporate,POS,POS Report");
			
			//dscp.openpos("DormanProduct,Portal Data,All Project Summary");
			dscp.openpos("DormanProduct,Product Team Shared Reports,Market Intelligence,Automated_Reports,DormanInventory");*/
			
			ExcelComparator e = new ExcelComparator();
			e.excelcompare("D:\\Dorman_BI\\07162019\\Material_Details_Stage.xls","D:\\Dorman_BI\\07162019\\Material_Details_Prod2.xls","D:\\Dorman_BI\\07162019\\ExcelResult.xlsx");
	/*		
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block	
			System.out.println();
		}catch(Exception e1)
		{
			
		}*/
	}

	@Test(enabled=false)
	public void dormansharedcorporate_supplychain_tool_Team_Summary_QA() throws Exception {
		WebDriver driver = binit.initialize("http://boqa/BOE/BI","C:\\Users\\sdhanavath\\Desktop\\Dorman_Reports\\QA");
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();

		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("qa");

		DormanSharedCorporatePage dscp = PageFactory.initElements(driver, DormanSharedCorporatePage.class);

		try {
			dscp.supplychain("qa");
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}

	@Test(enabled=false)
	public void dormansharedcorporate_POS_Basic_Key_Account_Stage() throws Exception {
		WebDriver driver = binit.initialize("http://botest/BOE/BI","C:\\Users\\sdhanavath\\Desktop\\Dorman_Reports\\Stage");
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();

		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("stage");

		DormanSharedCorporatePage dscp = PageFactory.initElements(driver, DormanSharedCorporatePage.class);
		try {
			dscp.openpos("stage");
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}

	@Test(enabled=false)
	public void dormansharedcorporate_supplychain__tool_Team_Summary_Stage() throws Exception {
		WebDriver driver = binit.initialize("http://botest/BOE/BI","C:\\Users\\sdhanavath\\Desktop\\Dorman_Reports\\Stage");
		LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
		lgntst.login();

		DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
		dcmntst.document("stage");

		DormanSharedCorporatePage dscp = PageFactory.initElements(driver, DormanSharedCorporatePage.class);

		try {
			dscp.supplychain("stage");
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}		
		@Test(enabled=false)
		public void dormansharedcorporate_MDM__basicinfo_RID_126_Qa() throws Exception {
			WebDriver driver = binit.initialize("http://boqa/BOE/BI","C:\\Users\\sdhanavath\\Desktop\\Dorman_Reports\\QA");
			LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
			lgntst.login();

			DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
			dcmntst.document("qa");

			DSC_MDM_Page dscp = PageFactory.initElements(driver, DSC_MDM_Page.class);

			try {
				dscp.open_Basic_Part_InfoRID_126("qa");
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}	
			
		@Test(enabled=false)
		public void dormansharedcorporate_MDM__basicinfo_RID_126_stage() throws Exception {
			WebDriver driver = binit.initialize("http://botest/BOE/BI","C:\\Users\\sdhanavath\\Desktop\\Dorman_Reports\\Stage");
			LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
			lgntst.login();

			DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
			dcmntst.document("stage");

			DSC_MDM_Page dscp = PageFactory.initElements(driver, DSC_MDM_Page.class);

			try {
				dscp.open_Basic_Part_InfoRID_126("stage");
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}	
			
			@Test(enabled=false,priority=1)
			public void dormansharedcorporate_MDM_NP$_Sales_RID_124_Qa() throws Exception {
				
				
				
				WebDriver driver = binit.initialize("http://boqa/BOE/BI",System.getProperty("user.dir")+"\\QA_Reports");
				LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
				lgntst.login();

				DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
				dcmntst.document("qa");

				DSC_MDM_Page dscp = PageFactory.initElements(driver, DSC_MDM_Page.class);

				try {
					dscp.open_NP$_Sales_RID_124("qa");
				} catch(Exception e1)
				{
					e1.printStackTrace();
				}
	}
			
			@Test(enabled=false,priority=2)
			public void dormansharedcorporate_MDM_NP$_Sales_RID_124_Stage() throws Exception {
				WebDriver driver = binit.initialize("http://botest/BOE/BI",System.getProperty("user.dir")+"\\Stage_Reports");
				LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
				lgntst.login();

				DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
				dcmntst.document("stage");

				DSC_MDM_Page dscp = PageFactory.initElements(driver, DSC_MDM_Page.class);

				try {
					dscp.open_NP$_Sales_RID_124("stage");
				} catch(Exception e1)
				{
					e1.printStackTrace();
				}
	}
			
			
			@Test(enabled=false)
			public void dormansharedcorporate_SupplyChain_InventoryAccess() throws Exception {
				WebDriver driver = binit.initialize("http://boqa/BOE/BI",System.getProperty("user.dir")+"\\QA_Reports");
				LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
				lgntst.login();

				DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
				dcmntst.document("qa");

				DormanSharedCorporatePage dscp = PageFactory.initElements(driver, DormanSharedCorporatePage.class);

				try {
					dscp.supplychain_InventoyExcessActualsBaseLine("qa");
				} catch(Exception e1)
				{
					e1.printStackTrace();
				}
	}
			
			@Test(enabled=false,priority=1)
			public void dormanproducts_stateoftheteam_qa() throws Exception {
				
			WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
	
				LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
				lgntst.login();

				DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
			dcmntst.document("qa");

				StateoftheTeam s = PageFactory.initElements(driver, StateoftheTeam.class);
				Screenshot s1 = PageFactory.initElements(driver, Screenshot.class);   
				try {
					s.open_stateoftheteam("qa");
				} catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				
				s1.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\StateoftheTeam"+File.separator+"screenshot_"+timestamp+".png");

				
	}
			
			
			
			@Test(enabled=false,priority=2)
			public void dormanproducts_stateoftheteam_stage() throws Exception {
				
			WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");
	
				LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
				lgntst.login();

				DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
				dcmntst.document("stage");

				StateoftheTeam s = PageFactory.initElements(driver, StateoftheTeam.class);
				
				Screenshot s1 = PageFactory.initElements(driver, Screenshot.class);

				try {
					s.open_stateoftheteam("stage");
				} catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
                  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				
				s1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\StateoftheTeam"+File.separator+"screenshot_"+timestamp+".png");

				
	}
		
			
			@Test(enabled=false,priority=1)
			public void dormansales_saesmiandash_qa() throws Exception {
				
			WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp","http://boqaapp/BOE/BI");
	
				LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
				lgntst.login();
/*
				DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
				dcmntst.document("qa");

				SalesMainDash s = PageFactory.initElements(driver, SalesMainDash.class);
				Screenshot s1 = PageFactory.initElements(driver, Screenshot.class);
				try {
					s.open_salesmaindash("qa");
				} catch(Exception e1)
				{
					e1.printStackTrace();
				}*/
				Screenshot s1 = PageFactory.initElements(driver, Screenshot.class);
                  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				
				s1.takescreenshot(System.getProperty("user.dir")+"\\QA_Screenshots\\SalesMainDash"+File.separator+"screenshot_"+timestamp+".jpg");

				
	}
			
			

			@Test(enabled=false,priority=1)
			public void dormansales_saesmiandash_stage() throws Exception {
				
			WebDriver driver = binit.initialize("chrome://settings/content/siteDetails?site=http%3A%2F%2Fbotestapp","http://botestapp/BOE/BI");
	
				LoginTest lgntst = PageFactory.initElements(driver, LoginTest.class);
				lgntst.login();

				DocumentTest dcmntst = PageFactory.initElements(driver, DocumentTest.class);
				dcmntst.document("stage");

				SalesMainDash s = PageFactory.initElements(driver, SalesMainDash.class);
				
				Screenshot s1 = PageFactory.initElements(driver, Screenshot.class);

				try {
					s.open_salesmaindash("stage");
				} catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
                  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				
				s1.takescreenshot(System.getProperty("user.dir")+"\\Stage_Screenshots\\SalesMainDash"+File.separator+"screenshot_"+timestamp+".png");

				
	}
			
			
			@Test(enabled=false)
			public void BillToCustomerCredit() throws Exception {
				
				WebDriver driver2 = binit2.initialize("http://boqa/BOE/BI");
				
				LoginTest lgntst = PageFactory.initElements(driver2, LoginTest.class);
				lgntst.login();

				/*DocumentTest dcmntst = PageFactory.initElements(driver2, DocumentTest.class);
				dcmntst.document("qa");*/
		
				SavedReports s = PageFactory.initElements(driver2, SavedReports.class);	
		
		s.opensavedreport();
		
		
	}
			
			
			@Test(enabled=false,priority=1)
			public void image_compare() throws Exception {
				 
				ImageCompare it=new ImageCompare();
				  String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
				it.ImgComp1("C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\QA_Screenshots\\SalesMainDash\\screenshot_2019_02_21__03_44_15.jpg", 
						"C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\Stage_Screenshots\\SalesMainDash\\screenshot_2019_02_21__03_18_42.jpg",
						"C:\\Users\\sdhanavath\\eclipse-workspace\\Practic2\\reports\\ImageComparisonResults\\SalesMainDash"+File.separator+"screenshot_"+timestamp+".jpg");
				
	}
			
		@Test(enabled=false)
public void Compare() throws Exception {
		/*				File Qa_folder = new File(System.getProperty("user.dir")+"\\QA_Reports\\");
			File[] QA_listOfFiles = Qa_folder.listFiles();	
		
		for(int i=0;i<QA_listOfFiles.length;i++)
		{
			
			  long  filesize1;
			  long  filesize2;
			  do {
				  filesize1 = QA_listOfFiles[i].length();  
				   Thread.sleep(5000);   
				   System.out.println("waiting for "+ QA_listOfFiles[i].getName() +" to get downloaded");
				  filesize2 = QA_listOfFiles[i].length() ;
			  }while (filesize1 != filesize2); 
			  
			  System.out.println("File "+ QA_listOfFiles[i].getName() +"downloaded");  
		}
		
		
		File Stage_folder = new File(System.getProperty("user.dir")+"\\Stage_Reports\\");
		File[] Stage_listOfFiles = Stage_folder.listFiles();
		System.out.println("QA_listOfFiles.length  :" +QA_listOfFiles.length + "  Stage_listOfFiles : "  +Stage_listOfFiles.length);
		
		
		while(QA_listOfFiles.length!=Stage_listOfFiles.length)
		{
			Stage_listOfFiles=Stage_folder.listFiles();
			System.out.println("waiting for the file to start dowloading.. " );
			Thread.sleep(15000);
		}
		for(int i=0;i<Stage_listOfFiles.length;i++)
		{
			  System.out.println("File " + Stage_listOfFiles[i].getName());	  
			  
			  long  filesize1;
			  long  filesize2;
			  do {
				  filesize1 = Stage_listOfFiles[i].length();  
				   Thread.sleep(10000);
				   
				   System.out.println("waiting for "+ Stage_listOfFiles[i].getName() +" to get downloaded");
				  filesize2 = Stage_listOfFiles[i].length();
			  }while (filesize1 != filesize2); 
			  System.out.println("File "+ Stage_listOfFiles[i].getName() +"downloaded");
		}
		*/
		ExcelComparator e=new ExcelComparator();
				
			//	e.extnentreport();
				
	//	e.excelcompare(System.getProperty("user.dir")+"\\QA_Reports\\NP$_Sales_RID_124_qa_new.xlsx", System.getProperty("user.dir")+"\\Stage_Reports\\NP$_Sales_RID_124_Stage_new.xlsx",   System.getProperty("user.dir")+"\\Comparison_Reports\\NP$_Sales_RID_124.xlsx",0);
			
		//	e.flush();
				
	}
		
		
		
}
