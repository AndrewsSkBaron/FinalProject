package org.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class SauceLabWebDriver implements Strategy{

    @Override
    public WebDriver getWebDriver(String browser) {
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", System.getenv("andreibaron"));
        sauceOptions.put("accessKey", System.getenv("f57e9fb8-f162-4a6b-8fd1-f5f065e8417f"));
        sauceOptions.put("screenResolution", "1920x1080");
        URL url;

        try {
            url = new URL("https://andreibaron:f57e9fb8-f162-4a6b-8fd1-f5f065e8417f@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Url failed", e);
        }

        switch (browser) {
            case "chrome" -> {
                ChromeOptions option = new ChromeOptions();
                option.setPlatformName("macOS 12");
                option.setBrowserVersion("15");
                option.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(url, option);
            }
            case "firefox" -> {
                FirefoxOptions option = new FirefoxOptions();
                option.setPlatformName("Windows 10");
                option.setBrowserVersion("latest");
                option.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(url, option);
            }
            default -> throw new RuntimeException("Browser fail:" + browser);
        }
    }
}
