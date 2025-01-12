package com.bootcamp.controller;

import com.bootcamp.service.NacimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacimientoController {

    @Autowired
    private NacimientoService nacimientoService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer dia,
                               @PathVariable Integer mes,
                               @PathVariable Integer anio) {
        return nacimientoService.calcularEdad(dia, mes, anio);
    }
}
