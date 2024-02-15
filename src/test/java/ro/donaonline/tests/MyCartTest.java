package ro.donaonline.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyCartTest extends BaseTest {
    @Test(description = "This test verifies the functionality of adding a product to the shopping cart")
    public void addToCartFunctionality() {
        navigateToPage("https://donaonline.ro/marci-exclusive");
        checkPageIsReady();

        //check if there are products in the list
        assertFalse(categoryPage.getSearchResults().isEmpty(), "No results found");

        //choose a random product and click on it and identify the name and the price from product list
        WebElement randomProduct = categoryPage.getSearchResults().get(6);
        randomProduct.click();
        checkPageIsReady();
        String productPageName = productPage.getNameResult().getText();
        String productPagePrice = productPage.getPriceResult().getText();

        // click on add to shopping cart
        productPage.getAddToCartButton().click();

        //JavaScript method used to scroll into view for the given page element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productPage.getCart());

        //Click on My cart
        productPage.getCart().click();
        checkPageIsReady();

        //verify if the name and the price from the product page are the same with the name and the price with the product from cart.
        String cartProductName = cartPage.getCartProductName().getText();
        String cartPrice = cartPage.getCartUnitPrice().getText();
        assertEquals(cartProductName, productPageName);
        assertEquals(cartPrice, productPagePrice);
    }

    @Test(description = "This test verifies the functionality to remove a product from the shopping cart after it has been added.")
    public void removeFromCartFunctionality() {
        //navigate to a specific product page, in this case "Calmogen"
        navigateToPage("https://donaonline.ro/calmogen-plant-tf-perrigo-20-capsule");
        checkPageIsReady();

        //add the product to my cart
        productPage.getAddToCartButton().click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productPage.getCart());
        //go to my cart page
        productPage.getCart().click();
        //verify if there is any products in list
        assertTrue(cartPage.productFromCart().isDisplayed(), "The cart is empty.");

        //remove any product from my cart
        cartPage.getRemoveFromCart().click();
        wait(2000);
        do {
            try {
                WebElement removeFromCartButton = driver.findElement(By.cssSelector(".btn-remove .fa-times-circle"));
                removeFromCartButton.click();
                wait(1000);
            } catch (NoSuchElementException exception) {
                System.out.println("the cart is empty");
                break;
            }
        }
        while (cartPage.getEmptyCartMessage().isDisplayed());
        wait(1000);

        //verify if the cart is empty
        String text = "Coșul tău este gol!";
        assertTrue(cartPage.getEmptyCartMessage().getText().contains(text), "The cart it's not empty and it should be");
    }
}
