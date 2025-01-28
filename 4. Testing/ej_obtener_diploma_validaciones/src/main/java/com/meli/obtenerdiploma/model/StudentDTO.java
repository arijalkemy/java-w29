package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "No puede estar vacío")
    @Size(max = 50, message = "No puede superar los 50 caracteres")
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]*([ ]([A-ZÁÉÍÓÚÑ][a-záéíóúñ]*))*$",
            message = "Debe comenzar con una letra mayúscula y solo debe contener letras " +
                    "(incluyendo acentos y ñ). No se permiten números ni caracteres especiales.")
    String studentName;

    String message;

    Double averageScore;

    @Valid
    @NotEmpty(message = "La lista no puede estar vacía")
    List<SubjectDTO> subjects;

}
