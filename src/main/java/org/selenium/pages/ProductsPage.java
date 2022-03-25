package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.ojb.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProductsPage extends BasePage {
    private By popup = By.xpath("//div[@id='layer_cart']");
    private By continueShop = By.xpath("//span[@title='Continue shopping']");
    private By products = By.xpath("//ul[@class='product_list grid row']/li");
    private By addToCartButton = By.xpath(".//a[@title='Add to cart']");

    private By productName = By.xpath("//span[@id='layer_cart_product_title']");
    private By productAttribute = By.xpath("//span[@id='layer_cart_product_attributes']");
    private By productPrice = By.xpath("//span[@id='layer_cart_product_price']");

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public List<Product> addToCart(int count) {
        Actions action = new Actions(driver);
        List<Product> products = new ArrayList<>(count);
        List<WebElement> elements = driver.findElements(this.products);
        for (int i = 0; i < count; i++) {
            WebElement item = elements.get(i);
            action.moveToElement(item).click(item.findElement(addToCartButton)).build().perform();
            wait.until(visibilityOfElementLocated(popup));
            String attributes = driver.findElement(productAttribute).getText();
            String name = driver.findElement(productName).getText();
            String color = attributes.substring(attributes.indexOf(""), attributes.indexOf(","));
            String size = attributes.substring(attributes.indexOf(",") + 2);
            String price = driver.findElement(productPrice).getText();
            String priseSub = price.substring(price.indexOf("$") + 1);
            double p = Double.valueOf(priseSub);
            products.add(new Product(name, color, size, p));
            driver.findElement(continueShop).click();
        }
        return products;
    }

    public double getTotalPrice(List<Product> products) {
        DecimalFormat df = new DecimalFormat("#.##");
        double total = 0;
        for(Product product : products) {
            total += product.getPrice();
        }
        return Double.parseDouble(df.format(total).replace("," , "."));
    }
}
