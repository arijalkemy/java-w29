package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "Nombre de estudiante no puede ser nulo")
    String studentName;
    @NotBlank(message = "Mensaje no puede ser nulo")
    @Length(max = 10, message = "Mensaje no puede ser mayor a 10 caracteres")
    String message;
    @PositiveOrZero(message = "Puntaje promedio no puede ser negativo")
    Double averageScore;
    @NotEmpty(message = "Lista de asignaturas no puede estar vacio")
    List<@Valid SubjectDTO> subjects;
}
