package org.skypro.skyshop.basket;

import org.skypro.skyshop.search.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket<T extends Product> {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getProduct().toLowerCase(), k -> new ArrayList<>()).add(product);
    }

    public int allCost() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printProductBasket() {
        products.values().forEach(System.out::println);
        System.out.println("Итого: " + allCost());
        System.out.println("Специальных товаров: " + specialProduct());
    }

    public long specialProduct() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
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
        Map<String, List<Product>> deleteProduct = products.entrySet().stream()
                .filter(d -> d.getKey().equalsIgnoreCase(name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
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
