package org.skypro.skyshop.search.product;

import org.skypro.skyshop.search.Searchable;

public class SimpleProduct extends Product implements Comparable<Searchable> {

    protected int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
        this.price = price;
        if (price < 1) {
            throw new IllegalArgumentException("Указанная цена недействительна");
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getProduct() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int compareTo(Searchable o) {
        return this.searchableName().compareTo(o.searchableName());
    }
}
