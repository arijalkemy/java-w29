package com.meli.obtenerdiploma.model;

import com.meli.obtenerdiploma.constants.Messages;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = Messages.STUDENT_NAME_ERROR)
    private String studentName;
    @NotBlank (message = Messages.MESSAGE_ERROR)
    private String message;
    @PositiveOrZero (message = Messages.AVERAGE_ERROR)
    private Double averageScore;
    @Valid
    @NotEmpty (message = Messages.SUBJECTS_ERROR)
    private List<SubjectDTO> subjects;
}
