package Assignments.astro_WebAutomation;

import org.testng.annotations.Test;

import com.todoist.en.homePage_eBay;
import com.todoist.en.homePage_amazon;

import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class TestCases_Web<combineSearchResult> {

	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void beforeTest() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void sortedSearchResultPrint() {
		homePage_amazon amazonPage = new homePage_amazon(driver);
		homePage_eBay eBayPage = new homePage_eBay(driver);
		String baseUrl_Amazon = "https://www.amazon.com";
		String baseUrl_eBay = "https://www.ebay.com/";
		String keyword_iPhone = "iPhone8";
		
		//opening amazon
		driver.get(baseUrl_Amazon);
		
		//Verifying the url title for amazon
		AssertJUnit.assertEquals(driver.getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		
		//searching for iPhone8 in searchbar and getting the list
		amazonPage.amazon_type_KeyWord_for_iPhone_in_searchBox(keyword_iPhone);
		amazonPage.amazon_click_searchButton_to_search_iPhone8();
		amazonPage.amazon_get_List_of_Search_Result();
		amazonPage.amazon_get_List_of_Search_Price();
		
		//Create a variable for the list of iPhone8 result in amazon
		List<String> searchResult_amazon = amazonPage.amazon_get_List_of_Search_Result();

		
		//Create a variable for the list of iPhone8 result prices in amazon
		List<String> searchPrice_amazon = amazonPage.amazon_get_List_of_Search_Price();
		System.out.println("****&*&*&&*&*&*&*&*&*&*&* amazon price list "+searchPrice_amazon);
		
		//Opening eBay
		driver.get(baseUrl_eBay);
		
		//Verifying the url title for eBay
		AssertJUnit.assertEquals(driver.getTitle(), "Error Page | eBay");
		
		//searching for iPhone8 in searchbar and getting the list
		eBayPage.eBaytypeKeyWordforiPhoneinsearchBox(keyword_iPhone);
		eBayPage.eBayClickSearchButtontoSearchiPhone8();
		eBayPage.eBayGetListofSearchResult();
		eBayPage.eBayGetListofSearchPrices();
		
		//Create a variable for the list of iPhone8 result in eBay
		List<String> searchResult_eBay = eBayPage.eBayGetListofSearchResult();
		
		//Create a variable for the list of iPhone8 prices in eBay
		List<String> searchPrices_eBay = eBayPage.eBayGetListofSearchPrices();
		System.out.println("****&*&*&&*&*&*&*&*&*&*&* ebay price list"+searchPrices_eBay);
		
		
		//Verifying that the search result contains the result of iPhone8
		if (searchResult_amazon.contains(keyword_iPhone)) {
			System.out.println("iPhone8 results showing successfully in amazon");
		}
		else {
			System.out.println("iPhone8 result didn't found in amazon");
		}
		
		/*for (int i = 0; i < searchResult_amazon.size(); i++) {
	        Assert.assertTrue(searchResult_amazon.get(i).getText().contains(keyword_iPhone));
	    }*/
		
		//Merging the search result of ebay and amzon
		searchResult_eBay.addAll(searchResult_amazon);
		
		//Merging the search result price list of ebay and amzon
		searchPrices_eBay.addAll(searchPrice_amazon);
		
		//Print the merged result of ebay and amzon
		//System.out.println("The iphone8 result list from ebay : " +searchResult_eBay);
		
		//Print the merged price of ebay and amzon
		//System.out.println("The iphone8 result list from ebay : " +searchPrices_eBay);		
		
		
		//Sort and print the sorted and merged result of iPhone8
		Collections.sort(searchResult_eBay);
		Collections.sort(searchPrices_eBay);
		for (int i = 0; i < searchResult_eBay.size() && i< searchPrices_eBay.size() ; i++) {
			System.out.println("The ihpone search result with price is: "+searchResult_eBay.get(i)+searchPrices_eBay.get(i));
		}
		
		/*for (int i = 0; i < searchPrices_eBay.size() ; i++) {
			System.out.println("The prices of phone is"+searchPrices_eBay.get(i));
		}*/
		
		/*for(String value : searchResult_eBay) {
			System.out.println(value);
		}*/
	
	}
	
	@AfterTest
	public void AfterTest() {
		driver.close();
	}
	
}
