package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverProvider {
    private static final Logger log = LoggerFactory.getLogger(DriverProvider.class);
    private WebDriver driver;

    public DriverProvider() {
        initDriver();
    }

    public void initDriver() {
        String browser = System.getProperty("browser");
        log.info("Browser property value: {}", browser);

        switch (browser.toLowerCase()) {
            case "chrome" -> {
                log.info("Initializing ChromeDriver");
                driver = new ChromeDriver();
            }

            case "firefox" -> {
                log.info("Initializing FirefoxDriver");
                driver = new FirefoxDriver();
            }

            case "safari" -> {
                log.info("Initializing SafariDriver");
                driver = new SafariDriver();
            }

            default -> {
                log.warn("Browser '{}' not supported, defaulting to Chrome", browser);
                driver = new ChromeDriver();
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
