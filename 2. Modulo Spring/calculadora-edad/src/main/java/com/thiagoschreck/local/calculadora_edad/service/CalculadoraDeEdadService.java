package com.thiagoschreck.local.calculadora_edad.service;

import com.thiagoschreck.local.calculadora_edad.model.Persona;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraDeEdadService {
    private final List<Persona> personas = new ArrayList<>();

    public Integer calcular(Persona.FechaDeNacimiento fechaDeNacimiento) {
        LocalDate fechaNacimiento = LocalDate.of(fechaDeNacimiento.year(), fechaDeNacimiento.month(), fechaDeNacimiento.day());
        Period period = Period.between(fechaNacimiento, LocalDate.now());
        return Math.abs(period.getYears());
    }

    public Persona agregarPersona(Persona persona) {
        personas.add(persona);
        return persona;
    }

    public Persona buscarPersona(int id) {
        return personas.stream()
                .filter(persona -> id == persona.id())
                .findFirst()
                .orElse(null);
    }

    public List<Persona> buscarPersonas(Persona.FechaDeNacimiento fechaDeNacimiento) {
        return personas.stream()
                .filter(persona -> fechaDeNacimiento.equals(persona.fechaDeNacimiento()))
                .toList();
    }
}
