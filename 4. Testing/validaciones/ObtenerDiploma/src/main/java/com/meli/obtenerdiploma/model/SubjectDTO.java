package com.meli.obtenerdiploma.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {

    @NotBlank(message = "{validation.not_blank}")
    String name;

    @NotNull(message = "{validation.not_null}")
    @PositiveOrZero(message = "{validation.positive_or_zero}")
    Double score;
}
