package com.bootcamp.edad.model;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate bornDate;
    public Person(String name, int day, int month, int year){
        this.name = name;
        this.bornDate = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }
}
