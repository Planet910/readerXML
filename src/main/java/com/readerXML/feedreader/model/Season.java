package com.readerXML.feedreader.model;

public enum Season {
    SPRING("Spring"),
    AUTUMN("Autumn"),
    WINTER("Winter"),
    SUMMER("Summer");

    private final String label;

    Season(String label) {
        this.label = label;
    }

    public static Season valueOfLabel(String label) {
        for (Season season : values()) {
            if (season.label.equals(label)) {
                return season;
            }
        }
        return null;
    }

    public String getLabel() {
        return label;
    }
}
