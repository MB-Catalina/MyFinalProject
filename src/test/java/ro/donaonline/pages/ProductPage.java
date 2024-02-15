package ro.donaonline.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
    @FindBy(css = "span.h1-title")
    WebElement nameResult;

    public WebElement getNameResult() {
        return nameResult;
    }

    @FindBy(css = "#product-info-right .product-price")
    WebElement priceResult;

    public WebElement getPriceResult() {
        return priceResult;
    }

    @FindBy(css = "#product-info-right a#button-cart")
    WebElement addToCartButton;

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    @FindBy(css = ".fa.fa-shopping-cart")
    private WebElement cart;

    public WebElement getCart() {
        return cart;
    }

    @FindBy(css = "#cart-items")
    private WebElement cartItems;
}
