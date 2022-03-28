package org.selenium.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.selenium.ojb.Product;
import org.selenium.pages.MainPage;
import org.selenium.pages.ProductDetailPage;
import org.selenium.pages.ProductsPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageTest extends BaseTest {

    @BeforeEach
    @Step("Beginning the action")
    public void getStart() {
        mainPage = new MainPage(driver, wait);
        productsPage = new ProductsPage(driver,wait);
        productDetailPage = new ProductDetailPage(driver, wait);
        logInPage = mainPage.logIn();
        myAccountPage = logInPage.login();
    }

    @Test
    @Epic(value = "Cart")
    @Description("Test description: Add product to car")
    public void checkCartAdded() {
        productsPage = mainPage.goToProducts();
        String expectedResult = productsPage.addToCart(3).toString();
        cartPage = mainPage.goToCart();
        String actualResult = cartPage.getCartList().toString();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @Epic(value = "Cart")
    @Description("Test description: Comparing amount with the total ")
    public void checkCartTotal() {
        List<Product> products = mainPage.goToProducts().addToCart(3);
        cartPage = mainPage.goToCart();
        cartPage.getCartList();
        assertEquals(productsPage.getTotalPrice(products), cartPage.getTotalPrice());
    }

    @Test
    @Epic(value = "Wishlist automation")
    @Description("Test description: Wishlist was created automatically")
    public void checkAutoCreateListData() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        productDetailPage = myAccountPage.goToMyWishList().createListAuto().choosingProduct().addInWishList();
        String actualResult = productDetailPage.goToMyAccount().goToMyWishList().getDataCreateAutoList();
        String expectedResult = formatter.format(date);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @Epic(value = "Wishlist manual")
    @Description("Test description: Wishlist was created manual")
    public void checkManualCreateNameList() {
        String nameOfList = faker.name().fullName();
        String expectedResult = nameOfList.toLowerCase(Locale.ROOT);
        productDetailPage = myAccountPage.goToMyWishList().createListManually(nameOfList).choosingProduct().addInWishList();
        String actualResult = productDetailPage.goToMyAccount().goToMyWishList().getCreateManualNameList();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @Epic(value = "Wishlist automation")
    @Description("Test description: Wishlist was created automatically and product is in there")
    public void checkAutoCreateList() {
        String expectedResult = myAccountPage.goToMyWishList().createListAuto().choosingProduct().getNameOfProduct();
        String actualResult = productDetailPage.addInWishList().goToMyAccount().goToMyWishList().productAdded().getNameOfProduct();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @Epic(value = "Wishlist manual")
    @Description("Test description: Wishlist was created manual and product is in there")
    public void checkManualCreateList() {
        String nameOfList = faker.name().fullName();
        String expectedResult = myAccountPage.goToMyWishList().createListManually(nameOfList).choosingProduct().getNameOfProduct();
        String actualResult = productDetailPage.addInWishList().goToMyAccount().goToMyWishList().productAdded().getNameOfProduct();
        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    @Step("Ending the action")
    public void getFinish() {
        mainPage.logOut();
    }
}
