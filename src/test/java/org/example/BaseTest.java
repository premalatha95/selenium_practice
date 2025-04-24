package org.example;

import org.example.driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

   @BeforeTest
   public void getDriver() {
       driver = new DriverProvider().getDriver();
   }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

