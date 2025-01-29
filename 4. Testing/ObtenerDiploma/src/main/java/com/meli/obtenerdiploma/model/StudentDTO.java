package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotEmpty(message = "Name shoudn't be empty")
    String studentName;

    String message;

    @Range(min = 0, max = 10, message = "Score should be from 0 to 10.")
    Double averageScore;

    @NotEmpty
    List<SubjectDTO> subjects;
}
