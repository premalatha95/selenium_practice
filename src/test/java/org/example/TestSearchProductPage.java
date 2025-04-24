package org.example;

import org.example.dto.Item;
import org.example.pageObjects.SearchPage;
import org.example.pageObjects.LauncherPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSearchProductPage extends BaseTest {

    @Test
    public void verifyIfSearchTermShowsRelevantResults() {
        //Arrange
        String searchItem = "Jeans";
        String searchKey = "Jean";

        LauncherPage launcherPage = new LauncherPage(driver);
        launcherPage.navigateTo("https://web-playground.ultralesson.com/");

        //Act
        SearchPage homepage = new SearchPage(driver);
        List<Item> searchItems = homepage.searchProducts(searchItem);

        //Assert
        Assert.assertEquals(searchItems.size(), 5, "Size Mismatch");
        Assert.assertTrue(searchItems.stream().allMatch(x -> x.getName().contains(searchKey)), "Search Result Contains different item");
    }
}


