package com.bootcamp.dto_p1.service;


import com.bootcamp.dto_p1.model.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AgeService {

    private Map<Integer, Person> persons = new HashMap<>();

    public Integer calculateAge(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        return Period.between(localDate, today).getYears();
    }

    public void addPerson(Person person) {
        persons.put(person.getId(), person);
    }

    public Integer calculateAgeById(int id) {
        LocalDate today = LocalDate.now();
        return Period.between(persons.get(id).getBirthDate(), today).getYears();
    }
}
