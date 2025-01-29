package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "Subject name is required")
    String name;
    @Size(min = 0, max = 10, message = "The score must be between 0 and 10")
    Double score;
}
