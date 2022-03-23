package org.selenium.driver;

import org.openqa.selenium.WebDriver;

public interface WebDriverStrategy {
    WebDriver getWebDriver(String browser);
}
