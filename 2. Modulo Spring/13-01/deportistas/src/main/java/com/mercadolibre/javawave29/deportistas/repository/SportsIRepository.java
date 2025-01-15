package com.mercadolibre.javawave29.deportistas.repository;

import com.mercadolibre.javawave29.deportistas.model.Person;
import com.mercadolibre.javawave29.deportistas.model.Sport;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class SportsIRepository implements IRepository {

    private final List<Sport> sports;
    private final List<Person> persons;

    public SportsIRepository() {
        sports = List.of(
                new Sport("Futbol", "Avanzado"),
                new Sport("Ciclismo", "Intermedio"),
                new Sport("Natación", "Principiante"),
                new Sport("Tenis", "Avanzado"),
                new Sport("Básquetbol", "Intermedio"),
                new Sport("Voleibol", "Principiante"),
                new Sport("Atletismo", "Avanzado"),
                new Sport("Gimnasia", "Intermedio"),
                new Sport("Boxeo", "Principiante"),
                new Sport("Judo", "Avanzado"),
                new Sport("Esgrima", "Intermedio"),
                new Sport("Remo", "Principiante"),
                new Sport("Surf", "Avanzado"),
                new Sport("Rugby", "Intermedio"),
                new Sport("Hockey", "Principiante")
        );
        persons = List.of(
                new Person("Juan", "Pérez", 30, sports.get(0)),
                new Person("María", "Gómez", 25, sports.get(1)),
                new Person("Carlos", "López", 28, sports.get(2)),
                new Person("Lucía", "Fernández", 22, sports.get(3)),
                new Person("Miguel", "Martínez", 35, sports.get(4)),
                new Person("Laura", "Rodríguez", 27, sports.get(5)),
                new Person("Javier", "Sánchez", 33, sports.get(6)),
                new Person("Ana", "García", 24, sports.get(7)),
                new Person("Pedro", "Ramírez", 29, sports.get(8)),
                new Person("Sofía", "Torres", 21, sports.get(9)),
                new Person("David", "Ruiz", 26, sports.get(10)),
                new Person("Marta", "Jiménez", 32, sports.get(11)),
                new Person("Andrés", "Díaz", 37, sports.get(12)),
                new Person("Elena", "Vargas", 23, sports.get(13)),
                new Person("Luis", "Moreno", 31, sports.get(14))
        );
    }

    @Override
    public List<Sport> findAll() {
        return sports;
    }

    @Override
    public Optional<Sport> findByName(String name) {
        return sports
                .stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }
}
