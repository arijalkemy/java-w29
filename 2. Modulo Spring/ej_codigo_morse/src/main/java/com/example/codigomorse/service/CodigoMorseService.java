package com.example.codigomorse.service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseService {

    private static final Map<String, String> morseToText = new HashMap<>();

    static {
        morseToText.put(".-", "A");
        morseToText.put("-...", "B");
        morseToText.put("-.-.", "C");
        morseToText.put("-..", "D");
        morseToText.put(".", "E");
        morseToText.put("..-.", "F");
        morseToText.put("--.", "G");
        morseToText.put("....", "H");
        morseToText.put("..", "I");
        morseToText.put(".---", "J");
        morseToText.put("-.-", "K");
        morseToText.put(".-..", "L");
        morseToText.put("--", "M");
        morseToText.put("-.", "N");
        morseToText.put("---", "O");
        morseToText.put(".--.", "P");
        morseToText.put("--.-", "Q");
        morseToText.put(".-.", "R");
        morseToText.put("...", "S");
        morseToText.put("-", "T");
        morseToText.put("..-", "U");
        morseToText.put("...-", "V");
        morseToText.put(".--", "W");
        morseToText.put("-..-", "X");
        morseToText.put("-.--", "Y");
        morseToText.put("--..", "Z");
        morseToText.put("-----", "0");
        morseToText.put(".----", "1");
        morseToText.put("..---", "2");
        morseToText.put("...--", "3");
        morseToText.put("....-", "4");
        morseToText.put(".....", "5");
        morseToText.put("-....", "6");
        morseToText.put("--...", "7");
        morseToText.put("---..", "8");
        morseToText.put("----.", "9");
        morseToText.put(".-.-.-", ".");
        morseToText.put("--..--", ",");
        morseToText.put("..--..", "?");
        morseToText.put("-.-.--", "!");
    }

    public String fromMorse(String codigoMorse) {
        StringBuilder resultado = new StringBuilder();

        String[] palabras = codigoMorse.split(" {3}");

        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");

            for (String letra : letras) {
                String letraDescodificada = morseToText.get(letra);
                if (letraDescodificada == null) {
                    throw new IllegalArgumentException("Mensaje inválido");
                }
                resultado.append(letraDescodificada);
            }
            resultado.append(" ");
        }

        return resultado.toString().trim();
    }
}
