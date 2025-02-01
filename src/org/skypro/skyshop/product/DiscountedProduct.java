package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    protected int basePrice;
    protected double discount;

    public DiscountedProduct(String productName, int basePrice, double discount) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return (int) (basePrice - basePrice * discount/100);
    }

    @Override
    public String toString() {
        return getProduct() + ": " + getPrice() + "(" + discount + ")";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
