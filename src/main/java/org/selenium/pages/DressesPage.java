package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.selenium.ojb.Product;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class DressesPage extends BasePage {
    private By categoryDresses = By.xpath("//div[@id='block_top_menu']/ul/li[2]/a");
    private By popup = By.xpath("//div[@id='layer_cart']");
    private By continueShop = By.xpath("//span[@title='Continue shopping']");
    private By containerProducts = By.xpath("//ul[@class='product_list grid row']");
    private By products = By.xpath("//ul[@class='product_list grid row']/li");
    private By addToCartButton = By.xpath(".//a[@title='Add to cart']");

    private By productName = By.xpath("//span[@id='layer_cart_product_title']");
    private By productAttribute = By.xpath("//span[@id='layer_cart_product_attributes']");
    private By productPrice = By.xpath("//span[@id='layer_cart_product_price']");

    private List<Product> productList;

    public List<Product> addToCart() {
        driver.findElement(categoryDresses).click();
        wait.until(visibilityOfElementLocated(containerProducts));
        Actions action = new Actions(driver);
        productList = new ArrayList<>();
        for (WebElement item : driver.findElements(products)) {
            if (productList.size() != 3) {
                action.moveToElement(item).click(item.findElement(addToCartButton)).build().perform();
                wait.until(visibilityOfElementLocated(popup));
                String attributes = driver.findElement(productAttribute).getText();
                String name = driver.findElement(productName).getText();
                String color = attributes.substring(attributes.indexOf(""), attributes.indexOf(","));
                String size = attributes.substring(attributes.indexOf(",") + 2);
                String price = driver.findElement(productPrice).getText();
                String priseSub = price.substring(price.indexOf("$") + 1);
                double p = Double.valueOf(priseSub);
                productList.add(new Product(name, color, size, p));
                driver.findElement(continueShop).click();
            }
        }
        return productList;
    }

    public double getTotalPrice() {
        double total = productList.get(0).getPrice() + productList.get(1).getPrice() + productList.get(2).getPrice();
        System.out.println(total);
        return total;
    }
}
