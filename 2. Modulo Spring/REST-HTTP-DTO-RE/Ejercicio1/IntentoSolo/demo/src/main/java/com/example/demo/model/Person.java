package com.example.demo.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private int id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private int age;

    public Person(int id, String name, String surname, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.age = calculateAge(birthDate);
    }

    private int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear() - birthDate.getYear();
    }

}
