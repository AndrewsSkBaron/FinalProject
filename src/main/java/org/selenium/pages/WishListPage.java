package org.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WishListPage extends BasePage {
    private Random random = new Random();
    private Alert alert;
    private By table = By.xpath("//div[@id='block-history']");
    private By name = By.xpath("//tr/td[1]/a");
    private By data = By.xpath("//tr/td[4]");
    private By buttonDelete = By.xpath("//a[@class='icon']");
    private By topSellersList = By.xpath("//a[@class='product-name']");
    private By nameList = By.xpath("//input[@id='name']");
    private By saveButton = By.xpath("//button[@id='submitWishlist']");
    private By productContainer = By.xpath("//ul[@class='row wlp_bought_list']");
    private By productName = By.xpath("//a[@title='Product detail']");

    public WishListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void deleteWishList() {
        if (isElementPresent(table) == true) {
            driver.findElement(buttonDelete).click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        }
    }

    public WishListPage createListAuto() {
        deleteWishList();
        return this;
    }

    public WishListPage createListManually(String name) {
        deleteWishList();
        driver.findElement(nameList).sendKeys(name);
        driver.findElement(saveButton).click();
        return this;
    }

    public ProductDetailPage choosingProduct() {
        int size = driver.findElements(topSellersList).size();
        int randomNumber = random.nextInt(1,size);
        driver.findElements(topSellersList).get(randomNumber).click();
        return new ProductDetailPage(driver, wait);
    }

    public ProductDetailPage productAdded(){
        driver.findElement(name).click();
        wait.until(visibilityOfElementLocated(productContainer));
        driver.findElement(productName).click();
        return new ProductDetailPage(driver, wait);
    }

    public String getCreateManualNameList() {
        return driver.findElement(name).getText().toLowerCase(Locale.ROOT);
    }

    public String getDataCreateAutoList() {
        String dataStr = driver.findElement(data).getText();
        return dataStr;
    }
}
