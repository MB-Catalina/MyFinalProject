package ro.donaonline.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class CategoryPage {
    @FindBy(css = ".filter-checkbox [data-ncase='CeraVe'] input[type='checkbox']")
    private WebElement ceraVeCeckbox;

    @FindBy(css = ".product-grid .product-thumb .name a")
    private List<WebElement> productGridList;

    @FindBy(css = ".main-products-wrapper .product-grid .product-layout")
    private List<WebElement> searchResults;
    @FindBy(css = ".name")
    private List<WebElement> vitaminaCProducts;

    public WebElement getCeraVeCheckbox() {
        return ceraVeCeckbox;
    }

    public List<WebElement> getProductGridList() {
        return productGridList;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public List<WebElement> getVitaminaCProducts() {
        return vitaminaCProducts;
    }
}
