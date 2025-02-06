package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "Nombre no puede ser nulo")
    String name;
    @NotNull(message = "Puntaje no puede ser nulo")
    @Positive(message = "Puntaje no puede ser negativo")
    Double score;
}
