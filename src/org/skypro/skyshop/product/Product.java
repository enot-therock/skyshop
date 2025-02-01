package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {

    private String productName;
    private int cost;

    public Product(String productName, int cost) {
        this.productName = productName;
        this.cost = cost;
    }

    public String getProduct() {
        return productName;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return getProduct() + ": " + getCost();
    }

}
