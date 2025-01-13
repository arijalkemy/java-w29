package com.example.introduccionspring.utils;

import java.util.Map;
import java.util.HashMap;
import java.lang.Character;

public class MorseParse {
    private static final Map<Character, String> morseToText = new HashMap<>();
    private static final Map<String, Character> textToMorse = new HashMap<>();

    static {
        // Alfabeto y códigos Morse
        String[] letras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        // Mapeo letras a Morse y viceversa
        for (int i = 0; i < letras.length; i++) {
            morseToText.put(letras[i].charAt(0), morse[i]);
            textToMorse.put(morse[i], letras[i].charAt(0));
        }

        // Mapeo de números con los códigos Morse estándar para los dígitos
        String[] morseNumeros = { "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----." };

        for (int i = 0; i < 10; i++) {
            morseToText.put((char) ('0' + i), morseNumeros[i]);
            textToMorse.put(morseNumeros[i], (char) ('0' + i));
        }


        // Mapeo de caracteres especiales
        morseToText.put('.', ".-.-.-");
        morseToText.put(',', "--..--");
        morseToText.put('?', "..--..");
        morseToText.put('!', "-.-.--");
        morseToText.put(':', "---...");
        morseToText.put(';', "-.-.-.");
        morseToText.put('(', "-.--.");
        morseToText.put(')', "-.--.-");
        morseToText.put('"', ".-..-.");
        morseToText.put(' ', "/");

        // Mapeo de caracteres especiales a Morse
        textToMorse.put(".-.-.-", '.');
        textToMorse.put("--..--", ',');
        textToMorse.put("..--..", '?');
        textToMorse.put("-.-.--", '!');
        textToMorse.put("---...", ':');
        textToMorse.put("-.-.-.", ';');
        textToMorse.put("-.--.", '(');
        textToMorse.put("-.--.-", ')');
        textToMorse.put(".-..-.", '"');
        textToMorse.put("/", ' ');
    }

    // Método para convertir Morse a texto
    public static String morseToSpanish(String morse) {
        StringBuilder result = new StringBuilder();
        String[] morseWords = morse.split(" ");
        for (String word : morseWords) {
            String[] morseLetters = word.split(" ");
            for (String letter : morseLetters) {
                Character spanishLetter = textToMorse.get(letter);
                if (spanishLetter != null) {
                    result.append(spanishLetter);
                } else {
                    result.append("?");
                }
            }
        }

        return result.toString().trim();
    }


    // Método para convertir texto a Morse
    public static String spanishToMorse(String text) {
        StringBuilder result = new StringBuilder();
        text = text.toUpperCase();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                result.append(" ");
            } else {
                String morseCode = morseToText.get(c);
                if (morseCode != null) {
                    result.append(morseCode).append(" ");
                } else {
                    result.append("? ");
                }
            }
        }

        return result.toString().trim();
    }
}
