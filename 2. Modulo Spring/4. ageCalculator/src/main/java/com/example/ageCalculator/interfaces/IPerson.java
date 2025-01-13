package com.example.ageCalculator.interfaces;

import com.example.ageCalculator.model.Person;

public interface IPerson {
    void add(Person person);
    Person getByName(String name);
}
