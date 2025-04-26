package org.example;

import org.example.Driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new DriverProvider().getDriver();
    }

    @AfterMethod
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
