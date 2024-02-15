package ro.donaonline.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPharmacyPage {
    @FindBy(css = "#search_by_city")
    private WebElement searchbycitybox;

    public WebElement getSearchbycitybox() {
        return searchbycitybox;
    }

    @FindBy(css = "#searchButton")
    private WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }

    @FindBy(css = "p[class='store-count'] span")
    private WebElement pharmacyFoundText;

    public WebElement getPharmacyFoundText() {
        return pharmacyFoundText;
    }

    @FindBy(css = "div#search_zone  strong")
    private WebElement numberOfPharmacies;

    public WebElement getNumberOfPharmacies() {
        return numberOfPharmacies;
    }
}
