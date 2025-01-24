package com.melibootcamp.DtoDeportes.services;

import com.melibootcamp.DtoDeportes.entity.Sport;

import java.util.List;

public interface ISportFinder {
    List<Sport> findSports();
    Sport findSport(String name);
    void createSport(String name, String level);
}
