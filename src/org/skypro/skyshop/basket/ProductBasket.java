package org.skypro.skyshop.basket;

import org.skypro.skyshop.search.product.Product;

import java.util.*;

public class ProductBasket<T extends Product> {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getProduct().toLowerCase(), k -> new ArrayList<>()).add(product);
    }

    public int allCost() {
        int allCost = 0;
        for (List<Product> cost: products.values()) {
            for (int i = 0; i < cost.size(); i++) {
                if (cost.get(i) == null) {
                    continue;
                }
                allCost += cost.get(i).getPrice();
            }
        }
        return allCost;
    }

    public void printProductBasket() {
        for (List<Product> prod: products.values()) {
            System.out.println(prod);
        }
        System.out.println("Итого: " + allCost());
        System.out.println("Специальных товаров: " + specialProduct());
    }

    public int specialProduct() {
        int counter = 0;
        for (List<Product> prod: products.values()) {
            for (int i = 0; i < prod.size(); i++) {
                if (prod.get(i) == null) {
                    continue;
                }
                Product product = prod.get(i);
                if (product.isSpecial()) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public List<Product> searchProduct(String productName) {
        if (products.containsKey(productName.toLowerCase())) {
            System.out.println("Искомый продукт: " + products.get(productName.toLowerCase()));
        } else {
            System.out.println("Искомого товара нет в корзине");
        }
        return products.get(productName.toLowerCase());
    }

    public void deleteAll() {
            products.clear();
    }

    public Map<String, List<Product>> deleteProductName(String name) {
        Map<String, List<Product>> deleteProduct = new HashMap<>();
        for (Map.Entry<String, List<Product>> prod : products.entrySet()) {
            if (prod.getKey().equalsIgnoreCase(name)) {
                deleteProduct.put(prod.getKey(), prod.getValue());
            }
        }
        products.remove(name.toLowerCase());
        System.out.println("Удаленные товары: " + deleteProduct);
        return deleteProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket<?> that = (ProductBasket<?>) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, List<Product>> prod : products.entrySet()) {
            str.append("Товар - ").append(prod.getKey()).append("; Описание - ").append(prod.getValue()).append("\n");
        }
        return str.toString();
    }
}
