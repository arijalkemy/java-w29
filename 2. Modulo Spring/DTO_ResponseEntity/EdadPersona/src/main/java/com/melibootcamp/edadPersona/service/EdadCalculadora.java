package com.melibootcamp.edadPersona.service;

import com.melibootcamp.edadPersona.Repository;
import com.melibootcamp.edadPersona.entity.Persona;
import org.springframework.http.ResponseEntity;
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
