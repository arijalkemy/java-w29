package com.meli.ej_edad.repository;

import com.meli.ej_edad.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private final List<Person> persons;

    public PersonRepository() {
        this.persons = new ArrayList<>();
    }

    public void save(Person person) {
        this.persons.add(person);
    }

    public Optional<Person> findById(Integer id) {
        return this.persons.stream().filter(person -> person.getId().equals(id)).findFirst();
    }
}
