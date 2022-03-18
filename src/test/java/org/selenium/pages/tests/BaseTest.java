package org.selenium.pages.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.driver.Driver;
import org.selenium.pages.MainPage;
import org.selenium.pages.MyAccountPage;

public abstract class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static MainPage mainHome;
    protected static MyAccountPage account;

    @BeforeAll
    @Step("Beginning the action")
    public static void setUp() {
        driver = Driver.getInstance().getWebDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @AfterAll
    @Step("End the action")
    public static void tearDown() {
      Driver.quit();
    }

    @BeforeEach
    public void getInit() {
        account = new MyAccountPage();
        mainHome = new MainPage();
        mainHome.userAuthentication();
        account.goToMyWishList();
    }
}