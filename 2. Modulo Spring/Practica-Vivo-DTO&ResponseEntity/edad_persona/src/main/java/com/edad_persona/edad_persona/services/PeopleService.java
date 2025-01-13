package com.edad_persona.edad_persona.services;

import org.springframework.stereotype.Service;

import com.edad_persona.edad_persona.models.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {
    private final List<Person> personas = new ArrayList<>();

    public PeopleService() {
    }

    public List<Person> addPerson(Person person) {
        this.personas.add(person);
        return this.personas;
    }

    public String calculatePersonAge(String name) {

        Person personFind = this.personas.stream().filter(person -> person.getName().equalsIgnoreCase(name)).findFirst()
                .orElse(null);

        String[] personBirthdate = personFind.getBrithdate().split("-");

        Integer year = Integer.parseInt(personBirthdate[2]);
        Integer month = Integer.parseInt(personBirthdate[1]);
        Integer day = Integer.parseInt(personBirthdate[0]);

        LocalDate birthDate = LocalDate.of(year, month, day);

        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthDate, currentDate);

        Integer years = period.getYears();

        return "La edad de la persona es: " + years;
    }
}
