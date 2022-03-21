package org.selenium.driver;

import org.openqa.selenium.WebDriver;

public interface Strategy {
    WebDriver getWebDriver(String browser);
}
