package com.meli.obtenerdiploma.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDto {

    private List<ErrorDetailDto> message;

    private LocalDateTime timestamp;

}
