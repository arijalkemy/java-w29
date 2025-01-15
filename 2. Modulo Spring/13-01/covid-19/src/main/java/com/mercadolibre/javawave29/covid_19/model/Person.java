package com.mercadolibre.javawave29.covid_19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private static Long nextId = 0L;

    private Long id;
    private String name;
    private String surname;
    private Integer age;

    public Person(String name, String surname, Integer age) {
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
