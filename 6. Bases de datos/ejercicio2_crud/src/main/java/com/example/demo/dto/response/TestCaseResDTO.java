package com.example.demo.dto.response;

import java.time.LocalDate;

public record TestCaseResDTO(String description, Boolean tested, Boolean passed,
                             String status, int numberOfTries, LocalDate lastUpdate) {
}
