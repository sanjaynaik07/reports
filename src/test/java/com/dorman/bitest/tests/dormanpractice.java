package com.dorman.bitest.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class dormanpractice {
@Test
	public void method() throws InterruptedException, AWTException {
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://boqa/BOE/BI");
	
	driver.manage().window().maximize();
	//gotomenubutton-button
	//div[@id='gotomenu']/div/ul/li
	//input[@name='_id0:logon:USERNAME']
	//input[@type='password']
	//input[@type='submit']
	
//	(//input[@type='text'])[4]
	/*List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
	System.out.println(iframes.size());
	 for (WebElement iframe : iframes) {
		 driver.switchTo().frame(iframe);          
        }
	 */
	
	List<WebElement> iframess = driver.findElements(By.xpath("//iframe"));
	System.out.println("printed the list " +iframess);
	System.out.println(iframess.size());
	/* for (WebElement iframe : iframes) {
		 
		 System.out.println("frame id" +iframe.getAttribute("id"));
		 System.out.println("frame name : " +iframe.getAttribute("name"));
		 
		 driver.switchTo().frame(iframe);
		 
	 }*/
int count=0;
 driver.switchTo().frame("servletBridgeIframe"); 
	// main frame
	driver.findElement(By.xpath("//input[@id='_id0:logon:USERNAME']")).sendKeys("sdhanavath");
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("S@nta18");
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();

System.out.println("login sucessfull");

	
	driver.findElement(By.xpath("//a[@title='Documents']")).click();

	
	System.out.println("clicked on Documents");
	//driver.switchTo().defaultContent();
	int count1=0;
	
	//WebElement folder=driver.findElement(By.xpath("//a[@title='Expand Folders']"));
	List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
	System.out.println("total frames : " +iframes.size());
	int size=iframes.size();
	
	for(WebElement e : iframes)
	{
		driver.switchTo().frame(e);
		
	int	total =driver.findElements(By.xpath("//a[@title='Expand Folders']")).size();
		
		System.out.println(total);
		if(total>0)
		 {
			 Thread.sleep(2000);
			// driver.switchTo().frame(iframe);
			 driver.findElement(By.xpath("//a[@title='Expand Folders']")).click();
			 break;
		 }
		 driver.switchTo().parentFrame();
		 }

	
	//span[contains(text(),'DormanSharedCorporate')]
	
	
	/*for(int i=0; i<=size; i++){
		
		driver.switchTo().frame(i);
		int total =driver.findElements(By.xpath("//a[@title='Expand Folders']")).size();
		System.out.println(total);
		if(total>0)
		 {
			 Thread.sleep(2000);
			// driver.switchTo().frame(iframe);
			 driver.findElement(By.xpath("//a[@title='Expand Folders']")).click();
			 break;
		 }
		 driver.switchTo().parentFrame();
		 }
	

	
	WebElement e=driver.findElement(By.xpath("//div[@class='ygtvitem' and @id='ygtv8']/table/tbody/tr/td[1]"));
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;

	jse.executeScript("arguments[0].scrollIntoView()", e); 
	WebDriverWait w=new WebDriverWait(driver,15);
	w.until(ExpectedConditions.elementToBeClickable(e));
e.click();
	System.out.println("expanded public folders");

	
	driver.findElement(By.xpath("//table[@id='ygtvtableel20']/tbody/tr/td[3]")).click();
	
System.out.println("clicked on Dorman shared Corporate");

driver.findElement(By.xpath("//table[@id='ygtvtableel20']/tbody/tr/td[2]")).click();
System.out.println("expanded the Dorman shared Corporate ");
Thread.sleep(10000);
//driver.findElement(By.xpath("//table[@id='ygtvtableel38']/tbody/tr/td[4]")).click();
driver.findElement(By.xpath("//a[@id='ygtvlabelel38']")).click();

System.out.println("clicked on POS");
	Thread.sleep(1000);
	
	
Actions a = new Actions(driver);
 WebElement e1=	driver.findElement(By.xpath("//*[@id='ListingURE_detailView_listColumn_1_0_1']"));
 
 

a.moveToElement(e1).doubleClick().build().perform();
//a.doubleClick(e1).build().perform();


System.out.println("opened POS");

Thread.sleep(15000);
	
Robot robot = new Robot();

robot.keyPress(KeyEvent.VK_ENTER);

System.out.println("clicked on OK Button");
 Thread.sleep(5000);
 List<WebElement> iframes1 = driver.findElements(By.xpath("//iframe"));
	System.out.println(iframes1.size());
	
	 for (WebElement iframe : iframes1) {
		
		 System.out.println("Frame Id :" + iframe.getAttribute("id"));
		 System.out.println("Frame Name :" + iframe.getAttribute("name"));
		 
		 System.out.println("-------------------");
		 
		 
		 


 
	 }
	 
	/* driver.switchTo().parentFrame();
	 Thread.sleep(1000);*/
	 driver.switchTo().defaultContent();
	 Thread.sleep(1000);
	 
 driver.switchTo().frame("servletBridgeIframe"); 
 List<WebElement> iframes2 = driver.findElements(By.xpath("//iframe"));
 
System.out.println("inside frames count of servletBridgeIframe ="  +iframes2.size());
int size2=iframes2.size();
//7
/*for(int i=0; i<size2; i++){
	
	driver.switchTo().frame(i);
	
	List<WebElement> iframes3 = driver.findElements(By.xpath("//iframe"));
	System.out.println("inside frame ="+i +"  " +iframes3.size());
	int size3=iframes3.size();
	for(int j=0; j<size3; j++)
	{ 
		driver.switchTo().frame(j);
		
		List<WebElement> iframes4 = driver.findElements(By.xpath("//iframe"));
		System.out.println("inside inside  frame i= " +i+" j= "+j +"  " +iframes4.size());
		int size4=iframes4.size();
		for(int k=0; k<size4; k++)
		{ 
			System.out.println("inside inside inside i= " +i+"+j=  " +j +" k= " + k);
			driver.switchTo().frame(k);
			
			System.out.println("Frame Id :" + ((WebElement) iframes4).getAttribute("id"));
			 System.out.println("Frame Name :" + ((WebElement) iframes4).getAttribute("name"));
			int total =driver.findElements(By.xpath("//span[contains(text(),'POS Basic Key Account')]")).size();
			System.out.println("innerframe "+ k +"element count" +total);
			
			if(total>0)
			 {
				 driver.findElement(By.xpath("//span[contains(text(),'POS Basic Key Account')]")).click();
				 break;
			 }
			else {
				driver.switchTo().parentFrame();
			}	
			
			}
		
		
			driver.switchTo().parentFrame();
		}	
		
	 driver.switchTo().parentFrame();
	 
	 
	 }*/

 
/* for (WebElement iframe3 : iframes2) {
		
	 System.out.println("Frame Id :" + iframe3.getAttribute("id"));
	 System.out.println("Frame Name :" + iframe3.getAttribute("name"));
 
 } 
 
 
 driver.switchTo().frame(6);	
 
 System.out.println("switched to 7th frame");
 
 List<WebElement> iframes4 = driver.findElements(By.xpath("//iframe"));
 
System.out.println("inside frame count ="  +iframes4.size());
 
 for (WebElement iframe5 : iframes4) {
		
	 System.out.println("Frame Id :" + iframe5.getAttribute("id"));
	 System.out.println("Frame Name :" + iframe5.getAttribute("name"));
 
 } 
 

 
driver.switchTo().frame(0);
WebElement frameid =driver.findElement(By.xpath("//iframe[@id='_iframeleftPaneW']"));

driver.switchTo().frame(frameid);

//span[contains(text(),'POS Basic Key Account')]

driver.findElement(By.xpath("//span[contains(text(),'POS Basic Key Account')]")).click();

driver.switchTo().parentFrame();*/
 
/* WebElement dropdown= driver.findElement(By.xpath("(//table[@title='Click here to access options'])[3]"));
w.until(ExpectedConditions.elementToBeClickable(dropdown));
dropdown.click();
System.out.println("clicked on the drop down");
//span[@id='iconMenu_menu__dhtmlLib_257_span_text__menuAutoId_12']
Thread.sleep(1000);
 WebElement exportdocas=driver.findElement(By.xpath("//td[@id='iconMenu_menu__dhtmlLib_257_text__menuAutoId_12' and @class='menuTextPart']"));
 
 a.moveToElement(exportdocas).click().build().perform();
 Thread.sleep(5000); 
WebElement xlxs=driver.findElement(By.xpath("//*[@id='_dhtmlLib_262_span_text__menuAutoId_14']"));	
//a.moveToElement(xlxs).click().build().perform();
//Thread.sleep(5000);
System.out.println("clicked on xlxs");
*/
	
}
}