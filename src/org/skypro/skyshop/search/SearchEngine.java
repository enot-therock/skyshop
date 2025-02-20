package org.skypro.skyshop.search;

import org.skypro.skyshop.Exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine<T extends Searchable> {

    private final List<T> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void addSearchComponents(Searchable searchable) {
        searchables.add((T) searchable);
    }

    public List<T> search(String searchText) {
        List<Searchable> result = new ArrayList<>();
        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i).searchTerm().toLowerCase().contains(searchText.toLowerCase())) {
                result.add(searchables.get(i));
            }
        }
        return (List<T>) result;
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        Searchable searchable = null;
        String string;
        int defaultIndex = 0;
        int searchIndex;
        for (int i = 0; i < searchables.size(); i++) {
            string = searchables.get(i).searchTerm().toLowerCase();
            search = search.toLowerCase();
            searchIndex = searchIndex(string, search);
            if (searchables.get(i) != null && searchIndex > defaultIndex) {
                defaultIndex = searchIndex;
                searchable = searchables.get(i);
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
