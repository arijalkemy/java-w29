package com.bootcamp.dto_p1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private LocalDate birthDate;
}
