package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;

import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotNull
    String studentName;

    @Size(min = 1, max = 50)
    String message;

    @Min(value = 1)
    Double averageScore;

    List<@NotBlank SubjectDTO> subjects;
}
