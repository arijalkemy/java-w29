package com.springboot.codigomorse.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CodigoMorseRestController {

    @GetMapping("/codigomorse/{letra}")
    public String conversorCodigoMorseALetra(@PathVariable String letra){
        return codigoMorse(letra);
    }

    private String codigoMorse(String letra){
        final HashMap<String, String> mapaMorse = new HashMap<>();
        mapaMorse.put(".-", "A");
        mapaMorse.put("-...", "B");
        mapaMorse.put("-.-.", "C");
        mapaMorse.put("-..", "D");
        mapaMorse.put(".", "E");
        mapaMorse.put("..-.", "F");
        mapaMorse.put("--.", "G");
        mapaMorse.put("....", "H");
        mapaMorse.put("..", "I");
        mapaMorse.put(".---", "J");
        mapaMorse.put("-.-", "K");
        mapaMorse.put(".-..", "L");
        mapaMorse.put("--", "M");
        mapaMorse.put("-.", "N");
        mapaMorse.put("---", "O");
        mapaMorse.put(".--.", "P");
        mapaMorse.put("--.-", "Q");
        mapaMorse.put(".-.", "R");
        mapaMorse.put("...", "S");
        mapaMorse.put("T", "T");
        mapaMorse.put("..-", "U");
        mapaMorse.put("...-", "V");
        mapaMorse.put(".--", "W");
        mapaMorse.put("-..-", "X");
        mapaMorse.put("-.--", "Y");
        mapaMorse.put("--..", "Z");
        mapaMorse.put("-----", "0");
        mapaMorse.put(".----", "1");
        mapaMorse.put("..---", "2");
        mapaMorse.put("...--", "3");
        mapaMorse.put("....-", "4");
        mapaMorse.put(".....", "5");
        mapaMorse.put("-....", "6");
        mapaMorse.put("--...", "7");
        mapaMorse.put("---..", "8");
        mapaMorse.put("----.", "9");

        mapaMorse.put(".-.-.-", ".");
        mapaMorse.put("--..--", ",");
        mapaMorse.put("..--..", "?");
        mapaMorse.put("-..-.", "/");
        mapaMorse.put(" ", "  ");

        StringBuilder resultado = new StringBuilder();
        for (char c : letra.toCharArray()){
            String morse = mapaMorse.get(Character.toUpperCase(c));
            if (morse != null){
                resultado.append(morse);
            }
        }
        return resultado.toString();
    }
}
