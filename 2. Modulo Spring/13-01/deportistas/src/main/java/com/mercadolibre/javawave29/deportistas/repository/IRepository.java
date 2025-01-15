package com.mercadolibre.javawave29.deportistas.repository;

import com.mercadolibre.javawave29.deportistas.model.Person;
import com.mercadolibre.javawave29.deportistas.model.Sport;

import java.util.List;
import java.util.Optional;

public interface IRepository {
    List<Sport> findAll();
    Optional<Sport> findByName(String name);
    List<Person> getPersons();
}
