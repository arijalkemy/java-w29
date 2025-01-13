package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;

public class Persona {
    private  Long id;
    private LocalDate fechaNacimiento;


    public Persona(Long id, LocalDate fechaNacimiento) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
