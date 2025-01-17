package com.spring_p1.person_age.repository;

import com.spring_p1.person_age.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonAgeRepository {
    private List<Person> persons = new ArrayList<>();

    public Person addPerson(Person person) {
        persons.add(person);
        return person;
    }

    public Optional<Person> getPerson(Integer id) {
        return persons.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
