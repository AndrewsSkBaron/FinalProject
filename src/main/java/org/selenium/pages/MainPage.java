package org.selenium.pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage extends BasePage {
    private By buttonSignIn = By.xpath("//a[normalize-space()='Sign in']");
    private By buttonLogOut = By.xpath("//a[@title='Log me out']");
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
