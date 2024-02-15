package ro.donaonline.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckboxTest extends BaseTest {

    @Test(description = "This test verifies the functionality of selecting products from a specific category based on the brand.")
    public void checkboxFunctionality() {
        navigateToPage(homePageUrl);
        // click the category option from the top navigation bar and after that click on specific category-Frumusete/dermato-cosmetice
        homePage.getCategoryToggle().click();
        homePage.getSpecificCategory().click();

        //From the filtering category according to the BRAND, check "CeraVe"
        categoryPage.getCeraVeCheckbox().click();
        wait(3000);
        assertTrue(!categoryPage.getProductGridList().isEmpty(), "No results found");

        //Verify that only products from the selected brand are displayed.
        for (WebElement gridItems : categoryPage.getProductGridList()) {
            String productName = gridItems.getText().toLowerCase();
            assertTrue(productName.contains("cerave"), "the product " + productName + " is not from CeraVe");
        }
    }
}
