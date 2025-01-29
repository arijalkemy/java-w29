package com.example.EjercicioHTTPBootcamp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Nacimiento {
    @GetMapping("/{dia}/{mes}/{ano}")
    public Integer edad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano) {
        int tMes;
        int tAno;
        int tDia;
        tDia = 13;
        tMes = 1;
        tAno = 2025;

        int edadDia;
        int edadMes;
        int edadAno;

        edadDia = tDia - dia;
        edadMes = tMes - mes;
        edadAno = tAno - ano;

        if (edadDia < 0 && edadMes < 0) {
            edadAno -= 1;
        }

        return edadAno;
    }
}
