package com.example.deportes.repository;

import com.example.deportes.model.entity.Sport;
import com.example.deportes.repository.interfaces.IReadeable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SportRepository implements IReadeable<Sport> {
    private static final List<Sport> sports = List.of(
            Sport.builder().name("Futbol").level("Amateur").build(),
            Sport.builder().name("Tenis").level("Profesional").build(),
            Sport.builder().name("Natacion").level("Amateur").build()
    );

    @Override
    public Sport getOneByName(String name) {
        return sports.stream().filter(sport -> sport.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Sport> getAll() {
        return sports;
    }
}
