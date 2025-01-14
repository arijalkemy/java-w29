package com.example.practiceCovid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {
    private Long code;
    private String name;
    private int severity;
}
