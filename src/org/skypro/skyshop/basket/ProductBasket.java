package org.skypro.skyshop.basket;

import org.skypro.skyshop.search.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket<T extends Product> {
    private final List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int allCost() {
        int allCost = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) == null) {
                break;
            }
            allCost += products.get(i).getPrice();
        }
        return allCost;
    }

    public void printProductBasket() {
        int counter = 0;
        int allCost = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) == null) {
                throw new IllegalArgumentException("В корзине ничего нет");
            }
            Product product = products.get(i);
            if (product.isSpecial()) {
                counter++;
            }
            System.out.println(product);
            allCost += products.get(i).getPrice();
        }
        System.out.println("Итого: " + allCost);
        System.out.println("Специальных товаров: " + counter);
    }

    public void searchProduct(String productName) {
        boolean name = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) == null) {
                break;
            }
            if (products.get(i).getProduct().equalsIgnoreCase(productName)) {
                name = true;
            }
        }
        System.out.println(name);
    }

    public void deleteAll() {
            products.clear();
    }

    public List<T> deleteProductName(String name) {
        List<T> deleteProduct = new ArrayList<>();
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getProduct().toLowerCase().equals(name.toLowerCase())) {
                deleteProduct.add((T) product);
                productIterator.remove();
            }
        }
        System.out.println("Удаленные товары: " + deleteProduct);
        return deleteProduct;
    }

}
