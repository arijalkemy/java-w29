package com.example.demo.service;

import com.example.demo.model.Persona;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImp implements PersonaService {
    private List<Persona> personas =new ArrayList<>();
    @Override
    public void savePersona(Persona p) {
        personas.add(p);

    }

    @Override
    public Optional<Persona> buscarPorID(Long id) {
        boolean persencontrada = false;
        for (Persona persona : personas) {
            if (persona.getId().equals(id)) {
                persencontrada = true;
                return Optional.of(persona);
            }
        }

        if (!persencontrada) {
            System.out.println("No existe el persona con el id " + id);
        }
        return  Optional.empty();
    }

    @Override
    public Integer calcularEdad(Long id) {
        Optional<Persona> p= buscarPorID(id);
        if (p.isEmpty()) {
            System.out.println("No se encontro la persona para calcular la edad");
        }else{

            LocalDate hoy = LocalDate.now();
            LocalDate fechaNacimiento;

            try {
                // Obtener la fecha de nacimiento de la persona
                fechaNacimiento = p.get().getFechaNacimiento();

                // Validar que la fecha no sea futura
                if (fechaNacimiento.isAfter(hoy)) {
                    throw new IllegalArgumentException("La fecha de nacimiento no puede ser mayor que la fecha actual.");
                }

                // Calcular la edad
                return Period.between(fechaNacimiento, hoy).getYears();
            } catch (DateTimeException e) {
                throw new IllegalArgumentException("La fecha proporcionada no es válida.");
            }
        }

        return 0;
    }
}
