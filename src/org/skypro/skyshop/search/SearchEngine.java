package org.skypro.skyshop.search;

import com.sun.source.tree.Tree;

import java.util.*;

public class SearchEngine <T extends Searchable> {
    private final Map<String, TreeSet<Searchable>> searchables;

    public SearchEngine() {
        this.searchables = new TreeMap<>();
    }

    public void addSearchComponents(Searchable searchable) {
        searchables.computeIfAbsent(searchable.searchableName().toLowerCase(), k -> new TreeSet<>()).add(searchable);
    }

    public TreeSet<Searchable> search(String searchText) {
        TreeSet<Searchable> search = new TreeSet<>(new SearchComparator());
        for (TreeSet<Searchable> set : searchables.values()) {
            if (set.contains(searchText.toLowerCase())) {
                //search.add(set.);
                System.out.println("Искомый объект " + searchables.values());
            } else {
                System.out.println("Искомого объекта нет");
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
