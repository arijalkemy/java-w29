package com.bootcamp.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class NacimientoService {

    public String calcularEdad(Integer dia, Integer mes, Integer anio) {
        LocalDate fechaActual = LocalDate.now(), fechaNacimiento = LocalDate.of(anio, mes, dia);
        if (fechaNacimiento.isAfter(fechaActual)) {
            return "El Nacimiento es mayor a la fecha actual";
        }
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return "La edad de la persona es " + periodo.getYears() + " años";

    }
}
