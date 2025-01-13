package com.edad_persona.edad_persona.models;

public class Person {
    private String name;
    private String brithdate;

    public Person(String name, String birthdate) {
        this.name = name;
        this.brithdate = birthdate;
    }

    public String getBrithdate() {
        return brithdate;
    }

    public String getName() {
        return name;
    }
}
