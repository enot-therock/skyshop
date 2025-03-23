package org.skypro.skyshop.search.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class FixPriceProduct extends Product implements Comparable<Searchable> {

    protected final int FIX_PRICE = 99;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getProduct() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int compareTo(Searchable o) {
        return this.searchableName().compareTo(o.searchableName());
    }
}
