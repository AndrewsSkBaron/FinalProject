package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage extends BasePage {
    private By buttonSignIn = By.xpath("//a[@Class='login']");
    private By buttonLogOut = By.xpath("//a[@Class='logout']");
    private By customerButton = By.xpath("//a[@class='account']");

    private By categoryDresses = By.xpath("//div[@id='block_top_menu']/ul/li[2]/a");
    private By containerProducts = By.xpath("//ul[@class='product_list grid row']");
    private By cartButton = By.xpath("//a[@title='View my shopping cart']");
    private By waitContainer = By.xpath("//div[@id='center_column']");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LogInPage logIn() {
        wait.until(visibilityOfElementLocated(buttonSignIn));
        driver.findElement(buttonSignIn).click();
        return new LogInPage(driver, wait);
    }

    public LogInPage logOut() {
        driver.findElement(buttonLogOut).click();
        return new LogInPage(driver, wait);
    }

    public ProductsPage goToProducts() {
        driver.findElement(categoryDresses).click();
        wait.until(visibilityOfElementLocated(containerProducts));
        return new ProductsPage(driver, wait);
    }

    public CartPage goToCart() {
        driver.findElement(cartButton).click();
        wait.until(visibilityOfElementLocated(waitContainer));
        return new CartPage(driver, wait);
    }

}
