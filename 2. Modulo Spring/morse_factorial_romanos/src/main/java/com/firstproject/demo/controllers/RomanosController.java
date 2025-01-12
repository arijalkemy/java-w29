package com.firstproject.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RomanosController {

    @GetMapping("/romanos/{a}")
    public Integer Romano(@PathVariable String a) {
        Map<Character, Integer> romanos = new HashMap<>();
        romanos.put('I',1);
        romanos.put('V',5);
        romanos.put('X',10);
        romanos.put('L',50);
        romanos.put('C',100);
        romanos.put('D',500);
        romanos.put('M',1000);

        Integer valorAnterior = 0, total=0;

        for (int i = 0; i < a.length(); i++) {
            Integer valorActual = romanos.get(a.charAt(i));
            if (valorActual > valorAnterior) {
                total+=valorActual;
            }else{
                total-=valorActual;
            }
            valorAnterior = valorActual;

        }

        return total;
    }
}
