package com.example.NumerosRomanos;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {
    Map<Character,Integer> ROMANOS = Map.of(
            'I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);


    public Integer convertirMensaje(@RequestParam int numeroArabigo) {
        return convertirArabigosARomanos(numeroArabigo);
    }

    public Integer convertirArabigosARomanos(int numeroArabigo) {
        StringBuilder romano = new StringBuilder();

        ROMANOS.forEach((valor, simbolo) -> {
            while (numero >= valor) {
                romano.append(simbolo);
                numero -= valor;
            }
        });

        return romano.toString();
    }

}


