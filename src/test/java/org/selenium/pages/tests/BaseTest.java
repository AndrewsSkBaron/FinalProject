package org.selenium.pages.tests;

import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.driver.Driver;
import org.selenium.pages.*;
import org.selenium.utils.ListenerEvent;

@ExtendWith(ListenerEvent.class)
public abstract class BaseTest {

    protected WebDriver driver = Driver.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driver, 30);
    protected MainPage mainPage = new MainPage();
    protected MyAccountPage myAccountPage = new MyAccountPage();
    protected RegistrationPage registrationPage = new RegistrationPage();
    protected LogInPage logInPage;
    protected DressesPage dressesPage = new DressesPage();
    protected CartPage cartPage = new CartPage();
    protected WishListPage wishListPage = new WishListPage();
    protected ProductDetailPage productDetailPage = new ProductDetailPage();

    @Before
    @Step("Beginning the action")
    public void create() {
    }

    @After
    @Step("Ending the action")
    public void tearDown() {
        Driver.quit();
    }
}