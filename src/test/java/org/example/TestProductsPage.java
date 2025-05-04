package org.example;

import org.example.dto.Product;
import org.example.pages.LaunchPage;
import org.example.pages.ProductDescriptionPage;
import org.example.pages.ProductsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductsPage extends BaseTest{
    private static final Logger log = LoggerFactory.getLogger(TestProductsPage.class);

    @Test
    public void selectTheProduct(){

        String brand = "Vendoz";

        //Arrange
        log.info("Setting Up Test Case");
        LaunchPage launchPage = new LaunchPage(driver);
        launchPage.navigateTo("https://www.amazon.in/s?k=shoes+for+girls+stylish");

        //Act
        log.info("Executing Test Case");
        ProductsPage product = new ProductsPage(driver);
        Product productDetailsInProductsPage = product.fetchProductDetails();
        product.selectTheItemLookingFor();

        ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
        Product productDetails = productDescriptionPage.fetchProductDetails();

        //Assert
        Assert.assertTrue(productDetails.getProductName().contains(productDetailsInProductsPage.getProductBrand()), "BrandName not matching");
    }
}
