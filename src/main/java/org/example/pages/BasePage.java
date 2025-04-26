package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void selectOption(WebElement element, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select select = new Select(element);
        select.selectByValue(value);
    }

}
