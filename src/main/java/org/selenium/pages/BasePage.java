package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.driver.Driver;
import org.selenium.ojb.DefaultUser;
import org.selenium.ojb.User;
import org.selenium.utils.JsonParser;

public abstract class BasePage {
    protected User user = new JsonParser().readUserFromGson();
    protected DefaultUser defaultUser = new DefaultUser("testReg27@gmail.com", "test070501");
    protected WebDriver driver = Driver.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driver, 30);

    protected boolean isElementPresent(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
