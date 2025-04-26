package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class SearchPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SearchPage.class);

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchIcon;

    @FindBy(css = ".nav-fill #twotabsearchtextbox")
    private WebElement searchTextField;

    @FindBy(css = "#sac-autocomplete-results-container .s-suggestion-ellipsis-direction")
    private List<WebElement> autocompleteSuggestions;

    @FindBy(xpath = "(//img[@class='s-image'])[5]")
    private WebElement itemToBeSearched;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchForTheProduct(String productName) {
        log.info("Searching for productName: {}", productName);
        sendKeys(searchTextField, productName);
        log.info("Searching for productList");
    }

    public String fetchSearchResults() {
        String firstSuggestion;
        try {
            waitUntil(autocompleteSuggestions);
            firstSuggestion = autocompleteSuggestions.get(0)
                    .getDomAttribute("aria-label");
        } catch (StaleElementReferenceException e) {
            log.info("Retrying to find search results");
            driver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(2));
            List<WebElement> searchResults = driver.findElements(By.cssSelector("#sac-autocomplete-results-container .s-suggestion-ellipsis-direction"));
            firstSuggestion = searchResults.get(0)
                    .getDomAttribute("aria-label");
        }
        log.info("productName: {}", firstSuggestion);
        return firstSuggestion;
    }
}

