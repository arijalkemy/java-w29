package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "Student name is required")
    String studentName;
    @Size(min = 2, max = 50, message = "The student name must be between 8 and 50 characters")
    String message;
    @NotNull(message = "Average score is required")
    Double averageScore;
    @NotEmpty(message = "Subjects are required")
    List<SubjectDTO> subjects;
}
