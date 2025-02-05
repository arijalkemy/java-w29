package com.starwars.starwars.repository;

import java.util.List;

import com.starwars.starwars.model.Personaje;

public interface IPersonajeRepository {
    public List<Personaje> getAllPersonajes();
    public Personaje getPersonajeByName(String name);
    public void addPersonaje(Personaje personaje);
    public void updatePersonaje(Personaje personaje);
    public void deletePersonaje(Personaje personaje);
}
