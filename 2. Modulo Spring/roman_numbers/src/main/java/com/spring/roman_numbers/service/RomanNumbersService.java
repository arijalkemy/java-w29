package com.spring.roman_numbers.service;

import com.spring.roman_numbers.repository.RomanNumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class RomanNumbersService {
    @Autowired
    private RomanNumbersRepository romanNumbersRepository;


    // Tomo array de numeros decimales, de mayor a menor.
    // Mientras el numero original no sea 0:
    // Si el actual es mayor a lo que me queda, sigo iterando
    // Si el actual es menor:
    // Si lo puedo repetir menos de 3 veces, lo inserto la max posible de repeticiones sin pasarme y bajo el numero para seguir iterando con mas chicos.
    // Si no lo puedo repetir menos de 3 veces, pongo primero a el y luego al de arriba, y le resto al original eso. Luego repito la iteracion con el mismo numero.

    public String mapToRomanNumber(Integer number) {
        System.out.println("Numero a transformar " + number);
        String romanNumber = "";
        List<Integer> decimalNumbers = romanNumbersRepository.getDecimalNumbers();
        List<Integer> reversedDecimals = decimalNumbers.stream()
                .sorted(Collections.reverseOrder())
                .toList();

        for (Integer decimal : reversedDecimals) {
            while (number >= decimal) {
                romanNumber += romanNumbersRepository.getRomanCharacter(decimal);
                number -= decimal;
            }
        }

        return romanNumber;
    }
}
