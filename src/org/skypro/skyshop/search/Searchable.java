package org.skypro.skyshop.search;

public interface Searchable {

    String searchTerm();

    String typeContent();

    String searchableName();

    default String getStringRepresentation() {
        return "Имя " + searchTerm() + " объекта - тип " + typeContent() + " - объекта";
    }
}
