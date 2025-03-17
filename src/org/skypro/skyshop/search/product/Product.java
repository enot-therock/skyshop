package org.skypro.skyshop.search.product;

import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public abstract class Product implements Searchable {
    private String productName;

    public Product(String productName) {
        this.productName = productName;
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Неверное имя продукта");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }

}
