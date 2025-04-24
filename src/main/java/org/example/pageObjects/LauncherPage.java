package org.example.pageObjects;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LauncherPage extends BasePage {

    public LauncherPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
