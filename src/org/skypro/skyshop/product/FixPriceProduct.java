package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

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
}
