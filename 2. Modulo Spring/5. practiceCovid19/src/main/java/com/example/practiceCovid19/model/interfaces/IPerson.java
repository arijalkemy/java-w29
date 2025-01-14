package com.example.practiceCovid19.model.interfaces;

import com.example.practiceCovid19.model.Person;

import java.util.List;

public interface IPerson {
    void addPerson(Person person);
    List<Person> getAll();
}
