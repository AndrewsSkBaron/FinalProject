package org.selenium.pages;

import org.openqa.selenium.By;

import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MyAccountPage extends BasePage{ ;
    private By breadcrumb = By.xpath("//a[normalize-space()='My account']");
    private By buttonWish = By.xpath("//a[@title='My wishlists']");

    public String getBreadcrumbText() {
        String text = driver.findElement(breadcrumb).getText().toLowerCase(Locale.ROOT);
        return text;
    }

    public WishListPage goToMyWishList() {
        wait.until(visibilityOfElementLocated(breadcrumb));
        driver.findElement(buttonWish).click();
        return new WishListPage();
    }

}
