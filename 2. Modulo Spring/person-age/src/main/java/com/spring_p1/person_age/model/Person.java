package com.spring_p1.person_age.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Person {
    private final Integer id;
    private final String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private final LocalDate birthDate;

    public Person(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
