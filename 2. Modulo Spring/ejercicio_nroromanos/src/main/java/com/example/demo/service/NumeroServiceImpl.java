package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class NumeroServiceImpl implements NumeroService {

    @Override
    public String transformar(Long n) {
        if (n <= 0 || n > 3999) {
            throw new IllegalArgumentException("El número debe estar entre 1 y 3999");
        }

        // Mapa con los valores romanos y sus equivalentes en números
        Map<Integer, String> mapaRomano = new LinkedHashMap<>();
        mapaRomano.put(1000, "M");
        mapaRomano.put(900, "CM");
        mapaRomano.put(500, "D");
        mapaRomano.put(400, "CD");
        mapaRomano.put(100, "C");
        mapaRomano.put(90, "XC");
        mapaRomano.put(50, "L");
        mapaRomano.put(40, "XL");
        mapaRomano.put(10, "X");
        mapaRomano.put(9, "IX");
        mapaRomano.put(5, "V");
        mapaRomano.put(4, "IV");
        mapaRomano.put(1, "I");

        // Cadena para construir el resultado
        StringBuilder romano = new StringBuilder();

        // Convertir el número
        for (Map.Entry<Integer, String> entrada : mapaRomano.entrySet()) {
            while (n >= entrada.getKey()) {
                romano.append(entrada.getValue());
                n -= entrada.getKey();
            }
        }

        return romano.toString();

    }
}
