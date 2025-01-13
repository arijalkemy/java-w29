package com.bootcamp.morse.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {

    public String translate(String code) {
        HashMap<String, String> morseCodeMap = new HashMap<>();
        StringBuilder currentCharString = new StringBuilder();
        StringBuilder result = new StringBuilder();
        // Letras
        morseCodeMap.put(".-", "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.", "F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..", "I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..", "L");
        morseCodeMap.put("--", "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-", "U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-", "X");
        morseCodeMap.put("-.--", "Y");
        morseCodeMap.put("--..", "Z");

        // Números
        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2");
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6");
        morseCodeMap.put("--...", "7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");
        morseCodeMap.put("-----", "0");

        // Caracteres especiales
        morseCodeMap.put("..--..", "?");
        morseCodeMap.put("-.-.--", "!");
        morseCodeMap.put(".-.-.-", ".");
        morseCodeMap.put("--..--", ",");

        for (int i = 0; i < code.length(); i++) {
            char currentStringChar = code.charAt(i);

            if (currentStringChar != ' ') {
                currentCharString.append(currentStringChar);
            } else if (morseCodeMap.containsKey(currentCharString.toString())) {
                result.append(morseCodeMap.get(currentCharString.toString()));
                currentCharString.delete(0, currentCharString.length());
            }
        }

        // Procesar el último código Morse si no termina con un espacio
        if (!currentCharString.isEmpty() && morseCodeMap.containsKey(currentCharString.toString())) {
            result.append(morseCodeMap.get(currentCharString.toString()));
        }

        return result.toString();
    }

}
