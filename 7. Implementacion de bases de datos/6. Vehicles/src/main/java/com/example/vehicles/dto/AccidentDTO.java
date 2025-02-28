package com.example.vehicles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccidentDTO {
    private Long id;
    private LocalDate accidentDate;
    private Double economicLoss;
}
