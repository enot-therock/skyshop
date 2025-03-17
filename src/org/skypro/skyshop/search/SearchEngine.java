package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine <T extends Searchable> {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new TreeSet<>();
    }

    public void addSearchComponents(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String searchText) {
        String name = searchText.substring(0, 1).toUpperCase() + searchText.toLowerCase().substring(1);
        Set<Searchable> search = new TreeSet<>(new SearchComparator());
        for (Searchable searchable : searchables) {
            if (searchable.searchTerm().contains(name)) {
                search.add(searchable);
                System.out.println("Искомый объект: " + search);
            }
        }
        return search;
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
