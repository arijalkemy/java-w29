package org.example.ej_starwars.Service;

import org.example.ej_starwars.Dto.PersonajeDto;
import org.example.ej_starwars.Repository.PersonajeRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajService {

    private final PersonajeRepositoryImpl repository;

    public PersonajeServiceImpl(PersonajeRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<PersonajeDto> findByName(String name) {
        return repository.getAll()
                .stream()
                .filter(c -> c.getName().contains(name))
                .map(PersonajeDto::toDto)
                .toList();
    }
}
