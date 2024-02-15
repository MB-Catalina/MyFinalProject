package ro.donaonline.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage {

    @FindBy(css = ".search-input.tt-input")
    private WebElement searchBox;

    @FindBy(css = ".mid-bar [data-search-url]")
    private WebElement searchButton;

    @FindBy(css = ".product-thumb .caption .name a")
    private WebElement productName;

    @FindBy(css = ".price span.price-normal")
    private WebElement productPrice;

    @FindBy(css = ".drop-menu.first-dropdown")
    private WebElement categoryToggle;

    @FindBy(xpath = "//div[@id='main-menu']/ul[@class='j-menu']/li[1]/div/div[@class='flyout-menu flyout-menu-27']//a[@href='https://donaonline.ro/frumusete-dermatocosmetice']/span[@class='links-text']")
    private WebElement specificCategory;

    @FindBy(xpath = "//div[@id='main-menu']/ul[@class='j-menu']/li[4]/a[@href='https://donaonline.ro/marci-exclusive']/span[@class='links-text']")
    private WebElement exclusiveBrands;

    @FindBy(xpath = "//span[normalize-space()='Farmacii']")
    private WebElement pharmacyCategory;

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getCategoryToggle() {
        return categoryToggle;
    }

    public WebElement getSpecificCategory() {
        return specificCategory;
    }

    public WebElement getPharmacyCategory() {
        return pharmacyCategory;
    }

}




