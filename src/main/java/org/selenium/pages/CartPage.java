package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.ojb.Product;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private By cartTotal = By.xpath("//td[@id='total_product']");
    private By rows = By.xpath("//table/tbody/tr");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public List<Product> getCartList() {
        List<Product> cartList = new ArrayList<>();
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

    public double getTotalPrice() {
        String value = driver.findElement(cartTotal).getText();
        String valueSub = value.substring(value.indexOf("$") + 1);
        double v = Double.valueOf(valueSub);
        return v;
    }
}
