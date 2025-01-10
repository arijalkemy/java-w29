package com.example.codigo_morse.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CodigoMorseController {

    private final Map<String, Character> morseMap;

    public CodigoMorseController() {
        morseMap = new HashMap<>();

        String[] lettersToCompare = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                "?", "!", ".", ","
        };

        String[] morseSymbols = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----",
                "..--..", "-.-.--", ".-.-.-", "--..--"
        };

        for (int i = 0; i < morseSymbols.length; i++) {
            morseMap.put(morseSymbols[i], lettersToCompare[i].charAt(0));
        }
    }

    @PostMapping("/phrase")
    public String translateToMorse(@RequestBody Map<String, String> json) {
        String frase = json.get("frase");
        StringBuilder morseTranslation = new StringBuilder();

        for (char c : frase.toUpperCase().toCharArray()) {
            if (morseMap.containsKey(c)) {
                morseTranslation.append(morseMap.get(c)).append("");
            } else if (c == ' ') {
                morseTranslation.append("/ ");
            }
        }

        return morseTranslation.toString().trim();
    }

    @PostMapping("/morse_code")
    public String translateToLetters(@RequestBody Map<String, String> json) {
        String codigo = json.get("codigo");
        StringBuilder lettersTranslation = new StringBuilder();
        System.out.println(codigo);
        String[] morseWords = codigo.split(" {3}");

        for (String morseWord: morseWords) {
            String[] MorseLetters = morseWord.split(" ");
            System.out.println(MorseLetters);
            for (String morseLetter: MorseLetters) {
                if (morseMap.containsKey(morseLetter)) {
                    lettersTranslation.append(morseMap.get(morseLetter)).append("");
                } else {
                    System.out.println("MorseLetter not valid: " + morseLetter);
                }
            }
        }

        return lettersTranslation.toString().trim();
    }
}
