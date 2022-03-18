package org.selenium.driver;
import org.openqa.selenium.WebDriver;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static Driver driver;
    private static WebDriver webDriver;
    String browserName = "chrome";
    String typeDriver = "local";
//    String typeDriver = "remote";
//    String driverType = "sauceLab";

    private Driver() {
        Strategy driverStrategy;
        switch (typeDriver.toLowerCase(Locale.ROOT)) {
            case "local" -> driverStrategy = new LocalWebDriver();
            case "remote" -> driverStrategy = new RemoteWDriver();
            case "sauceLab" -> driverStrategy = new SauceLabWebDriver();
            default -> throw new RuntimeException("Driver type fail: " + browserName);
        }

        webDriver = driverStrategy.getWebDriver(browserName);
        Objects.requireNonNull(webDriver).manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://automationpractice.com/index.php");
    }


    public static Driver getInstance() {
        if (driver == null) {
            driver = new Driver();
        }
        return driver;
    }

    public static void quit() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
