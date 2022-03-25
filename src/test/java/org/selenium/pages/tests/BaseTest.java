package org.selenium.pages.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.driver.Driver;
import org.selenium.pages.*;
import org.selenium.utils.ListenerEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

@ExtendWith(ListenerEvent.class)
public abstract class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected MainPage mainPage;
    protected RegistrationPage registrationPage;
    protected LogInPage logInPage;
    protected MyAccountPage myAccountPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected WishListPage wishListPage;
    protected ProductDetailPage productDetailPage;

    @BeforeAll
    //@Step("Beginning the action")
    public static void create() {
        driver = Driver.getInstance();
        wait = new WebDriverWait(driver, 30);
        System.out.println("<----- | Browser Session Started | ----->");
    }

    @AfterAll
    //@Step("Ending the action")
    public static void tearDown() {
        Driver.quit();
        System.out.println("<----- | Browser Session End | ----->");
    }
}