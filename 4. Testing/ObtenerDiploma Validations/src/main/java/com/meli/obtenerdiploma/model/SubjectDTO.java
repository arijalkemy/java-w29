package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "Subject name cannot be null")
    String name;

    @Min(value = 1, message = "Score must be greater than or equal to 1")
    Double score;
}
