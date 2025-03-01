package org.skypro.skyshop.search;

import org.skypro.skyshop.Exception.BestResultNotFound;
import org.skypro.skyshop.search.product.Product;

import java.util.*;

public class SearchEngine<T extends Searchable> {
    private final Map<String, List<Searchable>> searchables;

    public SearchEngine() {
        this.searchables = new TreeMap<>();
    }

    public void addSearchComponents(Searchable searchable) {
        searchables.computeIfAbsent(searchable.searchableName().toLowerCase(), k -> new ArrayList<>()).add(searchable);
    }

    public List<Searchable> search(String searchText) {
        if (searchables.containsKey(searchText.toLowerCase())) {
            System.out.println("Искомый объект: " + searchables.get(searchText.toLowerCase()));
        } else {
            System.out.println("Искомого объекта нет");
        }
        return searchables.get(searchText.toLowerCase());
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable searchable = null;
        String string;
        int defaultIndex = 0;
        int searchIndex;
        for (List<Searchable> searchables1: searchables.values()) {
            for (int i = 0; i < searchables1.size(); i++) {
                string = searchables1.get(i).searchTerm().toLowerCase();
                search = search.toLowerCase();
                searchIndex = searchIndex(string, search);
                if (searchables1.get(i) != null && searchIndex > defaultIndex) {
                    defaultIndex = searchIndex;
                    searchable = searchables1.get(i);
                }
                if (searchable == null) {
                    throw new BestResultNotFound("Элемента " + search + " не найдено");
                }

            }
        }
        return searchable;
    }


    private int searchIndex (String string, String search){
        int counter = 0;
        int index = 0;
        int subIndex = string.indexOf(search, index);

        while (subIndex != -1) {
            counter++;
            index = subIndex + search.length();
            subIndex = string.indexOf(search, index);
        }
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine<?> that = (SearchEngine<?>) o;
        return Objects.equals(searchables, that.searchables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchables);
    }
}
