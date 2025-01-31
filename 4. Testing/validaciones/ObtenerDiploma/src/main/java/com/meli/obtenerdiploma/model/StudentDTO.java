package com.meli.obtenerdiploma.model;

import lombok.Data;
import lombok.Getter;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class StudentDTO {

  @NotBlank(message = "{validation.not_blank}")
  String studentName;

  @Max(value = 50, message = "{validation.string.max}")
  String message;

  Double averageScore;

  @NotEmpty(message = "{validation.not_empty}")
  @Valid
  List<SubjectDTO> subjects;
}
