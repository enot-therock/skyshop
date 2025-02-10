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

    public String[] search(String searchText) {
        int counter = 0;
        String[] result = new String[5];
        for (int i = 0; i < size; i++) {
            if (searchables[i].searchTerm().toLowerCase().contains(searchText.toLowerCase())) {
                result[counter] = searchables[i].searchTerm();
                counter++;
            }
        }
        return result;
    }
}
