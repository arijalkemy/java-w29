package com.excercise.morse_code.repository;

import com.excercise.morse_code.database.MorseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MorseRepository {
    private final MorseDatabase morseDataBase;

    @Autowired
    public MorseRepository(MorseDatabase morseDatabase){
        this.morseDataBase = morseDatabase;
    }
    public String getCharacter(String morseCode) {
        return morseDataBase.getMorseToChar().getOrDefault(morseCode, "");
    }
}
