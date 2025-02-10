package org.skypro.skyshop.search.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    private String productName;

    public Product(String productName) {
        this.productName = productName;
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

    @Override
    public String searchTerm() {
        return getProduct();
    }

    @Override
    public String typeContent() {
        return "PRODUCT";
    }

    @Override
    public String searchableName() {
        return getProduct();
    }
}
