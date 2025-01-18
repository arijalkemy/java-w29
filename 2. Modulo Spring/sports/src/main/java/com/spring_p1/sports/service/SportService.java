package com.spring_p1.sports.service;

import com.spring_p1.sports.model.Person;
import com.spring_p1.sports.model.Sport;
import com.spring_p1.sports.dto.SportPersonDTO;
import com.spring_p1.sports.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;

    public Set<Sport> getSports() {
        return sportRepository.getSports();
    }

    public Optional<Sport> getSportById(int sportId) {
        return sportRepository.getSportById(sportId);
    }

    public SportPersonDTO sportPersonToDTO(Sport sport, Person person) {
        return new SportPersonDTO(
            person.getLastName() + ", " + person.getFirstName() + ".",
            sport.getName()
        );
    }

    public List<SportPersonDTO> getSportsPersons() {
        Set<Person> persons = sportRepository.getPersons();
        return persons.stream()
                    .map(person ->
                            sportPersonToDTO(sportRepository.getSport(person), person))
                    .toList();
    }
}
