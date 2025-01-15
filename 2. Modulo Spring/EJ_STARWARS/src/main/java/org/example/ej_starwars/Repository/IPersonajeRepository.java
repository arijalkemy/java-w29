package org.example.ej_starwars.Repository;

import org.example.ej_starwars.Entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> getAll();
    
}
