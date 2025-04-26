package org.example;

import org.example.pages.LaunchPage;
import org.example.pages.SearchPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestSearchPage extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(TestSearchPage.class);

    @Test
    public void verifySearchFunctionality() {

        String product = "Shoes";

        LaunchPage launchPage = new LaunchPage(driver);
        launchPage.navigateTo("https://www.amazon.in/");

        SearchPage search = new SearchPage(driver);
        search.searchForTheProduct(product);
    }
}
