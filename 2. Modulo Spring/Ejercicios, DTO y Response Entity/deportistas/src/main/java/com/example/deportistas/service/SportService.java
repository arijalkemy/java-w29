package com.example.deportistas.service;

import com.example.deportistas.model.Sport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class SportService {

    private List<Sport> sportList;

    public SportService() {
        sportList = new ArrayList<>();
        sportList.add(new Sport(1,"Tenis"));
        sportList.add(new Sport(2,"Bascketball"));
        sportList.add(new Sport(3,"Football"));
    }

    public List<Sport> getSportList() {
        return sportList;
    }

    public void setSportList(List<Sport> sportList) {
        this.sportList = sportList;
    }

    public void add(Sport sport) {
        sportList.add(sport);
    }

    public Sport findSport(String sportName) {
        Optional<Sport> s = sportList.stream().filter(sport -> sport.getNombre().equals(sportName)).findFirst();
        if (s.isPresent()) {
            return s.get();
        }else throw new IllegalArgumentException("El sport no existe");
    }
}
