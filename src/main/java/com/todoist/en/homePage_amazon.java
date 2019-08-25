package com.todoist.en;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class homePage_amazon {
	
	WebDriver driver;
	
	public homePage_amazon(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//INPUT[@id='twotabsearchtextbox']")
	WebElement searchBar;
	
	@FindBy(xpath="(//INPUT[@type='submit'])[1]")
	WebElement searchButton;	
	
	@FindBy(css="span[class='a-size-medium a-color-base a-text-normal']")
	List<WebElement> iPhoneSearchResult;
	
	public void amazon_type_KeyWord_for_iPhone_in_searchBox(String searchiPhone) {
		searchBar.sendKeys(searchiPhone);
	}
	
	public void amazon_click_searchButton_to_search_iPhone8() {
		searchButton.click();
	} 
	
	public List<String> amazon_get_List_of_Search_Result() {
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < iPhoneSearchResult.size(); i++) {
			results.add(iPhoneSearchResult.get(i).getText());
		}
		return results;
	}

	public void verifySearchResult(String keyword_iPhone) {
		
		
	}

}
