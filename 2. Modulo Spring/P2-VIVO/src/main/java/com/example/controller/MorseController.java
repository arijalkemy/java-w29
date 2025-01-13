package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {

    // Mapa para convertir letras a código Morse
    private static final Map<Character, String> morseCodeMap = new HashMap<>();
    // Mapa para convertir código Morse a letras
    private static final Map<String, Character> morseToCharMap = new HashMap<>();

    static {
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
        morseCodeMap.put(' ', "/"); // Separador para palabras

        // Llenando el mapa inverso
        for (Map.Entry<Character, String> entry : morseCodeMap.entrySet()) {
            morseToCharMap.put(entry.getValue(), entry.getKey());
        }
    }

    @GetMapping("/morse/{morseCode}")
    public String convertMorseToText(@PathVariable String morseCode) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] morseChars = morseCode.split(" "); // Dividir el string por espacios

        for (String morseChar : morseChars) {
            if (morseToCharMap.containsKey(morseChar)) {
                decodedMessage.append(morseToCharMap.get(morseChar));
            } else {
                decodedMessage.append("?"); // Para caracteres desconocidos
            }
        }

        return decodedMessage.toString();
    }
}

