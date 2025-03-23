package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int length = Integer.compare(o2.searchableName().length(), o1.searchableName().length());
        if (length == 0) {
            return o1.searchableName().compareTo(o2.searchableName());
        } else {
            return length;
        }
    }
}
