package org.example;

import org.example.dto.Product;
import org.example.pages.LaunchPage;
import org.example.pages.ProductDescriptionPage;
import org.example.pages.ProductsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductDescriptionPage extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(TestProductDescriptionPage.class);

    @Test
    public void verifyProductsDetails() {
        // Arrange
        log.info("Setting Up Test Case");
        LaunchPage launchPage = new LaunchPage(driver);
        launchPage.navigateTo("https://www.amazon.in/s?k=shoes+for+girls/");

        // Act
        log.info("Executing Test Case");
        ProductsPage productsPage = new ProductsPage(driver);
        Product expectedProductDetails = productsPage.fetchProductDetails();
        productsPage.selectTheItemLookingFor();

        ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
        Product productDetailsInDescriptionPage = productDescriptionPage.fetchProductDetails();
        log.info("Validating Test Case");
        Assert.assertTrue(expectedProductDetails.getProductName().contains(productDetailsInDescriptionPage.getProductName()), "Product name is mismatched");
        Assert.assertTrue(expectedProductDetails.getProductPrice().contains(productDetailsInDescriptionPage.getProductPrice()), "Product price is mismatched");

    }
}