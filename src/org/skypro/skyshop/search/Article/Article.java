package org.skypro.skyshop.search.Article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {

    private String nameArticle;
    private String textArticle;

    public Article(String nameArticle, String textArticle) {
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public String getTextArticle() {
        return textArticle;
    }

    @Override
    public String toString() {
        return getNameArticle() + System.lineSeparator() + getTextArticle();
    }

    @Override
    public String searchTerm() {
        return getNameArticle() + System.lineSeparator() + getTextArticle();
    }

    @Override
    public String typeContent() {
        return "ARTICLE";
    }
}
