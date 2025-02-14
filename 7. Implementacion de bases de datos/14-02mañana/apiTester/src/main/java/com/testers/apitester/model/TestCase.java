package com.testers.apitester.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_case;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    private LocalDate last_update;

    public TestCase(Long id_case, String description, Boolean tested, Boolean passed, int number_of_tries, LocalDate last_update) {
        this.id_case = id_case;
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.number_of_tries = number_of_tries;
        this.last_update = last_update;
    }

    public TestCase(String description, Boolean tested, Boolean passed, int number_of_tries, LocalDate last_update) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.number_of_tries = number_of_tries;
        this.last_update = last_update;
    }

    public TestCase() {
    }

    public Long getId_case() {
        return id_case;
    }

    public void setId_case(Long id_case) {
        this.id_case = id_case;
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

    public int getNumber_of_tries() {
        return number_of_tries;
    }

    public void setNumber_of_tries(int number_of_tries) {
        this.number_of_tries = number_of_tries;
    }

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
    }
}
