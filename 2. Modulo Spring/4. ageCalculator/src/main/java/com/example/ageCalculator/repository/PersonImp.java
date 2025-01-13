package com.example.ageCalculator.repository;

import com.example.ageCalculator.interfaces.IPerson;
import com.example.ageCalculator.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonImp implements IPerson {
    List<Person> personList = new ArrayList<>();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public Person getByName(String name) {
        return personList.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
