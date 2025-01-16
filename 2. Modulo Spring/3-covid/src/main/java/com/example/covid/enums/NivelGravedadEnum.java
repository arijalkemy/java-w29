package com.example.covid.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NivelGravedadEnum {
    BAJO("Bajo"),
    MEDIO("Medio"),
    ALTO("Alto");

    private final String string;

}
