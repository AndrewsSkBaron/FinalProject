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
public class LogInPageTest extends BaseTest {
    @BeforeEach
    @Step("Beginning the action")
    public void getStart() {
        mainPage.logIn();
    }

    @Test
    @Epic(value = "Authorization")
    @Description("Test description: Log in (Sign In))")
    public void checkSignIn() {
        signIn.login();
        assertEquals(account.getText(), "my account");
    }

    @AfterEach
    @Step("Ending the action")
    public void getFinish() {
        mainPage.logOut();
    }
}
