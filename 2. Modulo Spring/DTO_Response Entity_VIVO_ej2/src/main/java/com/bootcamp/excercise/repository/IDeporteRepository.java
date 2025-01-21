package com.bootcamp.excercise.repository;

import com.bootcamp.excercise.entity.DeporteEntity;
import com.bootcamp.excercise.entity.PersonaEntity;

import java.util.List;

public interface IDeporteRepository {
    List<DeporteEntity> findAllSports();
    List<PersonaEntity> findAllPersons();
    DeporteEntity findSportByName(String nombre);

}
