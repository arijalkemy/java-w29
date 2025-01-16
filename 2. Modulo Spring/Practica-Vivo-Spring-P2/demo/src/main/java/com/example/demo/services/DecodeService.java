package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DecodeService {

    private final Map<String, String> codes = new HashMap<>();

    public DecodeService() {
        // Letras
        codes.put(".-", "A");
        codes.put("-...", "B");
        codes.put("-.-.", "C");
        codes.put("-..", "D");
        codes.put(".", "E");
        codes.put("..-.", "F");
        codes.put("--.", "G");
        codes.put("....", "H");
        codes.put("..", "I");
        codes.put(".---", "J");
        codes.put("-.-", "K");
        codes.put(".-..", "L");
        codes.put("--", "M");
        codes.put("-.", "N");
        codes.put("---", "O");
        codes.put(".--.", "P");
        codes.put("--.-", "Q");
        codes.put(".-.", "R");
        codes.put("...", "S");
        codes.put("-", "T");
        codes.put("..-", "U");
        codes.put("...-", "V");
        codes.put(".--", "W");
        codes.put("-..-", "X");
        codes.put("-.--", "Y");
        codes.put("--..", "Z");

        // Números
        codes.put("-----", "0");
        codes.put(".----", "1");
        codes.put("..---", "2");
        codes.put("...--", "3");
        codes.put("....-", "4");
        codes.put(".....", "5");
        codes.put("-....", "6");
        codes.put("--...", "7");
        codes.put("---..", "8");
        codes.put("----.", "9");

        // Signos de puntuación
        codes.put(".-.-.-", ".");
        codes.put("--..--", ",");
        codes.put("---...", ":");
        codes.put("..--..", "?");
        codes.put(".----.", "'");
        codes.put("-....-", "-");
        codes.put("-..-.", "/");
        codes.put(".--.-.", "@");
        codes.put("-...-", "=");
        codes.put("-.-.--", "!");
        codes.put("-.--.", "(");
        codes.put("-.--.-", ")");
    }

    public String decodedMorse(String morse) {
        StringBuilder secretMessage = new StringBuilder();
        String[] words = morse.split("   ");

        for (String word : words) {
            String[] letters = word.split(" ");

            for (String letter : letters) {
                System.out.println("xxxx" + letter + "xxxxxx");

                secretMessage.append(codes.get(letter));

            }
            secretMessage.append(" ");
        }

        return secretMessage.toString();
    }
}
