package org.skypro.skyshop.search.product;

public class SimpleProduct extends Product {

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
}
