package org.selenium.pages.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.selenium.utils.ListenerEvent;

import static org.junit.Assert.assertEquals;

@ExtendWith(ListenerEvent.class)
public class RegistrationPageTest extends BaseTest {
    @BeforeEach
    @Step("Beginning the action")
    public void getStart() {
        mainPage.logIn();
        signIn.registration();
    }

    @Test
    @Epic(value = "Authorization")
    @Description("Test description: Create account (Registration)")
    public void checkRegistration() {
        registration.createAccount(22,7,2003,"Indiana",21);
        assertEquals(account.getText(), "my account");
    }


    @AfterEach
    @Step("Ending the action")
    public void getFinish() {
        mainPage.logOut();
    }
}
