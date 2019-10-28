package com.dorman.bitest.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class settings {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");	
		 
		 WebDriver driver =new ChromeDriver();
		 
		 driver.get("chrome://settings/content/siteDetails?site=http%3A%2F%2Fboqaapp");
		 
		 Thread.sleep(5000);
		 Robot r =new Robot();
		 
		 r.keyPress(KeyEvent.VK_TAB);
		 r.keyRelease(KeyEvent.VK_TAB);
		 
		 r.keyPress(KeyEvent.VK_TAB);
		 r.keyRelease(KeyEvent.VK_TAB);
		 
		 r.keyPress(KeyEvent.VK_TAB);
		 r.keyRelease(KeyEvent.VK_TAB);
		 
		 r.keyPress(KeyEvent.VK_DOWN);
		 
		 driver.get("http://boqaapp/BOE/BI");
		 
		 
		 
		 
		
		 
		
	}

}
