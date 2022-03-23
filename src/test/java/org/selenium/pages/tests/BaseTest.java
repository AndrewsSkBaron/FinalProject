package org.selenium.pages.tests;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.driver.Driver;
import org.selenium.pages.*;
import org.selenium.utils.JsonParser;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JsonParser parser = new JsonParser();;
    protected static MainPage mainPage;
    protected static MyAccountPage account;
    protected static RegistrationPage registration;
    protected static LogInPage signIn;
    protected static DressesPage dresses;
    protected static CartPage cart;
    protected static WishListPage wishList;
    protected static ProductDetailPage product;

    @Before
    public void create() {
        parser.createJson();
    }

    @BeforeAll
    public static void setUp() {
        driver = Driver.getInstance();
        wait = new WebDriverWait(driver, 30);
        mainPage = new MainPage();
        account = new MyAccountPage();
        registration = new RegistrationPage();
        signIn = new LogInPage();
        dresses = new DressesPage();
        cart = new CartPage();
        wishList = new WishListPage();
        product = new ProductDetailPage();
    }

    @AfterAll
    public static void tearDown() {
        //Driver.quit();
    }
}