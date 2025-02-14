package org.skypro.skyshop.search;

import org.skypro.skyshop.Exception.BestResultNotFound;

public class SearchEngine {

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

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable searchable = null;
        String string;
        int defaultIndex = 0;
        int searchIndex;
        for (int i = 0; i < size; i++) {
            string = searchables[i].searchTerm().toLowerCase();
            search = search.toLowerCase();
            searchIndex = searchIndex(string, search);
            if (searchables[i] != null && searchIndex > defaultIndex) {
                defaultIndex = searchIndex;
                searchable = searchables[i];
            }
            if (searchable == null) {
                throw new BestResultNotFound("Элемента " + search + " не найдено");
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

}
