package com.roman_numerals.servicio;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ConvertService {

    private List<Integer> decimales = new ArrayList<>();
    private List<String> romanos = new ArrayList<>();

    public ConvertService() {
        this.decimales = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        this.romanos = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
    }

    public String convert(Integer numero){

        String resultado = "";

        for(int i = 0; i < decimales.size(); i++) {
            while(decimales.get(i) <= numero) {
                numero -= decimales.get(i);
                resultado += romanos.get(i);
            }
        }

        return  resultado;
    }
}
