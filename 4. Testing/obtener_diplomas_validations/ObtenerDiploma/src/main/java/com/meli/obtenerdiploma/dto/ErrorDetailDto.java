package com.meli.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetailDto {

    private String field;

    private String errorMessage;

}