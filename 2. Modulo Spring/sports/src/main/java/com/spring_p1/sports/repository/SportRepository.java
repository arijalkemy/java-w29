package com.spring_p1.sports.repository;

import com.spring_p1.sports.model.Person;
import com.spring_p1.sports.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SportRepository {
    private final Map<Person, Sport> sportsPeople;

    public SportRepository() {
        this.sportsPeople = new HashMap<>();
        Sport proFootball = new Sport(1, "Football", "Professional");
        Sport amateurGolf = new Sport(2, "Golf", "Amateur");

        Person homer = new Person(1, "Homer", "Simpson", 38);
        Person skinner = new Person(2, "Seymour", "Skinner", 45);

        sportsPeople.put(homer, proFootball);
        sportsPeople.put(skinner, amateurGolf);
    }

    public Set<Person> getPersons() {
        return sportsPeople.keySet();
    }

    public Set<Sport> getSports() {
        return new HashSet<>(sportsPeople.values());
    }

    public Sport getSport(Person person) {
        return sportsPeople.get(person);
    }

    public Optional<Sport> getSportById(int id) {
        return getSports().stream().filter(sport -> sport.getId() == id).findFirst();
    }
}
