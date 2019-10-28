package com.dorman.bitest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SavedReports {

	
	WebDriver driver;

	public SavedReports(WebDriver driver)

	{
		this.driver = driver;
	}
	
	
	@FindBy(xpath = "//a[@title='Documents']")
	WebElement documentlink;
	@FindBy(xpath = "//*[@id='BtnCImg_CD_OKBtn']")
	WebElement okbutton;
	@FindBy(xpath = "//*[@id='IconImg_iconMenu_icon__dhtmlLib_274']")
	WebElement refresh;
	
	//*[@id='IconImg_iconMenu_icon__dhtmlLib_274']
	@FindBy(xpath = "//div[contains(text(),'BillToCustomerCredit_18_02_2019') and @id='ListingURE_detailView_listColumn_1_0_1']")
	WebElement BilltoCustomer;
	

	@FindBy(xpath = "(//table[@title='Click here to access options'])[3]")
	WebElement optionsdropdown;
	
	
	public void opensavedreport( )
	{
		Actions a = new Actions(driver);
		a.moveToElement(documentlink).click().build().perform();
		// documentlink.click();
		System.out.println(" clicked on document link");
		
		List<WebElement> iframes1 = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes1.size());
		
		driver.switchTo().frame(5);
		a.moveToElement(BilltoCustomer).doubleClick().build().perform();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("servletBridgeIframe");
		List<WebElement> iframes2 = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes2.size());
		
		driver.switchTo().frame(6);
		
		driver.switchTo().frame(0);
	
		refresh.click();
		
		
		okbutton.click();
		
		driver.switchTo().parentFrame();
		
		/*driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("servletBridgeIframe");
		
		List<WebElement> iframes3 = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes3.size());
		driver.switchTo().frame(7);*/
		optionsdropdown.click();
		
		
	}
}
