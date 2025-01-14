package com.example.practiceCovid19.repository;

import com.example.practiceCovid19.model.Person;
import com.example.practiceCovid19.model.interfaces.IPerson;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPerson {
    List<Person> personList = new ArrayList<>();

    @Override
    public void addPerson(Person person) {
        personList.add(person);
    }

    @Override
    public List<Person> getAll() {
        return personList;
    }
}
