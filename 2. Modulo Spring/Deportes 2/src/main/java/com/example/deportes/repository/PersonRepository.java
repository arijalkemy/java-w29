package com.example.deportes.repository;

import com.example.deportes.model.entity.Person;
import com.example.deportes.model.entity.Sport;
import com.example.deportes.repository.interfaces.IReadeable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository implements IReadeable<Person> {
    private static final List<Person> people = List.of(
            Person.builder()
                    .name("Juan")
                    .lastName("Perez")
                    .age(25)
                    .sport(null)
                    .build(),
            Person.builder()
                    .name("Maria")
                    .lastName("Gomez")
                    .age(30)
                    .sport(Sport.builder().name("Tenis").level("Profesional").build())
                    .build(),
            Person.builder()
                    .name("Pedro")
                    .lastName("Gonzalez")
                    .age(22)
                    .sport(Sport.builder().name("Futbol").level("Amateur").build())
                    .build()
    );

    @Override
    public Person getOneByName(String name) {
        return people.stream().filter(person -> person.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Person> getAll() {
        return people;
    }

}
