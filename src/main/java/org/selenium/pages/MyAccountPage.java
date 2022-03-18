package org.selenium.pages;

import org.openqa.selenium.By;

import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MyAccountPage extends BasePage{ ;
    private By waitContainer = By.xpath("//div[@id='columns']");
    private By title = By.xpath("//h1[@class='page-heading']");
    private By buttonWish = By.xpath("//a[@title='My wishlists']");

    public String getTitleExpected() {
        wait.until(visibilityOfElementLocated(waitContainer));
        String text = driver.findElement(title).getText().toLowerCase(Locale.ROOT);
        return text;
    }

    public String getTitleActual() {
        wait.until(visibilityOfElementLocated(waitContainer));
        String text = driver.findElement(title).getText().toLowerCase(Locale.ROOT);
        return text;
    }

    public WishListPage goToMyWishList() {
        wait.until(visibilityOfElementLocated(waitContainer));
        driver.findElement(buttonWish).click();
        return new WishListPage();
    }

}
