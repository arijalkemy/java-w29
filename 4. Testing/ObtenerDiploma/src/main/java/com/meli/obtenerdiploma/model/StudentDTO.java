package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @Max(value = 2, message = "La cantidad maxima de caracteres para el nombre es de 2")
    String studentName;
    String message;
    Double averageScore;
    @Size(max = 1, message = "La cantidad maxima de subject es de 1")
    List<SubjectDTO> subjects;
}
