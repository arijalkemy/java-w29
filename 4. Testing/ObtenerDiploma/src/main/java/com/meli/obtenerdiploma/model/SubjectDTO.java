package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "Name cannot be null")
    String name;

    @DecimalMin(value = "0.0", message = "Avg score should be between 0.0 and 10.0")
    @DecimalMax(value = "10.0", message = "Avg score should be between 0.0 and 10.0")
    Double score;
}
