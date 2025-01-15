package com.mercadolibre.javawave29.covid_19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symptom {
    private static Long nextCode = 0L;

    private Long code;
    private String name;
    private Integer severityLevel;

    public Symptom(String name, Integer severityLevel) {
        this.code = nextCode++;
        this.name = name;
        this.severityLevel = severityLevel;
    }
}
