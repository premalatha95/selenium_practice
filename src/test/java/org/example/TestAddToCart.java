package org.example;

//import org.example.dto.Product;
import org.example.pages.AddToCartPage;
import org.example.pages.LaunchPage;
//import org.example.pages.ProductDescriptionPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddToCart extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TestAddToCart.class);

    @Test
    public void verifyAddToCart() {
        // Arrange
        log.info("Setting Up Test Case");
        LaunchPage launchPage = new LaunchPage(driver);
        launchPage.navigateTo("https://www.amazon.in/ASIAN-AROMA-03-Running-Lightweight-Comfortable/dp/B0DRYKS4Y9");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Act
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        log.info("Calling addItemToCart method");
        addToCartPage.addItemToCart();
        log.info("Calling verifyProductAddToCartStatus method");
        String productAddToCartStatus = addToCartPage.verifyProductAddToCartStatus();

        // Assert
        log.info("Validating Test Case");
        Assert.assertTrue(productAddToCartStatus.contains("Added to cart"), "Product Not Added to Cart");
    }
}
