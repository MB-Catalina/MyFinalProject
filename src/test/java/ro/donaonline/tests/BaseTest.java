package ro.donaonline.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import ro.donaonline.pages.*;

public class BaseTest {
    WebDriver driver;
    String homePageUrl = "https://donaonline.ro/";
    HomePage homePage;
    CategoryPage categoryPage;
    ProductPage productPage;
    CartPage cartPage;

    SearchPharmacyPage searchPharmacyPage;

    @Parameters({"browserP"})
    @BeforeClass
    public void setUp(String browser) {
        switch (browser) {
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        initPages(driver);
    }

    public void initPages(WebDriver driver) {
        homePage = new HomePage();
        categoryPage = new CategoryPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        searchPharmacyPage = new SearchPharmacyPage();
        PageFactory.initElements(driver, homePage);
        PageFactory.initElements(driver, categoryPage);
        PageFactory.initElements(driver, productPage);
        PageFactory.initElements(driver, cartPage);
        PageFactory.initElements(driver, searchPharmacyPage);

    }

    public void navigateToPage(String url) {
        System.out.println("Open the page...");
        driver.get(url);
        driver.manage().window().maximize();
        checkPageIsReady();
    }

    public void checkPageIsReady() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page is loaded");
            return;
        } else {
            System.out.println("Page is NOT loaded");
        }
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Close window");
        driver.quit();
    }

    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
