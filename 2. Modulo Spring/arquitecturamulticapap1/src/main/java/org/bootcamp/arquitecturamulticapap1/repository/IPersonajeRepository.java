package org.bootcamp.arquitecturamulticapap1.repository;

import org.bootcamp.arquitecturamulticapap1.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> getPersonajeByName(String name);
}
