package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Getter @Setter
public class SubjectDTO {

    @NotEmpty(message = "Name shoudn't be empty")
    String name;

    @Range(min = 0, max = 10, message = "Score should be from 0 to 10.")
    Double score;
}
