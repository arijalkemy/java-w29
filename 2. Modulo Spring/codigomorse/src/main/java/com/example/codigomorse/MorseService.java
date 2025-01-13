package com.example.codigomorse;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {

    private static final Map<String, String> morseDict = new HashMap<>();

    static {

        morseDict.put(".-", "A");
        morseDict.put("-...", "B");
        morseDict.put("-.-.", "C");
        morseDict.put("-..", "D");
        morseDict.put(".", "E");
        morseDict.put("..-.", "F");
        morseDict.put("--.", "G");
        morseDict.put("....", "H");
        morseDict.put("..", "I");
        morseDict.put(".---", "J");
        morseDict.put("-.-", "K");
        morseDict.put(".-..", "L");
        morseDict.put("--", "M");
        morseDict.put("-.", "N");
        morseDict.put("---", "O");
        morseDict.put(".--.", "P");
        morseDict.put("--.-", "Q");
        morseDict.put(".-.", "R");
        morseDict.put("...", "S");
        morseDict.put("-", "T");
        morseDict.put("..-", "U");
        morseDict.put("...-", "V");
        morseDict.put(".--", "W");
        morseDict.put("-..-", "X");
        morseDict.put("-.--", "Y");
        morseDict.put("--..", "Z");
        morseDict.put(".-.-.-", ".");
        morseDict.put("--..--", ",");
        morseDict.put("..--..", "?");
        morseDict.put(".----.", "'");
        morseDict.put("-....-", "-");
        morseDict.put("-.--.", "(");
        morseDict.put("-.--.-", ")");
        morseDict.put(".-.-.", "+");
        morseDict.put("--..-.", "/");
        morseDict.put("---...", ":");
        morseDict.put(".----", "1");
        morseDict.put("..---", "2");
        morseDict.put("...--", "3");
        morseDict.put("....-", "4");
        morseDict.put(".....", "5");
        morseDict.put("-....", "6");
        morseDict.put("--...", "7");
        morseDict.put("---..", "8");
        morseDict.put("----.", "9");
        morseDict.put("-----", "0");
    }

    public String translateMorseToText(String morseCode) {
        String[] words = morseCode.trim().split("   ");
        StringBuilder translatedMessage = new StringBuilder();

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                translatedMessage.append(morseDict.getOrDefault(letter, ""));
            }
            translatedMessage.append(" ");
        }

        return translatedMessage.toString().trim();
    }
}

