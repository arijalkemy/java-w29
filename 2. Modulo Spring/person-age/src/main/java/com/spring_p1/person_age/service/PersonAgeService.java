package com.spring_p1.person_age.service;

import com.spring_p1.person_age.model.Person;
import com.spring_p1.person_age.repository.PersonAgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class PersonAgeService {
    @Autowired
    private PersonAgeRepository personAgeRepository;

    public Integer getAgeFromDDMMYYYY(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return getAgeFromDate(date);
    }

    public Integer getAgeFromDate(LocalDate date) {
        LocalDate today = LocalDate.now();
        return Period.between(date, today).getYears();
    }


    public Person addPerson(Person person) {
        personAgeRepository.addPerson(person);
        return person;
    }

    public Optional<Person> getPerson(Integer id) {
        return personAgeRepository.getPerson(id);
    }

    public Integer getAge(Person person) {
        return getAgeFromDate(person.getBirthDate());
    }
}
