package com.example.deportes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Person {
    private String name;
    private String lastName;
    private int age;
    private Sport sport;
}
