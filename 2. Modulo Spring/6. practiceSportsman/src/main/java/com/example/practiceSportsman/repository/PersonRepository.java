package com.example.practiceSportsman.repository;

import com.example.practiceSportsman.model.Person;
import com.example.practiceSportsman.model.interfaces.IPerson;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPerson {
    List<Person> people = new ArrayList<>();

    @Override
    public void addPerson(Person person) {
        this.people.add(person);
    }

    @Override
    public List<Person> getAllPeople() {
        return people;
    }
}
