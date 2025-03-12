package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        if (Integer.compare(o1.searchableName().length(), o2.searchableName().length()) != 0) {
            return o1.searchableName().length() - o2.searchableName().length();
        } else {
           return o1.searchableName().compareTo(o2.searchableName());
        }
    }
}
