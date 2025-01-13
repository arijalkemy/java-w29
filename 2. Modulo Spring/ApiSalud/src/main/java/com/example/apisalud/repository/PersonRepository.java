package com.example.apisalud.repository;

import com.example.apisalud.model.entity.Person;
import com.example.apisalud.model.entity.Symptom;
import com.example.apisalud.repository.interfaces.IReadeable;
import java.util.List;

public class PersonRepository implements IReadeable<Person> {
    private final List<Person> persons = List.of(
            Person.builder().id(1).name("Juan").lastName("Perez").age(25)
                    .symptoms(List.of(
                            Symptom.builder().code("S1").name("Fiebre").severity(1).build(),
                            Symptom.builder().code("S2").name("Tos").severity(2).build()
                    )).
                    build(),
            Person.builder().id(2).name("Maria").lastName("Lopez").age(61)
                    .symptoms(
                            List.of(
                                    Symptom.builder().code("S3").name("Dolor de cabeza").severity(3).build(),
                                    Symptom.builder().code("S4").name("Dolor de garganta").severity(4).build(),
                                    Symptom.builder().code("S5").name("Dolor de cuerpo").severity(5).build()
                            )
                    )
                    .build(),
            Person.builder().id(3).name("Pedro").lastName("Gomez").age(35).build()
    );

    @Override
    public List<Person> getAll() {
        return persons;
    }
}
