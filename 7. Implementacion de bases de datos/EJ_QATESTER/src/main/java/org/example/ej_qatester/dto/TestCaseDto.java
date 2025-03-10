package org.example.ej_qatester.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDto {
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;
    @JsonProperty("last_update")
    private LocalDate lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getTested() {
        return tested;
    }

    public void setTested(Boolean tested) {
        this.tested = tested;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public Integer getNumberOfTries() {
        return numberOfTries;
    }

    public void setNumberOfTries(Integer numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "TestCaseDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", tested=" + tested +
                ", passed=" + passed +
                ", numberOfTries=" + numberOfTries +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
