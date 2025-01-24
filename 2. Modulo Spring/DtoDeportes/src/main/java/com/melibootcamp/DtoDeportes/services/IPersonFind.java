package com.melibootcamp.DtoDeportes.services;

import com.melibootcamp.DtoDeportes.dto.DtoSportPerson;

public interface IPersonFind {
    DtoSportPerson findSportPerson(String name);
    public void createPerson(String name, String lastName,Integer years);
    public void addSportToPerson(String name, String sport);
}
