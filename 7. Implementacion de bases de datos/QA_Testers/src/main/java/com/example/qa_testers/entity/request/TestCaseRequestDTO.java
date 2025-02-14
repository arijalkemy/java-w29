package com.example.qa_testers.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseRequestDTO {
    String description;
    Boolean tested;
    Boolean passed;
    @JsonProperty("number_of_tries")
    Integer numberOfTries;
    @JsonProperty("last_update")
    LocalDate lastUpdate;
}
