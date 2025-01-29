package com.example.PruebaFactorial.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CodigoMorze {

    @GetMapping("/{codigo}")
    public String morseATexto(@PathVariable String codigo) {
        Map<String, String> letras = new HashMap<>();
        letras.put(".-", "A");
        letras.put("-...", "B");
        letras.put("-.-.", "C");
        letras.put("-..", "D");
        letras.put(".", "E");
        letras.put("..-.", "F");
        letras.put("--.", "G");
        letras.put("....", "H");
        letras.put("..", "I");
        letras.put(".---", "J");
        letras.put("-.-", "K");
        letras.put(".-..", "L");
        letras.put("--", "M");
        letras.put("-.", "N");
        letras.put("---", "O");
        letras.put(".--.", "P");
        letras.put("--.-", "Q");
        letras.put(".-.", "R");
        letras.put("...", "S");
        letras.put("-", "T");
        letras.put("..-", "U");
        letras.put("...-", "V");
        letras.put(".--", "W");
        letras.put("-..-", "X");
        letras.put("-.--", "Y");
        letras.put("--..", "Z");

        StringBuilder letraCodigo = new StringBuilder();
        StringBuilder espacio = new StringBuilder();
        StringBuilder salida = new StringBuilder();

        for (Character letra : codigo.toCharArray()) {
            if (letra == '.' || letra == '-') {
                letraCodigo.append(letra);
            } else if (letra == ' ') {
                if (letraCodigo.length() > 0) {
                    salida.append(letras.get(letraCodigo.toString()));
                    letraCodigo = new StringBuilder();
                }
                espacio.append(letra);
                if (espacio.length() == 3) {
                    salida.append(" ");
                    espacio = new StringBuilder();
                }
            }
        }

        if (letraCodigo.length() > 0) {
            salida.append(letras.get(letraCodigo.toString()));
        }

        return salida.toString();
    }
}
