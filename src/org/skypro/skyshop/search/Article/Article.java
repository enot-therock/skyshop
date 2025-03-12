package org.skypro.skyshop.search.Article;

import org.skypro.skyshop.search.Searchable;

import java.util.Comparator;
import java.util.Objects;

public class Article implements Searchable {

    private final String nameArticle;
    private final String textArticle;

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

    @Override
    public String searchableName() {
        return getNameArticle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameArticle, article.nameArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameArticle);
    }

}
