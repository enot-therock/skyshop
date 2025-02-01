package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {

    private String productName;

    public Product(String productName) {
        this.productName = productName;
        //this.cost = cost;
    }

    public String getProduct() {
        return productName;
    }

    @Override
    public String toString() {
        return getProduct() + ": " + getPrice();
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

}
