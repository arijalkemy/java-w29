package com.example.demo.repository;

import com.example.demo.model.Personas;
import com.example.demo.model.Sintomas;

import java.util.List;
import java.util.Optional;

public interface ICovidrepository {

    //ver todos los sintomas cargados
    List<Sintomas> findSintomas();

    //Ver sintoma por nombre
    Optional<Sintomas> findByName(String n);

    //ver personas de grupo de riesgo
    List<Personas> findPersonasGrupoRiesgo();
}
