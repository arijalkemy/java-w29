package com.bootcamp.repository;

import com.bootcamp.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findByText(String text);
}
