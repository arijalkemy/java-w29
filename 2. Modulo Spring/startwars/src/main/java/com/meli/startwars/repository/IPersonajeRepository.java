package com.meli.startwars.repository;

import com.meli.startwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> fiendByName(String nombre);
}
