package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "Student name cannot be null")
    @NotEmpty(message = "Message cannot be empty")
    @Size(min = 1, max = 40, message = "Student name must be between 1 and 40 characters")
    String studentName;

    @NotNull(message = "Message cannot be null")
    @NotEmpty(message = "Message cannot be empty")
    @Size(min = 1, max = 70, message = "Message name must be between 1 and 70 characters")
    String message;

    @Min(value = 1, message = "Average score must be greater than or equal to 1")
    Double averageScore;

    @Valid
    @NotEmpty(message = "Subjects cannot be null or empty")
    List<SubjectDTO> subjects;
}
