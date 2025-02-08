package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "Estudiante debe tener nombre")
    String studentName;
    @NotNull(message = "Debe existir un mensaje")
    String message;
    @PositiveOrZero(message = "El promedio debe ser mayor a 0")
    Double averageScore;
    @Size (min = 1, max = 3, message = "Solo puede anotarse entre 1 y 3 materias")
    List<@Valid SubjectDTO> subjects;
}
