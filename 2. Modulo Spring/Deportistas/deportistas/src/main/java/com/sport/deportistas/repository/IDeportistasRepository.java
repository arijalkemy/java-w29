package com.sport.deportistas.repository;

import com.sport.deportistas.entity.Deporte;
import com.sport.deportistas.entity.Persona;

import java.util.List;

public interface IDeportistasRepository {
    List<Persona> searchPersonas();
    List<Deporte> searchDeportes();
    Deporte searchDeporteByName(String name);
}
