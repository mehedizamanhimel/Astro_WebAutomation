package Assignments.astro_WebAutomation;

import com.todoist.en.homePage_eBay;
import com.todoist.en.homePage_amazon;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class TestCases_Web {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // headless=new: works on Chrome 112+ and GitHub Actions ubuntu runners
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1600,1100");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void sortedSearchResultPrint() {
        homePage_amazon amazonPage = new homePage_amazon(driver);
        homePage_eBay eBayPage = new homePage_eBay(driver);
        String baseUrl_Amazon = "https://www.amazon.com";
        String baseUrl_eBay = "https://www.ebay.com/";
        String keyword_iPhone = "iPhone8";

        // Open Amazon and verify title
        driver.get(baseUrl_Amazon);
        AssertJUnit.assertEquals(driver.getTitle(),
                "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

        // Search Amazon
        amazonPage.amazon_type_KeyWord_for_iPhone_in_searchBox(keyword_iPhone);
        amazonPage.amazon_click_searchButton_to_search_iPhone8();
        List<String> searchResult_amazon = amazonPage.amazon_get_List_of_Search_Result();
        List<String> searchPrice_amazon  = amazonPage.amazon_get_List_of_Search_Price();

        // Open eBay and verify title
        driver.get(baseUrl_eBay);
        AssertJUnit.assertEquals(driver.getTitle(), "Error Page | eBay");

        // Search eBay
        eBayPage.eBaytypeKeyWordforiPhoneinsearchBox(keyword_iPhone);
        eBayPage.eBayClickSearchButtontoSearchiPhone8();
        List<String> searchResult_eBay  = eBayPage.eBayGetListofSearchResult();
        List<String> searchPrices_eBay  = eBayPage.eBayGetListofSearchPrices();

        // Check Amazon contains keyword
        if (searchResult_amazon.contains(keyword_iPhone)) {
            System.out.println("iPhone8 results showing successfully in amazon");
        } else {
            System.out.println("iPhone8 result didn't found in amazon");
        }

        // Merge and sort combined results
        searchResult_eBay.addAll(searchResult_amazon);
        searchPrices_eBay.addAll(searchPrice_amazon);
        Collections.sort(searchResult_eBay);

        // Print combined sorted results
        System.out.println("The url of amazon: " + baseUrl_Amazon);
        System.out.println("The url of eBay: " + baseUrl_eBay);
        for (int i = 0; i < searchResult_eBay.size() && i < searchPrices_eBay.size(); i++) {
            System.out.println("The iPhone search result with price is: "
                    + searchResult_eBay.get(i) + searchPrices_eBay.get(i));
        }
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
