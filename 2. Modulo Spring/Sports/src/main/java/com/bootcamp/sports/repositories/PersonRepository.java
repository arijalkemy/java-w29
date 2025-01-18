package com.bootcamp.sports.repositories;

import com.bootcamp.sports.models.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private List<Person> persons = new ArrayList<>(List.of(new Person("Pepe", "Lopez", 29)));

    public List<Person> getPersons() {
        return persons;
    }

}
