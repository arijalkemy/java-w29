package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "Materia debe tener nombre")
    String name;
    @PositiveOrZero(message = "El puntaje debe ser mayor a 0")
    Double score;
}
