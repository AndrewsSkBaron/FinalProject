package org.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class WishListPage extends BasePage {
    private Random random = new Random();
    private Alert alert;
    private By table = By.xpath("//div[@id='block-history']");
    private By name = By.xpath("//tr/td[1]/a");
    private By buttonDelete = By.xpath("//a[@class='icon']");
    private By topSellersList = By.xpath("//a[@class='product-name']");
    private By nameList = By.xpath("//input[@id='name']");
    private By saveButton = By.xpath("//button[@id='submitWishlist']");
    private By productContainer = By.xpath("//ul[@class='row wlp_bought_list']");
    private By productName = By.xpath("//a[@title='Product detail']");

    public WishListPage createListAutomatically() {
        if (isElementPresent(table) == true) {
            driver.findElement(buttonDelete).click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        }
        return this;
    }

    public WishListPage createListManually(String name) {
        if (isElementPresent(table) == true) {
            driver.findElement(buttonDelete).click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        }
        driver.findElement(nameList).sendKeys(name);
        driver.findElement(saveButton).click();
        return this;
    }

    public ProductDetailPage choosingProduct() {
        int size = driver.findElements(topSellersList).size();
        int randomNumber = random.nextInt(1,size);
        driver.findElements(topSellersList).get(randomNumber).click();
        return new ProductDetailPage();
    }

    public ProductDetailPage productAdded(){
        driver.findElement(name).click();
        wait.until(visibilityOfElementLocated(productContainer));
        driver.findElement(productName).click();
        return new ProductDetailPage();
    }

    public String getCreateNameList() {
        return driver.findElement(name).getText().toLowerCase(Locale.ROOT);
    }

}
