package com.bootcamp.excercise.service;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService {
    private LocalDate actual;
    private LocalDate calcular;
    public Integer edadACalcular(Integer dia, Integer mes, Integer año) {
        actual = LocalDate.now();
        calcular = LocalDate.of(año,mes,dia);
        Period period = Period.between(calcular,actual);
        return period.getYears();
    }
}
