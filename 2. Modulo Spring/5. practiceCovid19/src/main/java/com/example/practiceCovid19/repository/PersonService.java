package com.example.practiceCovid19.repository;

import com.example.practiceCovid19.model.Person;

import java.util.List;

public class PersonService {
    PersonRepository personRepository;

    public PersonService() {
        this.personRepository = new PersonRepository();
    }

    public void addPerson(Person person){
        this.personRepository.addPerson(person);
    }

    public List<Person> getAll() {
        return this.personRepository.getAll();
    }
}
