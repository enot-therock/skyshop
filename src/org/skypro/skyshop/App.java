package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.search.Article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.product.DiscountedProduct;
import org.skypro.skyshop.search.product.FixPriceProduct;
import org.skypro.skyshop.search.product.SimpleProduct;

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

        SearchEngine searchEngine = new SearchEngine(13);

        searchEngine.addSearchComponents(product2);
        searchEngine.addSearchComponents(product4);
        searchEngine.addSearchComponents(product1);
        searchEngine.addSearchComponents(product3);
        searchEngine.addSearchComponents(product5);
        searchEngine.addSearchComponents(product6);
        searchEngine.addSearchComponents(product7);
        searchEngine.addSearchComponents(product9);
        searchEngine.addSearchComponents(product15);
        searchEngine.addSearchComponents(product10);

        Article article1 = new Article("Торт", "Жиры 20%, Белки 25%, Углеводы 55%");
        Article article2 = new Article("Мясо", "Кофеин 4%, Эфирные масла 20%, Углеводы 50%, Аминокислоты 12%");
        Article article3 = new Article("Кофе", "Жиры 12%, Белки 17%, Углеводы 69%");

        searchEngine.addSearchComponents(article1);
        searchEngine.addSearchComponents(article2);
        searchEngine.addSearchComponents(article3);

        System.out.println(article1.searchTerm());
        System.out.println(article1.typeContent());
        System.out.println(product2.searchTerm());

        System.out.println();
        searchEngine.search("колбаса");
        searchEngine.search("ТОРТ");
        searchEngine.search("СнИкеРс");

    }
}