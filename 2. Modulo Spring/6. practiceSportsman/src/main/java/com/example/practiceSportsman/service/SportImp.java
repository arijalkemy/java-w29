package com.example.practiceSportsman.service;

import com.example.practiceSportsman.model.Sport;
import com.example.practiceSportsman.repository.SportRepository;

import java.util.List;

public class SportImp {
    private final SportRepository sportRepository;

    public SportImp() {
        sportRepository = new SportRepository();
    }

    public void addSport(Sport sport) {
        sportRepository.addSport(sport);
    }

    public List<Sport> getAllSports() {
        return sportRepository.getAllSports();
    }

    public Sport getSportByName(String name) {
        return sportRepository.getSportByName(name);
    }
}
