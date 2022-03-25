package org.selenium.tests;

import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class LogInPageTest extends BaseTest {

    @Test
    @Epic(value = "Authorization")
    @Description("Test description: Log in (Sign In))")
    public void checkSignIn() {
        logInPage = mainPage.logIn();
        logInPage.login();
        Assert.assertEquals(myAccountPage.getText(), "my account");
        mainPage.logOut();
    }

}
