package org.selenium.pages;

import org.openqa.selenium.By;

import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProductDetailPage extends BasePage {
    private By waitContainer = By.xpath("//div[@class='primary_block row']");
    private By waitPopup = By.xpath("//div[@class='fancybox-overlay fancybox-overlay-fixed']");
    private By buttonAddWish = By.xpath("//a[@id='wishlist_button']");
    private By productName = By.xpath("//h1[@itemprop='name']");
    private By textPopup = By.xpath("//p[@class='fancybox-error']");
    private By closeButton = By.xpath("//a[@title='Close']");
    private By account = By.xpath("//a[@title='View my customer account']");

    public String getNameOfProduct() {
        wait.until(visibilityOfElementLocated(waitContainer));
        String name = driver.findElement(productName).getText().toLowerCase(Locale.ROOT);
        return name;
    }

    public ProductDetailPage addInWishList(){
        driver.findElement(buttonAddWish).click();
        wait.until(visibilityOfElementLocated(waitPopup));
        driver.findElement(closeButton).click();
        return this;
    }

    public WishListPage goToMyAccount() {
        driver.findElement(account).click();
        return new MyAccountPage().goToMyWishList();
    }

}
