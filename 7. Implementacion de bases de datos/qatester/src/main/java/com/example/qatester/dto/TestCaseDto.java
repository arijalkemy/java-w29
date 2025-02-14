package com.example.qatester.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDto {
    @Size(max = 255, message = "La descripción no puede exceder los 255 caracteres")
    private String description;

    private Boolean tested;

    private Boolean passed;

    @Min(value = 0, message = "El número de intentos no puede ser negativo")
    @Positive
    private int numberOfTries;

    @NotNull(message = "La fecha de última actualización no puede ser nula")
    private LocalDate lastUpdate;
}
