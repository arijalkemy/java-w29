package com.mercadolibre.javawave29.edadpersona.service;

import com.mercadolibre.javawave29.edadpersona.model.LifeTime;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgeService {
    private List<LifeTime> lifeTimes = new ArrayList<>();

    public String getAge(int day, int month, int year) {
        if ((day < 1 || day > 31)|| (month < 1 || month > 12) || LocalDate.of(year, month, day).isAfter(LocalDate.now())) {
            return "Los datos ingresados son incorrectos";
        }
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        LocalDate date = LocalDate.now();

        Period period = Period.between(dateOfBirth, date);
        int edad = period.getYears();
        return "La persona tiene " + edad + " años";
    }

    public LifeTime saveAge(String date) {
        String[] split = date.split("/");
        int day = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int year = Integer.parseInt(split[2]);

        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        LifeTime lifeTime = new LifeTime(period.getYears(), period.getMonths(), period.getDays());
        lifeTimes.add(lifeTime);
        return lifeTime;
    }

    public LifeTime getAgeById(Integer id) {
        return lifeTimes.get(id);
    }
}
