package com.melibootcamp.DtoDeportes.repository;

import com.melibootcamp.DtoDeportes.entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SportRepository {
    static List<Sport> sports=new ArrayList<>();
    public static void addSport(Sport sport){
        sports.add(sport);
    }
    public static Sport findSport(String name){
        for (Sport sport:sports) {
            if(sport.getName().equals(name)){
                return sport;
            }
        }
        return null;
    }

    public static void setSports(List<Sport> sports) {
        SportRepository.sports = sports;
    }

    public static List<Sport> getSports() {
        return sports;
    }
}
