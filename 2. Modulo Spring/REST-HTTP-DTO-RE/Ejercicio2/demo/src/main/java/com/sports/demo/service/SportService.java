package com.sports.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.sports.demo.model.Sport;

public class SportService {
    private List<Sport> sportList = new ArrayList<>();

    public SportService () {
        sportList.add(new Sport("Football", "High"));
        sportList.add(new Sport("Basketball", "Medium"));
        sportList.add(new Sport("Tennis", "Low"));
    }

    public List<Sport> getAllSports() {
        return sportList;
    }

    public Sport getSportByName(String name) {
        for (Sport sport : sportList) {
            if (sport.getName().equalsIgnoreCase(name)) {
                return sport;
            }
        }
        return null;
    }
}
