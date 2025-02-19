package com.example.qa_tester.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseTestCaseDto {
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
