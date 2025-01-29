package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ExceptionDTO {
    private List<String> errorMessages;
}
