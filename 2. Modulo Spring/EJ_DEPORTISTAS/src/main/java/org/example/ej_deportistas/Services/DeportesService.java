package org.example.ej_deportistas.Services;

import org.example.ej_deportistas.Models.Deporte;

import java.util.List;

public interface DeportesService {

    List<Deporte> getAllDeportes();

    Deporte getDeportebyName(String nombre);
}
