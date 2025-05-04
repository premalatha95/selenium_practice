package org.example.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class DriverProvider {
    private static final Logger log = LoggerFactory.getLogger(DriverProvider.class);
    private WebDriver driver;

    public DriverProvider() {
        initDriver();
    }

    public void initDriver(){
        try {
            String browser = System.getProperty("browser", "firefox");
            log.info("Browser Property Value {}", browser);

            switch (browser.toLowerCase()){
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    log.info("Initializing ChromeDriver");
                }
                case "firefox" -> {
//                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    log.info("Initializing FirefoxDriver");
                }
                case "safari" -> {
                    driver = new SafariDriver();
                    log.info("Initializing SafariDriver");
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    log.info("Incompatible browser type initializing default ChromeDriver");
                }
            }
            
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            log.info("Browser window maximized and implicit wait set");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
