package org.skypro.skyshop.search;

public class SearchEngine{

    private Searchable[] searchables;
    private int size;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void addSearchComponents(Searchable searchable) {
        if (size >= searchables.length) {
            throw new IllegalArgumentException("список для поиска полон");
        }
        searchables[size++] = searchable;
    }

    public Searchable[] search(String searchText) {
        int counter = 0;
        Searchable[] result = new Searchable[5];
        for (int i = 0; i < size; i++) {
            if (searchables[i].searchTerm().toLowerCase().contains(searchText.toLowerCase())) {
                result[counter] = searchables[i];
                counter++;
            }
        }
        return result;
    }
}
