package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] products;
    private int size;

    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(Product product) {
        if (size >= products.length) {
            throw new IllegalArgumentException("Невозможно добавить новый продукт");
        }
        products[size++] = product;
    }

    public int allCost() {
        int allCost = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                break;
            }
            allCost += products[i].getCost();
        }
        return allCost;
    }

    public void printProductBasket() {
        int allCost = 0;
        for (int i = 0; i < size; i++) {
            if (products[i] == null) {
                throw new IllegalArgumentException("В корзине ничего нет");
            }
            Product product = products[i];
            System.out.println(product);
            allCost += products[i].getCost();
        }
        System.out.println("Итого: " + allCost);
    }

    public void searchProduct(String productName) {
        boolean name = false;
        for (int i = 0; i < size; i++) {
            if (products[i] == null) {
                break;
            }
            if (products[i].getProduct().equalsIgnoreCase(productName)) {
                name = true;
            }
        }
        System.out.println(name);
    }

    public void deleteAll() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
            size = 0;
        }
    }

}
