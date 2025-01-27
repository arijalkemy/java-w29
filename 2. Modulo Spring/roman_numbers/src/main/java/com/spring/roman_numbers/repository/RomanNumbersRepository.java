package com.spring.roman_numbers.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RomanNumbersRepository {
    private final Map<Integer, String> numberToRoman;

    public RomanNumbersRepository() {
        numberToRoman = new HashMap<>();
        populateMap();
    }

    private void populateMap() {
        numberToRoman.put(1, "I");
        numberToRoman.put(4, "IV");
        numberToRoman.put(5, "V");
        numberToRoman.put(9, "IX");
        numberToRoman.put(10, "X");
        numberToRoman.put(50, "L");
        numberToRoman.put(100, "C");
        numberToRoman.put(500, "D");
        numberToRoman.put(1000, "M");
    }

    public List<Integer> getDecimalNumbers() {
        return numberToRoman.keySet().stream().toList();
    }

    public String getRomanCharacter(Integer number) {
        return numberToRoman.get(number);
    }
}
