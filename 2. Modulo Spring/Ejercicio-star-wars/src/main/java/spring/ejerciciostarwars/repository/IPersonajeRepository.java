package spring.ejerciciostarwars.repository;

import spring.ejerciciostarwars.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findByName(String name);
}
