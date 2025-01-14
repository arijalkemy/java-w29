package com.example.demo.repository;

import com.example.demo.model.Personaje;

import java.util.List;

public interface PersonajeRepository {

    List<Personaje> findAll ();
}
