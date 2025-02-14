package com.meli.qa.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AddTestCaseRequestDto {

    String description;

    Boolean passed;

    Boolean tested;

    int numberOfTries;

    LocalDate lastUpdated;
}
