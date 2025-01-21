package com.bootcamp.excercise.controller;


import com.bootcamp.excercise.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {
    @Autowired
    private EdadService edadService;

    @GetMapping("/{name}/{dia}/{mes}/{año}")
    public String cacularEdad(@PathVariable String name,@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer año){
        return "la edad de " + name + " es: " + edadService.edadACalcular(dia,mes,año);
    }
}
