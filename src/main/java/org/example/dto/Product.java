package org.example.dto;

import java.util.Objects;

public class Product {
    private  String productName;
    private  String productPrice;
    private  String productBrand;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName) && Objects.equals(productPrice, product.productPrice) && Objects.equals(productBrand, product.productBrand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPrice, productBrand);
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
}
