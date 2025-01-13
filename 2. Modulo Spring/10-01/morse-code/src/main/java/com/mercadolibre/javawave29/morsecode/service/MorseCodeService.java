package com.mercadolibre.javawave29.morsecode.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseCodeService {

    private final Map<String, String> morseMap = new HashMap<>() {{
        put(".-", "A");
        put("-...", "B");
        put("-.-.", "C");
        put("-..", "D");
        put(".", "E");
        put("..-.", "F");
        put("--.", "G");
        put("....", "H");
        put("..", "I");
        put(".---", "J");
        put("-.-", "K");
        put(".-..", "L");
        put("--", "M");
        put("-.", "N");
        put("---", "O");
        put(".--.", "P");
        put("--.-", "Q");
        put(".-.", "R");
        put("...", "S");
        put("-", "T");
        put("..-", "U");
        put("...-", "V");
        put(".--", "W");
        put("-..-", "X");
        put("-.--", "Y");
        put("--..", "Z");
        put(".----", "1");
        put("..---", "2");
        put("...--", "3");
        put("....-", "4");
        put(".....", "5");
        put("-....", "6");
        put("--...", "7");
        put("---..", "8");
        put("----.", "9");
        put("-----", "0");
        put("..--..", "?");
        put("-.-.--", "!");
        put(".-.-.-", ".");
        put("--..--", ",");
    }};

    public String fromMorse(String phrase) {
        String[] words = phrase.split("( {3}|%20{3})");
        StringBuilder sb = new StringBuilder("El código morse: " + phrase + "es ");
        for (String word : words) {
            String[] letters = word.split("( |%20)");
            for (String letter : letters) {
                sb.append(morseMap.get(letter));
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public String toMorse(String phrase) {
        String[] words = phrase.split(" ");
        StringBuilder sb = new StringBuilder("La palabra: " + phrase + " en código morse es:  ");
        for (String word : words) {
            String[] letters = word.split("");
            for (String letter : letters) {
                sb.append(getKeyByValue(letter));
                sb.append(" ");
            }
            sb.append("   ");
        }
        return sb.toString();
    }

    private String getKeyByValue(String letter) {
        for (Map.Entry<String, String> entry : morseMap.entrySet()) {
            if (entry.getValue().equals(letter)) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("Caracter no encontrado");
    }
}
