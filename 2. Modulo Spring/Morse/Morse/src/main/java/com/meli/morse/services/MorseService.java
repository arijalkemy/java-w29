package com.meli.morse.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class MorseService {
    static Map <String, String> morseMap = new HashMap<>();
    static {
        morseMap.put(".-", "A");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        //
        morseMap.put("..-.", "F");
        //
        morseMap.put("--.", "G");
        //
        morseMap.put("....", "H");
        //
        morseMap.put("..", "I");
        //
        morseMap.put(".---", "J");
        //
        morseMap.put("-.-", "K");
        //
        morseMap.put(".-..", "L");
        //
        morseMap.put("--", "M");
        //
        morseMap.put("-.", "N");
        //
        morseMap.put("---", "O");
        //
        morseMap.put(".--.", "P");
        //
        morseMap.put("--.-", "Q");
        //
        morseMap.put(".-.", "R");
        //
        morseMap.put("...", "S");
        //
        morseMap.put("-", "T");
        //
        morseMap.put("..-", "U");
        //
        morseMap.put("...-", "V");
        //
        morseMap.put(".--", "W");
        //
        morseMap.put("-..-", "X");
        //
        morseMap.put("-.--", "Y");
        //
        morseMap.put("--..", "Z");


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

        morseMap.put(".-.-.-", ".");

        morseMap.put("--..--", ",");

        morseMap.put("..--..", "?");

        morseMap.put(".----.", "'");

        morseMap.put("-.-.--", "!");

        morseMap.put("-..-.", "/");

        morseMap.put("-.--.", "(");

        morseMap.put("-.--.-", ")");

        morseMap.put(".-...", "&");

        morseMap.put("---...", ":");

        morseMap.put("-.-.-.", ";");

        morseMap.put("-...-", "=");

        morseMap.put(".-.-.", "+");

        morseMap.put("-....-", "-");

        morseMap.put("..--.-", "_");

        morseMap.put(".-..-.", "\"");

        morseMap.put("...-..-", "$");

        morseMap.put(".--.-.", "@");

        morseMap.put("   ", " ");
    }




public String generateMorse(String text) {
            String morseWord = "";
            String[] words = text.split("   ");
            System.out.println(words.length);
            for (String word : words) {
                System.out.println(word);
                for (String letter : word.split(" ")) {
                    morseWord += morseMap.get(letter);
                }
                morseWord += " ";
            }
       return morseWord;
    }
}
