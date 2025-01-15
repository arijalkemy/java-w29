package com.mercadolibre.javawave29.deportistas.service;

import com.mercadolibre.javawave29.deportistas.model.Sport;
import com.mercadolibre.javawave29.deportistas.model.SportsPersonsDTO;
import java.util.List;

public interface IService {
    List<Sport> findAll();
    Sport findByName(String name);
    List<SportsPersonsDTO> findSportsPersons();
}
