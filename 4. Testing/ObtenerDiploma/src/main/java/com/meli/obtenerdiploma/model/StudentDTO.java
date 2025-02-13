package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "Name cannot be null")
    String studentName;

    String message;

    @DecimalMin(value = "0.0", message = "Avg score should be between 0.0 and 10.0")
    @DecimalMax(value = "10.0", message = "Avg score should be between 0.0 and 10.0")
    Double averageScore;

    @Valid
    @Size(min = 1, message = "Student has to be enrolled in one subject at least")
    List<SubjectDTO> subjects;
}
