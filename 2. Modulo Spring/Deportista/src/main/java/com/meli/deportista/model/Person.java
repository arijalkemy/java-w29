package com.meli.deportista.model;

import lombok.Data;

@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Sport sport;
}
