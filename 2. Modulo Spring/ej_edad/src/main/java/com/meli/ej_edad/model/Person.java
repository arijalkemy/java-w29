package com.meli.ej_edad.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private LocalDate birthDate;
}
