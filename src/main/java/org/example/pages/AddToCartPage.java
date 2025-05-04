package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddToCartPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(AddToCartPage.class);

    @FindBy(css = "[id='submit.add-to-cart']")
    private WebElement addToCartBtn;

    @FindBy(css = "#NATC_SMART_WAGON_CONF_MSG_SUCCESS h1")
    private WebElement productAddedToCart;

    public AddToCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart() {
        log.info("Adding Item to Cart");
        waitUntil(addToCartBtn);
        click(addToCartBtn);
    }

    public String verifyProductAddToCartStatus(){
        log.info("Verifying Product Added to Cart {}", productAddedToCart.getText());
        return productAddedToCart.getText();
    }
}
