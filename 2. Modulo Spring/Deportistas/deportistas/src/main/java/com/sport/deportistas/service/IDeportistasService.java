package com.sport.deportistas.service;

import com.sport.deportistas.dto.DeporteDTO;
import com.sport.deportistas.dto.DeportistaDTO;

import java.util.List;

public interface IDeportistasService {
    List<DeporteDTO> findSports();
    DeporteDTO findSportsByName(String name);

    List<DeportistaDTO> findSportsPersons();
}
