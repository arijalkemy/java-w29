package com.example.deportes.service;

import com.example.deportes.model.dto.response.AthleteResponse;
import com.example.deportes.model.entity.Person;
import com.example.deportes.repository.PersonRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class PersonService {

    private final PersonRepository personRepository = new PersonRepository();

    public List<Person> getAll() {
        return personRepository.getAll();
    }

    public List<AthleteResponse> getAllAthletes() {
        List<Person> people = personRepository.getAll();
        return people.stream().filter(
                        person -> person.getSport() != null
                ).map(
                        person -> AthleteResponse.builder()
                                .nombre(person.getName())
                                .apellido(person.getLastName())
                                .nombreDeporte(person.getSport().getName())
                                .build()
                ).toList();
    }
}
