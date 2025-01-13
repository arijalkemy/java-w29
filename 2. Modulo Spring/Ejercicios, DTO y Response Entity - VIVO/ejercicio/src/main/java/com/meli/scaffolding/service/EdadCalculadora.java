package com.meli.scaffolding.service;

import com.meli.scaffolding.Repository;
import com.meli.scaffolding.entity.Persona;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
@Service
public class EdadCalculadora implements IEdadCalculadora {
    @Override
    public int calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
    @Override
    public void guardarPersona(Persona persona) {
        Repository.addPersona(persona);
    }
    @Override
    public Persona buscarPersona(String id) {
        return Repository.buscarPersona(id);
    }
}
