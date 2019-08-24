package Assignments.astro_WebAutomation;

import org.testng.annotations.Test;

import com.todoist.en.homePage_Wallmart;
import com.todoist.en.homePage_amazon;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class TestCases_Web {

	WebDriver driver = new ChromeDriver();
	
	
	@Test
	public void SearchResultPrint() {
		homePage_amazon amazonPage = new homePage_amazon(driver);
		homePage_Wallmart WallmartPage = new homePage_Wallmart(driver);
		
		String baseUrl_Amazon = "https://www.amazon.com";
		String baseUrl_eBay = "https://www.ebay.com/";
		String keyword_iPhone = "iPhone8";
		
		
		driver.get(baseUrl_eBay);
		
		//AssertJUnit.assertEquals(driver.getTitle(), "Walmart.com | Save Money. Live Better.");
		
		WallmartPage.eBaytypeKeyWordforiPhoneinsearchBox(keyword_iPhone);
		WallmartPage.eBayClickSearchButtontoSearchiPhone8();
		WallmartPage.eBayGetListofSearchResult();
		
		String searchResult_eBay = WallmartPage.eBayGetListofSearchResult();
		
		System.out.println("######### : "+searchResult_eBay);
		
		
		driver.get(baseUrl_Amazon);
		
		AssertJUnit.assertEquals(driver.getTitle(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
		
		amazonPage.amazon_type_KeyWord_for_iPhone_in_searchBox(keyword_iPhone);
		amazonPage.amazon_click_searchButton_to_search_iPhone8();
		amazonPage.amazon_get_List_of_Search_Result();
		
		String searchResult_amazon = amazonPage.amazon_get_List_of_Search_Result();
		
		System.out.println("$$$$$$$$$$$: "+searchResult_amazon);
		
		
	}
	
	@AfterTest
	public void AfterTest() {
		driver.close();
	}
	
}
