package org.selenium.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver webDriver;
    private static String browserName = "chrome";
    private static String typeDriver = "local";
//   private String typeDriver = "remote";
//   private String driverType = "sauceLab";

    private Driver() {
    }

    public static WebDriver getInstance() {
        if (webDriver == null) {
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
        return webDriver;
    }

    public static void quit() {
        webDriver.quit();
        webDriver = null;
    }

}
