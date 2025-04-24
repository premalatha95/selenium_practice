package org.example.pageObjects;

import org.example.dto.Item;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SearchPage.class);
    private static final Duration SEARCH_TIMEOUT = Duration.ofSeconds(15);

    @FindBy(css = ".header__icon .icon.icon-search")
    private WebElement searchIcon;

    @FindBy(css = "#Search-In-Modal")
    private WebElement searchTextField;

    @FindBy(css = "#predictive-search-results-list li")
    private List<WebElement> searchResults;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<Item> searchProducts(String product) {
        try {
            log.info("Searching for product: {}", product);
            // Wait for search icon and click
            WebDriverWait wait = new WebDriverWait(driver, SEARCH_TIMEOUT);
            wait.until(ExpectedConditions.elementToBeClickable(searchIcon));
            searchIcon.click();
            
            // Wait for search field and enter text
            wait.until(ExpectedConditions.visibilityOf(searchTextField));
            searchTextField.clear();
            searchTextField.sendKeys(product);
            
            // Wait for results
            wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
            
            List<Item> items = new ArrayList<>();
            for (WebElement searchResult : searchResults) {
                Item item = new Item();
                item.setName(searchResult.getText());
                items.add(item);
            }
            
            log.info("Found {} items", items.size());
            return items;
        } catch (Exception e) {
            log.error("Error in searchAndGetItems: {}", e.getMessage());
            throw e;
        }
    }
}
