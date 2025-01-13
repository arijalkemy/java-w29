package com.meli.ej_edad.service;

import com.meli.ej_edad.dto.PersonDetailsDTO;
import com.meli.ej_edad.model.Person;
import com.meli.ej_edad.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PersonService {
    private Integer idCounter;
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        this.idCounter = 0;
    }

    public Integer createPerson(Person person) {
        Person createdPerson = new Person(
                this.idCounter,
                person.getName(),
                person.getBirthDate()
        );
        this.personRepository.save(createdPerson);
        this.idCounter++;
        return createdPerson.getId();

    }

    public Integer calculateAge(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }

    public PersonDetailsDTO getPersonDetails(Integer id) {
        Person personFound = this.personRepository
                .findById(id)
                .orElse(null);
        if (personFound == null) {
            throw new IllegalArgumentException("Person not found");
        }
        return new PersonDetailsDTO(
                personFound.getName(),
                this.calculateAge(personFound.getBirthDate())
        );

    }
}
