package com.sports.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.sports.demo.DTOs.PersonDTO;
import com.sports.demo.model.Person;
import com.sports.demo.model.Sport;

import lombok.Data;

@Data
public class PersonService {
    private List<Person> people = new ArrayList<Person>();

    public PersonService() {
        people.add(new Person("John", "Doe", 25, new Sport("Football", "High")));
        people.add(new Person("Jane", "Smith", 30, new Sport("Basketball", "Medium")));
        people.add(new Person("Tom", "Johnson", 28, new Sport("Tennis", "Low")));
    }

    public void add(Person person) {
        people.add(person);
    }
    public List<PersonDTO> getAllPeople() {
        List<PersonDTO> peopleDTOList = new ArrayList<>();
        for (Person person : people) {
            peopleDTOList.add(new PersonDTO(person.getName(), person.getSurname(), person.getSport().getName()));
        }
        return peopleDTOList;
    }
}
