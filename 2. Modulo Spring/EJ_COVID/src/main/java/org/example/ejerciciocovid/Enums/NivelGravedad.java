package org.example.ejerciciocovid.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NivelGravedad
{
    BAJO("Bajo"),
    MEDIO("Medio"),
    ALTO("Alto");

    private final String string;
}
