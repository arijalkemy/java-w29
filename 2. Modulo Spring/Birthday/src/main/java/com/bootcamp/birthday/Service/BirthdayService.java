package com.bootcamp.birthday.Service;

import com.bootcamp.birthday.Models.BirthdayQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class BirthdayService {

    Map<String, Integer> queries = new HashMap<>();

    public int getAge(int day, int month, int year) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthday, currentDate);

        return period.getYears();
    }

    public String generateBirthday(BirthdayQuery query) {
        String uuid = UUID.randomUUID().toString();
        queries.put(uuid, getAge(query.day(), query.month(), query.year()));
        return uuid;
    }

    public int getAgeWithCode(String code) {
        if (queries.containsKey(code)) {
            return queries.get(code);
        }

        return -1;
    }
}
