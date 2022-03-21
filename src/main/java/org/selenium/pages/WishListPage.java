package org.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    private By topSellersList = By.xpath("//ul[@class='block_content products-block']");
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
        choosingProduct();
        return this;
    }

    public WishListPage createListManually() {
        if (isElementPresent(table) == true) {
            driver.findElement(buttonDelete).click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        }
        driver.findElement(nameList).sendKeys("Test List");
        driver.findElement(saveButton).click();
        choosingProduct();
        return this;
    }

    public ProductDetailPage choosingProduct() {
        int size = 7;
        int penultimate = random.nextInt(size);
        int last = (penultimate + 2 + random.nextInt(size - 1)) % size;
        int randomNumber = (penultimate + 3 + random.nextInt(size - 1)) % size;
        for (WebElement product : driver.findElements(topSellersList)) {
            if (randomNumber == last) {
                randomNumber = (penultimate + size - 1) % size;
            } else if(randomNumber == 0) {
                randomNumber = 1;
            }
            penultimate = last;
            last = randomNumber;
            product.findElement(By.xpath("./li["+randomNumber+"]/a")).click();
        }
        return new ProductDetailPage();
    }

    public ProductDetailPage productAdded(){
        driver.findElement(name).click();
        wait.until(visibilityOfElementLocated(productContainer));
        driver.findElement(productName).click();
        return new ProductDetailPage();
    }

    public String getAutoCreateNameList() {
        return driver.findElement(name).getText().toLowerCase(Locale.ROOT);
    }

    public String getManualCreateNameList() {
        return driver.findElement(name).getText().toLowerCase(Locale.ROOT);
    }

}
