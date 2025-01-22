package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        productBasket.addProduct("Яйцо", 179); // 1. Добавление продукта в корзину
        productBasket.addProduct("Мясо", 1467);
        productBasket.addProduct("Кофе", 862);
        productBasket.addProduct("Шоколад", 81);
        // productBasket.addProduct("Колбаса", 236); // 2. Добавление продукта в заполненную корзину

        System.out.println();
        productBasket.printProductBasket(); // 3. Печать содержимого корзины

        System.out.println();
        productBasket.allCost(); // Получение стоимости корзины с несколькими товарами
        System.out.println();

        productBasket.addProduct("Какао", 781);
        productBasket.printProductBasket();

        System.out.println();
        productBasket.searchProduct("яйцо"); // Поиск товара, который есть в корзине

        System.out.println();
        productBasket.searchProduct("кабачок"); // Поиск товара, которого нет в корзине

        System.out.println();
        productBasket.deleteAll(); // Очистка корзины

        // productBasket.printProductBasket(); // 3. Печать содержимого пустой корзины

        System.out.println();
        productBasket.allCost(); // Получение стоимости пустой корзины

        System.out.println();
        productBasket.searchProduct("яйцо"); // Поиск товара по имени в пустой корзине

    }
}