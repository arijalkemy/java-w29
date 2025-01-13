package org.bootcamp.dtoyresponseentityp1.service;

import org.bootcamp.dtoyresponseentityp1.model.Persona;
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
                .filter(persona -> fechaDeNacimiento.day() == persona.fechaDeNacimiento().day()
                        && fechaDeNacimiento.month() == persona.fechaDeNacimiento().month()
                        && fechaDeNacimiento.year() == persona.fechaDeNacimiento().year())
                .toList();
    }

    public List<Persona> getTodasLasPersonas() {
        return personas;
    }
}