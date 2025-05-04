package org.example;

import org.example.dto.Product;
import org.example.pages.LaunchPage;
import org.example.pages.ProductDescriptionPage;
import org.example.pages.ProductsPage;
import org.example.pages.SearchPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchPage extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(TestSearchPage.class);

    @Test
    public void verifySearchFunctionality() {
        // Arrange
        log.info("Setting Up Test Case");
        String productName = "shoes for girls";
        LaunchPage launchPage = new LaunchPage(driver);
        launchPage.navigateTo("https://www.amazon.in/");


        // Act
        log.info("Executing Test Case");
        SearchPage search = new SearchPage(driver);
        ProductsPage productsPage = search.searchForTheProduct(productName);
        String firstOption = search.fetchSearchResults();

        // Assert
        log.info("Validating Test Case");
        Assert.assertTrue(firstOption.contains(productName), "Received Invalid Autocomplete Suggestion");
    }
}
