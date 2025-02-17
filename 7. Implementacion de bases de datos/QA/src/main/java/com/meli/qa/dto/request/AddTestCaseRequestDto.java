package com.meli.qa.dto.request;

import lombok.Getter;

@Getter
public class AddTestCaseRequestDto {

    String description;

    Boolean passed;

    Boolean tested;

    int numberOfTries;
}
