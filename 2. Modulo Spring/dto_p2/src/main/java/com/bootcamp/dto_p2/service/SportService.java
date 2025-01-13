package com.bootcamp.dto_p2.service;

import com.bootcamp.dto_p2.dto.PersonDTO;
import com.bootcamp.dto_p2.model.Person;
import com.bootcamp.dto_p2.model.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SportService {

    private final List<Sport> sports =new ArrayList<>();
    private final List<Person> persons = new ArrayList<>();

    public SportService() {
        Sport s1 = new Sport("Futbol", 1);
        Sport s2 =new Sport("Basquetball", 2);
        Sport s3 =new Sport("Natacion", 3);
        sports.add(s1);
        sports.add(s2);
        sports.add(s3);

        Person p1 = new Person("Daniel", "Ochoa", 23, s1);
        Person p2 = new Person("Nicolas", "Urrego", 31, s2);
        Person p3 = new Person("Wilmer", "Rodriguez", 22, s3);
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
    }

    public List<Sport> getSports() {
        return sports;
    }

    public Optional<Sport> getSportByName(String name) {
        return sports.stream().filter(sport -> sport.getName().equals(name)).findFirst();
    }

    public List<PersonDTO> getSportingPersons() {
        return persons.stream().map(PersonDTO::new).collect(Collectors.toList());
    }
}
