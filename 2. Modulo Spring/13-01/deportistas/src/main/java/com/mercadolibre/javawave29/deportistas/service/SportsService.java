package com.mercadolibre.javawave29.deportistas.service;

import com.mercadolibre.javawave29.deportistas.model.Person;
import com.mercadolibre.javawave29.deportistas.model.Sport;
import com.mercadolibre.javawave29.deportistas.model.SportsPersonsDTO;
import com.mercadolibre.javawave29.deportistas.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportsService implements IService {

    private final IRepository repository;

    @Autowired
    public SportsService(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Sport> findAll() {
        return repository.findAll();
    }

    @Override
    public Sport findByName(String name) {
        return repository
                .findByName(name)
                .orElse(null);
    }

    @Override
    public List<SportsPersonsDTO> findSportsPersons() {
        List<Person> persons = repository.getPersons();
        return persons
                .stream()
                .map(p -> new SportsPersonsDTO(p.getName(), p.getSurname(), p.getSport().getName()))
                .collect(Collectors.toList());
    }
}
