package ro.donaonline.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage {
    @FindBy(css = ".cart-page tbody .td-name.text-left")
    private WebElement cartProductName;
    @FindBy(css = ".cart-page tbody .td-price")
    private WebElement cartUnitPrice;

    @FindBy(css = ".table.table-bordered > tbody > tr > .td-name.text-left > a")
    private WebElement emptyCart;

    @FindBy(css = "button:nth-of-type(2) > .fa.fa-times-circle")
    private WebElement removeFromCart;

    @FindBy(css = "div#content > p")
    private WebElement emptyCartMessage;

    @FindBy(xpath = "//tbody/tr[1]/td[4]/div[1]/span[1]/button[2]/i[1]")
    private List<WebElement> removeButtons;

    public WebElement getCartProductName() {
        return cartProductName;
    }

    public WebElement getCartUnitPrice() {
        return cartUnitPrice;
    }

    public WebElement productFromCart() {
        return emptyCart;
    }

    public WebElement getRemoveFromCart() {
        return removeFromCart;
    }

    public WebElement getEmptyCartMessage() {
        return emptyCartMessage;
    }

}
