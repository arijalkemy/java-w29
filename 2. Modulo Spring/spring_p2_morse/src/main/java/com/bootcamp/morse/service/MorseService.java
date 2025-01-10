package com.bootcamp.morse.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {

    private final Map<Character, String> morseMap = new HashMap<>();

    public MorseService() {
        this.morseMap.put('A', ".-");
        this.morseMap.put('B', "-...");
        this.morseMap.put('C', "-.-.");
        this.morseMap.put('D', "-..");
        this.morseMap.put('E', ".");
        this.morseMap.put('F', "..-.");
        this.morseMap.put('G', "--.");
        this.morseMap.put('H', "....");
        this.morseMap.put('I', "..");
        this.morseMap.put('J', ".---");
        this.morseMap.put('K', "-.-");
        this.morseMap.put('L', ".-..");
        this.morseMap.put('M', "--");
        this.morseMap.put('N', "-.");
        this.morseMap.put('O', "---");
        this.morseMap.put('P', ".--.");
        this.morseMap.put('Q', "--.-");
        this.morseMap.put('R', ".-.");
        this.morseMap.put('S', "...");
        this.morseMap.put('T', "-");
        this.morseMap.put('U', "..-");
        this.morseMap.put('V', "...-");
        this.morseMap.put('W', ".--");
        this.morseMap.put('X', "-..-");
        this.morseMap.put('Y', "-.--");
        this.morseMap.put('Z', "--..");
        this.morseMap.put('1', ".----");
        this.morseMap.put('2', "..---");
        this.morseMap.put('3', "...--");
        this.morseMap.put('4', "....-");
        this.morseMap.put('5', ".....");
        this.morseMap.put('6', "-....");
        this.morseMap.put('7', "--...");
        this.morseMap.put('8', "---..");
        this.morseMap.put('9', "----.");
        this.morseMap.put('0', "----");
        this.morseMap.put('?', "..--..");
        this.morseMap.put('!', "-.-.--");
        this.morseMap.put('.', ".-.-.-");
        this.morseMap.put(',', "--..--");
    }

    public String generateMorse(String query) {
        System.out.println(morseMap);
        return "";
    }
}
