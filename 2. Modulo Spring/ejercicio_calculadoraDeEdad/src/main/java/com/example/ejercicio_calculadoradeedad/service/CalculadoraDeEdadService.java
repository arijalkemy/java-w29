package com.example.ejercicio_calculadoradeedad.service;

import com.example.ejercicio_calculadoradeedad.model.Persona;
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


}
