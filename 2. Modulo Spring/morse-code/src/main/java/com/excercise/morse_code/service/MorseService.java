package com.excercise.morse_code.service;


import com.excercise.morse_code.repository.MorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MorseService {

    private final MorseRepository morseRepository;

    @Autowired
    public MorseService(MorseRepository morseRepository){
        this.morseRepository = morseRepository;
    }
    public String translate(String morseCode) {
        StringBuilder result = new StringBuilder();
        String[] words = morseCode.trim().split("   ");

        for (String word : words) {
            String[] characters = word.split(" ");
            for (String character : characters) {
                result.append(morseRepository.getCharacter(character));
            }
            result.append(" ");
        }

        return result.toString();
    }
}
