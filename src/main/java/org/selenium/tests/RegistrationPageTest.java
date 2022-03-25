package org.selenium.tests;

import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RegistrationPageTest extends BaseTest {

    @Test
    @Epic(value = "Authorization")
    @Description("Test description: Create account (Registration)")
    public void checkRegistration() {
        logInPage = mainPage.logIn();
        logInPage.registration();
        registrationPage.createAccount(22, 7, 2003, "Indiana", 21);
        Assert.assertEquals(myAccountPage.getText(), "my account");
        mainPage.logOut();
    }
}
