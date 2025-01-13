package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Person;

public class PeopleService {
    private List<Person> people = new ArrayList<Person>();

    public PeopleService() {
    }
    public List<Person> getAllPeople() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Person getPersonById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
}
