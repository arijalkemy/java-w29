package com.example.demo.service;

import com.example.demo.model.Persona;

import java.util.Optional;

public interface PersonaService {
    public void savePersona(Persona p);
    public Optional<Persona> buscarPorID(Long id);

    public Integer calcularEdad( Long id);
}
