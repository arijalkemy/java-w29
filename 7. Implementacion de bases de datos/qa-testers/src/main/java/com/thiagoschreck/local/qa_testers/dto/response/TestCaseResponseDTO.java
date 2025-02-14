package com.thiagoschreck.local.qa_testers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TestCaseResponseDTO {
    private Long caseId;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
