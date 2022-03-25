package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.utils.JsonParser;

public class LogInPage extends BasePage {
    private By emailSignIn = By.xpath("//input[@id='email']");
    private By passSignIn = By.xpath("//input[@id='passwd']");
    private By buttonSignIn = By.xpath("//button[@id='SubmitLogin']");
    private By inputToCreateAccount = By.xpath("//input[@id='email_create']");
    private By buttonCreateAccount = By.xpath("//button[@id='SubmitCreate']");
    private By errorAvailableMail = By.xpath("//div[@id='create_account_error']//li");

    public LogInPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public MyAccountPage login() {
        driver.findElement(emailSignIn).sendKeys(defaultUser.getEmail());
        driver.findElement(passSignIn).sendKeys(defaultUser.getPassword());
        driver.findElement(buttonSignIn).click();
        return new MyAccountPage(driver, wait);
    }

    public RegistrationPage registration() {
        super.user = new JsonParser().createJson();
        driver.findElement(inputToCreateAccount).sendKeys(user.getEmail());
        driver.findElement(buttonCreateAccount).click();
        return new RegistrationPage(driver, wait);
    }

}
