package com.melibootcamp.DtoDeportes.services;

import com.melibootcamp.DtoDeportes.dto.DtoSportPerson;
import com.melibootcamp.DtoDeportes.entity.Person;
import com.melibootcamp.DtoDeportes.entity.Sport;
import com.melibootcamp.DtoDeportes.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonFinder implements IPersonFind {

    @Autowired
    ISportFinder SportFinder;
    @Override
    public DtoSportPerson findSportPerson(String id) {
        Person person = PersonRepository.findPerson(id);
        if (person == null) {
            return null;
        }
        return new DtoSportPerson(person.getName(), person.getLastName(), person.getSports().stream().map(Sport::getName).toList());
    }

    @Override
    public void createPerson(String name, String lastName,Integer years) {
        PersonRepository.addPerson(new Person(name, lastName,years));
    }

    @Override
    public void addSportToPerson(String name, String sport) {
        Person person = PersonRepository.findPerson(name);
        Sport sport1 = SportFinder.findSport(sport);
        if (person != null && sport1 != null) {
            person.addSport(sport1);
        }
    }
}
