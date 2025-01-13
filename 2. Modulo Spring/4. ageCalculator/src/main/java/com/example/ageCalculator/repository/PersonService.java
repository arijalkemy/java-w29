package com.example.ageCalculator.repository;

import com.example.ageCalculator.interfaces.IPerson;
import com.example.ageCalculator.model.Person;

import java.time.LocalDate;
import java.time.Period;

public class PersonService {
    private final IPerson personRepository;

    public PersonService() {
        this.personRepository = new PersonImp();
    }

    public void addPerson(Person person) {
        personRepository.add(person);
    }

    public Person getPersonByName(String name) {
        return personRepository.getByName(name);
    }

    public int getYears(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period period = Period.between(date, now);

        return period.getYears();
    }
}
