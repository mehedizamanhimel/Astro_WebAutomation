package com.todoist.en;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class homePage_Wallmart {
	
	WebDriver driver;
	
	@FindBy(xpath="//INPUT[@id='gh-ac']")
	WebElement searchBar;
	
	@FindBy(xpath="//INPUT[@id='gh-btn']")
	WebElement searchButton;	
	
	@FindBy(css="h3[class='s-item__title']")
	List<WebElement> iPhoneSearchResult;
	
	
	
	public homePage_Wallmart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void eBaytypeKeyWordforiPhoneinsearchBox(String keywordforIphone) {
		searchBar.sendKeys(keywordforIphone);
	}
	
	public void eBayClickSearchButtontoSearchiPhone8() {
		searchButton.click();
	}
	
	public String eBayGetListofSearchResult() {
		
		int i;
		String elementText = null;
	 for( i =0;i<iPhoneSearchResult.size();i++)
	 		{
			 elementText = iPhoneSearchResult.get(i).getText(); 
			 System.out.println(elementText); 
			}
	 return elementText;
	}

}
