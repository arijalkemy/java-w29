package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    @NotEmpty(message = "El nombre no puede estar vacío")
    String name;
    @Min(value = 0, message = "El promedio no puede ser menor a 0")
    @Max(value = 100, message = "El promedio no puede ser mayor a 100")
    Double score;
}
