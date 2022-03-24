package org.selenium.pages.tests;

import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LogInPageTest extends BaseTest {

    @Test
    @Epic(value = "Authorization")
    @Description("Test description: Log in (Sign In))")
    public void checkSignIn() {
        logInPage = mainPage.logIn();
        logInPage.login();
        assertEquals(myAccountPage.getText(), "my account");
        mainPage.logOut();
    }

}
