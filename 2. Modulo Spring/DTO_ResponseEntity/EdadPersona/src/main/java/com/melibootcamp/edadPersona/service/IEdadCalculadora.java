package com.melibootcamp.edadPersona.service;

import com.melibootcamp.edadPersona.entity.Persona;

import java.time.LocalDate;

public interface IEdadCalculadora {
    public int calcularEdad(LocalDate fechaNacimiento);
    public Persona buscarPersona(String id);
    public void guardarPersona(Persona persona);
}
