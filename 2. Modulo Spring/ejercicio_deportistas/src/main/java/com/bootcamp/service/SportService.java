package com.bootcamp.service;

import com.bootcamp.dto.PersonDto;
import com.bootcamp.model.Person;
import com.bootcamp.model.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SportService {

    private static final List<Sport> sportList;

    static {
        Person person1 = new Person("John", "Doe", 25);
        Person person2 = new Person("Jane", "Smith", 30);
        Person person3 = new Person("Mike", "Brown", 28);
        Sport sport1 = new Sport("Football", "Intermediate", Arrays.asList(person1, person2));
        Sport sport2 = new Sport("Basketball", "Advanced", Arrays.asList(person2, person3));
        Sport sport3 = new Sport("Tennis", "Beginner", List.of(person1));
        sportList = Arrays.asList(sport1, sport2, sport3);
    }

    public Optional<Sport> findSportByName(String name) {
        return sportList.stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Sport> findSports() {
        return sportList;
    }

    public List<PersonDto> findSportsPersons() {
        List<PersonDto> personDtoList = new ArrayList<>();
        for (Sport sport : sportList) {
            for (Person person : sport.getPersons())
                personDtoList.add(new PersonDto(person.getName(), person.getLastname(), sport.getName()));
        }
        return personDtoList;
    }
}
