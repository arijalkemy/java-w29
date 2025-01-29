package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    String studentName;

    String message;
    Double averageScore;

    @Valid
    List<SubjectDTO> subjects;
}
