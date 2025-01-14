package com.obtener.edad.service;

import com.obtener.edad.models.BirthdayDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PersonaService {

    Map<String, Integer> register = new HashMap<>();

    public Integer calculateAge(Integer year, Integer month, Integer day) {
        LocalDate clientDate = LocalDate.of(year, month, day);
        return Period.between(clientDate, LocalDate.now()).getYears();
    }

    public String addBirthday(BirthdayDTO birthday) {
        String id = UUID.randomUUID().toString();
        register.put(id, calculateAge(birthday.getYear(), birthday.getMonth(), birthday.getDay()));
        return id;
    }

    public Integer getAge(String id) {
        if (register.containsKey(id)) {
            return register.get(id);
        }
        return -1;
    }
}
