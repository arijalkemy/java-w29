package com.mercadolibre.javawave29.deportistas.model;

public class Person {
    private final String name;
    private final String surname;
    private final Integer age;
    private Sport sport;

    public Person(String name, String surname, Integer age, Sport sport) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Sport getSport() {
        return sport;
    }
}
