package com.mercadolibre.javawave29.covid_19.model;

import lombok.Getter;

@Getter
public class SymptomDTO {
    private final Integer severityLevel;

    public SymptomDTO(Integer severityLevel) {
        this.severityLevel = severityLevel;
    }
}
