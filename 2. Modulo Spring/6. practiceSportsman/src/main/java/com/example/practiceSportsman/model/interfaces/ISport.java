package com.example.practiceSportsman.model.interfaces;

import com.example.practiceSportsman.model.Sport;

import java.util.List;

public interface ISport {
    void addSport(Sport sport);
    List<Sport> getAllSports();
    Sport getSportByName(String name);
}
