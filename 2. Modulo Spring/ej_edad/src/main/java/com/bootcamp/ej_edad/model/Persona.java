package com.bootcamp.ej_edad.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Persona {
    private UUID idPersona;
    private LocalDate fechaNacimiento;
}
