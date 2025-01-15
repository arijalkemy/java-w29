package com.mercadolibre.javawave29.deportistas.model;

public class Sport {
    private final String name;
    private final String level;

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
