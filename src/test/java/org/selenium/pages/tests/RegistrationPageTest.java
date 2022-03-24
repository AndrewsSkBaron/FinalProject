package org.selenium.pages.tests;

import io.qameta.allure.Epic;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class RegistrationPageTest extends BaseTest {

    @Test
    @Epic(value = "Authorization")
    @Description("Test description: Create account (Registration)")
    public void checkRegistration() {
        logInPage = mainPage.logIn();
        logInPage.registration();
        registrationPage.createAccount(22, 7, 2003, "Indiana", 21);
        assertEquals(myAccountPage.getText(), "my account");
        mainPage.logOut();
    }
}
