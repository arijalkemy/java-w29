package com.mercadolibre.bootcamp.qatesters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.bootcamp.qatesters.model.TestCase;

import java.time.LocalDate;

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

    public String getDescription() {
        return description;
    }

    public Boolean getTested() {
        return tested;
    }

    public Boolean getPassed() {
        return passed;
    }

    public Integer getNumberOfTries() {
        return numberOfTries;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public static TestCaseDto from(TestCase tc) {
        return new TestCaseDto(
                tc.getDescription(),
                tc.getTested(),
                tc.getPassed(),
                tc.getNumberOfTries(),
                tc.getLastUpdate()
        );
    }

    public static TestCase to(TestCaseDto tc) {
        return new TestCase(
                tc.getDescription(),
                tc.getTested(),
                tc.getPassed(),
                tc.getNumberOfTries(),
                tc.getLastUpdate()
        );
    }

}
