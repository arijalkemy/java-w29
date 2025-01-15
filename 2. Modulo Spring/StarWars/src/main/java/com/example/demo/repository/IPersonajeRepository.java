package com.example.demo.repository;

import com.example.demo.model.Personaje;

import java.util.List;
import java.util.Optional;

public interface IPersonajeRepository {
    Optional<List<Personaje>> encontrarPersonajes();
}
