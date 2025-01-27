package com.bootcamp.covid.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NivelDeGravedad {
    BAJO("Bajo"),
    MEDIO("Medio"),
    ALTO("Alto");

    private final String string;
}
