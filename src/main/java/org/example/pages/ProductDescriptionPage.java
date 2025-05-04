package org.example.pages;

import org.example.dto.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDescriptionPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ProductDescriptionPage.class);

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartBtn;

    @FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
    private WebElement itemPrice;

    @FindBy(id = "productTitle")
    private WebElement productName;

    public ProductDescriptionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String returnProductName(){
        log.info("Returning Product Name {}", productName.getText());
        return productName.getText();
    }

    public void addItemToCart() {
        log.info("Adding Item to Cart");
        click(addToCartBtn);
    }

    public String returnItemPrice() {
        log.info("Returning Item Price {}", itemPrice.getText());
        return itemPrice.getText();
    }

    public Product fetchProductDetails() {
        Product product = new Product();
        product.setProductName(returnProductName());
        product.setProductPrice(returnItemPrice());
        return product;
    }
}
