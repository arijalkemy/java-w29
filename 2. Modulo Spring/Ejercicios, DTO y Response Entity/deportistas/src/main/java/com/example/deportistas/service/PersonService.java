package com.example.deportistas.service;

import com.example.deportistas.DTO.PersonSportDTO;
import com.example.deportistas.model.Person;
import com.example.deportistas.model.Sport;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private List<Person> personList;
    public PersonService() {
        personList = new ArrayList<>();
        personList.add(new Person("asd","asd", 3, new Sport(1,"Tenis")));
        personList.add(new Person("asd2","asd2", 2, new Sport(2,"Bascketball")));
        personList.add(new Person("asd3","asd3", 1, new Sport(3,"Football")));
    }

    public List<PersonSportDTO> getPersonSports() {
        List<PersonSportDTO> list = personList.stream().map(person -> new PersonSportDTO(person)).toList();
        System.out.println(list.get(0));
        return list;
    }
}
