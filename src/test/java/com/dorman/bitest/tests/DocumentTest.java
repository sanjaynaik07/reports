package com.dorman.bitest.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dorman.bitest.pages.DocumentsPage;
import com.dorman.bitest.startbrowser.BrowserInit;

public class DocumentTest extends BrowserInit {

	
	@Test(priority=2)
	public void document(String s) throws Exception 
	{
		DocumentsPage dp =PageFactory.initElements(driver, DocumentsPage.class);
		
	//	Thread.sleep(2*60*1000);
		dp.clickondocuments();
		dp.clickonfolder();
		dp.clickonexpandfolder("qa");
		
	/*	if(s.equals("qa"))
		{
		dp.clickonexpandfolder("qa");
		}
		else {
			dp.clickonexpandfolder("test");
		}*/
	}
	
	
	
	
}
