package com.melibootcamp.edadPersona.entity;

import java.time.LocalDate;

public class Persona {
    String id;
    LocalDate fechaNacimiento;

    public Persona(String id, LocalDate fechaNacimiento) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

