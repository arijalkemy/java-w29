package com.example.codigomorse.service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class MorseService {

    private Map<String, Character> morseMap = new HashMap<>();

    public void instanceMorseMap(){
        morseMap.put(".-", 'A');
        morseMap.put("-...", 'B');
        morseMap.put("-.-.", 'C');
        morseMap.put("-..", 'D');
        morseMap.put(".", 'E');
        morseMap.put("..-.", 'F');
        morseMap.put("--.", 'G');
        morseMap.put("....", 'H');
        morseMap.put("..", 'I');
        morseMap.put(".---", 'J');
        morseMap.put("-.-", 'K');
        morseMap.put(".-..", 'L');
        morseMap.put("--", 'M');
        morseMap.put("-.", 'N');
        morseMap.put("---", 'O');
        morseMap.put(".--.", 'P');
        morseMap.put("--.-", 'Q');
        morseMap.put(".-.", 'R');
        morseMap.put("...", 'S');
        morseMap.put("-", 'T');
        morseMap.put("..-", 'U');
        morseMap.put("...-", 'V');
        morseMap.put(".--", 'W');
        morseMap.put("-..-", 'X');
        morseMap.put("-.--", 'Y');
        morseMap.put("--..", 'Z');
        morseMap.put(".----", '1');
        morseMap.put("..---", '2');
        morseMap.put("...--", '3');
        morseMap.put("....-", '4');
        morseMap.put(".....", '5');
        morseMap.put("-....", '6');
        morseMap.put("--...", '7');
        morseMap.put("---..", '8');
        morseMap.put("----.", '9');
        morseMap.put("-----", '0');
        morseMap.put("..--..", '?');
        morseMap.put("--..--", ',');
        morseMap.put("-.-.--", '!');
    }

    public String generateWord(String morse){
        StringBuilder wordGenerated = new StringBuilder();
        instanceMorseMap();
        ArrayList<String> morseWords = new ArrayList<>(Arrays.asList(morse.split("   ")));
        for (String word : morseWords) {
            wordGenerated.append(" "+convertWord(word));
        }
        return wordGenerated.toString();
    }

    public String convertWord(String word){
        StringBuilder wordConvert = new StringBuilder();
        List<String> morseWords = Arrays.asList(word.split(" "));
        for (String morseWord : morseWords) {
            wordConvert.append(morseMap.get(morseWord));
        }
        return wordConvert.toString();
    }
}
