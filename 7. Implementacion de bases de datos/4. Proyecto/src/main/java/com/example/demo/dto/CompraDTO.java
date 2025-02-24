package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompraDTO {
    private Integer idPersona;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;
    private Double valor;
}
