package org.selenium.pages;

import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage extends BasePage {
    private By buttonSignIn = By.xpath("//a[normalize-space()='Sign in']");
    private By waitTitle = By.xpath("//a[normalize-space()='Sign in']");
    private By buttonLogOut = By.xpath("//a[@title='Log me out']");
    private By customerButton = By.xpath("//a[@class='account']");
    public MyAccountPage userAuthentication() {
        if(isElementPresent(customerButton) == false) {
            wait.until(visibilityOfElementLocated(waitTitle));
            driver.findElement(buttonSignIn).click();
        } else {
            driver.findElement(buttonLogOut).click();
            driver.findElement(buttonSignIn).click();
        }
        return new LogInPage().authentication();
    }
}
