package org.selenium.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalWebDriver implements WebDriverStrategy {

    @Override
    public WebDriver getWebDriver(String browser) {
        String path = "src/main/resources/drivers/";
        String gecko = "webdriver.gecko.driver";
        String chrome = "webdriver.chrome.driver";
        switch (browser) {
            case "chrome" -> {
                System.setProperty(chrome, path + "chromedriver.exe");
                return new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty(gecko, path + "geckodriver.exe");
               return new FirefoxDriver();
            }
            default -> throw new RuntimeException("Browser fail:" + browser);
        }

    }
}
