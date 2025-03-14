package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (Integer.compare(o1.length(), o2.length()) != 0) {
            return o1.length() - o2.length();
        } else {
           return o1.compareTo(o2);
        }
    }
}
