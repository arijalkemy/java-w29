package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre no puede estar vacio")
    String name;

    @PositiveOrZero
    @NotNull
    Double score;
}
