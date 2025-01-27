package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {

        Product product1 = new Product("Торт", 598);
        Product product2 = new Product("Мясо", 1246);
        Product product3 = new Product("Кофе", 813);
        Product product4 = new Product("Сыр", 567);
        Product product5 = new Product("Молоко", 81);
        Product product6 = new Product("Конфеты", 236);
        Product product7 = new Product("Вафли", 44);

        ProductBasket productBasket = new ProductBasket();

        productBasket.addProduct(product1);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product2);
        productBasket.addProduct(product7);

        //productBasket.addProduct(product6);

        productBasket.printProductBasket();
        System.out.println();

        System.out.println("Общая стоимость корзины: " + productBasket.allCost());
        System.out.println();

        productBasket.searchProduct("сыр");
        System.out.println();

        productBasket.searchProduct("молоко");
        System.out.println();

        productBasket.deleteAll();
        productBasket.printProductBasket();
        System.out.println("Общая стоимость корзины: " + productBasket.allCost());
        System.out.println();

        productBasket.searchProduct("вафли");
    }
}