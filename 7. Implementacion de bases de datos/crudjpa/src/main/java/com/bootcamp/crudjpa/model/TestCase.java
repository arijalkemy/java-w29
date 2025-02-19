package com.bootcamp.crudjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCase;
    String description;
    Boolean tested;
    Boolean passed;
    int numberOfTries;
    LocalDate lastUpdate;
}
