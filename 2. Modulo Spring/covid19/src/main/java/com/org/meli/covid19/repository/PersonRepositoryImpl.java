package com.org.meli.covid19.repository;


import com.org.meli.covid19.dto.RiskGroupPersonDto;
import com.org.meli.covid19.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements IPersonRepository{

    private final List<Person> persons = List.of(
            new Person(1L,"Juan", "Perez", 30),
            new Person(2L,"Maria", "Gomez", 25),
            new Person(3L, "Carlos", "Lopez", 62),
            new Person(4L,"Laura", "Rodriguez", 70),
            new Person(5L,"Pedro", "Gonzalez", 65)
    );

    @Override
    public List<Person> findRiskGroup() {
        return persons.stream()
                .filter(person -> person.getAge() > 60)
                .toList();
    }
}
