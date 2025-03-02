package com.edadpers.edadpersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class obtenerEdad {

    @GetMapping("/{dia}/{mes}/{anio}")
    public String obtenerEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

        int edad = 0;

        LocalDateTime hoy = LocalDateTime.now();

        int diaActual = hoy.getDayOfMonth();
        int mesActual = hoy.getMonthValue();
        int anioActual = hoy.getYear();

        if (mesActual < mes){
            edad = anioActual - anio - 1;
        } else if (mesActual == mes && diaActual < dia){
            edad = anioActual - anio - 1;
        } else {
            edad = anioActual - anio;
        }

        return "La edad es: " + edad;
    }
}
