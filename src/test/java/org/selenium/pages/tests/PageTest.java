package org.selenium.pages.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenium.pages.CartPage;
import org.selenium.pages.DressesPage;
import org.selenium.pages.ProductDetailPage;
import org.selenium.pages.WishListPage;
import org.selenium.utils.ListenerEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ListenerEvent.class)
public class PageTest extends BaseTest {
    private DressesPage dresses;
    private CartPage cart;
    private WishListPage wishList;
    private ProductDetailPage product;

    @Test
    @Epic(value = "Authorization")
    @Description("Test description: Create account (Registration)")
    public void checkRegistration() {
        assertEquals(account.getTitleExpected(), account.getTitleActual());
    }

    @Test
    @Epic(value = "Authorization")
    @Description("Test description: Log in (Sign In))")
    public void checkSignIn() {
        assertEquals(account.getTitleExpected(), account.getTitleActual());
    }

    @Test
    @Epic(value = "Cart")
    @Description("Test description: Add product to car")
    public void checkCartAdded() {
        dresses = new DressesPage();
        cart = new CartPage();
        assertEquals(dresses.addToCart().toString(), cart.getCartList().toString());
    }

    @Test
    @Epic(value = "Cart")
    @Description("Test description: Comparing amount with the total ")
    public void checkCartTotal() {
        dresses = new DressesPage();
        cart = new CartPage();
        dresses.addToCart();
        cart.getCartList();
        assertEquals(dresses.getTotalPrice(), cart.getTotalCart());
    }

    @Test
    @Epic(value = "Wishlist automation")
    @Description("Test description: Wishlist was created automatically")
    public void checkAutoCreateNameList() {
        wishList = new WishListPage();
        product = new ProductDetailPage();
        wishList.createListAutomatically();
        product.addInWishList().goToMyAccount();
        assertEquals(wishList.getAutoCreateNameListExpected(), wishList.getAutoCreateNameListActual());
    }

    @Test
    @Epic(value = "Wishlist manual")
    @Description("Test description: Wishlist was created manual")
    public void checkManualCreateNameList() {
        wishList = new WishListPage();
        product = new ProductDetailPage();
        wishList.createListManually();
        product.addInWishList().goToMyAccount();
        assertEquals(wishList.getManualCreateNameListExpected(), wishList.getManualCreateNameListActual());
    }

    @Test
    @Epic(value = "Wishlist automation")
    @Description("Test description: Wishlist was created automatically and product is in there")
    public void checkAutoCreateList() {
        wishList = new WishListPage();
        product = new ProductDetailPage();
        wishList.createListAutomatically();
        product.addInWishList().goToMyAccount();
        assertEquals(wishList.productAdded().getNameOfProductExpected(), product.getNameOfProductActual());
    }

    @Test
    @Epic(value = "Wishlist manual")
    @Description("Test description: Wishlist was created manual and product is in there")
    public void checkManualCreateList() {
        wishList = new WishListPage();
        product = new ProductDetailPage();
        wishList.createListManually();
        product.addInWishList().goToMyAccount();
        assertEquals(wishList.productAdded().getNameOfProductExpected(), product.getNameOfProductActual());
    }
}
