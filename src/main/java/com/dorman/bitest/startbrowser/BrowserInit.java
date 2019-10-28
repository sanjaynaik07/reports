package com.dorman.bitest.startbrowser;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;


public class BrowserInit {
	
	
	public static WebDriver driver =null;

	public static boolean count;

	@SuppressWarnings("deprecation")
	public WebDriver initialize(String settingsurl,String evnurl) throws Exception{
		 try {



/*File file = new File("C://Users//sdhanavath//Desktop//chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");*/
			 
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\sdhanavath\\Downloads\\chromedriver.exe");		 
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sdhanavath\\Desktop\\chrome\\chromedriver.exe");

		 }catch(Exception e)
		 {
			 System.out.println("chrome driver path is not correct");
		 }
	//	 String downloadFilepath = Path;
		 
		 ChromeOptions options=new ChromeOptions();
		 
//		 options.addArguments("user-data-dir=C:\\Users\\sdhanavath\\AppData\\Local\\Google\\Chrome\\User Data");
		// options.addArguments("--disable-features=EnableEphemeralFlashPermission");
//		 HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		 
	//	 chromePrefs.put("profile.default_content_settings.popups", 0);
	//	 chromePrefs.put("download.default_directory", downloadFilepath);
		 
		// chromePrefs.put("profile.content_settings.exceptions.plugins.*,*.setting", 1);
		 /*chromePrefs.put("profile.default_content_setting_values.plugins", 1);
		 chromePrefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
		 chromePrefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);*/
		 
	//	 options.addArguments("--disable-features=EnableEphemeralFlashPermission");
		 
		/* chromePrefs.put("profile.default_content_setting_values.plugins", 1);
		 chromePrefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);*/
		// chromePrefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
		 
	//	 chromePrefs.put("profile.content_settings.exceptions.plugins.*,*.setting", 1);
		 /*chromePrefs.put("RunAllFlashInAllowMode",true);
		 chromePrefs.put("profile.default_content_settings.state.flash", 1);
		 chromePrefs.put("profile.plugins.flashBlock.enabled", 0);
		 chromePrefs.put("DefaultPluginsSetting", 1);
		 
		 chromePrefs.put("AllowOutdatedPlugins", 1);
		 	
		 
		 chromePrefs.put("PluginsAllowedForUrls", "http://boqaapp/BOE/BI");*/
		 
	//	 options.setExperimentalOption("prefs", chromePrefs);
 DesiredCapabilities cap = DesiredCapabilities.chrome();
	
	/*	 cap.setCapability(ChromeOptions.CAPABILITY, options);
		 cap.setBrowserName("chrome");
		 cap.setPlatform(Platform.VISTA);*/
		 
	//	 driver=new RemoteWebDriver(new URL("http://192.168.2.245:5566/wd/hub"),cap);
		 
	//	driver.get("http://boqaapp/BOE/BI");
	
		  driver = new ChromeDriver(cap); 
	
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		         
		   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		   driver.get(settingsurl);
		   System.out.println("blast padthada");
		   
		   //Thread.sleep(5000);
		   Robot r =new Robot();
			 
		   for(int i=0; i<=21;i++)
		   {
			 r.keyPress(KeyEvent.VK_TAB);
			 r.keyRelease(KeyEvent.VK_TAB);
			 System.out.println("blast padthada");
		   }
			/* 
			 
			 r.keyPress(KeyEvent.VK_TAB);
			 r.keyRelease(KeyEvent.VK_TAB);
			 
			 r.keyPress(KeyEvent.VK_TAB);
			 r.keyRelease(KeyEvent.VK_TAB);*/
			 
			 r.keyPress(KeyEvent.VK_DOWN);
			 
			 driver.navigate().refresh();
			 Thread.sleep(3000);
		
			 driver.get(evnurl);
		  
		 return driver;
		 
		 
		 }
	
	
	
	/*@AfterSuite
	 public void TeardownTest()
	    {
		BrowserInit.driver.quit();
	    }
	 
	 */

		}

