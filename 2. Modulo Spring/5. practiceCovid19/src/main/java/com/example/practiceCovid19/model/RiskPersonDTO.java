package com.example.practiceCovid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiskPersonDTO {
    private String name;
    private String lastname;
    private List<Symptom> symptoms;
}
