package com.thiagoschreck.local.qa_testers.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record UpdateTestCaseRequestDTO(
        Long caseId,
        String description,
        Boolean tested,
        Boolean passed,
        Integer numberOfTries,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate lastUpdate
) {
}
