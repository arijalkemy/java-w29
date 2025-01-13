package com.example.edades.controller;

import com.example.edades.utils.AgeConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeRestController {
    @GetMapping("/{day}/{month}/{year}")
    public String getAge(
            @PathVariable int day,
            @PathVariable int month,
            @PathVariable int year)
    {
        return AgeConverter.calculateAge(day, month, year) + " años";
    }

}
