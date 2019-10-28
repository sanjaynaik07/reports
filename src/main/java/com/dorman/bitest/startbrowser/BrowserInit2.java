package com.dorman.bitest.startbrowser;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInit2 {


	public static WebDriver driver =null;

	
	
	public WebDriver initialize(String envURL) throws IOException, AWTException, InterruptedException{
		 try {
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		 }catch(Exception e)
		 {
			 System.out.println("chrome driver path is not correct");
		 }
		 
		 driver=new ChromeDriver();

		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		         
		   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		   driver.get(envURL);
		     
		/*   Thread.sleep(5000);
			 Robot r =new Robot();
			 
			 r.keyPress(KeyEvent.VK_TAB);
			 r.keyRelease(KeyEvent.VK_TAB);
			 
			 r.keyPress(KeyEvent.VK_TAB);
			 r.keyRelease(KeyEvent.VK_TAB);
			 
			 r.keyPress(KeyEvent.VK_TAB);
			 r.keyRelease(KeyEvent.VK_TAB);
			 
			 r.keyPress(KeyEvent.VK_DOWN);
			 
			 driver.get("http://boqaapp/BOE/BI");*/
			 
		return driver;
}
}