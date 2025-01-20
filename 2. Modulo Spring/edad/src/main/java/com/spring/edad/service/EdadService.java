package com.spring.edad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService {

    public Integer calcularEdad(Integer day, Integer month, Integer year) {

        try{
            LocalDate currentDate = LocalDate.now();
            LocalDate localDate = LocalDate.of(year, month, day);

            Period period = Period.between(localDate, currentDate);
            return period.getYears();
        }catch(Exception e){
            return null;
        }


    }
}
