package com.example.introduccion_a_spring.service;


import com.example.introduccion_a_spring.controller.NumberController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberService {
    public String calculate(int number){
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder convert = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            while (number >= values[i] ){
                number -= values[i];
                convert.append(romanNumerals[i]);
            }
        }
        return convert.toString();
    }
}
