package org.skypro.skyshop.search.product;

import org.skypro.skyshop.search.Searchable;

public class FixPriceProduct extends Product implements Comparable {

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
    public int compareTo(Object o) {
        return 0;
    }
}
