package com.meli.deportista.service;

import com.meli.deportista.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    List<Person> persons;

    public PersonService() {
        this.persons = new ArrayList<>();
    }

    public PersonService(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return this.persons;
    }
}
