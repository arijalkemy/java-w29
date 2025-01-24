package com.melibootcamp.DtoDeportes.repository;

import com.melibootcamp.DtoDeportes.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PersonRepository {
    static List<Person> persons=new ArrayList<>();
    public static void addPerson(Person person){
        persons.add(person);
    }
    public static Person findPerson(String name){
        for (Person person:persons) {
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }
}
