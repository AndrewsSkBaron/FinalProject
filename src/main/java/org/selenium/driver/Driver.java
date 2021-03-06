package org.selenium.driver;
import org.openqa.selenium.WebDriver;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver webDriver;

    private Driver() {
    }

    public static WebDriver getInstance() {
        String browserName = System.getProperty("browser", "chrome");
        String typeDriver = System.getProperty("type", "local");
        if (webDriver == null) {
            WebDriverStrategy driverStrategy;
            switch (typeDriver.toLowerCase(Locale.ROOT)) {
                case "local" -> driverStrategy = new LocalWebDriver();
                case "remote" -> driverStrategy = new RemoteWDriver();
                case "sauceLab" -> driverStrategy = new SauceLabWebDriver();
                default -> throw new RuntimeException("Driver type fail: " + typeDriver);
            }
            webDriver = driverStrategy.getWebDriver(browserName);
            Objects.requireNonNull(webDriver).manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.get("http://automationpractice.com/index.php");
        }
        return webDriver;
    }

    public static void quit() {
        webDriver.quit();
        webDriver = null;
    }

}
