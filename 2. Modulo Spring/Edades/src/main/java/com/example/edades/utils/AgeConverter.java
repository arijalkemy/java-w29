package com.example.edades.utils;

import java.util.Date;

public class AgeConverter {
    public static int calculateAge(int day, int month, int year) {
        Date now = new Date();
        int currentYear = now.getYear() + 1900;
        int currentMonth = now.getMonth() + 1;
        int currentDay = now.getDate();
        int age = currentYear - year;
        if (month > currentMonth || (month == currentMonth && day > currentDay)) {
            age--;
        }
        return age;
    }
}
