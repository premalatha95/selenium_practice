package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LaunchPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(LaunchPage.class);

    public LaunchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(String url) {
        log.info("Navigating to URL: {}", url);
        driver.get(url);
        
        log.info("Waiting for page to load completely");
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
            (ExpectedCondition<Boolean>) wd ->
                ((org.openqa.selenium.JavascriptExecutor) wd)
                    .executeScript("return document.readyState")
                    .equals("complete")
        );
        
        log.info("Page loaded successfully");
    }
}
