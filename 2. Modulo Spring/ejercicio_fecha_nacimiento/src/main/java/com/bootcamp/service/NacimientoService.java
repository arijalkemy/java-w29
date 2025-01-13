package com.bootcamp.service;

import com.bootcamp.model.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NacimientoService {

    public static final List<Persona> personas = new ArrayList<>();

    public String calcularEdad(Integer dia, Integer mes, Integer anio) {
        LocalDate fechaActual = LocalDate.now(), fechaNacimiento = LocalDate.of(anio, mes, dia);
        if (fechaNacimiento.isAfter(fechaActual)) {
            return "El Nacimiento es mayor a la fecha actual";
        }
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return "La edad de la persona es " + periodo.getYears() + " años";
    }

    public String getEdadById(Long id) {
        Optional<Persona> p = personas.stream()
                .filter(persona -> persona.getId().equals(id))
                .findFirst();
        if (p.isPresent()) {
            return "La edad es: " + calcularEdad(p.get().getDia(), p.get().getMes(), p.get().getAnio());
        }
        return "La edad no existe";
    }

    public Persona agregarPersona(Persona persona) {
        personas.add(persona);
        return persona;
    }
}
