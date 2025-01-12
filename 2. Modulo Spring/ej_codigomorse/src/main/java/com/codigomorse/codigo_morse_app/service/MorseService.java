package com.codigomorse.codigo_morse_app.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {

    private final Map<String, String> morseMap;

    public MorseService() {
        this.morseMap = new HashMap<>();
        // Letras del alfabeto
        morseMap.put(".-", "A");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");
        morseMap.put(" ", " ");

        // Números
        morseMap.put("-----", "0");
        morseMap.put(".----", "1");
        morseMap.put("..---", "2");
        morseMap.put("...--", "3");
        morseMap.put("....-", "4");
        morseMap.put(".....", "5");
        morseMap.put("-....", "6");
        morseMap.put("--...", "7");
        morseMap.put("---..", "8");
        morseMap.put("----.", "9");

        // Caracteres comunes
        morseMap.put(".-.-.-", ".");
        morseMap.put("--..--", ",");
        morseMap.put("..--..", "?");
        morseMap.put("-.-.--", "!");
        morseMap.put("-....-", "-");
        morseMap.put(".-.-.", "+");
        morseMap.put("-..-.", "/");
        morseMap.put("-.--.", "(");
        morseMap.put("-.--.-", ")");
        morseMap.put(".-...", "&");
        morseMap.put("---...", ":");
        morseMap.put("-.-.-.", ";");
    }

    public String translate(String morse) {
        StringBuilder translatedText = new StringBuilder();
        String[] words = morse.trim().split(" {3}");
        for(String word : words) {

            String[] letters = word.split(" ");
            for (String letter : letters) {
                translatedText.append(morseMap.getOrDefault(letter, "?"));
            }

            translatedText.append(" ");
        }
        return translatedText.toString();

    }
}
