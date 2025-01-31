package com.meli.obtenerdiploma.model;

import com.meli.obtenerdiploma.constants.Messages;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotBlank (message = Messages.SUBJECT_NAME_ERROR)
    private String name;

    @NonNull
    @PositiveOrZero (message = Messages.SCORE_ERROR)
    private Double score;
}
