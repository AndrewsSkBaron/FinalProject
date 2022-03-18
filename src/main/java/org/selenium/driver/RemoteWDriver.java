package org.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class RemoteWDriver implements Strategy {
    private static DesiredCapabilities dc;

    @Override
    public WebDriver getWebDriver(String browser) {
        dc = new DesiredCapabilities();
        URL url;

        try {
            url = new URL("http://localhost:4444");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Url failed", e);
        }

        switch (browser) {
            case "chrome" -> {
                dc.setBrowserName("chrome");
                return new RemoteWebDriver(url, dc);
            }
            case "firefox" -> {
                dc.setBrowserName("firefox");
                return new RemoteWebDriver(url, dc);
            }
            default -> throw new RuntimeException("Browser fail:" + browser);
        }
    }
}
