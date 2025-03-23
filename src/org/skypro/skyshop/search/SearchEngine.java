package org.skypro.skyshop.search;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEngine <T extends Searchable> {
    private final Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new TreeSet<>();
    }

    public void addSearchComponents(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String searchText) {
        TreeSet<Searchable> search = searchables.stream()
                .filter(s -> s.searchableName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchComparator())));
        System.out.println("Искомый объект: = " + search);
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
