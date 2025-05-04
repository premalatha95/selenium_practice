package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void click(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendKeys(WebElement element, String str){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            element.sendKeys(str);
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void waitUntilListIsVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitUntil(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void switchToActiveTab() {
        String parentWindow = driver.getWindowHandle();

        for (String childWindow : driver.getWindowHandles())
            if (!childWindow.equals(parentWindow))
                driver.switchTo().window(childWindow);
            else
                driver.close();
    }
}