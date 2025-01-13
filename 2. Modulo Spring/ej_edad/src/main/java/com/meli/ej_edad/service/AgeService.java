package com.meli.ej_edad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeService {

    public Integer calculateAge(Integer day, Integer month, Integer year) {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        return Period.between(birthDate, today).getYears();
    }
}
