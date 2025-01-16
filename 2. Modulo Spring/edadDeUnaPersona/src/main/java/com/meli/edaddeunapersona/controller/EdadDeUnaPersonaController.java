package com.meli.edaddeunapersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EdadDeUnaPersonaController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer EdadDeUnaPersona(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        LocalDate currentDate = LocalDate.now();
        currentDate = currentDate.minusMonths(mes);
        currentDate = currentDate.minusDays(dia);
        currentDate = currentDate.minusYears(anio);
        return currentDate.getYear();
    }
}
