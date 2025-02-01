package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {

        SimpleProduct product1 = new SimpleProduct("Торт", 598);
        SimpleProduct product2 = new SimpleProduct("Мясо", 1246);
        SimpleProduct product3 = new SimpleProduct("Кофе", 813);
        SimpleProduct product4 = new SimpleProduct("Сыр", 567);
        SimpleProduct product5 = new SimpleProduct("Молоко", 81);
        SimpleProduct product6 = new SimpleProduct("Конфеты", 236);
        SimpleProduct product7 = new SimpleProduct("Вафли", 44);

        DiscountedProduct product9 = new DiscountedProduct("Хлопья", 298, 20);
        DiscountedProduct product10 = new DiscountedProduct("Колбаса", 536, 25);

        FixPriceProduct product15 = new FixPriceProduct("Сникерс");

        ProductBasket productBasket = new ProductBasket();

        productBasket.addProduct(product1);
        productBasket.addProduct(product3);
        productBasket.addProduct(product9);
        productBasket.addProduct(product10);
        productBasket.addProduct(product15);


        //productBasket.addProduct(product6);

        productBasket.printProductBasket();
        System.out.println();

        System.out.println("Общая стоимость корзины: " + productBasket.allCost());
        System.out.println();

        productBasket.searchProduct("сникерс");
        System.out.println();

        productBasket.searchProduct("молоко");
        System.out.println();

        productBasket.deleteAll();
        productBasket.printProductBasket();
        System.out.println("Общая стоимость корзины: " + productBasket.allCost());
        System.out.println();

        productBasket.searchProduct("торт");
    }
}