package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class SubjectDTO {

    @NotBlank(message = "No puede estar vacío")
    @Size(max = 50, message = "No puede contener más de 50 caracteres")
    String name;

    @DecimalMin(value = "0.0", message = "No puede ser menor a 0.0")
    @DecimalMax(value = "10.0", message = "No puede ser mayor a 10.0")
    Double score;

}
