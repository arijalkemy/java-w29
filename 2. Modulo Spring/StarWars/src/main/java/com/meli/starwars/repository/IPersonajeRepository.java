package com.meli.starwars.repository;


import com.meli.starwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    public List<Personaje> searchByName(String name);
}
