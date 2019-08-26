package com.todoist.en;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class homePage_eBay {
	
	WebDriver driver;
	
	@FindBy(xpath="//INPUT[@id='gh-ac']")
	WebElement searchBar;
	
	@FindBy(xpath="//INPUT[@id='gh-btn']")
	WebElement searchButton;	
	
	@FindBy(css="h3[class='s-item__title']")
	List<WebElement> iPhoneSearchResult;
	
	@FindBy(css="span[class='s-item__price']")
	List<WebElement> iPhoneSearchPriceseBay;
	
	public homePage_eBay(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void eBaytypeKeyWordforiPhoneinsearchBox(String keywordforIphone) {
		searchBar.sendKeys(keywordforIphone);
	}
	
	public void eBayClickSearchButtontoSearchiPhone8() {
		searchButton.click();
	}
	
	public List<String> eBayGetListofSearchResult() {
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < iPhoneSearchResult.size(); i++) {
			results.add(iPhoneSearchResult.get(i).getText());
		}
		return results;
	}
	
	public List<String> eBayGetListofSearchPrices() {
			List<String> results2 = new ArrayList<String>();
		for (int i = 0; i < iPhoneSearchPriceseBay.size(); i++) {
				results2.add(iPhoneSearchPriceseBay.get(i).getText());
			}
		return results2;
	}

	
}
