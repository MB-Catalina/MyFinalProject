package ro.donaonline.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchPharmacyByCityTest extends BaseTest {

    @Test(dataProvider = "citiesDataProvider")
    public void checkSearchFunctionality(String city) {
        navigateToPage(homePageUrl);

        //go to pharmacies category from top bar menu
        homePage.getPharmacyCategory().click();
        homePage.getPharmacyCategory().click();

        //search Pharmacy by city
        searchPharmacyPage.getSearchbycitybox().click();
        searchPharmacyPage.getSearchbycitybox().sendKeys(city);
        searchPharmacyPage.getSearchButton().click();

        //scroll to see the results
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        wait(2000);

        //verify if there are pharmacies for the given city
        Assert.assertTrue(searchPharmacyPage.getPharmacyFoundText().isDisplayed());
        int pharmacyCount = Integer.parseInt(searchPharmacyPage.getNumberOfPharmacies().getText());
        Assert.assertTrue(pharmacyCount > 0, "No pharmacy found for given city");
    }

    //DataProvider method used to execute test for each provider value
    @DataProvider(name = "citiesDataProvider")
    public Object[][] returnCity() {
        return new Object[][]{{"Cluj-Napoca"}, {"Sibiu"}};
    }
}