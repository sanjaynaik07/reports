package com.dorman.bitest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.dorman.bitest.pages.DocumentsPage;

public class DormanSharedCorporatePage {
	WebDriver driver;

	public DormanSharedCorporatePage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//span[contains(text(),'DormanSharedCorporate')]")
	WebElement dormansharedcorporate;

	/*
	 * @FindBy(xpath="//table[@id='ygtvtableel20']/tbody/tr/td[3]") WebElement
	 * dormansharedcorporate;
	 */
	@FindBy(xpath = "//table[@id='ygtvtableel20']/tbody/tr/td[2]")
	WebElement expanddormansharedcorporate;

	@FindBy(xpath = "//a[@id='ygtvlabelel38']")
	WebElement POSlink;

	@FindBy(xpath = "//div[text()='POS']")
	WebElement POS;

	@FindBy(xpath = "//a[@id='ygtvlabelel44']")
	WebElement stage_POSlink;
	// a[@id='ygtvlabelel44']

	@FindBy(xpath = "//*[@id='ListingURE_detailView_listColumn_1_0_1']")
	WebElement openpos;
	@FindBy(xpath = "//iframe[@name='servletBridgeIframe']")
	WebElement loginframe;

	@FindBy(xpath = "//iframe[@id='_iframeleftPaneW']")
	WebElement frameid;

	@FindBy(xpath = "//span[contains(text(),'POS Basic Key Account')]")
	WebElement posbasickeyaccount;

	@FindBy(xpath = "(//table[@title='Click here to access options'])[3]")
	WebElement optionsdropdown;

	@FindBy(xpath = "//td[@id='iconMenu_menu__dhtmlLib_257_text__menuAutoId_12' and @class='menuTextPart']")
	WebElement exportdocas;
	@FindBy(xpath = "//*[@id='_dhtmlLib_262_span_text__menuAutoId_14']")
	WebElement xlsx;

	@FindBy(xpath = "//*[@id='accordionNavigationView_drawer1_treeView_treeNode40_name']")
	WebElement supplychainkpilink;

	@FindBy(xpath = "//*[@id='accordionNavigationView_drawer1_treeView_treeNode46_name']")
	WebElement stage_supplychainkpilink;

	// *[@id='accordionNavigationView_drawer1_treeView_treeNode46_name']

	@FindBy(xpath = "//table[@id='ListingURE_detailView_listMainTable']/tbody/tr[3]")
	WebElement supplychaintool;

	@FindBy(xpath = "//table[@id='ListingURE_detailView_listMainTable']/tbody/tr[4]")
	WebElement stage_supplychaintool;

	@FindBy(xpath = "//input[@id='lovWidgetpromptLovZone_textField']")
	WebElement inputtext;

	@FindBy(xpath = "//*[@id='Btn_lrz_arrowAdd_promptLovZone_RightZone_basic']")
	WebElement rightarrow;

	@FindBy(xpath = "//*[@id='mlst_bodylrz_selList_promptLovZone_RightZone_basic']/div/table/tbody/tr[1]/td/div")
	WebElement select1;

	@FindBy(xpath = "//*[@id='Btn_lrz_arrowRemove_promptLovZone_RightZone_basic']")
	WebElement leftarrow;

	@FindBy(xpath = "//*[@id='_CWpromptsPromptListTWe_1']/tbody/tr/td[3]")
	WebElement month;

	@FindBy(xpath = "//input[@id='lovWidgetpromptLovZone_textField']")
	WebElement entermonth;

	@FindBy(xpath = "//*[@id='Btn_OK_BTN_promptsDlg']")
	WebElement okbutton;

	@FindBy(xpath = "//div[contains(text(),'Inventory Excess Actuals Baseline') and @id='ListingURE_detailView_listColumn_1_0_1']")
	WebElement qa_InventaryExcess;

	@FindBy(xpath = "//div[contains(text(),'Inventory Excess Actuals Baseline') and @id='ListingURE_detailView_listColumn_2_0_1']")
	WebElement stage_InventaryExcess;

	@FindBy(xpath = "//div[@class='ygtvitem' and @id='ygtv8']/table/tbody/tr/td[1]")
	WebElement expandfolder;

	String[] s;

	public void openpos(String reportname) throws Exception {
		s = reportname.split(",");
		String xpath1_Mainfolder = "//span[contains(text(),'";
		String xpath2_Mainfolder = s[0] + "')]";
		String xpath_Mainfolder = xpath1_Mainfolder + xpath2_Mainfolder;

		System.out.println("man folder" + xpath_Mainfolder);

		String xpath1_subfolder = "//div[contains(text(),'";
		String xpath2_subfolder = s[1] + "')]";
		String xpath_subfolder = xpath1_subfolder + xpath2_subfolder;

		System.out.println(xpath_subfolder);

		String xpath1_reportname = "//div[contains(text(),'";
		String xpath2_reportname = s[2] + "')]";
		String xpath_reportname = xpath1_reportname + xpath2_reportname;

		System.out.println(xpath_reportname);
		WebElement dormansharedcorporat = driver.findElement(By.xpath(xpath_Mainfolder));

		/*
		 * WebDriverWait w = new WebDriverWait(driver, 30); try {
		 * w.until(ExpectedConditions.elementToBeClickable(dormansharedcorporat)); }
		 * catch (Exception e) { expandfolder.click(); }
		 */

		// dormansharedcorporat.click();

		/*
		 * // sp[contains(text(),'DormanProduct')] List<WebElement> wel =
		 * driver.findElements(By.className("ygtvrow")); WebElement wel2 = null;
		 * System.out.println("Count : " + wel.size()); String nam = ""; for (WebElement
		 * fol : wel) { try { wel2 = fol.findElement(By.tagName("span")); nam =
		 * wel2.getText(); if (nam.contains("Corporate Dashboards")) { wel2.click();
		 * fol.findElement(By.tagName("a")).click(); } if (nam.contains("Deploy")) {
		 * wel2.click(); fol.findElement(By.tagName("a")).click(); } } catch (Exception
		 * ex) { System.out.println(ex.getMessage()); } }
		 */

		String[] folderNames = "DormanProduct,Product Team Shared Reports,Market Intelligence,Automated_Reports,DormanInventory"
				.split(",");

		for (String folders : folderNames) {
			ClickFoldersinDocumentsPane(folders);
		}

		Thread.sleep(2000);

		WebElement posf = driver.findElement(By.xpath(xpath_subfolder));

		Actions a = new Actions(driver);
		Thread.sleep(1000);

		a.moveToElement(posf).doubleClick().build().perform();

		Thread.sleep(1000);

		WebElement posr = driver.findElement(By.xpath(xpath_reportname));

		a.moveToElement(posr).doubleClick().build().perform();

		Thread.sleep(20000);

		System.out.println("opened POS");

		Thread.sleep(30000);

		List<WebElement> iframes1 = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes1.size());

		for (WebElement iframe : iframes1) {

			System.out.println("inside Frame Id :" + iframe.getAttribute("id"));
			System.out.println("inside Frame Name :" + iframe.getAttribute("name"));

			System.out.println("-------------------");

		}

		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("servletBridgeIframe");

		List<WebElement> iframes2 = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes2.size());

		for (WebElement iframe3 : iframes2) {

			System.out.println("in main  Frame Id :" + iframe3.getAttribute("id"));
			System.out.println("in main Frame Name :" + iframe3.getAttribute("name"));

			System.out.println("-------------------");

		}

		driver.switchTo().frame(6);

		List<WebElement> iframes4 = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes4.size());

		for (WebElement iframe5 : iframes4) {

			System.out.println("inside 7 Frame Id :" + iframe5.getAttribute("id"));
			System.out.println("inside 7  Frame Name :" + iframe5.getAttribute("name"));

			System.out.println("-------------------");

		}

		driver.switchTo().frame("webiViewFrame");

		List<WebElement> iframes6 = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes6.size());

		for (WebElement iframe7 : iframes6) {

			System.out.println("inside webview Frame Id :" + iframe7.getAttribute("id"));
			System.out.println("inside webview  Frame Name :" + iframe7.getAttribute("name"));

			System.out.println("-------------------");

		}

		inputtext.sendKeys("2017");
		rightarrow.click();

		select1.click();

		leftarrow.click();

		month.click();

		entermonth.sendKeys("M03");

		// front
		Thread.sleep(2000);
		rightarrow.click();
		Thread.sleep(5000);
		select1.click();
		leftarrow.click();
		Thread.sleep(5000);
		okbutton.click();

		// driver.switchTo().frame(6);

		// driver.switchTo().frame(webiViewFrame);

		driver.switchTo().frame("_iframeleftPaneW");

		posbasickeyaccount.click();

		driver.switchTo().parentFrame();

		// w.until(ExpectedConditions.elementToBeClickable(optionsdropdown));
		optionsdropdown.click();
		System.out.println("clicked on the drop down");

		Thread.sleep(1000);

		a.moveToElement(exportdocas).click().build().perform();
		Thread.sleep(5000);

		// a.moveToElement(xlsx).click().build().perform();
		/*
		 * Thread.sleep(5000); System.out.println("clicked on xlxs");
		 * 
		 * Thread.sleep(5000);
		 */

		// driver.quit();

	}

	public void ClickFoldersinDocumentsPane(String folder) {
		List<WebElement> wel = driver.findElements(By.className("ygtvrow"));
		
		WebElement wel2 = null;
		System.out.println("Count : " + wel.size());
		String nam = "";
		for (WebElement fol : wel) {
			try {
				wel2 = fol.findElement(By.tagName("span"));
				nam = wel2.getText();
				if (nam.contains(folder)) {
				//	
					fol.findElement(By.tagName("a")).click();
					driver.wait(2000);
					wel2.click();
					
					break;
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public void supplychain(String s) throws Exception {

		if (s.equals("stage")) {
			stage_supplychainkpilink.click();
		} else {
			supplychainkpilink.click();

		}
		Thread.sleep(2000);
		System.out.println("clicked on supply chain");
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		if (s.equals("stage")) {
			a.moveToElement(stage_supplychaintool).doubleClick().build().perform();
		} else {
			a.moveToElement(supplychaintool).doubleClick().build().perform();
		}
		System.out.println("double clicked on supply chain tool");

		Thread.sleep(5000);

		driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		driver.switchTo().frame("servletBridgeIframe");

		List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes.size());
		int f = iframes.size() - 1;

		for (WebElement iframe : iframes) {

			System.out.println("Frame Id :" + iframe.getAttribute("id"));
			System.out.println("Frame Name :" + iframe.getAttribute("name"));

		}

		driver.switchTo().frame(f);
		driver.switchTo().frame("webiViewFrame");

		WebElement year = driver
				.findElement(By.xpath("//*[@id='mlst_bodylovWidgetpromptLovZone_lov']/div/table/tbody/tr[13]/td/div"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].scrollIntoView()", year);

		Thread.sleep(2000);
		year.click();
		jse.executeScript("window.scrollBy(0,-1000)");

		rightarrow.click();

		// *[@id='_CWpromptstrLstElt_TWe_2']/span[1]

		driver.findElement(By.xpath("//*[@id='_CWpromptstrLstElt_TWe_2']/span[1]")).click();
		Thread.sleep(2000);

		// *[@id='mlst_bodylovWidgetpromptLovZone_lov']/div/table/tbody/tr[3]/td/div

		WebElement month = driver
				.findElement(By.xpath("//*[@id='mlst_bodylovWidgetpromptLovZone_lov']/div/table/tbody/tr[3]/td/div"));

		a.moveToElement(month).build().perform();

		month.click();
		rightarrow.click();
		Thread.sleep(3000);

		okbutton.click();

		WebDriverWait w = new WebDriverWait(driver, 300);
		w.until(ExpectedConditions.elementToBeClickable(optionsdropdown));
		optionsdropdown.click();
		System.out.println("clicked on the drop down");

		Thread.sleep(1000);

		a.moveToElement(exportdocas).click().build().perform();
		Thread.sleep(5000);

		a.moveToElement(xlsx).click().build().perform();
		/*
		 * Thread.sleep(5000); System.out.println("clicked on xlxs");
		 */

	}

	public void supplychain_InventoyExcessActualsBaseLine(String s) throws Exception {

		if (s.equals("stage")) {
			stage_supplychainkpilink.click();
		} else {
			supplychainkpilink.click();

		}
		Thread.sleep(2000);
		System.out.println("clicked on supply chain");
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		if (s.equals("stage")) {
			a.moveToElement(stage_InventaryExcess).doubleClick().build().perform();
		} else {
			a.moveToElement(qa_InventaryExcess).doubleClick().build().perform();
		}
		System.out.println("double clicked on supplychain_Inventoy Excess Actuals BaseLine");

		Thread.sleep(5000);

		driver.switchTo().parentFrame();

		driver.switchTo().defaultContent();

		driver.switchTo().frame("servletBridgeIframe");

		List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		System.out.println(iframes.size());
		int f = iframes.size() - 1;

		for (WebElement iframe : iframes) {

			System.out.println("Frame Id :" + iframe.getAttribute("id"));
			System.out.println("Frame Name :" + iframe.getAttribute("name"));

		}

		driver.switchTo().frame(f);
		driver.switchTo().frame("webiViewFrame");

		WebDriverWait w = new WebDriverWait(driver, 300);
		w.until(ExpectedConditions.elementToBeClickable(optionsdropdown));
		optionsdropdown.click();
		System.out.println("clicked on the drop down");

		Thread.sleep(1000);

		a.moveToElement(exportdocas).click().build().perform();
		Thread.sleep(5000);

		a.moveToElement(xlsx).click().build().perform();
		/*
		 * Thread.sleep(5000); System.out.println("clicked on xlxs");
		 */

	}

}
