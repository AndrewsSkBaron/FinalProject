package org.selenium.pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage extends BasePage {
    private By buttonSignIn = By.xpath("//a[@Class='login']");
    private By buttonLogOut = By.xpath("//a[@Class='logout']");
    private By customerButton = By.xpath("//a[@class='account']");

    public LogInPage logIn() {
        wait.until(visibilityOfElementLocated(buttonSignIn));
        driver.findElement(buttonSignIn).click();
        return new LogInPage();
    }

    public LogInPage logOut() {
        driver.findElement(buttonLogOut).click();
        return new LogInPage();
    }

}
