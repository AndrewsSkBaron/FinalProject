package org.selenium.utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.selenium.driver.Driver;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerEvent implements TestWatcher {
    WebDriver driver = Driver.getInstance().getWebDriver();
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.addAttachment("Error", screenShot());
        Allure.addAttachment("Name of a browser", getBrowserName());
        Allure.addAttachment("Date and time:", gerDateAndTime());
        Allure.addAttachment("Platform version:", getPlateFormVersion());
    }

    private ByteArrayInputStream screenShot() {
        return new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }

    protected String getBrowserName() {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        return cap.getBrowserName();
    }

    protected String gerDateAndTime() {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("hh_m_ss");
        return formatDate.format(date);
    }
    protected String getPlateFormVersion() {
        return System.getProperty("os.name");
    }
}
