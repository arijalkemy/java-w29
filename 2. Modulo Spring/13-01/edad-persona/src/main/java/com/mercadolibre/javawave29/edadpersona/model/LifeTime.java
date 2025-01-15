package com.mercadolibre.javawave29.edadpersona.model;

public class LifeTime {
    private static Integer lastId = 0;

    private Integer id;
    private Integer year;
    private Integer month;
    private Integer day;

    public LifeTime(Integer year, Integer month, Integer day) {
        id = lastId++;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "LifeTime{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
