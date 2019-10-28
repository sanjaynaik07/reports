package com.dorman.bitest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocumentsPage {
	WebDriver driver;

	public DocumentsPage(WebDriver driver)

	{
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@title='Documents']")
	private WebElement documentlink;

	@FindBy(xpath = "//a[@title='Expand Folders']")
	WebElement folders;

	@FindBy(xpath = "//div[@class='ygtvitem' and @id='ygtv8']/table/tbody/tr/td[1]")
	WebElement expandfolder;
	//@FindBy(xpath = "//*[@id='ygtvt8']/a")
	//WebElement expandfolder;
	@FindBy(xpath = "//span[contains(text(),'DormanSharedCorporate')]")
	WebElement dormansharedcorporate;

	@FindBy(xpath = "//table[@id='ygtvtableel20']/tbody/tr/td[2]")
	WebElement qa_expanddormansharedcorporate;

	@FindBy(xpath = "//table[@id='ygtvtableel25']/tbody/tr[1]/td[2]")
	WebElement test_expanddormansharedcorporate;
	
	
	@FindBy(xpath = "//span[@id='accordionNavigationView_drawer1_treeView_treeNode1_name']")
	WebElement publicfolders;
	
	
	@FindBy(xpath = "//div[text()='DormanSales']")
	WebElement Dormansales;
	//span[@id='accordionNavigationView_drawer1_treeView_treeNode1_name']
	public void clickondocuments() {
		Actions a = new Actions(driver);
		
		WebDriverWait w = new WebDriverWait(driver, 30);
		try {
			
			if(documentlink.isDisplayed())
			{
				a.moveToElement(documentlink).click().build().perform();
			}else
			{
				driver.navigate().refresh();
				
				Thread.sleep(20000);
				w.until(ExpectedConditions.elementToBeClickable(documentlink));
				a.moveToElement(documentlink).click().build().perform();
			}
	
		}
		catch(Exception e)
		{
			
		}
		// documentlink.click();
		System.out.println(" clicked on document link");
	}

	public void clickonfolder() throws Exception

	{
		WebDriverWait w = new WebDriverWait(driver, 30);
		Actions a = new Actions(driver);
		List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes.size());

		for (WebElement iframe : iframes) {

			System.out.println("Frame Id :" + iframe.getAttribute("id"));
			System.out.println("Frame Name :" + iframe.getAttribute("name"));

			System.out.println("-------------------");
		}

		driver.switchTo().frame(5);

	//	folders.click();
		try {
			if(folders.isDisplayed())
		{
				folders.click();
		
		}else {
			driver.navigate().refresh();
			Thread.sleep(30000);
			w.until(ExpectedConditions.elementToBeClickable(documentlink));
			a.moveToElement(documentlink).click().build().perform();
			folders.click();
		}
		}catch(Exception e)
		{
			
		}

		System.out.println("clicked on folders ");
		
		
	}

	public void clickonexpandfolder(String s) throws InterruptedException {
	
		
	
		try {
		if(Dormansales.isDisplayed())
		{
		}
		}
		catch (Exception e) {
			publicfolders.click();
		}
		/*finally {
			publicfolders.click();
		}*/
		/*JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].scrollIntoView()", expandfolder);
		WebDriverWait w = new WebDriverWait(driver, 15);
		w.until(ExpectedConditions.elementToBeClickable(expandfolder));

		expandfolder.click();
		Thread.sleep(2000);
		
		try {
			w.until(ExpectedConditions.elementToBeClickable(dormansharedcorporate));
		}
		catch(Exception e) {
			
			expandfolder.click();
			Thread.sleep(5000);
			
		}
		
		System.out.println("expanded public folders");
		// dormansharedcorporate.click();
*/
	}

}
