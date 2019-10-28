package com.dorman.bitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DormanSharedCorporatePage_TestEvn {
	WebDriver driver;
    public DormanSharedCorporatePage_TestEvn(WebDriver driver)
    { 
   	 this.driver=driver;
   	 
      }
	
	  @FindBy(xpath="//table[@id='ygtvtableel25']/tbody/tr[1]/td[2]")
		 WebElement test_expanddormansharedcorporate;
	  
	  

	  @FindBy(xpath="//*[@id='accordionNavigationView_drawer1_treeView_treeNode44_name']")
		 WebElement test_pos;
	  
	  @FindBy(xpath="//*[@id='ListingURE_detailView_listColumn_1_0_1']")
		 WebElement test_openpos;
	  
	  
	  public void openpos_test() throws Exception
		 {
		  
		 }
	  
	  

}
