package org.selenium.driver;

import org.openqa.selenium.WebDriver;

public interface Strategy {
    String path = "src/main/resources/drivers/";
    String gecko = "webdriver.gecko.driver";
    String chrome = "webdriver.chrome.driver";
    WebDriver getWebDriver(String browser);
}
