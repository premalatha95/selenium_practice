package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    protected WebDriver driver;
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(WebElement element) {
        try {
            waitForElementTobeClickable(element);
            element.click();
        } catch (Exception e) {
            log.error("Error clicking element: {}", e.getMessage());
            throw e;
        }
    }

    protected void waitForVisibilityOf(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            log.error("Error waiting for element visibility: {}", e.getMessage());
            throw e;
        }
    }

    protected void waitForElementTobeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            log.error("Error waiting for element to be clickable: {}", e.getMessage());
            throw e;
        }
    }

    protected void sendKeys(WebElement element, String text) {
        try {
            waitForVisibilityOf(element);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            log.error("Error sending keys to element: {}", e.getMessage());
            throw e;
        }
    }
}
