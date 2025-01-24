package com.melibootcamp.DtoDeportes.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter @Getter
public class Person {
    private String name;
    private String lastName;
    private int age;
    private List<Sport> sports;

    public void addSport(Sport sport){
        sports.add(sport);
    }
    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        sports=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }
}
