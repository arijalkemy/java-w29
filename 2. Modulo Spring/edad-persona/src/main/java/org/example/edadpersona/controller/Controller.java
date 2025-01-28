package org.example.edadpersona.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/")
public class Controller {
    @GetMapping("/{dia}/{mes}/{anio}")
    public String fechaDeNacimiento (@PathVariable String dia, @PathVariable String mes, @PathVariable String anio){
        return (dia+"/"+mes+"/"+anio);
    }
}
