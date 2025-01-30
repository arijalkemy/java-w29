package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotBlank(message = "No puede estar vacío")
    @Size(max = 30, message = "No puede contener más de 30 caracteres")
    String name;

    @PositiveOrZero
    @Min(value = 0, message = "el valor minimo es 0.")
    @Max(value = 10, message = "El valor máximo puede ser 10.")
    Double score;
}
