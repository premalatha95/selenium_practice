package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(SearchPage.class);

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchIcon;

    @FindBy(css = ".nav-fill #twotabsearchtextbox")
    private WebElement searchTextField;

    @FindBy(className = "left-pane-results-container")
    private  WebElement resultList;

    @FindBy(css = ".s-suggestion.s-suggestion-ellipsis-direction")
    private WebElement firstProduct;

    @FindBy(id = "a-autoid-1-announce")
    private WebElement addToCart;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchForTheProduct(String product) {
        log.info("Searching for product: {}", product);
        sendKeys(searchTextField, product);
        click(firstProduct);
        click(addToCart);
    }
}
