package com.mercadolibre.javawave29.deportistas.model;

public class SportsPersonsDTO {
    private final String name;
    private final String surname;
    private final String sport;

    public SportsPersonsDTO(String name, String surname, String sport) {
        this.name = name;
        this.surname = surname;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSport() {
        return sport;
    }
}
