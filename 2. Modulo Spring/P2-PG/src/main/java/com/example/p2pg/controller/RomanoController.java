package com.example.p2pg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class RomanoController {

    private static final Map<Integer, String> ROMANOS = new LinkedHashMap<>();
    static {
        ROMANOS.put(1000, "M");
        ROMANOS.put(900, "CM");
        ROMANOS.put(500, "D");
        ROMANOS.put(400, "CD");
        ROMANOS.put(100, "C");
        ROMANOS.put(90, "XC");
        ROMANOS.put(50, "L");
        ROMANOS.put(40, "XL");
        ROMANOS.put(10, "X");
        ROMANOS.put(9, "IX");
        ROMANOS.put(5, "V");
        ROMANOS.put(4, "IV");
        ROMANOS.put(1, "I");
    }

    @GetMapping("/convertirRomano/{numero}")
    public String convertirRomano(@PathVariable Integer numero) {
        StringBuilder resultado = new StringBuilder();//el resultado final
        if (numero <= 0) {
            return "Error: El número debe ser mayor a 0";
        }
        for (Map.Entry<Integer, String> entrada : ROMANOS.entrySet()) {
            while (numero >= entrada.getKey()) {//si el numero es mayor a la key
                resultado.append(entrada.getValue());//value es el nro romano
                numero -= entrada.getKey();//lo importante es que lo resta
            }
        }
        return resultado.toString();
    }
}
