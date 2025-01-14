package com.example.practiceSportsman.repository;

import com.example.practiceSportsman.model.Sport;
import com.example.practiceSportsman.model.interfaces.ISport;

import java.util.ArrayList;
import java.util.List;

public class SportRepository implements ISport {
    private List<Sport> sports = new ArrayList<>();

    @Override
    public void addSport(Sport sport) {
        sports.add(sport);
    }

    @Override
    public List<Sport> getAllSports() {
        return sports;
    }

    @Override
    public Sport getSportByName(String name) {
        return sports.stream()
                .filter(sport -> sport.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
