package com.mercadolibre.javawave29.covid_19.repository;

import com.mercadolibre.javawave29.covid_19.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> people = List.of(
            new Person("John", "Doe", 30),
            new Person("Jane", "Smith", 25),
            new Person("Emily", "Jones", 40),
            new Person("Michael", "Brown", 35),
            new Person("Sarah", "Davis", 28),
            new Person("David", "Wilson", 32),
            new Person("Laura", "Taylor", 27),
            new Person("Robert", "Anderson", 45),
            new Person("Linda", "Thomas", 50),
            new Person("James", "Harris", 38)
    );

    public List<Person> findAll() {
        return people;
    }
}
