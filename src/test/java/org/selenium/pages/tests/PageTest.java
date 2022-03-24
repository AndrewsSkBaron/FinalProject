package org.selenium.pages.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.selenium.ojb.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageTest extends BaseTest {

    @BeforeEach
    @Step("Beginning the action")
    public void getStart() {
        logInPage = mainPage.logIn();
        logInPage.login();
        myAccountPage.goToMyWishList();
    }

    @Test
    @Epic(value = "Cart")
    @Description("Test description: Add product to car")
    public void checkCartAdded() {
        assertEquals(dressesPage.addToCart(3).toString(), cartPage.getCartList().toString());
    }

    @Test
    @Epic(value = "Cart")
    @Description("Test description: Comparing amount with the total ")
    public void checkCartTotal() {
        List<Product> products = dressesPage.addToCart(3);
        cartPage.getCartList();
        assertEquals(dressesPage.getTotalPrice(products), cartPage.getTotalCart());
    }

    @Test
    @Epic(value = "Wishlist automation")
    @Description("Test description: Wishlist was created automatically")
    public void checkAutoCreateNameList() {
        wishListPage.createListAutomatically().choosingProduct();
        productDetailPage.addInWishList().goToMyAccount().goToMyWishList();
        assertEquals("my wishlist", wishListPage.getCreateNameList());
    }

    @Test
    @Epic(value = "Wishlist manual")
    @Description("Test description: Wishlist was created manual")
    public void checkManualCreateNameList() {
        wishListPage.createListManually("Test List").choosingProduct();
        productDetailPage.addInWishList().goToMyAccount().goToMyWishList();
        assertEquals("test list", wishListPage.getCreateNameList());
    }

    @Test
    @Epic(value = "Wishlist automation")
    @Description("Test description: Wishlist was created automatically and product is in there")
    public void checkAutoCreateList() {
        wishListPage.createListAutomatically().choosingProduct();
        productDetailPage.addInWishList().goToMyAccount().goToMyWishList();
        assertEquals(wishListPage.productAdded().getNameOfProduct(), productDetailPage.getNameOfProduct());
    }

    @Test
    @Epic(value = "Wishlist manual")
    @Description("Test description: Wishlist was created manual and product is in there")
    public void checkManualCreateList() {
        wishListPage.createListManually("Test List").choosingProduct();
        productDetailPage.addInWishList().goToMyAccount().goToMyWishList();
        assertEquals(wishListPage.productAdded().getNameOfProduct(), productDetailPage.getNameOfProduct());
    }

    @AfterEach
    @Step("Ending the action")
    public void getFinish() {
        mainPage.logOut();
    }
}
