package com.bootcamp.sports.repositories;

import com.bootcamp.sports.models.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SportRepository {

    private List<Sport> sports = new ArrayList<>(List.of(
            new Sport("Football", 1),
            new Sport("Football", 2),
            new Sport("Handball", 1)
        ));

    public List<Sport> getSports() {
        return sports;
    }
}
