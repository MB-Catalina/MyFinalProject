package ro.donaonline.tests;

import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class SearchTests extends BaseTest {


    @Test(description = "This test verifies the functionality of searching for a product by writing it in the search box.")
    public void checkSearchFunctionality() {
        String searchProduct = "vitamax";
        navigateToPage(homePageUrl);
        //Identify search box and search for a given product
        homePage.getSearchBox().click();
        homePage.getSearchBox().sendKeys(searchProduct);
        homePage.getSearchButton().click();

        //check if you are redirected to a page with products
        assertTrue(!categoryPage.getVitaminaCProducts().isEmpty(), "No results found");

        //Identify the first element from results list
        WebElement firstProduct = categoryPage.getSearchResults().get(0);

        //Open the product page for first element from search result
        firstProduct.click();
        checkPageIsReady();

        //Verify if the first product contains searchProduct in the name
        String nameResult = productPage.getNameResult().getText().toLowerCase();
        assertTrue(nameResult.contains(searchProduct));
    }
}
