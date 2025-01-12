package com.ejercicio_calculo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TraductorService {

    private static final Map<String, String> MORSE_TO_TEXT = new HashMap<>();

    static {
        MORSE_TO_TEXT.put(".-", "A");
        MORSE_TO_TEXT.put("-...", "B");
        MORSE_TO_TEXT.put("-.-.", "C");
        MORSE_TO_TEXT.put("-..", "D");
        MORSE_TO_TEXT.put(".", "E");
        MORSE_TO_TEXT.put("..-.", "F");
        MORSE_TO_TEXT.put("--.", "G");
        MORSE_TO_TEXT.put("....", "H");
        MORSE_TO_TEXT.put("..", "I");
        MORSE_TO_TEXT.put(".---", "J");
        MORSE_TO_TEXT.put("-.-", "K");
        MORSE_TO_TEXT.put(".-..", "L");
        MORSE_TO_TEXT.put("--", "M");
        MORSE_TO_TEXT.put("-.", "N");
        MORSE_TO_TEXT.put("---", "O");
        MORSE_TO_TEXT.put(".--.", "P");
        MORSE_TO_TEXT.put("--.-", "Q");
        MORSE_TO_TEXT.put(".-.", "R");
        MORSE_TO_TEXT.put("...", "S");
        MORSE_TO_TEXT.put("-", "T");
        MORSE_TO_TEXT.put("..-", "U");
        MORSE_TO_TEXT.put("...-", "V");
        MORSE_TO_TEXT.put(".--", "W");
        MORSE_TO_TEXT.put("-..-", "X");
        MORSE_TO_TEXT.put("-.--", "Y");
        MORSE_TO_TEXT.put("--..", "Z");
    }

    public String traducir(String codigoMorse) {
        StringBuilder sb = new StringBuilder();
        String[] palabras = codigoMorse.split("  ");
        for (String p : palabras) {
            String[] letras = p.split(" ");
            for (String l : letras)
                sb.append(MORSE_TO_TEXT.getOrDefault(l, " "));
        }
        return sb.toString().trim();
    }
}
