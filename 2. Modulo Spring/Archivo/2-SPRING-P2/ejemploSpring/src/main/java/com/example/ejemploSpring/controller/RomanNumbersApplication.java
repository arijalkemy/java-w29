package com.example.ejemploSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roman")
public class RomanNumbersApplication {

        @GetMapping("/convert/{number}")
        public String convertToRoman(@PathVariable int number) {
            if (number <= 0 || number > 3999) {
                return "El número debe estar entre 1 y 3999.";
            }
            return decimalToRoman(number);
        }

        private String decimalToRoman(int number) {
            StringBuilder roman = new StringBuilder();
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            for (int i = 0; i < values.length; i++) {
                while (number >= values[i]) {
                    roman.append(symbols[i]);
                    number -= values[i];
                }
            }
            return roman.toString();
        }
}
