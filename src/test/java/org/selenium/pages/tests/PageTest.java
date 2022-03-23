package org.selenium.pages.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenium.ojb.Product;
import org.selenium.utils.ListenerEvent;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ListenerEvent.class)
public class PageTest extends BaseTest {
    private List<Product> products = new ArrayList<>();
    @BeforeEach
    @Step("Beginning the action")
    public void getStart() {
        mainPage.logIn();
        signIn.login();
        account.goToMyWishList();
    }

    @Test
    @Epic(value = "Cart")
    @Description("Test description: Add product to car")
    public void checkCartAdded() {
        assertEquals(dresses.addToCart(3, products).toString(), cart.getCartList().toString());
    }

    @Test
    @Epic(value = "Cart")
    @Description("Test description: Comparing amount with the total ")
    public void checkCartTotal() {
        dresses.addToCart(3,products);
        cart.getCartList();
        assertEquals(dresses.getTotalPrice(products), cart.getTotalCart());
    }

    @Test
    @Epic(value = "Wishlist automation")
    @Description("Test description: Wishlist was created automatically")
    public void checkAutoCreateNameList() {
        wishList.createListAutomatically();
        product.addInWishList().goToMyAccount();
        assertEquals("my wishlist", wishList.getAutoCreateNameList());
    }

    @Test
    @Epic(value = "Wishlist manual")
    @Description("Test description: Wishlist was created manual")
    public void checkManualCreateNameList() {
        wishList.createListManually();
        product.addInWishList().goToMyAccount();
        assertEquals("test list", wishList.getManualCreateNameList());
    }

    @Test
    @Epic(value = "Wishlist automation")
    @Description("Test description: Wishlist was created automatically and product is in there")
    public void checkAutoCreateList() {
        wishList.createListAutomatically();
        product.addInWishList().goToMyAccount();
        assertEquals(wishList.productAdded().getNameOfProduct(), product.getNameOfProduct());
    }

    @Test
    @Epic(value = "Wishlist manual")
    @Description("Test description: Wishlist was created manual and product is in there")
    public void checkManualCreateList() {
        wishList.createListManually();
        product.addInWishList().goToMyAccount();
        assertEquals(wishList.productAdded().getNameOfProduct(), product.getNameOfProduct());
    }

    @AfterEach
    @Step("Ending the action")
    public void getFinish() {
        mainPage.logOut();
    }
}
