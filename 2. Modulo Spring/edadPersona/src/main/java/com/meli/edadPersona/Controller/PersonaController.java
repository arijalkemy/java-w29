package com.meli.edadPersona.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public Object calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

        if(dia < 1 || mes < 1 || mes > 12 || anio < 1){
            return "Los valores de día, mes o año no pueden ser negativos o inválidos.";
        }

        try {
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();

            Period periodo = Period.between(fechaNacimiento, fechaActual);
            return periodo.getYears();
        }catch (DateTimeException e) {
            return "La fecha de nacimiento no es correcta: " + e.getMessage();
        }
    }
}
