package com.morse.practicamorse.Services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseCodeTranslator {

    private static final Map<String, String> MORSE_CODE_MAP = new HashMap<>();

    static {
        // Diccionario de traducción de Morse a texto.
        MORSE_CODE_MAP.put(".-", "A");
        MORSE_CODE_MAP.put("-...", "B");
        MORSE_CODE_MAP.put("-.-.", "C");
        MORSE_CODE_MAP.put("-..", "D");
        MORSE_CODE_MAP.put(".", "E");
        MORSE_CODE_MAP.put("..-.", "F");
        MORSE_CODE_MAP.put("--.", "G");
        MORSE_CODE_MAP.put("....", "H");
        MORSE_CODE_MAP.put("..", "I");
        MORSE_CODE_MAP.put(".---", "J");
        MORSE_CODE_MAP.put("-.-", "K");
        MORSE_CODE_MAP.put(".-..", "L");
        MORSE_CODE_MAP.put("--", "M");
        MORSE_CODE_MAP.put("-.", "N");
        MORSE_CODE_MAP.put("---", "O");
        MORSE_CODE_MAP.put(".--.", "P");
        MORSE_CODE_MAP.put("--.-", "Q");
        MORSE_CODE_MAP.put(".-.", "R");
        MORSE_CODE_MAP.put("...", "S");
        MORSE_CODE_MAP.put("-", "T");
        MORSE_CODE_MAP.put("..-", "U");
        MORSE_CODE_MAP.put("...-", "V");
        MORSE_CODE_MAP.put(".--", "W");
        MORSE_CODE_MAP.put("-..-", "X");
        MORSE_CODE_MAP.put("-.--", "Y");
        MORSE_CODE_MAP.put("--..", "Z");
        MORSE_CODE_MAP.put("-----", "0");
        MORSE_CODE_MAP.put(".----", "1");
        MORSE_CODE_MAP.put("..---", "2");
        MORSE_CODE_MAP.put("...--", "3");
        MORSE_CODE_MAP.put("....-", "4");
        MORSE_CODE_MAP.put(".....", "5");
        MORSE_CODE_MAP.put("-....", "6");
        MORSE_CODE_MAP.put("--...", "7");
        MORSE_CODE_MAP.put("---..", "8");
        MORSE_CODE_MAP.put("----.", "9");
        MORSE_CODE_MAP.put("..--..", "?");
        MORSE_CODE_MAP.put(".-.-.-", ".");
        MORSE_CODE_MAP.put("-.-.--", "!");
        MORSE_CODE_MAP.put("--..--", ",");
    }

    public String translate(String morseCode) {
        StringBuilder sb = new StringBuilder();

        // Divide el código Morse en palabras (separadas por 3 espacios).
        String[] words = morseCode.trim().split("   "); // Usa "   " para separar palabras.

        for (String word : words) {
            // Divide cada palabra en caracteres (separados por un espacio simple).
            String[] characters = word.split(" ");
            for (String character : characters) {
                // Traduce cada carácter Morse a texto.
                sb.append(MORSE_CODE_MAP.getOrDefault(character, "?"));
            }
            // Añade un espacio entre palabras traducidas.
            sb.append(" ");
        }

        // Devuelve el texto traducido, eliminando espacios innecesarios al final.
        return sb.toString().trim();
    }

}
