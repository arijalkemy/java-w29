package com.bootcamp.EjerciciosDTOResponseEntity_Vivodemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadPersonaController {
    @GetMapping("{dia}/{mes}/{año}")
    public int darEdad(@PathVariable int dia
            , @PathVariable int mes, @PathVariable int año){
        //LocalDate para representar las fechas.
        LocalDate fechaNacimiento = LocalDate.of(año,mes,dia);
        LocalDate fechaActual = LocalDate.now();
        //Period.between: Calcula la diferencia entre dos fechas.
        Period periodo = Period.between(fechaNacimiento,fechaActual);
        //propiedad getYears() da la cantidad de años completos entre las dos fechas.
        return periodo.getYears();
    }
}
