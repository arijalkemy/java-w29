package com.example.deportistas.services;

import com.example.deportistas.models.Deporte;

import java.util.List;

public interface DeportesService {
    List<Deporte> getAllDeportes();

    Deporte getByName(String name);
}
