package com.dorman.bitest.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;

public class DSC_MDM_Page {
	WebDriver driver;
    public DSC_MDM_Page(WebDriver driver)
    { 
   	 this.driver=driver;
    }
    
    
    @FindBy(xpath="//span[contains(text(),'MDM')]")
	 WebElement MDM;
    
    @FindBy(xpath="//div[contains(text(),'Basic Part Info – RID_126')]")
	 WebElement Basic_Part_InfoRID_126;
    
    @FindBy(xpath="//*[@id='Btn_OK_BTN_promptsDlg']")
	 WebElement OKBtn;
    
    @FindBy(xpath="(//table[@title='Click here to access options'])[3]")
	 WebElement optionsdropdown;
    
    @FindBy(xpath="//td[@id='iconMenu_menu__dhtmlLib_257_text__menuAutoId_12' and @class='menuTextPart']")
	 WebElement exportdocas;
    @FindBy(xpath="//*[@id='_dhtmlLib_262_span_text__menuAutoId_14']")
	 WebElement xlsx;
    @FindBy(xpath="//iframe[@id='webiViewFrame']")
	 WebElement webiViewFrame;
  //iframe[@id='webiViewFrame']
    
    @FindBy(xpath="//div[contains(text(),'NP$ Sales RID_124')]")
	 WebElement NP$_Sales_RID_124;
    
    public void open_Basic_Part_InfoRID_126(String s) throws Exception
	 { 
    	
    	
    	MDM.click();
    	 Actions a = new Actions(driver);
		 Thread.sleep(2000);
   
    	a.moveToElement(Basic_Part_InfoRID_126).doubleClick().build().perform();
    	
    	System.out.println("opned the Basic_Part_InfoRID_126 document ");
    	driver.switchTo().parentFrame();
		
		 driver.switchTo().defaultContent();
		 System.out.println("switched to default ");
		 driver.switchTo().frame("servletBridgeIframe");
		 System.out.println("switched to servletBridgeIframe ");
		 
		 List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
			System.out.println(iframes.size());
			int f=iframes.size()-1;
			
			 for (WebElement iframe : iframes) {
				
				 System.out.println("Frame Id :" + iframe.getAttribute("id"));
				 System.out.println("Frame Name :" + iframe.getAttribute("name"));
		 
			 }
		 

			 driver.switchTo().frame(f);
			 
			 System.out.println("switched to last frame in main frame ");
		 driver.switchTo().frame("webiViewFrame");
		 System.out.println("switched to webiViewFrame ");
		     	
	    	
	    	Thread.sleep(8000);
	    	
	    	OKBtn.click();
	    	System.out.println("clicked on ok");
	    /*	WebDriverWait w1 =new WebDriverWait(driver,1300);
        w1.until(ExpectedConditions.elementToBeClickable(optionsdropdown));*/
    	
	    	
	    	Thread.sleep(17 *   
	                60 *   
	                1000); 
	    	
    	optionsdropdown.click();
    	System.out.println("clicked on the drop down");

		 Thread.sleep(1000);
		 	

		 	 a.moveToElement(exportdocas).click().build().perform();
		 	 Thread.sleep(5000); 
		
		 a.moveToElement(xlsx).click().build().perform();
}







public void open_NP$_Sales_RID_124(String s) throws InterruptedException, AWTException 
{
	MDM.click();
	 Actions a = new Actions(driver);
	 Thread.sleep(2000);
	 a.moveToElement(NP$_Sales_RID_124).doubleClick().build().perform();
	 
	 System.out.println("opned the Basic_Part_InfoRID_126");
	 
	 driver.switchTo().parentFrame();
		
	 driver.switchTo().defaultContent();
	 System.out.println("switched to default ");
	 driver.switchTo().frame("servletBridgeIframe");
	 System.out.println("switched to servletBridgeIframe ");
	 
	 List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes.size());
		int f=iframes.size()-1;
		
		 for (WebElement iframe : iframes) {
			
			 System.out.println("Frame Id :" + iframe.getAttribute("id"));
			 System.out.println("Frame Name :" + iframe.getAttribute("name"));
	 
		 }
	 

		 driver.switchTo().frame(f);
		 
		 System.out.println("switched to last frame in main frame ");
	 driver.switchTo().frame("webiViewFrame");
	 System.out.println("switched to webiViewFrame ");
	     	
	 WebDriverWait w =new WebDriverWait(driver,50);
    	Thread.sleep(8000);
    	 w.until(ExpectedConditions.elementToBeClickable(OKBtn)); 	
    	OKBtn.click();
    	System.out.println("clicked on ok");
    
	
    	Thread.sleep(8000);
    	
    	//*[@id='BtnCImg_OK_BTN_alertDlg']
    	
    	/*Thread.sleep(20 *   
                60 *   
                1000); */
 /*   
  
  */
    	
    if(s.equals("qa"))	
    {
  WebElement e=  	driver.findElement(By.xpath("//*[@id='BtnCImg_OK_BTN_alertDlg']"));
    
    w.until(ExpectedConditions.elementToBeClickable(e));
    e.click();
    }
    
  		 
		 Thread.sleep(3000);

		 optionsdropdown.click();
	System.out.println("clicked on the drop down");

	 Thread.sleep(1000);
	 	

	 	 a.moveToElement(exportdocas).click().build().perform();
	 	 Thread.sleep(5000); 
	
	 a.moveToElement(xlsx).click().build().perform();
}
}