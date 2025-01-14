package com.example.practiceSportsman.service;

import com.example.practiceSportsman.model.Person;
import com.example.practiceSportsman.repository.PersonRepository;

import java.util.List;

public class PersonImp {
    private final PersonRepository personRepository;

    public PersonImp() {
        personRepository = new PersonRepository();
    }

    public void addPerson(Person person) {
        personRepository.addPerson(person);
    }

    public List<Person> getAllPeople() {
        return personRepository.getAllPeople();
    }
}
