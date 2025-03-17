package org.skypro.skyshop.search;

import java.util.Comparator;
import java.util.function.Function;

public interface Searchable {

    String searchTerm();

    String typeContent();

    String searchableName();

    default String getStringRepresentation() {
        return "Имя " + searchTerm() + " объекта - тип " + typeContent() + " - объекта";
    }
}

