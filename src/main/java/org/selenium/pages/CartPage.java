package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.ojb.Product;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CartPage extends BasePage {
    private By cartButton = By.xpath("//a[@title='View my shopping cart']");
    private By waitContainer = By.xpath("//div[@id='center_column']");
    private By cartTotal = By.xpath("//span[@id='total_price']");
    private By rows = By.xpath("//table/tbody/tr");
    private List<Product> cartList;

    public List<Product> getCartList() {
        driver.findElement(cartButton).click();
        wait.until(visibilityOfElementLocated(waitContainer));
        cartList = new ArrayList<>();
        for (WebElement row : driver.findElements(rows)) {
            String attribute = row.findElement(By.xpath("./td[2]/small/a")).getText();
            String name = row.findElement(By.xpath("./td[2]//p/a")).getText();
            String color = attribute.substring(attribute.indexOf("Color : ") + 8, attribute.indexOf(","));
            String size = attribute.substring(attribute.indexOf("Size : ") + 7);
            String price = row.findElement(By.xpath("./td[6]")).getText();
            String priseSub = price.substring(price.indexOf("$") + 1);
            double p = Double.valueOf(priseSub);
            cartList.add(new Product(name, color, size, p));
        }
        return cartList;
    }

    public double getTotalCart() {
        String value = driver.findElement(cartTotal).getText();
        String valueSub = value.substring(value.indexOf("$") + 1);
        double v = Double.valueOf(valueSub);
        return v;
    }
}
