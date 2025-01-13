package com.meli.scaffolding.service;

import com.meli.scaffolding.entity.Persona;

import java.time.LocalDate;

public interface IEdadCalculadora {
    public int calcularEdad(LocalDate fechaNacimiento);
    public Persona buscarPersona(String id);
    public void guardarPersona(Persona persona);
}
