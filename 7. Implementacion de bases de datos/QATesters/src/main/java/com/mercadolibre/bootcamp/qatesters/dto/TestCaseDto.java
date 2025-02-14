package com.mercadolibre.bootcamp.qatesters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
public class TestCaseDto {

    private String description;
    private Boolean tested;
    private Boolean passed;

    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @JsonProperty("last_update")
    private LocalDate lastUpdate;

    public TestCaseDto() {}

    public TestCaseDto(String description, Boolean tested, Boolean passed, Integer numberOfTries, LocalDate lastUpdate) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.numberOfTries = numberOfTries;
        this.lastUpdate = lastUpdate;
    }

}
