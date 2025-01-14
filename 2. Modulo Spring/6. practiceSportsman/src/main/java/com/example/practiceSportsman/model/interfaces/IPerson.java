package com.example.practiceSportsman.model.interfaces;

import com.example.practiceSportsman.model.Person;

import java.util.List;

public interface IPerson {
    void addPerson(Person person);
    List<Person> getAllPeople();
}
