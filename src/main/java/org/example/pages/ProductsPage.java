package org.example.pages;

import org.example.dto.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductsPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ProductsPage.class);

    @FindBy(id = "a-autoid-1-announce")
    private WebElement addToCartBtn;

    @FindBy(className = "a-price-whole")
    private List<WebElement> itemPrice;

    @FindBy(css = "[data-component-type=\"s-product-image\"] .a-section .s-image")
    private List<WebElement> itemToBeClicked;

    @FindBy(css = "[data-cy='title-recipe'] .a-row h2")
    private List<WebElement> brandNames;

    @FindBy(css = "[data-cy='title-recipe'] .a-size-base-plus.a-spacing-none")
    private List<WebElement> productNames;

    public ProductsPage(WebDriver driver) {
        super(driver);
        log.info("Initializing ProductsPage");
        PageFactory.initElements(driver, this);
    }

    private void addItemToCart() {
        log.info("Adding Item to Cart");
        click(addToCartBtn);
    }

    public String returnItemPrice() {
        String itemValue = itemPrice.get(0).getText();
        log.info("Returning Item Price {}", itemValue);
        return itemValue;
    }

    public String getProductName() {
        StringBuilder stringBuilder = new StringBuilder();

        String brandNameText = getProductBrand();
        log.info("Returning Product Brand {}", brandNameText);
        stringBuilder.append(brandNameText);
        stringBuilder.append(" ");

        String productName = productNames.get(0)
                .getText();
        log.info("Returning product name {}", productName);
        stringBuilder.append(productName);
        log.info("Returning Product Details {}", stringBuilder);
        return stringBuilder.toString();
    }

    private String getProductBrand() {
        return brandNames.get(0)
                .getText();
    }

    public void selectTheItemLookingFor() {
        log.info("Selecting Item");
        waitUntil(itemToBeClicked.get(0));
        click(itemToBeClicked.get(0));
        switchToActiveTab();
    }

    public Product fetchProductDetails() {
        Product product = new Product();
        log.info("Fetching Product Details");
        product.setProductName(getProductName());
        product.setProductPrice(returnItemPrice());
        product.setProductBrand(getProductBrand());
        return product;
    }
}
