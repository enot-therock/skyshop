package org.skypro.skyshop.basket;

import org.skypro.skyshop.search.product.Product;

import java.util.*;

public class ProductBasket<T extends Product> {
    private List<Product> productList;
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.productList = new ArrayList<>();
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getProduct(), k -> new ArrayList<>()).add(product);
    }

    public int allCost() {
        int allCost = 0;
        for (List<Product> cost: products.values()) {
            for (int i = 0; i < cost.size(); i++) {
                if (cost.get(i) == null) {
                    break;
                }
                allCost += cost.get(i).getPrice();
            }
        }
        return allCost;
    }

    public void printProductBasket() {
        int counter = 0;
        int allCost = 0;
        for (List<Product> prod: products.values()) {
            for (int i = 0; i < prod.size(); i++) {
                if (prod.get(i) == null) {
                    throw new IllegalArgumentException("В корзине ничего нет");
                }
                Product product = prod.get(i);
                if (product.isSpecial()) {
                    counter++;
                }
                allCost += product.getPrice();
            }
        }
        for (Map.Entry<String, List<Product>> prod : products.entrySet()) {
            System.out.println("Товар - " + prod.getKey() + "; Описание - " + prod.getValue());
        }
        System.out.println("Итого: " + allCost);
        System.out.println("Специальных товаров: " + counter);
    }

    public Map<String, List<Product>> searchProduct(String productName) {
        Map<String, List<Product>> result = new HashMap<>();
        for (Map.Entry<String, List<Product>> prod : products.entrySet()) {
            if (prod.getKey() == null) {
                break;
            }
            if (prod.getKey().equalsIgnoreCase(productName)) {
                System.out.println("Искомый продукт: " + prod.getValue());
                result.put(prod.getKey(), prod.getValue());
            }
        }
        return result;
    }

    public void deleteAll() {
            products.clear();
    }

    public Map<String, List<Product>> deleteProductName(String name) {
        Map<String, List<Product>> deleteProduct = new HashMap<>();

        Iterator<Map.Entry<String, List<Product>>> productIterator = products.entrySet().iterator();
        while (productIterator.hasNext()) {
            Map.Entry<String, List<Product>> prod = productIterator.next();
            if (prod.getKey().equalsIgnoreCase(name)) {
                deleteProduct.put(prod.getKey(), prod.getValue());
                productIterator.remove();
            }
        }
        System.out.println("Удаленные товары: " + deleteProduct);
        return deleteProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket<?> that = (ProductBasket<?>) o;
        return Objects.equals(productList, that.productList) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productList, products);
    }
}
