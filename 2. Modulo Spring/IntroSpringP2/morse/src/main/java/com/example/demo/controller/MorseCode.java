package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class MorseCode {

    private String code;
    private String meaning;
    private static Map<Character, String> morseCodeMap = new HashMap<Character,String>();

    // Inverse mapping from Morse code to characters
    private static final Map<String, Character> inverseMorseCodeMap = new HashMap<>();

    static {
        // Initialize the Morse code map
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
        morseCodeMap.put('Ñ', "--.--");   // Morse code for Ñ
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

        // Initialize the inverse Morse code map
        for (Map.Entry<Character, String> entry : morseCodeMap.entrySet()) {
            inverseMorseCodeMap.put(entry.getValue(), entry.getKey());
        }
    }

    public MorseCode(String code, boolean encoded) {
        if (encoded) {
            this.code = code;
            this.meaning = getMeaningInSpanish();
        }else {
            this.meaning = code;
            this.code = encode();
        }
    }

    private String encode() {
        StringBuilder newCode = new StringBuilder();

        Arrays.asList(meaning.split(" "))
                .stream()
                .forEach(word -> newCode.append(wordToMorse(word)).append("  "));

        return newCode.toString();
    }

    private String getMeaningInSpanish() {
        StringBuilder meaning = new StringBuilder();
        
        Arrays.asList(code.split(" {3,}"))
                .stream()
                .forEach(word -> meaning.append(wordToSpanish(word)).append(" "));
        
        return meaning.toString();
    }

    private String wordToSpanish(String word){
        StringBuilder meaning_word = new StringBuilder();
        Arrays.asList(word.split(" "))
                .stream()
                .map(c -> inverseMorseCodeMap.get(c))
                .forEach(b -> meaning_word.append(b));
            
        return meaning_word.toString();
    }

    private String wordToMorse(String word) {
        StringBuilder code_word = new StringBuilder();
        Arrays.asList(word.split("(?!^)"))
                .stream()
                .map(c -> morseCodeMap.get(c.toUpperCase().charAt(0)))
                .forEach(b -> code_word.append(b).append(" "));
            
        return code_word.toString();
    }
    public String toString() {
        return this.meaning;
    }
}
